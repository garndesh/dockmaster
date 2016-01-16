package nl.garndesh.dockmaster.client.render;

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

    public BoatRender(RenderManager renderManager) {
        super(renderManager);
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float a, float b)
    {
        GlStateManager.pushMatrix();
        ((EntityBoat) entity).getModelBoat().render(entity, 0, 0, 0, 0, 0, 0);
        GlStateManager.popMatrix();
        super.doRender(entity,x, y, z, a, b);

    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return boatTextures;
    }
}
