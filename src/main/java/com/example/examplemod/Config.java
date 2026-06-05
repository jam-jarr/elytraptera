package com.example.examplemod;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue LOG_DIRT_BLOCK = BUILDER
            .comment("Whether to log the dirt block on common setup")
            .define("logDirtBlock", true);

    public static final ModConfigSpec.IntValue MAGIC_NUMBER = BUILDER
            .comment("A magic number")
            .defineInRange("magicNumber", 42, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.ConfigValue<String> MAGIC_NUMBER_INTRODUCTION = BUILDER
            .comment("What you want the introduction message to be for the magic number")
            .define("magicNumberIntroduction", "The magic number is... ");

    // a list of strings that are treated as resource locations for items
    public static final ModConfigSpec.ConfigValue<List<? extends String>> ITEM_STRINGS = BUILDER
            .comment("A list of items to log on common setup.")
            .defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), () -> "", Config::validateItemName);

    // --- Flight configuration ---

    public static final ModConfigSpec.DoubleValue HORIZONTAL_SPEED = BUILDER
            .comment("Horizontal flight speed")
            .defineInRange("horizontalSpeed", 0.5, 0.0, 10.0);

    public static final ModConfigSpec.DoubleValue VERTICAL_SPEED = BUILDER
            .comment("Vertical flight speed")
            .defineInRange("verticalSpeed", 0.5, 0.0, 10.0);

    public static final ModConfigSpec.IntValue BASE_STAMINA = BUILDER
            .comment("Base stamina for flight")
            .defineInRange("baseStamina", 100, 1, 1000);

    public static final ModConfigSpec.DoubleValue FLY_STAMINA_DRAIN = BUILDER
            .comment("Stamina drained per tick while flying")
            .defineInRange("flyStaminaDrain", 1.0, 0.0, 100.0);

    public static final ModConfigSpec.DoubleValue HOVER_STAMINA_DRAIN = BUILDER
            .comment("Stamina drained per tick while hovering")
            .defineInRange("hoverStaminaDrain", 0.2, 0.0, 100.0);

    public static final ModConfigSpec.DoubleValue STAMINA_REGEN_RATE = BUILDER
            .comment("Stamina regained per tick while not flying")
            .defineInRange("staminaRegenRate", 0.5, 0.0, 100.0);

    public static final ModConfigSpec.DoubleValue HOVER_DESCENT_SPEED = BUILDER
            .comment("Vertical descent speed while hovering with shift held")
            .defineInRange("hoverDescentSpeed", 0.3, 0.0, 5.0);

    public static final ModConfigSpec.BooleanValue ALLOW_VANILLA_FLIGHT_SPRINT = BUILDER
            .comment("Allow vanilla elytra flight while sprinting")
            .define("allowVanillaFlightSprint", false);

    static final ModConfigSpec SPEC = BUILDER.build();

    private static boolean validateItemName(final Object obj) {
        return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(itemName));
    }
}
