package com.integral.examplemod.proxy;

import java.util.HashMap;
import java.util.UUID;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityPortalFX;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {

    public ClientProxy() {
        super();
    }

    @Override
    public Object getClientGuiElement(final int ID, final EntityPlayer player, final World world, final int X, final int Y, final int Z) {
        final TileEntity te = world.getTileEntity(X, Y, Z);

        if (te == null)
            return null;

        return null;
    }

    @Override
    public void registerRenderers() {
        // NO-OP
    }

    @Override
    public EntityPlayer getPlayer(UUID playerID) {
        if (Minecraft.getMinecraft().theWorld != null) {
            for (Object object : Minecraft.getMinecraft().theWorld.playerEntities) {
                EntityPlayer player = (EntityPlayer) object;
                if (player.getUniqueID().equals(playerID))
                    return player;
            }
        }

        return null;
    }

}
