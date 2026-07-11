package net.hhdsj.goodblock.abilities;

import net.hhdsj.goodblock.entity.simple.CrystalArrow;
import net.ltxprogrammer.changed.ability.IAbstractChangedEntity;
import net.ltxprogrammer.changed.ability.SimpleAbility;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;

public class ShootCrystalArrowAbility extends SimpleAbility {

    private static final float ARROW_VELOCITY = 3.0F;
    private static final float ARROW_DAMAGE = 6.0F;
    private static final float INACCURACY = 1.0F;

    @Override
    public boolean canUse(IAbstractChangedEntity entity) {
        return entity != null && entity.getEntity().isAlive();
    }

    @Override
    public void startUsing(IAbstractChangedEntity entity) {
        if (entity.getEntity().level().isClientSide) {
            return;
        }

        LivingEntity shooter = (LivingEntity) entity.getEntity();

        if (!(shooter.level() instanceof ServerLevel serverLevel)) {
            return;
        }

        CrystalArrow arrow = new CrystalArrow(serverLevel, shooter);
        arrow.setBaseDamage(ARROW_DAMAGE);
        arrow.pickup = AbstractArrow.Pickup.DISALLOWED; // 不可拾取

        arrow.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot(), 0.0F, ARROW_VELOCITY, INACCURACY);

        serverLevel.addFreshEntity(arrow);

        serverLevel.playSound(
                null, shooter.getX(), shooter.getY(), shooter.getZ(),
                SoundEvents.ARROW_SHOOT,
                SoundSource.PLAYERS,
                1.0F, 0.9F + (float) Math.random() * 0.2F
        );
    }

    @Override
    public int getCoolDown(IAbstractChangedEntity entity) {
        return 15; // 0.75秒冷却
    }

    @Override
    public UseType getUseType(IAbstractChangedEntity entity) {
        return UseType.INSTANT;
    }
}