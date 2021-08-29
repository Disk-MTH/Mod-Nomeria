package fr.diskmth.nomeria.objects.items;

import java.util.Set;

import com.google.common.collect.Sets;

import fr.diskmth.nomeria.Main;
import fr.diskmth.nomeria.init.ItemsInit;
import fr.diskmth.nomeria.utils.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class AxeItem extends ItemTool implements IHasModel
{
    private String typeOfAxe = "";

    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE);

    public AxeItem(String name, ToolMaterial material)
    {
        super(material, EFFECTIVE_ON);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.typeOfAxe = name;
        setCreativeTab(null);
        ItemsInit.ITEMS.add(this);
    }

    public float getStrVsBlock(ItemStack stack, IBlockState state)
    {
        Material material = state.getMaterial();
        return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? 1 : this.toolMaterial.getEfficiency();
    }

    public boolean getIsRepairable(ItemStack input, ItemStack repair)
    {
        if(typeOfAxe.contains("topaze"))
        {
            if(repair.getItem() == ItemsInit.TOPAZE)
            {
                return true;
            }
        }

        if(typeOfAxe.contains("azurite"))
        {
            if(repair.getItem() == ItemsInit.AZURITE)
            {
                return true;
            }
        }

        if(typeOfAxe.contains("mercure"))
        {
            if(repair.getItem() == ItemsInit.MERCURE)
            {
                return true;
            }
        }

        if(typeOfAxe.contains("menorite"))
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
