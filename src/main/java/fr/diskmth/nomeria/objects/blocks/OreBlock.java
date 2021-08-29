package fr.diskmth.nomeria.objects.blocks;

import java.util.Random;

import fr.diskmth.nomeria.Main;
import fr.diskmth.nomeria.init.BlocksInit;
import fr.diskmth.nomeria.init.ItemsInit;
import fr.diskmth.nomeria.utils.interfaces.IHasModel;
import net.minecraft.block.BlockOre;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class OreBlock extends BlockOre implements IHasModel
{
    private boolean multipleDrop = false;
    private boolean isFortuneEnable = false;
    private boolean isExpDropEnable = false;
    private int minDrop;
    private int maxDrop;
    @SuppressWarnings("unused")
    private int minExpDrop;
    @SuppressWarnings("unused")
    private int maxExpDrop;

    public OreBlock(String name, float hardness, float resistance, int harvesLevel, SoundType sound)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel("pickaxe", harvesLevel);
        setSoundType(sound);
        setCreativeTab(null);
        BlocksInit.BLOCKS.add(this);
        ItemsInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));
    }

    public OreBlock(String name, float hardness, float resistance, int harvesLevel, SoundType sound, int minDrop, int maxDrop, boolean isFortuneEnable, boolean isExpDropEnable, int minExpDrop, int maxExpDrop)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel("pickaxe", harvesLevel);
        setSoundType(sound);
        this.multipleDrop = true;
        this.minDrop = minDrop;
        this.maxDrop = maxDrop;
        this.isFortuneEnable = isFortuneEnable;
        this.isExpDropEnable = isExpDropEnable;
        this.minExpDrop = minExpDrop;
        this.maxExpDrop = maxExpDrop;
        BlocksInit.BLOCKS.add(this);
        ItemsInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));
    }

    public Item getItemDropped(IBlockState state, Random random, int fortune)
    {
        if(this == BlocksInit.RANDOM_ORE)
        {
            int luck = random.nextInt(99);

            if(luck <= 53)
            {
                return ItemsInit.TOPAZE;
            }
            else if(luck > 53 && luck <= 88)
            {
                return ItemsInit.AZURITE;
            }
            else if(luck > 88 && luck <= 97)
            {
                return ItemsInit.MERCURE;
            }
            else
            {
                return ItemsInit.MENORITE_FRAGMENT;
            }
        }

        else
        {
            return Item.getItemFromBlock(this);
        }

    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune)
    {
        if(isExpDropEnable)
        {
            Random rand = world instanceof World ? ((World)world).rand : new Random();

            if(this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
            {}
        }
        return 0;
    }

    public int quantityDropped(int fortune, Random random)
    {
        if(isFortuneEnable == true)
        {
            if(fortune > 0)
            {
                int j = random.nextInt(fortune + 2) - 1;

                if(j < 0)
                {
                    j = 0;
                }
                return quantityDropped(random) * (j + 1);
            }

            else
            {
                return this.multipleDrop ? this.minDrop + random.nextInt(this.maxDrop - this.minDrop) : 1;
            }
        }

        else
        {
            return this.multipleDrop ? this.minDrop + random.nextInt(this.maxDrop - this.minDrop) : 1;
        }
    }

    @Override
    public ItemStack getSilkTouchDrop(IBlockState state)
    {
        return super.getSilkTouchDrop(state);
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0);
    }
}
