package fr.diskmth.nomeria.objects.items;

import fr.diskmth.nomeria.Main;
import fr.diskmth.nomeria.init.ItemsInit;
import fr.diskmth.nomeria.utils.interfaces.IHasModel;
import net.minecraft.item.Item;

public class BasicItem extends Item implements IHasModel
{
    public BasicItem(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(null);
        ItemsInit.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(this, 0);
    }
}
