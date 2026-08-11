package net.hhdsj.changed_creatures.block;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.client.renderer.RenderType;

public class CryoSubjectChamberRenderer implements BlockEntityRenderer<CryoSubjectChamberBlockEntity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public CryoSubjectChamberRenderer(BlockEntityRendererProvider.Context context) {
        this.blockRenderDispatcher = context.getBlockRenderDispatcher();
    }

    @Override
    public void render(CryoSubjectChamberBlockEntity blockEntity, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        Level level = blockEntity.getLevel();
        if (level == null) return;

        BlockPos pos = blockEntity.getBlockPos();
        BlockState state = blockEntity.getBlockState();

        if (state == null || state.isAir()) return;

        poseStack.pushPose();
        poseStack.translate(0, 1.0, 0);

        // 获取模型
        var model = blockRenderDispatcher.getBlockModel(state);
        var vertexConsumer = bufferSource.getBuffer(RenderType.translucent());

        blockRenderDispatcher.getModelRenderer().renderModel(
                poseStack.last(),
                vertexConsumer,
                state,
                model,
                1.0f, 1.0f, 1.0f,
                packedLight,
                OverlayTexture.NO_OVERLAY
        );

        poseStack.popPose();
    }

    @Override
    public int getViewDistance() {
        return 64;
    }
}