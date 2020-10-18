package net.sintaxis.schematics.schematicapi.schematic.paster;

import net.sintaxis.schematics.schematicapi.schematic.SchematicData;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class SchematicPaster {

    public void paste(Location location, SchematicData schematicData) {
        short length = schematicData.getLength();
        short width = schematicData.getWidth();
        short height = schematicData.getHeight();
        location.subtract(width / 2.00, height / 2.00, length / 2.00);
        byte[] blocks = schematicData.getBlocks();
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                for (int z = 0; z < length; ++z) {
                    int index = y * width * length + z * width + x;
                    Location blockLocation = new Location(location.getWorld(), x + location.getX(), y + location.getY(), z + location.getZ());
                    int b = blocks[index] & 0xFF;
                    Block block = blockLocation.getBlock();
                    Material material = Material.getMaterial(b);
                    block.setType(material);
                }
            }
        }
    }
}