package net.hhdsj.changed_creatures.entity.simple;

import net.hhdsj.changed_creatures.entity.simple.Abstract.AbstractProtogenWater;
import net.hhdsj.changed_creatures.init.ChangedCreatureModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.PlayMessages;

public class ProtogenNyxarixEntity extends AbstractProtogenWater {

    public ProtogenNyxarixEntity(EntityType<ProtogenNyxarixEntity> protogenNyxarixEntityEntityType, Level world) {
        super(protogenNyxarixEntityEntityType,world);
    }

    public ProtogenNyxarixEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(ChangedCreatureModEntities.PROTOGEN_NYXARIX.get(), world);
    }
}
