package nl.garndesh.dockmaster;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import nl.garndesh.dockmaster.blocks.ModBlocks;
import nl.garndesh.dockmaster.entity.EntityBoat;
import nl.garndesh.dockmaster.items.ModItems;
import nl.garndesh.dockmaster.lib.Reference;
import nl.garndesh.dockmaster.proxy.IProxy;
import nl.garndesh.dockmaster.util.LogHelper;

/**
 *
 * Created by garndesh on 4-1-2016.
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER)
public class Dockmaster {

    @Mod.Instance(Reference.MOD_ID)
    public static Dockmaster instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {

    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){

        //load config file
        //config = new Configuration(event.getSuggestedConfigurationFile());

        //config.save();

        // set version number
        LogHelper.info("PreInit");
        event.getModMetadata().version = Reference.VERSION_NUMBER;
        ModBlocks.init();
        ModItems.init();

        EntityRegistry.registerModEntity(EntityBoat.class, "new boat", EntityRegistry.findGlobalUniqueEntityId(), this, 20, 3, true);
        LogHelper.info("PreInit done");
    }


    @Mod.EventHandler
    public void Init(FMLInitializationEvent event){
        proxy.registerRenderer();
        LogHelper.info("Init");
    }

    @Mod.EventHandler
    public void PostInit(FMLPostInitializationEvent event){

    }
}
