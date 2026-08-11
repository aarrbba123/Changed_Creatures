package net.hhdsj.changed_creatures.event;

import net.hhdsj.changed_creatures.ChangedCreature;
import net.hhdsj.changed_creatures.capability.CrystalRing;
import net.hhdsj.changed_creatures.capability.CrystalRingProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod.EventBusSubscriber(modid = ChangedCreature.MODID)
public class CrystalRingHandler {
    public static final Capability<CrystalRing> CAPABILITY = CapabilityManager.get(new CapabilityToken<>(){});

    // ========== 注册能力和模型层 ==========
    public static void registerCapabilities(IEventBus bus) {
        bus.addListener((RegisterCapabilitiesEvent event) -> event.register(CrystalRing.class));
        // 只在客户端注册模型层
        if (FMLEnvironment.dist == Dist.CLIENT) {
            bus.addListener(ClientHandler::registerLayerDefinitions);
        }
    }

    // ========== 将能力附加到所有玩家 ==========
    @SubscribeEvent
    public static void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            event.addCapability(ChangedCreature.ChangedCreatureResourceLocation("crystal_ring"), new CrystalRingProvider());
        }
    }
}