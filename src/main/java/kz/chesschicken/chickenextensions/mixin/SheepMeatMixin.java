package kz.chesschicken.chickenextensions.mixin;

import kz.chesschicken.chickenextensions.api.common.RegisteringClass;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.Item;
import net.minecraft.entity.animal.AnimalBase;
import net.minecraft.entity.animal.Sheep;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Random;

@Mixin(Sheep.class)
public class SheepMeatMixin extends AnimalBase {
    public SheepMeatMixin(Level arg) { super(arg); }

    @Override
    public void onKilledBy(EntityBase arg) {
        Item lol = new Item(level, this.x, this.y, this.z, new ItemInstance(this.fire > 0 ? RegisteringClass.itemMuttonCooked : RegisteringClass.itemMuttonRaw, (new Random()).nextInt(3)));
        level.spawnEntity(lol);
    }
}
