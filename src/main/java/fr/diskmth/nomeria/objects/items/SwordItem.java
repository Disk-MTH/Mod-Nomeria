package fr.diskmth.nomeria.objects.items;

import fr.diskmth.nomeria.Main;
import fr.diskmth.nomeria.init.ItemsInit;
import fr.diskmth.nomeria.utils.interfaces.IHasModel;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class SwordItem extends ItemSword implements IHasModel
{
    private String typeOfSword = "";

    public SwordItem(String name, ToolMaterial material)
    {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.typeOfSword = name;
        setCreativeTab(null);
        ItemsInit.ITEMS.add(this);
    }

    public boolean getIsRepairable(ItemStack input, ItemStack repair)
    {
        if(typeOfSword.contains("topaze"))
        {
            if(repair.getItem() == ItemsInit.TOPAZE)
            {
                return true;
            }
        }

        if(typeOfSword.contains("azurite"))
        {
            if(repair.getItem() == ItemsInit.AZURITE)
            {
                return true;
            }
        }

        if(typeOfSword.contains("mercure"))
        {
            if(repair.getItem() == ItemsInit.MERCURE)
            {
                return true;
            }
        }

        if(typeOfSword.contains("menorite"))
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
