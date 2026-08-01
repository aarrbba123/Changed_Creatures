package net.hhdsj.goodblock.item;

import net.hhdsj.goodblock.init.GoodblockModMobEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class LatexLavaCrystalItem extends Item {
    public LatexLavaCrystalItem() {
        super(new Properties().stacksTo(64).rarity(Rarity.RARE).fireResistant().food(new FoodProperties.Builder()
                .nutrition(4)
                .saturationMod(2f)
                .alwaysEat()
                .effect(() -> new MobEffectInstance(GoodblockModMobEffects.SLOWINFECTION.get(), 200, 0), 1.0f)
                .effect(() -> new MobEffectInstance(GoodblockModMobEffects.LAVA_BURN.get(), 200, 0), 1.0f)
                .build()
        ));
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("item.goodblock.latex_lava_crystal.desc1").withStyle(ChatFormatting.RED));
        list.add(Component.translatable("item.goodblock.latex_lava_crystal.desc2").withStyle(ChatFormatting.DARK_RED));
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return 18000;
    }


}
