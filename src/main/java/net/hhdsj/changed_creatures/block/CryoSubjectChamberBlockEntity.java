package net.hhdsj.changed_creatures.block;

import net.hhdsj.changed_creatures.init.ChangedCreatureBlockEntities;
import net.hhdsj.changed_creatures.init.ChangedCreatureModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CryoSubjectChamberBlockEntity extends BlockEntity {
    public CryoSubjectChamberBlockEntity(BlockPos pos, BlockState state) {
        super(ChangedCreatureBlockEntities.CRYO_SUBJECT_CHAMBER_BE.get(), pos, state);
    }
}