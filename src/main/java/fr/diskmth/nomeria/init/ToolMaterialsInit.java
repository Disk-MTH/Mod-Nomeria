package fr.diskmth.nomeria.init;

import fr.diskmth.nomeria.utils.References;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ToolMaterialsInit
{
    // armor
    public static ArmorMaterial TOPAZE_ARMOR;
    public static ArmorMaterial AZURITE_ARMOR;
    public static ArmorMaterial MERCURE_ARMOR;
    public static ArmorMaterial MENORITE_ARMOR;
    // tools
    public static ToolMaterial TOPAZE_TOOL;
    public static ToolMaterial AZURITE_TOOL;
    public static ToolMaterial MERCURE_TOOL;
    public static ToolMaterial MENORITE_TOOL;
    // sword
    public static ToolMaterial TOPAZE_SWORD;
    public static ToolMaterial AZURITE_SWORD;
    public static ToolMaterial MERCURE_SWORD;
    public static ToolMaterial MENORITE_SWORD;
    // other
    public static ToolMaterial LEGENDARY_PICKAXE;

    @SuppressWarnings("static-access")
    public static void registerToolMaterials()
    {
        // armor
        TOPAZE_ARMOR = new EnumHelper().addArmorMaterial("topaze", References.MODID + ":topaze", 150, new int[] {3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0f);
        AZURITE_ARMOR = new EnumHelper().addArmorMaterial("azurite", References.MODID + ":azurite", 187, new int[] {4, 7, 9, 4}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0f);
        MERCURE_ARMOR = new EnumHelper().addArmorMaterial("mercure", References.MODID + ":mercure", 235, new int[] {5, 8, 10, 5}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0f);
        MENORITE_ARMOR = new EnumHelper().addArmorMaterial("menorite", References.MODID + ":menorite", 440, new int[] {6, 9, 11, 6}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0f);
        // tools
        TOPAZE_TOOL = new EnumHelper().addToolMaterial("topaze_tool", 4, 1951, 12.0f, 1.0f, 15);
        AZURITE_TOOL = new EnumHelper().addToolMaterial("azurite_tool", 5, 2439, 14.0f, 1.0f, 15);
        MERCURE_TOOL = new EnumHelper().addToolMaterial("mercure_tool", 6, 3049, 16.0f, 1.0f, 15);
        MENORITE_TOOL = new EnumHelper().addToolMaterial("menorite_tool", 7, 4573, 20.0f, 1.0f, 15);
        // sword
        TOPAZE_SWORD = new EnumHelper().addToolMaterial("topaze_sword", 4, 1951, 1.0f, 13.0f, 15);
        AZURITE_SWORD = new EnumHelper().addToolMaterial("azurite_sword", 5, 2439, 1.0f, 19.0f, 15);
        MERCURE_SWORD = new EnumHelper().addToolMaterial("mercure_sword", 6, 3049, 1.0f, 25.0f, 15);
        MENORITE_SWORD = new EnumHelper().addToolMaterial("menorite_sword", 7, 4573, 1.0f, 33.0f, 15);
        // other
        LEGENDARY_PICKAXE = new EnumHelper().addToolMaterial("lengendary_pickaxe", 8, 4000, 20.0f, 1.0f, 15);
    }
}