package net.hhdsj.goodblock.client.renderer.latex_dragon;

import net.hhdsj.goodblock.client.model.latex_dragon.ModelLatexYaoLingDragon;
import net.hhdsj.goodblock.entity.simple.LatexYaoLingDragonEntity;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.*;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleWingedDragonModel;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class LatexYaoLingDragonRenderer extends AdvancedHumanoidRenderer<LatexYaoLingDragonEntity, ModelLatexYaoLingDragon> {
    public LatexYaoLingDragonRenderer(EntityRendererProvider.Context context) {
        super(context, new ModelLatexYaoLingDragon(context.bakeLayer(ModelLatexYaoLingDragon.LAYER_LOCATION)),
                ArmorLatexMaleWingedDragonModel.MODEL_SET,
                0.5f);
        this.addLayer(new EmissiveBodyLayer<>(this,
                new ResourceLocation("goodblock", "textures/entities/latex/latex_yao_ling_dragon_light.png")));
        this.addLayer(new LatexParticlesLayer<>(this, getModel()));
        this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
        //this.addLayer(CustomEyesLayer.builder(this, context.getModelSet())
        this.addLayer(new CustomEyesLayer<>(this, context.getModelSet(), CustomEyesLayer::scleraColor, CustomEyesLayer.fixedColorGlowing(Color3.parseHex("#8dcfff")), CustomEyesLayer.fixedColorGlowing(Color3.parseHex("#8dcfff")), CustomEyesLayer::noRender, CustomEyesLayer::noRender));
        this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));

    }

    @Override
    public ResourceLocation getTextureLocation(LatexYaoLingDragonEntity entity) {
        return new ResourceLocation("goodblock:textures/entities/latex/latex_yao_ling_dragon.png");
    }
}
