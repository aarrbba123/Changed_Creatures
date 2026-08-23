package net.hhdsj.changed_creatures.abilities;

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

    private static final int RADIUS = 6;
    @Override
    public boolean canUse(IAbstractChangedEntity entity) {
        return entity.getFoodLevel() > 6;
    }

    @Override
    public UseType getUseType(IAbstractChangedEntity entity) {
        return UseType.CHARGE_TIME;
    }
    @Override
    public void startUsing(IAbstractChangedEntity entity) {

        if (entity.getEntity().level().isClientSide()) return;

        ServerPlayer player = (ServerPlayer) entity.getEntity();
        Level level = player.level();
        BlockPos centerPos = player.blockPosition();
        int centerY = centerPos.getY();
        var succed = false;
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
                            Blocks.ICE.defaultBlockState(),
                            Block.UPDATE_ALL
                    );
                    succed = true;
                }
            }
        }
        if (succed){
            if (!level.isClientSide()) {
                ((ServerLevel) level).sendParticles(
                        ParticleTypes.SNOWFLAKE,
                        player.getX(), player.getY() + 0.5, player.getZ(),
                        200, 5, 0.5, 5, 0.1
                );
            }
            entity.causeFoodExhaustion(16.0F);
        }
    }

    @Override
    public int getChargeTime(IAbstractChangedEntity entity) {
        return 100;
    }

    @Override
    public int getCoolDown(IAbstractChangedEntity entity) {
        return 800;
    }
}
