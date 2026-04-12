
/*
 *    这些为注册类,请将注册写在这里,而不是其它地方!
 */
package net.hhdsj.goodblock.init;

import net.hhdsj.goodblock.client.armor.ArmorLatexMaleWolfWingedDragonModel;
import net.hhdsj.goodblock.client.model.boss.ModelLatexIceFieldWolfDragonBoss;
import net.hhdsj.goodblock.client.model.boss.ModelLatexNightOwl;
import net.hhdsj.goodblock.client.model.boss.ModelLatexNightOwlBoss;
import net.hhdsj.goodblock.client.model.latex_dragon.*;
import net.hhdsj.goodblock.client.model.latex_fox.ModelLatexOrangeFox;
import net.hhdsj.goodblock.client.model.latex_fox.ModelLatexRadiationFox;
import net.hhdsj.goodblock.client.model.latex_pup.ModelInksuger;
import net.hhdsj.goodblock.client.model.latex_pup.Modelblackpupmale;
import net.hhdsj.goodblock.client.model.latex_pup.Modelwhitebluepup;
import net.hhdsj.goodblock.client.model.latex_shark.ModelLatexKcahraShark;
import net.hhdsj.goodblock.client.model.latex_taur.ModelLatexDarkPurpleDragonTaur;
import net.hhdsj.goodblock.client.model.latex_wolf.*;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorModelSet;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorNoTailModel;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorNoneModel;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import java.util.Objects;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class GoodblockModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelLatexOrangeFox.LAYER_LOCATION, ModelLatexOrangeFox::createBodyLayer);
		event.registerLayerDefinition(Modelbluedragon.LAYER_LOCATION, Modelbluedragon::createBodyLayer);
		event.registerLayerDefinition(ModelLatexKcahraShark.LAYER_LOCATION, ModelLatexKcahraShark::createBodyLayer);
		event.registerLayerDefinition(ModelLatexicedragon.LAYER_LOCATION, ModelLatexicedragon::createBodyLayer);
		event.registerLayerDefinition(DarkfuLatexWolfMale.LAYER_LOCATION, DarkfuLatexWolfMale::createBodyLayer);
		event.registerLayerDefinition(ModelInksuger.LAYER_LOCATION, ModelInksuger::createBodyLayer);
		event.registerLayerDefinition(ModelIceFieldWolfDragon.LAYER_LOCATION, ModelIceFieldWolfDragon::createBodyLayer);
		event.registerLayerDefinition(Modelwhitebluepup.LAYER_LOCATION, Modelwhitebluepup::createBodyLayer);
		event.registerLayerDefinition(Modelblackpupmale.LAYER_LOCATION, Modelblackpupmale::createBodyLayer);
		event.registerLayerDefinition(ModelLatexpurplewswolf.LAYER_LOCATION, ModelLatexpurplewswolf::createBodyLayer);
		event.registerLayerDefinition(Modellatexyunxqhotdragon.LAYER_LOCATION, Modellatexyunxqhotdragon::createBodyLayer);
		event.registerLayerDefinition(ModelLatexthreemonthwolf.LAYER_LOCATION, ModelLatexthreemonthwolf::createBodyLayer);
		event.registerLayerDefinition(ModelLatexDragonFruitWolf.LAYER_LOCATION, ModelLatexDragonFruitWolf::createBodyLayer);
		event.registerLayerDefinition(ModelLatexYunQiIceDragon.LAYER_LOCATION, ModelLatexYunQiIceDragon::createBodyLayer);
		event.registerLayerDefinition(ModelLatexiceredDragonUnified_bw.LAYER_LOCATION, ModelLatexiceredDragonUnified_bw::createBodyLayer);
		event.registerLayerDefinition(ModelLatexRadiationFox.LAYER_LOCATION, ModelLatexRadiationFox::createBodyLayer);
		event.registerLayerDefinition(ModelLatexPurpleCoocWolf.LAYER_LOCATION, ModelLatexPurpleCoocWolf::createBodyLayer);
		event.registerLayerDefinition(ModelLatexNightOwlBoss.LAYER_LOCATION, ModelLatexNightOwlBoss::createBodyLayer);
		event.registerLayerDefinition(ModelLatexNightOwl.LAYER_LOCATION, ModelLatexNightOwl::createBodyLayer);
		event.registerLayerDefinition(ModelLatexIqGoldDragon.LAYER_LOCATION, ModelLatexIqGoldDragon::createBodyLayer);
		event.registerLayerDefinition(ModelLatexDarkPurpleDragonTaur.LAYER_LOCATION, ModelLatexDarkPurpleDragonTaur::createBodyLayer);
		event.registerLayerDefinition(ModelDarkPurpleLatexDragon.LAYER_LOCATION, ModelDarkPurpleLatexDragon::createBodyLayer);
		event.registerLayerDefinition(ModelLatexIceFieldWolfDragonBoss.LAYER_LOCATION, ModelLatexIceFieldWolfDragonBoss::createBodyLayer);
		event.registerLayerDefinition(ModelLuoHongEarlySpringFoxDragon.LAYER_LOCATION, ModelLuoHongEarlySpringFoxDragon::createBodyLayer);
		event.registerLayerDefinition(ModelLatexFruitDragonWolf.LAYER_LOCATION, ModelLatexFruitDragonWolf::createBodyLayer);
		event.registerLayerDefinition(ModelNeondimnessWolf.LAYER_LOCATION, ModelNeondimnessWolf::createBodyLayer);
		event.registerLayerDefinition(ModelLatexChengXi.LAYER_LOCATION, ModelLatexChengXi::createBodyLayer);
		ArmorLatexMaleWolfWingedDragonModel.MODEL_SET.registerDefinitions(event::registerLayerDefinition);
	}
}
