package com.igentuman.steamtech.datagen;

import com.igentuman.steamtech.SteamTech;
import com.igentuman.steamtech.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class STItemTags extends ItemTagsProvider {

    public STItemTags(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper helper) {
        super(generator, blockTags, SteamTech.MODID, helper);
    }

    @Override
    protected void addTags() {
        tag(Tags.Items.ORES)
                .add(Registration.TIN_ORE_ITEM.get())
                .add(Registration.LEAD_ORE_ITEM.get());
        tag(Tags.Items.INGOTS)
                .add(Registration.TIN_INGOT.get())
                .add(Registration.LEAD_INGOT.get());
    }

    @Override
    public String getName() {
        return "Tutorial Tags";
    }
}
