package net.sintaxis.schematics.schematicapi.schematic.saver;

import net.sintaxis.schematics.schematicapi.schematic.SchematicData;
import org.jnbt.ByteArrayTag;
import org.jnbt.CompoundTag;
import org.jnbt.NBTOutputStream;
import org.jnbt.ShortTag;
import org.jnbt.StringTag;
import org.jnbt.Tag;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class SchematicSaver {

    public void saveSchematic(SchematicData schematicData, File destination) throws IOException {
        OutputStream outputStream = new FileOutputStream(destination);
        NBTOutputStream nbtOutputStream = new NBTOutputStream(outputStream);

        ShortTag width = new ShortTag("Width", schematicData.getWidth());
        ShortTag length = new ShortTag("Length", schematicData.getLength());
        ShortTag height = new ShortTag("Height", schematicData.getHeight());
        ByteArrayTag blocks = new ByteArrayTag("Blocks", schematicData.getBlocks());
        StringTag stringTag = new StringTag("Materials", "Alpha");

        Map<String, Tag> stringTagMap = new HashMap<>();
        stringTagMap.put("Width", width);
        stringTagMap.put("Length", length);
        stringTagMap.put("Height", height);
        stringTagMap.put("Blocks", blocks);
        stringTagMap.put("Materials", stringTag);

        CompoundTag compoundTag = new CompoundTag("Schematic", stringTagMap);
        nbtOutputStream.writeTag(compoundTag);
        nbtOutputStream.close();
        outputStream.close();
    }
}