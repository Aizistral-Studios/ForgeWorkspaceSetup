package com.integral.examplemod;

import io.github.crucible.grimoire.common.api.grimmix.Grimmix;
import io.github.crucible.grimoire.common.api.grimmix.GrimmixController;
import io.github.crucible.grimoire.common.api.grimmix.lifecycle.IConfigBuildingEvent;
import io.github.crucible.grimoire.common.api.mixin.ConfigurationType;

@Grimmix(id = "examplegrimmix", name = "The Example Grimmix")
public class ExampleGrimmix extends GrimmixController {

    @Override
    public void buildMixinConfigs(IConfigBuildingEvent event) {
        event.createBuilder("examplemod/mixins.examplemod.json")
        .mixinPackage("com.integral.examplemod.mixins.core")
        .commonMixins("common.*")
        .clientMixins("client.*")
        .refmap("@MIXIN_REFMAP@")
        .verbose(true)
        .required(true)
        .build();

        event.createBuilder("examplemod/mixins.baubles.json")
        .mixinPackage("com.integral.examplemod.mixins.baubles")
        .configurationType(ConfigurationType.MOD)
        .commonMixins("*")
        .refmap("@MIXIN_REFMAP@")
        .verbose(true)
        .required(false)
        .build();
    }

}