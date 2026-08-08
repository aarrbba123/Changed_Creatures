/*
 *    这些为注册类,请将注册写在这里,而不是其它地方!
 */
package net.hhdsj.goodblock.init;

import net.hhdsj.goodblock.GoodblockMod;
import net.ltxprogrammer.changed.init.ChangedItems;
import net.minecraft.client.model.PufferfishSmallModel;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GoodblockModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GoodblockMod.MODID);

	public static final RegistryObject<CreativeModeTab> WORLDBLOCK = REGISTRY.register("goodblock_block",
			() -> CreativeModeTab.builder()
					.title(Component.translatable("item_group.goodblock.worldblock"))
					.icon(() -> new ItemStack(GoodblockModItems.LATEX_DEEP_CRYSTAL_DRAGON_DOLL.get()))
					.build());

	public static final RegistryObject<CreativeModeTab> GOODBLOCK_ENTITY = REGISTRY.register("goodblock_entity",
			() -> CreativeModeTab.builder()
					.title(Component.translatable("item_group.goodblock.goodblock_entity"))
					.icon(() -> new ItemStack(ChangedItems.DARK_LATEX_MASK.get()))
					.build());

	// 所有物品通过事件添加到对应的标签页
	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == WORLDBLOCK.getKey()) {
			// 方块
			tabData.accept(GoodblockModBlocks.SULPHURBLOCK.get().asItem());
			tabData.accept(GoodblockModBlocks.NITREBLOCK.get().asItem());
			tabData.accept(GoodblockModBlocks.URANIUM_ORE.get().asItem());
			tabData.accept(GoodblockModBlocks.PALE_WOOD_PLANKS.get().asItem());
			tabData.accept(GoodblockModBlocks.PALE_WOOD_LEAVES.get().asItem());
			tabData.accept(GoodblockModBlocks.PALE_WOOD_LOG.get().asItem());
			tabData.accept(GoodblockModBlocks.PALE_WOOD_WOOD.get().asItem());
			tabData.accept(GoodblockModBlocks.URANIUMBLOCK.get().asItem());
			tabData.accept(GoodblockModBlocks.BLUEBLOCK.get().asItem());
			tabData.accept(GoodblockModBlocks.IRONHOT.get().asItem());
			tabData.accept(GoodblockModBlocks.PALE_WOOD_STAIRS.get().asItem());
			tabData.accept(GoodblockModBlocks.PALE_WOOD_SLAB.get().asItem());
			tabData.accept(GoodblockModBlocks.PALE_WOOD_BUTTON.get().asItem());
			tabData.accept(GoodblockModBlocks.BLOCKBW_1.get().asItem());
			tabData.accept(GoodblockModBlocks.BLOCKBW_2.get().asItem());
			tabData.accept(GoodblockModBlocks.BLUE_CRYSTALORE.get().asItem()); // 修复：添加到标签页
			tabData.accept(GoodblockModBlocks.CATALYZER.get().asItem()); // 修复：添加到标签页
			tabData.accept(GoodblockModBlocks.LATEX_CRYSTAL_JELLY_GAS_CANISTER.get().asItem());
			tabData.accept(GoodblockModBlocks.CRYO_SUBJECT_CHAMBER.get().asItem());
			tabData.accept(GoodblockModBlocks.LATEX_DEEP_CRYSTAL_DRAGON_DOLL.get().asItem());
			// 物品
			tabData.accept(GoodblockModItems.SULPHUR.get());
			tabData.accept(GoodblockModItems.NITRICACID.get());
			tabData.accept(GoodblockModItems.IMPUREURANIUM.get());
			tabData.accept(GoodblockModItems.IMPUREURANIUMINGOT.get());
			tabData.accept(GoodblockModItems.PAINITESWORD.get());
			tabData.accept(GoodblockModItems.PAINITEMANUSCRIPT.get());
			tabData.accept(GoodblockModItems.PAINITEAXE.get());
			tabData.accept(GoodblockModItems.PAINITEHOE.get());
			tabData.accept(GoodblockModItems.PAINITESHOVEL.get());
			tabData.accept(GoodblockModItems.CURSED_SCYTHE.get());
			//tabData.accept(GoodblockModItems.THEFLUFFYHEARTBEATINTHECUBICLEMUSIC.get());
			//tabData.accept(GoodblockModItems.FLUTEMUSICA_1RECORDS.get());
			//tabData.accept(GoodblockModItems.NOTLISTENTHIS.get());
			//tabData.accept(GoodblockModItems.FLUTE.get());
			//tabData.accept(GoodblockModItems.ANITFRRYMUSIC.get());
			tabData.accept(GoodblockModItems.Impure_Frost_Condensed_Crystal_Cluster.get());
			tabData.accept(GoodblockModItems.Frost_Condensed_Crystal_Cluster.get());
			tabData.accept(GoodblockModItems.Latex_Night_Owl_Goo_Item.get());
			tabData.accept(GoodblockModItems.DRAGONFRUIT.get());
			tabData.accept(GoodblockModItems.BlueCrystaloreItem.get());
			tabData.accept(GoodblockModItems.PALETREE.get());
			//tabData.accept(GoodblockModItems.INKSANS_4.get());
			tabData.accept(GoodblockModItems.LatexCrystalJellyItem.get());

			tabData.accept(GoodblockModItems.LATEX_LAVA_CRYSTAL.get());
			//tabData.accept(GoodblockModItems.LATEX_CRYSTAL_JELLY_GAS_CANISTER.get());

			tabData.accept(GoodblockModItems.PAINITE_ARMOR_HELMET.get());
			tabData.accept(GoodblockModItems.PAINITE_ARMOR_CHESTPLATE.get());
			tabData.accept(GoodblockModItems.PAINITE_ARMOR_LEGGINGS.get());
			tabData.accept(GoodblockModItems.PAINITE_ARMOR_BOOTS.get());

			// 液体桶
			//tabData.accept(GoodblockModItems.FLUIDHOTTEST_BUCKET.get());
		}

		// 自定义标签页：GOODBLOCK_ENTITY
		else if (tabData.getTabKey() == GOODBLOCK_ENTITY.getKey()) {

		}

		// 原版标签页
		else if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(GoodblockModBlocks.BLACKBLOCK.get().asItem());
		}
		else if (tabData.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
			tabData.accept(GoodblockModBlocks.PALE_WOOD_FENCE_GATE.get().asItem());
			tabData.accept(GoodblockModBlocks.PALE_WOOD_PRESSURE_PLATE.get().asItem());
		}
		else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {

		}
		else if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(GoodblockModBlocks.PALE_WOOD_FENCE.get().asItem());
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