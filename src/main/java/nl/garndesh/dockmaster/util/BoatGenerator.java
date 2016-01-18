package nl.garndesh.dockmaster.util;

import nl.garndesh.dockmaster.blocks.BlockHull;
import nl.garndesh.dockmaster.client.model.ModelEntityBoat;

/**
 * Created by christiaan on 1/4/16.
 */
public class BoatGenerator {

    public static ModelEntityBoat generateModelFromMultiblockFormat(MultiblockFormat multiblockFormat) {
        ModelEntityBoat result = new ModelEntityBoat();

        multiblockFormat.getMultiBlock().forEach((blockPos, block) -> {
            if (block instanceof BlockHull) {
                result.addBlock(((BlockHull)block).getRendererFromMultiblock(multiblockFormat.getNeighbours(blockPos), blockPos) );
            }
        });

        return result;
    }


}
