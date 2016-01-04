package nl.garndesh.dockmaster.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nl.garndesh.dockmaster.lib.Reference;

/**
 * Created by cte20616 on 4-1-2016.
 */
public class BlockBase extends Block {

    private String name;

    protected BlockBase(String name, Material material, CreativeTabs creativeTabs) {
        super(material);
        this.name = name;
        setUnlocalizedName(Reference.MOD_ID + "_" + name);
        setCreativeTab(creativeTabs);
        GameRegistry.registerBlock(this, name);
    }


    public String getName() {
        return name;
    }

}
