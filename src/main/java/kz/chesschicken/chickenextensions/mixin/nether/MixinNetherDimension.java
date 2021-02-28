package kz.chesschicken.chickenextensions.mixin.nether;


import net.minecraft.level.dimension.Dimension;
import net.minecraft.level.dimension.Nether;
import net.minecraft.level.gen.BiomeSource;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * Adds multiple biomes support - biome source;
 */
@Mixin(Nether.class)
public abstract class MixinNetherDimension extends Dimension {
    @Redirect(method = "initBiomeSource()V", at = @At(value = "FIELD", target = "Lnet/minecraft/level/dimension/Nether;biomeSource:Lnet/minecraft/level/gen/BiomeSource;", opcode = Opcodes.PUTFIELD))
    private void addMultiple(Nether nether, BiomeSource value)
    {
        nether.biomeSource = new NetherSource(this.level);
    }
}
