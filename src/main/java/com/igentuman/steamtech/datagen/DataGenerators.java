package com.igentuman.steamtech.datagen;

import com.igentuman.steamtech.SteamTech;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = SteamTech.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        if (event.includeServer()) {
            generator.addProvider(new STRecipes(generator));
            generator.addProvider(new STLootTables(generator));
            STBlockTags blockTags = new STBlockTags(generator, event.getExistingFileHelper());
            generator.addProvider(blockTags);
            generator.addProvider(new STItemTags(generator, blockTags, event.getExistingFileHelper()));
        }
        if (event.includeClient()) {
            generator.addProvider(new STBlockStates(generator, event.getExistingFileHelper()));
            generator.addProvider(new STItemModels(generator, event.getExistingFileHelper()));
            generator.addProvider(new STEngLanguageProvider(generator, "en_us"));
        }
    }
}
