/*
 *    这些为注册类,请将注册写在这里,而不是其它地方!
 * 					粒子
 */
package net.hhdsj.changed_creatures.init;

import net.hhdsj.changed_creatures.ChangedCreature;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

public class ChangedCreatureModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY =
			DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ChangedCreature.MODID);

	public static final RegistryObject<SimpleParticleType> PARHOTX =
			REGISTRY.register("parhotx", () -> new SimpleParticleType(true));

	public static final RegistryObject<SimpleParticleType> GREEN_FLAME =
			REGISTRY.register("green_flame", () -> new SimpleParticleType(true));
}