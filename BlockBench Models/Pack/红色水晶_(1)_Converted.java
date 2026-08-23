// Made with Blockbench 5.1.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class 红色水晶_(1)_Converted<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "红色水晶_(1)_converted"), "main");
	private final ModelPart bone;

	public 红色水晶_(1)_Converted(ModelPart root) {
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(2, 0).addBox(-10.0F, -7.0F, 7.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.001F))
		.texOffs(2, 0).addBox(-10.0F, -7.8F, 7.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F))
		.texOffs(4, 1).addBox(-9.5F, -0.2F, 7.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).addBox(-10.0F, -0.4F, 7.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F))
		.texOffs(4, 1).addBox(-9.5F, -8.1F, 7.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 24.0F, -8.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}