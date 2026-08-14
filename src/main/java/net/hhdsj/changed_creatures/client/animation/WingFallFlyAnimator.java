package net.hhdsj.changed_creatures.client.animation;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.util.Mth;

public class WingFallFlyAnimator extends WingAnimator {

    public WingFallFlyAnimator(ModelPart leftWingRoot, ModelPart leftWingBone1, ModelPart leftWingBone2,
                               ModelPart rightWingRoot, ModelPart rightWingBone1, ModelPart rightWingBone2) {
        super(leftWingRoot, leftWingBone1, leftWingBone2, rightWingRoot, rightWingBone1, rightWingBone2);
    }

    @Override
    public WingAnimationState getState() {
        return WingAnimationState.FALL_FLY;
    }

    @Override
    public void setupAnim(AbstractClientPlayer player, float limbSwing, float limbSwingAmount,
                          float ageInTicks, float netHeadYaw, float headPitch, float partialTick) {

        // 鞘翅飞行时翅膀完全展开
        this.leftWingRoot.xRot = Mth.lerp(this.fallFlyingAmount, this.leftWingRoot.xRot, 0.0F);
        this.leftWingRoot.yRot = Mth.lerp(this.fallFlyingAmount, this.leftWingRoot.yRot, 0.087266F);
        this.leftWingRoot.zRot = Mth.lerp(this.fallFlyingAmount, this.leftWingRoot.zRot, 0.0F);

        this.rightWingRoot.xRot = Mth.lerp(this.fallFlyingAmount, this.rightWingRoot.xRot, 0.0F);
        this.rightWingRoot.yRot = Mth.lerp(this.fallFlyingAmount, this.rightWingRoot.yRot, -0.087266F);
        this.rightWingRoot.zRot = Mth.lerp(this.fallFlyingAmount, this.rightWingRoot.zRot, 0.0F);

        // 翅膀骨骼完全展开
        this.leftWingBone1.zRot = Mth.lerp(this.fallFlyingAmount, this.leftWingBone1.zRot, -0.523598F);
        this.leftWingBone2.zRot = Mth.lerp(this.fallFlyingAmount, this.leftWingBone2.zRot, -0.959931F);

        this.rightWingBone1.zRot = Mth.lerp(this.fallFlyingAmount, this.rightWingBone1.zRot, 0.523598F);
        this.rightWingBone2.zRot = Mth.lerp(this.fallFlyingAmount, this.rightWingBone2.zRot, 0.959931F);
    }
}