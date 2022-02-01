package com.igentuman.steamtech.datagen;

import com.igentuman.steamtech.SteamTech;
import com.igentuman.steamtech.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

import static com.igentuman.steamtech.blocks.GeneratorBlock.MESSAGE_GENERATOR;
import static com.igentuman.steamtech.blocks.PowergenBlock.MESSAGE_POWERGEN;
import static com.igentuman.steamtech.blocks.PowergenBlock.SCREEN_TUTORIAL_POWERGEN;
import static com.igentuman.steamtech.setup.ModSetup.TAB_NAME;

public class STEngLanguageProvider extends LanguageProvider {

    public STEngLanguageProvider(DataGenerator gen, String locale) {
        super(gen, SteamTech.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + TAB_NAME, "Tutorial");
        add(MESSAGE_POWERGEN, "Power generator generating %s per tick!");
        add(MESSAGE_GENERATOR, "Generate ores from ingots!");
        add(SCREEN_TUTORIAL_POWERGEN, "Power generator");

        add(Registration.GENERATOR.get(), "Generator");
        add(Registration.POWERGEN.get(), "Power generator");

        add(Registration.TIN_ORE.get(), "Tin Ore");
        add(Registration.LEAD_ORE.get(), "Lead Ore");

        add(Registration.RAW_LEAD_CHUNK.get(), "Lead Raw Chunk");
        add(Registration.LEAD_INGOT.get(), "Lead Ingot");

        add(Registration.RAW_TIN_CHUNK.get(), "Tin Raw Chunk");
        add(Registration.TIN_INGOT.get(), "Tin Ingot");

        add(Registration.BRONZE_INGOT.get(), "Bronze Ingot");
        add(Registration.STEEL_INGOT.get(), "Steel Ingot");

        add(Registration.STEEL_PLATE.get(), "Steel Plate");
        add(Registration.BRONZE_PLATE.get(), "Bronze Plate");

    }
}
