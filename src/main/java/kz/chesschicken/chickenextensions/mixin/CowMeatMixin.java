package kz.chesschicken.chickenextensions.mixin;

import kz.chesschicken.chickenextensions.api.RegisteringClass;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.Item;
import net.minecraft.entity.animal.AnimalBase;
import net.minecraft.entity.animal.Cow;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Random;

@Mixin(Cow.class)
public class CowMeatMixin extends AnimalBase {
    public CowMeatMixin(Level arg) { super(arg); }

    @Override
    public void onKilledBy(EntityBase arg) {
        Item lol = new Item(level, this.x, this.y, this.z, new ItemInstance(this.fire > 0 ? RegisteringClass.itemSteakCooked : RegisteringClass.itemSteakRaw, (new Random()).nextInt(3)));
        level.spawnEntity(lol);
    }
}