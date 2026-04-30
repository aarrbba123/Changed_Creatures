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
            "goodblock:latex_orange_fox",
            "goodblock:latex_kcahra_shark",
            "goodblock:latexbluedragon",
            "goodblock:darkfu_latex_wolf_male",
            "goodblock:latex_ko_qi_ice_dragon",
            "goodblock:inksuger",
            "goodblock:blackpupmale",
            "goodblock:whitebluepup",
            "goodblock:latexpurplewswolf",
            "goodblock:latexyunxqhotdragon",
            "goodblock:latexyunxqicedragon",
            "goodblock:latex_ice_field_wolf_dragon",
            "goodblock:latex_purple_cooc_wolf",
            "goodblock:latexthreemonthwolf",
            "goodblock:latex_yun_qi_ice_dragon",
            "goodblock:latex_radiation_fox",
            "goodblock:latex_night_owl_dragon",
            "goodblock:latex_iq_gold_dragon",
            "goodblock:latex_dark_purple_dragon_taur",
            "goodblock:latex_dark_purple_dragon",
            "goodblock:latex_luo_hong_early_spring_fox_dragon",
            "goodblock:latex_neondimness_wolf",
            "goodblock:latex_cheng_xi_fox")
    );
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