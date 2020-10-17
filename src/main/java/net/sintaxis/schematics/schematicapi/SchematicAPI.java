package net.sintaxis.schematics.schematicapi;

import net.sintaxis.schematics.schematicapi.schematic.SchematicData;
import net.sintaxis.schematics.schematicapi.schematic.parser.SchematicParser;
import net.sintaxis.schematics.schematicapi.schematic.paster.SchematicPaster;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.io.File;
import java.io.IOException;

public final class SchematicAPI {

    public static void main(String[] args) throws IOException {
        SchematicData schematicData = new SchematicParser()
                .parseFileToSchematic(new File(""));

        SchematicPaster schematicPaster = new SchematicPaster();
        schematicPaster.paste(new Location(Bukkit.getWorld("Test"), 10, 10, 10), schematicData);
    }
}