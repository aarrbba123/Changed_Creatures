package net.hhdsj.goodblock.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class Crusedscythe1Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isAlive()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
				_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 180, 1));
				_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 180, 3));
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 180, 5));
			}
		}
	}
}