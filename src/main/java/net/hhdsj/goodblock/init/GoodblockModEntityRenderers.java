
/*
 *    这些为注册类,请将注册写在这里,而不是其它地方!
 */
package net.hhdsj.goodblock.init;

import net.hhdsj.goodblock.block.CryoSubjectChamberRenderer;
import net.hhdsj.goodblock.client.renderer.ProtogenNyxarixRenderer;
import net.hhdsj.goodblock.client.renderer.boss.LatexNightOwlBossRenderer;
import net.hhdsj.goodblock.client.renderer.boss.LatexNightOwlRenderer;
import net.hhdsj.goodblock.client.renderer.cat.LatexBlueveCatRenderer;
import net.hhdsj.goodblock.client.renderer.latex_dragon.*;
import net.hhdsj.goodblock.client.renderer.latex_fox.*;
import net.hhdsj.goodblock.client.renderer.latex_pup.BlackpupmaleRenderer;
import net.hhdsj.goodblock.client.renderer.latex_pup.InksugerRenderer;
import net.hhdsj.goodblock.client.renderer.latex_pup.WhitebluepupRenderer;
import net.hhdsj.goodblock.client.renderer.latex_shark.LatexEnkangDragonSharkRenderer;
import net.hhdsj.goodblock.client.renderer.latex_shark.LatexKcahraSharkRenderer;
import net.hhdsj.goodblock.client.renderer.latex_shark.LatexQianGuiSharkRenderer;
import net.hhdsj.goodblock.client.renderer.latex_taur.LatexDarkPurpleDragonTaurRenderer;
import net.hhdsj.goodblock.client.renderer.latex_taur.LatexFrostScaleDragonTaurRenderer;
import net.hhdsj.goodblock.client.renderer.latex_wolf.*;
import net.hhdsj.goodblock.client.renderer.projectile.BlueCrystalProjectileRenderer;
import net.hhdsj.goodblock.client.renderer.projectile.CrystalArrowRenderer;
import net.hhdsj.goodblock.client.renderer.projectile.LatexArrowRenderer;
import net.hhdsj.goodblock.client.renderer.projectile.ThrownCrystalJavelinTridentRenderer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GoodblockModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(GoodblockModEntities.LATEX_ORANGE_FOX.get(), LatexOrangeFoxRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEX_KCAHRA_SHARK.get(), LatexKcahraSharkRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.DARKFU_LATEX_WOLF_MALE.get(), DarkfuLatexWolfMaleRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXICE_DRAGON.get(), LatexiceDragonRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.INKSUGER.get(), InksugerRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.BLACKPUPMALE.get(), BlackpupmaleRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.WHITEBLUEPUP.get(), WhitebluepupRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXPURPLEWSWOLF.get(), LatexpurplewswolfRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXTHREEMONTHWOLF.get(), LatexthreemonthwolfRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXYUNXQHOTDRAGON.get(), LatexyunxqhotdragonRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXYUNXQICEDRAGON.get(), LatexyunxqicedragonRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXBLUEDRAGON.get(), LatexbluedragonRenderer::new);
		//event.registerEntityRenderer(GoodblockModEntities.LATEX_ICE_FIELD_WOLF_DRAGON.get(), LatexIceFieldWolfDragonRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXPRTPLECOOCWOLF.get(), LatexPurpleCoocWolfRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXTHREEMONTHWOLF_PROJECTILE.get(), LatexArrowRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXYUNQIICEDRAGON.get(), LatexYunQiIceDragonRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXRADIATIONFOX.get(), LatexRadiationFoxRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXNIGHTOWLDRAGONBOSS.get(), LatexNightOwlBossRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXNIGHTOWLDRAGON.get(), LatexNightOwlRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXIQGOLDDRAGON.get(), LatexIqGoldDragonRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXDARKPURPLEDRAGONTAUR.get(), LatexDarkPurpleDragonTaurRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXDARKPURPLEDRAGON.get(), LatexDarkPurpleDragonRenderer::new);
		//event.registerEntityRenderer(GoodblockModEntities.LATEX_ICE_FIELD_WOLF_DRAGON_BOSS.get(), LatexIceFieldWolfDragonBossRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXLUOHONGEARLYSPRINGFOXDRAGON.get(), LatexLuoHongEarlySpringFoxDragonRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXFRUITDRAGONWOLF.get(), LatexFruitDragonRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXNEONDIMNESSWOLF.get(), LatexNeondimnessWolfRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEX_CHENG_XI.get(), LatexChengXiRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXYAOLINGDRAGON.get(),LatexYaoLingDragonRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEX_DIVINE_SWORD_KITSUNE.get(), LatexDivineSwordKitsuneRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.BLUECRYSTALPROJECTILE.get(), BlueCrystalProjectileRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.CRYSTAL_ARROW.get(), CrystalArrowRenderer::new);

		event.registerEntityRenderer(GoodblockModEntities.THROWN_CRYSTAL_JAVELIN.get(), ThrownCrystalJavelinTridentRenderer::new);

		event.registerEntityRenderer(GoodblockModEntities.LATEX_YUE_XI_FOX_FEMALE.get(), LatexYueXiFoxFemaleRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEX_GAO_HUI_FOX.get(), LatexGaoHuiFoxRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEX_DAWN_WOLF.get(), LatexDawnWolfRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEX_ENKANG_DRAGON_SHARK.get(), LatexEnkangDragonSharkRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEX_HYAZINTHE_FOX.get(), LatexHyazintheFoxRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEX_BLUEVE_CAT.get(), LatexBlueveCatRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEX_QIAN_GUI_SHARK.get(), LatexQianGuiSharkRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEX_FLORA_FOX.get(), LatexFloraFoxRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LUOLONG_DRAGON_SHARK.get(), LatexLuoLongDragonSharkRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEX_DUSK_DAWN_DRAGON.get(), LatexDuskDawnDragonRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEX_DUSK_DAWN_DRAGON_FEMALE.get(), LatexDuskDawnDragonFemaleRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEX_CRYSTAL_JELLY.get(), LatexCrystalJellyDragonRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEX_FROST_SCALE_DRAGON_TAUR.get(), LatexFrostScaleDragonTaurRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEX_EMBERSCALES_MAGMA_DRAGON_MALE.get(), LatexEmberscalesMagmaDragonMaleRenderer::new);
		//ModelLatexEtanKind
		event.registerEntityRenderer(GoodblockModEntities.LATEX_ETAN_KIND.get(), LatexEtanKingRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.PROTOGEN_NYXARIX.get(), ProtogenNyxarixRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEX_STEPPEN_WOLF.get(), LatexSteppenWolfRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEX_PEAUNT_BUTTER_WOLF.get(), LatexPeanutButterWolfRenderer::new);

	}
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(GoodblockModBlocks.CRYO_SUBJECT_CHAMBER_BE.get(), CryoSubjectChamberRenderer::new);
	}
}
