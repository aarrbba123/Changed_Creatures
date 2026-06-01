package net.hhdsj.goodblock.registers;


import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.hhdsj.goodblock.client.models.ModelLatexOrangeFox;
import net.hhdsj.goodblock.client.models.ModelgreendragonUnified;
import net.hhdsj.goodblock.client.models.ModelLatexKcahraShark;
import net.hhdsj.goodblock.client.models.ModelLatexicedragon;
import net.hhdsj.goodblock.client.models.DarkfuLatexWolfMale;
import net.hhdsj.goodblock.client.models.ModelInksuger;
import net.hhdsj.goodblock.client.models.ModelLatexkamonaHSguydragonwolf;
import net.hhdsj.goodblock.client.models.Modelwhitebluepup;
import net.hhdsj.goodblock.client.models.Modelblackpupmale;
import net.hhdsj.goodblock.client.models.ModelLatexpurplewswolf;
import net.hhdsj.goodblock.client.models.Modellatexyunxqhotdragon;
import net.hhdsj.goodblock.client.models.ModelLatexthreemonthwolf;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class GoodblocksModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelLatexOrangeFox.LAYER_LOCATION, ModelLatexOrangeFox::createBodyLayer);
		event.registerLayerDefinition(ModelgreendragonUnified.LAYER_LOCATION, ModelgreendragonUnified::createBodyLayer);
		event.registerLayerDefinition(ModelLatexKcahraShark.LAYER_LOCATION, ModelLatexKcahraShark::createBodyLayer);
		event.registerLayerDefinition(ModelLatexicedragon.LAYER_LOCATION, ModelLatexicedragon::createBodyLayer);
		event.registerLayerDefinition(DarkfuLatexWolfMale.LAYER_LOCATION, DarkfuLatexWolfMale::createBodyLayer);
		event.registerLayerDefinition(ModelInksuger.LAYER_LOCATION, ModelInksuger::createBodyLayer);
		event.registerLayerDefinition(ModelLatexkamonaHSguydragonwolf.LAYER_LOCATION, ModelLatexkamonaHSguydragonwolf::createBodyLayer);
		event.registerLayerDefinition(Modelwhitebluepup.LAYER_LOCATION, Modelwhitebluepup::createBodyLayer);
		event.registerLayerDefinition(Modelblackpupmale.LAYER_LOCATION, Modelblackpupmale::createBodyLayer);
		event.registerLayerDefinition(ModelLatexpurplewswolf.LAYER_LOCATION, ModelLatexpurplewswolf::createBodyLayer);
		event.registerLayerDefinition(Modellatexyunxqhotdragon.LAYER_LOCATION, Modellatexyunxqhotdragon::createBodyLayer);
		event.registerLayerDefinition(ModelLatexthreemonthwolf.LAYER_LOCATION, ModelLatexthreemonthwolf::createBodyLayer);
	}
}
