package com.jeffyjamzhd.mixin;

import com.jeffyjamzhd.MiTEPresenceFootsteps;
import eu.ha3.mc.haddon.implem.HaddonUtilityImpl;
import net.minecraft.*;
import net.xiaoyu233.fml.FishModLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Minecraft.class, priority = 10)
public class PFMinecraftMixin {
    @Shadow
    public long prevFrameTime;

    @Inject(method = "startGame", at = @At(value = "INVOKE", target = "Lnet/minecraft/Minecraft;refreshResources()V", ordinal = 0))
    private void pf$init(CallbackInfo ci) {
        PFHaddon addon = MiTEPresenceFootsteps.ADDON;

        // Init
        if (!addon.hasLoaded) {
            addon.setUtility(new HaddonUtilityImpl());
            addon.onLoad();
        }
    }

    @Inject(method = "startGame", at = @At("TAIL"))
    private void pf$postInit(CallbackInfo ci) {
        PFHaddon addon = MiTEPresenceFootsteps.ADDON;
        addon.reloadEverything(false);
    }

    @Inject(method = "runGameLoop", at = @At("TAIL"))
    private void pf$frame(CallbackInfo ci) {
        PFHaddon addon = MiTEPresenceFootsteps.ADDON;
        addon.onFrame(this.prevFrameTime);
    }

    @Inject(method = "runTick", at = @At("TAIL"))
    private void updateInput(CallbackInfo ci) {
    }
}
