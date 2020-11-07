package kz.chesschicken.chickenextensions.item.tool;

import net.minecraft.item.ItemInstance;
import net.minecraft.item.armour.Armour;
import net.modificationstation.stationloader.api.client.item.ArmorTextureProvider;

public class ArmourExtended extends Armour implements ArmorTextureProvider {
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
    private final int type;

    public ArmourExtended(int id, int j, int k, int slot, int armorType) {
        super(id, j, k, slot);
        this.field_2082 = j;
        this.armourSlot = slot;
        this.field_2085 = k;
        this.field_2084 = field_2086[slot];
        this.setDurability(BASE_DURABILITY[slot] * 3 << j);
        this.maxStackSize = 1;
        this.type = armorType;
    }

    @Override
    public String getChestplateModelTexture(ItemInstance itemInstance) {
        switch (type)
        {
            case 0:
                return "/assets/chickenextensions/textures/armor/copper_2.png";
            case 1:
                return "/assets/chickenextensions/textures/armor/ruby_2.png";
            case 2:
                return "/assets/chickenextensions/textures/armor/saphire_2.png";
            default:
                return null;
        }
    }

    @Override
    public String getOtherModelTexture(ItemInstance itemInstance) {
        switch (type)
        {
            case 0:
                return "/assets/chickenextensions/textures/armor/copper_1.png";
            case 1:
                return "/assets/chickenextensions/textures/armor/ruby_1.png";
            case 2:
                return "/assets/chickenextensions/textures/armor/saphire_1.png";
            default:
                return null;
        }
    }


}
