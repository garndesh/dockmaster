package nl.garndesh.dockmaster.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nl.garndesh.dockmaster.lib.Reference;

/**
 * Created by cte20616 on 15-1-2016.
 */
public class ItemBase extends Item {

    private String name;

    public ItemBase(String name, CreativeTabs tab){
        this.name = name;
        setCreativeTab(tab);
        setUnlocalizedName(Reference.MOD_ID + "_" + name);
        GameRegistry.registerItem(this, name);
    }

    public String getName() {
        return name;
    }
}
