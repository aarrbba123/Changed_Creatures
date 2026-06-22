
package net.hhdsj.goodblock.client.renderer;

import net.hhdsj.goodblock.client.models.LatexFishSmallModel;
import net.hhdsj.goodblock.entity.LatexFishEntity;
import net.hhdsj.goodblock.entity.LatexKcahraSharkEntity;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.*;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleSharkModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class LatexFishRenderer extends AdvancedHumanoidRenderer<LatexFishEntity, LatexFishSmallModel>{
	public LatexFishRenderer(EntityRendererProvider.Context context) {
		super(context, new LatexFishSmallModel(context.bakeLayer(LatexFishSmallModel.LAYER_LOCATION)),
            ArmorLatexMaleSharkModel.MODEL_SET,
            0.5f);
		this.addLayer(new LatexParticlesLayer<>(this, this.getModel()));
	}

	@Override
	public ResourceLocation getTextureLocation(LatexFishEntity entity) {
		return new ResourceLocation("goodblock:textures/entities/latex_fish.png");
	}
}
