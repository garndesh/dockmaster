package nl.garndesh.dockmaster.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/**
 * Created by cte20616 on 4-1-2016.
 */
public class EntityBoat extends Entity {

    private int length;
    private int width;
    private int height;

    public EntityBoat(World world) {
        this(world, 3, 1, 1);
    }

    public EntityBoat(World world, int length, int width, int height){
        super(world);
        this.height = height;
        this.width = width;
        this.length = length;
    }

    @Override
    protected void entityInit() {

    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound tagCompund) {
        int[] size = tagCompund.getIntArray("size");
        height = size[0];
        width = size[1];
        length = size[3];
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound tagCompound) {
        tagCompound.setIntArray("size", new int[] {height, width, length});
    }

    /**
     * First layer of player interaction
     */
    public boolean interactFirst(EntityPlayer playerIn)
    {
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != playerIn)
        {
            return true;
        }
        else
        {
            if (!this.worldObj.isRemote)
            {
                playerIn.mountEntity(this);
            }

            return true;
        }
    }
}
