package net.sintaxis.schematics.schematicapi.schematic.parser;

import net.sintaxis.schematics.schematicapi.schematic.SchematicData;
import net.sintaxis.schematics.schematicapi.utils.ChildTagUtil;
import org.jnbt.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SchematicParser {

    public SchematicData parseFileToSchematic(File file) throws IOException {
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

        ListTag tileEntitiesTag = ChildTagUtil.getChildTag(schematic,"TileEntities",ListTag.class);
        List<Tag> titleEntities = tileEntitiesTag.getValue();

        return new SchematicData(width, length, height, blocks,titleEntities);
    }
}