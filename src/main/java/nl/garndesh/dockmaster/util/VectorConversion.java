package nl.garndesh.dockmaster.util;

import net.minecraft.util.Vec3;
import org.lwjgl.util.vector.Vector3f;

/**
 * Created by cte20616 on 15-1-2016.
 */
public class VectorConversion {

    public static Vec3 toVec3(Vector3f vector3f){
        return new Vec3(vector3f.getX(), vector3f.getY(), vector3f.getZ());
    }
}
