package kz.chesschicken.chickenextensions.mixin;

import net.minecraft.block.BlockBase;
import net.minecraft.block.Grass;
import net.minecraft.block.Leaves;
import net.minecraft.block.material.Material;
import net.minecraft.level.TileView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({Leaves.class, Grass.class})
public abstract class MixinColour extends BlockBase {
    protected MixinColour(int id, Material material) { super(id, material); }

    @Inject(method = "getColourMultiplier", at = @At("HEAD"), cancellable = true)
    private void nullme(TileView arg, int x, int y, int z, CallbackInfoReturnable<Integer> cir)
    {

    }

}
