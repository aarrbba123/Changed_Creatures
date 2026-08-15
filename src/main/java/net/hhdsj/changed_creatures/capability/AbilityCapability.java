package net.hhdsj.changed_creatures.capability;

import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Capability 注册和提供者
 */
public class AbilityCapability {

    // 1. 定义 Capability（全局唯一）
    public static final Capability<IAbilityData> ABILITY_CAPABILITY =
            CapabilityManager.get(new CapabilityToken<>() {});

    // 2. 提供者类（附加到实体上）
    public static class Provider implements ICapabilityProvider {
        private final IAbilityData data = new AbilityData();
        private final LazyOptional<IAbilityData> lazyOptional = LazyOptional.of(() -> data);

        @Override
        public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
            return LazyOptional.empty();
        }

        @Override
        public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap) {
            if (cap == ABILITY_CAPABILITY) {
                return lazyOptional.cast();
            }
            return LazyOptional.empty();
        }

        public void invalidate() {
            lazyOptional.invalidate();
        }
    }
}