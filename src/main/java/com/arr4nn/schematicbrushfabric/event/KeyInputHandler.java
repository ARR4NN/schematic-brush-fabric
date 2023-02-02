package com.arr4nn.schematicbrushfabric.event;

import com.arr4nn.schematicbrushfabric.ToggleKeyBinding;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import org.lwjgl.glfw.GLFW;

import java.util.Objects;

public class KeyInputHandler {
    public static final String KEY_CATEGORY = "key.category.schematicbrushreborn.schematic";
    public static final String KEY_SCHEMATIC_NEXT = "key.schematicbrushreborn.schematic.next";
    public static final String KEY_SCHEMATIC_PREVIOUS = "key.schematicbrushreborn.schematic.previous";
    public static final String KEY_SCHEMATIC_LOCK = "key.schematicbrushreborn.schematic.lock";

    public static ToggleKeyBinding schematicNextKey,schematicPrevKey,schematicLockKey;

    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {

            if(schematicNextKey.isToggled()) return;
            if(schematicPrevKey.isToggled()) return;
            if(schematicLockKey.isToggled()) return;


            if (schematicNextKey.wasPressed()) {
                schematicNextKey.toggle();
                Objects.requireNonNull(client.getNetworkHandler()).sendCommand("sbr schematic next");
            }
            if (schematicPrevKey.wasPressed()) {
                schematicPrevKey.toggle();
                Objects.requireNonNull(client.getNetworkHandler()).sendCommand("sbr schematic previous");
            }
            if (schematicLockKey.wasPressed()) {
                schematicLockKey.toggle();
                Objects.requireNonNull(client.getNetworkHandler()).sendCommand("sbr schematic lock");
                assert client.player != null;
                client.player.playSound(SoundEvents.BLOCK_NOTE_BLOCK_PLING.value(), SoundCategory.AMBIENT,1f,2f);
            }
        });
    }

        public static void register(){
        schematicNextKey = (ToggleKeyBinding) KeyBindingHelper.registerKeyBinding(new ToggleKeyBinding(
                KEY_SCHEMATIC_NEXT,
                GLFW.GLFW_KEY_I,
                KEY_CATEGORY
        ));

        schematicPrevKey = (ToggleKeyBinding) KeyBindingHelper.registerKeyBinding(new ToggleKeyBinding(
                KEY_SCHEMATIC_PREVIOUS,
                GLFW.GLFW_KEY_U,
                KEY_CATEGORY
        ));
        schematicLockKey = (ToggleKeyBinding) KeyBindingHelper.registerKeyBinding(new ToggleKeyBinding(
                KEY_SCHEMATIC_LOCK,
                GLFW.GLFW_KEY_J,
                KEY_CATEGORY
        ));



        registerKeyInputs();
    }

}
