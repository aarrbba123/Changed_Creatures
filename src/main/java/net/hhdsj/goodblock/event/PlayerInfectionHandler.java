package net.hhdsj.goodblock.event;

import net.hhdsj.goodblock.util.PlayerDataGetHelper;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.player.Player;
import net.hhdsj.goodblock.network.GoodblockModVariables;

@Mod.EventBusSubscriber
public class PlayerInfectionHandler {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {

        if (event.phase == TickEvent.Phase.END && !event.player.level().isClientSide()) {

            Player player = event.player;
            GoodblockModVariables.PlayerVariables data = PlayerDataGetHelper.get(player);

            if (!data.Player_Is_Infection) {
               return;
            }

            data.Player_Infection_tick++;

            if (data.Player_Infection_tick % 100 == 0) {
                data.syncPlayerVariables(player);
            }
            if (data.Player_Infection_tick >= 1000) {
                if (!player.hasEffect(MobEffects.BLINDNESS)) {
                    player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 10, 1));
                }
                if (!player.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 1));
                }
            }

            if (data.Player_Infection_tick % 100 == 0) {
                System.out.println("Now Player_Infection_tick : " + data.Player_Infection_tick);
            }
        }
    }
}