package net.hhdsj.changed_creatures.item;

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

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.translatable("item.changed_creatures.latex_crystal_jelly.desc1").withStyle(ChatFormatting.BLUE));
		list.add(Component.translatable("item.changed_creatures.latex_crystal_jelly.desc2").withStyle(ChatFormatting.BLUE));
		list.add(Component.translatable("item.changed_creatures.latex_crystal_jelly.desc3").withStyle(ChatFormatting.RED));
	}


}