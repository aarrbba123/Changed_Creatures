package net.hhdsj.goodblock.potion;

import net.hhdsj.goodblock.init.GoodblockModMobEffects;
import net.hhdsj.goodblock.procedures.LatexHotParChangedProcedure;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public class FrostMobEffect extends MobEffect {
    public FrostMobEffect() {
        super(MobEffectCategory.HARMFUL, 0x8BDBFF);
    }

    @Override
    public @NotNull String getDescriptionId() {
        return "effect.goodblock.frost";
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {

        if (entity.level().isClientSide) {
            return;
        }

        if (entity.isInLava() || entity.isOnFire()) {
            entity.removeEffect(GoodblockModMobEffects.Frost_Effect.get());
            return;
        }

        if (entity.tickCount % 20 == 0) {
            float damage = 0.5F + amplifier;
            entity.hurt(entity.damageSources().freeze(), damage);

            if (entity instanceof Player player) {
                spawnFreezeParticles(player,1);
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }

    private void spawnFreezeParticles(LivingEntity entity, int amplifier) {
        double x = entity.getX();
        double y = entity.getY() + entity.getBbHeight() / 2;
        double z = entity.getZ();

        for (int i = 0; i < 3 + amplifier; i++) {
            double offsetX = (entity.getRandom().nextDouble() - 0.5) * 0.8;
            double offsetY = (entity.getRandom().nextDouble() - 0.5) * 0.8;
            double offsetZ = (entity.getRandom().nextDouble() - 0.5) * 0.8;

            entity.level().addParticle(
                    ParticleTypes.SNOWFLAKE,
                    x + offsetX,
                    y + offsetY,
                    z + offsetZ,
                    0,
                    -0.1,
                    0
            );
        }
    }
}
