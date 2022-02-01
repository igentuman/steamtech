package com.igentuman.steamtech.datagen;

import com.igentuman.steamtech.setup.Registration;
import net.minecraft.data.DataGenerator;

public class STLootTables extends BaseLootTableProvider {

    public STLootTables(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables() {
        lootTables.put(Registration.GENERATOR.get(), createStandardTable("generator", Registration.GENERATOR.get(), Registration.GENERATOR_BE.get()));
        lootTables.put(Registration.POWERGEN.get(), createStandardTable("powergen", Registration.POWERGEN.get(), Registration.POWERGEN_BE.get()));
        lootTables.put(Registration.TIN_ORE.get(), createSilkTouchTable("tin_ore", Registration.TIN_ORE.get(), Registration.RAW_TIN_CHUNK.get(), 1, 3));
        lootTables.put(Registration.LEAD_ORE.get(), createSilkTouchTable("lead_ore", Registration.LEAD_ORE.get(), Registration.RAW_LEAD_CHUNK.get(), 1, 3));
    }
}
