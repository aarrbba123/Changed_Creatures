package net.hhdsj.goodblock.event;

import net.hhdsj.goodblock.GoodblockMod;
import net.hhdsj.goodblock.init.GoodblockModTransfurVariants;
import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GoodblockMod.MODID)
public class DamageHandler {

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        LivingEntity target = event.getEntity();      // 受到伤害的实体
        LivingEntity attacker = null;

        if (!(target instanceof Player)) {
            return;
        }

        TransfurVariantInstance<?> variant = ProcessTransfur.getPlayerTransfurVariant((Player) target);
        if (variant == null) {
            return;
        }

        if (event.getSource().getEntity() instanceof LivingEntity) {
            attacker = (LivingEntity) event.getSource().getEntity();
        }
        if (variant.getParent() == GoodblockModTransfurVariants.LATEX_HYAZINTHE_FOX.get()) {
            target.addEffect(new MobEffectInstance(
                    MobEffects.WEAKNESS,      // 虚弱效果
                    1000,                       // 持续时间（5秒 = 100刻）
                    0,                         // 等级（I级 = 0, II级 = 1）
                    true,                      // 显示粒子效果
                    true                       // 显示图标
            ));
        }
        if (variant.getParent() == GoodblockModTransfurVariants.LATEX_ENKANG_DRAGON_SHARK.get()) {
            target.addEffect(new MobEffectInstance(
                    MobEffects.WEAKNESS,      // 虚弱效果
                    1000,                       // 持续时间（5秒 = 100刻）
                    2,                         // 等级（I级 = 0, II级 = 1）
                    true,                      // 显示粒子效果
                    true                       // 显示图标
            ));
        }
    }
}