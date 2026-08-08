package net.hhdsj.goodblock.event;

import net.hhdsj.goodblock.GoodblockMod;
import net.hhdsj.goodblock.init.GoodblockModMobEffects;
import net.hhdsj.goodblock.init.GoodblockModTags;
import net.hhdsj.goodblock.init.GoodblockModTransfurVariants;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.TransfurContext;
import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.ltxprogrammer.changed.init.ChangedRegistry;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid = "goodblock")
public class PlayerDeathHandler {

    private static final Random RANDOM = new Random();

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (player.level().isClientSide) return;
        if (ProcessTransfur.getPlayerTransfurVariant(player) != null) return;
        if (!player.hasEffect(GoodblockModMobEffects.SLOWINFECTION.get())) return;

        handleSlowInfectionDeath(player, event);
    }

    private static void handleSlowInfectionDeath(Player player, LivingDeathEvent event) {
        TransfurVariant<?> selectedVariant = getRandomVariantFromTag();

        if (selectedVariant == null) {
            GoodblockMod.LOGGER.warn("No variants found in tag, using default");
            selectedVariant = GoodblockModTransfurVariants.LATEXDARKPURPLEDRAGON.get();
        }

        ProcessTransfur.setPlayerTransfurVariant(
                player,
                selectedVariant,
                TransfurContext.hazard(TransfurCause.GRAB_REPLICATE),
                1.0f
        );

        event.setCanceled(true);
        player.setHealth(1.0f);
        player.removeEffect(GoodblockModMobEffects.SLOWINFECTION.get());
    }

    private static TransfurVariant<?> getRandomVariantFromTag() {
        try {
            var registry = ChangedRegistry.TRANSFUR_VARIANT.get();
            if (registry == null) return null;

            // 直接获取所有注册的变体，然后筛选
            var allVariants = registry.getValues().stream()
                    .filter(variant -> variant.is(GoodblockModTags.slowInfectionVariants()))
                    .toList();

            if (allVariants.isEmpty()) {
                GoodblockMod.LOGGER.warn("Tag {} is empty", GoodblockModTags.slowInfectionVariants());
                return null;
            }

            return allVariants.get(RANDOM.nextInt(allVariants.size()));

        } catch (Exception e) {
            GoodblockMod.LOGGER.error("Failed to get random variant from tag", e);
            return null;
        }
    }
}