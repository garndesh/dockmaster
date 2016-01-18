package nl.garndesh.dockmaster.items;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import nl.garndesh.dockmaster.blocks.BlockHull;
import nl.garndesh.dockmaster.entity.EntityBoat;
import nl.garndesh.dockmaster.util.MultiblockFormat;

/**
 * Created by cte20616 on 15-1-2016.
 */
public class ItemTest extends ItemBase {

    public ItemTest() {
        super("test", CreativeTabs.tabTools);
    }


    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player){

        if(!world.isRemote) {
            MultiblockFormat multiblock = new MultiblockFormat();
            for (int x = -10; x < 10; x++) {
                for (int y = -10; y < 10; y++) {
                    for (int z = -10; z < 10; z++) {
                        BlockPos pos = new BlockPos(player.posX + x, player.posY + y, player.posZ + z);
                        Block b = world.getChunkFromBlockCoords(pos).getBlock(pos);
                        //System.out.println("checking block pos " + pos.toString());
                        if (b instanceof BlockHull) {
                            //System.out.println("adding block " + ((BlockHull) b).getName());
                            multiblock.setBlock(new BlockPos(x, y, z), b);
                        }
                    }
                }
            }
            System.out.printf("multiblock size: " + multiblock.getLowerBound()[0] + " " +multiblock.getUpperBound()[0]);
            EntityBoat boat = new EntityBoat(world, multiblock);
            boat.setPosition(player.posX + 10, player.posY, player.posZ);
            world.spawnEntityInWorld(boat);
        }
        return itemStack;
    }

}
