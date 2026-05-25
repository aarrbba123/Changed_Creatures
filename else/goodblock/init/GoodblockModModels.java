
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.hhdsj.goodblock.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.hhdsj.goodblock.client.renderer.models.ModelProtoTypeMob;
import net.hhdsj.goodblock.client.renderer.models.ModelNoNameMob;
import net.hhdsj.goodblock.client.renderer.models.ModelLatexPurpleFoxUnified;
import net.hhdsj.goodblock.client.renderer.models.ModelDarkLatexYufengUnified;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class GoodblockModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelDarkLatexYufengUnified.LAYER_LOCATION, ModelDarkLatexYufengUnified::createBodyLayer);
		event.registerLayerDefinition(ModelProtoTypeMob.LAYER_LOCATION, ModelProtoTypeMob::createBodyLayer);
		event.registerLayerDefinition(ModelNoNameMob.LAYER_LOCATION, ModelNoNameMob::createBodyLayer);
		event.registerLayerDefinition(ModelLatexPurpleFoxUnified.LAYER_LOCATION, ModelLatexPurpleFoxUnified::createBodyLayer);
	}
}
