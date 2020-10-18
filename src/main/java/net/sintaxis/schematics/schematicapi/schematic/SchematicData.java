package net.sintaxis.schematics.schematicapi.schematic;

public class SchematicData {

    private final short width;
    private final short length;
    private final short height;
    private final byte[] blocks;

    public SchematicData(short width, short length, short height, byte[] blocks) {
        this.blocks = blocks;
        this.width = width;
        this.length = length;
        this.height = height;
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
}