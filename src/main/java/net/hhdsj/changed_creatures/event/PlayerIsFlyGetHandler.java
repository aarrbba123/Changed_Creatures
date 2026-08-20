package net.hhdsj.changed_creatures.event;

import net.hhdsj.changed_creatures.util.PlayerDataGetHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class PlayerIsFlyGetHandler {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;

        if (event.phase == TickEvent.Phase.END) {
            //boolean isFlying = player.getAbilities().flying;
            //PlayerDataGetHelper.SetPlayerIsFly(player, isFlying);
        }
    }
}