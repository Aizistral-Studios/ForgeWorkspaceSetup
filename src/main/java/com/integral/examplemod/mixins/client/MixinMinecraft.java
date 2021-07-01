package com.integral.examplemod.mixins.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.integral.examplemod.ExampleMod;

import net.minecraft.client.Minecraft;

@Mixin(Minecraft.class)
public class MixinMinecraft {

    @Inject(method = "init", at = @At("HEAD"), cancellable = true, remap = true)
    private void onGameStart(CallbackInfo info) {
        new RuntimeException("Hello from stack!").fillInStackTrace().printStackTrace();
    }

}