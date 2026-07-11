package net.hhdsj.goodblock.client.renderer.latex_taur;

import com.mojang.blaze3d.vertex.PoseStack;
import net.hhdsj.goodblock.client.models.latex_taur.ModelLatexFrostScaleDragonTaur;
import net.hhdsj.goodblock.entity.simple.LatexFrostScaleDragonTaurEntity;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.*;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexCentaurLowerModel;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleTaurUpperModel;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorModelPicker;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.SaddleLayer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class LatexFrostScaleDragonTaurRenderer extends AdvancedHumanoidRenderer<LatexFrostScaleDragonTaurEntity, ModelLatexFrostScaleDragonTaur> {
    public LatexFrostScaleDragonTaurRenderer(EntityRendererProvider.Context context) {
        super(context, new ModelLatexFrostScaleDragonTaur(context.bakeLayer(ModelLatexFrostScaleDragonTaur.LAYER_LOCATION)),
                ArmorModelPicker.centaur(context.getModelSet(), ArmorLatexMaleTaurUpperModel.MODEL_SET, ArmorLatexCentaurLowerModel.MODEL_SET_WITH_TORSO), 0.7f);
        this.addLayer(new LatexParticlesLayer<>(this, getModel()));
        this.addLayer(new EmissiveBodyLayer<>(this, new ResourceLocation("goodblock", "textures/entities/latex/latex_taur/latex_frost_scale_dragon_taur_light.png")));
        this.addLayer(new CustomEyesLayer<>(this, context.getModelSet(), CustomEyesLayer::scleraColor,
                CustomEyesLayer.fixedColorGlowing(Color3.parseHex("#00ffff")), CustomEyesLayer.fixedColorGlowing(Color3.parseHex("#00ffff")),
                CustomEyesLayer::noRender, CustomEyesLayer::noRender));
        this.addLayer(new SaddleLayer<>(this, getModel(), new ResourceLocation("goodblock:textures/entities/latex/latex_taur/latex_frost_scale_dragon_taur_saddle.png")));
        this.addLayer(new TaurChestPackLayer<>(this, context.getModelSet()));
        this.addLayer(TransfurCapeLayer.shortCape(this, context.getModelSet()));
        this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull LatexFrostScaleDragonTaurEntity p_114482_) {
        return new ResourceLocation("goodblock:textures/entities/latex/latex_taur/latex_frost_scale_dragon_taur.png");
    }

    @Override
    protected void scale(@NotNull LatexFrostScaleDragonTaurEntity entity, PoseStack poseStack, float partialTickTime) {
        float scaleFactor = 1.35F;
        poseStack.scale(scaleFactor, scaleFactor, scaleFactor);
        super.scale(entity, poseStack, partialTickTime);
    }
}