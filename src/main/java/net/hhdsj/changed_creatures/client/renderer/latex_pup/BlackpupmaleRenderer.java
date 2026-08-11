
package net.hhdsj.changed_creatures.client.renderer.latex_pup;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.hhdsj.changed_creatures.entity.simple.BlackpupmaleEntity;
import net.hhdsj.changed_creatures.client.models.latex_pup.ModelBlackPupMale;

import net.ltxprogrammer.changed.client.renderer.layers.CustomEyesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.LatexParticlesLayer;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorNoneModel;
import net.ltxprogrammer.changed.util.Color3;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.minecraft.world.entity.Pose;


public class BlackpupmaleRenderer extends AdvancedHumanoidRenderer<BlackpupmaleEntity, ModelBlackPupMale> {
	public BlackpupmaleRenderer (EntityRendererProvider.Context context) {
		super(context, new ModelBlackPupMale(context.bakeLayer(ModelBlackPupMale.LAYER_LOCATION)),
				//ArmorNoneModel::new, 
				ArmorNoneModel.MODEL_SET, 
				0.4F);
		this.addLayer(new LatexParticlesLayer<>(this, this.model));

		this.addLayer(CustomEyesLayer.builder(this, context.getModelSet())
				.withSclera(Color3.fromInt(0x242424))
				.withIris(CustomEyesLayer.fixedIfNotDarkLatexOverrideLeft(Color3.BLACK),
						CustomEyesLayer.fixedIfNotDarkLatexOverrideRight(Color3.BLACK))
				.build()
				.setHeadShape(CustomEyesLayer.HeadShape.PUP_CONCAVE));
	}

	@Override
	protected float getFlipDegrees(BlackpupmaleEntity entity) {
		return entity.getPose() == Pose.SLEEPING ? 0.0F : super.getFlipDegrees(entity);
	}

	@Override
	public ResourceLocation getTextureLocation(BlackpupmaleEntity entity) {
		return new ResourceLocation("changed_creatures:textures/entities/latex/texture.png");
	}

}
