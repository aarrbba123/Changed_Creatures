package net.hhdsj.changed_creatures.util;

import net.hhdsj.changed_creatures.network.GoodblockModVariables;
import net.minecraft.world.entity.player.Player;

public class PlayerDataGetHelper {
    public static GoodblockModVariables.PlayerVariables get(Player player) {
        return player.getCapability(GoodblockModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new GoodblockModVariables.PlayerVariables());
    }
}
