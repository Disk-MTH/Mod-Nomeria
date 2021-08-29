package fr.diskmth.nomeria.init;

import java.util.Random;

import net.minecraft.init.Items;
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
        int luck = random.nextInt(99) + 1;
        int quantity = random.nextInt(1) + 1;

        if(luck <= 55)
        {
            return new ItemStack(ItemsInit.TOPAZE, quantity);
        }
        if(luck > 55 && luck <= 90)
        {
            return new ItemStack(ItemsInit.AZURITE, quantity);
        }
        if(luck > 90 && luck <= 99)
        {
            return new ItemStack(ItemsInit.MERCURE, quantity);
        }
        if(luck == 100)
        {
            return new ItemStack(ItemsInit.MENORITE_FRAGMENT, quantity);
        }

        return new ItemStack(Items.AIR);
    }
}