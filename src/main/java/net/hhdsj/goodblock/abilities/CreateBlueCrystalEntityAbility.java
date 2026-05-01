package net.hhdsj.goodblock.abilities;

import net.hhdsj.goodblock.entity.BlueCrystalProjectile;
import net.ltxprogrammer.changed.ability.IAbstractChangedEntity;
import net.ltxprogrammer.changed.ability.SimpleAbility;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class CreateBlueCrystalEntityAbility extends SimpleAbility {

    private static final double PROJECTILE_SPEED = 1.8D;
    private static final double SPREAD_OFFSET = 0.08D;
    private static final float PROJECTILE_DAMAGE = 5.0F;

    @Override
    public void startUsing(IAbstractChangedEntity entity) {
        if (entity.getEntity().level().isClientSide) {
            return;
        }

        LivingEntity shooter = (LivingEntity) entity.getEntity();

        if (!(shooter.level() instanceof ServerLevel serverLevel)) {
            return;
        }

        // 创建投射物
        BlueCrystalProjectile projectile = new BlueCrystalProjectile(serverLevel, shooter);
        projectile.setProjectileDamage(PROJECTILE_DAMAGE);

        // 添加散射效果
        Vec3 lookVec = shooter.getLookAngle();
        double spreadX = (Math.random() - 0.5D) * SPREAD_OFFSET;
        double spreadY = (Math.random() - 0.5D) * SPREAD_OFFSET;
        double spreadZ = (Math.random() - 0.5D) * SPREAD_OFFSET;

        Vec3 finalDirection = new Vec3(
                lookVec.x + spreadX,
                lookVec.y + spreadY,
                lookVec.z + spreadZ
        ).normalize();

        projectile.setDeltaMovement(finalDirection.scale(PROJECTILE_SPEED));

        // 添加到世界
        serverLevel.addFreshEntity(projectile);

        // 播放音效
        serverLevel.playSound(
                null, shooter.getX(), shooter.getY(), shooter.getZ(),
                SoundEvents.ENDER_PEARL_THROW,
                SoundSource.PLAYERS,
                1.0F, 0.8F + (float) Math.random() * 0.4F
        );
    }

    @Override
    public int getCoolDown(IAbstractChangedEntity entity) {
        return 30; // 1.5秒冷却
    }

    @Override
    public UseType getUseType(IAbstractChangedEntity entity) {
        return UseType.INSTANT;
    }
}