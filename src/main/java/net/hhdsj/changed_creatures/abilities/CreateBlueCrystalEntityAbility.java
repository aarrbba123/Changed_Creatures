package net.hhdsj.changed_creatures.abilities;

import net.hhdsj.changed_creatures.entity.simple.BlueCrystalProjectile;
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

    // 关键：必须覆盖这个方法，返回 true
    @Override
    public boolean canUse(IAbstractChangedEntity entity) {
        // 检查实体是否存在且存活
        if (entity == null || entity.getEntity() == null || !entity.getEntity().isAlive()) {
            return false;
        }
        // 返回 true 表示可以使用
        return true;
    }

    @Override
    public void startUsing(IAbstractChangedEntity entity) {
        System.out.println("CreateBlueCrystalEntityAbility.startUsing() called!");

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
        projectile.setParryable(false);

        // 获取发射方向
        Vec3 lookVec = shooter.getLookAngle();

        // 添加随机散射
        double spreadX = (Math.random() - 0.5D) * SPREAD_OFFSET;
        double spreadY = (Math.random() - 0.5D) * SPREAD_OFFSET;
        double spreadZ = (Math.random() - 0.5D) * SPREAD_OFFSET;

        Vec3 finalDirection = new Vec3(
                lookVec.x + spreadX,
                lookVec.y + spreadY,
                lookVec.z + spreadZ
        ).normalize();

        // 设置速度和位置
        projectile.setDeltaMovement(finalDirection.scale(PROJECTILE_SPEED));
        projectile.setPos(shooter.getX(), shooter.getEyeY() - 0.2, shooter.getZ());

        // 添加到世界
        serverLevel.addFreshEntity(projectile);
        System.out.println("Projectile spawned at: " + shooter.getX() + ", " + shooter.getY() + ", " + shooter.getZ());

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
        return 20; // 1秒冷却
    }

    @Override
    public UseType getUseType(IAbstractChangedEntity entity) {
        return UseType.INSTANT;
    }
}