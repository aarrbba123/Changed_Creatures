package net.hhdsj.goodblock.mixin;

import net.minecraft.CrashReport;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CrashReport.class)
public class CrashReportMixin {

    @Inject(method = "getFriendlyReport", at = @At("RETURN"), cancellable = true)
    private void addCustomHeader(CallbackInfoReturnable<String> cir) {
        String original = cir.getReturnValue();
        cir.setReturnValue("// f you crash due to the Goodblock mod, please report it at:\n" +
                "https://github.com/hhdsjgit/Good-blocks/issues\n" + original);
    }
}