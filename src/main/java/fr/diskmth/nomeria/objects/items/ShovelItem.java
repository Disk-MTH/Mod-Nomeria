package fr.diskmth.nomeria.objects.items;

import fr.diskmth.nomeria.Main;
import fr.diskmth.nomeria.init.ItemsInit;
import fr.diskmth.nomeria.utils.interfaces.IHasModel;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class ShovelItem extends ItemSpade implements IHasModel
{
    private String typeOfShovel = "";

    public ShovelItem(String name, ToolMaterial material)
    {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.typeOfShovel = name;
        setCreativeTab(null);
        ItemsInit.ITEMS.add(this);
    }

    public boolean getIsRepairable(ItemStack input, ItemStack repair)
    {
        if(typeOfShovel.contains("topaze"))
        {
            if(repair.getItem() == ItemsInit.TOPAZE)
            {
                return true;
            }
        }

        if(typeOfShovel.contains("azurite"))
        {
            if(repair.getItem() == ItemsInit.AZURITE)
            {
                return true;
            }
        }

        if(typeOfShovel.contains("mercure"))
        {
            if(repair.getItem() == ItemsInit.MERCURE)
            {
                return true;
            }
        }

        if(typeOfShovel.contains("menorite"))
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
