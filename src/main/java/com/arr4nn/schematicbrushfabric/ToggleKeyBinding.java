package com.arr4nn.schematicbrushfabric;

import net.minecraft.client.option.KeyBinding;

public class ToggleKeyBinding extends KeyBinding {
    private boolean toggled = false;

    public ToggleKeyBinding(String name, int code, String category) {
        super(name, code, category);
    }

    public void toggle() {
        toggled = true;
    }

    public boolean isToggled() {
        boolean state = toggled;
        toggled = false;
        return state;
    }
}
