package com.example.examplemod.network;

import com.example.examplemod.Elytraptera;
import com.example.examplemod.flight.FlightController;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

public record FlightActionPayload(FlightController.FlightAction action) implements CustomPacketPayload {

    public static final CustomPacketPayload.Type<FlightActionPayload> TYPE =
            new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(Elytraptera.MODID, "flight_action"));

    public static final StreamCodec<ByteBuf, FlightActionPayload> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.VAR_INT.map(
                            ordinal -> FlightController.FlightAction.values()[ordinal],
                            FlightController.FlightAction::ordinal
                    ),
                    FlightActionPayload::action,
                    FlightActionPayload::new
            );

    @Override
    @NotNull
    public CustomPacketPayload.Type<FlightActionPayload> type() {
        return TYPE;
    }

    public void handle(IPayloadContext context) {
        // TODO: Process action on server thread
    }
}
