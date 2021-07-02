package com.integral.examplemod.mixins.baubles;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import baubles.common.event.EventHandlerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;

@Mixin(value = EventHandlerEntity.class, remap = false)
public class MixinEventHandlerEntity {

    @Inject(method = "playerDeath", at = @At("HEAD"), cancellable = true, remap = false)
    private void onPlayerDeath(PlayerDropsEvent event, CallbackInfo info) {
        if (!event.getEntityPlayer().world.isRemote) {
            if (DamageSource.CACTUS.damageType.equals(event.getSource().damageType)) {
                event.getEntityPlayer().sendStatusMessage(new TextComponentString(
                        "I see you died from hugging cactus... I'll save your baubles this time."), false);
                info.cancel();
            }
        }
    }

}
