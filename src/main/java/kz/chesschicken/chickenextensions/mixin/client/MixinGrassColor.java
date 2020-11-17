package kz.chesschicken.chickenextensions.mixin.client;


import kz.chesschicken.chickenextensions.api.common.BiomeClass;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Grass;
import net.minecraft.block.Leaves;
import net.minecraft.block.TallGrass;
import net.minecraft.level.TileView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin({Grass.class, Leaves.class, TallGrass.class})
public class MixinGrassColor {
    @Inject(method = "getColor(Lnet/minecraft/level/TileView;III)I", at = @At("HEAD"), cancellable = true)
    private void doS(TileView arg, int x, int y, int z, CallbackInfoReturnable<Integer> cir)
    {
        BiomeClass.loadTemp();
        cir.setReturnValue(BiomeClass.tempValue.get(arg.getBiomeSource().getBiome(x,z)));

    }
}
