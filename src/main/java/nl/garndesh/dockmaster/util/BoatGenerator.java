package nl.garndesh.dockmaster.util;

import net.minecraft.util.BlockPos;
import nl.garndesh.dockmaster.blocks.BlockHull;
import nl.garndesh.dockmaster.client.model.ModelBoat;

/**
 * Created by christiaan on 1/4/16.
 */
public class BoatGenerator {

    MultiblockFormat multiblockFormat;

    public ModelBoat generateModelFromMultiblockFormat(MultiblockFormat multiblockFormat) {
        this.multiblockFormat = multiblockFormat;
        ModelBoat result = new ModelBoat();

        int[] lowerBound = multiblockFormat.getLowerBound();
        int[] upperBound = multiblockFormat.getUpperBound();

        for (int x = lowerBound[0]; x <= upperBound[0]; x++) {
            for (int z = lowerBound[3]; z <= upperBound[3]; z++) {
                BlockPos pos = new BlockPos(x, lowerBound[2], z);
                if (multiblockFormat.blockAtPosIsInstanceOf(pos, BlockHull.class)) {
                    BlockHull block = (BlockHull) multiblockFormat.getBlockAtPos(pos);
                    block.getRendererFromMultiblock(multiblockFormat.getNeighbours(pos));
                    result.a
                    //return pos;
                }
            }
        }


        return null;
    }


}
