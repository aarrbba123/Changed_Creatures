// Made with Blockbench 5.1.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class 夜枭<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "夜枭"), "main");
	private final ModelPart RightLeg;
	private final ModelPart RightLowerLeg;
	private final ModelPart RightFoot;
	private final ModelPart RightPad;
	private final ModelPart bone5;
	private final ModelPart LeftLeg;
	private final ModelPart LeftLowerLeg;
	private final ModelPart LeftFoot;
	private final ModelPart LeftPad;
	private final ModelPart bone6;
	private final ModelPart Head;
	private final ModelPart RightEar;
	private final ModelPart RightEarPivot;
	private final ModelPart LeftEar;
	private final ModelPart LeftEarPivot;
	private final ModelPart Torso;
	private final ModelPart RightWing;
	private final ModelPart rightWingRoot;
	private final ModelPart rightSecondaries;
	private final ModelPart rightTertiaries;
	private final ModelPart Tail;
	private final ModelPart TailPrimary;
	private final ModelPart TailSecondary;
	private final ModelPart TailTertiary;
	private final ModelPart TailQuaternary;
	private final ModelPart bone;
	private final ModelPart hair;
	private final ModelPart LeftWing;
	private final ModelPart leftWingRoot;
	private final ModelPart leftSecondaries;
	private final ModelPart leftTertiaries;
	private final ModelPart RightArm;
	private final ModelPart bone3;
	private final ModelPart LeftArm;
	private final ModelPart bone4;

	public 夜枭(ModelPart root) {
		this.RightLeg = root.getChild("RightLeg");
		this.RightLowerLeg = this.RightLeg.getChild("RightLowerLeg");
		this.RightFoot = this.RightLowerLeg.getChild("RightFoot");
		this.RightPad = this.RightFoot.getChild("RightPad");
		this.bone5 = this.RightPad.getChild("bone5");
		this.LeftLeg = root.getChild("LeftLeg");
		this.LeftLowerLeg = this.LeftLeg.getChild("LeftLowerLeg");
		this.LeftFoot = this.LeftLowerLeg.getChild("LeftFoot");
		this.LeftPad = this.LeftFoot.getChild("LeftPad");
		this.bone6 = this.LeftPad.getChild("bone6");
		this.Head = root.getChild("Head");
		this.RightEar = this.Head.getChild("RightEar");
		this.RightEarPivot = this.RightEar.getChild("RightEarPivot");
		this.LeftEar = this.Head.getChild("LeftEar");
		this.LeftEarPivot = this.LeftEar.getChild("LeftEarPivot");
		this.Torso = root.getChild("Torso");
		this.RightWing = this.Torso.getChild("RightWing");
		this.rightWingRoot = this.RightWing.getChild("rightWingRoot");
		this.rightSecondaries = this.rightWingRoot.getChild("rightSecondaries");
		this.rightTertiaries = this.rightSecondaries.getChild("rightTertiaries");
		this.Tail = this.Torso.getChild("Tail");
		this.TailPrimary = this.Tail.getChild("TailPrimary");
		this.TailSecondary = this.TailPrimary.getChild("TailSecondary");
		this.TailTertiary = this.TailSecondary.getChild("TailTertiary");
		this.TailQuaternary = this.TailTertiary.getChild("TailQuaternary");
		this.bone = this.TailQuaternary.getChild("bone");
		this.hair = this.Torso.getChild("hair");
		this.LeftWing = this.Torso.getChild("LeftWing");
		this.leftWingRoot = this.LeftWing.getChild("leftWingRoot");
		this.leftSecondaries = this.leftWingRoot.getChild("leftSecondaries");
		this.leftTertiaries = this.leftSecondaries.getChild("leftTertiaries");
		this.RightArm = root.getChild("RightArm");
		this.bone3 = this.RightArm.getChild("bone3");
		this.LeftArm = root.getChild("LeftArm");
		this.bone4 = this.LeftArm.getChild("bone4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offset(-2.5F, 10.5F, 0.0F));

		PartDefinition RightThigh_r1 = RightLeg.addOrReplaceChild("RightThigh_r1", CubeListBuilder.create().texOffs(24, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition RightLowerLeg = RightLeg.addOrReplaceChild("RightLowerLeg", CubeListBuilder.create(), PartPose.offset(0.0F, 6.375F, -3.45F));

		PartDefinition RightCalf_r1 = RightLowerLeg.addOrReplaceChild("RightCalf_r1", CubeListBuilder.create().texOffs(48, 17).addBox(-1.99F, -0.125F, -2.9F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, -2.125F, 1.95F, 0.8727F, 0.0F, 0.0F));

		PartDefinition RightFoot = RightLowerLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create(), PartPose.offset(0.0F, 0.8F, 7.175F));

		PartDefinition RightArch_r1 = RightFoot.addOrReplaceChild("RightArch_r1", CubeListBuilder.create().texOffs(60, 41).addBox(-2.0F, -8.45F, -0.725F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.005F)), PartPose.offsetAndRotation(0.0F, 7.075F, -4.975F, -0.3491F, 0.0F, 0.0F));

		PartDefinition RightPad = RightFoot.addOrReplaceChild("RightPad", CubeListBuilder.create().texOffs(56, 27).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.325F, -4.425F));

		PartDefinition bone5 = RightPad.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(74, 47).addBox(-10.0F, 9.2F, -1.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(66, 74).addBox(-13.0F, 9.2F, -1.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(62, 69).addBox(-12.0F, 9.2F, -1.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(62, 71).addBox(-11.0F, 9.2F, -1.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(70, 67).addBox(-12.0F, 9.1F, -0.1F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, -8.0F, -0.55F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offset(2.5F, 10.5F, 0.0F));

		PartDefinition LeftThigh_r1 = LeftLeg.addOrReplaceChild("LeftThigh_r1", CubeListBuilder.create().texOffs(40, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition LeftLowerLeg = LeftLeg.addOrReplaceChild("LeftLowerLeg", CubeListBuilder.create(), PartPose.offset(0.0F, 6.375F, -3.45F));

		PartDefinition LeftCalf_r1 = LeftLowerLeg.addOrReplaceChild("LeftCalf_r1", CubeListBuilder.create().texOffs(0, 51).addBox(-2.01F, -0.125F, -2.9F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, -2.125F, 1.95F, 0.8727F, 0.0F, 0.0F));

		PartDefinition LeftFoot = LeftLowerLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create(), PartPose.offset(0.0F, 0.8F, 7.175F));

		PartDefinition LeftArch_r1 = LeftFoot.addOrReplaceChild("LeftArch_r1", CubeListBuilder.create().texOffs(52, 60).addBox(-2.0F, -8.45F, -0.725F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.005F)), PartPose.offsetAndRotation(0.0F, 7.075F, -4.975F, -0.3491F, 0.0F, 0.0F));

		PartDefinition LeftPad = LeftFoot.addOrReplaceChild("LeftPad", CubeListBuilder.create().texOffs(56, 34).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.325F, -4.425F));

		PartDefinition bone6 = LeftPad.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(74, 43).addBox(12.0F, 9.2F, -1.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(74, 45).addBox(9.0F, 9.2F, -1.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(56, 41).addBox(10.0F, 9.2F, -1.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(52, 58).addBox(11.0F, 9.2F, -1.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(70, 64).addBox(10.0F, 9.1F, -0.1F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, -8.0F, -0.55F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(68, 0).addBox(-2.0F, -3.0F, -6.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(72, 7).addBox(-1.5F, -1.0F, -5.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(42, 74).addBox(-0.5F, -3.4F, -6.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.0F, -0.5F, 0.0F));

		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(70, 60).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.3F))
		.texOffs(48, 27).addBox(-5.1F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(2.05F, -7.8F, -1.7F, 1.1345F, 0.0F, 0.0F));

		PartDefinition cube_r2 = Head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(34, 64).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.5F))
		.texOffs(0, 66).addBox(-5.1F, -2.0F, -1.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(2.05F, -7.8F, -1.8F, 1.0472F, 0.0F, 0.0F));

		PartDefinition RightEar = Head.addOrReplaceChild("RightEar", CubeListBuilder.create(), PartPose.offset(-3.0F, -7.7F, 2.0F));

		PartDefinition RightEarPivot = RightEar.addOrReplaceChild("RightEarPivot", CubeListBuilder.create().texOffs(30, 70).addBox(-1.9F, -1.2F, -1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.05F))
		.texOffs(8, 72).addBox(-0.9F, -1.6F, -0.4F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.04F))
		.texOffs(72, 56).addBox(-0.9F, -0.6F, 0.1F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.04F))
		.texOffs(74, 29).addBox(-0.9F, -2.3F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.05F))
		.texOffs(74, 41).addBox(0.1F, -3.4F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(0.5F, -1.25F, 0.0F, -0.1309F, 0.5236F, -0.3491F));

		PartDefinition LeftEar = Head.addOrReplaceChild("LeftEar", CubeListBuilder.create(), PartPose.offset(3.0F, -7.7F, 2.0F));

		PartDefinition LeftEarPivot = LeftEar.addOrReplaceChild("LeftEarPivot", CubeListBuilder.create().texOffs(38, 70).addBox(-1.1F, -1.2F, -1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.05F))
		.texOffs(72, 52).addBox(-1.1F, -1.6F, -0.4F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.04F))
		.texOffs(70, 73).addBox(-1.1F, -0.6F, 0.1F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.04F))
		.texOffs(74, 27).addBox(-1.1F, -2.3F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.05F))
		.texOffs(74, 39).addBox(-1.1F, -3.4F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-0.5F, -1.25F, 0.0F, -0.1309F, -0.5236F, 0.3491F));

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 0.0F));

		PartDefinition RightWing = Torso.addOrReplaceChild("RightWing", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, 5.0F, 2.0F, 0.0F, 0.48F, 0.0F));

		PartDefinition rightWingRoot = RightWing.addOrReplaceChild("rightWingRoot", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r3 = rightWingRoot.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 61).addBox(-25.975F, -4.475F, 1.65F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 20.0F, -2.0F, 0.0F, 0.0F, 1.2654F));

		PartDefinition cube_r4 = rightWingRoot.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 48).addBox(-30.075F, -12.7F, 1.2F, 11.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 20.0F, -2.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r5 = rightWingRoot.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(64, 24).addBox(-12.775F, -19.75F, 1.2F, 5.0F, 2.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(2.0F, 20.0F, -2.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition rightSecondaries = rightWingRoot.addOrReplaceChild("rightSecondaries", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.3F, -7.0F, -0.5F, 0.0F, 0.0F, 0.5236F));

		PartDefinition cube_r6 = rightSecondaries.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(14, 64).addBox(1.025F, -30.55F, 1.2F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.3F, 27.0F, -1.5F, 0.0F, 0.0F, -0.48F));

		PartDefinition cube_r7 = rightSecondaries.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(48, 0).addBox(-5.5F, -2.5F, 0.0F, 10.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0551F, 6.3129F, 0.151F, 0.0F, 0.0F, 1.5272F));

		PartDefinition cube_r8 = rightSecondaries.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(50, 69).addBox(-0.5F, -6.0F, -0.5F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-3.6495F, 5.6238F, 0.2F, 0.0F, 0.0F, 0.0262F));

		PartDefinition cube_r9 = rightSecondaries.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(16, 58).addBox(-24.525F, -13.85F, 1.648F, 9.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.3F, 27.0F, -1.5F, 0.0F, 0.0F, 0.7418F));

		PartDefinition rightTertiaries = rightSecondaries.addOrReplaceChild("rightTertiaries", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.7F, -1.1F, 0.0F, 0.0F, 0.0F, 0.9599F));

		PartDefinition cube_r10 = rightTertiaries.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(46, 64).addBox(2.3F, -28.5F, 1.2F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(10.2F, 26.5F, -1.5F, 0.0F, 0.0F, -0.48F));

		PartDefinition cube_r11 = rightTertiaries.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(16, 52).addBox(-26.125F, -10.525F, 1.64F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 26.3F, -1.5F, 0.0F, 0.0F, 0.8727F));

		PartDefinition Tail = Torso.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(0.0F, 11.0F, 0.0F));

		PartDefinition TailPrimary = Tail.addOrReplaceChild("TailPrimary", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r12 = TailPrimary.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(116, -6).addBox(-1.0F, -3.0F, -4.0F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.1F, 4.8F, -0.5236F, 0.0F, 0.0F));

		PartDefinition Base_r1 = TailPrimary.addOrReplaceChild("Base_r1", CubeListBuilder.create().texOffs(0, 96).addBox(-2.0F, -2.9F, 0.4F, 4.0F, 4.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition TailSecondary = TailPrimary.addOrReplaceChild("TailSecondary", CubeListBuilder.create(), PartPose.offset(0.0F, 0.925F, 4.5F));

		PartDefinition cube_r13 = TailSecondary.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(118, -2).addBox(-1.0F, -3.0F, -4.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.775F, 5.7F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Base_r2 = TailSecondary.addOrReplaceChild("Base_r2", CubeListBuilder.create().texOffs(24, 43).addBox(-1.5F, -1.4F, -2.7F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.1F, 3.2F, -0.3927F, 0.0F, 0.0F));

		PartDefinition TailTertiary = TailSecondary.addOrReplaceChild("TailTertiary", CubeListBuilder.create(), PartPose.offset(0.0F, 2.5F, 5.0F));

		PartDefinition cube_r14 = TailTertiary.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(118, 1).addBox(-1.0F, -3.0F, -4.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.275F, 5.4F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Base_r3 = TailTertiary.addOrReplaceChild("Base_r3", CubeListBuilder.create().texOffs(42, 43).addBox(-1.5F, -13.225F, 6.6F, 3.0F, 3.0F, 6.0F, new CubeDeformation(-0.22F)), PartPose.offsetAndRotation(0.0F, 11.6F, -7.8F, -0.1309F, 0.0F, 0.0F));

		PartDefinition TailQuaternary = TailTertiary.addOrReplaceChild("TailQuaternary", CubeListBuilder.create(), PartPose.offset(0.0F, 0.5F, 4.5F));

		PartDefinition Base_r4 = TailQuaternary.addOrReplaceChild("Base_r4", CubeListBuilder.create().texOffs(22, 64).addBox(-1.0F, -10.45F, 13.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, 11.1F, -12.3F, 0.0436F, 0.0F, 0.0F));

		PartDefinition bone = TailQuaternary.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(68, 10).addBox(0.0F, -10.8432F, 15.9015F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.4F, -12.7F, 0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r15 = bone.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(22, 70).addBox(2.1568F, -3.0F, -0.3985F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6F, -11.4F, 16.3F, 0.0F, 0.0F, 1.5708F));

		PartDefinition hair = Torso.addOrReplaceChild("hair", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r16 = hair.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(64, 22).addBox(-6.0F, 0.0F, -1.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 1.5929F, -1.2929F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r17 = hair.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(60, 50).addBox(-6.0F, 0.0F, -1.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 0.7929F, -1.2929F, -0.7854F, 0.0F, 0.0F));

		PartDefinition LeftWing = Torso.addOrReplaceChild("LeftWing", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, 5.0F, 2.0F, 0.0F, -0.48F, 0.0F));

		PartDefinition leftWingRoot = LeftWing.addOrReplaceChild("leftWingRoot", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r18 = leftWingRoot.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(64, 17).addBox(18.975F, -4.475F, 1.65F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 20.0F, -2.0F, 0.0F, 0.0F, -1.2654F));

		PartDefinition cube_r19 = leftWingRoot.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(48, 7).addBox(19.075F, -12.7F, 1.2F, 11.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 20.0F, -2.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r20 = leftWingRoot.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(68, 4).addBox(7.775F, -19.75F, 1.2F, 5.0F, 2.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-2.0F, 20.0F, -2.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition leftSecondaries = leftWingRoot.addOrReplaceChild("leftSecondaries", CubeListBuilder.create(), PartPose.offsetAndRotation(7.3F, -7.0F, -0.5F, 0.0F, 0.0F, -0.5236F));

		PartDefinition cube_r21 = leftSecondaries.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(18, 64).addBox(-2.025F, -30.55F, 1.2F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.3F, 27.0F, -1.5F, 0.0F, 0.0F, 0.48F));

		PartDefinition cube_r22 = leftSecondaries.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(48, 10).addBox(-4.5F, -2.5F, 0.0F, 10.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0551F, 6.3129F, 0.151F, 0.0F, 0.0F, -1.5272F));

		PartDefinition cube_r23 = leftSecondaries.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(34, 58).addBox(15.525F, -13.85F, 1.648F, 9.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.3F, 27.0F, -1.5F, 0.0F, 0.0F, -0.7418F));

		PartDefinition cube_r24 = leftSecondaries.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(54, 69).addBox(-0.5F, -6.0F, -0.5F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(3.6495F, 5.6238F, 0.2F, 0.0F, 0.0F, -0.0262F));

		PartDefinition leftTertiaries = leftSecondaries.addOrReplaceChild("leftTertiaries", CubeListBuilder.create(), PartPose.offsetAndRotation(3.7F, -1.1F, 0.0F, 0.0F, 0.0F, -0.9599F));

		PartDefinition cube_r25 = leftTertiaries.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(66, 60).addBox(-3.3F, -28.5F, 1.2F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-10.2F, 26.5F, -1.5F, 0.0F, 0.0F, 0.48F));

		PartDefinition cube_r26 = leftTertiaries.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(36, 52).addBox(16.125F, -10.525F, 1.64F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 26.3F, -1.5F, 0.0F, 0.0F, -0.8727F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(32, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offset(-5.0F, 1.5F, 0.0F));

		PartDefinition bone3 = RightArm.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(34, 74).addBox(0.0F, 9.2F, -1.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(74, 35).addBox(-3.0F, 9.2F, -1.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(74, 37).addBox(-2.0F, 9.2F, -1.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(38, 74).addBox(-1.0F, 9.2F, -1.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(0, 72).addBox(-2.0F, 9.1F, -0.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(32, 0).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offset(5.0F, 1.5F, 0.0F));

		PartDefinition bone4 = LeftArm.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(62, 73).addBox(2.0F, 9.2F, -1.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(30, 74).addBox(-1.0F, 9.2F, -1.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(74, 31).addBox(0.0F, 9.2F, -1.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(74, 33).addBox(1.0F, 9.2F, -1.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(70, 70).addBox(0.0F, 9.1F, -0.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}