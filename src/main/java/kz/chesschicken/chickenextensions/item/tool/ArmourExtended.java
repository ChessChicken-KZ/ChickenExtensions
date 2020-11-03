package kz.chesschicken.chickenextensions.item.tool;

import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.armour.Armour;
import net.modificationstation.stationloader.impl.common.entity.player.PlayerAPI;

public class ArmourExtended extends Armour {
    //INFO
    /*
     * COPPER - 16
     * TIN - 16
     * BRONZE - 15
     */
    private static final int[] field_2086 = new int[]{3, 8, 6, 3};
    private static final int[] BASE_DURABILITY = new int[]{11, 16, 15, 13};
    public final int field_2082;
    public final int armourSlot;
    public final int field_2084;
    public final int field_2085;

    public ArmourExtended(int id, int j, int k, int slot) {
        super(id, j, k, slot);
        this.field_2082 = j;
        this.armourSlot = slot;
        this.field_2085 = k;
        this.field_2084 = field_2086[slot];
        this.setDurability(BASE_DURABILITY[slot] * 3 << j);
        this.maxStackSize = 1;
    }
}
