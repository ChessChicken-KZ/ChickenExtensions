package kz.chesschicken.chickenextensions.item.goldenegg;

import kz.chesschicken.chickenextensions.api.RegisteringClass;
import net.minecraft.entity.animal.Chicken;
import net.minecraft.level.Level;

public class GoldenChicken extends Chicken {
    public GoldenChicken(Level arg) {
        super(arg);
        this.texture = "/assets/chickenextensions/textures/entity/animal/chickenGold.png";
        this.setSize(0.3F, 0.4F);
        this.health = 8;
        this.field_2165 = this.rand.nextInt(12000) + 6000;
    }
    @Override
    public void updateDespawnCounter() {
        super.updateDespawnCounter();
        this.field_2163 = this.field_2160;
        this.field_2162 = this.field_2161;
        this.field_2161 = (float)((double)this.field_2161 + (double)(this.onGround ? -1 : 4) * 0.3D);
        if (this.field_2161 < 0.0F) {
            this.field_2161 = 0.0F;
        }

        if (this.field_2161 > 1.0F) {
            this.field_2161 = 1.0F;
        }

        if (!this.onGround && this.field_2164 < 1.0F) {
            this.field_2164 = 1.0F;
        }

        this.field_2164 = (float)((double)this.field_2164 * 0.9D);
        if (!this.onGround && this.velocityY < 0.0D) {
            this.velocityY *= 0.6D;
        }

        this.field_2160 += this.field_2164 * 2.0F;
        if (!this.level.isClient && --this.field_2165 <= 0) {
            this.level.playSound(this, "mob.chickenplop", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(RegisteringClass.itemEggGold.id, 1);
            this.field_2165 = this.rand.nextInt(12000) + 6000;
        }

    }

}
