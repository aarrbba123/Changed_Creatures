package net.hhdsj.goodblock.abilities;

import net.ltxprogrammer.changed.ability.AbstractAbility;
import net.ltxprogrammer.changed.ability.IAbstractChangedEntity;
import net.ltxprogrammer.changed.ability.SimpleAbility;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class LatexFrostSpikeAblilty extends SimpleAbility {

    private static final int RADIUS = 10;

    @Override
    public UseType getUseType(IAbstractChangedEntity entity) {
        return UseType.INSTANT;
    }
    @Override
    public void startUsing(IAbstractChangedEntity entity) {

        if (entity.getEntity().level().isClientSide()) return;

        ServerPlayer player = (ServerPlayer) entity.getEntity();
        Level level = player.level();
        BlockPos centerPos = player.blockPosition();
        int centerY = centerPos.getY();

        for (int dx = -RADIUS; dx <= RADIUS; dx++) {
            for (int dz = -RADIUS; dz <= RADIUS; dz++) {
                if (dx * dx + dz * dz > RADIUS * RADIUS) continue;

                BlockPos targetPos = new BlockPos(
                        centerPos.getX() + dx,
                        centerY,
                        centerPos.getZ() + dz
                );

                if (level.getBlockState(targetPos).isAir() &&
                        !level.getBlockState(targetPos.below()).isAir()) {
                    level.setBlock(
                            targetPos,
                            Blocks.BLUE_ICE.defaultBlockState(),
                            Block.UPDATE_ALL
                    );
                }
            }
        }

        if (!level.isClientSide()) {
            ((ServerLevel) level).sendParticles(
                    ParticleTypes.SNOWFLAKE,
                    player.getX(), player.getY() + 0.5, player.getZ(),
                    100, 5, 0.5, 5, 0.1
            );
        }
    }
}
