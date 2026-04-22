package net.hhdsj.goodblock.mixin;

import net.minecraft.CrashReport;
import net.minecraftforge.logging.CrashReportExtender;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CrashReportExtender.class)
public class CrashReportExtenderMixin {
    @Inject(method = "addCrashReportHeader", at = @At("HEAD"), remap = false)
    private static void CrashReportExtender(StringBuilder builder, CrashReport crashReport, CallbackInfo ci) {
        try {
            builder.append("\n\n-- GoodBlock Mod --\n");
            builder.append("If you crash due to the Goodblock mod, please report it at:\n");
            builder.append("https://github.com/hhdsjgit/Good-blocks/issues\n");
            builder.append("\n\n-- END --\n");
        } catch(Throwable ignored) {

        }
    }
}
