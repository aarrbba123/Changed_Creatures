package net.hhdsj.changed_creatures.client.renderer.animate.wing;

import net.ltxprogrammer.changed.client.renderer.animate.HumanoidAnimator;
import net.ltxprogrammer.changed.client.renderer.model.AdvancedHumanoidModel;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.minecraft.client.model.geom.ModelPart;

public abstract class AbstractWingAnimator<T extends ChangedEntity, M extends AdvancedHumanoidModel<T>> extends HumanoidAnimator.Animator<T, M> {
    public final ModelPart leftWingRoot;
    public final ModelPart leftWingBone1;
    public final ModelPart leftWingBone2;
    public final ModelPart leftWingBone3;
    public final ModelPart rightWingRoot;
    public final ModelPart rightWingBone1;
    public final ModelPart rightWingBone2;
    public final ModelPart rightWingBone3;

    public AbstractWingAnimator(ModelPart leftWingRoot, ModelPart leftWingBone1, ModelPart leftWingBone2,ModelPart leftWingBone3, ModelPart rightWingRoot, ModelPart rightWingBone1, ModelPart rightWingBone2,ModelPart rightWingBone3) {
        this.leftWingRoot = leftWingRoot;
        this.leftWingBone1 = leftWingBone1;
        this.leftWingBone3 = leftWingBone3;
        this.leftWingBone2 = leftWingBone2;
        this.rightWingRoot = rightWingRoot;
        this.rightWingBone1 = rightWingBone1;
        this.rightWingBone3 = rightWingBone3;
        this.rightWingBone2 = rightWingBone2;
    }
}
