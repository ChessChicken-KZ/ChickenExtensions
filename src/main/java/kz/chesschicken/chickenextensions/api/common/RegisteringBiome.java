package kz.chesschicken.chickenextensions.api.common;

import kz.chesschicken.chickenextensions.biome.AlphiumBiome;
import kz.chesschicken.chickenextensions.biome.GravelDesert;
import kz.chesschicken.chickenextensions.entity.BloodyPigman;
import net.minecraft.entity.EntityEntry;
import net.minecraft.level.biome.Biome;
import net.modificationstation.stationloader.api.common.event.level.biome.BiomeRegister;
import net.modificationstation.stationloader.mixin.common.accessor.BiomeAccessor;

public class RegisteringBiome implements BiomeRegister {

    public static Biome biomeGravelDesert;
    public static Biome biomeAlphiumBiome;
    public static Biome biomeSnowGravelDesert;
    public static Biome biomeSnowAlphiumBiome;
    @Override
    public void registerBiomes() {
        ((BiomeAccessor) Biome.NETHER).getMonsters().add(new EntityEntry(BloodyPigman.class, 10));
        biomeGravelDesert = new GravelDesert(false);
        biomeAlphiumBiome = new AlphiumBiome(false);
        biomeSnowGravelDesert = new GravelDesert(true);
        biomeSnowAlphiumBiome = new AlphiumBiome(true);
    }






}
