package com.arr4nn.schematicbrushfabric;

import com.arr4nn.schematicbrushfabric.config.ModConfigs;
import net.fabricmc.api.ModInitializer;

public class SchematicBrushFabric implements ModInitializer {

    public static final String MOD_ID = "schematic-brush-reborn-mod";

    @Override
    public void onInitialize() {
        ModConfigs.registerConfigs();
    }
}
