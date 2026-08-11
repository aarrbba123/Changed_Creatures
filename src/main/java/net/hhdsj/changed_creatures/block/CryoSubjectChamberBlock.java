package net.hhdsj.changed_creatures.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CryoSubjectChamberBlock extends BaseEntityBlock {
    // 定义碰撞箱组件
    private static final VoxelShape SHAPE_FRAME_LEFT = box(14, 2, 0, 16, 14, 16);
    private static final VoxelShape SHAPE_FRAME_RIGHT = box(0, 2, 0, 2, 14, 16);
    private static final VoxelShape SHAPE_FRAME_BACK = box(0, 2, 14, 16, 14, 16);
    private static final VoxelShape SHAPE_FRAME_FRONT = box(0, 2, 0, 16, 14, 2);
    private static final VoxelShape SHAPE_FRAME_BOTTOM = box(0, 0, 0, 16, 2, 16);
    private static final VoxelShape SHAPE_FRAME_TOP = box(0, 14, 0, 16, 16, 16);

    // 组合碰撞箱
    private static final VoxelShape SHAPE_COLLISION = Shapes.or(
            SHAPE_FRAME_LEFT, SHAPE_FRAME_RIGHT, SHAPE_FRAME_BACK,
            SHAPE_FRAME_FRONT, SHAPE_FRAME_BOTTOM, SHAPE_FRAME_TOP
    );
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public CryoSubjectChamberBlock() {
        super(BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.BASEDRUM)
                .sound(SoundType.STONE)
                .strength(1f, 10f)
                .noOcclusion()
                .isRedstoneConductor((bs, br, bp) -> false));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return true;
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 8;
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return box(-10, 0, -10, 26, 48, 26);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public @NotNull BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    // BlockEntity 相关方法
    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CryoSubjectChamberBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        // 返回 ENTITYBLOCK_ANIMATED 以使用 BlockEntity 渲染
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }
}