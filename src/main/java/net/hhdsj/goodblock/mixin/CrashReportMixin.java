package net.hhdsj.goodblock.mixin;

import net.minecraft.CrashReport;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CrashReport.class)
public class CrashReportMixin {

    @Mutable
    @Final
    @Shadow
    private String details;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void onCrashReportInit(CallbackInfo ci) {
        String customInfo = "\n\n-- GoodBlock Mod --\nIf you crash due to the Goodblock mod, please report it at:\nhttps://github.com/hhdsjgit/Good-blocks/issues\n";
        this.details = customInfo + this.details;
    }
}