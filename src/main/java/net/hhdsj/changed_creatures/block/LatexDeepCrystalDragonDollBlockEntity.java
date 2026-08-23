package net.hhdsj.changed_creatures.block;

import net.hhdsj.changed_creatures.init.ChangedCreatureBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class LatexDeepCrystalDragonDollBlockEntity extends BlockEntity {

    public LatexDeepCrystalDragonDollBlockEntity(BlockPos pos, BlockState state) {
        super(ChangedCreatureBlockEntities.LATEX_DEEP_CRYSTAL_DRAGON_DOLL_BE.get(), pos, state);
    }
}