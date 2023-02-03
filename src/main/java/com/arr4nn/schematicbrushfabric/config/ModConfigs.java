package com.arr4nn.schematicbrushfabric.config;

import com.mojang.datafixers.util.Pair;
import com.arr4nn.schematicbrushfabric.SchematicBrushFabric;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static String COMMAND_SCHEMATIC_NEXT;
    public static String COMMAND_SCHEMATIC_PREVIOUS;
    public static String COMMAND_SCHEMATIC_SELECTION_LOCKED_ORDERED;
    public static String COMMAND_SCHEMATIC_SELECTION_LOCKED_RANDOM;
    public static String COMMAND_SCHEMATIC_SELECTION_ORDERED;
    public static String COMMAND_SCHEMATIC_SELECTION_RANDOM;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(SchematicBrushFabric.MOD_ID + "_config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("commands.next", "sbrm next"), "Command issued for next schematic");
        configs.addKeyValuePair(new Pair<>("commands.previous", "sbrm previous"), "Command issued for previous schematic");

        configs.addKeyValuePair(new Pair<>("commands.selection.locked_ordered", "sbrm selection locked_ordered"), "Command issued for locked ordered");
        configs.addKeyValuePair(new Pair<>("commands.selection.locked_random", "sbrm selection locked_random"), "Command issued for locked random");
        configs.addKeyValuePair(new Pair<>("commands.selection.ordered", "sbrm selection ordered"), "Command issued for ordered");
        configs.addKeyValuePair(new Pair<>("commands.selection.random", "sbrm selection random"), "Command issued for random");
    }

    private static void assignConfigs() {
        COMMAND_SCHEMATIC_NEXT = CONFIG.getOrDefault("commands.next.value", "sbrm next");
        COMMAND_SCHEMATIC_PREVIOUS = CONFIG.getOrDefault("commands.previous.value", "sbrm previous");

        COMMAND_SCHEMATIC_SELECTION_LOCKED_ORDERED = CONFIG.getOrDefault("commands.selection.locked_ordered", "sbrm selection locked_ordered");
        COMMAND_SCHEMATIC_SELECTION_LOCKED_RANDOM = CONFIG.getOrDefault("commands.selection.locked_random", "sbrm selection locked_random");
        COMMAND_SCHEMATIC_SELECTION_ORDERED = CONFIG.getOrDefault("commands.selection.ordered", "sbrm selection ordered");
        COMMAND_SCHEMATIC_SELECTION_RANDOM = CONFIG.getOrDefault("commands.selection.random", "sbrm selection random");

        System.out.println("All " + configs.getConfigsList().size() + " config properties have been set properly.");
    }
}
