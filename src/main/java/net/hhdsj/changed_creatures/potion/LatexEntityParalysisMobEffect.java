package net.hhdsj.changed_creatures.potion;

import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.ltxprogrammer.changed.util.EntityUtil;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public class LatexEntityParalysisMobEffect extends MobEffect {
    public LatexEntityParalysisMobEffect() {
        super(MobEffectCategory.HARMFUL, -52480);
    }

    @Override
    public @NotNull String getDescriptionId() {
        return "effect.changed_creatures.latex_paralysis";
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
        if (entity instanceof Player player) {
            if (ProcessTransfur.getPlayerTransfurVariant(player) != null) {
                EntityUtil.setNoControlTicks(player, 2);
                var Progress = ProcessTransfur.getPlayerTransfurProgress(player);
                if (Progress != 0f) {
                    ProcessTransfur.setPlayerTransfurProgress(player,Progress+0.05f);
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
