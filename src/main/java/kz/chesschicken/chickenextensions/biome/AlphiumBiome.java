package kz.chesschicken.chickenextensions.biome;

import kz.chesschicken.chickenextensions.ChickenMod;
import net.minecraft.level.biome.Biome;

public class AlphiumBiome extends Biome {
    public AlphiumBiome()
    {
        this.setName("Alphium Biome");
        this.setGrassColour(ChickenMod.INSTANCE.get16ColorCode(5));
    }
}
