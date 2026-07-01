package net.hhdsj.goodblock.item;

import net.hhdsj.goodblock.init.GoodblockModMobEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public class LatexDragonFruitItem extends Item {
	public LatexDragonFruitItem() {
		super(new Item.Properties()
			.stacksTo(64)
			.rarity(Rarity.COMMON)
			.food((new FoodProperties.Builder())
			.nutrition(4)
			.saturationMod(1f)
			.alwaysEat()
			.effect(() -> new MobEffectInstance(
					GoodblockModMobEffects.SLOWINFECTION.get(),
					500,
					0
			), 0.3f)
			.build()));
	}

	@Override
	public void appendHoverText(@NotNull ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("流淌的胶液的食物").withStyle(ChatFormatting.BLUE));
		list.add(Component.literal("人类触碰不宜食用").withStyle(ChatFormatting.RED));
	}
}
