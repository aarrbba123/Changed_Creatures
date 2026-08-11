
package net.hhdsj.changed_creatures.item;

import net.hhdsj.changed_creatures.util.ProgressTransfurExt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

public class ImpureuraniumingotItem extends Item {
	public ImpureuraniumingotItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			ProgressTransfurExt.execute((LivingEntity) entity,"changed_creatures:form_latex_radiation_fox");
	}
}
