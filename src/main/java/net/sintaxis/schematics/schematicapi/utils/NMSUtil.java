package net.sintaxis.schematics.schematicapi.utils;

import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.IBlockData;
import net.minecraft.server.v1_8_R3.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;

public class NMSUtil {

    public static void setBlockFast(Block block, int blockId, byte data) {
        World nmsWorld = ((CraftWorld) block.getWorld()).getHandle();
        BlockPosition bp = new BlockPosition(block.getLocation().getX(), block.getLocation().getY(), block.getLocation().getZ());
        IBlockData ibd = net.minecraft.server.v1_8_R3.Block.getByCombinedId(blockId + (data << 12));
        nmsWorld.setTypeAndData(bp, ibd, 2);
    }
}