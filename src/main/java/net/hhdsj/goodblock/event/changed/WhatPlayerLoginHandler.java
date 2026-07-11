package net.hhdsj.goodblock.event.changed;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
/*
@Mod.EventBusSubscriber
public class WhatPlayerLoginHandler {

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        String playerName = player.getName().getString();
        if ("chengxi_yea".equals(playerName)) {
            handleBoomPlayer(player);
        }
    }

    private static void handleBoomPlayer(Player player) {
        if (player.level().isClientSide()) return;
        if (!(player instanceof ServerPlayer serverPlayer)) return;
        if (player.level().random.nextFloat() >= 0.1f) return;
        serverPlayer.connection.disconnect(Component.literal("连接超时"));
    }
}*/