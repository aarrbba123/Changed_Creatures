package net.hhdsj.goodblock.item;

import net.hhdsj.goodblock.util.ProgressTransfurExt;
import net.ltxprogrammer.changed.entity.TransfurCause;
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
        list.add(Component.translatable("item.goodblock.impure_frost_condensed_crystal_cluster.desc").withStyle(ChatFormatting.BLUE));
    }

    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        // 先调用父类完成食用逻辑（恢复饥饿值）
        ItemStack result = super.finishUsingItem(stack, level, entity);

        if (!level.isClientSide) {
            if (entity instanceof Player player) {
                variant = ProcessTransfur.getPlayerTransfurVariant(player);
            }
            if (variant != null) {
                entity.addEffect(new MobEffectInstance(MobEffects.POISON, 800, 0));
            }else{
                ProgressTransfurExt.tf(entity,0.8f,"goodblock:form_latex_frost_scale_dragon_taur", TransfurCause.FACE_HAZARD);
            }
            entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 500, 0));
        }
        return result;
    }
}
