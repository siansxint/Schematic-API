package net.sintaxis.schematics.schematicapi.schematic;

import org.jnbt.Tag;

import java.util.List;

public class SchematicData {

    private final short width;
    private final short length;
    private final short height;
    private final byte[] blocks;

    private final List<Tag> tileEntities;

    public SchematicData(short width, short length, short height, byte[] blocks, List<Tag> tileEntities) {
        this.blocks = blocks;
        this.width = width;
        this.length = length;
        this.height = height;
        this.tileEntities = tileEntities;
    }

    public short getWidth() {
        return this.width;
    }

    public short getLength() {
        return this.length;
    }

    public short getHeight() {
        return this.height;
    }

    public byte[] getBlocks() {
        return this.blocks;
    }

    public List<Tag> getTileEntities(){
        return tileEntities;
    }

}