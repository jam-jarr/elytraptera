package com.example.examplemod.mixin.client;

import com.example.examplemod.attachment.PlayerFlightData;
import com.example.examplemod.flight.FlightController;
import com.example.examplemod.flight.FlightState;
import net.minecraft.client.player.Input;
import net.minecraft.client.player.LocalPlayer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class)
@OnlyIn(Dist.CLIENT)
public class LocalPlayerMixin {

    @Shadow
    public Input input;

    @Unique
    private boolean elytraptera$wasSpaceHeld;

    @Unique
    private boolean elytraptera$wasShiftHeld;

    @Inject(method = "aiStep", at = @At("HEAD"))
    private void elytraptera$onAiStep(CallbackInfo ci) {
        LocalPlayer player = (LocalPlayer) (Object) this;
        boolean spaceHeld = input.jumping;
        boolean shiftHeld = input.shiftKeyDown;

        FlightState state = PlayerFlightData.getFlightState(player);

        // TODO: Detect flight activation — space pressed while midair and not on ground
        // TODO: Detect hover toggle — shift held while in FLYING state
        // TODO: Send FlightActionPayload packets to server

        elytraptera$wasSpaceHeld = spaceHeld;
        elytraptera$wasShiftHeld = shiftHeld;
    }
}
