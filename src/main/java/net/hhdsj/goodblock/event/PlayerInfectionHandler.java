package net.hhdsj.goodblock.event;

import net.hhdsj.goodblock.init.GoodBlockModGameRules;
import net.hhdsj.goodblock.util.PlayerDataGetHelper;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.TransfurContext;
import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.ltxprogrammer.changed.init.ChangedRegistry;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.player.Player;
import net.hhdsj.goodblock.network.GoodblockModVariables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber
public class PlayerInfectionHandler {
    private static final Random RANDOM = new Random();
    private static final List<String> LIST_VARIANT = new ArrayList<>(List.of(
            // === 原有 23 项 ===
            "goodblock:form_orange_fox",
            "goodblock:form_latex_kcahra_shark",
            "goodblock:form_blue_dragon",
            "goodblock:form_darkfu_latex_wolf_male",
            "goodblock:form_latex_ice_dragon",
            "goodblock:form_ink_suger",
            "goodblock:form_black_pup",
            "goodblock:form_white_blue_pup",
            "goodblock:form_latex_purplews_wolf",
            "goodblock:form_latex_three_month_wolf",
            "goodblock:form_latex_yunxq_hot_dragon",
            "goodblock:form_latex_yun_xq_ice_dragon",
            "goodblock:form_latex_ice_field_wolf_dragon",
            "goodblock:form_latex_purple_cooc_wolf",
            "goodblock:form_latex_yun_qi_ice_dragon",
            "goodblock:form_latex_radiation_fox",
            "goodblock:form_latex_night_owl_dragon",
            "goodblock:form_latex_iq_gold_dragon",
            "goodblock:form_latex_dark_purple_dragon_taur",
            "goodblock:form_latex_dark_purple_dragon",
            "goodblock:form_latex_luo_hong_early_spring_fox_dragon",
            "goodblock:form_latex_neondimness_wolf",
            "goodblock:form_latex_cheng_xi_fox",

            // === 新增（注册表中存在但 LIST_VARIANT 中缺失的） ===
            "goodblock:form_latex_yao_ling_dragon",
            "goodblock:form_latex_dragon_fruit_wolf",
            "goodblock:form_latex_divine_sword_kitsune",
            "goodblock:form_latex_gao_hui_fox",
            "goodblock:form_latex_hyazinthe_fox",
            "goodblock:form_latex_yue_xi_fox_female",
            "goodblock:form_latex_enkang_dragon_shark",
            "goodblock:form_latex_qian_gui_shark",
            "goodblock:form_latex_dawn_wolf",
            "goodblock:form_latex_blueve_cat"
    ));
    private static ResourceLocation FORM_VARIANT = new ResourceLocation("goodblock", "form_latex_yunxq_hot_dragon");
    //private static final TransfurVariant<?> variant = ChangedRegistry.TRANSFUR_VARIANT.get().getValue(FORM_VARIANT);

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        if (player instanceof ServerPlayer serverPlayer) {
            GameType gameMode = serverPlayer.gameMode.getGameModeForPlayer();
            if (gameMode == GameType.CREATIVE || gameMode == GameType.SPECTATOR){
                return;
            }

        }

        TransfurVariantInstance<?> TransfurVariant = ProcessTransfur.getPlayerTransfurVariant(player);


        if (event.phase == TickEvent.Phase.END && !event.player.level().isClientSide()) {
            GoodblockModVariables.PlayerVariables data = PlayerDataGetHelper.get(player);

            if (!data.Player_Is_Infection) {
                return;
            }

            Level level = event.player.level();
            if (!level.getGameRules().getBoolean(GoodBlockModGameRules.TEST_RULE)) {
                return;
            }

            if (TransfurVariant != null) {
                data.Player_Infection_tick = 0;
                data.Player_Is_Infection = true;
                data.syncPlayerVariables(player);
                return;
            }

            data.Player_Infection_tick++;

            if (data.Player_Infection_tick % 100 == 0) {
                data.syncPlayerVariables(player);
            }

            if (data.Player_Infection_tick >= 1000) {
                player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 50, 1));
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 2));
                FORM_VARIANT = new ResourceLocation(LIST_VARIANT.get(RANDOM.nextInt(LIST_VARIANT.size())));
                TransfurVariant<?> variant = ChangedRegistry.TRANSFUR_VARIANT.get().getValue(FORM_VARIANT);
                if (variant != null) {
                    GoodblockProcessTransfur.progressTransfur(player, 1f, variant, TransfurContext.hazard(TransfurCause.FACE_HAZARD));
                }
            }

            if (data.Player_Infection_tick % 100 == 0) {
                System.out.println("Now Player_Infection_tick : " + data.Player_Infection_tick);
            }
        }
    }
}