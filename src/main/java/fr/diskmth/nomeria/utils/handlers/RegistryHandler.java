package fr.diskmth.nomeria.utils.handlers;

import fr.diskmth.nomeria.init.BlocksInit;
import fr.diskmth.nomeria.init.CreativeTabsInit;
import fr.diskmth.nomeria.init.EntityInit;
import fr.diskmth.nomeria.init.ItemsInit;
import fr.diskmth.nomeria.init.RecipesInit;
import fr.diskmth.nomeria.init.RendersInit;
import fr.diskmth.nomeria.init.ToolMaterialsInit;
import fr.diskmth.nomeria.utils.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler
{

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(ItemsInit.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(BlocksInit.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event)
    {
        for(Item item : ItemsInit.ITEMS)
        {
            if(item instanceof IHasModel)
            {
                ((IHasModel)item).registerModels();
            }
        }

        for(Block block : BlocksInit.BLOCKS)
        {
            if(block instanceof IHasModel)
            {
                ((IHasModel)block).registerModels();
            }
        }
    }

    public static void preInitRegistries()
    {
        ToolMaterialsInit.registerToolMaterials();
        CreativeTabsInit.registerCreativetabs();
        RendersInit.registerEntityRenders();
        EntityInit.registerEntity();
        RendersInit.registerEntityRenders();
    }

    public static void initRegistries()
    {
        RecipesInit.registerRecipes();
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }

    public static void postInitRegistries()
    {

    }
}