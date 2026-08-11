
package net.hhdsj.changed_creatures.item;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class AnitfrrymusicItem extends RecordItem {
	public AnitfrrymusicItem() {
		super(15, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("changed_creatures:anit_furry_music")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 100);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}
}
/*
public class AnitfrrymusicItem extends RecordItem {
	public AnitfrrymusicItem() {
		super(15, ChangedCreatureModSounds.REGISTRY.get(new ResourceLocation("changed_creatures:anit_furry_music")), new Item.Properties().tab(ChangedCreatureModTabs.TAB_WORLDBLOCK).stacksTo(1).rarity(Rarity.RARE));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}
}
*/