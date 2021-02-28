package kz.chesschicken.chickenextensions.mixin.overworld;

import kz.chesschicken.chickenextensions.content.overworld.OverworldListener;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.Item;
import net.minecraft.entity.animal.AnimalBase;
import net.minecraft.entity.animal.Cow;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import org.spongepowered.asm.mixin.Mixin;

/**
 * Adding cow meat drop!
 */
@Mixin(Cow.class)
public class MixinCowMeat extends AnimalBase {
    public MixinCowMeat(Level arg) { super(arg); }

    @Override
    public void onKilledBy(EntityBase arg) {
            Item lol = new Item(level, this.x, this.y, this.z, new ItemInstance(this.fire > 0 ? OverworldListener.itemSteakCooked() : OverworldListener.itemSteakRaw(), 1));
            level.spawnEntity(lol);
    }
}
