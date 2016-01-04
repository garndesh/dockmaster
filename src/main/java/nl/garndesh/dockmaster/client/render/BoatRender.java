package nl.garndesh.dockmaster.client.render;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.util.ResourceLocation;

/**
 * Created by cte20616 on 4-1-2016.
 */
public class BoatRender extends Render {

    private static final ResourceLocation boatTextures = new ResourceLocation("textures/entity/boat.png");

    protected BoatRender(RenderManager renderManager) {
        super(renderManager);
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float p_180552_8_, float p_180552_9_)
    {

    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return boatTextures;
    }
}
