package com.integral.examplemod.handlers;

import java.util.Random;

import com.integral.examplemod.ExampleMod;
import com.integral.examplemod.network.packets.ExamplePacket;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class GenericEventHandler {
    private int messageCountdown = 10;

    @SubscribeEvent
    public void onEntityJoinWorld(PlayerEvent.PlayerLoggedInEvent event) {
        Entity entity = event.player;

        if (!entity.world.isRemote && entity instanceof EntityPlayerMP) {
            System.out.println("Entity joined world: " + entity);
        }
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.player instanceof EntityPlayerMP && this.messageCountdown != 0) {
            this.messageCountdown--;

            if (this.messageCountdown == 0) {
                ExampleMod.packetHandler.sendTo(new ExamplePacket(), (EntityPlayerMP)event.player);
            }
        }
    }

}
