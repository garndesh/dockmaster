package nl.garndesh.dockmaster.util;

import net.minecraft.util.BlockPos;
import nl.garndesh.dockmaster.blocks.BlockHull;
import nl.garndesh.dockmaster.blocks.ModBlocks;
import nl.garndesh.dockmaster.client.model.ModelBoat;
import nl.garndesh.dockmaster.client.model.ModelEntityBoat;

/**
 * Created by christiaan on 1/4/16.
 */
public class BoatGenerator {

    public static ModelEntityBoat generateModelFromMultiblockFormat(MultiblockFormat multiblockFormat) {
        ModelEntityBoat result = new ModelEntityBoat();

        int[] lowerBound = multiblockFormat.getLowerBound();
        int[] upperBound = multiblockFormat.getUpperBound();

        multiblockFormat.getMultiBlock().forEach((blockPos, block) -> {
            if (block instanceof BlockHull) {
                result.addBlock(((BlockHull)block).getRendererFromMultiblock(multiblockFormat.getNeighbours(blockPos), blockPos) );
            }
        });

        return result;
    }


}
