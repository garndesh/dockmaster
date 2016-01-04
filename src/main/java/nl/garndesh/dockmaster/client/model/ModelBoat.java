package nl.garndesh.dockmaster.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by christiaan on 1/4/16.
 */
public class ModelBoat extends ModelBase {

    private List<ModelRenderer> panes = new ArrayList<>();

    public ModelBoat() {
    }

    public void addPane(ModelRenderer pane) {
        panes.add(pane);
    }


}
