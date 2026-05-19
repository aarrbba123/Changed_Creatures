package net.hhdsj.goodblock.client.renderer.projectile;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.hhdsj.goodblock.entity.ThrownCrystalJavelinTrident;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.hhdsj.goodblock.init.GoodblockModItems;
import org.jetbrains.annotations.NotNull;

public class ThrownCrystalJavelinTridentRenderer extends EntityRenderer<ThrownCrystalJavelinTrident> {

    public static final ResourceLocation TEXTURE =
            new ResourceLocation("goodblock", "textures/item/thrown_crystal_javelin_trident.png");

    private final ItemRenderer itemRenderer;

    public ThrownCrystalJavelinTridentRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(ThrownCrystalJavelinTrident entity, float entityYaw, float partialTicks,
                       @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();

        // 三叉戟的旋转和位置调整
        poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entity.yRotO, entity.getYRot()) - 90.0F));
        poseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTicks, entity.xRotO, entity.getXRot()) + 90.0F));

        // 渲染物品模型
        ItemStack itemStack = new ItemStack(GoodblockModItems.CRYSTAL_JAVELIN.get());
        this.itemRenderer.renderStatic(
                itemStack,
                ItemDisplayContext.FIXED,
                packedLight,
                OverlayTexture.NO_OVERLAY,
                poseStack,
                buffer,
                entity.level(),
                0
        );

        poseStack.popPose();
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    @NotNull
    public ResourceLocation getTextureLocation(@NotNull ThrownCrystalJavelinTrident entity) {
        return TEXTURE;
    }
}