package com.igentuman.steamtech.datagen;

import com.igentuman.steamtech.SteamTech;
import com.igentuman.steamtech.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class STBlockTags extends BlockTagsProvider {

    public STBlockTags(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, SteamTech.MODID, helper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Registration.GENERATOR.get())
                .add(Registration.POWERGEN.get())
                .add(Registration.TIN_ORE.get())
                .add(Registration.LEAD_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(Registration.GENERATOR.get())
                .add(Registration.POWERGEN.get());

        tag(Tags.Blocks.ORES)
                .add(Registration.TIN_ORE.get())
                .add(Registration.LEAD_ORE.get());
    }

    @Override
    public String getName() {
        return "SteamTech Tags";
    }
}
