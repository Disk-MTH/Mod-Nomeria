package fr.diskmth.nomeria.objects.blocks;

import fr.diskmth.nomeria.Main;
import fr.diskmth.nomeria.init.BlocksInit;
import fr.diskmth.nomeria.init.ItemsInit;
import fr.diskmth.nomeria.utils.interfaces.IHasModel;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.SoundType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;

public class TopazeLadderBlock extends BlockLadder implements IHasModel
{
    public TopazeLadderBlock()
    {
        setUnlocalizedName("topaze_ladder");
        setRegistryName("topaze_ladder");
        setCreativeTab(null);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        setSoundType(SoundType.LADDER);
        BlocksInit.BLOCKS.add(this);
        ItemsInit.ITEMS.add(new ItemBlock(this).setRegistryName("topaze_ladder"));
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0);
    }
}