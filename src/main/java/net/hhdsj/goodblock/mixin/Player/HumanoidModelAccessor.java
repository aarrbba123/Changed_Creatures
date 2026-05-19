package net.hhdsj.goodblock.mixin.Player;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(HumanoidModel.class)
public interface HumanoidModelAccessor {

    @Accessor("body")
    ModelPart getBody();

    @Accessor("head")
    ModelPart getHead();

    @Accessor("leftArm")
    ModelPart getLeftArm();

    @Accessor("rightArm")
    ModelPart getRightArm();

    @Accessor("leftLeg")
    ModelPart getLeftLeg();

    @Accessor("rightLeg")
    ModelPart getRightLeg();
}