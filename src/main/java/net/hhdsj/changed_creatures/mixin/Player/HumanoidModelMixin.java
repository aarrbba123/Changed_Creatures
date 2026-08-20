package net.hhdsj.changed_creatures.mixin.Player;

import net.hhdsj.changed_creatures.entity.PartiallyTransfurVariant;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HumanoidModel.class)
public abstract class HumanoidModelMixin<T extends LivingEntity> {

    @Final
    @Shadow
    public ModelPart rightArm;

    @Final
    @Shadow
    public ModelPart leftArm;

    @Shadow
    @Final
    public ModelPart rightLeg;

    @Shadow
    @Final
    public ModelPart leftLeg;

    @Inject(
            method = "setupAnim",
            at = @At("RETURN")
    )
    private void onSetupAnimReturn(T entity, float limbSwing, float limbSwingAmount,
                                   float ageInTicks, float netHeadYaw, float headPitch,
                                   CallbackInfo ci) {
        if (!(entity instanceof Player player)) {
            return;
        }

        if (!PartiallyTransfurVariant.canFly(player) || !PartiallyTransfurVariant.meetsFlightCriteria(player)) {
            return;
        }
        if (!player.getAbilities().flying) {
            return;
        }
        float scale = 0.5f;
        rightArm.xRot *= scale;
        leftArm.xRot *= scale;
        rightLeg.xRot *= scale;
        leftLeg.xRot *= scale;
    }

    @Unique
    private boolean changed_creatures$isThirdPersonLocalPlayer(T entity) {
        Player localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null) {
            return false;
        }

        if (entity != localPlayer) {
            return false;
        }

        return !Minecraft.getInstance().options.getCameraType().isFirstPerson();
    }
}