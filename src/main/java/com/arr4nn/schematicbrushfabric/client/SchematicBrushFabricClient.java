package com.arr4nn.schematicbrushfabric.client;

import com.arr4nn.schematicbrushfabric.event.KeyInputHandler;
import net.fabricmc.api.ClientModInitializer;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class SchematicBrushFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
    }
}
