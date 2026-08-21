package net.hhdsj.changed_creatures.client.renderer.animate.wing;


import net.ltxprogrammer.changed.client.renderer.animate.HumanoidAnimator;
import net.ltxprogrammer.changed.client.renderer.animate.HumanoidAnimator.AnimateStage;
import net.ltxprogrammer.changed.client.renderer.model.AdvancedHumanoidModel;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

public class DragonOnlyRootWingFallFlyAnimator<T extends ChangedEntity, M extends AdvancedHumanoidModel<T>> extends AbstractWingAnimatorOnly<T, M> {
    public DragonOnlyRootWingFallFlyAnimator(ModelPart leftWingRoot, ModelPart rightWingRoot) {
        super(leftWingRoot, rightWingRoot);
    }

    public HumanoidAnimator.AnimateStage preferredStage() {
        return AnimateStage.FALL_FLY;
    }

    public void setupAnim(@NotNull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.leftWingRoot.xRot = Mth.lerp(this.core.fallFlyingAmount, this.leftWingRoot.xRot, 0.0F);
        this.leftWingRoot.yRot = Mth.lerp(this.core.fallFlyingAmount, this.leftWingRoot.yRot, 0.087266F);
        this.leftWingRoot.zRot = Mth.lerp(this.core.fallFlyingAmount, this.leftWingRoot.zRot, 0.0F);
        this.rightWingRoot.xRot = Mth.lerp(this.core.fallFlyingAmount, this.rightWingRoot.xRot, 0.0F);
        this.rightWingRoot.yRot = Mth.lerp(this.core.fallFlyingAmount, this.rightWingRoot.yRot, -0.087266F);
        this.rightWingRoot.zRot = Mth.lerp(this.core.fallFlyingAmount, this.rightWingRoot.zRot, 0.0F);
    }
}
