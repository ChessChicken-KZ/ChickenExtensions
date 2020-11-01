package kz.chesschicken.chickenextensions.block.extensions;

import kz.chesschicken.chickenextensions.api.RegisteringClass;
import net.minecraft.item.ItemInstance;
import net.minecraft.item.PlaceableTileEntity;
import net.modificationstation.stationloader.api.common.preset.item.PlaceableTileEntityWithMeta;

public class TileItemExtended extends PlaceableTileEntity implements PlaceableTileEntityWithMeta {
    public int getMetaData(int i) {
        return i;
    }

    public String getTranslationKey(ItemInstance item) {
        return getTranslationKey() + item.getDamage();
    }

    public TileItemExtended(int i) {
        super(i);
        this.setDurability(0);
        this.setHasSubItems(true);
    }

    @Override
    public int getTexturePosition(int damage) {
        return RegisteringClass.fenceExtended.getTextureForSide(0, damage);
    }
}
