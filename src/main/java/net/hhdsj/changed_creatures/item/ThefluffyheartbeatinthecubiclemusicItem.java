
package net.hhdsj.changed_creatures.item;

import net.hhdsj.changed_creatures.init.ChangedCreatureModSounds;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ThefluffyheartbeatinthecubiclemusicItem extends RecordItem {
	public ThefluffyheartbeatinthecubiclemusicItem() {
		// 方法1：使用RegistryObject（推荐）
		super(1,
				ChangedCreatureModSounds.THE_FLUFFY_HEARTBEAT_IN_THE_CUBICLE.get(),
				new Item.Properties()
						.stacksTo(1)
						.rarity(Rarity.RARE),
				2400); // 2400 ticks = 2分钟
	}
}
