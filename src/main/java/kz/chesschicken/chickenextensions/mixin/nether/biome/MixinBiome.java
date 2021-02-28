package kz.chesschicken.chickenextensions.mixin.nether.biome;

//import kz.chesschicken.goldenfeaturessap.content.overworld.entity.CreeperBlue;
import net.minecraft.entity.EntityEntry;
import net.minecraft.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

/**
 * Adds blue creeper spawn!
 */
@Mixin(Biome.class)
public class MixinBiome {
    @Shadow protected List monsters;

    //@Inject(method = "<init>", at = @At("TAIL"))
    //private void addMobs(CallbackInfo ci)
    //{
    //    this.monsters.add(new EntityEntry(CreeperBlue.class, 10));
    //}

}
