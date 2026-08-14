package net.hhdsj.changed_creatures.client.animation;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.util.Mth;

public class WingAnimationManager {

    private final ModelPart leftWing;
    private final ModelPart leftWingRoot;
    private final ModelPart leftFirstise;
    private final ModelPart leftSecondaries;
    private final ModelPart leftTertiaries;

    private final ModelPart rightWing;
    private final ModelPart rightWingRoot;
    private final ModelPart rightFirsties;
    private final ModelPart rightSecondaries;
    private final ModelPart rightTertiaries;

    // 动画状态
    private float flyAmount = 0.0F;
    private float fallFlyingAmount = 0.0F;
    private float swimAmount = 0.0F;
    private float crouchAmount = 0.0F;

    public WingAnimationManager(ModelPart leftWing, ModelPart leftWingRoot, ModelPart leftFirstise,
                                ModelPart leftSecondaries, ModelPart leftTertiaries,
                                ModelPart rightWing, ModelPart rightWingRoot, ModelPart rightFirsties,
                                ModelPart rightSecondaries, ModelPart rightTertiaries) {
        this.leftWing = leftWing;
        this.leftWingRoot = leftWingRoot;
        this.leftFirstise = leftFirstise;
        this.leftSecondaries = leftSecondaries;
        this.leftTertiaries = leftTertiaries;

        this.rightWing = rightWing;
        this.rightWingRoot = rightWingRoot;
        this.rightFirsties = rightFirsties;
        this.rightSecondaries = rightSecondaries;
        this.rightTertiaries = rightTertiaries;
    }

    public void update(AbstractClientPlayer player, float partialTick) {
        float lerpSpeed = 0.15F;
        this.flyAmount = Mth.lerp(partialTick * lerpSpeed, this.flyAmount,
                player.getAbilities().flying ? 1.0F : 0.0F);
        this.fallFlyingAmount = Mth.lerp(partialTick * lerpSpeed, this.fallFlyingAmount,
                player.isFallFlying() ? 1.0F : 0.0F);
        this.swimAmount = Mth.lerp(partialTick * lerpSpeed, this.swimAmount,
                player.isVisuallySwimming() ? 1.0F : 0.0F);
        this.crouchAmount = Mth.lerp(partialTick * lerpSpeed, this.crouchAmount,
                player.isCrouching() ? 1.0F : 0.0F);
    }

    public void applyAnimation(AbstractClientPlayer player, float limbSwing, float limbSwingAmount,
                               float ageInTicks, float netHeadYaw, float headPitch, float partialTick) {

        // 确定展开程度
        float spreadAmount = Math.max(this.flyAmount, this.fallFlyingAmount);
        float swimSpread = this.swimAmount * 0.6F;
        spreadAmount = Math.max(spreadAmount, swimSpread);

        // 计算扇动角度
        float flapAngle = 0.0F;
        if (this.flyAmount > 0.5F) {
            // 创造飞行：快速扇动
            float flap = Mth.cos(ageInTicks * 0.3F);
            flap *= flap;
            flapAngle = Mth.map(flap, 0.0F, 1.0F, -0.15F, 0.25F);
        } else if (this.fallFlyingAmount > 0.5F) {
            // 鞘翅飞行：轻微扇动
            flapAngle = Mth.sin(ageInTicks * 0.1F) * 0.05F;
        } else if (this.swimAmount > 0.5F) {
            // 游泳：划水动作
            flapAngle = Mth.sin(ageInTicks * 0.4F) * 0.3F;
        }

        // 应用左翅膀动画
        applyLeftWingAnimation(spreadAmount, flapAngle);

        // 应用右翅膀动画
        applyRightWingAnimation(spreadAmount, flapAngle);

        // 应用潜行影响
        if (this.crouchAmount > 0.01F) {
            this.leftWing.yRot += this.crouchAmount * 0.1F;
            this.rightWing.yRot -= this.crouchAmount * 0.1F;
        }
    }

    private void applyLeftWingAnimation(float spreadAmount, float flapAngle) {
        // 左翅膀主翼展开
        this.leftWing.yRot = Mth.lerp(spreadAmount, -0.48F, -0.15F);
        this.leftWing.zRot = Mth.lerp(spreadAmount, 0.0F, -0.25F);
        this.leftWing.xRot = flapAngle;

        // 翅膀根部
        this.leftWingRoot.zRot = Mth.lerp(spreadAmount, 0.0F, -0.15F);

        // 第一级羽毛
        this.leftFirstise.zRot = Mth.lerp(spreadAmount, -0.7854F, -1.1F);

        // 第二级羽毛
        this.leftSecondaries.zRot = Mth.lerp(spreadAmount, -0.5236F, -0.8F);

        // 第三级羽毛
        this.leftTertiaries.zRot = Mth.lerp(spreadAmount, -0.9599F, -1.3F);
    }

    private void applyRightWingAnimation(float spreadAmount, float flapAngle) {
        // 右翅膀主翼展开
        this.rightWing.yRot = Mth.lerp(spreadAmount, 0.48F, 0.15F);
        this.rightWing.zRot = Mth.lerp(spreadAmount, 0.0F, 0.25F);
        this.rightWing.xRot = -flapAngle;

        // 翅膀根部
        this.rightWingRoot.zRot = Mth.lerp(spreadAmount, 0.0F, 0.15F);

        // 第一级羽毛
        this.rightFirsties.zRot = Mth.lerp(spreadAmount, 0.7854F, 1.1F);

        // 第二级羽毛
        this.rightSecondaries.zRot = Mth.lerp(spreadAmount, 0.5236F, 0.8F);

        // 第三级羽毛
        this.rightTertiaries.zRot = Mth.lerp(spreadAmount, 0.9599F, 1.3F);
    }
}