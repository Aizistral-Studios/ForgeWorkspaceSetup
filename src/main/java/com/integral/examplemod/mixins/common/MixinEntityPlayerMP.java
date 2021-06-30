package com.integral.examplemod.mixins.common;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;

@Mixin(EntityPlayerMP.class)
public class MixinEntityPlayerMP {

    @Shadow(remap = true)
    private int lastExperience;

    @Inject(method = "setItemInUse", at = @At("HEAD"), cancellable = true, remap = true)
    private void onItemClick(ItemStack stack, int maxUseDuration, CallbackInfo info) {
        EntityPlayerMP player = (EntityPlayerMP)(Object)this;

        if (stack != null && stack.getItem() != null) {
            player.addChatMessage(new ChatComponentText("I see that you used some item..."));
            player.addChatMessage(new ChatComponentText("Your item class is: " + stack.getItem().getClass()));
        }
    }

}
