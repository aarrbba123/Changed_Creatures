package net.hhdsj.goodblock.client.renderer.animate.wing;

import net.ltxprogrammer.changed.client.renderer.animate.HumanoidAnimator;
import net.ltxprogrammer.changed.client.renderer.model.AdvancedHumanoidModel;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

public class FrostScaleDragonTaurWingInitAnimator<T extends ChangedEntity, M extends AdvancedHumanoidModel<T>> extends AbstractWingAnimator<T, M> {
    public FrostScaleDragonTaurWingInitAnimator(
            ModelPart leftWingRoot, ModelPart leftWingBone1, ModelPart leftWingBone2,ModelPart leftWingBone3,
            ModelPart rightWingRoot, ModelPart rightWingBone1, ModelPart rightWingBone2,ModelPart rightWingBone3) {
        super(leftWingRoot,leftWingBone1,leftWingBone2,leftWingBone3,
                rightWingRoot,rightWingBone1,rightWingBone2,rightWingBone3);
    }

    @Override
    public HumanoidAnimator.AnimateStage preferredStage() {
        return HumanoidAnimator.AnimateStage.INIT;
    }

    @Override
    public void setupAnim(@NotNull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        // 从第1帧提取的旋转值（角度转换为弧度）
        // leftWingRoot: (-33.3651°, -31.9176°, 30.1077°)
        // rightWingRoot: (-33.3651°, 31.9176°, -30.1077°)
        // leftSecondaries: (0°, 0°, 20°) -> 对应 leftWingBone2 (第2级)
        // rightSecondaries: (0°, 0°, -20°) -> 对应 rightWingBone2 (第2级)
        // leftTertiaries: (0°, 0°, 25°) -> 对应 leftWingBone3 (第3级)
        // rightTertiaries: (0°, 0°, -25°) -> 对应 rightWingBone3 (第3级)
        // leftWingBone1 和 rightWingBone1 保持默认 (0°, 0°, 0°)

        // 角度转弧度: 角度 * π / 180
        float wingRootXAgeLerp = Mth.lerp(core.ageLerp, -0.5823f, 0.0f); // -33.3651°
        float leftWingRootYAgeLerp = Mth.lerp(core.ageLerp, -0.5571f, 0.0f); // -31.9176°
        float leftWingRootZAgeLerp = Mth.lerp(core.ageLerp, 0.5255f, 0.0f); // 30.1077°
        float rightWingRootYAgeLerp = Mth.lerp(core.ageLerp, 0.5571f, 0.0f); // 31.9176°
        float rightWingRootZAgeLerp = Mth.lerp(core.ageLerp, -0.5255f, 0.0f); // -30.1077°

        float leftSecondaryZAgeLerp = Mth.lerp(core.ageLerp, 0.3491f, 0.0f); // 20°
        float rightSecondaryZAgeLerp = Mth.lerp(core.ageLerp, -0.3491f, 0.0f); // -20°
        float leftTertiaryZAgeLerp = Mth.lerp(core.ageLerp, 0.4363f, 0.0f); // 25°
        float rightTertiaryZAgeLerp = Mth.lerp(core.ageLerp, -0.4363f, 0.0f); // -25°

        // === 翼根 (第0级/root) ===
        leftWingRoot.xRot = wingRootXAgeLerp;
        leftWingRoot.yRot = leftWingRootYAgeLerp;
        leftWingRoot.zRot = leftWingRootZAgeLerp;

        rightWingRoot.xRot = wingRootXAgeLerp;
        rightWingRoot.yRot = rightWingRootYAgeLerp;
        rightWingRoot.zRot = rightWingRootZAgeLerp;

        // === 第1级 (first) ===
        // 动画中没有指定，保持默认
        leftWingBone1.xRot = 0.0f;
        leftWingBone1.yRot = 0.0f;
        leftWingBone1.zRot = 0.0f;

        rightWingBone1.xRot = 0.0f;
        rightWingBone1.yRot = 0.0f;
        rightWingBone1.zRot = 0.0f;

        // === 第2级 (secondaries) ===
        leftWingBone2.xRot = 0.0f;
        leftWingBone2.yRot = 0.0f;
        leftWingBone2.zRot = leftSecondaryZAgeLerp;

        rightWingBone2.xRot = 0.0f;
        rightWingBone2.yRot = 0.0f;
        rightWingBone2.zRot = rightSecondaryZAgeLerp;

        // === 第3级 (tertiaries) ===
        leftWingBone3.xRot = 0.0f;
        leftWingBone3.yRot = 0.0f;
        leftWingBone3.zRot = leftTertiaryZAgeLerp;

        rightWingBone3.xRot = 0.0f;
        rightWingBone3.yRot = 0.0f;
        rightWingBone3.zRot = rightTertiaryZAgeLerp;
    }
}
