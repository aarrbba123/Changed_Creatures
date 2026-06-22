package net.hhdsj.goodblock.mixin.Player;

import net.hhdsj.goodblock.client.models.other.TailModel;
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

}