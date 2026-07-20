// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class Protogen_Nyxarix<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "protogen_nyxarix"), "main");
	private final ModelPart RightLeg;
	private final ModelPart RightLowerLeg;
	private final ModelPart RightFoot;
	private final ModelPart RightPad;
	private final ModelPart LeftLeg;
	private final ModelPart LeftLowerLeg;
	private final ModelPart LeftFoot;
	private final ModelPart LeftPad;
	private final ModelPart Head;
	private final ModelPart Hair;
	private final ModelPart LeftEar;
	private final ModelPart RightEar;
	private final ModelPart RightHorn3;
	private final ModelPart LeftHorn3;
	private final ModelPart Torso;
	private final ModelPart RightUpperTentacle;
	private final ModelPart TentacleSecondaryRU;
	private final ModelPart TentacleTertiaryRU;
	private final ModelPart TentacleQuaternaryRU;
	private final ModelPart TentaclePadRU;
	private final ModelPart RightLowerTentacle;
	private final ModelPart TentacleSecondaryRL;
	private final ModelPart TentacleTertiaryRL;
	private final ModelPart TentacleQuaternaryRL;
	private final ModelPart TentaclePadRL;
	private final ModelPart LeftUpperTentacle;
	private final ModelPart TentacleSecondaryLU;
	private final ModelPart TentacleTertiaryLU;
	private final ModelPart TentacleQuaternaryLU;
	private final ModelPart TentaclePadLU;
	private final ModelPart LeftLowerTentacle;
	private final ModelPart TentacleSecondaryLL;
	private final ModelPart TentacleTertiaryLL;
	private final ModelPart TentacleQuaternaryLL;
	private final ModelPart TentaclePadLL;
	private final ModelPart Tail;
	private final ModelPart TailPrimary;
	private final ModelPart TailSecondary;
	private final ModelPart TailTertiary;
	private final ModelPart TailQuaternary;
	private final ModelPart Tail2;
	private final ModelPart TailPrimary2;
	private final ModelPart TailSecondary2;
	private final ModelPart TailTertiary2;
	private final ModelPart TailQuaternary2;
	private final ModelPart Tail3;
	private final ModelPart TailPrimary3;
	private final ModelPart TailSecondary3;
	private final ModelPart TailTertiary3;
	private final ModelPart TailQuaternary3;
	private final ModelPart RightArm;
	private final ModelPart RightArm2;
	private final ModelPart LeftArm;
	private final ModelPart LeftArm2;

	public Protogen_Nyxarix(ModelPart root) {
		this.RightLeg = root.getChild("RightLeg");
		this.RightLowerLeg = this.RightLeg.getChild("RightLowerLeg");
		this.RightFoot = this.RightLowerLeg.getChild("RightFoot");
		this.RightPad = this.RightFoot.getChild("RightPad");
		this.LeftLeg = root.getChild("LeftLeg");
		this.LeftLowerLeg = this.LeftLeg.getChild("LeftLowerLeg");
		this.LeftFoot = this.LeftLowerLeg.getChild("LeftFoot");
		this.LeftPad = this.LeftFoot.getChild("LeftPad");
		this.Head = root.getChild("Head");
		this.Hair = this.Head.getChild("Hair");
		this.LeftEar = this.Head.getChild("LeftEar");
		this.RightEar = this.Head.getChild("RightEar");
		this.RightHorn3 = this.Head.getChild("RightHorn3");
		this.LeftHorn3 = this.Head.getChild("LeftHorn3");
		this.Torso = root.getChild("Torso");
		this.RightUpperTentacle = this.Torso.getChild("RightUpperTentacle");
		this.TentacleSecondaryRU = this.RightUpperTentacle.getChild("TentacleSecondaryRU");
		this.TentacleTertiaryRU = this.TentacleSecondaryRU.getChild("TentacleTertiaryRU");
		this.TentacleQuaternaryRU = this.TentacleTertiaryRU.getChild("TentacleQuaternaryRU");
		this.TentaclePadRU = this.TentacleQuaternaryRU.getChild("TentaclePadRU");
		this.RightLowerTentacle = this.Torso.getChild("RightLowerTentacle");
		this.TentacleSecondaryRL = this.RightLowerTentacle.getChild("TentacleSecondaryRL");
		this.TentacleTertiaryRL = this.TentacleSecondaryRL.getChild("TentacleTertiaryRL");
		this.TentacleQuaternaryRL = this.TentacleTertiaryRL.getChild("TentacleQuaternaryRL");
		this.TentaclePadRL = this.TentacleQuaternaryRL.getChild("TentaclePadRL");
		this.LeftUpperTentacle = this.Torso.getChild("LeftUpperTentacle");
		this.TentacleSecondaryLU = this.LeftUpperTentacle.getChild("TentacleSecondaryLU");
		this.TentacleTertiaryLU = this.TentacleSecondaryLU.getChild("TentacleTertiaryLU");
		this.TentacleQuaternaryLU = this.TentacleTertiaryLU.getChild("TentacleQuaternaryLU");
		this.TentaclePadLU = this.TentacleQuaternaryLU.getChild("TentaclePadLU");
		this.LeftLowerTentacle = this.Torso.getChild("LeftLowerTentacle");
		this.TentacleSecondaryLL = this.LeftLowerTentacle.getChild("TentacleSecondaryLL");
		this.TentacleTertiaryLL = this.TentacleSecondaryLL.getChild("TentacleTertiaryLL");
		this.TentacleQuaternaryLL = this.TentacleTertiaryLL.getChild("TentacleQuaternaryLL");
		this.TentaclePadLL = this.TentacleQuaternaryLL.getChild("TentaclePadLL");
		this.Tail = this.Torso.getChild("Tail");
		this.TailPrimary = this.Tail.getChild("TailPrimary");
		this.TailSecondary = this.TailPrimary.getChild("TailSecondary");
		this.TailTertiary = this.TailSecondary.getChild("TailTertiary");
		this.TailQuaternary = this.TailTertiary.getChild("TailQuaternary");
		this.Tail2 = this.Torso.getChild("Tail2");
		this.TailPrimary2 = this.Tail2.getChild("TailPrimary2");
		this.TailSecondary2 = this.TailPrimary2.getChild("TailSecondary2");
		this.TailTertiary2 = this.TailSecondary2.getChild("TailTertiary2");
		this.TailQuaternary2 = this.TailTertiary2.getChild("TailQuaternary2");
		this.Tail3 = this.Torso.getChild("Tail3");
		this.TailPrimary3 = this.Tail3.getChild("TailPrimary3");
		this.TailSecondary3 = this.TailPrimary3.getChild("TailSecondary3");
		this.TailTertiary3 = this.TailSecondary3.getChild("TailTertiary3");
		this.TailQuaternary3 = this.TailTertiary3.getChild("TailQuaternary3");
		this.RightArm = root.getChild("RightArm");
		this.RightArm2 = root.getChild("RightArm2");
		this.LeftArm = root.getChild("LeftArm");
		this.LeftArm2 = root.getChild("LeftArm2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offset(-2.7F, 9.3F, 0.0F));

		PartDefinition RightThigh_r1 = RightLeg.addOrReplaceChild("RightThigh_r1", CubeListBuilder.create().texOffs(48, 0).addBox(-2.0F, -0.9F, -2.55F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, 1.2F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition RightLowerLeg = RightLeg.addOrReplaceChild("RightLowerLeg", CubeListBuilder.create(), PartPose.offset(0.0F, 6.75F, -4.1F));

		PartDefinition RightCalf_r1 = RightLowerLeg.addOrReplaceChild("RightCalf_r1", CubeListBuilder.create().texOffs(32, 60).addBox(-1.99F, -0.9F, -2.4F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, -1.3F, 2.6F, 0.8727F, 0.0F, 0.0F));

		PartDefinition RightFoot = RightLowerLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create(), PartPose.offset(0.0F, 0.9F, 8.2F));

		PartDefinition RightArch_r1 = RightFoot.addOrReplaceChild("RightArch_r1", CubeListBuilder.create().texOffs(70, 22).addBox(-2.0F, -8.95F, -0.825F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.255F)), PartPose.offsetAndRotation(0.0F, 7.8F, -5.35F, -0.3491F, 0.0F, 0.0F));

		PartDefinition RightPad = RightFoot.addOrReplaceChild("RightPad", CubeListBuilder.create().texOffs(64, 7).addBox(-2.0F, 0.25F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 4.55F, -4.8F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offset(2.7F, 9.3F, 0.0F));

		PartDefinition LeftThigh_r1 = LeftLeg.addOrReplaceChild("LeftThigh_r1", CubeListBuilder.create().texOffs(32, 16).addBox(-2.0F, -0.9F, -2.55F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, 1.2F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition LeftLowerLeg = LeftLeg.addOrReplaceChild("LeftLowerLeg", CubeListBuilder.create(), PartPose.offset(0.0F, 6.75F, -4.1F));

		PartDefinition LeftCalf_r1 = LeftLowerLeg.addOrReplaceChild("LeftCalf_r1", CubeListBuilder.create().texOffs(54, 33).addBox(-2.01F, -0.9F, -2.4F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, -1.3F, 2.6F, 0.8727F, 0.0F, 0.0F));

		PartDefinition LeftFoot = LeftLowerLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create(), PartPose.offset(0.0F, 0.9F, 8.2F));

		PartDefinition LeftArch_r1 = LeftFoot.addOrReplaceChild("LeftArch_r1", CubeListBuilder.create().texOffs(16, 70).addBox(-2.0F, -8.95F, -0.825F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.255F)), PartPose.offsetAndRotation(0.0F, 7.8F, -5.35F, -0.3491F, 0.0F, 0.0F));

		PartDefinition LeftPad = LeftFoot.addOrReplaceChild("LeftPad", CubeListBuilder.create().texOffs(64, 0).addBox(-2.0F, 0.25F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 4.55F, -4.8F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 28).addBox(-4.0F, -4.095F, -8.55F, 8.0F, 4.0F, 7.0F, new CubeDeformation(-0.005F)), PartPose.offset(0.0F, -2.2F, 0.0F));

		PartDefinition Head_r1 = Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(2, 18).addBox(-4.0F, 0.01F, 0.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.005F)), PartPose.offsetAndRotation(0.0F, -4.1F, -8.55F, 0.7077F, 0.0F, 0.0F));

		PartDefinition Hair = Head.addOrReplaceChild("Hair", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, -2.0F));

		PartDefinition LeftEar = Head.addOrReplaceChild("LeftEar", CubeListBuilder.create(), PartPose.offsetAndRotation(2.5F, -5.0F, -2.4F, -0.5672F, 0.0F, 0.0F));

		PartDefinition left ear_r1 = LeftEar.addOrReplaceChild("left ear_r1", CubeListBuilder.create().texOffs(24, 79).addBox(-6.5334F, -32.1027F, -17.8111F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 30.0F, 2.0F, -0.5236F, 0.1745F, 0.2618F));

		PartDefinition RightEar = Head.addOrReplaceChild("RightEar", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.5F, -5.0F, -2.4F, -0.5672F, 0.0F, 0.0F));

		PartDefinition right ear_r1 = RightEar.addOrReplaceChild("right ear_r1", CubeListBuilder.create().texOffs(54, 73).addBox(4.5334F, -32.1027F, -17.8111F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 30.0F, 2.0F, -0.5236F, -0.1745F, -0.2618F));

		PartDefinition RightHorn3 = Head.addOrReplaceChild("RightHorn3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.5F, 18.7F, -3.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition Horn_r1 = RightHorn3.addOrReplaceChild("Horn_r1", CubeListBuilder.create().texOffs(76, 82).addBox(-3.0F, -31.3F, 18.8F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.48F, -0.1745F, 0.0F));

		PartDefinition Horn_r2 = RightHorn3.addOrReplaceChild("Horn_r2", CubeListBuilder.create().texOffs(82, 31).addBox(-3.0F, -31.3F, 18.8F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-0.3F, 7.0F, 1.8F, 0.48F, -0.1745F, 0.0F));

		PartDefinition Horn_r3 = RightHorn3.addOrReplaceChild("Horn_r3", CubeListBuilder.create().texOffs(16, 39).addBox(-3.0F, -35.2F, 8.1F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.2182F, -0.1745F, 0.0F));

		PartDefinition Horn_r4 = RightHorn3.addOrReplaceChild("Horn_r4", CubeListBuilder.create().texOffs(34, 85).addBox(-3.0F, -30.75F, -19.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, -0.5672F, -0.1745F, 0.0F));

		PartDefinition LeftHorn3 = Head.addOrReplaceChild("LeftHorn3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.5F, 18.7F, -3.0F, 0.0F, 0.0F, 0.0436F));

		PartDefinition Horn_r5 = LeftHorn3.addOrReplaceChild("Horn_r5", CubeListBuilder.create().texOffs(12, 85).addBox(1.0F, -31.3F, 18.8F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.3F, 7.0F, 1.8F, 0.48F, 0.1745F, 0.0F));

		PartDefinition Horn_r6 = LeftHorn3.addOrReplaceChild("Horn_r6", CubeListBuilder.create().texOffs(84, 25).addBox(1.0F, -31.3F, 18.8F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.48F, 0.1745F, 0.0F));

		PartDefinition Horn_r7 = LeftHorn3.addOrReplaceChild("Horn_r7", CubeListBuilder.create().texOffs(84, 20).addBox(1.0F, -35.2F, 8.1F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.2182F, 0.1745F, 0.0F));

		PartDefinition Horn_r8 = LeftHorn3.addOrReplaceChild("Horn_r8", CubeListBuilder.create().texOffs(58, 85).addBox(1.0F, -30.75F, -19.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, -0.5672F, 0.1745F, 0.0F));

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(30, 28).addBox(-4.0F, 0.1F, -2.2F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, -2.2F, 0.0F));

		PartDefinition RightUpperTentacle = Torso.addOrReplaceChild("RightUpperTentacle", CubeListBuilder.create(), PartPose.offset(-2.5F, 2.7F, 1.0F));

		PartDefinition TentaclePart_r1 = RightUpperTentacle.addOrReplaceChild("TentaclePart_r1", CubeListBuilder.create().texOffs(80, 58).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.192F, -0.4363F, -0.0524F));

		PartDefinition TentacleSecondaryRU = RightUpperTentacle.addOrReplaceChild("TentacleSecondaryRU", CubeListBuilder.create(), PartPose.offset(-1.5F, -0.5F, 3.3F));

		PartDefinition TentaclePart_r2 = TentacleSecondaryRU.addOrReplaceChild("TentaclePart_r2", CubeListBuilder.create().texOffs(76, 76).addBox(0.0F, -1.0F, 3.55F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.5F, -3.3F, 0.2269F, -0.6981F, -0.1134F));

		PartDefinition TentacleTertiaryRU = TentacleSecondaryRU.addOrReplaceChild("TentacleTertiaryRU", CubeListBuilder.create(), PartPose.offset(-2.4F, -0.7F, 2.7F));

		PartDefinition TentaclePart_r3 = TentacleTertiaryRU.addOrReplaceChild("TentaclePart_r3", CubeListBuilder.create().texOffs(80, 64).addBox(1.8F, -1.0F, 6.75F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.9F, 1.2F, -6.0F, 0.2967F, -0.9425F, -0.2094F));

		PartDefinition TentacleQuaternaryRU = TentacleTertiaryRU.addOrReplaceChild("TentacleQuaternaryRU", CubeListBuilder.create(), PartPose.offset(-3.0F, -0.5F, 2.2F));

		PartDefinition TentaclePart_r4 = TentacleQuaternaryRU.addOrReplaceChild("TentaclePart_r4", CubeListBuilder.create().texOffs(46, 81).addBox(4.45F, -1.0F, 9.375F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.9F, 1.7F, -8.2F, 0.4712F, -1.1868F, -0.4102F));

		PartDefinition TentaclePadRU = TentacleQuaternaryRU.addOrReplaceChild("TentaclePadRU", CubeListBuilder.create(), PartPose.offset(-3.6F, -0.4F, 1.3F));

		PartDefinition TentaclePart_r5 = TentaclePadRU.addOrReplaceChild("TentaclePart_r5", CubeListBuilder.create().texOffs(86, 82).addBox(6.075F, -1.5F, 16.4F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(30, 70).addBox(6.075F, -2.5F, 12.4F, 2.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.5F, 2.1F, -9.5F, 0.6807F, -1.2915F, -0.6283F));

		PartDefinition TentaclePart_r6 = TentaclePadRU.addOrReplaceChild("TentaclePart_r6", CubeListBuilder.create().texOffs(48, 22).addBox(6.075F, 0.5F, 16.4F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.6F, 1.0F, -9.3F, 0.6807F, -1.2915F, -0.6283F));

		PartDefinition RightLowerTentacle = Torso.addOrReplaceChild("RightLowerTentacle", CubeListBuilder.create(), PartPose.offset(-2.5F, 6.7F, 1.0F));

		PartDefinition TentaclePart_r7 = RightLowerTentacle.addOrReplaceChild("TentaclePart_r7", CubeListBuilder.create().texOffs(34, 79).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.192F, -0.4276F, 0.0524F));

		PartDefinition TentacleSecondaryRL = RightLowerTentacle.addOrReplaceChild("TentacleSecondaryRL", CubeListBuilder.create(), PartPose.offset(-1.5F, 0.5F, 3.3F));

		PartDefinition TentaclePart_r8 = TentacleSecondaryRL.addOrReplaceChild("TentaclePart_r8", CubeListBuilder.create().texOffs(42, 73).addBox(0.0F, -1.0F, 3.6F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -0.5F, -3.3F, -0.2182F, -0.6894F, 0.1134F));

		PartDefinition TentacleTertiaryRL = TentacleSecondaryRL.addOrReplaceChild("TentacleTertiaryRL", CubeListBuilder.create(), PartPose.offset(-2.4F, 0.7F, 2.9F));

		PartDefinition TentaclePart_r9 = TentacleTertiaryRL.addOrReplaceChild("TentaclePart_r9", CubeListBuilder.create().texOffs(64, 79).addBox(1.9F, -1.05F, 6.8F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.9F, -1.2F, -6.2F, -0.2967F, -0.9425F, 0.2094F));

		PartDefinition TentacleQuaternaryRL = TentacleTertiaryRL.addOrReplaceChild("TentacleQuaternaryRL", CubeListBuilder.create(), PartPose.offset(-2.9F, 0.4F, 2.0F));

		PartDefinition TentaclePart_r10 = TentacleQuaternaryRL.addOrReplaceChild("TentaclePart_r10", CubeListBuilder.create().texOffs(80, 14).addBox(4.525F, -1.0F, 9.3F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8F, -1.6F, -8.2F, -0.4712F, -1.1868F, 0.4102F));

		PartDefinition TentaclePadRL = TentacleQuaternaryRL.addOrReplaceChild("TentaclePadRL", CubeListBuilder.create(), PartPose.offset(-3.7F, 0.3F, 1.3F));

		PartDefinition TentaclePart_r11 = TentaclePadRL.addOrReplaceChild("TentaclePart_r11", CubeListBuilder.create().texOffs(42, 87).addBox(6.15F, -1.5F, 16.4F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(64, 70).addBox(6.15F, -2.5F, 12.4F, 2.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.5F, -1.9F, -9.5F, -0.6807F, -1.2915F, 0.6283F));

		PartDefinition TentaclePart_r12 = TentaclePadRL.addOrReplaceChild("TentaclePart_r12", CubeListBuilder.create().texOffs(48, 26).addBox(6.15F, 0.5F, 16.4F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.525F, -2.725F, -8.9F, -0.6807F, -1.2915F, 0.6283F));

		PartDefinition LeftUpperTentacle = Torso.addOrReplaceChild("LeftUpperTentacle", CubeListBuilder.create(), PartPose.offset(2.5F, 2.7F, 1.0F));

		PartDefinition TentaclePart_r13 = LeftUpperTentacle.addOrReplaceChild("TentaclePart_r13", CubeListBuilder.create().texOffs(0, 82).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.192F, 0.4363F, 0.0524F));

		PartDefinition TentacleSecondaryLU = LeftUpperTentacle.addOrReplaceChild("TentacleSecondaryLU", CubeListBuilder.create(), PartPose.offset(1.5F, -0.5F, 3.3F));

		PartDefinition TentaclePart_r14 = TentacleSecondaryLU.addOrReplaceChild("TentaclePart_r14", CubeListBuilder.create().texOffs(12, 79).addBox(-2.0F, -1.0F, 3.55F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.5F, -3.3F, 0.2269F, 0.6981F, 0.1134F));

		PartDefinition TentacleTertiaryLU = TentacleSecondaryLU.addOrReplaceChild("TentacleTertiaryLU", CubeListBuilder.create(), PartPose.offset(2.4F, -0.7F, 2.7F));

		PartDefinition TentaclePart_r15 = TentacleTertiaryLU.addOrReplaceChild("TentaclePart_r15", CubeListBuilder.create().texOffs(82, 0).addBox(-3.8F, -1.0F, 6.75F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9F, 1.2F, -6.0F, 0.2967F, 0.9425F, 0.2094F));

		PartDefinition TentacleQuaternaryLU = TentacleTertiaryLU.addOrReplaceChild("TentacleQuaternaryLU", CubeListBuilder.create(), PartPose.offset(3.0F, -0.5F, 2.2F));

		PartDefinition TentaclePart_r16 = TentacleQuaternaryLU.addOrReplaceChild("TentaclePart_r16", CubeListBuilder.create().texOffs(82, 6).addBox(-6.45F, -1.0F, 9.375F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.9F, 1.7F, -8.2F, 0.4712F, 1.1868F, 0.4102F));

		PartDefinition TentaclePadLU = TentacleQuaternaryLU.addOrReplaceChild("TentaclePadLU", CubeListBuilder.create(), PartPose.offset(3.6F, -0.4F, 1.3F));

		PartDefinition TentaclePart_r17 = TentaclePadLU.addOrReplaceChild("TentaclePart_r17", CubeListBuilder.create().texOffs(48, 24).addBox(-8.075F, 0.5F, 16.4F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.6F, 1.0F, -9.3F, 0.6807F, 1.2915F, 0.6283F));

		PartDefinition TentaclePart_r18 = TentaclePadLU.addOrReplaceChild("TentaclePart_r18", CubeListBuilder.create().texOffs(66, 85).addBox(-8.075F, -1.5F, 16.4F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(70, 31).addBox(-8.075F, -2.5F, 12.4F, 2.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.5F, 2.1F, -9.5F, 0.6807F, 1.2915F, 0.6283F));

		PartDefinition LeftLowerTentacle = Torso.addOrReplaceChild("LeftLowerTentacle", CubeListBuilder.create(), PartPose.offset(2.5F, 6.7F, 1.0F));

		PartDefinition TentaclePart_r19 = LeftLowerTentacle.addOrReplaceChild("TentaclePart_r19", CubeListBuilder.create().texOffs(80, 40).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.192F, 0.4276F, -0.0524F));

		PartDefinition TentacleSecondaryLL = LeftLowerTentacle.addOrReplaceChild("TentacleSecondaryLL", CubeListBuilder.create(), PartPose.offset(1.5F, 0.5F, 3.3F));

		PartDefinition TentaclePart_r20 = TentacleSecondaryLL.addOrReplaceChild("TentaclePart_r20", CubeListBuilder.create().texOffs(76, 70).addBox(-2.0F, -1.0F, 3.6F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -0.5F, -3.3F, -0.2182F, 0.6894F, -0.1134F));

		PartDefinition TentacleTertiaryLL = TentacleSecondaryLL.addOrReplaceChild("TentacleTertiaryLL", CubeListBuilder.create(), PartPose.offset(2.4F, 0.7F, 2.9F));

		PartDefinition TentaclePart_r21 = TentacleTertiaryLL.addOrReplaceChild("TentaclePart_r21", CubeListBuilder.create().texOffs(80, 46).addBox(-3.9F, -1.05F, 6.8F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9F, -1.2F, -6.2F, -0.2967F, 0.9425F, -0.2094F));

		PartDefinition TentacleQuaternaryLL = TentacleTertiaryLL.addOrReplaceChild("TentacleQuaternaryLL", CubeListBuilder.create(), PartPose.offset(2.9F, 0.4F, 2.0F));

		PartDefinition TentaclePart_r22 = TentacleQuaternaryLL.addOrReplaceChild("TentaclePart_r22", CubeListBuilder.create().texOffs(80, 52).addBox(-6.525F, -1.0F, 9.3F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8F, -1.6F, -8.2F, -0.4712F, 1.1868F, -0.4102F));

		PartDefinition TentaclePadLL = TentacleQuaternaryLL.addOrReplaceChild("TentaclePadLL", CubeListBuilder.create(), PartPose.offset(3.7F, 0.3F, 1.3F));

		PartDefinition TentaclePart_r23 = TentaclePadLL.addOrReplaceChild("TentaclePart_r23", CubeListBuilder.create().texOffs(70, 40).addBox(-8.15F, 0.5F, 16.4F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.525F, -2.725F, -8.9F, -0.6807F, 1.2915F, -0.6283F));

		PartDefinition TentaclePart_r24 = TentaclePadLL.addOrReplaceChild("TentaclePart_r24", CubeListBuilder.create().texOffs(22, 87).addBox(-8.15F, -1.5F, 16.4F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 73).addBox(-8.15F, -2.5F, 12.4F, 2.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.5F, -1.9F, -9.5F, -0.6807F, 1.2915F, -0.6283F));

		PartDefinition Tail = Torso.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(0.0F, 12.2F, 0.0F));

		PartDefinition TailPrimary = Tail.addOrReplaceChild("TailPrimary", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition Base_r1 = TailPrimary.addOrReplaceChild("Base_r1", CubeListBuilder.create().texOffs(64, 43).addBox(-2.0F, 0.75F, -1.4F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0908F, 0.0F, 0.0F));

		PartDefinition TailSecondary = TailPrimary.addOrReplaceChild("TailSecondary", CubeListBuilder.create(), PartPose.offset(0.0F, 1.25F, 4.5F));

		PartDefinition Base_r2 = TailSecondary.addOrReplaceChild("Base_r2", CubeListBuilder.create().texOffs(0, 55).addBox(-2.0F, -0.25F, -1.9F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, 0.5F, 0.0F, 1.3526F, 0.0F, 0.0F));

		PartDefinition TailTertiary = TailSecondary.addOrReplaceChild("TailTertiary", CubeListBuilder.create(), PartPose.offset(0.0F, 0.75F, 4.5F));

		PartDefinition Base_r3 = TailTertiary.addOrReplaceChild("Base_r3", CubeListBuilder.create().texOffs(48, 11).addBox(-2.0F, 5.05F, -2.8F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(0.0F, -0.25F, -4.5F, 1.5184F, 0.0F, 0.0F));

		PartDefinition TailQuaternary = TailTertiary.addOrReplaceChild("TailQuaternary", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 7.5F));

		PartDefinition Base_r4 = TailQuaternary.addOrReplaceChild("Base_r4", CubeListBuilder.create().texOffs(64, 14).addBox(-2.0F, 4.6F, -3.6F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.12F)), PartPose.offsetAndRotation(0.0F, -1.0F, -5.5F, 1.6581F, 0.0F, 0.0F));

		PartDefinition Tail2 = Torso.addOrReplaceChild("Tail2", CubeListBuilder.create(), PartPose.offset(0.0F, 12.2F, 0.0F));

		PartDefinition TailPrimary2 = Tail2.addOrReplaceChild("TailPrimary2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.5236F, 0.0F));

		PartDefinition Base_r5 = TailPrimary2.addOrReplaceChild("Base_r5", CubeListBuilder.create().texOffs(64, 52).addBox(-2.0F, 0.75F, -1.4F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0908F, 0.0F, 0.0F));

		PartDefinition TailSecondary2 = TailPrimary2.addOrReplaceChild("TailSecondary2", CubeListBuilder.create(), PartPose.offset(0.0F, 1.25F, 4.5F));

		PartDefinition Base_r6 = TailSecondary2.addOrReplaceChild("Base_r6", CubeListBuilder.create().texOffs(16, 60).addBox(-2.0F, -0.25F, -1.9F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, 0.5F, 0.0F, 1.3526F, 0.0F, 0.0F));

		PartDefinition TailTertiary2 = TailSecondary2.addOrReplaceChild("TailTertiary2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.75F, 4.5F));

		PartDefinition Base_r7 = TailTertiary2.addOrReplaceChild("Base_r7", CubeListBuilder.create().texOffs(48, 44).addBox(-2.0F, 5.05F, -2.8F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(0.0F, -0.25F, -4.5F, 1.5184F, 0.0F, 0.0F));

		PartDefinition TailQuaternary2 = TailTertiary2.addOrReplaceChild("TailQuaternary2", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 7.5F));

		PartDefinition Base_r8 = TailQuaternary2.addOrReplaceChild("Base_r8", CubeListBuilder.create().texOffs(0, 65).addBox(-2.0F, 4.6F, -3.6F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.12F)), PartPose.offsetAndRotation(0.0F, -1.0F, -5.5F, 1.6581F, 0.0F, 0.0F));

		PartDefinition Tail3 = Torso.addOrReplaceChild("Tail3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 12.2F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition TailPrimary3 = Tail3.addOrReplaceChild("TailPrimary3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, -0.5236F, 0.0F));

		PartDefinition Base_r9 = TailPrimary3.addOrReplaceChild("Base_r9", CubeListBuilder.create().texOffs(64, 61).addBox(-2.0F, 0.75F, -1.4F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0908F, 0.0F, 0.0F));

		PartDefinition TailSecondary3 = TailPrimary3.addOrReplaceChild("TailSecondary3", CubeListBuilder.create(), PartPose.offset(0.0F, 1.25F, 4.5F));

		PartDefinition Base_r10 = TailSecondary3.addOrReplaceChild("Base_r10", CubeListBuilder.create().texOffs(48, 55).addBox(-2.0F, -0.25F, -1.9F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, 0.5F, 0.0F, 1.3526F, 0.0F, 0.0F));

		PartDefinition TailTertiary3 = TailSecondary3.addOrReplaceChild("TailTertiary3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.75F, 4.5F));

		PartDefinition Base_r11 = TailTertiary3.addOrReplaceChild("Base_r11", CubeListBuilder.create().texOffs(54, 22).addBox(-2.0F, 5.05F, -2.8F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(0.0F, -0.25F, -4.5F, 1.5184F, 0.0F, 0.0F));

		PartDefinition TailQuaternary3 = TailTertiary3.addOrReplaceChild("TailQuaternary3", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 7.5F));

		PartDefinition Base_r12 = TailQuaternary3.addOrReplaceChild("Base_r12", CubeListBuilder.create().texOffs(48, 65).addBox(-2.0F, 4.6F, -3.6F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.12F)), PartPose.offsetAndRotation(0.0F, -1.0F, -5.5F, 1.6581F, 0.0F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(16, 44).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(-5.2F, 3.9F, -0.2F));

		PartDefinition RightArm2 = partdefinition.addOrReplaceChild("RightArm2", CubeListBuilder.create().texOffs(32, 44).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(-5.2F, -0.1F, -0.2F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(32, 0).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(5.2F, 3.9F, -0.2F));

		PartDefinition LeftArm2 = partdefinition.addOrReplaceChild("LeftArm2", CubeListBuilder.create().texOffs(0, 39).addBox(-0.8F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(5.0F, -0.1F, -0.2F));

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
		RightArm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}