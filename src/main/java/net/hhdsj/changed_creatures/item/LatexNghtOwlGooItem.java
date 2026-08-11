package net.hhdsj.changed_creatures.item;

import net.foxyas.changedaddon.init.ChangedAddonItems;
import net.ltxprogrammer.changed.init.ChangedItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class LatexNghtOwlGooItem extends Item {

    public LatexNghtOwlGooItem() {
        super(new Properties().stacksTo(4).rarity(Rarity.RARE));
    }

    // 文本
    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("item.changed_creatures.latex_night_owl_goo.desc1").withStyle(ChatFormatting.RED));
    }
}
