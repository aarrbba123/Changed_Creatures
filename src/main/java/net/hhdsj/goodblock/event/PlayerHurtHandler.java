package net.hhdsj.goodblock.event;

import net.hhdsj.goodblock.init.GoodblockModEntities;
import net.hhdsj.goodblock.init.GoodblockModTransfurVariants;
import net.hhdsj.goodblock.network.GoodblockModVariables;
import net.hhdsj.goodblock.util.PlayerDataGetHelper;
import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class PlayerHurtHandler {

    private static final List<String> FIRE_IMMUNE_VARIANTS = new ArrayList<>(List.of(
            "goodblock:form_latex_yunxq_hot_dragon",
            "goodblock:form_latex_iq_gold_dragon",
            "goodblock:form_latex_yao_ling_dragon",
            "goodblock:form_latex_ice_field_wolf_dragon",
            "goodblock:form_latex_night_owl_dragon"

    ));

    public static boolean shouldBeFireImmune(Player player) {
        TransfurVariantInstance<?> variant = ProcessTransfur.getPlayerTransfurVariant(player);
        if (variant == null) return false;  // 未变身 → 不防火

        String currentId = String.valueOf(variant.getFormId());
        return FIRE_IMMUNE_VARIANTS.contains(currentId);  // 在列表里 → 防火
    }

    @SubscribeEvent
    public static void onPlayerDamage(LivingDamageEvent event) {

        if (!(event.getEntity() instanceof Player player)) return;

        if (!shouldBeFireImmune(player)) return;  // 不防火 → 跳过

        if (event.getSource().is(DamageTypeTags.IS_FIRE)) {
            //event.setAmount(0.0F);
            //event.isCanceled();
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(LivingEvent.LivingTickEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (player.level().isClientSide()) return;
        if (!shouldBeFireImmune(player)) return;  // 不防火 → 跳过

        if (player.isOnFire()) {
            player.clearFire();
        }
    }
}