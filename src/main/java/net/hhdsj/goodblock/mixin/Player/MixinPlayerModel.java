package net.hhdsj.goodblock.mixin.Player;

import net.hhdsj.goodblock.client.renderer.models.TailModel;
import net.hhdsj.goodblock.init.GoodblockModModelLayers;
import net.hhdsj.goodblock.mixin.ModelPartAccessor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Pose;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerModel.class)
public abstract class MixinPlayerModel {

    @Unique
    public ModelPart goodblock$body;

    @Unique
    private TailModel good_blocks$tailModel;

    @Unique
    private ModelPart good_blocks$tailPart;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void onInit(ModelPart root, boolean slim, CallbackInfo ci) {
        ModelPart tailRoot = Minecraft.getInstance()
                .getEntityModels()
                .bakeLayer(GoodblockModModelLayers.TAIL_LAYER);
        this.good_blocks$tailModel = new TailModel(tailRoot);
        this.good_blocks$tailPart = tailRoot.getChild("Tail");

        this.good_blocks$tailPart.setPos(0.0F, -2.0F, 6.0F);
        this.good_blocks$tailPart.setRotation((float) Math.PI / 2.0F, 0.0F, 0.0F);

        // 使用 Accessor 获取 children map
        ((ModelPartAccessor) (Object) goodblock$body).getChildren().put("good_blocks$tail", this.good_blocks$tailPart);
    }

    @Inject(
            method = "setupAnim(Lnet/minecraft/world/entity/LivingEntity;FFFFF)V",
            at = @At("TAIL")
    )
    private void onSetupAnim(
            net.minecraft.world.entity.LivingEntity entity,
            float limbSwing,
            float limbSwingAmount,
            float ageInTicks,
            float netHeadYaw,
            float headPitch,
            CallbackInfo ci
    ) {
        if (good_blocks$tailModel == null) return;
        if (!(entity instanceof net.minecraft.client.player.AbstractClientPlayer player)) return;

        good_blocks$tailModel.setupAnim(limbSwing, limbSwingAmount, ageInTicks);
        if (player.getVehicle() != null) good_blocks$tailModel.setupRideAnim();
        if (player.getPose() == Pose.SLEEPING) good_blocks$tailModel.setupSleepAnim();
        if (player.isCrouching()) good_blocks$tailModel.setupCrouchAnim();
        float swimAmount = player.getSwimAmount(1.0F);
        if (swimAmount > 0.0F) good_blocks$tailModel.setupSwimAnim(swimAmount);
        if (player.isFallFlying()) good_blocks$tailModel.setupFallFlyAnim(player.getFallFlyingTicks());

        ModelPart tailModelPart = good_blocks$tailModel.getTailPart();
        this.good_blocks$tailPart.copyFrom(tailModelPart);
    }
}