
/*
 *    这些为注册类,请将注册写在这里,而不是其它地方!
 */
package net.hhdsj.changed_creatures.init;

import net.minecraft.world.inventory.MenuType;

import net.hhdsj.changed_creatures.world.inventory.FINDGUIMenu;
import net.hhdsj.changed_creatures.world.inventory.CatalyzerguiMenu;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.hhdsj.changed_creatures.ChangedCreature;
/*
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChangedCreatureModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<FINDGUIMenu> FINDGUI = register("findgui", (id, inv, extraData) -> new FINDGUIMenu(id, inv, extraData));
	public static final MenuType<CatalyzerguiMenu> CATALYZERGUI = register("catalyzergui", (id, inv, extraData) -> new CatalyzerguiMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}*/



public class ChangedCreatureModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ChangedCreature.MODID);
	public static final RegistryObject<MenuType<CatalyzerguiMenu>> CATALYZERGUI = REGISTRY.register("catalyzergui", () -> IForgeMenuType.create(CatalyzerguiMenu::new));
	public static final RegistryObject<MenuType<FINDGUIMenu>> FINDGUI = REGISTRY.register("findgui", () -> IForgeMenuType.create(FINDGUIMenu::new));
}
