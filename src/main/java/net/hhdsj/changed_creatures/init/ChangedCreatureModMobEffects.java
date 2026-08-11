
/*
 *	这些为注册类,请将注册写在这里,而不是其它地方!
 */
package net.hhdsj.changed_creatures.init;

import net.hhdsj.changed_creatures.ChangedCreature;
import net.hhdsj.changed_creatures.potion.*;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

public class ChangedCreatureModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ChangedCreature.MODID);
	public static final RegistryObject<MobEffect> RADIATION = REGISTRY.register("radiation", RadiationMobEffect::new);
	public static final RegistryObject<MobEffect> LATEXHOTPAR = REGISTRY.register("latexhotpar", LatexhotparMobEffect::new);
	public static final RegistryObject<MobEffect> SLOWINFECTION = REGISTRY.register("slowinfection", SlowinfectionMobEffect::new);
	public static final RegistryObject<MobEffect> Frost_Effect = REGISTRY.register("frost", FrostMobEffect::new);
	public static final RegistryObject<MobEffect> Latex_Paralysis = REGISTRY.register("latex_paralysis", LatexEntityParalysisMobEffect::new);
	public static final RegistryObject<MobEffect> LAVA_BURN = REGISTRY.register("lava_burn", LavaBurnEffect::new);
}
