package com.example.examplemod.mixin;

import com.example.examplemod.attachment.PlayerFlightData;
import com.example.examplemod.flight.FlightController;
import net.minecraft.network.syncher.SyncedDataHolder;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public class PlayerMixin {

    @Inject(method = "defineSynchedData", at = @At("TAIL"))
    private void elytraptera$onDefineSynchedData(SyncedDataHolder.Builder builder, CallbackInfo ci) {
        builder.define(PlayerFlightData.STAMINA, 100);
        builder.define(PlayerFlightData.MAX_STAMINA, 100);
        builder.define(PlayerFlightData.FLIGHT_STATE, (byte) 0);
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void elytraptera$onTick(CallbackInfo ci) {
        FlightController.tickFlight((Player) (Object) this);
    }
}
