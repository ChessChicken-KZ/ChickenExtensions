package kz.chesschicken.chickenextensions.block.colour;

import kz.chesschicken.chickenextensions.ChickenMod;
import kz.chesschicken.chickenextensions.api.common.BiomeClass;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemInstance;
import net.minecraft.item.PlaceableTileEntity;

public class TileItemColour_Flower extends PlaceableTileEntity {
    public TileItemColour_Flower(int i) {
        super(i);
        this.setDurability(0);
        this.setHasSubItems(true);
    }

    public int getMetaData(int i) {
        return i;
    }

    @Environment(EnvType.CLIENT)
    public String getTranslationKey(ItemInstance item) {
        return getTranslationKey() + item.getDamage();
    }

    @Environment(EnvType.CLIENT)
    public int getTexturePosition(int damage) {
        return ChickenMod.textColourFlower;
    }

    @Override public int getNameColour(int i) { return BiomeClass.get16ColorCode(i); }
}
