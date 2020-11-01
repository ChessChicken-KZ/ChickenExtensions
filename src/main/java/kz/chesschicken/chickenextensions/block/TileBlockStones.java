package kz.chesschicken.chickenextensions.block;

import net.minecraft.item.ItemInstance;
import net.minecraft.item.PlaceableTileEntity;


public class TileBlockStones extends PlaceableTileEntity {
    public int getMetaData(int i) {
        return i;
    }

    public String getTranslationKey(ItemInstance item) {
        return getTranslationKey() + item.getDamage();
    }

    public TileBlockStones(int i) {
        super(i);
        this.setDurability(0);
        this.setHasSubItems(true);
    }


}