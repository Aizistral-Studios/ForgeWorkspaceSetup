package com.integral.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.integral.examplemod.handlers.ExampleConfig;
import com.integral.examplemod.handlers.GenericEventHandler;
import com.integral.examplemod.network.packets.ExamplePacket;
import com.integral.examplemod.proxy.CommonProxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION, name = ExampleMod.NAME)
public class ExampleMod {
    public static final String MODID = "examplemod";
    public static final String NAME = "The Example Mod";
    public static final String VERSION = "@VERSION@";

    public static SimpleNetworkWrapper packetHandler;

    @SidedProxy(clientSide = "com.integral.examplemod.proxy.ClientProxy", serverSide = "com.integral.examplemod.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static final Logger logger = LogManager.getLogger("ExampleMod");
    public static final int howCoolAmI = Integer.MAX_VALUE;

    @EventHandler
    public void load(FMLInitializationEvent event) {
        proxy.registerRenderers();
    }

    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        // NO-OP
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ExampleConfig.load(event);

        packetHandler = NetworkRegistry.INSTANCE.newSimpleChannel("ExampleModChannel");
        packetHandler.registerMessage(ExamplePacket.Handler.class, ExamplePacket.class, 1, Side.CLIENT);

        GenericEventHandler handler = new GenericEventHandler();
        MinecraftForge.EVENT_BUS.register(handler);
        FMLCommonHandler.instance().bus().register(handler);

        NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
    }


    public static CreativeTabs tabExampleMod = new CreativeTabs("tabExampleMod") {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return Items.baked_potato;
        }
    };
}
