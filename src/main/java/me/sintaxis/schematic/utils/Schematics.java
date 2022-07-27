package me.sintaxis.schematic.utils;

import me.sintaxis.schematic.Schematic;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.jnbt.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public interface Schematics {

    static void parseAndPaste(Location location, File file) throws IOException {
        paste(location, parseFileToSchematic(file));
    }

    static void paste(Location location, Schematic schematic) {
        short length = schematic.getLength();
        short width = schematic.getWidth();
        short height = schematic.getHeight();
        location.subtract(width / 2.00, height / 2.00, length / 2.00);
        byte[] blocks = schematic.getBlocks();
        byte[] blockData = schematic.getData();
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                for (int z = 0; z < length; ++z) {
                    int index = y * width * length + z * width + x;
                    Block block = new Location(location.getWorld(), x + location.getX(), y + location.getY(), z + location.getZ()).getBlock();
                    NMSUtil.setBlockFast(block, blocks[index], blockData[index]);
                }
            }
        }
    }

    static Schematic parseFileToSchematic(File file) throws IOException {
        FileInputStream stream = new FileInputStream(file);
        NBTInputStream nbtStream = new NBTInputStream(stream);
        CompoundTag schematicTag = (CompoundTag) nbtStream.readTag();
        stream.close();
        nbtStream.close();
        Map<String, Tag> schematic = schematicTag.getValue();
        short width = ChildTagUtil.getChildTag(schematic, "Width", ShortTag.class).getValue();
        short length = ChildTagUtil.getChildTag(schematic, "Length", ShortTag.class).getValue();
        short height = ChildTagUtil.getChildTag(schematic, "Height", ShortTag.class).getValue();
        String materials = ChildTagUtil.getChildTag(schematic, "Materials", StringTag.class).getValue();
        if (!materials.equals("Alpha")) {
            throw new IllegalArgumentException("Schematic file is not an Alpha schematic");
        }
        byte[] blocks = ChildTagUtil.getChildTag(schematic, "Blocks", ByteArrayTag.class).getValue();
        byte[] blockData = ChildTagUtil.getChildTag(schematic, "Data", ByteArrayTag.class).getValue();
        return new Schematic(width, length, height, blocks, blockData);
    }
}