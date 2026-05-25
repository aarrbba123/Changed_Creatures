package net.hhdsj.goodblock.client.renderer.latex_dragon;

import net.hhdsj.goodblock.client.renderer.models.latex_dragon.ModelLatexLuoLongDragonShark;
import net.hhdsj.goodblock.entity.simple.LatexLuoLongDragonSharkEntity;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.*;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleWingedDragonModel;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class LatexLuoLongDragonSharkRenderer extends AdvancedHumanoidRenderer<LatexLuoLongDragonSharkEntity, ModelLatexLuoLongDragonShark> {
    public LatexLuoLongDragonSharkRenderer(EntityRendererProvider.Context context) {

        super(context, new ModelLatexLuoLongDragonShark(context.bakeLayer(ModelLatexLuoLongDragonShark.LAYER_LOCATION)),
                ArmorLatexMaleWingedDragonModel.MODEL_SET,
                0.5f);
        this.addLayer(new EmissiveBodyLayer<>(this, new ResourceLocation("goodblock", "textures/entities/latex/light_latex_luolong_dragon_shark.png")));
        this.addLayer(new LatexParticlesLayer<>(this, getModel()));
        this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
        this.addLayer(new CustomEyesLayer<>(this, context.getModelSet()));
        this.addLayer(new CustomEyesLayer<>(this, context.getModelSet(), CustomEyesLayer::scleraColor, CustomEyesLayer.fixedColorGlowing(Color3.parseHex("#e2506c")), CustomEyesLayer.fixedColorGlowing(Color3.parseHex("#e2506c")), CustomEyesLayer::noRender, CustomEyesLayer::noRender));
        this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(LatexLuoLongDragonSharkEntity entity) {
        return new ResourceLocation("goodblock:textures/entities/latex/latex_luolong_dragon_shark.png");
    }
}