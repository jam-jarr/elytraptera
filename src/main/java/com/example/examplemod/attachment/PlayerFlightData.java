package com.example.examplemod.attachment;

import com.example.examplemod.flight.FlightState;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SyncedDataHolder;
import net.minecraft.world.entity.player.Player;

public class PlayerFlightData {

    public static final EntityDataAccessor<Integer> STAMINA =
            SyncedDataHolder.defineId(Player.class, EntityDataSerializers.INT);

    public static final EntityDataAccessor<Integer> MAX_STAMINA =
            SyncedDataHolder.defineId(Player.class, EntityDataSerializers.INT);

    public static final EntityDataAccessor<Byte> FLIGHT_STATE =
            SyncedDataHolder.defineId(Player.class, EntityDataSerializers.BYTE);

    public static int getStamina(Player player) {
        return player.getEntityData().get(STAMINA);
    }

    public static void setStamina(Player player, int value) {
        player.getEntityData().set(STAMINA, value);
    }

    public static int getMaxStamina(Player player) {
        return player.getEntityData().get(MAX_STAMINA);
    }

    public static void setMaxStamina(Player player, int value) {
        player.getEntityData().set(MAX_STAMINA, value);
    }

    public static FlightState getFlightState(Player player) {
        return FlightState.values()[player.getEntityData().get(FLIGHT_STATE)];
    }

    public static void setFlightState(Player player, FlightState state) {
        player.getEntityData().set(FLIGHT_STATE, (byte) state.ordinal());
    }

    public static boolean isFlying(Player player) {
        return getFlightState(player) != FlightState.IDLE;
    }
}
