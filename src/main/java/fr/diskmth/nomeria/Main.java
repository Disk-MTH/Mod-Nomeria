package fr.diskmth.nomeria;

import fr.diskmth.nomeria.utils.References;
import fr.diskmth.nomeria.utils.handlers.RegistryHandler;
import fr.diskmth.nomeria.utils.proxy.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION)
public class Main
{
    @Instance
    public static Main instance;

    @SidedProxy(clientSide = References.CLIENT, serverSide = References.COMMON)
    public static CommonProxy proxy;

    public static Logger logger;

    static
    {
        FluidRegistry.enableUniversalBucket();
    }

    @EventHandler
    public static void preInit(FMLPreInitializationEvent e) throws Exception
    {
        if(e.getSide().isClient())
        {
            if(!Minecraft.getMinecraft().mcDataDir.getPath().contains(".Nomeria"))
            {
                throw(new Exception("Mauvais launcher détecté, veuillez passé par le launcher officiel de Noméria"));
            }
        }
        
        logger = e.getModLog();
        proxy.preInit();
        proxy.init();
        RegistryHandler.preInitRegistries();
    }

    @EventHandler
    public static void init(FMLInitializationEvent e)
    {
        RegistryHandler.initRegistries();
    }

    @EventHandler
    public static void postInit(FMLPostInitializationEvent e)
    {
        RegistryHandler.postInitRegistries();
    }
}