package net.hhdsj.changed_creatures.block;

import net.hhdsj.changed_creatures.init.ChangedCreatureBlockEntities;
import net.ltxprogrammer.changed.block.ThreeXThreeSection;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class CryoSubjectChamberBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public static final VoxelShape SHAPE_FRAME_LEFT = Block.box(25.0D, 2.0D, -11.0D, 27.0D, 46.0D, 27.0D);
    public static final VoxelShape SHAPE_FRAME_LEFT_OPEN = Block.box(25.0D, 2.0D, 0.0D, 27.0D, 46.0D, 27.0D);
    public static final VoxelShape SHAPE_FRAME_RIGHT = Block.box(-11.0D, 2.0D, -11.0D, -9.0D, 46.0D, 27.0D);
    public static final VoxelShape SHAPE_FRAME_RIGHT_OPEN = Block.box(-11.0D, 2.0D, 0.0D, -9.0D, 46.0D, 27.0D);

    public static final VoxelShape SHAPE_FRAME_BACK = Block.box(-11.0D, 2.0D, 25.0D, 27.0D, 46.0D, 27.0D);
    public static final VoxelShape SHAPE_FRAME_FRONT = Block.box(-11.0D, 2.0D, -11.0D, 27.0D, 46.0D, -9.0D);
    public static final VoxelShape SHAPE_FRAME_BOTTOM = Block.box(-11.0D, 0.0D, -11.0D, 27.0D, 2.0D, 27.0D);
    public static final VoxelShape SHAPE_FRAME_TOP = Block.box(-11.0D, 46.0D, -11.0D, 27.0D, 48.0D, 27.0D);

    public static final VoxelShape INTERACTION_SHAPE = Block.box(-11.0D, 0.0D, -11.0D, 27.0D, 48.0D, 27.0D);

    public static final VoxelShape SHAPE_COLLISION_OPEN = Shapes.or(
            SHAPE_FRAME_LEFT_OPEN, SHAPE_FRAME_RIGHT_OPEN,
            SHAPE_FRAME_BACK,
            SHAPE_FRAME_BOTTOM, SHAPE_FRAME_TOP
    );

    public static final EnumProperty<ThreeXThreeSection> SECTION =
            EnumProperty.create("section", ThreeXThreeSection.class);

    public static final VoxelShape SHAPE_INTERIOR_FLOOR =
            Block.box(-11.0D, 0.0D, -11.0D, 27.0D, 0.5D, 27.0D);

    public static final VoxelShape SHAPE_COLLISION_CLOSED = Shapes.or(
            SHAPE_FRAME_LEFT, SHAPE_FRAME_RIGHT,
            SHAPE_FRAME_BACK, SHAPE_FRAME_FRONT,
            SHAPE_FRAME_BOTTOM, SHAPE_FRAME_TOP,
            SHAPE_INTERIOR_FLOOR  // ← 内部地板
    );

    public CryoSubjectChamberBlock() {
        super(BlockBehaviour.Properties.of()
                .sound(SoundType.METAL)
                .requiresCorrectToolForDrops()
                .strength(6.5F, 9.0F)
                .lightLevel(state -> 15) // 发光等级（可选）
        );
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(SECTION, ThreeXThreeSection.MIDDLE_BOTTOM_MIDDLE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING, SECTION);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        var offset = state.getValue(SECTION).getOffset(state.getValue(FACING), ThreeXThreeSection.MIDDLE_BOTTOM_MIDDLE);
        return SHAPE_COLLISION_CLOSED.move(offset.getX(), offset.getY(), offset.getZ());
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        if (state.getValue(SECTION) == ThreeXThreeSection.CENTER) {
            return ChangedCreatureBlockEntities.CRYO_SUBJECT_CHAMBER_BE.get().create(pos, state);
        }
        return null;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(SECTION, ThreeXThreeSection.MIDDLE_BOTTOM_MIDDLE);
    }

}