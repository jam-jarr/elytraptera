package com.example.examplemod.flight;

import com.example.examplemod.attachment.PlayerFlightData;
import net.minecraft.world.entity.player.Player;

public final class FlightController {

    private FlightController() {}

    public static void tickFlight(Player player) {
        if (player.level().isClientSide) return;

        FlightState state = PlayerFlightData.getFlightState(player);

        switch (state) {
            case IDLE -> tickIdle(player);
            case FLYING -> tickFlying(player);
            case HOVERING -> tickHovering(player);
        }
    }

    private static void tickIdle(Player player) {
        // TODO: Check if player is midair with space held → startFlight(player)
        // TODO: Regen stamina
    }

    private static void tickFlying(Player player) {
        // TODO: Drain stamina per tick
        // TODO: Check enchantments for modifiers (takeoff bonus)
        // TODO: If stamina depleted → stopFlight(player)
        // TODO: Apply durability damage to elytra item
    }

    private static void tickHovering(Player player) {
        // TODO: Drain stamina at reduced rate
        // TODO: If stamina depleted → stopFlight(player)
        // TODO: If shift held → apply slow descent
        // TODO: If space pressed → switch to FLYING
    }

    public static void startFlight(Player player) {
        // TODO: Set flight state to FLYING
        // TODO: Set fall-flying flag on player
        // TODO: Initialize takeoff timer from enchantment
    }

    public static void startHover(Player player) {
        // TODO: Set flight state to HOVERING
        // TODO: Clear fall-flying flag
        // TODO: Zero out motion
    }

    public static void stopFlight(Player player) {
        // TODO: Set flight state to IDLE
        // TODO: Clear fall-flying flag
    }

    public static void handleAction(Player player, FlightAction action) {
        // TODO: Handle incoming action from client packet
    }

    public enum FlightAction {
        START_FLIGHT,
        STOP_FLIGHT,
        START_HOVER,
        STOP_HOVER,
        APPLY_THRUST
    }
}
