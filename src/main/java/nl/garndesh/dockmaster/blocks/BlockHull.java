package nl.garndesh.dockmaster.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.creativetab.CreativeTabs;
import nl.garndesh.dockmaster.util.MultiblockFormat;

/**
 * Created by christiaan on 1/4/16.
 */
public abstract class BlockHull extends BlockBase {

    protected BlockHull() {
        super("tmp", Material.anvil, CreativeTabs.tabBlock);
    }

    public abstract ModelRenderer getRendererFromMultiblock(MultiblockFormat multiblockFormat);
}
