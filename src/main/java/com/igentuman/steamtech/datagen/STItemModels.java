package com.igentuman.steamtech.datagen;

import com.igentuman.steamtech.SteamTech;
import com.igentuman.steamtech.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class STItemModels extends ItemModelProvider {

    public STItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, SteamTech.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(Registration.TIN_ORE_ITEM.get().getRegistryName().getPath(), modLoc("block/tin_ore"));
        withExistingParent(Registration.LEAD_ORE_ITEM.get().getRegistryName().getPath(), modLoc("block/lead_ore"));

        withExistingParent(Registration.GENERATOR_ITEM.get().getRegistryName().getPath(), modLoc("block/generator"));
        withExistingParent(Registration.POWERGEN_ITEM.get().getRegistryName().getPath(), modLoc("block/powergen/main"));

        singleTexture(Registration.RAW_TIN_CHUNK.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/raw_tin_chunk"));

        singleTexture(Registration.TIN_INGOT.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/tin_ingot"));

        singleTexture(Registration.BRONZE_INGOT.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/bronze_ingot"));

        singleTexture(Registration.STEEL_INGOT.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/steel_ingot"));

        singleTexture(Registration.BRONZE_PLATE.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/bronze_plate"));

        singleTexture(Registration.STEEL_PLATE.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/steel_plate"));

        singleTexture(Registration.RAW_LEAD_CHUNK.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/raw_lead_chunk"));

        singleTexture(Registration.LEAD_INGOT.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/lead_ingot"));
    }
}
