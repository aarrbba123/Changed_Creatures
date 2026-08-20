package net.hhdsj.changed_creatures.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.hhdsj.changed_creatures.network.KeyMessage;
import net.hhdsj.changed_creatures.ChangedCreature;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ChangedCreatureModKeyMappings {
	public static final KeyMapping KEYA = new KeyMapping("key.changed_creatures.keya", GLFW.GLFW_KEY_P, "key.categories.ui") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ChangedCreature.PACKET_HANDLER.sendToServer(new KeyMessage(0, 0));
                if (Minecraft.getInstance().player != null) {
                    KeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
                }
            }
			isDownOld = isDown;
		}
	};

	public static final KeyMapping ELYTRA_FLY = new KeyMapping("key.changed_creatures.keya", GLFW.GLFW_KEY_G, "key.categories.ui") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ChangedCreature.PACKET_HANDLER.sendToServer(new KeyMessage(2, 0));
				if (Minecraft.getInstance().player != null) {
					KeyMessage.pressAction(Minecraft.getInstance().player, 2, 0);
				}
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(ELYTRA_FLY);
		event.register(KEYA);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				KEYA.consumeClick();
				ELYTRA_FLY.consumeClick();
			}
		}
	}
}