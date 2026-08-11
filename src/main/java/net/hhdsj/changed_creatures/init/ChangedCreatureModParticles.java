/*
 *    这些为注册类,请将注册写在这里,而不是其它地方!
 */
package net.hhdsj.changed_creatures.init;

import net.hhdsj.changed_creatures.ChangedCreature;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.hhdsj.changed_creatures.client.particle.ParhotxParticle;
import net.hhdsj.changed_creatures.client.particle.GreenFlameParticle; // 你需要创建这个类

@Mod.EventBusSubscriber(modid = ChangedCreature.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ChangedCreatureModParticles {

	@SubscribeEvent
	public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(ChangedCreatureModParticleTypes.PARHOTX.get(), ParhotxParticle::provider);
		event.registerSpriteSet(ChangedCreatureModParticleTypes.GREEN_FLAME.get(), GreenFlameParticle::provider);
}
}