package com.integral.examplemod.proxy;

import java.util.HashMap;
import java.util.UUID;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CommonProxy implements IGuiHandler {

    public CommonProxy() {
        // NO-OP
    }

    @Override
    public Object getServerGuiElement(final int ID, final EntityPlayer player, final World world, final int X, final int Y, final int Z) {
        final TileEntity te = world.getTileEntity(X, Y, Z);

        if (te == null)
            return null;

        return null;

    }

    @Override
    public Object getClientGuiElement(final int ID, final EntityPlayer player, final World world, final int X,
            final int Y, final int Z) {
        return null;
    }

    public void registerRenderers() {
        // NO-OP
    }

    public EntityPlayer getPlayer(UUID playerID) {
        if (MinecraftServer.getServer() != null) {
            for (Object object : MinecraftServer.getServer().getConfigurationManager().playerEntityList) {
                EntityPlayerMP player = (EntityPlayerMP) object;
                if (player.getUniqueID().equals(playerID))
                    return player;
            }
        }

        return null;
    }

}
