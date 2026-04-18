package net.hhdsj.goodblock.mixin;

import net.minecraft.CrashReport;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CrashReport.class)
public class CrashReportMixin {

    @Inject(method = "getDetails(Ljava/lang/StringBuilder;)V", at = @At("RETURN"))
    private void addGoodBlockInfo(StringBuilder stringBuilder, CallbackInfo ci) {
        stringBuilder.append("\n\n-- GoodBlock Mod --\n");
        stringBuilder.append("If you crash due to the Goodblock mod, please report it at:\n");
        stringBuilder.append("https://github.com/hhdsjgit/Good-blocks/issues\n");
    }
}