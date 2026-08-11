package net.hhdsj.changed_creatures.entity.simple;

import net.foxyas.changedaddon.entity.advanced.AbstractKitsuneEntity;
import net.hhdsj.changed_creatures.init.ChangedCreatureModEntities;
import net.hhdsj.changed_creatures.init.ChangedCreatureModParticleTypes;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.entity.Gender;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.network.PlayMessages;

import java.util.Objects;

public class LatexGaoHuiFoxEntity extends AbstractKitsuneEntity {
    @Override
    protected void setAttributes(AttributeMap attributes) {
        super.setAttributes(attributes);
        Objects.requireNonNull(attributes.getInstance(Attributes.MOVEMENT_SPEED)).setBaseValue(1.1);
        Objects.requireNonNull(attributes.getInstance(ForgeMod.SWIM_SPEED.get())).setBaseValue(0.9);
        Objects.requireNonNull(attributes.getInstance(Attributes.MAX_HEALTH)).setBaseValue(40);
    }

    public LatexGaoHuiFoxEntity(EntityType<? extends ChangedEntity> type, Level level) {
        super(type, level);
    }

    public LatexGaoHuiFoxEntity(PlayMessages.SpawnEntity ignoredPacket, Level world) {
        this(ChangedCreatureModEntities.LATEX_GAO_HUI_FOX.get(), world);
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (this.isFallFlying() || (!this.onGround() && !this.isInWater())) {
            spawnFlightParticles();
        }
    }

    private void spawnFlightParticles() {
        if (this.level().isClientSide) {
            double x = this.getX();
            double y = this.getY() + 1.0; // 腰部高度
            double z = this.getZ();

            // 环绕粒子的半径
            double radius = 1;
            // 粒子数量
            int particleCount = 2;

            for (int i = 0; i < particleCount; i++) {
                // 计算环绕角度
                double angle = (this.tickCount * 10 + i * (360.0 / particleCount)) * Math.PI / 180.0;

                // 计算粒子位置
                double offsetX = Math.cos(angle) * radius;
                double offsetZ = Math.sin(angle) * radius;

                // 添加垂直波动效果
                double offsetY = Math.sin(this.tickCount * 0.2 + i) * 0.1;

                // 生成粒子
                this.level().addParticle(
                        ChangedCreatureModParticleTypes.GREEN_FLAME.get(),  // 火焰粒子（亮绿色类似火把）
                        x + offsetX,
                        y + offsetY,
                        z + offsetZ,
                        0.0, 0.02, 0.0  // 速度（缓慢上升）
                );
            }
        }
    }

    public Gender getGender() {
        return Gender.MALE;
    }
}
