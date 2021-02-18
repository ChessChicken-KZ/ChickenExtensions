package kz.chesschicken.chickenextensions.mixin.overworld;


import kz.chesschicken.chickenextensions.content.overworld.OverworldBase;
import net.minecraft.entity.monster.Zombie;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Adding rotten flesh drop!
 */
@Mixin(Zombie.class)
public class MixinZombie {
    @Inject(method = "getMobDrops", at = @At("HEAD"), cancellable = true)
    private void fleshMeat(CallbackInfoReturnable<Integer> cir)
    {
        cir.setReturnValue(OverworldBase.itemRottenFlesh().id);
        cir.cancel();
    }

}
