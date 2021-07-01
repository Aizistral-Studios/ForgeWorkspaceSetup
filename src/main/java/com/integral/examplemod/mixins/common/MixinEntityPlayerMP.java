package com.integral.examplemod.mixins.common;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;

@Mixin(EntityPlayerMP.class)
public class MixinEntityPlayerMP {

    @Shadow(remap = true)
    private float lastHealth;

    @Inject(method = "swingArm", at = @At("HEAD"), cancellable = true, remap = true)
    private void onItemClick(EnumHand hand, CallbackInfo info) {
        EntityPlayerMP player = (EntityPlayerMP)(Object)this;
        ItemStack stack = player.getHeldItemMainhand();

        if (stack != null && stack.getItem() != null) {
            player.sendStatusMessage(new TextComponentString("I see that you swinged your arm..."), false);
            player.sendStatusMessage(new TextComponentString("Your held item class is: " + stack.getItem().getClass()), false);
        }
    }

}