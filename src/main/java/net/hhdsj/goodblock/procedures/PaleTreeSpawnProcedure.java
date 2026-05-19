package net.hhdsj.goodblock.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.hhdsj.goodblock.init.GoodblockModBlocks;

public class PaleTreeSpawnProcedure {
	private static final double TREE_HEIGHT = 7;
	private static final double SPAWN_CHANCE_MIN = -3;
	private static final double SPAWN_CHANCE_MAX = 18;
	private static final double SPAWN_THRESHOLD = 15;
	private static final ResourceLocation LEAVES_TAG = new ResourceLocation("minecraft:leaves");

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		// 检查生成位置是否有效
		if (!canTreeGenerate(world, x, y, z, blockstate)) {
			return;
		}

		// 随机决定是否生成
		if (!shouldGenerateTree()) {
			return;
		}

		// 生成树木
		generateTree(world, x, y, z);
	}

	/**
	 * 检查树木生成位置是否有效
	 */
	private static boolean canTreeGenerate(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		int validSpaces = 0;

		for (int i = 1; i <= TREE_HEIGHT; i++) {
			BlockPos checkPos = BlockPos.containing(x, y + i, z);
			if (world.isEmptyBlock(checkPos) || blockstate.is(BlockTags.create(LEAVES_TAG))) {
				validSpaces++;
			}
		}

		return validSpaces >= TREE_HEIGHT;
	}

	/**
	 * 随机决定是否生成树木
	 */
	private static boolean shouldGenerateTree() {
		RandomSource random = RandomSource.create();
		double randomValue = Mth.nextDouble(random, SPAWN_CHANCE_MIN, SPAWN_CHANCE_MAX);
		return randomValue >= SPAWN_THRESHOLD;
	}

	/**
	 * 生成完整的树木（橡树风格）
	 */
	private static void generateTree(LevelAccessor world, double x, double y, double z) {
		BlockState woodLog = GoodblockModBlocks.PALE_WOOD_LOG.get().defaultBlockState();
		BlockState leaves = GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState();

		// 生成树干
		generateTrunk(world, x, y, z, woodLog);

		// 生成橡树风格的树叶
		generateOakStyleLeaves(world, x, y, z, leaves);
	}

	/**
	 * 生成树干
	 */
	private static void generateTrunk(LevelAccessor world, double x, double y, double z, BlockState woodLog) {
		// 放置底部原木
		world.setBlock(BlockPos.containing(x, y, z), woodLog, 3);

		// 向上生成树干
		for (int i = 1; i <= TREE_HEIGHT; i++) {
			BlockPos trunkPos = BlockPos.containing(x, y + i, z);
			if (world.isEmptyBlock(trunkPos)) {
				world.setBlock(trunkPos, woodLog, 3);
			}
		}
	}

	/**
	 * 生成橡树风格的树叶（自然、蓬松、不规则）
	 */
	private static void generateOakStyleLeaves(LevelAccessor world, double x, double y, double z, BlockState leaves) {
		RandomSource random = RandomSource.create();

		// 树冠起始高度（树干顶部往下2格）
		double canopyStartY = y + TREE_HEIGHT - 3;

		// 第一层：底部树冠（最大层）
		generateOakLayer(world, x, canopyStartY, z, leaves, 3, random);

		// 第二层：中部树冠
		generateOakLayer(world, x, canopyStartY + 1, z, leaves, 2, random);

		// 第三层：顶部树冠
		generateOakLayer(world, x, canopyStartY + 2, z, leaves, 2, random);

		// 第四层：树顶
		generateOakLayer(world, x, canopyStartY + 3, z, leaves, 1, random);

		// 额外：树干周围的树叶（增加自然感）
		generateTrunkSurroundingLeaves(world, x, y, z, leaves, random);

		// 额外：随机延伸的树枝
		generateRandomBranches(world, x, y, z, leaves, random);
	}

	private static void generateOakLayer(LevelAccessor world, double centerX, double y, double centerZ, BlockState leaves, int baseRadius, RandomSource random) {
		for (int dx = -baseRadius; dx <= baseRadius; dx++) {
			for (int dz = -baseRadius; dz <= baseRadius; dz++) {
				// 计算曼哈顿距离，使树叶更圆润
				int distance = Math.abs(dx) + Math.abs(dz);

				// 根据距离决定是否放置树叶
				boolean shouldPlace = false;

				if (baseRadius == 3) {
					// 底层：完整圆形
					shouldPlace = distance <= 4;
				} else if (baseRadius == 2) {
					// 中层：稍微缩小
					shouldPlace = distance <= 3;
					// 随机缺失一些边缘树叶，更自然
					if (distance == 3 && random.nextDouble() < 0.3) {
						shouldPlace = false;
					}
				} else if (baseRadius == 1) {
					// 顶层：小树冠
					shouldPlace = distance <= 2;
					// 随机缺失
					if (distance == 2 && random.nextDouble() < 0.4) {
						shouldPlace = false;
					}
				}

				if (shouldPlace) {
					BlockPos leafPos = BlockPos.containing(centerX + dx, y, centerZ + dz);
					// 避免替换树干
					if (world.isEmptyBlock(leafPos)) {
						world.setBlock(leafPos, leaves, 3);
					}
				}
			}
		}

		// 为较大的层添加角落树叶（使树冠更蓬松）
		if (baseRadius >= 2) {
			addCornerLeaves(world, centerX, y, centerZ, leaves, baseRadius, random);
		}
	}

	/**
	 * 添加角落树叶，使树冠更蓬松
	 */
	private static void addCornerLeaves(LevelAccessor world, double centerX, double y, double centerZ, BlockState leaves, int radius, RandomSource random) {
		int[] corners = {-radius, radius};
		for (int dx : corners) {
			for (int dz : corners) {
				if (random.nextDouble() < 0.5) {
					BlockPos cornerPos = BlockPos.containing(centerX + dx, y, centerZ + dz);
					if (world.isEmptyBlock(cornerPos)) {
						world.setBlock(cornerPos, leaves, 3);
					}
				}
			}
		}
	}

	/**
	 * 生成树干周围的树叶（模拟树枝分叉）
	 */
	private static void generateTrunkSurroundingLeaves(LevelAccessor world, double x, double y, double z, BlockState leaves, RandomSource random) {
		// 树干中上部周围的树叶
		for (int i = 3; i <= TREE_HEIGHT - 2; i++) {
			double currentY = y + i;

			// 四个方向随机生成树叶
			int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
			for (int[] dir : directions) {
				if (random.nextDouble() < 0.4) {
					BlockPos leafPos = BlockPos.containing(x + dir[0], currentY, z + dir[1]);
					if (world.isEmptyBlock(leafPos)) {
						world.setBlock(leafPos, leaves, 3);

						// 有时会在外围再生成一层
						if (random.nextDouble() < 0.3) {
							BlockPos outerPos = BlockPos.containing(x + dir[0] * 2, currentY, z + dir[1] * 2);
							if (world.isEmptyBlock(outerPos)) {
								world.setBlock(outerPos, leaves, 3);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * 生成随机延伸的树枝
	 */
	private static void generateRandomBranches(LevelAccessor world, double x, double y, double z, BlockState leaves, RandomSource random) {
		// 在树冠区域随机生成突出的小树枝
		for (int i = 0; i < 6; i++) {
			double branchY = y + TREE_HEIGHT - 4 + random.nextInt(4);
			int branchX = random.nextInt(3) - 1;
			int branchZ = random.nextInt(3) - 1;

			// 避免中心位置
			if (branchX == 0 && branchZ == 0) {
				continue;
			}

			BlockPos branchPos = BlockPos.containing(x + branchX, branchY, z + branchZ);
			if (world.isEmptyBlock(branchPos)) {
				world.setBlock(branchPos, leaves, 3);

				// 有时生成更远的小分支
				if (random.nextDouble() < 0.3) {
					BlockPos farPos = BlockPos.containing(x + branchX * 2, branchY, z + branchZ * 2);
					if (world.isEmptyBlock(farPos)) {
						world.setBlock(farPos, leaves, 3);
					}
				}
			}
		}
	}
}