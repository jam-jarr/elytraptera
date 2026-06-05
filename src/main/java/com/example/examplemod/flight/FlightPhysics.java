package com.example.examplemod.flight;

import net.minecraft.world.entity.player.Player;

public final class FlightPhysics {

    private FlightPhysics() {}

    public static void applyFlightPhysics(Player player) {
        // TODO: Read config values for horizontal/vertical speed
        // TODO: Calculate thrust direction from player look vector
        // TODO: Apply upward thrust when space is held
        // TODO: Maintain horizontal momentum with drag
        // TODO: Apply takeoff enchantment multiplier during first N ticks
        // TODO: Set final delta movement on player
    }

    public static void applyHoverPhysics(Player player) {
        // TODO: Zero out player motion (no gravity, no drag)
        // TODO: If shift held, apply small downward velocity
        // TODO: Maintain absolute position (perfect still hover)
    }
}
