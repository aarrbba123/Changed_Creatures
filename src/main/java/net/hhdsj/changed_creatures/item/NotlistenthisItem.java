
package net.hhdsj.changed_creatures.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.hhdsj.changed_creatures.init.ChangedCreatureModSounds;

public class NotlistenthisItem extends RecordItem {
	public NotlistenthisItem() {
		super(0, ChangedCreatureModSounds.ANIT_FURRY_MUSIC.get(), new Item.Properties().stacksTo(1).rarity(Rarity.RARE),100);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}
}
