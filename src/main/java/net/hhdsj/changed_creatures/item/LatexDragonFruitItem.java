package net.hhdsj.changed_creatures.item;

import net.hhdsj.changed_creatures.init.ChangedCreatureModMobEffects;
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
					ChangedCreatureModMobEffects.SLOWINFECTION.get(),
					3200,
					0
			), 0.3f)
			.build()));
	}

	@Override
	public void appendHoverText(@NotNull ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.translatable("item.changed_creatures.latex_dragon_fruit.desc1").withStyle(ChatFormatting.BLUE));
		list.add(Component.translatable("item.changed_creatures.latex_dragon_fruit.desc2").withStyle(ChatFormatting.RED));
	}
}
