package nl.garndesh.dockmaster.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nl.garndesh.dockmaster.client.render.IRenderer;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cte20616 on 18-1-2016.
 */
public class ModelEntityBoat extends ModelBase {

    private List<IRenderer> blocks = new ArrayList<>();
    private int displayList = 0;
    private boolean compiled = false;

    public void addBlock(IRenderer block){
        this.blocks.add(block);
        this.compiled = false;
    }

    @Override
    public void render(Entity boat, float x, float y, float z, float p_78088_5_, float p_78088_6_, float deltaTime) {
        if(!compiled){
            compileDisplayList(deltaTime);
        }
        GlStateManager.callList(displayList);

    }


    @SideOnly(Side.CLIENT)
    private void compileDisplayList(float deltaTime)
    {
        if(displayList == 0) this.displayList = GLAllocation.generateDisplayLists(1);
        GL11.glNewList(this.displayList, GL11.GL_COMPILE);
        WorldRenderer worldrenderer = Tessellator.getInstance().getWorldRenderer();

        blocks.forEach(iRenderer -> iRenderer.render(worldrenderer, deltaTime));

        GL11.glEndList();
        this.compiled = true;
    }

}
