package net.hhdsj.goodblock.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.hhdsj.goodblock.client.renderer.animate.GoodBlockAnimatorPresets;
import net.hhdsj.goodblock.entity.simple.ProtogenNyxarixEntity;
import net.ltxprogrammer.changed.client.renderer.animate.HumanoidAnimator;
import net.ltxprogrammer.changed.client.renderer.model.AdvancedHumanoidModel;
import net.ltxprogrammer.changed.client.renderer.model.DoubleArmedModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@OnlyIn(Dist.CLIENT)
public class ModelProtogenNyxarix extends AdvancedHumanoidModel<ProtogenNyxarixEntity> implements DoubleArmedModel<ProtogenNyxarixEntity> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("goodblock", "protogen_nyxarix"), "main");

    public final ModelPart RightLeg;
    public final ModelPart LeftLeg;
    public final ModelPart Head;
    public final ModelPart Torso;
    public final ModelPart RightArm;
    public final ModelPart LeftArm;
    public final ModelPart RightArm2;
    public final ModelPart LeftArm2;
    public final ModelPart Tail1;
    public final ModelPart Tail2;
    public final ModelPart Tail3;
    public final HumanoidAnimator<ProtogenNyxarixEntity, ModelProtogenNyxarix> animator;


    public ModelProtogenNyxarix(ModelPart root) {
        super(root);
        this.RightLeg = root.getChild("RightLeg");
        this.LeftLeg = root.getChild("LeftLeg");
        this.Head = root.getChild("Head");
        this.Torso = root.getChild("Torso");
        this.RightArm = root.getChild("RightArm");
        this.LeftArm = root.getChild("LeftArm");
        this.RightArm2 = root.getChild("RightArm2");
        this.LeftArm2 = root.getChild("LeftArm2");
        this.Tail1 = this.Torso.getChild("Tail");
        this.Tail2 = this.Torso.getChild("Tail2");
        this.Tail3 = this.Torso.getChild("Tail3");


        var tailPrimary1 = Tail1.getChild("TailPrimary");
        var tailSecondary1 = tailPrimary1.getChild("TailSecondary");
        var tailTertiary1 = tailSecondary1.getChild("TailTertiary");
        var TailQuaternary1 = tailTertiary1.getChild("TailQuaternary");

        var tailPrimary2 = Tail2.getChild("TailPrimary2");
        var tailSecondary2 = tailPrimary2.getChild("TailSecondary2");
        var tailTertiary2 = tailSecondary2.getChild("TailTertiary2");
        var TailQuaternary2 = tailTertiary2.getChild("TailQuaternary2");

        var tailPrimary3 = Tail3.getChild("TailPrimary3");
        var tailSecondary3 = tailPrimary3.getChild("TailSecondary3");
        var tailTertiary3 = tailSecondary3.getChild("TailTertiary3");
        var TailQuaternary3 = tailTertiary3.getChild("TailQuaternary3");

        var leftLowerLeg = LeftLeg.getChild("LeftLowerLeg");
        var leftFoot = leftLowerLeg.getChild("LeftFoot");
        var rightLowerLeg = RightLeg.getChild("RightLowerLeg");
        var rightFoot = rightLowerLeg.getChild("RightFoot");

        var upperRightTentacle = new ArrayList<ModelPart>();
        upperRightTentacle.add(Torso.getChild("RightUpperTentacle"));
        upperRightTentacle.add(last(upperRightTentacle).getChild("TentacleSecondaryRU"));
        upperRightTentacle.add(last(upperRightTentacle).getChild("TentacleTertiaryRU"));
        upperRightTentacle.add(last(upperRightTentacle).getChild("TentacleQuaternaryRU"));
        upperRightTentacle.add(last(upperRightTentacle).getChild("TentaclePadRU"));
        var upperLeftTentacle = new ArrayList<ModelPart>();
        upperLeftTentacle.add(Torso.getChild("LeftUpperTentacle"));
        upperLeftTentacle.add(last(upperLeftTentacle).getChild("TentacleSecondaryLU"));
        upperLeftTentacle.add(last(upperLeftTentacle).getChild("TentacleTertiaryLU"));
        upperLeftTentacle.add(last(upperLeftTentacle).getChild("TentacleQuaternaryLU"));
        upperLeftTentacle.add(last(upperLeftTentacle).getChild("TentaclePadLU"));
        var lowerRightTentacle = new ArrayList<ModelPart>();
        lowerRightTentacle.add(Torso.getChild("RightLowerTentacle"));
        lowerRightTentacle.add(last(lowerRightTentacle).getChild("TentacleSecondaryRL"));
        lowerRightTentacle.add(last(lowerRightTentacle).getChild("TentacleTertiaryRL"));
        lowerRightTentacle.add(last(lowerRightTentacle).getChild("TentacleQuaternaryRL"));
        lowerRightTentacle.add(last(lowerRightTentacle).getChild("TentaclePadRL"));
        var lowerLeftTentacle = new ArrayList<ModelPart>();
        lowerLeftTentacle.add(Torso.getChild("LeftLowerTentacle"));
        lowerLeftTentacle.add(last(lowerLeftTentacle).getChild("TentacleSecondaryLL"));
        lowerLeftTentacle.add(last(lowerLeftTentacle).getChild("TentacleTertiaryLL"));
        lowerLeftTentacle.add(last(lowerLeftTentacle).getChild("TentacleQuaternaryLL"));
        lowerLeftTentacle.add(last(lowerLeftTentacle).getChild("TentaclePadLL"));

        animator = HumanoidAnimator.of(this).hipOffset(-1.5f).legLength(13.0f)
                .addPreset(GoodBlockAnimatorPresets.ProtogenNyxarixLike(
                        Head, Head.getChild("LeftEar"), Head.getChild("RightEar"),
                        Torso, LeftArm2, RightArm2, LeftArm, RightArm,
                        Tail1, List.of(tailPrimary1, tailSecondary1, tailTertiary1, TailQuaternary1),
                        Tail2, List.of(tailPrimary2, tailSecondary2, tailTertiary2, TailQuaternary2),
                        Tail3, List.of(tailPrimary3, tailSecondary3, tailTertiary3, TailQuaternary3),
                        upperLeftTentacle, upperRightTentacle, lowerLeftTentacle, lowerRightTentacle,
                        LeftLeg, leftLowerLeg, leftFoot, leftFoot.getChild("LeftPad"), RightLeg, rightLowerLeg, rightFoot, rightFoot.getChild("RightPad")));

    }

    @SuppressWarnings("unused")
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
                .texOffs(0, 28).addBox(-4.0F, -3.97F, -10.95F, 8.0F, 4.0F, 7.0F, new CubeDeformation(-0.005F)), PartPose.offset(0.0F, -2.2F, 0.0F));

        PartDefinition Head_r1 = Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, 0.01F, 0.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.005F)), PartPose.offsetAndRotation(0.0F, -3.975F, -10.95F, 0.5332F, 0.0F, 0.0F));

        PartDefinition Hair = Head.addOrReplaceChild("Hair", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, -2.0F));

        PartDefinition LeftEar = Head.addOrReplaceChild("LeftEar", CubeListBuilder.create(), PartPose.offsetAndRotation(2.5F, -5.0F, -2.4F, -0.5672F, 0.0F, 0.0F));

        PartDefinition left_ear_r1 = LeftEar.addOrReplaceChild("left_ear_r1", CubeListBuilder.create().texOffs(24, 79).addBox(-6.5334F, -32.1027F, -17.8111F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 30.0F, 2.0F, -0.5236F, 0.1745F, 0.2618F));

        PartDefinition RightEar = Head.addOrReplaceChild("RightEar", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.5F, -5.0F, -2.4F, -0.5672F, 0.0F, 0.0F));

        PartDefinition right_ear_r1 = RightEar.addOrReplaceChild("right_ear_r1", CubeListBuilder.create().texOffs(54, 73).addBox(4.5334F, -32.1027F, -17.8111F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 30.0F, 2.0F, -0.5236F, -0.1745F, -0.2618F));

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
    public HumanoidAnimator<ProtogenNyxarixEntity, ModelProtogenNyxarix> getAnimator(ProtogenNyxarixEntity entity) {
        return this.animator;
    }

    public void setupHand(ProtogenNyxarixEntity entity) {
        animator.setupHand();
    }

    @Override
    public @NotNull ModelPart m_102851_(@NotNull HumanoidArm humanoidArm) {
        return humanoidArm == HumanoidArm.LEFT ? this.LeftArm2 : this.RightArm2;
    }

    @Override
    public ModelPart getOtherArm(HumanoidArm humanoidArm) {
        return switch (humanoidArm) {
            case LEFT -> LeftArm;
            case RIGHT -> RightArm;
        };
    }

    @Override
    public void translateToUpperHand(ProtogenNyxarixEntity entity, HumanoidArm arm, PoseStack poseStack) {
        this.getArm(arm).translateAndRotate(poseStack);
        poseStack.translate(0.0, (this.animator.armLength - 12.0f) / 20.0, 0.0);
    }

    @Override
    public void translateToLowerHand(ProtogenNyxarixEntity entity, HumanoidArm arm, PoseStack poseStack) {
        this.getOtherArm(arm).translateAndRotate(poseStack);
        poseStack.translate(0.0, (this.animator.armLength - 12.0f) / 20.0, 0.0);
    }

    @Override
    public ModelPart getLeg(HumanoidArm humanoidArm) {
        return humanoidArm == HumanoidArm.LEFT ? this.LeftLeg : this.RightLeg;
    }

    public @NotNull ModelPart getHead() {
        return this.Head;
    }

    public ModelPart getTorso() {
        return Torso;
    }


    public void setupAnim(@NotNull ProtogenNyxarixEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        RightArm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        LeftArm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);

    }
}