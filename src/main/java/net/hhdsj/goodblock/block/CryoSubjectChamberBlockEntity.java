package net.hhdsj.goodblock.block;

import net.hhdsj.goodblock.init.GoodblockModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.hhdsj.goodblock.block.CryoSubjectChamberBlock;

public class CryoSubjectChamberBlockEntity extends BlockEntity {
    public CryoSubjectChamberBlockEntity(BlockPos pos, BlockState state) {
        super(GoodblockModBlocks.CRYO_SUBJECT_CHAMBER_BE.get(), pos, state);
    }
}