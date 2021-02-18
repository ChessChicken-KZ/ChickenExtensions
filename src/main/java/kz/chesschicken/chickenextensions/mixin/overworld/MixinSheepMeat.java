package kz.chesschicken.chickenextensions.mixin.overworld;


import kz.chesschicken.chickenextensions.content.overworld.OverworldBase;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.Item;
import net.minecraft.entity.animal.AnimalBase;
import net.minecraft.entity.animal.Sheep;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import org.spongepowered.asm.mixin.Mixin;

/**
 * Adding sheep meat drop!
 */
@Mixin(Sheep.class)
public class MixinSheepMeat extends AnimalBase {
    public MixinSheepMeat(Level arg) { super(arg); }

    @Override
    public void onKilledBy(EntityBase arg) {
        Item lol = new Item(level, this.x, this.y, this.z, new ItemInstance(this.fire > 0 ? OverworldBase.itemMuttonCooked() : OverworldBase.itemMuttonRaw(), 1));
        level.spawnEntity(lol);
    }
}
