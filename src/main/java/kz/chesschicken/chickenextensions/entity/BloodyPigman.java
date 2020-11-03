package kz.chesschicken.chickenextensions.entity;

import net.minecraft.entity.monster.ZombiePigman;
import net.minecraft.level.Level;

public class BloodyPigman extends ZombiePigman {
    public BloodyPigman(Level arg) {
        super(arg);
        this.texture = "/assets/chickenextensions/textures/entity/nether/pigmanBlood.png";
        this.movementSpeed = 0.5F;
        this.attackDamage = 5;
        this.immuneToFire = true;
    }
}
