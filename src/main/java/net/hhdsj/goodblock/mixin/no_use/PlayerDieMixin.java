package net.hhdsj.goodblock.mixin.no_use;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
@Mixin(ServerPlayer.class)
public class PlayerDieMixin {

    @Unique
    private @NotNull Player goodblockMod_java$asEntity() {
        return (ServerPlayer)(Object)this;
    }

    @Inject(method = "die", at = @At("HEAD"))
    private void onPlayerDie(DamageSource damageSource, CallbackInfo ci) {

        /*
        Player player = this.goodblockMod_java$asEntity();
        TransfurVariantInstance<?> variant = ProcessTransfur.getPlayerTransfurVariant(player);

        if (variant == null) {
            TransfurVariant<?> targetVariant = GoodblockModTransfurVariants.LATEXDARKPURPLEDRAGON.get();
            TransfurVariantInstance<?> variantInstance = ProcessTransfur.setPlayerTransfurVariant(
                    player,
                    targetVariant,
                    TransfurContext.hazard(TransfurCause.GRAB_REPLICATE),
                    1f
            );
            player.level().playSound(null, player, ChangedSounds.TRANSFUR_BY_LATEX.get(), SoundSource.PLAYERS, 1, 1);
        }*/
    }
}