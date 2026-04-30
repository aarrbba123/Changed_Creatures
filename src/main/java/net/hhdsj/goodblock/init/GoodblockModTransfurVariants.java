/*
 *    这些为注册类,请将注册写在这里,而不是其它地方!
 */
package net.hhdsj.goodblock.init;
//原版我的世界导入
import net.foxyas.changedaddon.init.ChangedAddonAbilities;
import net.hhdsj.goodblock.entity.boss.LatexNightOwlEntity;
import net.hhdsj.goodblock.entity.simple.*;
import net.minecraft.world.entity.monster.*;
//FORGE导入
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
//changed-mc mod导入
import net.ltxprogrammer.changed.entity.*;
import net.ltxprogrammer.changed.init.*;
import net.ltxprogrammer.changed.entity.variant.*;

//import net.foxyas.changedaddon.init.ChangedAddonAbilities;

import net.hhdsj.goodblock.entity.*;//推荐不要用*(来自hhdsj的话=))

import java.util.List;

public class GoodblockModTransfurVariants {
    public static final DeferredRegister<TransfurVariant<?>> REGISTRY = ChangedRegistry.TRANSFUR_VARIANT.createDeferred("goodblock");
	
    public static final RegistryObject<TransfurVariant<LatexOrangeFoxEntity>> LATEX_ORANGE_FOX = 
			REGISTRY.register("form_orange_fox", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEX_ORANGE_FOX)
				.nightVision()
				.transfurMode(TransfurMode.ABSORPTION)
				.addAbility(ChangedAddonAbilities.CLAWS)
				.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
				.build());

	public static final RegistryObject<TransfurVariant<LatexKcahraSharkEntity>> LATEX_KCAHRA_SHARK = 
			REGISTRY.register("form_latex_kcahra_shark", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEX_KCAHRA_SHARK)
				.gills()
				.breatheMode(TransfurVariant.BreatheMode.ANY)
				.transfurMode(TransfurMode.ABSORPTION)
				.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
				.replicating()
				.build());

	public static final RegistryObject<TransfurVariant<LatexbluedragonEntity>> LATEXBLUEDRAGON = 
			REGISTRY.register("form_blue_dragon", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXBLUEDRAGON)
				.glide()
				.transfurMode(TransfurMode.ABSORPTION)
				.replicating()
				.nightVision()
				.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
				.build());

	public static final RegistryObject<TransfurVariant<DarkfuLatexWolfMaleEntity>> DARKFU_LATEX_WOLF_MALE = 
			REGISTRY.register("form_darkfu_latex_wolf_male", () -> TransfurVariant.Builder.of(GoodblockModEntities.DARKFU_LATEX_WOLF_MALE)
				//.stepSize(0.7f)
				//.faction(ChangedLatexTypes.DARK_LATEX)
				.breatheMode(TransfurVariant.BreatheMode.NORMAL)
				.transfurMode(TransfurMode.ABSORPTION)
				.replicating()
				.build());

	public static final RegistryObject<TransfurVariant<LatexiceDragonEntity>> LATEXICE_DRAGON = 
			REGISTRY.register("form_latex_ice_dragon", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXICE_DRAGON)
				//.stepSize(0.7f)
				.nightVision()
				.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
				.replicating()
				.build());

	public static final RegistryObject<TransfurVariant<InksugerEntity>> INKSUGER = 
			REGISTRY.register("form_ink_suger", () -> TransfurVariant.Builder.of(GoodblockModEntities.INKSUGER)
				//.stepSize(0.7f)
				.nightVision()
				.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
				.transfurMode(TransfurMode.ABSORPTION)
				.holdItemsInMouth()
				//.reducedFall()
				.build());
	
	public static final RegistryObject<TransfurVariant<LatexIceFieldWolfDragonEntity>> LATEX_KAMONA_HSGUY_DRAGON_WOLF = 
			REGISTRY.register("form_latex_ice_field_wolf_dragon", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEX_ICE_FIELD_WOLF_DRAGON)
				.addAbility(ChangedAddonAbilities.DODGE)
				.nightVision()
				.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
				.addAbility(ChangedAddonAbilities.CLAWS)
				.transfurMode(TransfurMode.ABSORPTION)
				.replicating()
				.build());

	public static final RegistryObject<TransfurVariant<BlackpupmaleEntity>> BLACKPUPMALE = 
			REGISTRY.register("form_black_pup", () -> TransfurVariant.Builder.of(GoodblockModEntities.BLACKPUPMALE)
				//.stepSize(0.7f)
				.nightVision()
				.transfurMode(TransfurMode.NONE)
				.holdItemsInMouth()
				//.reducedFall()
				.build());

	public static final RegistryObject<TransfurVariant<WhitebluepupEntity>> WHITEBLUEPUP = 
			REGISTRY.register("form_white_blue_pup", () -> TransfurVariant.Builder.of(GoodblockModEntities.WHITEBLUEPUP)
				//.stepSize(0.7f)
				.nightVision()
				.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
				.holdItemsInMouth()
				//.reducedFall()
				.build());

	public static final RegistryObject<TransfurVariant<LatexpurplewswolfEntity>> LATEXPURPLEWSWOLF = 
			REGISTRY.register("form_latex_purplews_wolf", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXPURPLEWSWOLF)
				.addAbility(ChangedAddonAbilities.CLAWS)
				.scares(Creeper.class)
				.nightVision()
				.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
				.extraJumps(2)
				.build());
	
	public static final RegistryObject<TransfurVariant<LatexthreemonthwolfEntity>> LATEXTHREEMONTHWOLF = 
			REGISTRY.register("form_latex_three_month_wolf", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXTHREEMONTHWOLF)
				.addAbility(ChangedAddonAbilities.CLAWS)
				.scares(Creeper.class)
				.nightVision()
				.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
				.extraJumps(2)
				.build());

	public static final RegistryObject<TransfurVariant<LatexyunxqhotdragonEntity>> LATEXYUNXQHOTDRAGON = 
			REGISTRY.register("form_latex_yunxq_hot_dragon", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXYUNXQHOTDRAGON)
				//.stepSize(0.7f)
				.glide()
				.scares(List.of(Creeper.class))
				.addAbility(entityType -> ChangedAddonAbilities.WING_FLAP_ABILITY.get())
				.transfurMode(TransfurMode.ABSORPTION)
				.replicating()
				.nightVision()
				.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
				.build());

	public static final RegistryObject<TransfurVariant<LatexYaoLingDragonEntity>> LATEXYAOLINGDRAGON =
			REGISTRY.register("form_latex_yao_ling_dragon", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXYAOLINGDRAGON)
					//.stepSize(0.7f)
					.glide()
					.scares(List.of(Creeper.class))
					.addAbility(entityType -> ChangedAddonAbilities.WING_FLAP_ABILITY.get())
					.replicating()
					.nightVision()
					.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
					.build());

	public static final RegistryObject<TransfurVariant<LatexyunxqicedragonEntity>> LATEXYUNXQICEDRAGON = 
			REGISTRY.register("form_latex_yun_xq_ice_dragon", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXYUNXQICEDRAGON)
			//.stepSize(0.7f)
				.glide()
				.addAbility(entityType -> ChangedAddonAbilities.WING_FLAP_ABILITY.get())
				.transfurMode(TransfurMode.ABSORPTION)
				.replicating()
				.nightVision()
				.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
				.build());

	public static final RegistryObject<TransfurVariant<LatexPurplecoocwolfEntity>> LATEXPRTPLECOOCWOLF = 
			REGISTRY.register("form_latex_purple_cooc_wolf", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXPRTPLECOOCWOLF)
				//.stepSize(0.7f)
				.transfurMode(TransfurMode.ABSORPTION)
				.replicating()
				.nightVision()
				.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
				.build());

	//火龙果狼>?
	public static final RegistryObject<TransfurVariant<LatexDragonFruitWolfEntity>> LATEXDRAGONFRUITWOLF =
			REGISTRY.register("form_latex_dragon_fruit_wolf", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXDRAGONFRUITWOLF)
				//.stepSize(0.7f)
				.addAbility(entityType -> GoodblockModAbilities.CREATE_DRAGON_FRUIT.get())
				.transfurMode(TransfurMode.ABSORPTION)
				.replicating()
				.scares(Creeper.class)
				.nightVision()
				.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
				.build());

	public static final RegistryObject<TransfurVariant<LatexYunQiIceDragonEntity>> LATEXYUNQIICEDRAGON =
			REGISTRY.register("form_latex_yun_qi_ice_dragon", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXYUNQIICEDRAGON)
					//.stepSize(0.7f)
					.addAbility(entityType -> ChangedAddonAbilities.WING_FLAP_ABILITY.get())
					.glide()
					.extraJumps(2)
					.transfurMode(TransfurMode.ABSORPTION)
					.replicating()
					.nightVision()
					.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
					.build());

	public static final RegistryObject<TransfurVariant<LatexRadiationFoxEntity>> LATEXRADIATIONFOX =
			REGISTRY.register("form_latex_radiation_fox", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXRADIATIONFOX)
					//.stepSize(0.7f)
					.glide()
					.transfurMode(TransfurMode.ABSORPTION)
					.replicating()
					.nightVision()
					.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
					.build());

	public static final RegistryObject<TransfurVariant<LatexNightOwlEntity>> LATEXNIGHTOWL =
			REGISTRY.register("form_latex_night_owl_dragon", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXNIGHTOWLDRAGON)
					//.stepSize(0.7f)
					.addAbility(ChangedAddonAbilities.DODGE)
					.addAbility(entityType -> ChangedAddonAbilities.WING_FLAP_ABILITY.get())
					.addAbility(ChangedAddonAbilities.CLAWS)
					.scares(List.of(Creeper.class))
					.glide()
					.transfurMode(TransfurMode.ABSORPTION)
					.replicating()
					.nightVision()
					.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
					.extraJumps(2)
					.build());

	public static final RegistryObject<TransfurVariant<LatexLuoHongEarlySpringFoxDragonEntity>> LATEXLUOHONGEARLYSPRINGFOXDRAGON =
			REGISTRY.register("form_latex_luo_hong_early_spring_fox_dragon", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXLUOHONGEARLYSPRINGFOXDRAGON)
					//.stepSize(0.7f)
					.addAbility(ChangedAddonAbilities.DODGE)
					.addAbility(entityType -> ChangedAddonAbilities.WING_FLAP_ABILITY.get())
					.addAbility(ChangedAddonAbilities.CLAWS)
					.scares(List.of(Creeper.class))
					.glide()
					.transfurMode(TransfurMode.ABSORPTION)
					.replicating()
					.nightVision()
					.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
					.extraJumps(2)
					.build());

    public static final RegistryObject<TransfurVariant<LatexIqGoldDragonEntity>> LATEXIQGOLDDRAGON =
            REGISTRY.register("form_latex_iq_gold_dragon", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXIQGOLDDRAGON)
                    //.stepSize(0.7f)
                    .addAbility(entityType -> ChangedAddonAbilities.WING_FLAP_ABILITY.get())
                    .addAbility(ChangedAddonAbilities.CLAWS)
                    .scares(List.of(Creeper.class))
                    .glide()
                    .transfurMode(TransfurMode.ABSORPTION)
                    .replicating()
                    .nightVision()
                    .addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
                    .extraJumps(1)
                    .build());

	public static final RegistryObject<TransfurVariant<LatexDarkPurpleDragonTaurEntity>> LATEXDARKPURPLEDRAGONTAUR =
			REGISTRY.register("form_latex_dark_purple_dragon_taur", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXDARKPURPLEDRAGONTAUR)
					.addAbility(entityType -> GoodblockModAbilities.TURN_FERA_LATEX_DARK_PURPLE.get())
					.addAbility(GoodblockModAbilities.BERRER_HYPNOSIE)
					.scares(List.of(Creeper.class))
					.replicating()
					.nightVision()
					.quadrupedal()
					.cameraZOffset(7.0f / 16.0f)
					.extraJumps(2)
					.rideable()
					.breatheMode(TransfurVariant.BreatheMode.ANY)
					//.reducedFall()
					.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
					.build());

	public static final RegistryObject<TransfurVariant<DarkPurpleLatexDragonEntity>> LATEXDARKPURPLEDRAGON =
			REGISTRY.register("form_latex_dark_purple_dragon", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXDARKPURPLEDRAGON)
					//.stepSize(0.7f)
					.addAbility(entityType -> ChangedAddonAbilities.WING_FLAP_ABILITY.get())
					.addAbility(GoodblockModAbilities.BERRER_HYPNOSIE)
					.addAbility(entityType -> GoodblockModAbilities.TURN_FERA_LATEX_DARK_PURPLE.get())
					.scares(List.of(Creeper.class))
					.glide()
					.transfurMode(TransfurMode.ABSORPTION)
					.replicating()
					.nightVision()
					.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
					.extraJumps(2)
					.build());

	public static final RegistryObject<TransfurVariant<LatexNeondimnessWolfEntity>> LATEXNEONDIMNESSWOLF =
			REGISTRY.register("form_latex_neondimness_wolf", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXNEONDIMNESSWOLF)
					.scares(List.of(Creeper.class))
					.transfurMode(TransfurMode.ABSORPTION)
					.replicating()
					.nightVision()
					.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
					.addAbility(ChangedAddonAbilities.TELEPORT)
					.addAbility(ChangedAddonAbilities.CARRY)
					.addAbility(ChangedAbilities.GRAB_ENTITY_ABILITY)
					.addAbility(ChangedAddonAbilities.DODGE)
					.addAbility(ChangedAddonAbilities.CUSTOM_INTERACTION)
					.build());

	public static final RegistryObject<TransfurVariant<LatexChengXiEntity>> LATEX_CHENG_XI =
			REGISTRY.register("form_latex_cheng_xi_fox", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEX_CHENG_XI)
					.scares(List.of(Creeper.class))
					.transfurMode(TransfurMode.ABSORPTION)
					.replicating()
					.nightVision()
					.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
					.extraJumps(2)
					.build());
	//

	public static final RegistryObject<TransfurVariant<LatexDivineSwordKitsuneEntity>> LATEX_DIVINE_SWORD_KITSUNE =
			REGISTRY.register("form_latex_divine_sword_kitsune", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEX_DIVINE_SWORD_KITSUNE)
					.addAbility(ChangedAddonAbilities.CLAWS)
					.addAbility(ChangedAddonAbilities.DODGE)
					.addAbility(ChangedAbilities.GRAB_ENTITY_ABILITY)
					.scares(List.of(Creeper.class))
					.glide()
					.transfurMode(TransfurMode.ABSORPTION)
					.replicating()
					.nightVision()
					.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
					.build());

	// 高辉狐 - 基础狐狸型
	public static final RegistryObject<TransfurVariant<LatexGaoHuiFoxEntity>> LATEX_GAO_HUI_FOX =
			REGISTRY.register("form_latex_gao_hui_fox", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEX_GAO_HUI_FOX)
					.addAbility(ChangedAddonAbilities.CLAWS)
					.addAbility(ChangedAddonAbilities.DODGE)
					.transfurMode(TransfurMode.ABSORPTION)
					.replicating()
					.nightVision()
					.glide()
					.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
					.scares(List.of(Creeper.class))
					.build());

	// 风信子狐 - 优雅型
	public static final RegistryObject<TransfurVariant<LatexHyazintheFoxEntity>> LATEX_HYAZINTHE_FOX =
			REGISTRY.register("form_latex_hyazinthe_fox", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEX_HYAZINTHE_FOX)
					.addAbility(ChangedAddonAbilities.CLAWS)
					.addAbility(ChangedAddonAbilities.DODGE)
					.transfurMode(TransfurMode.ABSORPTION)
					.replicating()
					.nightVision()
					.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
					.scares(List.of(Creeper.class))
					.build());

	// 月夕雌狐 - 雌性狐狸型
	public static final RegistryObject<TransfurVariant<LatexYueXiFoxFemaleEntity>> LATEX_YUE_XI_FOX_FEMALE =
			REGISTRY.register("form_latex_yue_xi_fox_female", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEX_YUE_XI_FOX_FEMALE)
					.addAbility(ChangedAddonAbilities.CLAWS)
					.addAbility(ChangedAddonAbilities.DODGE)
					.transfurMode(TransfurMode.ABSORPTION)
					.replicating()
					.nightVision()
					.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
					.scares(List.of(Creeper.class))
					.build());

	// 恩康龙鲨 - 水生龙鲨型
	public static final RegistryObject<TransfurVariant<LatexEnkangDragonSharkEntity>> LATEX_ENKANG_DRAGON_SHARK =
			REGISTRY.register("form_latex_enkang_dragon_shark", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEX_ENKANG_DRAGON_SHARK)
					.addAbility(ChangedAddonAbilities.CLAWS)
					.addAbility(ChangedAddonAbilities.DODGE)
					.addAbility(ChangedAbilities.GRAB_ENTITY_ABILITY)
					.gills()
					.breatheMode(TransfurVariant.BreatheMode.ANY)
					.transfurMode(TransfurMode.ABSORPTION)
					.replicating()
					.nightVision()
					.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
					.build());

	// 千龟鲨 - 水生鲨鱼型
	public static final RegistryObject<TransfurVariant<LatexQianGuiSharkEntity>> LATEX_QIAN_GUI_SHARK =
			REGISTRY.register("form_latex_qian_gui_shark", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEX_QIAN_GUI_SHARK)
					.addAbility(ChangedAddonAbilities.CLAWS)
					.addAbility(ChangedAddonAbilities.DODGE)
					.addAbility(ChangedAbilities.GRAB_ENTITY_ABILITY)
					.gills()
					.breatheMode(TransfurVariant.BreatheMode.ANY)
					.transfurMode(TransfurMode.ABSORPTION)
					.replicating()
					.nightVision()
					.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
					.build());


	// 黎明狼 - 基础狼型
	public static final RegistryObject<TransfurVariant<LatexDawnWolfEntity>> LATEX_DAWN_WOLF =
			REGISTRY.register("form_latex_dawn_wolf", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEX_DAWN_WOLF)
					.addAbility(ChangedAddonAbilities.CLAWS)
					.addAbility(ChangedAddonAbilities.DODGE)
					.addAbility(ChangedAbilities.GRAB_ENTITY_ABILITY)
					.transfurMode(TransfurMode.ABSORPTION)
					.replicating()
					.nightVision()
					.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
					.scares(List.of(Creeper.class))
					.breatheMode(TransfurVariant.BreatheMode.ANY)
					.build());

	// 蓝脉猫 - 猫型
	public static final RegistryObject<TransfurVariant<LatexBlueveCatEntity>> LATEX_BLUEVE_CAT =
			REGISTRY.register("form_latex_blueve_cat", () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEX_BLUEVE_CAT)
					.addAbility(ChangedAddonAbilities.CLAWS)
					.addAbility(ChangedAddonAbilities.DODGE)
					.addAbility(ChangedAbilities.GRAB_ENTITY_ABILITY)
					.transfurMode(TransfurMode.ABSORPTION)
					.replicating()
					.nightVision()
					.canClimb()
					.addAbility(ChangedAddonAbilities.TOGGLE_CLIMB)
					.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
					.scares(List.of(Creeper.class))
					.build());

	public static void register(IEventBus bus) {
        REGISTRY.register(bus);
    }


}












