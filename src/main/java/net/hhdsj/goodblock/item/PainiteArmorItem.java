package net.hhdsj.goodblock.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public abstract class PainiteArmorItem extends ArmorItem {
	public PainiteArmorItem(ArmorItem.Type type, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForType(ArmorItem.@NotNull Type type) {
				// 使用明确的类型判断
                return switch (type) {
                    case HELMET -> 13 * 45;  // 头盔耐久
                    case CHESTPLATE -> 15 * 45;  // 胸甲耐久
                    case LEGGINGS -> 16 * 45;  // 护腿耐久
                    case BOOTS -> 11 * 45;  // 靴子耐久
                    default -> 0;
                };
			}

			@Override
			public int getDefenseForType(ArmorItem.@NotNull Type type) {
				// 使用明确的类型判断
                return switch (type) {
                    case HELMET -> 3;  // 头盔防御
                    case CHESTPLATE -> 6;  // 胸甲防御
                    case LEGGINGS -> 8;  // 护腿防御
                    case BOOTS -> 3;  // 靴子防御
                    default -> 0;
                };
			}

			@Override
			public int getEnchantmentValue() {
				return 50;
			}

			@Override
			public @NotNull SoundEvent getEquipSound() {
				// 添加安全处理
				SoundEvent sound = ForgeRegistries.SOUND_EVENTS.getValue(
						new ResourceLocation("goodblock:item.armor.equip_netherite")
				);
				return sound != null ? sound : SoundEvents.ARMOR_EQUIP_NETHERITE;
			}

			@Override
			public @NotNull Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.NETHERITE_INGOT));
			}

			@Override
			public @NotNull String getName() {
				return "painite_armor";
			}

			@Override
			public float getToughness() {
				return 3f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.1f;
			}
		}, type, properties);
	}

	// 确保getEquipmentSlot方法正确返回槽位
	@Override
	public @NotNull EquipmentSlot getEquipmentSlot() {
		// 根据ArmorItem.Type返回正确的EquipmentSlot
		return this.type.getSlot();
	}

	public static class Helmet extends PainiteArmorItem {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties().fireResistant().stacksTo(1));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "goodblock:textures/models/armor/painite_layer_1.png";
		}
	}

	public static class Chestplate extends PainiteArmorItem {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().stacksTo(1));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "goodblock:textures/models/armor/painite_layer_1.png";
		}
	}

	public static class Leggings extends PainiteArmorItem {
		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().stacksTo(1));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "goodblock:textures/models/armor/painite_layer_2.png";
		}
	}

	public static class Boots extends PainiteArmorItem {
		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().stacksTo(1));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "goodblock:textures/models/armor/painite_layer_1.png";
		}
	}
}