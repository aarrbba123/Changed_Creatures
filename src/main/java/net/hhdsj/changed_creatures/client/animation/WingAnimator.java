package net.hhdsj.changed_creatures.client.animation;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.util.Mth;

public abstract class WingAnimator {

    protected final ModelPart leftWingRoot;
    protected final ModelPart leftWingBone1;
    protected final ModelPart leftWingBone2;
    protected final ModelPart rightWingRoot;
    protected final ModelPart rightWingBone1;
    protected final ModelPart rightWingBone2;

    // 动画状态变量
    protected float ageLerp = 0.0F;
    protected float flyAmount = 0.0F;
    protected float fallFlyingAmount = 0.0F;
    protected float swimAmount = 0.0F;

    public WingAnimator(ModelPart leftWingRoot, ModelPart leftWingBone1, ModelPart leftWingBone2,
                        ModelPart rightWingRoot, ModelPart rightWingBone1, ModelPart rightWingBone2) {
        this.leftWingRoot = leftWingRoot;
        this.leftWingBone1 = leftWingBone1;
        this.leftWingBone2 = leftWingBone2;
        this.rightWingRoot = rightWingRoot;
        this.rightWingBone1 = rightWingBone1;
        this.rightWingBone2 = rightWingBone2;
    }

    public abstract void setupAnim(AbstractClientPlayer player, float limbSwing, float limbSwingAmount,
                                   float ageInTicks, float netHeadYaw, float headPitch, float partialTick);

    public abstract WingAnimationState getState();

    // 更新动画状态变量
    public void updateState(AbstractClientPlayer player, float partialTick) {
        this.ageLerp = Mth.lerp(partialTick, this.ageLerp, player.isCrouching() ? 0.5F : 0.0F);
        this.flyAmount = Mth.lerp(partialTick, this.flyAmount,
                player.getAbilities().flying ? 1.0F : 0.0F);
        this.fallFlyingAmount = Mth.lerp(partialTick, this.fallFlyingAmount,
                player.isFallFlying() ? 1.0F : 0.0F);
        this.swimAmount = Mth.lerp(partialTick, this.swimAmount,
                player.isVisuallySwimming() ? 1.0F : 0.0F);
    }
}