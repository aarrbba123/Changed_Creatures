package net.hhdsj.changed_creatures.init;

public class ChangedCreatureModPlacedFeatures {
    /*
    public static final ResourceKey<PlacedFeature> SULPHUR_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new net.minecraft.resources.ResourceLocation("changed_creatures", "sulphur_ore_placed"));

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        PlacementUtils.register(context, SULPHUR_ORE_PLACED_KEY,
                configuredFeatures.getOrThrow(GoodblockModConfiguredFeatures.SULPHUR_ORE_KEY),
                commonOrePlacement(10,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(128)))
        );
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier pCountPlacement,
                                                        PlacementModifier pHeightRange) {
        return List.of(pCountPlacement, InSquarePlacement.spread(), pHeightRange, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int pCount,
                                                              PlacementModifier pHeightRange) {
        return orePlacement(CountPlacement.of(pCount), pHeightRange);
    }*/
}