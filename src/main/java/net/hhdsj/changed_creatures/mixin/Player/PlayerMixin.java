package net.hhdsj.changed_creatures.mixin.Player;

import net.hhdsj.changed_creatures.util.PlayerDataGetHelper;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({Player.class})
public class PlayerMixin {
    @Inject(
            method = {"tryToStartFallFlying"},
            at = {@At("HEAD")},
            cancellable = true
    )
    protected void tryToStartFallFlying(CallbackInfoReturnable<Boolean> ci) {
        Player player = (Player) (Object) this;

        if (PlayerDataGetHelper.GetPlayerCanFly(player) &&
                PlayerDataGetHelper.GetPlayerCanGliding(player) &&
                !player.onGround() &&
                !player.isInWater() &&
                !player.isFallFlying() &&
                !player.hasEffect(MobEffects.LEVITATION)) {

            player.startFallFlying();
            ci.setReturnValue(true);
            ci.cancel();
        }
    }
}
