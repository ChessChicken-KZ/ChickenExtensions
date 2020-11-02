package kz.chesschicken.chickenextensions.biome;

import net.minecraft.block.BlockBase;
import net.minecraft.level.biome.SparseBiome;

public class GravelDesert extends SparseBiome {
    public GravelDesert(boolean snow)
    {
        this.setName("Gravel Desert");
        this.setGrassColour(16421912);
        this.topTileId = this.underTileId = (byte) BlockBase.GRAVEL.id;
        if(snow)
            this.setSnowy();
    }

    @Override
    public boolean canRain() {
        return false;
    }
}
