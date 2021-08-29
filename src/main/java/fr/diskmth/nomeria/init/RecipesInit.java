package fr.diskmth.nomeria.init;

import java.util.Random;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipesInit
{
    public static void registerRecipes()
    {
        GameRegistry.addSmelting(BlocksInit.TOPAZE_ORE, new ItemStack(ItemsInit.TOPAZE, 1), 5.0F);
        GameRegistry.addSmelting(BlocksInit.AZURITE_ORE, new ItemStack(ItemsInit.AZURITE, 1), 10.0F);
        GameRegistry.addSmelting(BlocksInit.MERCURE_ORE, new ItemStack(ItemsInit.MERCURE, 1), 15.0F);
        GameRegistry.addSmelting(BlocksInit.RANDOM_ORE, randomOreSmelt(), 0.0F);
    }

    private static ItemStack randomOreSmelt()
    {
        Random random = new Random();
        int luck = random.nextInt(99);
        int quantity = random.nextInt(1) + 1;

        if(luck <= 53)
        {
            return new ItemStack(ItemsInit.TOPAZE, quantity);
        }
        else if(luck > 53 && luck <= 88)
        {
            return new ItemStack(ItemsInit.AZURITE, quantity);
        }
        else if(luck > 88 && luck <= 97)
        {
            return new ItemStack(ItemsInit.MERCURE, quantity);
        }
        else
        {
            return new ItemStack(ItemsInit.MENORITE_FRAGMENT, quantity);
        }
    }
}