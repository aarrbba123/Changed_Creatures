package net.hhdsj.goodblock.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
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
        super(new Properties().stacksTo(64).rarity(Rarity.RARE).fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.literal("一种流淌的胶液的水晶").withStyle(ChatFormatting.RED));
        list.add(Component.literal("人类触碰不宜触碰").withStyle(ChatFormatting.DARK_RED));
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return 1800;
    }
}
