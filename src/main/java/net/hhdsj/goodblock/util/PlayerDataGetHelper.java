package net.hhdsj.goodblock.util;

import net.hhdsj.goodblock.network.GoodblockModVariables;
import net.minecraft.world.entity.player.Player;

public class PlayerDataGetHelper {
    public static GoodblockModVariables.PlayerVariables get(Player player) {
        return player.getCapability(GoodblockModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new GoodblockModVariables.PlayerVariables());
    }
}
