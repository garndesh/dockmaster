package nl.garndesh.dockmaster.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by christiaan on 1/4/16.
 */
public class ModelBoat extends ModelBase {

    private List<ModelRenderer> blocks = new ArrayList<>();

    public ModelBoat() {
    }

    public void addBlock(ModelRenderer block) {
        blocks.add(block);
    }


}
