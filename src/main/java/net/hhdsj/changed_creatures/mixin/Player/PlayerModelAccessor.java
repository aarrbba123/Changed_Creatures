package net.hhdsj.changed_creatures.mixin.Player;

import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(PlayerModel.class)
public abstract class PlayerModelAccessor implements HumanoidModelAccessor {

    @Final
    @Shadow
    public ModelPart jacket;

    @Final
    @Shadow
    public ModelPart leftSleeve;

    @Final
    @Shadow
    public ModelPart rightSleeve;

    @Final
    @Shadow
    public ModelPart leftPants;

    @Final
    @Shadow
    public ModelPart rightPants;
}