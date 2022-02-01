package com.igentuman.steamtech;

import com.igentuman.steamtech.setup.ModSetup;
import com.igentuman.steamtech.setup.ClientSetup;
import com.igentuman.steamtech.setup.Registration;
import com.igentuman.steamtech.worldgen.ores.Ores;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(SteamTech.MODID)
public class SteamTech {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "steamtech";

    public SteamTech() {

        // Register the deferred registry
        ModSetup.setup();
        Registration.init();

        // Register the setup method for modloading
        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        modbus.addListener(ModSetup::init);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> modbus.addListener(ClientSetup::init));
    }
}
