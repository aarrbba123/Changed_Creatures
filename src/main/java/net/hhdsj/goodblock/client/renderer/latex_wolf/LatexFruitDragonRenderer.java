package net.hhdsj.goodblock.client.renderer.latex_wolf;

import net.hhdsj.goodblock.client.model.latex_wolf.ModelLatexFruitDragonWolf;

import net.hhdsj.goodblock.entity.simple.LatexFruitDragonEntity;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.*;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleWolfModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class LatexFruitDragonRenderer extends AdvancedHumanoidRenderer<LatexFruitDragonEntity, ModelLatexFruitDragonWolf> {
    public LatexFruitDragonRenderer(EntityRendererProvider.Context context) {

        super(context, new ModelLatexFruitDragonWolf(context.bakeLayer(ModelLatexFruitDragonWolf.LAYER_LOCATION)),
                ArmorLatexMaleWolfModel.MODEL_SET,
                0.5f);
        this.addLayer(new LatexParticlesLayer<>(this, this.getModel()));
        this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
        this.addLayer(new CustomEyesLayer<>(this, context.getModelSet(), CustomEyesLayer::scleraColor, CustomEyesLayer::glowingIrisColorLeft, CustomEyesLayer::glowingIrisColorRight, CustomEyesLayer::noRender, CustomEyesLayer::noRender));
        this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));

    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull LatexFruitDragonEntity entity) {
        return new ResourceLocation("goodblock:textures/entities/latex/latex_dragon_fruit.png");
    }
}
