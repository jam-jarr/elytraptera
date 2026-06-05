package com.example.examplemod;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import com.example.examplemod.network.FlightActionPayload;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Elytraptera.MODID)
public class Elytraptera {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "elytraptera";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(Registries.ENCHANTMENT, MODID);
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Registries.SOUND_EVENT, MODID);

    // TODO: Register enchantments with proper elytra item tag, costs, and max levels
    // public static final DeferredHolder<Enchantment, Enchantment> EXTENDED_FLIGHT = ENCHANTMENTS.register("extended_flight",
    //         () -> Enchantment.enchantment(Enchantment.definition(
    //                 ItemTags.CHEST_ARMOR_ENCHANTABLE, 10, 4,
    //                 Enchantment.constantCost(10),
    //                 Enchantment.constantCost(50)
    //         )).build());

    // public static final DeferredHolder<Enchantment, Enchantment> TAKEOFF = ENCHANTMENTS.register("takeoff", ...);
    // public static final DeferredHolder<Enchantment, Enchantment> RECOUPERATION = ENCHANTMENTS.register("recouperation", ...);

    // TODO: Register wing flap sound event (uncomment if FlightSoundSystem is implemented)
    // public static final DeferredHolder<SoundEvent, SoundEvent> WING_FLAP = SOUND_EVENTS.register("wing_flap",
    //         () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(MODID, "wing_flap")));

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public Elytraptera(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register flight system registries
        ENCHANTMENTS.register(modEventBus);
        SOUND_EVENTS.register(modEventBus);
        // Register network payload handlers
        modEventBus.addListener(this::registerPayloads);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (Elytraptera) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void registerPayloads(RegisterPayloadHandlersEvent event) {
        // TODO: Register FlightActionPayload for client-to-server communication
        // var registrar = event.registrar(MODID);
        // registrar.playToServer(FlightActionPayload.TYPE, FlightActionPayload.STREAM_CODEC,
        //         (payload, context) -> payload.handle(context));
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
}
