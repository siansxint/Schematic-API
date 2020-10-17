package net.sintaxis.schematics.schematicapi.schematic.saver;

import org.jnbt.CompoundTag;
import org.jnbt.NBTOutputStream;
import org.jnbt.Tag;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public class SchematicSaver {

    public void saveSchematic(String name, Map<String, Tag> stringTagMap) throws IOException {
        OutputStream outputStream = new FileOutputStream("");
        NBTOutputStream nbtOutputStream = new NBTOutputStream(outputStream);
        CompoundTag compoundTag = new CompoundTag(name, stringTagMap);
        nbtOutputStream.writeTag(compoundTag);
        nbtOutputStream.close();
    }
}
