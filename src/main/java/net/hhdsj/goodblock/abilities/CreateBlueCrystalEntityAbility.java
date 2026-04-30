package net.hhdsj.goodblock.abilities;

import net.hhdsj.goodblock.entity.BlueCrystalProjectile;
import net.ltxprogrammer.changed.ability.AbstractAbility;
import net.ltxprogrammer.changed.ability.AbstractAbilityInstance;
import net.ltxprogrammer.changed.ability.IAbstractChangedEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class CreateBlueCrystalEntityAbility extends AbstractAbilityInstance {

    // 配置参数
    private static final double PROJECTILE_SPEED = 1.8D;
    private static final double SPREAD_OFFSET = 0.08D;
    private static final float PROJECTILE_DAMAGE = 5.0F;

    private boolean isActive = false;

    public CreateBlueCrystalEntityAbility(AbstractAbility<?> ability, IAbstractChangedEntity entity) {
        super(ability, entity);
    }

    @Override
    public boolean canUse() {
        // 检查实体是否有效
        if (entity == null || entity.getEntity() == null || !entity.getEntity().isAlive()) {
            return false;
        }

        // 检查冷却
        if (getController().isCoolingDown()) {
            return false;
        }

        return true;
    }

    @Override
    public boolean canKeepUsing() {
        return false;
    }

    @Override
    public void startUsing() {
        if (isActive) return;

        isActive = true;

        // 只在服务端创建投射物
        if (!entity.getEntity().level().isClientSide) {
            createAndShootProjectile();
            // 设置冷却
            getController().applyCoolDown();
        }

        // 播放音效
        playShootSound();

        isActive = false;
    }

    private void createAndShootProjectile() {
        LivingEntity shooter = (LivingEntity) entity.getEntity();

        // 检查世界类型
        if (!(shooter.level() instanceof ServerLevel serverLevel)) {
            return;
        }

        // 使用现有的构造函数 - 只需要 shooter 参数
        BlueCrystalProjectile projectile = new BlueCrystalProjectile(serverLevel, shooter);

        // 设置自定义属性
        projectile.setProjectileDamage(PROJECTILE_DAMAGE);
        projectile.setParryable(true); // 可以格挡

        // 可选：设置转化变体（如果你想要特定的转化效果）
        // projectile.setFormVariant(new ResourceLocation("goodblock", "form_latex_gao_hui_fox"));

        // 获取发射方向并添加散射
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

        // 发射投射物 - 重设速度以使用我们的自定义速度
        projectile.setDeltaMovement(finalDirection.scale(PROJECTILE_SPEED));

        // 添加到世界
        serverLevel.addFreshEntity(projectile);
    }

    private void playShootSound() {
        entity.getEntity().level().playSound(
                null,
                entity.getEntity().getX(),
                entity.getEntity().getY(),
                entity.getEntity().getZ(),
                SoundEvents.ENDER_PEARL_THROW,
                SoundSource.PLAYERS,
                1.0F,
                0.8F + (float) Math.random() * 0.4F
        );
    }

    @Override
    public void tick() {
        // INSTANT 类型不需要持续 tick
    }

    @Override
    public void stopUsing() {
        isActive = false;
    }

    @Override
    public void tickIdle() {
        // 空闲时的处理
    }

    @Override
    public void onRemove() {
        isActive = false;
        super.onRemove();
    }

    @Override
    public boolean hasFoil() {
        return true; // 图标有附魔光泽
    }
}