package nl.garndesh.dockmaster.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import nl.garndesh.dockmaster.lib.Names;

/**
 * Created by cte20616 on 4-1-2016.
 */
public class BlockDock extends BlockBase {

    protected BlockDock() {
        super(Names.BLOCK_DOCK, Material.wood, CreativeTabs.tabBlock);
    }


}
