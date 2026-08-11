package net.hhdsj.changed_creatures.procedures;

import net.foxyas.changedaddon.init.ChangedAddonItems;
import net.hhdsj.changed_creatures.util.ProgressTransfurExt;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.ltxprogrammer.changed.util.ItemUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;

public class RadiationProcedure {
    public static void execute(LevelAccessor world, LivingEntity entity) {
        if (entity == null)
            return;

        if (entity instanceof Player player) {
            TransfurVariantInstance<?> variant = ProcessTransfur.getPlayerTransfurVariant(player);
            if (variant != null) {
                applyRadiationDamage(world, entity);
                return;
            }

            boolean wearingSuit = ItemUtil.getWearingItems(player).anyMatch(slottedItem -> slottedItem.itemStack().is(ChangedAddonItems.HAZARD_BODY_SUIT.get()));if (wearingSuit) {
                return;
            }
        }

        if (entity.getHealth() >= 10) {
            applyRadiationDamage(world, entity);
        } else {
            if (entity instanceof Player player) {
                player.displayClientMessage(Component.translatable("effect.changed_creatures.radiation.tf").withStyle((style -> {
                    Style returnStyle = style.withColor(ChatFormatting.WHITE);
                    returnStyle = returnStyle.withItalic(true);
                    return returnStyle;
                })), true);
                ProgressTransfurExt.tf(player, 4f, "changed_creatures:form_latex_radiation_fox", TransfurCause.FACE_HAZARD);
                player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 220, 2, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 220, 2, false, false));
            }
        }
    }

    private static void applyRadiationDamage(LevelAccessor world, LivingEntity entity) {
        entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.WITHER)), 1);
    }
}