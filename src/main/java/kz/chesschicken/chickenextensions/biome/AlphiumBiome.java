package kz.chesschicken.chickenextensions.biome;

import kz.chesschicken.chickenextensions.ChickenMod;
import net.minecraft.level.biome.Biome;

public class AlphiumBiome extends Biome {
    public AlphiumBiome(boolean snow)
    {
        this.setName("Alphium Biome");
        this.setGrassColour(ChickenMod.INSTANCE.get16ColorCode(5));
        if(snow)
            this.setSnowy();
    }
}
