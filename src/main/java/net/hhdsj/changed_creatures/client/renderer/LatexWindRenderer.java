package net.hhdsj.changed_creatures.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.hhdsj.changed_creatures.client.models.other.ModelLatexWind;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

public class LatexWindRenderer extends ElytraLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {

    private static final ResourceLocation WINGS_TEXTURE =
            new ResourceLocation("changed_creatures:textures/entities/latex_wind.png");

    private final ModelLatexWind wingsModel;

    public LatexWindRenderer(RenderLayerParent<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> renderer,
                             EntityModelSet entityModelSet) {
        super(renderer, entityModelSet);
        this.wingsModel = new ModelLatexWind(entityModelSet.bakeLayer(ModelLatexWind.LAYER_LOCATION));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight,
                       AbstractClientPlayer player, float limbSwing, float limbSwingAmount,
                       float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {

        ItemStack chestItem = player.getItemBySlot(EquipmentSlot.CHEST);

        if (!shouldRender(chestItem, player)) {
            return;
        }

        ResourceLocation texture = getElytraTexture(chestItem, player);

        poseStack.pushPose();
        poseStack.translate(0.0F, 0.0F, 0.0F);

        this.getParentModel().copyPropertiesTo(this.wingsModel);

        this.wingsModel.setupAnim(player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

        // 渲染翅膀
        VertexConsumer vertexConsumer = ItemRenderer.getArmorFoilBuffer(
                buffer,
                RenderType.armorCutoutNoCull(texture),
                false,
                chestItem.hasFoil()
        );

        this.wingsModel.renderToBuffer(
                poseStack,
                vertexConsumer,
                packedLight,
                OverlayTexture.NO_OVERLAY,
                1.0F, 1.0F, 1.0F, 1.0F
        );

        poseStack.popPose();
    }

    @Override
    public boolean shouldRender(ItemStack stack, AbstractClientPlayer entity) {
        // return stack.getItem() == ModItems.LATEX_WIND.get();

        return !entity.isInvisible() && !entity.isSpectator();
    }

    @Override
    public ResourceLocation getElytraTexture(ItemStack stack, AbstractClientPlayer entity) {
        return WINGS_TEXTURE;
    }
}