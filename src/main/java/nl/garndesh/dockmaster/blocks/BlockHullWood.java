package nl.garndesh.dockmaster.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import nl.garndesh.dockmaster.client.model.ModelDistortedCube;
import nl.garndesh.dockmaster.client.render.IRenderer;
import nl.garndesh.dockmaster.util.MultiblockFormat;

/**
 * Created by cte20616 on 16-1-2016.
 */
public class BlockHullWood extends BlockHull {

    public BlockHullWood() {
        super("name", Material.wood);
    }

    @Override
    public IRenderer getRendererFromMultiblock(MultiblockFormat multiblockFormat, BlockPos pos) {
        return new ModelDistortedCube(multiblockFormat, pos);
    }
}
