package com.arr4nn.schematicbrushfabric.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY = "key.category.schematicbrushreborn.schematic";
    public static final String KEY_SCHEMATIC_NEXT = "key.schematicbrushreborn.schematic.next";
    public static final String KEY_SCHEMATIC_PREVIOUS = "key.schematicbrushreborn.schematic.previous";

    public static KeyBinding schematicNextKey;
    public static KeyBinding schematicPrevKey;

    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(schematicNextKey.wasPressed()){
                // This happens when next key is pressed.
                client.player.sendMessage(Text.of("next key is pressed"));
            }
            if(schematicPrevKey.wasPressed()){
                // This happens when previous key is pressed.
                client.player.sendMessage(Text.of("previous key is pressed"));

            }
        });
    }

    public static void register(){
        schematicNextKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_SCHEMATIC_NEXT,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_U,
                KEY_CATEGORY
        ));

        schematicPrevKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_SCHEMATIC_PREVIOUS,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_I,
                KEY_CATEGORY
        ));

        registerKeyInputs();
    }

}
