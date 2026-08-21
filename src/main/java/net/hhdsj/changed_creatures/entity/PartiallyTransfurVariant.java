package net.hhdsj.changed_creatures.entity;

import net.hhdsj.changed_creatures.ChangedCreature;
import net.hhdsj.changed_creatures.util.PlayerDataGetHelper;
import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = ChangedCreature.MODID)
public class PartiallyTransfurVariant {

    private static final float HORIZONTAL_PENALTY_SPRINT = 0.725F;
    private static final float HORIZONTAL_PENALTY_WALK = 0.625F;
    private static final float VERTICAL_PENALTY_UP = 0.3F;
    private static final float VERTICAL_PENALTY_DOWN = 0.8F;
    private static final int MIN_FOOD_LEVEL = 6;
    private static final float EXHAUSTION_SPRINT = 0.05F;
    private static final float EXHAUSTION_WALK = 0.025F;
    private static final Map<UUID, Boolean> lastFlightState = new HashMap<>();

    private static boolean isPartiallyTransfurred(Player player) {
        if (player == null) return false;

        TransfurVariantInstance<?> variant = ProcessTransfur.getPlayerTransfurVariant(player);
        return variant != null;
    }

    public static boolean canFly(Player player) {
        if (player == null) return false;
        if (player.isCreative() || player.isSpectator()) return false;
        if (isPartiallyTransfurred(player)) return false;
        if (PlayerDataGetHelper.GetPlayerCanFly(player)) return true;
        return false;
    }

    public static void applyFlightPhysics(Player player) {
        if (player == null) return;
        if (!player.getAbilities().flying) return;
        if (player.isCreative() || player.isSpectator()) return;

        if (!canFly(player) || !meetsFlightCriteria(player)) {
            return;
        }

        float horizontalPenalty = player.isSprinting() ? HORIZONTAL_PENALTY_SPRINT : HORIZONTAL_PENALTY_WALK;
        float verticalPenalty = player.getDeltaMovement().y > 0.0F ? VERTICAL_PENALTY_UP : VERTICAL_PENALTY_DOWN;

        player.setDeltaMovement(
                player.getDeltaMovement().multiply(horizontalPenalty, verticalPenalty, horizontalPenalty)
        );

        if (!player.level().isClientSide) {
            player.causeFoodExhaustion(player.isSprinting() ? EXHAUSTION_SPRINT : EXHAUSTION_WALK);
        }
    }

    public static boolean meetsFlightCriteria(Player player) {
        if (player == null) return false;
        if (player.getFoodData().getFoodLevel() <= MIN_FOOD_LEVEL) return false;
        if (player.isInWater()) return false;
        if (player.getVehicle() != null) return false;
        return true;
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        Player player = event.player;
        Item item = player.getItemBySlot(EquipmentSlot.CHEST).getItem();
        if (player.isCreative() || player.isSpectator()) return;

        applyFlightPhysics(player);

        if (!player.level().isClientSide) {
            autoManageFlight(player);
        }
        //Gliding(player);
    }

    private static void autoManageFlight(Player player) {
        UUID playerId = player.getUUID();
        boolean canFly = canFly(player);
        boolean meetsCriteria = meetsFlightCriteria(player);
        boolean shouldHaveFlight = canFly && meetsCriteria;

        boolean currentMayfly = player.getAbilities().mayfly;
        boolean currentFlying = player.getAbilities().flying;

        Boolean lastState = lastFlightState.get(playerId);

        if (lastState != null && lastState == shouldHaveFlight) {
            return;
        }

        if (shouldHaveFlight) {
            if (!currentMayfly) {
                player.getAbilities().mayfly = true;
                player.onUpdateAbilities();
            }
        } else {
            if (currentMayfly || currentFlying) {
                player.getAbilities().mayfly = false;
                if (currentFlying) {
                    player.getAbilities().flying = false;
                }
                player.onUpdateAbilities();
            }
        }

        lastFlightState.put(playerId, shouldHaveFlight);
    }

    @SubscribeEvent
    public static void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event) {
        lastFlightState.remove(event.getEntity().getUUID());
    }

    public static void manageGliding(Player player) {
        Item chestItem = player.getItemBySlot(EquipmentSlot.CHEST).getItem();
        boolean hasElytra = chestItem == Items.ELYTRA;
        if (hasElytra) {
            return;
        }
        boolean currentGlide = PlayerDataGetHelper.GetPlayerCanGliding(player);
        System.out.print("Can Glide : " + currentGlide + "\n");

        player.displayClientMessage(Component.literal("Can Glide : " + currentGlide).withStyle((style -> {
            Style returnStyle = style.withColor(ChatFormatting.WHITE);
            returnStyle = returnStyle.withItalic(true);
            return returnStyle;
        })), true);


    }

    public static void Gliding(Player player) {
        Item chestItem = player.getItemBySlot(EquipmentSlot.CHEST).getItem();
        boolean hasElytra = chestItem == Items.ELYTRA;
        if (hasElytra) {
            return;
        }
        double verticalSpeed = player.getDeltaMovement().y;
        boolean isAscending = verticalSpeed > 0.1;

        boolean shouldGlide = !player.onGround() &&
                Math.abs(player.fallDistance) >= 0F &&
                !player.isInWater() &&
                !player.isInLava() &&
                !player.getAbilities().flying &&
                canFly(player) &&
                PlayerDataGetHelper.GetPlayerCanGliding(player);

        if (shouldGlide && !player.isFallFlying()) {
            player.startFallFlying();
        }else{
            if (player.onGround() || !canFly(player) || player.getAbilities().flying) {
                player.stopFallFlying();
            }
        }
    }
}