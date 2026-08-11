package net.hhdsj.changed_creatures.entity.simple.Abstract;

import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.TransfurMode;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;

import java.util.Objects;

public class AbstractLatexDuskDawnDragon extends ChangedEntity {

    public boolean can_changed_color = true;
    public String eyes_color = "#FFFFFF";

    public AbstractLatexDuskDawnDragon(EntityType<? extends ChangedEntity> type, Level level) {
        super(type, level);
    }

    public Color3 getTransfurColor(TransfurCause cause) {
        return Color3.getColor(eyes_color);
    }

    @Override
    public TransfurMode getTransfurMode() {
        return TransfurMode.ABSORPTION;
    }

    @Override
    protected void setAttributes(AttributeMap attributes) {
        super.setAttributes(attributes);
        Objects.requireNonNull(attributes.getInstance(Attributes.MOVEMENT_SPEED)).setBaseValue(1.16);
        Objects.requireNonNull(attributes.getInstance(Attributes.MAX_HEALTH)).setBaseValue(24);
        Objects.requireNonNull(attributes.getInstance(ForgeMod.SWIM_SPEED.get())).setBaseValue(1.1);
    }

    public boolean GetCanChangeColor() {
        return can_changed_color;
    }

    public void setCanChangeColor(boolean canChange) {
        this.can_changed_color = canChange;
    }

    public String getEyesColor() {
        return eyes_color;
    }

    public void setEyesColor(String color) {
        this.eyes_color = color;
    }
}
