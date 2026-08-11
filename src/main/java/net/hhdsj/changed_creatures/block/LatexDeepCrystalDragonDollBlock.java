package net.hhdsj.changed_creatures.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class LatexDeepCrystalDragonDollBlock extends Block {
    public LatexDeepCrystalDragonDollBlock() {
        super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(5f, 40f));
    }
}
