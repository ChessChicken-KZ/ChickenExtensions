package kz.chesschicken.chickenextensions.block.furniture;

import kz.chesschicken.chickenextensions.ChickenMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.level.TileView;
import net.minecraft.tileentity.TileEntityBase;

import java.util.Random;

public class BlockCorpseBox extends BlockContainerFurniture{
    public BlockCorpseBox(int id) {
        super(id);
    }

    @Environment(EnvType.CLIENT)
    public int method_1626(TileView arg, int i, int j, int k, int i1) {
        return ChickenMod.texLocker;
    }
    @Override
    public int getTextureForSide(int side) {
        return ChickenMod.texLocker;
    }

    protected TileEntityBase createTileEntity() {
        return new TileCorpseBox();
    }

    @Override
    public int getDropId(int meta, Random rand) {
        return 0;
    }
}
