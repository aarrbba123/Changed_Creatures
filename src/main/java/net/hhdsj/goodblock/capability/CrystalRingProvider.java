package net.hhdsj.goodblock.capability;

import net.hhdsj.goodblock.event.CrystalRingHandler;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CrystalRingProvider implements ICapabilitySerializable<CompoundTag> {
    private final CrystalRing instance = new CrystalRing();
    private final LazyOptional<CrystalRing> holder = LazyOptional.of(() -> instance);

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return cap == CrystalRingHandler.CAPABILITY ? holder.cast() : LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putBoolean("active", instance.isActive());
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        instance.setActive(tag.getBoolean("active"));
    }
}