package kz.chesschicken.chickenextensions.mixin.common;

import kz.chesschicken.chickenextensions.api.common.RegisteringBiome;
import net.minecraft.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(Biome.class)
public class MixinBiomeSystem {
    private static float getFirstSwitch;
    private static float getSecondSwitch;
    private static Biome randomBiome;

    @Inject(method = "getClimateBiome", at = @At("HEAD"), cancellable = true)
    private static void recreateB(float temperature, float rainfall, CallbackInfoReturnable<Biome> cir)
    {
        if (getFirstSwitch != temperature && getSecondSwitch != rainfall) {
            randomBiome = getRandomBiome();
            getFirstSwitch = temperature;
            getSecondSwitch = rainfall;
        }
        cir.setReturnValue(randomBiome);
    }

    private static Biome getRandomBiome()
    {
        int r = (new Random()).nextInt(14);
        switch (r)
        {
            case 0:
                return Biome.RAINFOREST;
            case 1:
                return Biome.SWAMPLAND;
            case 2:
                return Biome.SEASONAL_FOREST;
            case 3:
                return Biome.FOREST;
            case 4:
                return Biome.SAVANNA;
            case 5:
                return Biome.SHRUBLAND;
            case 6:
                return Biome.TAIGA;
            case 7:
                return Biome.DESERT;
            case 8:
                return Biome.PLAINS;
            case 9:
                return Biome.ICE_DESERT;
            case 10:
                return Biome.TUNDRA;
            case 11:
                return RegisteringBiome.biomeGravelDesert;
            case 12:
                return RegisteringBiome.biomeAlphiumBiome;
            case 13:
                return RegisteringBiome.biomeSnowAlphiumBiome;
            case 14:
                return RegisteringBiome.biomeSnowGravelDesert;
            default:
                return Biome.PLAINS;
        }
    }
}
