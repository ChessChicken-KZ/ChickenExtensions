package kz.chesschicken.chickenextensions.api.common;

import net.minecraft.level.biome.Biome;

import java.awt.*;
import java.util.HashMap;
import java.util.Random;

public class BiomeClass {
    public static HashMap<Biome, Float> minHeight = new HashMap<>();
    public static HashMap<Biome, Float> maxHeight = new HashMap<>();
    public static HashMap<Integer, Biome> biomeID = new HashMap<>();
    public static HashMap<Biome, Integer> tempValue = new HashMap<>();


    public static void load()
    {
        biomeID.clear();
        minHeight.clear();
        maxHeight.clear();
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

    public static void loadTemp()
    {
        if(tempValue.isEmpty())
        {
            tempValue.put(Biome.DESERT, new Color(94,93,46).getRGB());
            tempValue.put(Biome.ICE_DESERT, new Color(94,93,46).getRGB());
            tempValue.put(Biome.FOREST, new Color(58,106,34).getRGB());
            tempValue.put(Biome.SEASONAL_FOREST, new Color(44,95,27).getRGB());
            tempValue.put(Biome.RAINFOREST, new Color(58,106,34).getRGB());
            tempValue.put(Biome.SWAMPLAND, new Color(38,64,29).getRGB());
            tempValue.put(Biome.PLAINS, new Color(58,106,34).getRGB());
            tempValue.put(Biome.TUNDRA, new Color(78,100,61).getRGB());
            tempValue.put(Biome.TAIGA, new Color(78,100,61).getRGB());
            tempValue.put(Biome.SHRUBLAND, new Color(44,95,27).getRGB());
            tempValue.put(Biome.SAVANNA, new Color(94,93,46).getRGB());
            tempValue.put(RegisteringBiome.biomeGravelDesert, new Color(94,93,46).getRGB());
            tempValue.put(RegisteringBiome.biomeSnowGravelDesert, new Color(94,93,46).getRGB());
            tempValue.put(RegisteringBiome.biomeAlphiumBiome, new Color(58,168,34).getRGB());
            tempValue.put(RegisteringBiome.biomeSnowAlphiumBiome, new Color(58,168,34).getRGB());
        }
    }

    public static int get16ColorCode(int colortype)
    {
        switch (colortype)
        {
            case 0:
                return new Color(221,221,221).getRGB();
            case 1:
                return new Color(219,125,62).getRGB();
            case 2:
                return new Color(179,80,188).getRGB();
            case 3:
                return new Color(107,138,201).getRGB();
            case 4:
                return new Color(177,166,39).getRGB();
            case 5:
                return new Color(65,164,56).getRGB();
            case 6:
                return new Color(208,132,153).getRGB();
            case 7:
                return new Color(64,64,64).getRGB();
            case 8:
                return new Color(154,161,161).getRGB();
            case 9:
                return new Color(46,110,137).getRGB();
            case 10:
                return new Color(126,61,181).getRGB();
            case 11:
                return new Color(46,56,141).getRGB();
            case 12:
                return new Color(79,50,31).getRGB();
            case 13:
                return new Color(53,70,27).getRGB();
            case 14:
                return new Color(150,52,48).getRGB();
            case 15:
                return new Color(25,22,22).getRGB();
        }
        return 0;
    }

    public static Biome getRandomBiome()
    {
        BiomeClass.load();
        return BiomeClass.biomeID.get((new Random()).nextInt(BiomeClass.biomeID.size()));
    }
}
