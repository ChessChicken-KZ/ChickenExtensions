package kz.chesschicken.chickenextensions.biome;

import kz.chesschicken.chickenextensions.api.common.RegisteringBiome;
import net.minecraft.level.biome.Biome;

import java.util.HashMap;
import java.util.Random;

public class BiomeDoubler {
    public static HashMap<Biome, Float> minHeight = new HashMap<Biome, Float>();
    public static HashMap<Biome, Float> maxHeight = new HashMap<Biome, Float>();
    public static HashMap<Integer, Biome> biomeID = new HashMap<Integer, Biome>();

    public static void load()
    {
        biomeID.clear();
        minHeight.put(Biome.DESERT, 0.1F);
        maxHeight.put(Biome.DESERT, 0.2F);
        minHeight.put(Biome.ICE_DESERT, 0.1F);
        maxHeight.put(Biome.ICE_DESERT, 0.2F);
        minHeight.put(Biome.FOREST, 0.1F);
        maxHeight.put(Biome.FOREST, 0.3F);
        minHeight.put(Biome.SEASONAL_FOREST, 0.1F);
        maxHeight.put(Biome.SEASONAL_FOREST, 0.3F);
        minHeight.put(Biome.RAINFOREST, 0.1F);
        maxHeight.put(Biome.RAINFOREST, 0.3F);
        minHeight.put(Biome.SWAMPLAND, -0.2F);
        maxHeight.put(Biome.SWAMPLAND, 0.1F);
        minHeight.put(Biome.PLAINS, 0.1F);
        maxHeight.put(Biome.PLAINS, 0.3F);
        minHeight.put(Biome.TUNDRA, 0.1F);
        maxHeight.put(Biome.TUNDRA, 0.4F);
        minHeight.put(Biome.TAIGA, 0.1F);
        maxHeight.put(Biome.TAIGA, 0.4F);
        minHeight.put(Biome.SHRUBLAND, 0.1F);
        maxHeight.put(Biome.SHRUBLAND, 0.3F);
        minHeight.put(Biome.SAVANNA, 0.2F);
        maxHeight.put(Biome.SAVANNA, 1.3F);

        minHeight.put(RegisteringBiome.biomeGravelDesert, 0.1F);
        maxHeight.put(RegisteringBiome.biomeGravelDesert, 0.2F);
        minHeight.put(RegisteringBiome.biomeSnowGravelDesert, 0.1F);
        maxHeight.put(RegisteringBiome.biomeSnowGravelDesert, 0.2F);
        minHeight.put(RegisteringBiome.biomeAlphiumBiome, 0.1F);
        maxHeight.put(RegisteringBiome.biomeAlphiumBiome, 0.3F);
        minHeight.put(RegisteringBiome.biomeSnowAlphiumBiome, 0.1F);
        maxHeight.put(RegisteringBiome.biomeSnowAlphiumBiome, 0.3F);

        biomeID.put(0, Biome.RAINFOREST);
        biomeID.put(1, Biome.SWAMPLAND);
        biomeID.put(2, Biome.SEASONAL_FOREST);
        biomeID.put(3, Biome.FOREST);
        biomeID.put(4, Biome.SAVANNA);
        biomeID.put(5, Biome.SHRUBLAND);
        biomeID.put(6, Biome.TAIGA);
        biomeID.put(7, Biome.DESERT);
        biomeID.put(8, Biome.PLAINS);
        biomeID.put(9, Biome.ICE_DESERT);
        biomeID.put(10, Biome.TUNDRA);
        biomeID.put(11, RegisteringBiome.biomeGravelDesert);
        biomeID.put(12, RegisteringBiome.biomeSnowGravelDesert);
        biomeID.put(13, RegisteringBiome.biomeAlphiumBiome);
        biomeID.put(14, RegisteringBiome.biomeSnowAlphiumBiome);
    }
    public static Biome getRandomBiome()
    {
        BiomeDoubler.load();
        return BiomeDoubler.biomeID.get((new Random()).nextInt(BiomeDoubler.biomeID.size()));
    }
}
