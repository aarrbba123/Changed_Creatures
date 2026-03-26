package net.hhdsj.goodblock.event;

import net.hhdsj.goodblock.GoodblockMod;
import net.hhdsj.goodblock.init.GoodblockModMobEffects;
import net.hhdsj.goodblock.init.GoodblockModTags;
import net.hhdsj.goodblock.init.GoodblockModTransfurVariants;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.TransfurContext;
import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryManager;

import java.util.Random;

@Mod.EventBusSubscriber
public class PlayerDeathHandler {

    private static final Random RANDOM = new Random();

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof Player player && !player.level().isClientSide) {
            if (ProcessTransfur.getPlayerTransfurVariant(player) != null) return;

            if (player.hasEffect(GoodblockModMobEffects.SLOWINFECTION.get())) {
                handleSlowInfectionDeathRandom(player, event);
            }
        }
    }

    private static void handleSlowInfectionDeathRandom(Player player, LivingDeathEvent event) {
        TransfurVariant<?> selectedVariant = getRandomVariantFromTag();

        if (selectedVariant == null) {
            selectedVariant = GoodblockModTransfurVariants.LATEXDARKPURPLEDRAGON.get();
        }

        ProcessTransfur.setPlayerTransfurVariant(
                player,
                selectedVariant,
                TransfurContext.hazard(TransfurCause.GRAB_REPLICATE),
                1f
        );

        event.setCanceled(true);
        player.setHealth(1.0f);
        player.removeEffect(GoodblockModMobEffects.SLOWINFECTION.get());
    }

    private static TransfurVariant<?> getRandomVariantFromTag() {
        try {
            // 获取 Forge 注册表
            var registry = RegistryManager.ACTIVE.getRegistry(
                    new ResourceLocation("changed", "transfur_variant")
            );

            if (registry != null) {
                @SuppressWarnings("unchecked")
                TagKey<Object> objectTagKey = (TagKey<Object>) (Object) GoodblockModTags.SLOW_INFECTION_VARIANTS;

                var tag = registry.tags().getTag(objectTagKey);

                if (!tag.isEmpty()) {
                    var list = tag.stream().toList();
                    if (!list.isEmpty()) {
                        return (TransfurVariant<?>) list.get(RANDOM.nextInt(list.size()));
                    }
                }
            }
        } catch (Exception e) {
            GoodblockMod.LOGGER.error("Error reading tag: {}", GoodblockModTags.SLOW_INFECTION_VARIANTS.location(), e);
        }

        return null;
    }
}