package net.hhdsj.changed_creatures.client.renderer.animate.wing;


import net.ltxprogrammer.changed.client.renderer.animate.HumanoidAnimator;
import net.ltxprogrammer.changed.client.renderer.animate.HumanoidAnimator.AnimateStage;
import net.ltxprogrammer.changed.client.renderer.animate.wing.AbstractWingAnimatorV2;
import net.ltxprogrammer.changed.client.renderer.model.AdvancedHumanoidModel;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

public class DragonOnlyRootWingInitAnimator<T extends ChangedEntity, M extends AdvancedHumanoidModel<T>> extends AbstractWingAnimatorOnly<T, M> {
    public DragonOnlyRootWingInitAnimator(ModelPart leftWingRoot, ModelPart rightWingRoot) {
        super(leftWingRoot,rightWingRoot);
    }

    public HumanoidAnimator.AnimateStage preferredStage() {
        return AnimateStage.INIT;
    }

    public void setupAnim(@NotNull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float wingRootYAgeLerp = Mth.lerp(this.core.ageLerp, 0.174532F, 0.3490659F);
        float wingRootZAgeLerp = Mth.lerp(this.core.ageLerp, 0.174532F, 0.2617994F);
        this.leftWingRoot.xRot = 0.0F;
        this.leftWingRoot.yRot = -wingRootYAgeLerp;
        this.leftWingRoot.zRot = -wingRootZAgeLerp;
        this.rightWingRoot.xRot = 0.0F;
        this.rightWingRoot.yRot = wingRootYAgeLerp;
        this.rightWingRoot.zRot = wingRootZAgeLerp;
    }
}
