package kz.chesschicken.chickenextensions.mixin.common;

import kz.chesschicken.chickenextensions.api.common.RegisteringClass;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.Item;
import net.minecraft.entity.animal.AnimalBase;
import net.minecraft.entity.animal.Cow;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Cow.class)
public class MixinCowMeat extends AnimalBase {
    public MixinCowMeat(Level arg) { super(arg); }

    @Override
    public void onKilledBy(EntityBase arg) {
        Item lol = new Item(level, this.x, this.y, this.z, new ItemInstance(this.fire > 0 ? RegisteringClass.itemSteakCooked : RegisteringClass.itemSteakRaw, 1));
        level.spawnEntity(lol);
    }
}
