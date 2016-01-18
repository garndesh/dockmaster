package nl.garndesh.dockmaster.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockPos;
import nl.garndesh.dockmaster.client.render.IRenderer;
import nl.garndesh.dockmaster.util.MultiblockFormat;

/**
 * Created by christiaan on 1/4/16.
 */
public abstract class BlockHull extends BlockBase {

    public BlockHull(String name, Material material) {
        super(name, material, CreativeTabs.tabBlock);
    }

    public abstract IRenderer getRendererFromMultiblock(MultiblockFormat multiblockFormat, BlockPos pos);
}
