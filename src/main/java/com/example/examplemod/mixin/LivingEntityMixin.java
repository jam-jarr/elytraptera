package com.example.examplemod.mixin;

import com.example.examplemod.attachment.PlayerFlightData;
import com.example.examplemod.flight.FlightPhysics;
import com.example.examplemod.flight.FlightState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "travel", at = @At("HEAD"), cancellable = true)
    private void elytraptera$onTravel(Vec3 travelVector, CallbackInfo ci) {
        if (!((Object) this instanceof Player player)) return;

        FlightState state = PlayerFlightData.getFlightState(player);

        if (state == FlightState.FLYING) {
            // TODO: Replace vanilla elytra physics with custom flight physics
            FlightPhysics.applyFlightPhysics(player);
            ci.cancel();
        } else if (state == FlightState.HOVERING) {
            // TODO: Override with hover physics (zero motion, no gravity)
            FlightPhysics.applyHoverPhysics(player);
            ci.cancel();
        }
    }
}
