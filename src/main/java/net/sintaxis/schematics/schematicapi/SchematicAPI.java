package net.sintaxis.schematics.schematicapi;

import net.sintaxis.schematics.schematicapi.schematic.SchematicData;
import net.sintaxis.schematics.schematicapi.schematic.parser.SchematicParser;
import net.sintaxis.schematics.schematicapi.schematic.paster.SchematicPaster;
import net.sintaxis.schematics.schematicapi.schematic.saver.SchematicSaver;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public final class SchematicAPI {

    public static void main(String[] args) throws IOException {
        SchematicData schematicData = new SchematicParser()
                .parseFileToSchematic(new File(""));

        SchematicPaster schematicPaster = new SchematicPaster();
        schematicPaster.paste(new Location(Bukkit.getWorld("Test"), 10, 10, 10), schematicData);

        SchematicSaver schematicSaver = new SchematicSaver();
        schematicSaver.saveSchematic("", new HashMap<>());
    }
}