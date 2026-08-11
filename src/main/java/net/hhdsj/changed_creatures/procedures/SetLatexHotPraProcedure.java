package net.hhdsj.changed_creatures.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.hhdsj.changed_creatures.init.ChangedCreatureModMobEffects;

public class SetLatexHotPraProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
        return entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ChangedCreatureModMobEffects.LATEXHOTPAR.get());
    }
}
