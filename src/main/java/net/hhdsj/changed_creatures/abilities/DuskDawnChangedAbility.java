package net.hhdsj.changed_creatures.abilities;

import net.hhdsj.changed_creatures.entity.simple.LatexDuskDawnDragonEntity;
import net.ltxprogrammer.changed.ability.IAbstractChangedEntity;
import net.ltxprogrammer.changed.ability.SimpleAbility;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class DuskDawnChangedAbility extends SimpleAbility {

    @Override
    public boolean canUse(IAbstractChangedEntity entity) {
        return true;
    }
    @Override
    public void startUsing(IAbstractChangedEntity entity) {
        LivingEntity living = entity.getEntity();
        if (living instanceof Player player) {
            if (entity instanceof LatexDuskDawnDragonEntity dragonEntity) {
                dragonEntity.setCanChangeColor(!dragonEntity.GetCanChangeColor());
            }
        }
        super.startUsing(entity);
    }

    public UseType getUseType(IAbstractChangedEntity entity) {
        return UseType.CHARGE_RELEASE;
    }
}