package net.hhdsj.goodblock.client.renderer.latex_dragon;

import net.hhdsj.goodblock.client.models.latex_dragon.ModelLatexEmberscalesMagmaDragonMale;
import net.hhdsj.goodblock.entity.simple.LatexEmberscalesMagmaDragonMaleEntity;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.*;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleWingedDragonModel;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class LatexEmberscalesMagmaDragonMaleRenderer extends AdvancedHumanoidRenderer<LatexEmberscalesMagmaDragonMaleEntity, ModelLatexEmberscalesMagmaDragonMale> {
	public LatexEmberscalesMagmaDragonMaleRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelLatexEmberscalesMagmaDragonMale(context.bakeLayer(ModelLatexEmberscalesMagmaDragonMale.LAYER_LOCATION)),
				ArmorLatexMaleWingedDragonModel.MODEL_SET,
				0.5f);
		this.addLayer(new EmissiveBodyLayer<>(this, new ResourceLocation("goodblock:textures/entities/latex/latex_emberscales_magma_dragon_male_light.png")));
		this.addLayer(new LatexParticlesLayer<>(this, getModel()));
        this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
		this.addLayer(new CustomEyesLayer<>(this, context.getModelSet(), CustomEyesLayer::scleraColor, CustomEyesLayer.fixedColorGlowing(Color3.parseHex("#ff2700")), CustomEyesLayer.fixedColorGlowing(Color3.parseHex("#ff2700")), CustomEyesLayer::noRender, CustomEyesLayer::noRender));
		this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));
		
	}

	@Override
	public @NotNull ResourceLocation getTextureLocation(LatexEmberscalesMagmaDragonMaleEntity entity) {
		return new ResourceLocation("goodblock:textures/entities/latex/latex_emberscales_magma_dragon_male.png");
	}
}
//latex_yunqi_ice_dragon_light
