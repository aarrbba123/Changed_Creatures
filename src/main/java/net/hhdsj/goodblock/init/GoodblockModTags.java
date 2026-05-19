package net.hhdsj.goodblock.init;

import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.ltxprogrammer.changed.init.ChangedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryManager;

public class GoodblockModTags {

    // 获取 TransfurVariant 的注册表名称
    public static final ResourceLocation TRANSFUR_VARIANT_REGISTRY_NAME =
            new ResourceLocation("changed", "transfur_variant");

    public static final TagKey<TransfurVariant<?>> SLOW_INFECTION_VARIANTS =
            TagKey.create(
                    ChangedRegistry.TRANSFUR_VARIANT.get().getRegistryKey(),
                    new ResourceLocation("goodblock", "slow_infection_variants")
            );

    public static final TagKey<TransfurVariant<?>> ANTI_FIRE = TagKey.create(
            ChangedRegistry.TRANSFUR_VARIANT.get().getRegistryKey(),
            new ResourceLocation("goodblock", "anti_fire_latex")
    );

    // 辅助方法：获取 Forge 注册表
    public static IForgeRegistry<TransfurVariant<?>> getTransfurVariantRegistry() {
        return RegistryManager.ACTIVE.getRegistry(TRANSFUR_VARIANT_REGISTRY_NAME);
    }
}