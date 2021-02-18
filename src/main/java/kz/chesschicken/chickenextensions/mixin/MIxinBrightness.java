package kz.chesschicken.chickenextensions.mixin;

import net.minecraft.block.BlockBase;
import net.minecraft.level.TileView;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBase.class)
public class MIxinBrightness {

    @Shadow @Final public static int[] EMITTANCE;

    @Shadow @Final public int id;

    @Inject(method = "method_1604", at = @At("RETURN"), cancellable = true)
    private void bright(TileView arg, int i, int j, int k, CallbackInfoReturnable<Float> cir)
    {
        cir.setReturnValue(false ? arg.method_1784(i, j, k, EMITTANCE[this.id]) : 1.3F);
    }
}
