
package net.hhdsj.goodblock.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.hhdsj.goodblock.procedures.LatexHotParChangedProcedure;
import org.jetbrains.annotations.NotNull;

public class LatexhotparMobEffect extends MobEffect {
	public LatexhotparMobEffect() {
		super(MobEffectCategory.HARMFUL, -52480);
	}

	@Override
	public @NotNull String getDescriptionId() {
		return "effect.goodblock.latexhotpar";
	}

	@Override
	public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
		LatexHotParChangedProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
