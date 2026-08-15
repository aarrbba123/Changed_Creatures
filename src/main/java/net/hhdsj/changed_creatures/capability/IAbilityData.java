package net.hhdsj.changed_creatures.capability;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;

public interface IAbilityData extends INBTSerializable<CompoundTag> {

    // 飞行能力
    boolean canFly();
    void setCanFly(boolean canFly);

    // 滑行能力
    boolean canGlide();
    void setCanGlide(boolean canGlide);
}
