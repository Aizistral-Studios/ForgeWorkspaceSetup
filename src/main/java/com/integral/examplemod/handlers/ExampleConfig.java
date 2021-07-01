package com.integral.examplemod.handlers;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ExampleConfig {
    private static final String GENERIC_CATEGORY = "Generic Config";

    public static int exampleInt = 512;
    public static boolean exampleBoolean = false;

    public static void load(FMLPreInitializationEvent event) {
        Configuration config = new Configuration(new File(event.getModConfigurationDirectory(), "ExampleMod.cfg"), "1.1", true);
        config.load();

        config.addCustomCategoryComment(GENERIC_CATEGORY, "Config for The Example Mod, created by Aizistral.");

        exampleInt = config.getInt("ExampleInt", GENERIC_CATEGORY, 512, Short.MIN_VALUE, Short.MAX_VALUE,
                "Example int property");

        exampleBoolean = config.getBoolean("ExampleBoolean", GENERIC_CATEGORY, false,
                "Example boolean property");

        config.save();
    }

}
