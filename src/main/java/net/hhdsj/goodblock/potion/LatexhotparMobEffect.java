
package net.hhdsj.goodblock.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.hhdsj.goodblock.procedures.LatexHotParChangedProcedure;

public class LatexhotparMobEffect extends MobEffect {
	public LatexhotparMobEffect() {
		super(MobEffectCategory.HARMFUL, -52480);
	}

	@Override
	public String getDescriptionId() {
		return "effect.goodblock.latexhotpar";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		LatexHotParChangedProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
