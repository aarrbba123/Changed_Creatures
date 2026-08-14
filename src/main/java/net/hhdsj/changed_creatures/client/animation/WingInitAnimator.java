package net.hhdsj.changed_creatures.client.animation;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.util.Mth;

public class WingInitAnimator extends WingAnimator {

    public WingInitAnimator(ModelPart leftWingRoot, ModelPart leftWingBone1, ModelPart leftWingBone2,
                            ModelPart rightWingRoot, ModelPart rightWingBone1, ModelPart rightWingBone2) {
        super(leftWingRoot, leftWingBone1, leftWingBone2, rightWingRoot, rightWingBone1, rightWingBone2);
    }

    @Override
    public WingAnimationState getState() {
        return WingAnimationState.INIT;
    }

    @Override
    public void setupAnim(AbstractClientPlayer player, float limbSwing, float limbSwingAmount,
                          float ageInTicks, float netHeadYaw, float headPitch, float partialTick) {

        // 翅膀收起时的角度
        float wingRootYAgeLerp = Mth.lerp(this.ageLerp, 0.174532F, 0.3490659F);  // 10-20度
        float wingRootZAgeLerp = Mth.lerp(this.ageLerp, 0.174532F, 0.2617994F);  // 10-15度

        // 左翅膀 - 收起
        this.leftWingRoot.xRot = 0.0F;
        this.leftWingRoot.yRot = -wingRootYAgeLerp;
        this.leftWingRoot.zRot = -wingRootZAgeLerp;

        // 右翅膀 - 收起
        this.rightWingRoot.xRot = 0.0F;
        this.rightWingRoot.yRot = wingRootYAgeLerp;
        this.rightWingRoot.zRot = wingRootZAgeLerp;

        // 翅膀骨骼
        this.leftWingBone1.xRot = 0.0F;
        this.leftWingBone1.yRot = 0.0F;
        this.leftWingBone1.zRot = -0.087266F;  // -5度

        this.leftWingBone2.xRot = 0.0F;
        this.leftWingBone2.yRot = 0.0F;
        this.leftWingBone2.zRot = -0.48171F;   // -27.6度

        this.rightWingBone1.xRot = 0.0F;
        this.rightWingBone1.yRot = 0.0F;
        this.rightWingBone1.zRot = 0.087266F;  // 5度

        this.rightWingBone2.xRot = 0.0F;
        this.rightWingBone2.yRot = 0.0F;
        this.rightWingBone2.zRot = 0.48171F;   // 27.6度
    }
}