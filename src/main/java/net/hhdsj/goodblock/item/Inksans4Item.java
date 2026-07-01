package net.hhdsj.goodblock.item;

import net.hhdsj.goodblock.init.GoodblockModSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class Inksans4Item extends RecordItem {
	public Inksans4Item() {
		super(13,  // 红石比较器输出信号
				GoodblockModSounds.INK_SANS.get(),
				new Item.Properties().stacksTo(1).rarity(Rarity.RARE),
				10000);  // 时长（秒）
	}
}