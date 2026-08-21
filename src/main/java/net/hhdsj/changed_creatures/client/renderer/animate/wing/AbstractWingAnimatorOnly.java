package net.hhdsj.changed_creatures.client.renderer.animate.wing;

import net.ltxprogrammer.changed.client.renderer.animate.HumanoidAnimator;
import net.ltxprogrammer.changed.client.renderer.model.AdvancedHumanoidModel;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.minecraft.client.model.geom.ModelPart;

public abstract class AbstractWingAnimatorOnly<T extends ChangedEntity, M extends AdvancedHumanoidModel<T>> extends HumanoidAnimator.Animator<T, M> {
    public final ModelPart leftWingRoot;
    public final ModelPart rightWingRoot;

    public AbstractWingAnimatorOnly(ModelPart leftWingRoot, ModelPart rightWingRoot) {
        this.leftWingRoot = leftWingRoot;
        this.rightWingRoot = rightWingRoot;
    }
}
