package net.hhdsj.changed_creatures.entity.simple;

import net.hhdsj.changed_creatures.entity.simple.Abstract.AbstractLatexDuskDawnDragon;
import net.hhdsj.changed_creatures.init.ChangedCreatureModEntities;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.PlayMessages;

public class LatexDuskDawnDragonEntity extends AbstractLatexDuskDawnDragon {

    public LatexDuskDawnDragonEntity(EntityType<? extends ChangedEntity> type, Level level) {
        super(type, level);
    }

    public LatexDuskDawnDragonEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(ChangedCreatureModEntities.LATEX_DUSK_DAWN_DRAGON.get(), world);
    }
}
