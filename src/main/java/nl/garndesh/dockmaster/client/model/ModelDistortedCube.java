package nl.garndesh.dockmaster.client.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.TexturedQuad;
import nl.garndesh.dockmaster.util.MultiblockFormat;
import org.lwjgl.util.vector.Vector3f;

/**
 * Created by cte20616 on 5-1-2016.
 */
public class ModelDistortedCube {

    private TexturedQuad[] quadList = new TexturedQuad[5];

    private Vector3f[] corners = new Vector3f[] {
            new Vector3f(-0.5f, -0.5f, -0.5f),
            new Vector3f(-0.5f, -0.5f, 0.5f),
            new Vector3f(0.5f, -0.5f, 0.5f),
            new Vector3f(0.5f, -0.5f, -0.5f),
            new Vector3f(-0.5f, 0.5f, -0.5f),
            new Vector3f(-0.5f, 0.5f, 0.5f),
            new Vector3f(0.5f, 0.5f, 0.5f),
            new Vector3f(0.5f, 0.5f, -0.5f)
    };

    private static byte[] quads = new byte[]{
            0, 3, 2, 1, //bottom
            0, 1, 5, 4, //left
            0, 4, 7, 3, //front
            6, 7, 4, 5, //top
            6, 2, 1, 5, //back
            6, 7, 3, 2  //right
    };

    private static byte[] triangles = new byte[] {
            0,1,2,
            0,2,3, //bottom face
            0,3,7,
            0,7,4, //front face
            0,5,1,
            0,4,5, //left face
            6,5,4,
            6,4,7, //top face
            6,1,3,
            6,2,1, //back face
            6,7,3,
            6,3,2  //left face
    };

    public ModelDistortedCube(ModelRenderer modelRenderer, MultiblockFormat neighbours){

    }

    public void updateQuadlist(){
        for(int i = 0; i<6; i++){
            this.quadList[i] = new TexturedQuad()
        }
    }

    public void render(float deltaTime){

    }
}
