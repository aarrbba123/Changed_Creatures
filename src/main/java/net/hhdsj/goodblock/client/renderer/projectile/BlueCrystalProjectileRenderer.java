// 文件名：BlueCrystalProjectileRenderer.java
package net.hhdsj.goodblock.client.renderer.projectile;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.hhdsj.goodblock.client.model.other.CrystalJavelinModel;
import net.hhdsj.goodblock.entity.BlueCrystalProjectile;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class BlueCrystalProjectileRenderer extends EntityRenderer<BlueCrystalProjectile> {
    // 你的模型纹理文件路径
    private static final ResourceLocation TEXTURE =
            new ResourceLocation("goodblock", "textures/entity/crystal_javelin.png");

    private final CrystalJavelinModel<BlueCrystalProjectile> model;

    public BlueCrystalProjectileRenderer(EntityRendererProvider.Context context) {
        super(context);
        ModelPart modelPart = context.bakeLayer(CrystalJavelinModel.LAYER_LOCATION);
        this.model = new CrystalJavelinModel<>(modelPart);
    }

    @Override
    public void render(BlueCrystalProjectile entity, float entityYaw, float partialTicks,
                       PoseStack poseStack, @NotNull MultiBufferSource bufferSource,
                       int packedLight) {

        poseStack.pushPose();

        float rotationYaw = entity.getYRot() + 90.0F; // 90度偏移调整朝向
        float rotationPitch = -entity.getXRot();

        poseStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(rotationYaw));
        poseStack.mulPose(com.mojang.math.Axis.XP.rotationDegrees(rotationPitch));

        float spin = (entity.tickCount + partialTicks) * 0.5f;
        poseStack.mulPose(com.mojang.math.Axis.ZP.rotationDegrees(spin));

        poseStack.scale(0.8F, 0.8F, 0.8F);

        VertexConsumer vertexConsumer = bufferSource.getBuffer(
                RenderType.entityCutoutNoCull(this.getTextureLocation(entity))
        );
        this.model.renderToBuffer(poseStack, vertexConsumer, packedLight,
                OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        poseStack.popPose();

        super.render(entity, entityYaw, partialTicks, poseStack, bufferSource, packedLight);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull BlueCrystalProjectile entity) {
        return TEXTURE;
    }
}