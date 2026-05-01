package net.hhdsj.goodblock.event;

import net.hhdsj.goodblock.GoodblockMod;
import net.hhdsj.goodblock.init.GoodblockModParticleTypes;
import net.hhdsj.goodblock.init.GoodblockModTransfurVariants;
import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GoodblockMod.MODID)
public class PlayerTickHandler {

    private static boolean wasFlying = false;

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) {
            return;
        }

        Player player = event.player;

        // 客户端也需要执行粒子效果
        // 不需要检查 isClientSide

        // 检查玩家是否在飞行
        boolean isFlying = player.getAbilities().flying;

        // 检测飞行状态变化（只在服务端执行）
        if (!player.level().isClientSide) {
            if (isFlying && !wasFlying) {
                onPlayerStartFlying(player);
            } else if (!isFlying && wasFlying) {
                onPlayerStopFlying(player);
            }
        }

        // 飞行中持续执行（客户端和服务端都执行）
        if (isFlying) {
            onPlayerFlying(player);
        }

        if (!player.level().isClientSide) {
            wasFlying = isFlying;
        }
    }

    private static void onPlayerStartFlying(Player player) {
        // 服务端逻辑
    }

    private static void onPlayerStopFlying(Player player) {
        // 服务端逻辑
    }

    private static void onPlayerFlying(Player player) {
        TransfurVariantInstance<?> variant = ProcessTransfur.getPlayerTransfurVariant(player);
        if (variant == null) {
            return;
        }

        if (variant.getParent() == GoodblockModTransfurVariants.LATEX_GAO_HUI_FOX.get()) {

            if (player.level().isClientSide) {
                if (player.tickCount % 4 == 0) {
                    double x = player.getX();
                    double y = player.getY() + 1.0;
                    double z = player.getZ();
                    double radius = 1.0;
                    int particleCount = 4;

                    for (int i = 0; i < particleCount; i++) {
                        double angle = (player.tickCount * 15 + i * (360.0 / particleCount)) * Math.PI / 180.0;
                        double offsetX = Math.cos(angle) * radius;
                        double offsetZ = Math.sin(angle) * radius;
                        double offsetY = Math.sin(player.tickCount * 0.2 + i) * 0.15;

                        player.level().addParticle(
                                GoodblockModParticleTypes.GREEN_FLAME.get(),
                                x + offsetX,
                                y + offsetY,
                                z + offsetZ,
                                0.0, 0.02, 0.0
                        );
                    }
                }
            }
        }
    }
}