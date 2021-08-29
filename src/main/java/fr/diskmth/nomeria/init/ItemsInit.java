package fr.diskmth.nomeria.init;

import java.util.ArrayList;
import java.util.List;

import fr.diskmth.nomeria.objects.items.ArmorItem;
import fr.diskmth.nomeria.objects.items.AxeItem;
import fr.diskmth.nomeria.objects.items.BasicItem;
import fr.diskmth.nomeria.objects.items.LengendaryPickaxeItem;
import fr.diskmth.nomeria.objects.items.PickaxeItem;
import fr.diskmth.nomeria.objects.items.ShovelItem;
import fr.diskmth.nomeria.objects.items.StickItem;
import fr.diskmth.nomeria.objects.items.SwordItem;
import fr.diskmth.nomeria.objects.items.TopazeBowItem;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;

public class ItemsInit
{
    public static List<Item> ITEMS = new ArrayList<Item>();

    // topaze
    public static Item TOPAZE = new BasicItem("topaze");
    public static ItemSword TOPAZE_SWORD = new SwordItem("topaze_sword", ToolMaterialsInit.TOPAZE_SWORD);
    public static ItemPickaxe TOPAZE_PICKAXE = new PickaxeItem("topaze_pickaxe", ToolMaterialsInit.TOPAZE_TOOL);
    public static AxeItem TOPAZE_AXE = new AxeItem("topaze_axe", ToolMaterialsInit.TOPAZE_TOOL);
    public static ItemSpade TOPAZE_SHOVEL = new ShovelItem("topaze_shovel", ToolMaterialsInit.TOPAZE_TOOL);
    public static ItemArmor TOPAZE_HELMET = new ArmorItem("topaze_helmet", ToolMaterialsInit.TOPAZE_ARMOR, 1, EntityEquipmentSlot.HEAD);
    public static ItemArmor TOPAZE_CHESTPLATE = new ArmorItem("topaze_chestplate", ToolMaterialsInit.TOPAZE_ARMOR, 1, EntityEquipmentSlot.CHEST);
    public static ItemArmor TOPAZE_LEGGING = new ArmorItem("topaze_legging", ToolMaterialsInit.TOPAZE_ARMOR, 2, EntityEquipmentSlot.LEGS);
    public static ItemArmor TOPAZE_BOOTS = new ArmorItem("topaze_boots", ToolMaterialsInit.TOPAZE_ARMOR, 1, EntityEquipmentSlot.FEET);
    public static Item TOPAZE_BOW = new TopazeBowItem();
    // azurite
    public static Item AZURITE = new BasicItem("azurite");
    public static ItemSword AZURITE_SWORD = new SwordItem("azurite_sword", ToolMaterialsInit.AZURITE_SWORD);
    public static ItemPickaxe AZURITE_PICKAXE = new PickaxeItem("azurite_pickaxe", ToolMaterialsInit.AZURITE_TOOL);
    public static AxeItem AZURITE_AXE = new AxeItem("azurite_axe", ToolMaterialsInit.AZURITE_TOOL);
    public static ItemSpade AZURITE_SHOVEL = new ShovelItem("azurite_shovel", ToolMaterialsInit.AZURITE_TOOL);
    public static ItemArmor AZURITE_HELMET = new ArmorItem("azurite_helmet", ToolMaterialsInit.AZURITE_ARMOR, 1, EntityEquipmentSlot.HEAD);
    public static ItemArmor AZURITE_CHESTPLATE = new ArmorItem("azurite_chestplate", ToolMaterialsInit.AZURITE_ARMOR, 1, EntityEquipmentSlot.CHEST);
    public static ItemArmor AZURITE_LEGGING = new ArmorItem("azurite_legging", ToolMaterialsInit.AZURITE_ARMOR, 2, EntityEquipmentSlot.LEGS);
    public static ItemArmor AZURITE_BOOTS = new ArmorItem("azurite_boots", ToolMaterialsInit.AZURITE_ARMOR, 1, EntityEquipmentSlot.FEET);
    // mercure
    public static Item MERCURE = new BasicItem("mercure");
    public static ItemSword MERCURE_SWORD = new SwordItem("mercure_sword", ToolMaterialsInit.MERCURE_SWORD);
    public static ItemPickaxe MERCURE_PICKAXE = new PickaxeItem("mercure_pickaxe", ToolMaterialsInit.MERCURE_TOOL);
    public static AxeItem MERCURE_AXE = new AxeItem("mercure_axe", ToolMaterialsInit.MERCURE_TOOL);
    public static ItemSpade MERCURE_SHOVEL = new ShovelItem("mercure_shovel", ToolMaterialsInit.MERCURE_TOOL);
    public static ItemArmor MERCURE_HELMET = new ArmorItem("mercure_helmet", ToolMaterialsInit.MERCURE_ARMOR, 1, EntityEquipmentSlot.HEAD);
    public static ItemArmor MERCURE_CHESTPLATE = new ArmorItem("mercure_chestplate", ToolMaterialsInit.MERCURE_ARMOR, 1, EntityEquipmentSlot.CHEST);
    public static ItemArmor MERCURE_LEGGING = new ArmorItem("mercure_legging", ToolMaterialsInit.MERCURE_ARMOR, 2, EntityEquipmentSlot.LEGS);
    public static ItemArmor MERCURE_BOOTS = new ArmorItem("mercure_boots", ToolMaterialsInit.MERCURE_ARMOR, 1, EntityEquipmentSlot.FEET);
    // menorite
    public static Item MENORITE_FRAGMENT = new BasicItem("menorite_fragment");
    public static Item MENORITE = new BasicItem("menorite");
    public static ItemSword MENORITE_SWORD = new SwordItem("menorite_sword", ToolMaterialsInit.MENORITE_SWORD);
    public static ItemPickaxe MENORITE_PICKAXE = new PickaxeItem("menorite_pickaxe", ToolMaterialsInit.MENORITE_TOOL);
    public static AxeItem MENORITE_AXE = new AxeItem("menorite_axe", ToolMaterialsInit.MENORITE_TOOL);
    public static ItemSpade MENORITE_SHOVEL = new ShovelItem("menorite_shovel", ToolMaterialsInit.MENORITE_TOOL);
    public static ItemArmor MENORITE_HELMET = new ArmorItem("menorite_helmet", ToolMaterialsInit.MENORITE_ARMOR, 1, EntityEquipmentSlot.HEAD);
    public static ItemArmor MENORITE_CHESTPLATE = new ArmorItem("menorite_chestplate", ToolMaterialsInit.MENORITE_ARMOR, 1, EntityEquipmentSlot.CHEST);
    public static ItemArmor MENORITE_LEGGING = new ArmorItem("menorite_legging", ToolMaterialsInit.MENORITE_ARMOR, 2, EntityEquipmentSlot.LEGS);
    public static ItemArmor MENORITE_BOOTS = new ArmorItem("menorite_boots", ToolMaterialsInit.MENORITE_ARMOR, 1, EntityEquipmentSlot.FEET);
    // other
    public static Item LEGENDARY_PICKAXE = new LengendaryPickaxeItem();
    public static Item HEAL_STICK = new StickItem("heal_stick", 5);
    public static Item LOGO = new BasicItem("logo");
}