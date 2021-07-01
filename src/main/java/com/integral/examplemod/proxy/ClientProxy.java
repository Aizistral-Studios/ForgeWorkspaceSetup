package com.integral.examplemod.proxy;

import java.util.HashMap;
import java.util.UUID;

import net.minecraft.client.Minecraft;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {

    public ClientProxy() {
        super();
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));

        if (te == null)
            return null;

        return null;
    }

    @Override
    public void registerRenderers() {
        // NO-OP
    }

}
