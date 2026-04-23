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

@Mod.EventBusSubscriber
public class PlayerInfectionHandler {
    private static final ResourceLocation FORM_VARIANT = new ResourceLocation("goodblock", "form_latex_yunxq_hot_dragon");
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
                TransfurVariant<?> variant = ChangedRegistry.TRANSFUR_VARIANT.get().getValue(FORM_VARIANT);
                if (variant != null) {
                    GoodblockProcessTransfur.progressTransfur(player, 1f, variant, TransfurContext.hazard(TransfurCause.FACE_HAZARD));
                }
                ;
            }
            ;

            if (data.Player_Infection_tick % 100 == 0) {
                System.out.println("Now Player_Infection_tick : " + data.Player_Infection_tick);
            }
        }
    }
}