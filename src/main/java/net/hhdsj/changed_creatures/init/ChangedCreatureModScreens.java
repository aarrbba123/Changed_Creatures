
/*
 *    这些为注册类,请将注册写在这里,而不是其它地方!
 * 					屏幕
 */
package net.hhdsj.changed_creatures.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.hhdsj.changed_creatures.client.gui.FINDGUIScreen;
//import net.hhdsj.changed_creatures.client.gui.CatalyzerguiScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ChangedCreatureModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(ChangedCreatureModMenus.FINDGUI.get(), FINDGUIScreen::new);
			//MenuScreens.register(ChangedCreatureModMenus.CATALYZERGUI.get(), CatalyzerguiScreen::new);
		});
	}
}
