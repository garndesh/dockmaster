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

    private List<IRenderer> blocks = new ArrayList<>();

    public ModelBoat() {
    }

    @Override
    public void render(Entity boat_, float x, float y, float z, float p_78088_5_, float p_78088_6_, float p_78088_7_) {

    }


    public void addBlock(IRenderer block) {
        blocks.add(block);
    }


}
