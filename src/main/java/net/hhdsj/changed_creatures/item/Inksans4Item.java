package net.hhdsj.changed_creatures.item;

import net.hhdsj.changed_creatures.init.ChangedCreatureModSounds;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class Inksans4Item extends RecordItem {
	public Inksans4Item() {
		super(13,  // 红石比较器输出信号
				ChangedCreatureModSounds.INK_SANS.get(),
				new Item.Properties().stacksTo(1).rarity(Rarity.RARE),
				10000);  // 时长（秒）
	}
}