package net.hhdsj.changed_creatures.client.models.other;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.hhdsj.changed_creatures.ChangedCreature;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class CrystalModel extends Model {
    public static final ResourceLocation TEXTURE = new ResourceLocation(ChangedCreature.MODID, "textures/entity/crystal/crystal.png");
    private final ModelPart crystal;

    public CrystalModel(ModelPart root) {
        super(RenderType::entityTranslucentEmissive);
        this.crystal = root.getChild("crystal");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition crystal = root.addOrReplaceChild("crystal",
                CubeListBuilder.create().texOffs(0, 0).addBox(-2, -6, -2, 4, 12, 4), PartPose.ZERO);
        crystal.addOrReplaceChild("ring", CubeListBuilder.create().texOffs(16, 0).addBox(-3, -1.5f, -3, 6, 3, 6), PartPose.ZERO);
        crystal.addOrReplaceChild("top", CubeListBuilder.create().texOffs(0, 16).addBox(-1, -8, -1, 2, 2, 2), PartPose.ZERO);
        return LayerDefinition.create(mesh, 64, 32);
    }

    @Override
    public void renderToBuffer(PoseStack pose, VertexConsumer buffer, int light, int overlay, float r, float g, float b, float a) {
        crystal.render(pose, buffer, light, overlay, r, g, b, a);
    }
}