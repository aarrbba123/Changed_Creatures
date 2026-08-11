package net.hhdsj.changed_creatures.item;

import com.mojang.datafixers.util.Pair;
import net.hhdsj.changed_creatures.ChangedCreature;
import net.hhdsj.changed_creatures.init.ChangedCreatureModItems;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.TransfurContext;
import net.ltxprogrammer.changed.entity.latex.LatexType;
import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.ltxprogrammer.changed.init.ChangedRegistry;
import net.ltxprogrammer.changed.init.ChangedTransfurVariants;
import net.ltxprogrammer.changed.item.FilledMug;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = ChangedCreature.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LatexFilledAllMugItem extends FilledMug {

    private static final String NBT_FORM_VARIANT = "form_variant";
    private static final String NBT_OVERLAY_COLOR = "overlay_color";
    private static final String DEFAULT_VARIANT = "changed:white_wolf_male";
    private static final int DEFAULT_COLOR = 0xFFFFFFFF;

    public LatexFilledAllMugItem(Supplier<? extends LatexType> latexType, Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemstack, @Nullable Level world,
                                @NotNull List<Component> list, @NotNull TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);

        String variantId = getVariantIdFromStack(itemstack);
        if (variantId != null && !variantId.isEmpty()) {
            list.add(Component.literal("§7内容物: §b" + variantId));
            int color = getOverlayColorFromStack(itemstack);
            if (color != DEFAULT_COLOR) {
                list.add(Component.literal("§7颜色: §f#" + String.format("%08X", color)));
            }
        } else {
            list.add(Component.literal("§7无内容物"));
        }
    }

    @Override
    protected void onDrink(ItemStack stack, Level level, LivingEntity user) {
        String variantId = getVariantIdFromStack(stack);
        ResourceLocation variantLocation = ResourceLocation.tryParse(variantId);
        if (variantLocation == null) {
            variantLocation = ChangedTransfurVariants.WHITE_WOLF_MALE.getId();
        }

        var variant = ChangedRegistry.TRANSFUR_VARIANT.get().getValue(variantLocation);
        if (variant != null) {
            ProcessTransfur.progressTransfur(user, 10f, variant,
                    TransfurContext.hazard(TransfurCause.FACE_HAZARD));
        }
    }

    @Override
    public @NotNull ItemStack getDefaultInstance() {
        ItemStack stack = super.getDefaultInstance();
        CompoundTag tag = stack.getOrCreateTag();
        if (!tag.contains(NBT_FORM_VARIANT)) {
            tag.putString(NBT_FORM_VARIANT, DEFAULT_VARIANT);
        }
        if (!tag.contains(NBT_OVERLAY_COLOR)) {
            tag.putInt(NBT_OVERLAY_COLOR, DEFAULT_COLOR);
        }
        return stack;
    }

    @Override
    public @NotNull InteractionResult interactLivingEntity(ItemStack stack, Player player,
                                                           LivingEntity interactionTarget,
                                                           net.minecraft.world.InteractionHand hand) {
        Level level = player.level();

        if (level.isClientSide) {
            return InteractionResult.PASS;
        }

        CompoundTag tag = stack.getTag();
        if (tag != null && tag.contains(NBT_FORM_VARIANT)) {
            return InteractionResult.PASS;
        }

        String targetVariantId = getVariantIdFromEntity(interactionTarget);

        if (targetVariantId != null && !targetVariantId.isEmpty()) {
            CompoundTag newTag = stack.getOrCreateTag();
            newTag.putString(NBT_FORM_VARIANT, targetVariantId);

            //获取并保存颜色
            Integer color = getVariantColor(targetVariantId);
            if (color != null) {
                newTag.putInt(NBT_OVERLAY_COLOR, color);
            }

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    private String getVariantIdFromEntity(LivingEntity entity) {
        if (entity instanceof Player targetPlayer) {
            TransfurVariantInstance<?> variantInstance = ProcessTransfur.getPlayerTransfurVariant(targetPlayer);
            if (variantInstance != null) {
                ResourceLocation formId = variantInstance.getFormId();
                if (formId != null) {
                    return formId.toString();
                }
            }
        }

        if (entity instanceof ChangedEntity changedEntity) {
            TransfurVariant<?> selfVariant = changedEntity.getSelfVariant();
            if (selfVariant != null) {
                ResourceLocation formId = selfVariant.getFormId();
                if (formId != null) {
                    return formId.toString();
                }
            }
        }

        try {
            java.util.Optional<TransfurVariant<?>> variantOpt = ProcessTransfur.getEntityVariant(entity);
            if (variantOpt.isPresent()) {
                TransfurVariant<?> variant = variantOpt.get();
                ResourceLocation key = ChangedRegistry.TRANSFUR_VARIANT.get().getKey(variant);
                if (key != null) {
                    return key.toString();
                }
            }
        } catch (Exception ignored) {

        }

        return null;
    }

    private String getVariantIdFromStack(ItemStack stack) {
        CompoundTag tag = stack.getTag();
        if (tag != null && tag.contains(NBT_FORM_VARIANT)) {
            String value = tag.getString(NBT_FORM_VARIANT);
            if (!value.isEmpty()) {
                return value;
            }
        }
        return DEFAULT_VARIANT;
    }

    public static int getOverlayColorFromStack(ItemStack stack) {
        CompoundTag tag = stack.getTag();
        if (tag != null && tag.contains(NBT_OVERLAY_COLOR)) {
            return tag.getInt(NBT_OVERLAY_COLOR);
        }
        return DEFAULT_COLOR;
    }

    public Integer getVariantColor(String variantId) {
        ResourceLocation variantLocation = ResourceLocation.tryParse(variantId);
        if (variantLocation == null) return null;

        TransfurVariant<?> variant = ChangedRegistry.TRANSFUR_VARIANT.get().getValue(variantLocation);
        if (variant == null) return null;

        Pair<Color3, Color3> colors = variant.getColors();
        if (colors != null && colors.getFirst() != null) {
            return colors.getFirst().toInt();
        }

        return null;
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.register((stack, tintIndex) -> {
            if (tintIndex == 1) {
                CompoundTag tag = stack.getTag();
                if (tag != null && tag.contains(NBT_FORM_VARIANT)) {
                    String variantId = tag.getString(NBT_FORM_VARIANT);
                    if (!variantId.isEmpty()) {
                        return getOverlayColorFromStack(stack);
                    }
                }
                return 0x00000000; //不渲染
            }
            return 0xFFFFFFFF;
        }, ChangedCreatureModItems.LATEX_FILLED_ALL_MUG_ITEM.get());
    }
}