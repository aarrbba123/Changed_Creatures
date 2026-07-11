
/////////////WARN/////////////
///////////AI CODE////////////

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
	// ===== 配置参数 =====
	private static final int TREE_HEIGHT = 7;
	private static final double SPAWN_CHANCE_MIN = -3;
	private static final double SPAWN_CHANCE_MAX = 18;
	private static final double SPAWN_THRESHOLD = 15;
	private static final ResourceLocation LEAVES_TAG = new ResourceLocation("minecraft:leaves");

	/**
	 * 执行树木生成（返回是否成功）
	 */
	public static boolean execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		// 1. 检查生成位置是否有效
		if (!canTreeGenerate(world, x, y, z, blockstate)) {
			return false;
		}

		// 2. 随机决定是否生成
		if (!shouldGenerateTree()) {
			return false;
		}

		// 3. 生成树木
		generateTree(world, x, y, z);

		return true;
	}

	/**
	 * 检查树木生成位置是否有效（移除了错误的光照和生长逻辑）
	 */
	private static boolean canTreeGenerate(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		int validSpaces = 0;

		// 检查树干空间（从 y+1 到 y+TREE_HEIGHT）
		for (int i = 1; i <= TREE_HEIGHT; i++) {
			BlockPos checkPos = BlockPos.containing(x, y + i, z);
			if (world.isEmptyBlock(checkPos) ||
					blockstate.is(BlockTags.create(LEAVES_TAG))) {
				validSpaces++;
			}
		}

		// 检查树冠空间（树冠区域）
		double canopyStartY = y + TREE_HEIGHT - 3;
		for (int dy = 0; dy < 4; dy++) {
			int radius = (dy == 0) ? 3 : (dy <= 2 ? 2 : 1);
			for (int dx = -radius; dx <= radius; dx++) {
				for (int dz = -radius; dz <= radius; dz++) {
					// 曼哈顿距离检查
					int distance = Math.abs(dx) + Math.abs(dz);
					if (distance <= radius + 1) {
						BlockPos checkPos = BlockPos.containing(x + dx, canopyStartY + dy, z + dz);
						if (!world.isEmptyBlock(checkPos) &&
								!blockstate.is(BlockTags.create(LEAVES_TAG))) {
							return false;  // 树冠空间被阻挡
						}
					}
				}
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
	 * 生成树干（略微弯曲，更自然）
	 */
	private static void generateTrunk(LevelAccessor world, double x, double y, double z, BlockState woodLog) {
		RandomSource random = RandomSource.create();
		int trunkHeight = TREE_HEIGHT;

		// 树干偏移（模拟弯曲）
		int offsetX = 0;
		int offsetZ = 0;

		for (int i = 0; i <= trunkHeight; i++) {
			// 在树干中部开始弯曲
			if (i > 3 && i < trunkHeight - 1 && random.nextDouble() < 0.2) {
				offsetX += random.nextInt(3) - 1;
				offsetZ += random.nextInt(3) - 1;
				// 限制偏移量
				offsetX = Math.max(-1, Math.min(1, offsetX));
				offsetZ = Math.max(-1, Math.min(1, offsetZ));
			}

			BlockPos trunkPos = BlockPos.containing(
					x + offsetX,
					y + i,
					z + offsetZ
			);

			// 只放置在有空间的位置（底部强制放置）
			if (world.isEmptyBlock(trunkPos) || i == 0) {
				world.setBlock(trunkPos, woodLog, 3);
			}
		}
	}

	/**
	 * 生成橡树风格的树叶（增强版）
	 */
	private static void generateOakStyleLeaves(LevelAccessor world, double x, double y, double z, BlockState leaves) {
		RandomSource random = RandomSource.create();

		// 树冠起始高度
		double canopyStartY = y + TREE_HEIGHT - 3;

		// === 第1层：底部树冠（最大） ===
		generateOakLayer(world, x, canopyStartY, z, leaves, 3, random);

		// === 第2层：中部树冠 ===
		generateOakLayer(world, x, canopyStartY + 1, z, leaves, 2, random);

		// === 第3层：上部树冠 ===
		generateOakLayer(world, x, canopyStartY + 2, z, leaves, 2, random);

		// === 第4层：树顶 ===
		generateOakLayer(world, x, canopyStartY + 3, z, leaves, 1, random);

		// === 第5层：最顶端（单个树叶） ===
		BlockPos topPos = BlockPos.containing(x, canopyStartY + 4, z);
		if (world.isEmptyBlock(topPos)) {
			world.setBlock(topPos, leaves, 3);
		}

		// === 树干周围的树叶（增加自然感） ===
		generateTrunkSurroundingLeaves(world, x, y, z, leaves, random);

		// === 随机延伸的树枝 ===
		generateRandomBranches(world, x, y, z, leaves, random);

		// === 底部垂落树叶（模拟藤蔓效果） ===
		generateHangingLeaves(world, x, canopyStartY, z, leaves, random);
	}

	/**
	 * 生成单层树叶
	 */
	private static void generateOakLayer(LevelAccessor world, double centerX, double y, double centerZ, BlockState leaves, int baseRadius, RandomSource random) {
		for (int dx = -baseRadius; dx <= baseRadius; dx++) {
			for (int dz = -baseRadius; dz <= baseRadius; dz++) {
				// 计算曼哈顿距离，使树叶更圆润
				int distance = Math.abs(dx) + Math.abs(dz);

				// 根据半径决定放置规则
				boolean shouldPlace = false;
				double decayChance = 0.0;

				if (baseRadius == 3) {
					// 底层：完整圆形，边缘稀疏
					shouldPlace = distance <= 4;
					if (distance == 4) {
						decayChance = 0.3;
					}
				} else if (baseRadius == 2) {
					// 中层：稍微缩小
					shouldPlace = distance <= 3;
					if (distance == 3) {
						decayChance = 0.25;
					}
				} else if (baseRadius == 1) {
					// 顶层：小树冠
					shouldPlace = distance <= 2;
					if (distance == 2) {
						decayChance = 0.4;
					}
				}

				// 应用随机稀疏
				if (shouldPlace && random.nextDouble() < decayChance) {
					shouldPlace = false;
				}

				if (shouldPlace) {
					BlockPos leafPos = BlockPos.containing(centerX + dx, y, centerZ + dz);
					if (world.isEmptyBlock(leafPos)) {
						world.setBlock(leafPos, leaves, 3);
					}
				}
			}
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
	 * 生成垂落的树叶（底部悬挂）
	 */
	private static void generateHangingLeaves(LevelAccessor world, double x, double y, double z, BlockState leaves, RandomSource random) {
		for (int dx = -2; dx <= 2; dx++) {
			for (int dz = -2; dz <= 2; dz++) {
				// 只在边缘生成
				if (Math.abs(dx) != 2 && Math.abs(dz) != 2) {
					continue;
				}

				if (random.nextDouble() < 0.3) {
					BlockPos hangPos = BlockPos.containing(x + dx, y - 1, z + dz);
					if (world.isEmptyBlock(hangPos)) {
						world.setBlock(hangPos, leaves, 3);
					}
				}
			}
		}
	}

	/**
	 * 生成树干周围的树叶（模拟树枝分叉）
	 */
	private static void generateTrunkSurroundingLeaves(LevelAccessor world, double x, double y, double z, BlockState leaves, RandomSource random) {
		for (int i = 3; i <= TREE_HEIGHT - 2; i++) {
			double currentY = y + i;

			int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
			for (int[] dir : directions) {
				if (random.nextDouble() < 0.35) {
					BlockPos leafPos = BlockPos.containing(x + dir[0], currentY, z + dir[1]);
					if (world.isEmptyBlock(leafPos)) {
						world.setBlock(leafPos, leaves, 3);

						// 有时在外围再生成一层
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
		for (int i = 0; i < 8; i++) {
			double branchY = y + TREE_HEIGHT - 4 + random.nextInt(4);
			int branchX = random.nextInt(3) - 1;
			int branchZ = random.nextInt(3) - 1;

			if (branchX == 0 && branchZ == 0) {
				continue;
			}

			BlockPos branchPos = BlockPos.containing(x + branchX, branchY, z + branchZ);
			if (world.isEmptyBlock(branchPos)) {
				world.setBlock(branchPos, leaves, 3);

				// 更远的小分支
				if (random.nextDouble() < 0.25) {
					BlockPos farPos = BlockPos.containing(x + branchX * 2, branchY - 1, z + branchZ * 2);
					if (world.isEmptyBlock(farPos)) {
						world.setBlock(farPos, leaves, 3);
					}
				}
			}
		}
	}
}