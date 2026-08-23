package net.hhdsj.changed_creatures.entity.simple;

import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.TransfurMode;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraftforge.common.ForgeMod;

public class LatexEyroEndDragonEntity extends ChangedEntity {


    public LatexEyroEndDragonEntity(EntityType<? extends ChangedEntity> type, Level level) {
        super(type, level);
    }

    protected void setAttributes(AttributeMap attributes) {
        super.setAttributes(attributes);
        attributes.getInstance(Attributes.MAX_HEALTH).setBaseValue(24);
        attributes.getInstance(ForgeMod.SWIM_SPEED.get()).setBaseValue(0.8);
    }
    @Override
    public TransfurMode getTransfurMode() {
        return TransfurMode.ABSORPTION;
    }

    @Override
    public Color3 getTransfurColor(TransfurCause cause) {
        return Color3.getColor("#57e4ff");
    }
}
