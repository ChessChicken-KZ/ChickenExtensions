package kz.chesschicken.chickenextensions.mixin.common;

import kz.chesschicken.chickenextensions.api.common.BiomeClass;
import net.minecraft.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Biome.class)
public class MixinBiomeSystem {
    private static double getFirstSwitch = 0D;
    private static Biome randomBiome;

    @Inject(method = "getClimateBiome", at = @At("HEAD"), cancellable = true)
    private static void recreateB(float temperature, float rainfall, CallbackInfoReturnable<Biome> cir)
    {

        if (getFirstSwitch != (Math.floor(temperature * 10))) {
            randomBiome = BiomeClass.getRandomBiome();
            getFirstSwitch = Math.floor(temperature * 10);
        }
        cir.setReturnValue(randomBiome);


    }

}
