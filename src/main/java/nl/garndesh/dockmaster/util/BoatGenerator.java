package nl.garndesh.dockmaster.util;

import net.minecraft.util.BlockPos;
import nl.garndesh.dockmaster.blocks.BlockHull;
import nl.garndesh.dockmaster.client.model.ModelBoat;

/**
 * Created by christiaan on 1/4/16.
 */
public class BoatGenerator {

    public static ModelBoat generateModelFromMultiblockFormat(MultiblockFormat multiblockFormat) {
        ModelBoat result = new ModelBoat();

        int[] lowerBound = multiblockFormat.getLowerBound();
        int[] upperBound = multiblockFormat.getUpperBound();

        for (int x = lowerBound[0]; x <= upperBound[0]; x++) {
            for (int z = lowerBound[2]; z <= upperBound[2]; z++) {
                BlockPos pos = new BlockPos(x, lowerBound[1], z);
                if (multiblockFormat.blockAtPosIsInstanceOf(pos, BlockHull.class)) {
                    BlockHull block = (BlockHull) multiblockFormat.getBlockAtPos(pos);
                    result.addBlock(block.getRendererFromMultiblock(multiblockFormat.getNeighbours(pos)) );
                    //return pos;
                }
            }
        }


        return result;
    }


}
