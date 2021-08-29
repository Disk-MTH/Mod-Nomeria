package fr.diskmth.nomeria.objects.items;

import fr.diskmth.nomeria.Main;
import fr.diskmth.nomeria.init.ItemsInit;
import fr.diskmth.nomeria.utils.interfaces.IHasModel;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class PickaxeItem extends ItemPickaxe implements IHasModel
{
    private String typeOfPickaxe = "";

    public PickaxeItem(String name, ToolMaterial material)
    {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.typeOfPickaxe = name;
        setCreativeTab(null);
        ItemsInit.ITEMS.add(this);
    }

    public boolean getIsRepairable(ItemStack input, ItemStack repair)
    {
        if(typeOfPickaxe.contains("topaze"))
        {
            if(repair.getItem() == ItemsInit.TOPAZE)
            {
                return true;
            }
        }

        if(typeOfPickaxe.contains("azurite"))
        {
            if(repair.getItem() == ItemsInit.AZURITE)
            {
                return true;
            }
        }

        if(typeOfPickaxe.contains("mercure"))
        {
            if(repair.getItem() == ItemsInit.MERCURE)
            {
                return true;
            }
        }

        if(typeOfPickaxe.contains("menorite"))
        {
            if(repair.getItem() == ItemsInit.MENORITE)
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(this, 0);
    }
}
