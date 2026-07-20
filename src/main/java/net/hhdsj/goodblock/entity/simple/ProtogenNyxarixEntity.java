package net.hhdsj.goodblock.entity.simple;

import net.hhdsj.goodblock.init.GoodblockModEntities;
import net.ltxprogrammer.changed.entity.*;
import net.ltxprogrammer.changed.entity.beast.AbstractAquaticEntity;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.network.PlayMessages;

public class ProtogenNyxarixEntity extends AbstractAquaticEntity implements GenderedEntity {

    public ProtogenNyxarixEntity(EntityType<ProtogenNyxarixEntity> protogenNyxarixEntityEntityType, Level world) {
        super(protogenNyxarixEntityEntityType,world);
    }

    @Override
    public TransfurMode getTransfurMode() {
        return TransfurMode.NONE;
    }

    @Override
    protected void setAttributes(AttributeMap attributes) {
        super.setAttributes(attributes);
        attributes.getInstance(Attributes.MOVEMENT_SPEED).setBaseValue(1.2);
        attributes.getInstance(ForgeMod.SWIM_SPEED.get()).setBaseValue(1.1);
        attributes.getInstance(Attributes.MAX_HEALTH).setBaseValue(50.0);
    }

    public Color3 getTransfurColor(TransfurCause cause) {
        return Color3.getColor("#050505");
    }

    public ProtogenNyxarixEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(GoodblockModEntities.PROTOGEN_NYXARIX.get(), world);
    }

    @Override
    public Gender getGender() {
        return Gender.MALE;
    }
}
