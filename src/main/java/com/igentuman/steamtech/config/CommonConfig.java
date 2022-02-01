package com.igentuman.steamtech.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.ArrayList;
import java.util.List;

public class CommonConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final General GENERAL = new General(BUILDER);
    public static final ForgeConfigSpec spec = BUILDER.build();

    private static boolean loaded = false;
    private static List<Runnable> loadActions = new ArrayList<>();

    public static void setLoaded() {
        if (!loaded)
            loadActions.forEach(Runnable::run);
        loaded = true;
    }

    public static boolean isLoaded() {
        return loaded;
    }

    public static void onLoad(Runnable action) {
        if (loaded)
            action.run();
        else
            loadActions.add(action);
    }

    public static class General {
        public final ForgeConfigSpec.ConfigValue<Integer> tin_ore_vein_size;
        public final ForgeConfigSpec.ConfigValue<Integer> tin_ore_veins;
        public final ForgeConfigSpec.ConfigValue<Integer> lead_ore_vein_size;
        public final ForgeConfigSpec.ConfigValue<Integer> lead_ore_veins;
        public final ForgeConfigSpec.ConfigValue<Integer> turbine_fe;

        public General(ForgeConfigSpec.Builder builder) {
            builder.push("General");

            tin_ore_vein_size = builder
                    .comment("Tin Ore Vein Size (0 to Disable)")
                    .define("tin_ore_vein_size", 4);

            tin_ore_veins = builder
                    .comment("Tin Ore Veins (0 to Disable)")
                    .define("tin_ore_veins", 2);

            lead_ore_vein_size = builder
                    .comment("Lead Ore Vein Size (0 to Disable)")
                    .define("lead_ore_vein_size", 4);

            lead_ore_veins = builder
                    .comment("Lead Ore Veins (0 to Disable)")
                    .define("lead_ore_veins", 2);

            turbine_fe = builder
                    .comment("Turbine Forge Energy per tick")
                    .define("turbine_fe", 12);

            builder.pop();
        }
    }
}
