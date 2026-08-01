package net.hhdsj.goodblock.abilities;

import net.ltxprogrammer.changed.ability.IAbstractChangedEntity;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

public class LatexConfusedAbility extends BetterHypnosisAbility{
    @Override
    public void tick(IAbstractChangedEntity entity) {
        LivingEntity self = entity.getEntity();
        Level level = entity.getLevel();

        ACTIVE_USERS.put(self, level.getGameTime());

        for (Entity entityiterator : level.getEntities((Entity) entity, new AABB((self.xo - 7), (self.yo - 7), (self.zo - 7), (self.xo + 7), (self.yo + 7), (self.zo + 7)))) {
            if (entityiterator instanceof Player player) {
                if (!(ProcessTransfur.getPlayerTransfurProgress(player) > 0f)) {
                    return;
                }
                if (ProcessTransfur.getPlayerTransfurVariant(player) == null) {
                    ProcessTransfur.setPlayerTransfurProgress(player, ProcessTransfur.getPlayerTransfurProgress(player) + 0.02f);
                }
            }
        }
        super.tick(entity);
    }
}
