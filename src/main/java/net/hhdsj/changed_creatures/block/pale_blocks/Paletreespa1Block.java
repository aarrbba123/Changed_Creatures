package net.hhdsj.changed_creatures.block.pale_blocks;

import net.hhdsj.changed_creatures.procedures.PaleTreeSpawnProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class Paletreespa1Block extends SaplingBlock {

	// 自定义生长阶段
	public static final IntegerProperty GROWTH_STAGE = IntegerProperty.create("growth_stage", 0, 1);

	// 自定义碰撞箱（比原版更高）
	protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 14.0D, 12.0D);

	// ===== 无参构造器（用于注册） =====
	public Paletreespa1Block() {
		// 传入自定义的树生长器
		super(new AbstractTreeGrower() {
				  @Nullable
				  @Override
				  protected net.minecraft.resources.ResourceKey<net.minecraft.world.level.levelgen.feature.ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean hasFlowers) {
					  // 返回 null，因为我们使用自定义的 growTree 方法
					  return null;
				  }

				  @Override
				  public boolean growTree(ServerLevel level, ChunkGenerator chunkGenerator, BlockPos pos, BlockState state, RandomSource random) {
					  // 调用你的自定义树生成逻辑
					  // 在 Forge 1.20.1 中，growTree 需要传入 ChunkGenerator
					  return PaleTreeSpawnProcedure.execute(level, pos.getX(), pos.getY(), pos.getZ(), state);
				  }
			  }, Properties.of()
						.mapColor(MapColor.PLANT)
						.strength(0.5F)
						.noOcclusion()
						.randomTicks()
						.sound(SoundType.GRASS)
		);

		// 注册默认状态
		this.registerDefaultState(
				this.stateDefinition.any()
						.setValue(STAGE, 0)
						.setValue(GROWTH_STAGE, 0)
		);
	}

	// ===== 带参构造器（保留以备后用） =====
	public Paletreespa1Block(AbstractTreeGrower grower, Properties properties) {
		super(grower, properties);
		this.registerDefaultState(
				this.stateDefinition.any()
						.setValue(STAGE, 0)
						.setValue(GROWTH_STAGE, 0)
		);
	}

	@Override
	public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	// ===== 重写随机刻 =====
	@Override
	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if (!level.isAreaLoaded(pos, 1)) return;
		if (level.getMaxLocalRawBrightness(pos.above()) >= 9 && random.nextInt(5) == 0) {
			this.advanceTree(level, pos, state, random);
		}
	}

	// ===== 重写生长推进器 =====
	@Override
	public void advanceTree(ServerLevel level, BlockPos pos, BlockState state, RandomSource random) {
		// 检查光照
		if (level.getMaxLocalRawBrightness(pos.above()) < 9) {
			return;
		}

		int currentStage = state.getValue(GROWTH_STAGE);

		if (currentStage == 0) {
			// 第一阶段 → 第二阶段
			level.setBlock(pos, state.setValue(GROWTH_STAGE, 1), 4);
		} else {
			// 第二阶段 → 尝试生成树木
			// 先移除树苗
			level.removeBlock(pos, false);

			// 调用你的自定义生成器
			boolean success = PaleTreeSpawnProcedure.execute(
					level,
					pos.getX(),
					pos.getY(),
					pos.getZ(),
					state
			);

			if (!success) {
				// 生成失败：恢复树苗
				level.setBlock(pos, state, 4);
			}
		}
	}

	// ===== 重写骨粉有效性 =====
	@Override
	public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean isClient) {
		return true;
	}

	// ===== 重写骨粉成功率 =====
	@Override
	public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
		return random.nextFloat() < 0.6F;
	}

	// ===== 重写骨粉执行 =====
	@Override
	public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
		this.advanceTree(level, pos, state, random);
	}

	// ===== 重写种植条件 =====
	@Override
	protected boolean mayPlaceOn(BlockState groundState, BlockGetter level, BlockPos pos) {
		return groundState.is(net.minecraft.world.level.block.Blocks.GRASS_BLOCK) ||
				groundState.is(net.minecraft.world.level.block.Blocks.DIRT) ||
				groundState.is(net.minecraft.world.level.block.Blocks.COARSE_DIRT) ||
				groundState.is(net.minecraft.world.level.block.Blocks.PODZOL);
	}

	// ===== 重写状态定义 =====
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(GROWTH_STAGE);
	}
}