package net.hhdsj.changed_creatures.client.animation;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.util.Mth;

public class WingSwimmingAnimator extends WingAnimator {

    public WingSwimmingAnimator(ModelPart leftWingRoot, ModelPart leftWingBone1, ModelPart leftWingBone2,
                                ModelPart rightWingRoot, ModelPart rightWingBone1, ModelPart rightWingBone2) {
        super(leftWingRoot, leftWingBone1, leftWingBone2, rightWingRoot, rightWingBone1, rightWingBone2);
    }

    @Override
    public WingAnimationState getState() {
        return WingAnimationState.SWIMMING;
    }

    @Override
    public void setupAnim(AbstractClientPlayer player, float limbSwing, float limbSwingAmount,
                          float ageInTicks, float netHeadYaw, float headPitch, float partialTick) {

        // 游泳时翅膀做划水动作
        float swimFlapRate = 0.3F;
        float flapAmount = Mth.sin(ageInTicks * swimFlapRate);

        // 翅膀部分展开，做划水动作
        this.leftWingRoot.xRot = Mth.lerp(this.swimAmount, this.leftWingRoot.xRot, flapAmount * 0.3F);
        this.leftWingRoot.yRot = Mth.lerp(this.swimAmount, this.leftWingRoot.yRot, 0.15F);
        this.leftWingRoot.zRot = Mth.lerp(this.swimAmount, this.leftWingRoot.zRot, -0.1F);

        this.rightWingRoot.xRot = Mth.lerp(this.swimAmount, this.rightWingRoot.xRot, -flapAmount * 0.3F);
        this.rightWingRoot.yRot = Mth.lerp(this.swimAmount, this.rightWingRoot.yRot, -0.15F);
        this.rightWingRoot.zRot = Mth.lerp(this.swimAmount, this.rightWingRoot.zRot, 0.1F);

        // 翅膀骨骼部分展开
        this.leftWingBone1.zRot = Mth.lerp(this.swimAmount, this.leftWingBone1.zRot, -0.3F);
        this.leftWingBone2.zRot = Mth.lerp(this.swimAmount, this.leftWingBone2.zRot, -0.5F);

        this.rightWingBone1.zRot = Mth.lerp(this.swimAmount, this.rightWingBone1.zRot, 0.3F);
        this.rightWingBone2.zRot = Mth.lerp(this.swimAmount, this.rightWingBone2.zRot, 0.5F);
    }
}