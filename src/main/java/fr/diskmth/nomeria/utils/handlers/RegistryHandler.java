package fr.diskmth.nomeria.utils.handlers;

import fr.diskmth.nomeria.init.*;
import fr.diskmth.nomeria.utils.interfaces.IHasModel;
import fr.diskmth.nomeria.world.generation.WorldGenOres;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

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
        EntityInit.registerEntity();
    }

    public static void initRegistries()
    {
        RecipesInit.registerRecipes();
        GameRegistry.registerWorldGenerator(new WorldGenOres(), 0);
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }

    public static void postInitRegistries()
    {
        NetworkInit.registerNetwork();
    }
}