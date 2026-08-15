package net.hhdsj.changed_creatures.entity;

import net.hhdsj.changed_creatures.ChangedCreature;
import net.hhdsj.changed_creatures.util.AbilityHelper;
import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.WeakHashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = ChangedCreature.MODID)
public class PartiallyTransfurVariant {

    private static final Map<Player, Boolean> lastFlightState = new WeakHashMap<>();

    private static boolean canFly(Player player) {
        if (player == null) return false;
        TransfurVariantInstance<?> TransfurVariant = ProcessTransfur.getPlayerTransfurVariant(player);
        if (player.isCreative() || player.isSpectator()) return false;
        if (AbilityHelper.canFly(player)) return false;
        if (TransfurVariant != null) return true;
        return true;
    }

    public static void applyFlightPhysics(Player player) {
        if (player == null) return;
        if (!player.getAbilities().flying) return;
        if (player.isCreative() || player.isSpectator()) return;

        if (!canFly(player)) {
            return;
        }
        float horizontalPenalty = player.isSprinting() ? 0.425F : 0.325F;
        float verticalPenalty = player.getDeltaMovement().y > 0.0F ? 0.3F : 0.8F;

        player.setDeltaMovement(
                player.getDeltaMovement().multiply(
                        horizontalPenalty,
                        verticalPenalty,
                        horizontalPenalty
                )
        );
        if (player.level().isClientSide) return;
        player.causeFoodExhaustion(player.isSprinting() ? 0.05F : 0.025F);
    }

    public static boolean meetsFlightCriteria(Player player) {
        if (player == null) return false;

        if (player.getFoodData().getFoodLevel() <= 6) return false;

        if (player.isInWater()) return false;

        if (player.getVehicle() != null) return false;

        return true;
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        //if (event.player.level().isClientSide) return;

        Player player = event.player;

        if (player.isCreative() || player.isSpectator()) return;

        applyFlightPhysics(player);

        if (event.player.level().isClientSide) return;
        autoManageFlight(player);
    }

    private static void autoManageFlight(Player player) {
        if (!canFly(player)) {
            boolean currentMayfly = player.getAbilities().mayfly;
            boolean currentFlying = player.getAbilities().flying;
            Boolean lastState = lastFlightState.get(player);

            if (lastState == null || lastState) {
                if (currentMayfly || currentFlying) {
                    player.getAbilities().mayfly = false;
                    if (currentFlying) {
                        player.getAbilities().flying = false;
                    }
                    player.onUpdateAbilities();
                }
                lastFlightState.put(player, false);
            }
            return;
        }

        boolean meetsCriteria = meetsFlightCriteria(player);
        boolean mayfly = player.getAbilities().mayfly;
        Boolean lastState = lastFlightState.get(player);

        if (!meetsCriteria && mayfly) {
            player.getAbilities().mayfly = false;
            if (player.getAbilities().flying) {
                player.getAbilities().flying = false;
            }
            player.onUpdateAbilities();
            lastFlightState.put(player, false);
        }
        else if (meetsCriteria && !mayfly) {
            player.getAbilities().mayfly = true;
            player.onUpdateAbilities();
            lastFlightState.put(player, true);
        }
        else {
            boolean currentState = meetsCriteria && mayfly;
            if (lastState == null || lastState != currentState) {
                lastFlightState.put(player, currentState);
            }
        }
    }
}