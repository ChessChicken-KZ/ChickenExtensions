package kz.chesschicken.chickenextensions.api;

public enum ExtendedMaterialEnum {
    //WOOD(0, 59, 2.0F, 0),
    //STONE(1, 131, 4.0F, 1),
    //IRON(2, 250, 6.0F, 2),
    //EMERALD(3, 1561, 8.0F, 3),
    //GOLD(0, 32, 12.0F, 0);
    RUBY(3, 1561, 8.0F, 3),
    SAPHIRE(3, 1561, 8.0F, 3),
    COPPER(1, 250, 5.0F, 2);

    private final int miningLevel;
    private final int durability;
    private final float miningSpeed;
    private final int attackDamage;

    ExtendedMaterialEnum(int miningLevel, int durability, float miningSpeed, int attackDamage) {
        this.miningLevel = miningLevel;
        this.durability = durability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
    }

    public int getDurability() {
        return this.durability;
    }

    public float getMiningSpeed() {
        return this.miningSpeed;
    }

    public int getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

}
