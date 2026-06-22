package net.hhdsj.goodblock.item;

import net.hhdsj.goodblock.network.GoodblockModVariables;
import net.hhdsj.goodblock.util.ProgressTransfurExt;
import net.hhdsj.goodblock.util.PlayerDataGetHelper;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.util.CameraUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.Objects;

public class LatexCrystalJellyItem extends Item {
	private static final double ATTRACT_RADIUS = 16.0D;  // 吸引半径
	private static final double LOOK_STRENGTH = 0.5D;  // 看向强度（原参考值0.125D，但CameraUtil用的是strength

	public LatexCrystalJellyItem() {
		super(new Properties().stacksTo(64).rarity(Rarity.RARE));
	}

	// 文本
	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("一种流淌的胶液的水晶").withStyle(ChatFormatting.BLUE));
		list.add(Component.literal("散发着未知诱人的力量").withStyle(ChatFormatting.BLUE));
		list.add(Component.literal("人类触碰不宜触碰").withStyle(ChatFormatting.RED));
	}

	// 背包Tick
	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotIndex, boolean isSelected) {
		super.inventoryTick(stack, level, entity, slotIndex, isSelected);

		// 仅在服务端执行
		if (level.isClientSide) {
			return;
		}

		if (entity instanceof Player player) {
			boolean isInMainHand = ItemStack.isSameItemSameTags(player.getMainHandItem(), stack);
			boolean isInOffHand = ItemStack.isSameItemSameTags(player.getOffhandItem(), stack);

			if (isInMainHand || isInOffHand) {
				handleInHandTick(player, stack);
			} else {
				handleInInventoryTick(player, stack);
			}
		}
	}

	// 物品实体更新（掉落在地上时）
	@Override
	public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
		Level level = entity.level();

		if (!level.isClientSide) {
			attractEntitiesToLookAtItem(level, entity);
		}

		return super.onEntityItemUpdate(stack, entity);
	}

	// 在手中
	private void handleInHandTick(Player player, ItemStack stack) {
		if (player.tickCount % 5 == 0) {
			ProgressTransfurExt.tf(player, 1f, "goodblock:form_latex_crystal_jelly_dragon", TransfurCause.FACE_HAZARD);
			player.displayClientMessage(Component.literal("你感到身体不适").withStyle((style -> {
				Style returnStyle = style.withColor(ChatFormatting.BLUE);
				returnStyle = returnStyle.withItalic(true);
				return returnStyle;
			})), true);
		}
	}

	// 在背包
	private void handleInInventoryTick(Player player, ItemStack stack) {
		ProgressTransfurExt.tf(player, 0.1f, "goodblock:form_latex_crystal_jelly_dragon", TransfurCause.FACE_HAZARD);
		GoodblockModVariables.PlayerVariables data = PlayerDataGetHelper.get(player);
		data.Crystal_Jelly_Infection = true;
	}

	/**
	 * 吸引范围内的生物看向掉落的物品
	 * 使用 HypnosisAbility 中的 CameraUtil.tugEntityLookDirection
	 */
	private void attractEntitiesToLookAtItem(Level level, ItemEntity itemEntity) {
		if (itemEntity == null || !itemEntity.isAlive() || level == null) {
			return;
		}

		AABB bounds = AABB.ofSize(itemEntity.position(), ATTRACT_RADIUS, ATTRACT_RADIUS, ATTRACT_RADIUS);

		level.getEntitiesOfClass(Player.class, bounds, player -> {
			return player != itemEntity.getOwner() &&
					player.isAlive() &&
					player.distanceToSqr(itemEntity) <= ATTRACT_RADIUS * ATTRACT_RADIUS;
		}).forEach(player -> {
			try {
				// 计算玩家到物品的方向向量
				Vec3 direction = itemEntity.position().subtract(player.position()).normalize();
				// 使用 Vec3 版本的方法
				CameraUtil.tugEntityLookDirection(player, direction, LOOK_STRENGTH);
			} catch (Exception ignored) {}
		});
	}
}