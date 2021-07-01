package com.integral.examplemod.handlers;

import baubles.api.BaublesApi;
import baubles.api.IBauble;
import baubles.api.cap.BaublesCapabilities;
import baubles.api.cap.IBaublesItemHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;

public class BaublesHelper {

    public static boolean hasEquipped(EntityPlayer player, Item bauble) {
        IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player);

        for(int i = 0; i < baubles.getSlots(); ++i) {
            ItemStack stack = baubles.getStackInSlot(i);
            if (stack != null && stack.getItem() == bauble)
                return true;
        }

        return false;
    }

}
