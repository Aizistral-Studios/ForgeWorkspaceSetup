# Forge Workspace Setup: Grimmix 1.12.2

Basic setup for Forge-based mod development workspace, but for mod that depends on Grimoire. Besides all advantages of standalone 1.12.2 setup, which you can familiarize yourself with [here](https://github.com/CrucibleMC/ForgeWorkspaceSetup#readme), this setup includes:

## Building Features:

- **MixinGradle** plugin is added to buildscript. Mostly just takes care of handling refmap generation and embedding. Check out [its repository](https://github.com/SpongePowered/MixinGradle) to know more;
- **Grimoire Shenanigans** plugin is added to buildscript. Does some amount of heavy lifting for ya, like specifying proper compile-time and runtime dependencies. For more details - [pay that plugin's reporitory a personal visit](https://github.com/CrucibleMC/Grimoire-Shenanigans#readme);
- Custom refmap name specified in `gradle.properties`.

## Extended Example Mod:

- Includes simple implementation of grimmix controller;
- Uses `IConfigBuildingEvent` to generate its mixin configurations at runtime. Alongside demonstrates how wildcards can be used when specifying mixin classes, and how `@MIXIN_REFMAP@` token can be used, which is replaced with actual refmap name as specified in `gradle.properties` when building modfile;
- Contains an example of both core- and mod-targeting mixins;
- Uses `@AnnotationConfig` to create mod's config file.

## Short Setup Guide:

Same steps as for standalone version, which you can familirize yourself with [here](https://github.com/CrucibleMC/ForgeWorkspaceSetup/tree/1.12.2-standalone#short-setup-guide).