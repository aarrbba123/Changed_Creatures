package net.hhdsj.goodblock.client;

import net.hhdsj.goodblock.GoodblockMod;
import net.hhdsj.goodblock.client.models.other.CrystalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;

@OnlyIn(Dist.CLIENT)
public class ClientHandler {
    public static final ModelLayerLocation LAYER = new ModelLayerLocation(
        GoodblockMod.GoodBlockResourceLocation("crystal"), "main"
    );

    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(LAYER, CrystalModel::createBodyLayer);
    }
}