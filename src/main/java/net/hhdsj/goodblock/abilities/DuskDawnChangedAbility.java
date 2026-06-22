package net.hhdsj.goodblock.abilities;

import net.hhdsj.goodblock.entity.simple.LatexDuskDawnDragonEntity;
import net.hhdsj.goodblock.init.GoodblockModTransfurVariants;
import net.ltxprogrammer.changed.ability.AbstractAbility;
import net.ltxprogrammer.changed.ability.IAbstractChangedEntity;
import net.ltxprogrammer.changed.ability.SimpleAbility;
import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.ltxprogrammer.changed.process.ProcessTransfur;
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