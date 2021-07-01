package com.integral.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.integral.examplemod.handlers.ExampleConfig;
import com.integral.examplemod.handlers.GenericEventHandler;
import com.integral.examplemod.network.packets.ExamplePacket;
import com.integral.examplemod.proxy.CommonProxy;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION, name = ExampleMod.NAME)
public class ExampleMod {
    public static final String MODID = "examplemod";
    public static final String NAME = "The Example Mod";
    public static final String VERSION = "1.0.0";

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

        MinecraftForge.EVENT_BUS.register(new GenericEventHandler());
        NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
    }

    public static CreativeTabs tabExampleMod = new CreativeTabs("tabExampleMod") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(Items.BAKED_POTATO);
        }
    };
}
