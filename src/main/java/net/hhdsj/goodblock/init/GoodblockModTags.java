package net.hhdsj.goodblock.init;

import net.hhdsj.goodblock.GoodblockMod;
import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.ltxprogrammer.changed.init.ChangedRegistry;
import net.minecraft.tags.TagKey;

import java.util.function.Supplier;

public class GoodblockModTags {
    // 使用 Supplier 延迟初始化
    public static final Supplier<TagKey<TransfurVariant<?>>> SLOW_INFECTION_VARIANTS =
            () -> tfCreate("slow_infection_variants");

    public static final Supplier<TagKey<TransfurVariant<?>>> LATEX_ANTI_FIRE =
            () -> tfCreate("anti_fire_latex");

    public static TagKey<TransfurVariant<?>> slowInfectionVariants() {
        return SLOW_INFECTION_VARIANTS.get();
    }

    public static TagKey<TransfurVariant<?>> antiFireLatex() {
        return LATEX_ANTI_FIRE.get();
    }

    private static TagKey<TransfurVariant<?>> tfCreate(String pName) {
        return TagKey.create(
                ChangedRegistry.TRANSFUR_VARIANT.get().getRegistryKey(),
                GoodblockMod.ModResource(pName)
        );
    }
}