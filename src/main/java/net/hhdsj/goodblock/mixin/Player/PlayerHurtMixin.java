package net.hhdsj.goodblock.mixin.Player;

import net.hhdsj.goodblock.init.GoodblockModMobEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Player.class)
public class PlayerHurtMixin {
    @ModifyVariable(
            method = "hurt",
            at = @At(value = "HEAD"),
            argsOnly = true,
            ordinal = 0
    )
    private float modifyDamage(float amount, DamageSource source) {
        Player player = (Player)(Object)this;
        if (player.hasEffect(GoodblockModMobEffects.Latex_Paralysis.get())) {
            return amount + amount * 1.2F;
        }
        return amount;
    }
}