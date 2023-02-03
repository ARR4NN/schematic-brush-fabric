package com.arr4nn.schematicbrushfabric.event;

import com.arr4nn.schematicbrushfabric.config.ModConfigs;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

import java.util.Objects;

public class KeyInputHandler {
    public static final String KEY_CATEGORY = "key.category.schematicbrushreborn.schematic";
    public static final String KEY_SCHEMATIC_NEXT = "key.schematicbrushreborn.schematic.next";
    public static final String KEY_SCHEMATIC_PREVIOUS = "key.schematicbrushreborn.schematic.previous";


    public static final String KEY_SCHEMATIC_SELECTION_LOCKED_ORDERED = "key.schematicbrushreborn.schematic.selection.locked_ordered";
    public static final String KEY_SCHEMATIC_SELECTION_LOCKED_RANDOM = "key.schematicbrushreborn.schematic.selection.locked_random";
    public static final String KEY_SCHEMATIC_SELECTION_ORDERED = "key.schematicbrushreborn.schematic.selection.ordered";
    public static final String KEY_SCHEMATIC_SELECTION_RANDOM = "key.schematicbrushreborn.schematic.selection.random";

    public static KeyBinding schematicNextKey,schematicPrevKey,schematicSelectionLockedOrdered,schematicSelectionLockedRandom,schematicSelectionOrdered,schematicSelectionRandom;

    private static void sendCommand(MinecraftClient client, String command){
        Objects.requireNonNull(client.getNetworkHandler()).sendCommand(command);
    }

    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {

            if (schematicNextKey.wasPressed()) sendCommand(client,ModConfigs.COMMAND_SCHEMATIC_NEXT);
            if (schematicPrevKey.wasPressed()) sendCommand(client,ModConfigs.COMMAND_SCHEMATIC_PREVIOUS);

            if (schematicSelectionLockedOrdered.wasPressed()) sendCommand(client, ModConfigs.COMMAND_SCHEMATIC_SELECTION_LOCKED_ORDERED);
            if (schematicSelectionLockedRandom.wasPressed()) sendCommand(client,ModConfigs.COMMAND_SCHEMATIC_SELECTION_LOCKED_RANDOM);
            if (schematicSelectionOrdered.wasPressed()) sendCommand(client,ModConfigs.COMMAND_SCHEMATIC_SELECTION_ORDERED);
            if (schematicSelectionRandom.wasPressed()) sendCommand(client,ModConfigs.COMMAND_SCHEMATIC_SELECTION_RANDOM);
        });
    }

        public static void register(){
        schematicNextKey =  KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_SCHEMATIC_NEXT,
                GLFW.GLFW_KEY_I,
                KEY_CATEGORY
        ));
        schematicPrevKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_SCHEMATIC_PREVIOUS,
                GLFW.GLFW_KEY_U,
                KEY_CATEGORY
        ));


        schematicSelectionLockedOrdered = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_SCHEMATIC_SELECTION_LOCKED_ORDERED,
                GLFW.GLFW_KEY_F7,
                KEY_CATEGORY
        ));
        schematicSelectionLockedRandom = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_SCHEMATIC_SELECTION_LOCKED_RANDOM,
                GLFW.GLFW_KEY_F8,
                KEY_CATEGORY
        ));
        schematicSelectionOrdered = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_SCHEMATIC_SELECTION_ORDERED,
                GLFW.GLFW_KEY_F9,
                KEY_CATEGORY
        ));
        schematicSelectionRandom = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_SCHEMATIC_SELECTION_RANDOM,
                GLFW.GLFW_KEY_F10,
                KEY_CATEGORY
        ));




            registerKeyInputs();
    }

}
