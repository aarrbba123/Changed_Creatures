package net.hhdsj.changed_creatures.util;

import net.hhdsj.changed_creatures.event.GoodblockProcessTransfur;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.TransfurContext;
import net.ltxprogrammer.changed.init.ChangedRegistry;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

/**
 * Tf
 */
public class ProgressTransfurExt {

    public static void execute(LivingEntity livingEntity,String text) {
        final ResourceLocation FORM_VARIANT = new ResourceLocation(text);
        try {
            final var variant = ChangedRegistry.TRANSFUR_VARIANT.get().getValue(FORM_VARIANT);

            if (variant != null) {
                GoodblockProcessTransfur.progressTransfur(livingEntity, 5f, variant, TransfurContext.hazard(TransfurCause.GRAB_REPLICATE));
            }
        } catch (Exception e) {
            e.printStackTrace();
            //QWQ AWA
        }
    }

    /**
     * Tf的简单辅助
     * @param livingEntity 实体(提供类型为LivingEntity)
     * @param progress_speed 速度
     * @param text 变体名称,类似xxx:form_xxx
     * @param transfurCause 动画从哪里播放,类似TransfurCause.FACE_HAZARD
     */
    public static void tf(LivingEntity livingEntity,float progress_speed,String text,TransfurCause transfurCause) {
        final ResourceLocation FORM_VARIANT = new ResourceLocation(text);
        try {
            final var variant = ChangedRegistry.TRANSFUR_VARIANT.get().getValue(FORM_VARIANT);
            if (variant != null) {
                ProcessTransfur.progressTransfur(livingEntity, progress_speed, variant, TransfurContext.hazard(transfurCause));
            }
        } catch (Exception e) {
            //抛出错误
            e.printStackTrace();
        }
    }
}
