package net.hhdsj.changed_creatures.client.renderer.animate.wing;

import net.ltxprogrammer.changed.client.renderer.animate.HumanoidAnimator;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.client.renderer.model.AdvancedHumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

public class DragonOnlyRootWingCreativeFlyAnimator<T extends ChangedEntity, M extends AdvancedHumanoidModel<T>> extends AbstractWingAnimatorOnly<T, M> {
    public static final float WING_FLAP_RATE = 0.2f;
    public static final float BODY_FLY_SCALE = 0.5f;

    public DragonOnlyRootWingCreativeFlyAnimator(
            ModelPart leftWingRoot, ModelPart rightWingRoot) {
        super(leftWingRoot, rightWingRoot);
    }

    @Override
    public HumanoidAnimator.AnimateStage preferredStage() {
        return HumanoidAnimator.AnimateStage.CREATIVE_FLY;
    }

    @Override
    public void setupAnim(@NotNull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        leftWingRoot.xRot = Mth.lerp(core.flyAmount, leftWingRoot.xRot, 0.0f);
        leftWingRoot.yRot = Mth.lerp(core.flyAmount, leftWingRoot.yRot, 0.087266f);
        leftWingRoot.zRot = Mth.lerp(core.flyAmount, leftWingRoot.zRot, 0.0f);
        rightWingRoot.xRot = Mth.lerp(core.flyAmount, rightWingRoot.xRot, 0.0f);
        rightWingRoot.yRot = Mth.lerp(core.flyAmount, rightWingRoot.yRot, -0.087266f);
        rightWingRoot.zRot = Mth.lerp(core.flyAmount, rightWingRoot.zRot, 0.0f);
        float flapAmount = Mth.cos(ageInTicks * WING_FLAP_RATE);
        flapAmount = flapAmount * flapAmount;
        float flapRotate = Mth.map(flapAmount, 0.0f, 1.0f, Mth.DEG_TO_RAD * -20.0f, Mth.DEG_TO_RAD * 32.0f);

        leftWingRoot.yRot = Mth.lerp(core.flyAmount, leftWingRoot.yRot, -flapRotate);
        rightWingRoot.yRot = Mth.lerp(core.flyAmount, rightWingRoot.yRot, flapRotate);
    }
}
