package fr.diskmth.nomeria.init;

import java.util.ArrayList;
import java.util.List;

import fr.diskmth.nomeria.objects.blocks.BasicBlock;
import fr.diskmth.nomeria.objects.blocks.OreBlock;
import fr.diskmth.nomeria.objects.blocks.PillerTNTBlock;
import fr.diskmth.nomeria.objects.blocks.TopazeLadderBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlocksInit
{
    public static List<Block> BLOCKS = new ArrayList<Block>();

    // topaze
    public static Block TOPAZE_BLOCK = new BasicBlock("topaze_block", Material.IRON, 5.0F, 10.0F, SoundType.METAL);
    public static Block TOPAZE_ORE = new OreBlock("topaze_ore", 3.0F, 5.0F, 3, SoundType.STONE);
    // azurite
    public static Block AZURITE_BLOCK = new BasicBlock("azurite_block", Material.IRON, 5.0F, 10.0F, SoundType.METAL);
    public static Block AZURITE_ORE = new OreBlock("azurite_ore", 3.0F, 5.0F, 3, SoundType.STONE);
    // mercure
    public static Block MERCURE_BLOCK = new BasicBlock("mercure_block", Material.IRON, 5.0F, 10.0F, SoundType.METAL);
    public static Block MERCURE_ORE = new OreBlock("mercure_ore", 3.0F, 5.0F, 3, SoundType.STONE);
    // menorite
    public static Block MENORITE_BLOCK = new BasicBlock("menorite_block", Material.IRON, 5.0F, 10.0F, SoundType.METAL);
    // other
    public static Block PILLER_TNT = new PillerTNTBlock("piller_tnt", Material.TNT);
    public static Block TOPAZE_LADDER = new TopazeLadderBlock();
    public static Block RANDOM_ORE = new OreBlock("random_ore", 3.0F, 5.0F, 3, SoundType.STONE, 1, 3, false, false, 0, 0);
}