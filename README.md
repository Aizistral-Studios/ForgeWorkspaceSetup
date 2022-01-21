# Forge Workspace Setup: Grimmix 1.7.10

Basic setup for Forge-based mod development workspace, but for mod that depends on Grimoire. Besides all advantages of standalone 1.7.10 setup, which you can familiarize yourself with [here](https://github.com/Aizistral-Studios/ForgeWorkspaceSetup#readme), this setup includes:

## Building Features:

- **Grimoire Shenanigans** plugin is added to buildscript. Does a lot of heavy lifting for ya, like specifying proper compile-time and runtime dependencies, making sure Mixin annotation processor will do its job when compiling, tweaking refmap generation, and some more. For more details - [pay that plugin's reporitory a personal visit](https://github.com/Aizistral-Studios/Grimoire-Shenanigans#readme);
- Custom refmap name specified in `gradle.properties`.

## Extended Example Mod:

- Includes simple implementation of grimmix controller;
- Uses `IConfigBuildingEvent` to generate its mixin configuration at runtime. Alongside demonstrates how wildcards can be used when specifying mixin classes, and how `@MIXIN_REFMAP@` token can be used, which is replaced with actual refmap name as specified in `gradle.properties` when building modfile;
- Contains a couple examples of core-targeting mixins;
- Uses `@AnnotationConfig` to create mod's config file.

## Short Setup Guide:

Same steps as for standalone version, which you can familiarize yourself with [here](https://github.com/Aizistral-Studios/ForgeWorkspaceSetup/tree/1.7.10-standalone#short-setup-guide).
