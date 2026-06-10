package net.hhdsj.goodblock.entity.simple;

import net.hhdsj.goodblock.entity.simple.Abstract.AbstractLatexDuskDawnDragon;
import net.hhdsj.goodblock.init.GoodblockModEntities;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.TransfurMode;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.network.PlayMessages;

import java.util.Objects;

public class LatexDuskDawnDragonEntity extends AbstractLatexDuskDawnDragon {

    public LatexDuskDawnDragonEntity(EntityType<? extends ChangedEntity> type, Level level) {
        super(type, level);
    }

    public LatexDuskDawnDragonEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(GoodblockModEntities.LATEX_DUSK_DAWN_DRAGON.get(), world);
    }
}
