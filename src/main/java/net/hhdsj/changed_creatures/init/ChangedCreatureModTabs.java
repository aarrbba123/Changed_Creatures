/*
 *    这些为注册类,请将注册写在这里,而不是其它地方!
 */
package net.hhdsj.changed_creatures.init;

import net.hhdsj.changed_creatures.ChangedCreature;
import net.ltxprogrammer.changed.init.ChangedItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTabs;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChangedCreatureModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ChangedCreature.MODID);

	public static final RegistryObject<CreativeModeTab> WORLDBLOCK = REGISTRY.register("changed_creatures_block",
			() -> CreativeModeTab.builder()
					.title(Component.translatable("item_group.changed_creatures.worldblock"))
					.icon(() -> new ItemStack(ChangedCreatureModItems.LATEX_DEEP_CRYSTAL_DRAGON_DOLL.get()))
					.build());

	public static final RegistryObject<CreativeModeTab> GOODBLOCK_ENTITY = REGISTRY.register("changed_creatures_entity",
			() -> CreativeModeTab.builder()
					.title(Component.translatable("item_group.changed_creatures.changed_creatures_entity"))
					.icon(() -> new ItemStack(ChangedItems.DARK_LATEX_MASK.get()))
					.build());

	// 所有物品通过事件添加到对应的标签页
	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == WORLDBLOCK.getKey()) {
			// 方块
			tabData.accept(ChangedCreatureModBlocks.SULPHURBLOCK.get().asItem());
			tabData.accept(ChangedCreatureModBlocks.NITREBLOCK.get().asItem());
			tabData.accept(ChangedCreatureModBlocks.URANIUM_ORE.get().asItem());
			tabData.accept(ChangedCreatureModBlocks.PALE_WOOD_PLANKS.get().asItem());
			tabData.accept(ChangedCreatureModBlocks.PALE_WOOD_LEAVES.get().asItem());
			tabData.accept(ChangedCreatureModBlocks.PALE_WOOD_LOG.get().asItem());
			tabData.accept(ChangedCreatureModBlocks.PALE_WOOD_WOOD.get().asItem());
			tabData.accept(ChangedCreatureModBlocks.URANIUMBLOCK.get().asItem());
			tabData.accept(ChangedCreatureModBlocks.BLUEBLOCK.get().asItem());
			tabData.accept(ChangedCreatureModBlocks.IRONHOT.get().asItem());
			tabData.accept(ChangedCreatureModBlocks.PALE_WOOD_STAIRS.get().asItem());
			tabData.accept(ChangedCreatureModBlocks.PALE_WOOD_SLAB.get().asItem());
			tabData.accept(ChangedCreatureModBlocks.PALE_WOOD_BUTTON.get().asItem());
			tabData.accept(ChangedCreatureModBlocks.BLOCKBW_1.get().asItem());
			tabData.accept(ChangedCreatureModBlocks.BLOCKBW_2.get().asItem());
			tabData.accept(ChangedCreatureModBlocks.BLUE_CRYSTALORE.get().asItem()); // 修复：添加到标签页
			tabData.accept(ChangedCreatureModBlocks.CATALYZER.get().asItem()); // 修复：添加到标签页
			tabData.accept(ChangedCreatureModBlocks.LATEX_CRYSTAL_JELLY_GAS_CANISTER.get().asItem());
			tabData.accept(ChangedCreatureModBlocks.CRYO_SUBJECT_CHAMBER.get().asItem());
			tabData.accept(ChangedCreatureModBlocks.LATEX_DEEP_CRYSTAL_DRAGON_DOLL.get().asItem());
			// 物品
			tabData.accept(ChangedCreatureModItems.SULPHUR.get());
			tabData.accept(ChangedCreatureModItems.NITRICACID.get());
			tabData.accept(ChangedCreatureModItems.IMPUREURANIUM.get());
			tabData.accept(ChangedCreatureModItems.IMPUREURANIUMINGOT.get());
			tabData.accept(ChangedCreatureModItems.PAINITESWORD.get());
			tabData.accept(ChangedCreatureModItems.PAINITEMANUSCRIPT.get());
			tabData.accept(ChangedCreatureModItems.PAINITEAXE.get());
			tabData.accept(ChangedCreatureModItems.PAINITEHOE.get());
			tabData.accept(ChangedCreatureModItems.PAINITESHOVEL.get());
			tabData.accept(ChangedCreatureModItems.CURSED_SCYTHE.get());
			//tabData.accept(ChangedCreatureModItems.THEFLUFFYHEARTBEATINTHECUBICLEMUSIC.get());
			//tabData.accept(ChangedCreatureModItems.FLUTEMUSICA_1RECORDS.get());
			//tabData.accept(ChangedCreatureModItems.NOTLISTENTHIS.get());
			//tabData.accept(ChangedCreatureModItems.FLUTE.get());
			//tabData.accept(ChangedCreatureModItems.ANITFRRYMUSIC.get());
			tabData.accept(ChangedCreatureModItems.Impure_Frost_Condensed_Crystal_Cluster.get());
			tabData.accept(ChangedCreatureModItems.Frost_Condensed_Crystal_Cluster.get());
			tabData.accept(ChangedCreatureModItems.Latex_Night_Owl_Goo_Item.get());
			tabData.accept(ChangedCreatureModItems.DRAGONFRUIT.get());
			tabData.accept(ChangedCreatureModItems.BlueCrystaloreItem.get());
			tabData.accept(ChangedCreatureModItems.PALETREE.get());
			//tabData.accept(ChangedCreatureModItems.INKSANS_4.get());
			tabData.accept(ChangedCreatureModItems.LatexCrystalJellyItem.get());

			tabData.accept(ChangedCreatureModItems.LATEX_LAVA_CRYSTAL.get());
			//tabData.accept(ChangedCreatureModItems.LATEX_CRYSTAL_JELLY_GAS_CANISTER.get());

			tabData.accept(ChangedCreatureModItems.PAINITE_ARMOR_HELMET.get());
			tabData.accept(ChangedCreatureModItems.PAINITE_ARMOR_CHESTPLATE.get());
			tabData.accept(ChangedCreatureModItems.PAINITE_ARMOR_LEGGINGS.get());
			tabData.accept(ChangedCreatureModItems.PAINITE_ARMOR_BOOTS.get());

			// 液体桶
			//tabData.accept(ChangedCreatureModItems.FLUIDHOTTEST_BUCKET.get());
		}

		// 自定义标签页：GOODBLOCK_ENTITY
		else if (tabData.getTabKey() == GOODBLOCK_ENTITY.getKey()) {

		}

		// 原版标签页
		else if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(ChangedCreatureModBlocks.BLACKBLOCK.get().asItem());
		}
		else if (tabData.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
			tabData.accept(ChangedCreatureModBlocks.PALE_WOOD_FENCE_GATE.get().asItem());
			tabData.accept(ChangedCreatureModBlocks.PALE_WOOD_PRESSURE_PLATE.get().asItem());
		}
		else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {

		}
		else if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(ChangedCreatureModBlocks.PALE_WOOD_FENCE.get().asItem());
		}
		else if (tabData.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
			// 如果有功能性方块可以放这里
		}
		else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			// 如果有工具可以放这里
		}
		else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			// 如果有战斗用品可以放这里
		}
		else if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			// 如果有食物可以放这里
		}
		else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			// 如果有合成材料可以放这里
		}
	}
}