# Forge Workspace Setup: Standalone 1.7.10

Basic setup for Forge-based mod development workspace. Essentially serves as ennobled version of last official setup provided by Forge itself (can be found [here](https://maven.minecraftforge.net/net/minecraftforge/forge/1.7.10-10.13.4.1614-1.7.10/forge-1.7.10-10.13.4.1614-1.7.10-src.zip)), which is no longer working in default configuration because of breaking changes in Forge repositories that happened over six years passed since it was released. To fix those issues and to expand upon the concept, this setup has an amount of important differences:

## Fixes:

- Custom ForgeGradle fork is used ([this one](https://github.com/juanmuscaria/ForgeGradle)). Ensures compatibility with Gradle 5.+, fixes some repository references and does a couple obscure manipulations with `.classpath` file for Eclipse projects to ensure they won't break again;
- Custom maven repository is used for locating all basic dependencies ([this one](https://github.com/juanmuscaria/maven)). Since Forge guys keep making breaking changes on their side without caring about old Minecraft versions, this is a much more reliable option than trying to chase their ever-shifting repos;
- Buildscript now enforces Java 8 compliance and UTF-8 encoding for all files.

## Building Features:

- Gradle wrapper 5.6.4 is used by default;
- Buildscript contains tasks for generating `dev` and `sources` artifacts for your mod, as well as ensures they will be generated alongside main jar when executing `gradlew build`;
- All data in `mcmod.info` file is filled when actually building a mod. This illustrates both how to inflate text files upon building and how to use `gradle.properties` file for declaring custom properties used by `build.gradle`;
- Illustration of how to add another mod to project dependencies, in a form of local file.

## Ennobled Example Mod:

- Creates basic logger for itself;
- Provides an example of registering custom `SimpleNetworkWrapper`, as well as an example packet sent from server to every player upon logging in. Shows a chat message to that player upon being received, just as demonstration that packet have performed its journey successfully;
- Has one method that interacts with Baubles - `BaublesHelper#hasEquipped`. Just to demonstrate that our example of local modfile dependency, which is Baubles modfile in this case, actually works;
- Mod version in the code (`ExampleMod.VERSION`) is defined as token string, which is replaced by actual project version when building;
- Has `CommonProxy`/`ClientProxy` thing, which also serves as an example of `IGuiHandler` implementation;
- Contains uncomplicated event handler with a single receiver for `EntityJoinWorldEvent`;
- Illustrates how to create a config file using Forge's `Configuration`;
- Creates custom creative tab.


## Short Setup Guide:

If you ended up here, I assume you are already familiar with how to setup basic Forge workspace, so I won't be covering it all in great detail. Only the most important steps, just in case you forgot something:

1. Ensure you have JDK 8 installed (not just JRE), and `JAVA_HOME` environment variable is set in your system, pointing to that JDK;
2. Download this repository contents ([like this](https://github.com/Aizistral-Studios/ForgeWorkspaceSetup/archive/refs/heads/1.7.10-standalone.zip), for instance), create folder for your mod-specific workspace and unpack those contents into that folder;
3. Open up a command line in that folder, and execure `gradlew setupDecompWorkspace`. Once its done, run IDE-specific command to generate project for your IDE; either `gradlew eclipse` or `gradlew idea`;
4. In case you use Eclipse, don't forget that you need to open your workspace by choosing `eclipse` folder within your mod-specific folder as workspace location. In case you use Idea... I dunno, you know better what to do;
5. Use `gradlew build` whenever you need to build a `.jar` with your mod. It will end up being in `build/libs` directory within your mod-specific workspace folder.

**Important note on repository setup:** Setup on this repository contains `eclipse` and `.settings` folders, which are important for setting up an Eclipse project, but you generally shouldn't commit them when you set up a repository for actual mod. For that purpose, it is unrecommended to use this repository as actual template via GitHub; you should instead copy its contents manually, so that `.gitignore` takes effect and doesn't let you commit these alongside all other stuff. Alternatively, after creating a repository using this one as template you should make a commit that removes these folders. Once pushed - put them back, thanks to `.gitignore` they won't be recognized any longer.
