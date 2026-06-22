package net.hhdsj.goodblock.mixin.Player;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.hhdsj.goodblock.GoodblockMod;
import net.hhdsj.goodblock.capability.CrystalRing;
import net.hhdsj.goodblock.client.models.other.CrystalModel;
import net.hhdsj.goodblock.event.CrystalRingHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerRenderer.class)
public class CrystalPlayerRendererMixin {

    @Unique
    private static final Capability<CrystalRing> goodblock$CAPABILITY = CrystalRingHandler.CAPABILITY;
    @Unique
    private static final ModelLayerLocation goodblock$LAYER =
            new ModelLayerLocation(GoodblockMod.GoodBlockResourceLocation("crystal"), "main");

    @Inject(method = "render*",at = @At("RETURN"))
    private void renderCrystalRing(AbstractClientPlayer player, float entityYaw, float partialTicks, PoseStack poseStack,
                                   MultiBufferSource bufferSource, int packedLight, CallbackInfo ci) {
        boolean active = player.getCapability(goodblock$CAPABILITY).map(CrystalRing::isActive).orElse(false);
        if (!active) return;

        if (player.isInvisible() || !player.isAlive() || player.getPose() == Pose.SLEEPING) {
            return;
        }

        ModelPart part = Minecraft.getInstance().getEntityModels().bakeLayer(goodblock$LAYER);
        CrystalModel model = new CrystalModel(part);
        long time = player.level().getGameTime();
        float pt = partialTicks;

        for (int i = 0; i < 8; i++) {
            double angle = Math.toRadians((time + pt) * 2.0f + i * 45.0);
            float x = (float) (1.2 * Math.cos(angle));
            float z = (float) (1.2 * Math.sin(angle));
            float y = (float) (Math.sin((time + pt + i * 10) * 0.1) * 0.15) + 1.5f;

            poseStack.pushPose();
            poseStack.translate(x, y, z);
            poseStack.mulPose(Axis.YP.rotationDegrees((time + pt + i * 45) * 1.5f));
            poseStack.mulPose(Axis.XP.rotationDegrees(15));
            poseStack.scale(0.5f, 0.7f, 0.5f);

            model.renderToBuffer(poseStack, bufferSource.getBuffer(RenderType.entityTranslucentEmissive(CrystalModel.TEXTURE)),
                    packedLight, 0, 1.0f, 0.1f, 0.1f, 0.9f);
            poseStack.popPose();
        }
    }
}