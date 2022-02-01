package com.igentuman.steamtech.worldgen.ores;

import com.igentuman.steamtech.config.CommonConfig;
import com.igentuman.steamtech.setup.Registration;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class Ores {

    public static PlacedFeature TIN_OREGEN;
    public static PlacedFeature LEAD_OREGEN;

    public static void registerConfiguredFeatures() {

        if(CommonConfig.GENERAL.tin_ore_veins.get() > 0 &&  CommonConfig.GENERAL.tin_ore_vein_size.get() > 0) {
            OreConfiguration tinConfig = new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES, Registration.TIN_ORE.get().defaultBlockState(), CommonConfig.GENERAL.tin_ore_vein_size.get());
            TIN_OREGEN = registerPlacedFeature("tin_ore", Feature.ORE.configured(tinConfig),
                    CountPlacement.of(CommonConfig.GENERAL.tin_ore_veins.get()),
                    InSquarePlacement.spread(),
                    new DimensionBiomeFilter(key -> key.equals(DimensionType.OVERWORLD_LOCATION)),
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(90)));
        }

        if(CommonConfig.GENERAL.lead_ore_veins.get() > 0 &&  CommonConfig.GENERAL.lead_ore_vein_size.get() > 0) {
            OreConfiguration leadConfig = new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES, Registration.LEAD_ORE.get().defaultBlockState(), CommonConfig.GENERAL.lead_ore_vein_size.get());
            LEAD_OREGEN = registerPlacedFeature("tin_ore", Feature.ORE.configured(leadConfig),
                    CountPlacement.of(CommonConfig.GENERAL.lead_ore_veins.get()),
                    InSquarePlacement.spread(),
                    new DimensionBiomeFilter(key -> key.equals(DimensionType.OVERWORLD_LOCATION)),
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(90)));
        }
    }

    private static <C extends FeatureConfiguration, F extends Feature<C>> PlacedFeature registerPlacedFeature(String registryName, ConfiguredFeature<C, F> feature, PlacementModifier... placementModifiers) {
        PlacedFeature placed = BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(registryName), feature).placed(placementModifiers);
        return PlacementUtils.register(registryName, placed);
    }

    public static void onBiomeLoadingEvent(BiomeLoadingEvent event) {
        if (event.getCategory() != Biome.BiomeCategory.NETHER && event.getCategory() != Biome.BiomeCategory.THEEND) {
            if(CommonConfig.GENERAL.tin_ore_veins.get() > 0 &&  CommonConfig.GENERAL.tin_ore_vein_size.get() > 0) {
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, TIN_OREGEN);
            }
            if(CommonConfig.GENERAL.lead_ore_veins.get() > 0 &&  CommonConfig.GENERAL.lead_ore_vein_size.get() > 0) {
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, LEAD_OREGEN);
            }
        }
    }
}
