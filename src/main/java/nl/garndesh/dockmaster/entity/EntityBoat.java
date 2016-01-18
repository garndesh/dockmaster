package nl.garndesh.dockmaster.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import nl.garndesh.dockmaster.client.model.ModelEntityBoat;
import nl.garndesh.dockmaster.util.BoatGenerator;
import nl.garndesh.dockmaster.util.MultiblockFormat;

/**
 * Created by cte20616 on 4-1-2016.
 */
public class EntityBoat extends Entity {

    private static final String NBT_MULTIBLOCK_TAG = "multiblock";
    private ModelEntityBoat modelBoat;
    private MultiblockFormat multiblock;

    public EntityBoat(World world){
        this(world, new MultiblockFormat());
    }

    public EntityBoat(World world, MultiblockFormat multiblock){
        super(world);
        this.multiblock = multiblock;
        modelBoat = BoatGenerator.generateModelFromMultiblockFormat(multiblock);
    }

    @Override
    protected void entityInit() {
        System.out.printf("entity init");
    }

    @Override
    public void setDead(){
        super.setDead();
        System.out.println("boat is dead");
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound tagCompund) {
        NBTTagCompound multiData = tagCompund.getCompoundTag(NBT_MULTIBLOCK_TAG);
        this.multiblock = new MultiblockFormat();
        this.multiblock.readMultiblockFromNBT(multiData);
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound tagCompound) {
        NBTTagCompound newTag = new NBTTagCompound();
        multiblock.writeMultiblockToNBT(newTag);
        tagCompound.setTag(NBT_MULTIBLOCK_TAG, newTag);
    }

    public ModelEntityBoat getModelBoat() {
        return modelBoat;
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
