package kz.chesschicken.chickenextensions.block.colour;

import kz.chesschicken.chickenextensions.ChickenMod;
import kz.chesschicken.chickenextensions.api.RegisteringClass;
import net.minecraft.block.Plant;
import net.minecraft.item.PlaceableTileEntity;
import net.minecraft.level.TileView;
import net.modificationstation.stationloader.api.common.block.BlockItemProvider;

import java.util.Random;

public class TileBlockColour_Flower extends Plant implements BlockItemProvider {
    public TileBlockColour_Flower(int id) {
        super(id, ChickenMod.textColourFlower);
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        return ChickenMod.textColourFlower;
    }

    @Override
    public int getColor(TileView arg, int x, int y, int z) {
        return ChickenMod.INSTANCE.get16ColorCode(arg.getTileMeta(x, y, z));
    }

    @Override
    public int getDropId(int meta, Random rand) { return RegisteringClass.blockFlowerC.id; }

    public PlaceableTileEntity getBlockItem(int i) {
        return new TileItemColour_Flower(i);
    }

    protected int droppedMeta(int i) {
        return i;
    }
}
