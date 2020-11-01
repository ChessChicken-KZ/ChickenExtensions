package kz.chesschicken.chickenextensions.biome;

import net.minecraft.block.BlockBase;
import net.minecraft.level.biome.Biome;
import net.minecraft.level.biome.SparseBiome;

public class GravelDesert extends SparseBiome {
    public GravelDesert()
    {
        this.setName("Gravel Desert");
        this.setGrassColour(16421912);
        this.topTileId = this.underTileId = (byte) BlockBase.GRAVEL.id;
    }

    @Override
    public boolean canRain() {
        return false;
    }
}
