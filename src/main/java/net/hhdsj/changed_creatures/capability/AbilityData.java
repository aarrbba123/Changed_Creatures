package net.hhdsj.changed_creatures.capability;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;

/**
 * 能力数据实现类
 */
public class AbilityData implements IAbilityData {

    private boolean canFly = false;
    private boolean canGlide = false;
    @Override
    public boolean canFly() { return canFly; }

    @Override
    public void setCanFly(boolean canFly) { this.canFly = canFly; }

    @Override
    public boolean canGlide() { return canGlide; }

    @Override
    public void setCanGlide(boolean canGlide) { this.canGlide = canGlide; }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putBoolean("canFly", canFly);
        tag.putBoolean("canGlide", canGlide);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        canFly = tag.getBoolean("canFly");
        canGlide = tag.getBoolean("canGlide");
    }
}