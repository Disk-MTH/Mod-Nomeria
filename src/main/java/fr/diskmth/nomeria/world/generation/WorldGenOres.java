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
    private WorldGenerator TOPAZE_ORE;
    private WorldGenerator AZURITE_ORE;
    private WorldGenerator MERCURE_ORE;
    private WorldGenerator RANDOM_ORE;

    public WorldGenOres()
    {
        TOPAZE_ORE = new WorldGenMinable(BlocksInit.TOPAZE_ORE.getDefaultState(), 10, BlockMatcher.forBlock(Blocks.STONE));
        AZURITE_ORE = new WorldGenMinable(BlocksInit.AZURITE_ORE.getDefaultState(), 8, BlockMatcher.forBlock(Blocks.STONE));
        MERCURE_ORE = new WorldGenMinable(BlocksInit.MERCURE_ORE.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.STONE));
        RANDOM_ORE = new WorldGenMinable(BlocksInit.RANDOM_ORE.getDefaultState(), 2, BlockMatcher.forBlock(Blocks.STONE));
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        switch(world.provider.getDimension())
        {
            case 0:
                runGenerator(TOPAZE_ORE, world, random, chunkX, chunkZ, 2.25, 2, 15);
                runGenerator(AZURITE_ORE, world, random, chunkX, chunkZ, 1.4, 2, 15);
                runGenerator(MERCURE_ORE, world, random, chunkX, chunkZ, 0.7, 2, 15);
                runGenerator(RANDOM_ORE, world, random, chunkX, chunkZ, 0.6, 2, 15);
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