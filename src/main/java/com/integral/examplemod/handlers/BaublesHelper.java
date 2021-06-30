package com.integral.examplemod.handlers;

import baubles.api.BaublesApi;
import baubles.common.container.InventoryBaubles;
import baubles.common.lib.PlayerHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BaublesHelper {

    public static boolean hasEquipped(EntityPlayer player, Item bauble) {
        InventoryBaubles baubles = PlayerHandler.getPlayerBaubles(player);

        for (ItemStack stack : baubles.stackList) {
            if (stack != null && stack.getItem() == bauble)
                return true;
        }

        return false;
    }

}
