package net.hhdsj.changed_creatures.abilities;

import net.ltxprogrammer.changed.ability.IAbstractChangedEntity;
import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

public class LatexConfusedAbility extends BetterHypnosisAbility {
    TransfurVariant<?> selfVariant = null;
    private static final double RANGE = 7.0;
    private static final float TRANSFUR_INCREMENT = 0.02f;

    @Override
    public void tick(IAbstractChangedEntity entity) {
        LivingEntity self = entity.getEntity();
        Level level = entity.getLevel();

        ACTIVE_USERS.put(self, level.getGameTime());

        if (self instanceof Player player) {
            var variantInstance = ProcessTransfur.getPlayerTransfurVariant(player);
            if (variantInstance != null) {
                selfVariant = variantInstance.getParent();
            }
        }

        if (selfVariant == null) {
            super.tick(entity);
            return;
        }

        AABB aabb = new AABB(
                self.getX() - RANGE,
                self.getY() - RANGE,
                self.getZ() - RANGE,
                self.getX() + RANGE,
                self.getY() + RANGE,
                self.getZ() + RANGE
        );

        for (Entity entityiterator : level.getEntities(self, aabb)) {
            if (entityiterator instanceof Player player) {
                if (ProcessTransfur.getPlayerTransfurProgress(player) > 0f) continue;

                var playerVariantInstance = ProcessTransfur.getPlayerTransfurVariant(player);
                TransfurVariant<?> playerVariant = playerVariantInstance != null ? playerVariantInstance.getParent() : null;

                if (playerVariant == null) {
                    ProcessTransfur.setPlayerTransfurVariant(player, selfVariant);
                    ProcessTransfur.setPlayerTransfurProgress(player, TRANSFUR_INCREMENT);
                } else {
                    float currentProgress = ProcessTransfur.getPlayerTransfurProgress(player);
                    float newProgress = Math.min(currentProgress + TRANSFUR_INCREMENT, 0.1f);
                    ProcessTransfur.setPlayerTransfurProgress(player, newProgress);
                }
            }
        }

        super.tick(entity);
    }
}