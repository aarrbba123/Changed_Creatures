package net.hhdsj.goodblock.event;

import net.hhdsj.goodblock.GoodblockMod;
import net.hhdsj.goodblock.capability.CrystalRing;
import net.hhdsj.goodblock.capability.CrystalRingProvider;
import net.hhdsj.goodblock.client.models.other.CrystalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GoodblockMod.MODID)
public class CrystalRingHandler {
    public static final Capability<CrystalRing> CAPABILITY = CapabilityManager.get(new CapabilityToken<>(){});

    @OnlyIn(Dist.CLIENT)
    public static final ModelLayerLocation LAYER = new ModelLayerLocation(GoodblockMod.GoodBlockResourceLocation("crystal"), "main");

    // ========== 注册能力和模型层 ==========
    public static void registerCapabilities(IEventBus bus) {
        bus.addListener((RegisterCapabilitiesEvent event) -> event.register(CrystalRing.class));
        bus.addListener((EntityRenderersEvent.RegisterLayerDefinitions event) -> event.registerLayerDefinition(LAYER, CrystalModel::createBodyLayer));
    }

    // ========== 将能力附加到所有玩家 ==========
    @SubscribeEvent
    public static void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            event.addCapability(GoodblockMod.GoodBlockResourceLocation("crystal_ring"), new CrystalRingProvider());
        }
    }
}