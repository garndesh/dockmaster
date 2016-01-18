package nl.garndesh.dockmaster.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBoat;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import nl.garndesh.dockmaster.entity.EntityBoat;

/**
 * Created by cte20616 on 4-1-2016.
 */
public class BoatRender extends Render {

    private static final ResourceLocation boatTextures = new ResourceLocation("textures/entity/boat.png");
    protected ModelBase modelBoat = new ModelBoat();

    public BoatRender(RenderManager renderManager) {
        super(renderManager);
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float a, float partialTicks)
    {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y + 0.25F, (float)z);
        GlStateManager.rotate(180.0F - partialTicks, 0.0F, 1.0F, 0.0F);
        this.bindTexture(boatTextures);
        modelBoat.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        ((EntityBoat)entity).getModelBoat().render(entity, 0, 0, 0, 0, 0, 0);
        GlStateManager.popMatrix();
        super.doRender(entity,x, y, z, a, partialTicks);

    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return boatTextures;
    }
}
