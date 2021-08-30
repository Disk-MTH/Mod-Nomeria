package fr.diskmth.nomeria.world.generation;

import java.util.Random;

import fr.diskmth.nomeria.init.BlocksInit;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenOres implements IWorldGenerator
{
    private WorldGenerator TOPAZE_ORE = (WorldGenerator)new WorldGenMinable(BlocksInit.TOPAZE_ORE.getDefaultState(), 10, BlockMatcher.forBlock(Blocks.STONE));
    private WorldGenerator AZURITE_ORE = (WorldGenerator)new WorldGenMinable(BlocksInit.AZURITE_ORE.getDefaultState(), 8, BlockMatcher.forBlock(Blocks.STONE));
    private WorldGenerator MERCURE_ORE = (WorldGenerator)new WorldGenMinable(BlocksInit.MERCURE_ORE.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.STONE));
    private WorldGenerator RANDOM_ORE = (WorldGenerator)new WorldGenMinable(BlocksInit.RANDOM_ORE.getDefaultState(), 2, BlockMatcher.forBlock(Blocks.STONE));

    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        switch(world.provider.getDimension())
        {
            case 0:
                runGenerator(this.TOPAZE_ORE, world, random, chunkX, chunkZ, 2.25D, 2, 15);
                runGenerator(this.AZURITE_ORE, world, random, chunkX, chunkZ, 1.4D, 2, 15);
                runGenerator(this.MERCURE_ORE, world, random, chunkX, chunkZ, 0.7D, 2, 15);
                runGenerator(this.RANDOM_ORE, world, random, chunkX, chunkZ, 0.6D, 2, 15);
                break;
        }
    }

    private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, double chance, int minHeight, int maxHeight)
    {
        if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256)
            throw new IllegalArgumentException("Ore generated out of bounds");
        int heightDiff = maxHeight - minHeight + 1;
        for(int i = 0; i < chance; i++)
        {
            int x = chunkX * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunkZ * 16 + rand.nextInt(16);
            gen.generate(world, rand, new BlockPos(x, y, z));
        }
    }
}