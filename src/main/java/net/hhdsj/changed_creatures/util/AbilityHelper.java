package net.hhdsj.changed_creatures.util;

import net.hhdsj.changed_creatures.capability.AbilityCapability;
import net.hhdsj.changed_creatures.capability.IAbilityData;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.LazyOptional;


public class AbilityHelper {
    public static LazyOptional<IAbilityData> getData(Player player) {
        if (player == null) {
            return LazyOptional.empty();
        }
        return player.getCapability(AbilityCapability.ABILITY_CAPABILITY);
    }

    public static boolean canFly(Player player) {
        return getData(player)
                .map(IAbilityData::canFly)
                .orElse(false);
    }

    public static void setCanFly(Player player, boolean value) {
        getData(player).ifPresent(data -> data.setCanFly(value));
    }

    public static boolean canGlide(Player player) {
        return getData(player)
                .map(IAbilityData::canGlide)
                .orElse(false);
    }

    public static void setCanGlide(Player player, boolean value) {
        getData(player).ifPresent(data -> data.setCanGlide(value));
    }
}