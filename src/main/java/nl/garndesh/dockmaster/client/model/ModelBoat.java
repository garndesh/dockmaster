package nl.garndesh.dockmaster.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import nl.garndesh.dockmaster.client.render.IRenderer;
import nl.garndesh.dockmaster.entity.EntityBoat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by christiaan on 1/4/16.
 */
public class ModelBoat extends ModelBase {

    @Override
    public void render(Entity boat, float x, float y, float z, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
        ((EntityBoat)boat).getModelBoat().render(boat, x, y, z, p_78088_5_, p_78088_6_, p_78088_7_);

    }


}
