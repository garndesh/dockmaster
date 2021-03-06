package nl.garndesh.dockmaster.util;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;

import java.util.*;

/**
 * Created by christiaan on 1/4/16.
 */
public class MultiblockFormat {

    private static final String NBT_BLOCKLIST_TAG = "blocklist";
    private Map<BlockPos, Block> multiBlock = new HashMap<>();

    private int[] lowerBound = new int[3], upperBound = new int[3];

    public void setBlock(BlockPos pos, Block block) {
        multiBlock.put(pos, block);
        updateBounds(pos);
    }

    public int[] getLowerBound() {
        return lowerBound;
    }

    public int[] getUpperBound() {
        return upperBound;
    }

    private void updateBounds(BlockPos pos) {
        if (pos.getX() < lowerBound[0]) {
            lowerBound[0] = pos.getX();
        }
        if (pos.getY() < lowerBound[1]) {
            lowerBound[1] = pos.getY();
        }
        if (pos.getZ() < lowerBound[2]) {
            lowerBound[2] = pos.getZ();
        }
        if (pos.getX() > upperBound[0]) {
            upperBound[0] = pos.getX();
        }
        if (pos.getY() > upperBound[1]) {
            upperBound[1] = pos.getY();
        }
        if (pos.getZ() > upperBound[2]) {
            upperBound[2] = pos.getZ();
        }
    }

    public MultiblockFormat getNeighbours(BlockPos pos){
        MultiblockFormat result = new MultiblockFormat();
        for(int x = -1; x<2; x++){
            for(int y = -1; y<2; y++){
                for(int z = -1; z<2; z++){
                    BlockPos currentPos = new BlockPos(pos.getX()+x, pos.getY()+y, pos.getZ()+z);
                    if(hasBlockAtPos(currentPos)){
                        result.setBlock(new BlockPos(x, y, z), multiBlock.get(currentPos));
                    }
                }
            }
        }
        return result;
    }

    public Set<BlockPos> getKeyset(){
        return multiBlock.keySet();
    }

    public Block getBlockAtPos(BlockPos pos){
        return multiBlock.get(pos);
    }

    public BlockPos getLowestPosition(String unlocalizedName) {
        for (int x = lowerBound[0]; x <= upperBound[0]; x++) {
            for (int z = lowerBound[3]; z <= upperBound[3]; z++) {
                BlockPos pos = new BlockPos(x, lowerBound[2], z);
                if (blockAtPosIsInstanceOf(pos, unlocalizedName)) {
                    return pos;
                }
            }
        }
        return null;
    }

    public Map<BlockPos, Block> getMultiBlock() {
        return multiBlock;
    }

    public boolean blockAtPosIsInstanceOf(BlockPos pos, String unlocalizedName) {
        if (hasBlockAtPos(pos)) {
            return multiBlock.get(pos).getUnlocalizedName().equalsIgnoreCase(unlocalizedName);
        }

        return false;
    }
    
    public void writeMultiblockToNBT(NBTTagCompound tag){
        int count = 0;
        multiBlock.forEach((blockPos, block) -> {
            NBTTagCompound newTag = new NBTTagCompound();
            newTag.setInteger("x", blockPos.getX());
            newTag.setInteger("y", blockPos.getY());
            newTag.setInteger("z", blockPos.getZ());
            newTag.setString("block",block.getUnlocalizedName());
            tag.setTag(NBT_BLOCKLIST_TAG+count, newTag);
        });
    }
    
    public void readMultiblockFromNBT(NBTTagCompound tag){
        tag.getKeySet().forEach(name -> {
            NBTTagCompound entry = tag.getCompoundTag((String)name);
            BlockPos pos = new BlockPos(
                    entry.getInteger("x"),
                    entry.getInteger("y"),
                    entry.getInteger("z")
            );
            Block b = Block.getBlockFromName(entry.getString("block"));
            multiBlock.put(pos, b);
        });
    }

    public boolean hasBlockAtPos(BlockPos pos) {
        return multiBlock.containsKey(pos);
    }

}
