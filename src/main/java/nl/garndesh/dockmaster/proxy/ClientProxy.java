package nl.garndesh.dockmaster.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import nl.garndesh.dockmaster.blocks.ModBlocks;
import nl.garndesh.dockmaster.client.render.BoatRender;
import nl.garndesh.dockmaster.entity.EntityBoat;
import nl.garndesh.dockmaster.lib.Reference;
import nl.garndesh.dockmaster.util.LogHelper;

/**
 * Created by cte20616 on 4-1-2016.
 */
public class ClientProxy implements IProxy {

    @Override
    public void registerRenderer() {

        LogHelper.info("Registering renderers");
        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

        //blocks
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(ModBlocks.dock), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ModBlocks.dock.getName(), "inventory"));

        RenderingRegistry.registerEntityRenderingHandler(EntityBoat.class, new BoatRender(Minecraft.getMinecraft().getRenderManager()));

    }
}
