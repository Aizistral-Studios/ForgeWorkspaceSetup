# Forge Workspace Setup: Standalone 1.12.2

Basic setup for Forge-based mod development workspace. Essentially serves as ennobled version of last official setup provided by Forge itself (can be found [here](https://maven.minecraftforge.net/net/minecraftforge/forge/1.12.2-14.23.5.2855/forge-1.12.2-14.23.5.2855-mdk.zip)). Has a couple features that original setup does not:

## Building Features:

- Gradle wrapper 5.6.4 is used by default;
- Enforced UTF-8 encoding for all files;
- Buildscript contains tasks for generating `dev` and `sources` artifacts for your mod, as well as ensures they will be generated alongside main jar when executing `gradlew build`;
- All data in `mcmod.info` file is filled when actually building a mod. This illustrates both how to inflate text files upon building and how to use `gradle.properties` file for declaring custom properties used by `build.gradle`;
- Illustration of how to add another mod to project dependencies, in a form of local file.

## Ennobled Example Mod:

- Creates basic logger for itself;
- Provides an example of registering custom `SimpleNetworkWrapper`, as well as an example packet sent from server to every player upon logging in. Shows a chat message to that player upon being received, just as demonstration that packet have performed its journey successfully;
- Has one method that interacts with Baubles - `BaublesHelper#hasEquipped`. Just to demonstrate that our example of local modfile dependency, which is Baubles modfile in this case, actually works;
- Has `CommonProxy`/`ClientProxy` thing, which also serves as an example of `IGuiHandler` implementation;
- Contains uncomplicated event handler with a couple event receivers;
- Illustrates how to create a config file using Forge's `Configuration`;
- Creates custom creative tab.


## Short Setup Guide:

If you ended up here, I assume you are already familiar with how to setup basic Forge workspace, so I won't be covering it all in great detail. Only the most important steps, just in case you forgot something:

1. Ensure you have JDK 8 installed (not just JRE), and `JAVA_HOME` environment variable is set in your system, pointing to that JDK;
2. Download this repository contents ([like this](https://github.com/CrucibleMC/ForgeWorkspaceSetup/archive/refs/heads/1.12.2-standalone.zip), for instance), create folder for your mod-specific workspace and unpack those contents into that folder;
3. Open up a command line in that folder, and execute IDE-specific command to generate project for your IDE; either `gradlew eclipse` or `gradlew idea`. Once done, execute command to generate IDE runs for that project - either `gradlew genEclipseRuns` or `genIntellijRuns`;
4. In case you use Eclipse, edit generated `runClient.launch` and `runServer.launch` files, replacing `${MC_VERSION}` token with `1.12.2`. No idea why ForgeGradle leaves it unreplaced, but it has to be in order for your IDE to correctly execute these runs;
5. Use `gradlew build` whenever you need to build a `.jar` with your mod. It will end up being in `build/libs` directory within your mod-specific workspace folder.

**Important note on repository setup:** Setup on this repository contains `.settings` folder, which is important for setting up an Eclipse project, but you generally shouldn't commit it when you set up a repository for actual mod. For that purpose, it is unrecommended to use this repository as actual template via GitHub; you should instead copy its contents manually, so that `.gitignore` takes effect and doesn't let you commit that folder alongside all other stuff. Alternatively, after creating a repository using this one as template you should make a commit that removes these folders. Once pushed - re-add them back, thanks to `.gitignore` they won't be recognized any longer.
