package net.hhdsj.changed_creatures.item;

import net.hhdsj.changed_creatures.init.ChangedCreatureModTransfurVariants;
import net.hhdsj.changed_creatures.util.ProgressTransfurExt;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.TransfurContext;
import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ImpureFrostCondensedCrystalClusterItem extends Item {
    TransfurVariantInstance<?> variant = null;
    public ImpureFrostCondensedCrystalClusterItem() {
        super(new Properties().stacksTo(64).rarity(Rarity.COMMON).food(new FoodProperties.Builder()
                .nutrition(2)
                .saturationMod(1f)
                .alwaysEat()
                .build()));
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("item.changed_creatures.impure_frost_condensed_crystal_cluster.desc").withStyle(ChatFormatting.BLUE));
    }

    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        ItemStack result = super.finishUsingItem(stack, level, entity);

        if (!level.isClientSide) {
            if (entity instanceof Player player) {
                variant = ProcessTransfur.getPlayerTransfurVariant(player);
            }
            if (variant != null) {
                entity.addEffect(new MobEffectInstance(MobEffects.POISON, 800, 0));
            }else{
                ProcessTransfur.progressTransfur(entity,0.8f, ChangedCreatureModTransfurVariants.LATEX_FROST_SCALE_DRAGON_TAUR.get());
            }
            entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 500, 0));
        }
        return result;
    }
}
