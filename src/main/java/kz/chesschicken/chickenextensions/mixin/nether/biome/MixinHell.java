package kz.chesschicken.chickenextensions.mixin.nether.biome;

//import kz.chesschicken.chickenextensions.content.nether.entity.CreeperRed;
import net.minecraft.entity.EntityEntry;
import net.minecraft.level.biome.Biome;
import net.minecraft.level.biome.Hell;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Adds red creeper spawn!
 */
@Mixin(Hell.class)
public class MixinHell extends Biome {
    //@Inject(method = "<init>", at = @At("TAIL"))
    //private void addMobs(CallbackInfo ci)
    //{
     //   this.monsters.add(new EntityEntry(CreeperRed.class, 10));
    //}
}
