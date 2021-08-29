package fr.diskmth.nomeria.objects.items;

import fr.diskmth.nomeria.Main;
import fr.diskmth.nomeria.init.ItemsInit;
import fr.diskmth.nomeria.utils.interfaces.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ArmorItem extends ItemArmor implements IHasModel
{
    private String typeOfArmor = "";

    public ArmorItem(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)
    {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        setUnlocalizedName(name);
        setRegistryName(name);
        this.typeOfArmor = name;
        setCreativeTab(null);
        ItemsInit.ITEMS.add(this);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        super.onArmorTick(world, player, itemStack);
    }

    public boolean getIsRepairable(ItemStack input, ItemStack repair)
    {
        if(typeOfArmor.contains("topaze"))
        {
            if(repair.getItem() == ItemsInit.TOPAZE)
            {
                return true;
            }
        }

        if(typeOfArmor.contains("azurite"))
        {
            if(repair.getItem() == ItemsInit.AZURITE)
            {
                return true;
            }
        }

        if(typeOfArmor.contains("mercure"))
        {
            if(repair.getItem() == ItemsInit.MERCURE)
            {
                return true;
            }
        }

        if(typeOfArmor.contains("menorite"))
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
