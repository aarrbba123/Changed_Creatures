package net.hhdsj.goodblock.entity.simple.Abstract;

import net.ltxprogrammer.changed.entity.Gender;
import net.ltxprogrammer.changed.entity.GenderedEntity;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.TransfurMode;
import net.ltxprogrammer.changed.entity.beast.AbstractAquaticEntity;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;

public class AbstractProtogenWater extends AbstractAquaticEntity implements GenderedEntity {

    public AbstractProtogenWater(EntityType<? extends AbstractAquaticEntity> p_19870_, Level p_19871_) {
        super(p_19870_, p_19871_);
    }

    @Override
    public TransfurMode getTransfurMode() {
        return TransfurMode.NONE;
    }

    @Override
    @SuppressWarnings("DataFlowIssue")
    protected void setAttributes(AttributeMap attributes) {
        super.setAttributes(attributes);
        attributes.getInstance(Attributes.ARMOR).setBaseValue(6);
        attributes.getInstance(Attributes.MOVEMENT_SPEED).setBaseValue(1.05);
        attributes.getInstance(ForgeMod.SWIM_SPEED.get()).setBaseValue(1.5);
        attributes.getInstance(Attributes.MAX_HEALTH).setBaseValue(50.0);
    }

    public Color3 getTransfurColor(TransfurCause cause) {
        return Color3.getColor("#FFFFFF");
    }

    @Override
    public Gender getGender() {
        return Gender.MALE;
    }
}
