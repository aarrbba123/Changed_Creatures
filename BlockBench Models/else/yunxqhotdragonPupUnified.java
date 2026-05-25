// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class yunxqhotdragonPupUnified<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this models's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "yunxqhotdragonpupunified"), "main");
	private final ModelPart RightLeg;
	private final ModelPart RightLowerLeg;
	private final ModelPart RightFoot;
	private final ModelPart RightPad;
	private final ModelPart LeftLeg;
	private final ModelPart LeftLowerLeg;
	private final ModelPart LeftFoot;
	private final ModelPart LeftPad;
	private final ModelPart Head;
	private final ModelPart RightEar;
	private final ModelPart RightEarPivot;
	private final ModelPart LeftEar;
	private final ModelPart LeftEarPivot;
	private final ModelPart Hair;
	private final ModelPart bone;
	private final ModelPart bone2;
	private final ModelPart Torso;
	private final ModelPart LeftWing;
	private final ModelPart leftWingRoot;
	private final ModelPart leftSecondaries;
	private final ModelPart leftTertiaries;
	private final ModelPart RightWing;
	private final ModelPart rightWingRoot;
	private final ModelPart rightSecondaries;
	private final ModelPart rightTertiaries;
	private final ModelPart Tail;
	private final ModelPart TailPrimary;
	private final ModelPart TailSecondary;
	private final ModelPart TailTertiary;
	private final ModelPart TailQuaternary;
	private final ModelPart RightArm;
	private final ModelPart RightArm2;
	private final ModelPart RightLowerArm2;
	private final ModelPart RightFoot2;
	private final ModelPart RightPad2;
	private final ModelPart LeftArm;
	private final ModelPart LeftArm2;
	private final ModelPart LeftLowerArm2;
	private final ModelPart LeftFoot2;
	private final ModelPart LeftPad2;

	public yunxqhotdragonPupUnified(ModelPart root) {
		this.RightLeg = root.getChild("RightLeg");
		this.RightLowerLeg = this.RightLeg.getChild("RightLowerLeg");
		this.RightFoot = this.RightLowerLeg.getChild("RightFoot");
		this.RightPad = this.RightFoot.getChild("RightPad");
		this.LeftLeg = root.getChild("LeftLeg");
		this.LeftLowerLeg = this.LeftLeg.getChild("LeftLowerLeg");
		this.LeftFoot = this.LeftLowerLeg.getChild("LeftFoot");
		this.LeftPad = this.LeftFoot.getChild("LeftPad");
		this.Head = root.getChild("Head");
		this.RightEar = this.Head.getChild("RightEar");
		this.RightEarPivot = this.RightEar.getChild("RightEarPivot");
		this.LeftEar = this.Head.getChild("LeftEar");
		this.LeftEarPivot = this.LeftEar.getChild("LeftEarPivot");
		this.Hair = this.Head.getChild("Hair");
		this.bone = this.Head.getChild("bone");
		this.bone2 = this.Head.getChild("bone2");
		this.Torso = root.getChild("Torso");
		this.LeftWing = this.Torso.getChild("LeftWing");
		this.leftWingRoot = this.LeftWing.getChild("leftWingRoot");
		this.leftSecondaries = this.leftWingRoot.getChild("leftSecondaries");
		this.leftTertiaries = this.leftSecondaries.getChild("leftTertiaries");
		this.RightWing = this.Torso.getChild("RightWing");
		this.rightWingRoot = this.RightWing.getChild("rightWingRoot");
		this.rightSecondaries = this.rightWingRoot.getChild("rightSecondaries");
		this.rightTertiaries = this.rightSecondaries.getChild("rightTertiaries");
		this.Tail = this.Torso.getChild("Tail");
		this.TailPrimary = this.Tail.getChild("TailPrimary");
		this.TailSecondary = this.TailPrimary.getChild("TailSecondary");
		this.TailTertiary = this.TailSecondary.getChild("TailTertiary");
		this.TailQuaternary = this.TailTertiary.getChild("TailQuaternary");
		this.RightArm = root.getChild("RightArm");
		this.RightArm2 = this.RightArm.getChild("RightArm2");
		this.RightLowerArm2 = this.RightArm2.getChild("RightLowerArm2");
		this.RightFoot2 = this.RightLowerArm2.getChild("RightFoot2");
		this.RightPad2 = this.RightFoot2.getChild("RightPad2");
		this.LeftArm = root.getChild("LeftArm");
		this.LeftArm2 = this.LeftArm.getChild("LeftArm2");
		this.LeftLowerArm2 = this.LeftArm2.getChild("LeftLowerArm2");
		this.LeftFoot2 = this.LeftLowerArm2.getChild("LeftFoot2");
		this.LeftPad2 = this.LeftFoot2.getChild("LeftPad2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offset(-2.0F, 18.0F, -2.0F));

		PartDefinition RightThigh_r1 = RightLeg.addOrReplaceChild("RightThigh_r1", CubeListBuilder.create().texOffs(40, 22).mirror().addBox(0.0F, 2.075F, -2.1F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, -4.5F, 0.5F, -0.2182F, 0.0F, 0.0F));

		PartDefinition RightLowerLeg = RightLeg.addOrReplaceChild("RightLowerLeg", CubeListBuilder.create(), PartPose.offset(-0.5F, 0.875F, -2.95F));

		PartDefinition RightCalf_r1 = RightLowerLeg.addOrReplaceChild("RightCalf_r1", CubeListBuilder.create().texOffs(10, 42).mirror().addBox(0.01F, -0.625F, -2.15F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -1.125F, 1.95F, 0.8727F, 0.0F, 0.0F));

		PartDefinition RightFoot = RightLowerLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create(), PartPose.offset(0.0F, 0.3F, 4.675F));

		PartDefinition RightArch_r1 = RightFoot.addOrReplaceChild("RightArch_r1", CubeListBuilder.create().texOffs(42, 39).mirror().addBox(0.0F, -5.45F, -0.725F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.005F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 5.575F, -3.225F, -0.3491F, 0.0F, 0.0F));

		PartDefinition RightPad = RightFoot.addOrReplaceChild("RightPad", CubeListBuilder.create().texOffs(42, 45).mirror().addBox(-1.0F, 1.0F, -0.85F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(18, 37).addBox(-1.2F, 1.4F, -0.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.31F))
		.texOffs(18, 37).addBox(-0.75F, 1.4F, -1.05F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.31F))
		.texOffs(18, 37).addBox(-0.25F, 1.4F, -1.05F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.31F))
		.texOffs(18, 37).addBox(0.2F, 1.4F, -0.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.31F))
		.texOffs(18, 37).addBox(-0.5F, 1.1F, -0.05F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.825F, -2.675F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offset(2.0F, 18.0F, 7.0F));

		PartDefinition LeftThigh_r1 = LeftLeg.addOrReplaceChild("LeftThigh_r1", CubeListBuilder.create().texOffs(40, 22).addBox(-2.0F, 2.075F, -2.1F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -4.5F, 0.5F, -0.2182F, 0.0F, 0.0F));

		PartDefinition LeftLowerLeg = LeftLeg.addOrReplaceChild("LeftLowerLeg", CubeListBuilder.create(), PartPose.offset(0.5F, 0.875F, -2.95F));

		PartDefinition LeftCalf_r1 = LeftLowerLeg.addOrReplaceChild("LeftCalf_r1", CubeListBuilder.create().texOffs(10, 42).addBox(-2.01F, -0.625F, -2.15F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.125F, 1.95F, 0.8727F, 0.0F, 0.0F));

		PartDefinition LeftFoot = LeftLowerLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create(), PartPose.offset(0.0F, 0.3F, 4.675F));

		PartDefinition LeftArch_r1 = LeftFoot.addOrReplaceChild("LeftArch_r1", CubeListBuilder.create().texOffs(42, 39).addBox(-2.0F, -5.45F, -0.725F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.005F)), PartPose.offsetAndRotation(1.0F, 5.575F, -3.225F, -0.3491F, 0.0F, 0.0F));

		PartDefinition LeftPad = LeftFoot.addOrReplaceChild("LeftPad", CubeListBuilder.create().texOffs(42, 45).addBox(-1.0F, 1.0F, -0.85F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(18, 37).mirror().addBox(0.2F, 1.4F, -0.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.31F)).mirror(false)
		.texOffs(18, 37).mirror().addBox(-0.25F, 1.4F, -1.05F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.31F)).mirror(false)
		.texOffs(18, 37).mirror().addBox(-0.75F, 1.4F, -1.05F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.31F)).mirror(false)
		.texOffs(18, 37).mirror().addBox(-1.2F, 1.4F, -0.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.31F)).mirror(false)
		.texOffs(18, 37).mirror().addBox(-0.5F, 1.1F, -0.05F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 2.825F, -2.675F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 47).addBox(-1.5F, 3.0F, -6.7F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 29).addBox(-2.0F, 1.2F, -7.7F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.5F, -4.0F));

		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(42, 17).mirror().addBox(-1.0F, -0.5F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5F, 2.9F, -3.9F, 0.0F, -0.3491F, 0.0F));

		PartDefinition cube_r2 = Head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(42, 17).addBox(-1.0F, -0.5F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 2.9F, -3.9F, 0.0F, 0.3491F, 0.0F));

		PartDefinition Snout_r1 = Head.addOrReplaceChild("Snout_r1", CubeListBuilder.create().texOffs(8, 48).addBox(-2.0F, -27.0F, -5.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 25.2F, -22.2F, -0.7854F, 0.0F, 0.0F));

		PartDefinition RightEar = Head.addOrReplaceChild("RightEar", CubeListBuilder.create(), PartPose.offset(-3.0F, -3.5F, -2.0F));

		PartDefinition RightEarPivot = RightEar.addOrReplaceChild("RightEarPivot", CubeListBuilder.create(), PartPose.offset(2.2F, -0.35F, -0.5F));

		PartDefinition cube_r3 = RightEarPivot.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(44, 0).addBox(0.0F, -5.0F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.85F, 1.4F, -0.55F, -0.9163F, -0.3491F, 0.0F));

		PartDefinition cube_r4 = RightEarPivot.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(32, 39).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.85F, 1.05F, -0.55F, -0.9163F, -0.3491F, 0.0F));

		PartDefinition LeftEar = Head.addOrReplaceChild("LeftEar", CubeListBuilder.create(), PartPose.offset(3.0F, -3.5F, -2.0F));

		PartDefinition LeftEarPivot = LeftEar.addOrReplaceChild("LeftEarPivot", CubeListBuilder.create(), PartPose.offset(-2.2F, -0.35F, -0.5F));

		PartDefinition cube_r5 = LeftEarPivot.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-1.0F, -5.0F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.85F, 1.4F, -0.55F, -0.9163F, 0.3491F, 0.0F));

		PartDefinition cube_r6 = LeftEarPivot.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(32, 39).mirror().addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.85F, 1.05F, -0.55F, -0.9163F, 0.3491F, 0.0F));

		PartDefinition Hair = Head.addOrReplaceChild("Hair", CubeListBuilder.create().texOffs(36, 50).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.2F))
		.texOffs(0, 52).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 4.0F, -2.0F));

		PartDefinition bone = Head.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.4F, -4.6F, -4.7F, 0.0F, -0.2618F, -0.0873F));

		PartDefinition cube_r7 = bone.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(34, 48).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1F, 1.0F, -0.3142F, 0.0F, 0.0F));

		PartDefinition cube_r8 = bone.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(34, 48).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.2F, 1.25F, -0.9687F, 0.0F, 0.0F));

		PartDefinition cube_r9 = bone.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(30, 48).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3142F, 0.0F, 0.0F));

		PartDefinition bone2 = Head.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.4F, -4.6F, -4.7F, 0.0F, 0.2618F, 0.0873F));

		PartDefinition cube_r10 = bone2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(30, 48).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3142F, 0.0F, 0.0F));

		PartDefinition cube_r11 = bone2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(34, 48).mirror().addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.2F, 1.25F, -0.9687F, 0.0F, 0.0F));

		PartDefinition cube_r12 = bone2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(34, 48).mirror().addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.1F, 1.0F, -0.3142F, 0.0F, 0.0F));

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create(), PartPose.offset(0.0F, 14.5F, 0.0F));

		PartDefinition cube_r13 = Torso.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(40, 33).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.7F, 4.6F, 0.384F, 0.0F, 0.0F));

		PartDefinition cube_r14 = Torso.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(40, 33).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, -2.4F, 0.384F, 0.0F, 0.0F));

		PartDefinition Torso_r1 = Torso.addOrReplaceChild("Torso_r1", CubeListBuilder.create().texOffs(0, 25).addBox(-3.0F, 3.0F, -2.0F, 6.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 14).addBox(-3.5F, -2.0F, -2.5F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 1.0F, -2.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition LeftWing = Torso.addOrReplaceChild("LeftWing", CubeListBuilder.create(), PartPose.offsetAndRotation(1.5F, -2.0F, 3.2F, 1.5708F, -0.0873F, -0.6981F));

		PartDefinition leftWingRoot = LeftWing.addOrReplaceChild("leftWingRoot", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r15 = leftWingRoot.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(18, 39).addBox(18.975F, -4.475F, 1.65F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 20.0F, -2.0F, 0.0F, 0.0F, -1.2654F));

		PartDefinition cube_r16 = leftWingRoot.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(26, 22).addBox(19.075F, -12.7F, 1.2F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 20.0F, -2.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r17 = leftWingRoot.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(42, 14).addBox(7.775F, -19.75F, 1.2F, 5.0F, 2.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-2.0F, 20.0F, -2.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition leftSecondaries = leftWingRoot.addOrReplaceChild("leftSecondaries", CubeListBuilder.create().texOffs(22, 44).addBox(-0.8F, -0.475F, -0.3F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(7.3F, -7.0F, -0.5F, 0.0F, 0.0F, -0.5236F));

		PartDefinition cube_r18 = leftSecondaries.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(26, 44).addBox(-2.025F, -22.55F, 1.2F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.3F, 27.0F, -1.5F, 0.0F, 0.0F, 0.48F));

		PartDefinition cube_r19 = leftSecondaries.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(28, 8).addBox(15.525F, -13.85F, 1.648F, 9.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.3F, 27.0F, -1.5F, 0.0F, 0.0F, -0.7418F));

		PartDefinition cube_r20 = leftSecondaries.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 37).addBox(13.4F, 10.625F, 1.651F, 9.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.3F, 27.0F, -1.5F, 0.0F, 0.0F, -1.8326F));

		PartDefinition leftTertiaries = leftSecondaries.addOrReplaceChild("leftTertiaries", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3F, 0.0F, 0.0F, 0.0F, 0.0F, -0.9599F));

		PartDefinition cube_r21 = leftTertiaries.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(18, 44).addBox(-3.3F, -22.5F, 1.2F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 27.0F, -1.5F, 0.0F, 0.0F, 0.5236F));

		PartDefinition cube_r22 = leftTertiaries.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(22, 34).addBox(16.125F, -10.525F, 1.64F, 9.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 27.0F, -1.5F, 0.0F, 0.0F, -0.8727F));

		PartDefinition cube_r23 = leftTertiaries.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(38, 48).addBox(9.15F, -26.2F, 1.2F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.5F, 21.0F, -1.5F, 0.0F, 0.0F, -1.0908F));

		PartDefinition cube_r24 = leftTertiaries.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(46, 7).addBox(9.15F, -26.2F, 1.2F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.005F)), PartPose.offsetAndRotation(-9.0F, 27.0F, -1.5F, 0.0F, 0.0F, -0.0436F));

		PartDefinition RightWing = Torso.addOrReplaceChild("RightWing", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, -2.0F, 3.2F, 1.5708F, 0.0873F, 0.6981F));

		PartDefinition rightWingRoot = RightWing.addOrReplaceChild("rightWingRoot", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r25 = rightWingRoot.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(18, 39).mirror().addBox(-25.975F, -4.475F, 1.65F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 20.0F, -2.0F, 0.0F, 0.0F, 1.2654F));

		PartDefinition cube_r26 = rightWingRoot.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(26, 22).mirror().addBox(-25.075F, -12.7F, 1.2F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 20.0F, -2.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r27 = rightWingRoot.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(42, 14).mirror().addBox(-12.775F, -19.75F, 1.2F, 5.0F, 2.0F, 1.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(2.0F, 20.0F, -2.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition rightSecondaries = rightWingRoot.addOrReplaceChild("rightSecondaries", CubeListBuilder.create().texOffs(22, 44).mirror().addBox(-0.2F, -0.475F, -0.3F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(-7.3F, -7.0F, -0.5F, 0.0F, 0.0F, 0.5236F));

		PartDefinition cube_r28 = rightSecondaries.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(26, 44).mirror().addBox(1.025F, -22.55F, 1.2F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.3F, 27.0F, -1.5F, 0.0F, 0.0F, -0.48F));

		PartDefinition cube_r29 = rightSecondaries.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(28, 8).mirror().addBox(-24.525F, -13.85F, 1.648F, 9.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.3F, 27.0F, -1.5F, 0.0F, 0.0F, 0.7418F));

		PartDefinition cube_r30 = rightSecondaries.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 37).mirror().addBox(-22.4F, 10.625F, 1.651F, 9.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.3F, 27.0F, -1.5F, 0.0F, 0.0F, 1.8326F));

		PartDefinition rightTertiaries = rightSecondaries.addOrReplaceChild("rightTertiaries", CubeListBuilder.create(), PartPose.offsetAndRotation(0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.9599F));

		PartDefinition cube_r31 = rightTertiaries.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(18, 44).mirror().addBox(2.3F, -22.5F, 1.2F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, 27.0F, -1.5F, 0.0F, 0.0F, -0.5236F));

		PartDefinition cube_r32 = rightTertiaries.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(22, 34).mirror().addBox(-25.125F, -10.525F, 1.64F, 9.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, 27.0F, -1.5F, 0.0F, 0.0F, 0.8727F));

		PartDefinition cube_r33 = rightTertiaries.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(38, 48).mirror().addBox(-10.15F, -26.2F, 1.2F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-18.5F, 21.0F, -1.5F, 0.0F, 0.0F, 1.0908F));

		PartDefinition cube_r34 = rightTertiaries.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(46, 7).mirror().addBox(-10.15F, -26.2F, 1.2F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.005F)).mirror(false), PartPose.offsetAndRotation(9.0F, 27.0F, -1.5F, 0.0F, 0.0F, 0.0436F));

		PartDefinition Tail = Torso.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(0.0F, 0.2F, 5.3F));

		PartDefinition TailPrimary = Tail.addOrReplaceChild("TailPrimary", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Base_r1 = TailPrimary.addOrReplaceChild("Base_r1", CubeListBuilder.create().texOffs(26, 14).addBox(-2.0F, -2.9F, 0.4F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4538F, 0.0F, 0.0F));

		PartDefinition TailSecondary = TailPrimary.addOrReplaceChild("TailSecondary", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 3.5F));

		PartDefinition Base_r2 = TailSecondary.addOrReplaceChild("Base_r2", CubeListBuilder.create().texOffs(22, 25).addBox(-1.5F, -1.4F, -2.7F, 3.0F, 3.0F, 6.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 0.4F, 2.2F, -0.3229F, 0.0F, 0.0F));

		PartDefinition TailTertiary = TailSecondary.addOrReplaceChild("TailTertiary", CubeListBuilder.create(), PartPose.offset(0.0F, 2.5F, 5.0F));

		PartDefinition Base_r3 = TailTertiary.addOrReplaceChild("Base_r3", CubeListBuilder.create().texOffs(28, 0).addBox(-1.5F, -13.225F, 6.6F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, 10.2F, -8.2F, -0.0611F, 0.0F, 0.0F));

		PartDefinition TailQuaternary = TailTertiary.addOrReplaceChild("TailQuaternary", CubeListBuilder.create(), PartPose.offset(0.0F, 0.5F, 4.5F));

		PartDefinition Base_r4 = TailQuaternary.addOrReplaceChild("Base_r4", CubeListBuilder.create().texOffs(0, 42).addBox(-1.0F, -10.45F, 13.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, 9.7F, -14.0F, 0.1134F, 0.0F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offset(-2.0F, 17.5F, -2.5F));

		PartDefinition RightArm2 = RightArm.addOrReplaceChild("RightArm2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.5F, 9.5F));

		PartDefinition RightThigh_r2 = RightArm2.addOrReplaceChild("RightThigh_r2", CubeListBuilder.create().texOffs(40, 22).mirror().addBox(0.0F, 2.075F, -2.1F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, -4.5F, 0.5F, -0.2182F, 0.0F, 0.0F));

		PartDefinition RightLowerArm2 = RightArm2.addOrReplaceChild("RightLowerArm2", CubeListBuilder.create(), PartPose.offset(-0.5F, 0.875F, -2.95F));

		PartDefinition RightCalf_r2 = RightLowerArm2.addOrReplaceChild("RightCalf_r2", CubeListBuilder.create().texOffs(10, 42).mirror().addBox(0.01F, -0.625F, -2.15F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -1.125F, 1.95F, 0.8727F, 0.0F, 0.0F));

		PartDefinition RightFoot2 = RightLowerArm2.addOrReplaceChild("RightFoot2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.3F, 4.675F));

		PartDefinition RightArch_r2 = RightFoot2.addOrReplaceChild("RightArch_r2", CubeListBuilder.create().texOffs(42, 39).mirror().addBox(0.0F, -5.45F, -0.725F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.005F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 5.575F, -3.225F, -0.3491F, 0.0F, 0.0F));

		PartDefinition RightPad2 = RightFoot2.addOrReplaceChild("RightPad2", CubeListBuilder.create().texOffs(42, 45).mirror().addBox(-1.0F, 1.0F, -0.85F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(18, 37).addBox(-1.2F, 1.4F, -0.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.31F))
		.texOffs(18, 37).addBox(-0.75F, 1.4F, -1.05F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.31F))
		.texOffs(18, 37).addBox(-0.25F, 1.4F, -1.05F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.31F))
		.texOffs(18, 37).addBox(0.2F, 1.4F, -0.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.31F))
		.texOffs(18, 37).addBox(-0.5F, 1.1F, -0.05F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.825F, -2.675F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(2.0F, 17.5F, -2.5F));

		PartDefinition LeftArm2 = LeftArm.addOrReplaceChild("LeftArm2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.5F, 0.5F));

		PartDefinition LeftThigh_r2 = LeftArm2.addOrReplaceChild("LeftThigh_r2", CubeListBuilder.create().texOffs(40, 22).addBox(-2.0F, 2.075F, -2.1F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -4.5F, 0.5F, -0.2182F, 0.0F, 0.0F));

		PartDefinition LeftLowerArm2 = LeftArm2.addOrReplaceChild("LeftLowerArm2", CubeListBuilder.create(), PartPose.offset(0.5F, 0.875F, -2.95F));

		PartDefinition LeftCalf_r2 = LeftLowerArm2.addOrReplaceChild("LeftCalf_r2", CubeListBuilder.create().texOffs(10, 42).addBox(-2.01F, -0.625F, -2.15F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.125F, 1.95F, 0.8727F, 0.0F, 0.0F));

		PartDefinition LeftFoot2 = LeftLowerArm2.addOrReplaceChild("LeftFoot2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.3F, 4.675F));

		PartDefinition LeftArch_r2 = LeftFoot2.addOrReplaceChild("LeftArch_r2", CubeListBuilder.create().texOffs(42, 39).addBox(-2.0F, -5.45F, -0.725F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.005F)), PartPose.offsetAndRotation(1.0F, 5.575F, -3.225F, -0.3491F, 0.0F, 0.0F));

		PartDefinition LeftPad2 = LeftFoot2.addOrReplaceChild("LeftPad2", CubeListBuilder.create().texOffs(42, 45).addBox(-1.0F, 1.0F, -0.85F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(18, 37).mirror().addBox(0.2F, 1.4F, -0.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.31F)).mirror(false)
		.texOffs(18, 37).mirror().addBox(-0.25F, 1.4F, -1.05F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.31F)).mirror(false)
		.texOffs(18, 37).mirror().addBox(-0.75F, 1.4F, -1.05F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.31F)).mirror(false)
		.texOffs(18, 37).mirror().addBox(-1.2F, 1.4F, -0.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.31F)).mirror(false)
		.texOffs(18, 37).mirror().addBox(-0.5F, 1.1F, -0.05F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 2.825F, -2.675F));

		return LayerDefinition.create(meshdefinition, 64, 64);
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