package net.hhdsj.goodblock.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Objects;

public class LatexCrystalJellyItem extends AbstractCamItem {


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


}