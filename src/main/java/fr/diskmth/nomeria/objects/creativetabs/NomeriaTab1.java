package fr.diskmth.nomeria.objects.creativetabs;

import fr.diskmth.nomeria.init.BlocksInit;
import fr.diskmth.nomeria.init.ItemsInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class NomeriaTab1 extends CreativeTabs
{
    public NomeriaTab1(String name)
    {
        super(name);
        this.setNoTitle();
        this.setBackgroundImageName(name + ".png");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ItemsInit.LOGO);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean hasSearchBar()
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void displayAllRelevantItems(NonNullList<ItemStack> list)
    {
        super.displayAllRelevantItems(list);

        // topaze
        list.add(new ItemStack(ItemsInit.TOPAZE));
        list.add(new ItemStack(BlocksInit.TOPAZE_BLOCK));
        list.add(new ItemStack(BlocksInit.TOPAZE_ORE));
        list.add(new ItemStack(ItemsInit.TOPAZE_SWORD));
        list.add(new ItemStack(ItemsInit.TOPAZE_PICKAXE));
        list.add(new ItemStack(ItemsInit.TOPAZE_AXE));
        list.add(new ItemStack(ItemsInit.TOPAZE_SHOVEL));
        list.add(new ItemStack(ItemsInit.TOPAZE_HELMET));
        list.add(new ItemStack(ItemsInit.TOPAZE_CHESTPLATE));
        list.add(new ItemStack(ItemsInit.TOPAZE_LEGGING));
        list.add(new ItemStack(ItemsInit.TOPAZE_BOOTS));
        list.add(new ItemStack(ItemsInit.TOPAZE_BOW));
        list.add(new ItemStack(BlocksInit.TOPAZE_LADDER));
        // azurite
        list.add(new ItemStack(ItemsInit.AZURITE));
        list.add(new ItemStack(BlocksInit.AZURITE_BLOCK));
        list.add(new ItemStack(BlocksInit.AZURITE_ORE));
        list.add(new ItemStack(ItemsInit.AZURITE_SWORD));
        list.add(new ItemStack(ItemsInit.AZURITE_PICKAXE));
        list.add(new ItemStack(ItemsInit.AZURITE_AXE));
        list.add(new ItemStack(ItemsInit.AZURITE_SHOVEL));
        list.add(new ItemStack(ItemsInit.AZURITE_HELMET));
        list.add(new ItemStack(ItemsInit.AZURITE_CHESTPLATE));
        list.add(new ItemStack(ItemsInit.AZURITE_LEGGING));
        list.add(new ItemStack(ItemsInit.AZURITE_BOOTS));
        // mercure
        list.add(new ItemStack(ItemsInit.MERCURE));
        list.add(new ItemStack(BlocksInit.MERCURE_BLOCK));
        list.add(new ItemStack(BlocksInit.MERCURE_ORE));
        list.add(new ItemStack(ItemsInit.MERCURE_SWORD));
        list.add(new ItemStack(ItemsInit.MERCURE_PICKAXE));
        list.add(new ItemStack(ItemsInit.MERCURE_AXE));
        list.add(new ItemStack(ItemsInit.MERCURE_SHOVEL));
        list.add(new ItemStack(ItemsInit.MERCURE_HELMET));
        list.add(new ItemStack(ItemsInit.MERCURE_CHESTPLATE));
        list.add(new ItemStack(ItemsInit.MERCURE_LEGGING));
        list.add(new ItemStack(ItemsInit.MERCURE_BOOTS));
        // menorite
        list.add(new ItemStack(ItemsInit.MENORITE_FRAGMENT));
        list.add(new ItemStack(ItemsInit.MENORITE));
        list.add(new ItemStack(BlocksInit.MENORITE_BLOCK));
        list.add(new ItemStack(ItemsInit.MENORITE_SWORD));
        list.add(new ItemStack(ItemsInit.MENORITE_PICKAXE));
        list.add(new ItemStack(ItemsInit.MENORITE_AXE));
        list.add(new ItemStack(ItemsInit.MENORITE_SHOVEL));
        list.add(new ItemStack(ItemsInit.MENORITE_HELMET));
        list.add(new ItemStack(ItemsInit.MENORITE_CHESTPLATE));
        list.add(new ItemStack(ItemsInit.MENORITE_LEGGING));
        list.add(new ItemStack(ItemsInit.MENORITE_BOOTS));
        // other
        list.add(new ItemStack(ItemsInit.LEGENDARY_PICKAXE));
        list.add(new ItemStack(ItemsInit.HEAL_STICK));
        list.add(new ItemStack(BlocksInit.PILLER_TNT));
        list.add(new ItemStack(BlocksInit.RANDOM_ORE));
    }
}
