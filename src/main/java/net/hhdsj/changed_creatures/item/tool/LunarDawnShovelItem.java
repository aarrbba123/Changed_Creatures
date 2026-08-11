
package net.hhdsj.changed_creatures.item.tool;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class LunarDawnShovelItem extends ShovelItem {
	public LunarDawnShovelItem() {
		super(new Tier() {
			public int getUses() {
				return 4320;
			}

			public float getSpeed() {
				return 13f;
			}

			public float getAttackDamageBonus() {
				return -1f;
			}

			public int getLevel() {
				return 2;
			}

			public int getEnchantmentValue() {
				return 20;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.NETHERITE_INGOT));
			}
		}, 1, -3f, new Properties().fireResistant());
	}
}
