package nl.garndesh.dockmaster.client.model;

import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.util.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nl.garndesh.dockmaster.client.render.IRenderer;
import nl.garndesh.dockmaster.util.MultiblockFormat;
import nl.garndesh.dockmaster.util.VectorConversion;
import org.lwjgl.util.vector.Vector3f;

/**
 * Created by cte20616 on 5-1-2016.
 */
public class ModelDistortedCube implements IRenderer {

    private TexturedQuad[] quadList = new TexturedQuad[6];

    private Vector3f[] corners = new Vector3f[]{
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

    private static byte[] triangles = new byte[]{
            0, 1, 2,
            0, 2, 3, //bottom face
            0, 3, 7,
            0, 7, 4, //front face
            0, 5, 1,
            0, 4, 5, //left face
            6, 5, 4,
            6, 4, 7, //top face
            6, 1, 3,
            6, 2, 1, //back face
            6, 7, 3,
            6, 3, 2  //left face
    };

    public ModelDistortedCube(MultiblockFormat neighbours) {
        updateCornerPositions(neighbours);
        updateQuadlist();
    }

    private void updateCornerPositions(MultiblockFormat neighbours) {
        for (BlockPos pos :
                neighbours.getKeyset()) {
            switch (pos.getX()) {
                case 1:
                    for (int i = 0; i < 4; i++) {
                        corners[quads[5 * 4 + i]].setX(1f); //right
                    }
                    break;
                case -1:
                    for (int i = 0; i < 4; i++) {
                        corners[quads[1 * 4 + i]].setX(-1f); //left
                    }
                    break;
            }
            switch (pos.getY()) {
                case 1:
                    for (int i = 0; i < 4; i++) {
                        corners[quads[3 * 4 + i]].setY(1f); //top
                    }
                    break;
                case -1:
                    for (int i = 0; i < 4; i++) {
                        corners[quads[0 * 4 + i]].setY(1f); //bottom
                    }
                    break;
            }
            switch (pos.getZ()) {
                case 1:
                    for (int i = 0; i < 4; i++) {
                        corners[quads[4 * 4 + i]].setZ(1f); //back
                    }
                    break;
                case -1:
                    for (int i = 0; i < 4; i++) {
                        corners[quads[2 * 4 + i]].setZ(-1f);
                    }
                    break;
            }
        }
    }

    public void updateQuadlist() {
        for (int i = 0; i < 6; i++) {
            this.quadList[i] = new TexturedQuad(fromQuadLocation(i));
        }
    }

    private PositionTextureVertex[] fromQuadLocation(int i) {
        PositionTextureVertex[] result = new PositionTextureVertex[4];
        result[0] = new PositionTextureVertex(VectorConversion.toVec3(corners[quads[i * 4 + 0]]), 0, 0);
        result[1] = new PositionTextureVertex(VectorConversion.toVec3(corners[quads[i * 4 + 1]]), 0, 8);
        result[2] = new PositionTextureVertex(VectorConversion.toVec3(corners[quads[i * 4 + 2]]), 8, 8);
        result[3] = new PositionTextureVertex(VectorConversion.toVec3(corners[quads[i * 4 + 3]]), 8, 0);
        return result;
    }

    @SideOnly(Side.CLIENT)
    public void render(WorldRenderer worldrenderer, float dt) {
        for (TexturedQuad q :
                quadList) {
            q.func_178765_a(worldrenderer, dt);
        }
    }
}

