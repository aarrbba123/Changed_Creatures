package net.hhdsj.goodblock.entity.simple;

import net.hhdsj.goodblock.entity.simple.Abstract.AbstractProtogenWater;
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

public class ProtogenNyxarixEntity extends AbstractProtogenWater {

    public ProtogenNyxarixEntity(EntityType<ProtogenNyxarixEntity> protogenNyxarixEntityEntityType, Level world) {
        super(protogenNyxarixEntityEntityType,world);
    }

    public ProtogenNyxarixEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(GoodblockModEntities.PROTOGEN_NYXARIX.get(), world);
    }
}
