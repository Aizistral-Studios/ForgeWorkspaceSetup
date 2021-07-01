package com.integral.examplemod.handlers;

import java.io.File;

import io.github.crucible.omniconfig.api.annotation.AnnotationConfig;
import io.github.crucible.omniconfig.api.annotation.properties.ConfigBoolean;
import io.github.crucible.omniconfig.api.annotation.properties.ConfigInt;
import io.github.crucible.omniconfig.api.utils.Observer;
import net.minecraftforge.common.config.Configuration;

@AnnotationConfig(reloadable = true)
public class ExampleConfig {

    @ConfigInt(comment = "Example integer property.", min = -100, max = 1000)
    public static int exampleInteger = 100;

    @ConfigBoolean(comment = "Another example, boolean property.")
    public static boolean exampleBoolean = true;

}