package net.hhdsj.goodblock.abilities;

import net.hhdsj.goodblock.entity.simple.LatexDuskDawnDragonEntity;
import net.hhdsj.goodblock.init.GoodblockModTransfurVariants;
import net.ltxprogrammer.changed.ability.IAbstractChangedEntity;
import net.ltxprogrammer.changed.ability.SimpleAbility;
import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.world.entity.player.Player;

public class DuskDawnChangedAbility extends SimpleAbility {

    @Override
    public boolean canUse(IAbstractChangedEntity entity) {
        if (entity instanceof Player player) {
            TransfurVariantInstance<?> variant = ProcessTransfur.getPlayerTransfurVariant(player);
            return variant.getParent() == GoodblockModTransfurVariants.LATEX_DUSK_DAWN_DRAGON.get();
        }
        return false;
    }
    @Override
    public void startUsing(IAbstractChangedEntity entity) {
        if (entity instanceof LatexDuskDawnDragonEntity dragonEntity) {
            dragonEntity.setCanChangeColor(!dragonEntity.GetCanChangeColor());
        }

        super.startUsing(entity);
    }
}