package fr.diskmth.nomeria.utils;

import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class OldPvpUtils
{
    public enum itemType
    {
        AXE, SWORD, OTHER
    }

    public static itemType getItemType(ItemStack itemStack)
    {
        if(itemStack.getItem().getRegistryName() == null)
        {
            return itemType.OTHER;
        }

        String itemName = itemStack.getItem().getRegistryName().toString();

        if(itemName.equals("minecraft:diamond_sword") ||
                itemName.equals("minecraft:iron_sword") ||
                itemName.equals("minecraft:stone_sword") ||
                itemName.equals("minecraft:golden_sword") ||
                itemName.equals("minecraft:wooden_sword") ||
                itemName.equals("nomeriamod:topaze_sword") ||
                itemName.equals("nomeriamod:azurite_sword") ||
                itemName.equals("nomeriamod:mercure_sword") ||
                itemName.equals("nomeriamod:menorite_sword"))
        {
            return itemType.SWORD;
        }

        if(itemName.equals("minecraft:diamond_axe") ||
                itemName.equals("minecraft:iron_axe") ||
                itemName.equals("minecraft:stone_axe") ||
                itemName.equals("minecraft:golden_axe") ||
                itemName.equals("minecraft:wooden_axe") ||
                itemName.equals("nomeriamod:topaze_axe") ||
                itemName.equals("nomeriamod:azurite_axe") ||
                itemName.equals("nomeriamod:mercure_axe") ||
                itemName.equals("nomeriamod:menorite_axe"))
        {
            return itemType.AXE;
        }

        return itemType.OTHER;
    }

    public static float getOldDamages(ItemStack itemStack)
    {
        if(itemStack.getItem().getRegistryName() == null)
        {
            return 0.0F;
        }

        if(getItemType(itemStack) != itemType.AXE)
        {
            return 0.0F;
        }

        switch(itemStack.getItem().getRegistryName().toString())
        {
            case "minecraft:diamond_axe":
                return 6.0F;
            case "minecraft:iron_axe":
                return 5.0F;
            case "minecraft:stone_axe":
                return 4.0F;
            case "minecraft:golden_axe":
            case "minecraft:wooden_axe":
                return 3.0F;
        }

        return 0.0F;
    }

    public static boolean canBeBlocked(DamageSource damageSource)
    {
        return (damageSource.damageType.equals("mob") ||
                damageSource.damageType.equals("player") ||
                damageSource.damageType.equals("arrow") ||
                damageSource.damageType.equals("explosion"));
    }

    public static int booleanToInt(boolean isBlocking)
    {
        if(!isBlocking)
        {
            return 0;
        }

        else
        {
            return 1;
        }
    }
}
