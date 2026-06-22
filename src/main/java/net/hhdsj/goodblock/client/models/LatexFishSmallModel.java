package net.hhdsj.goodblock.client.models;

import net.hhdsj.goodblock.entity.DarkPurpleLatexDragonEntity;
import net.hhdsj.goodblock.entity.LatexFishEntity;
import net.ltxprogrammer.changed.client.renderer.animate.HumanoidAnimator;
import net.ltxprogrammer.changed.client.renderer.model.AdvancedHumanoidModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LatexFishSmallModel extends AdvancedHumanoidModel<LatexFishEntity> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "latex_fish"),"main");
    private final ModelPart root;
    private final ModelPart leftFin;
    private final ModelPart rightFin;

    public LatexFishSmallModel(ModelPart root) {
        super(root);
        this.root = root;
        this.leftFin = root.getChild("left_fin");
        this.rightFin = root.getChild("right_fin");
    }

    @Override
    public HumanoidAnimator<LatexFishEntity, ?> getAnimator(LatexFishEntity latexFishEntity) {
        return null;
    }

    @Override
    public ModelPart m_102851_(HumanoidArm humanoidArm) {
        return null;
    }

    @Override
    public ModelPart getLeg(HumanoidArm humanoidArm) {
        return null;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        int i = 23;
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 27).addBox(-1.5F, -2.0F, -1.5F, 3.0F, 2.0F, 3.0F), PartPose.offset(0.0F, 23.0F, 0.0F));
        partdefinition.addOrReplaceChild("right_eye", CubeListBuilder.create().texOffs(24, 6).addBox(-1.5F, 0.0F, -1.5F, 1.0F, 1.0F, 1.0F), PartPose.offset(0.0F, 20.0F, 0.0F));
        partdefinition.addOrReplaceChild("left_eye", CubeListBuilder.create().texOffs(28, 6).addBox(0.5F, 0.0F, -1.5F, 1.0F, 1.0F, 1.0F), PartPose.offset(0.0F, 20.0F, 0.0F));
        partdefinition.addOrReplaceChild("back_fin", CubeListBuilder.create().texOffs(-3, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 0.0F, 3.0F), PartPose.offset(0.0F, 22.0F, 1.5F));
        partdefinition.addOrReplaceChild("right_fin", CubeListBuilder.create().texOffs(25, 0).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 2.0F), PartPose.offset(-1.5F, 22.0F, -1.5F));
        partdefinition.addOrReplaceChild("left_fin", CubeListBuilder.create().texOffs(25, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 2.0F), PartPose.offset(1.5F, 22.0F, -1.5F));
        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    public ModelPart root() {
        return this.root;
    }

    public void setupAnim(LatexFishEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.rightFin.zRot = -0.2F + 0.4F * Mth.sin(ageInTicks * 0.2F);
        this.leftFin.zRot = 0.2F - 0.4F * Mth.sin(ageInTicks * 0.2F);
    }

    @Override
    public ModelPart getTorso() {
        return null;
    }
}