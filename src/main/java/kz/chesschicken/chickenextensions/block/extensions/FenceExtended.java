package kz.chesschicken.chickenextensions.block.extensions;

import kz.chesschicken.chickenextensions.ChickenMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.item.PlaceableTileEntity;
import net.minecraft.level.Level;
import net.minecraft.util.maths.Box;
import net.modificationstation.stationloader.api.common.block.BlockItemProvider;

public class FenceExtended extends BlockBase implements BlockItemProvider {
    public FenceExtended(int i) {
        super(i, Material.STONE);
        this.setHardness(2.0F);
        this.setBlastResistance(5.0F);
        this.sounds(STONE_SOUNDS);
        this.disableNotifyOnMetaDataChange();
    }

    public boolean canPlaceAt(Level level, int x, int y, int z) {
        if (level.getTileId(x, y - 1, z) == this.id) {
            return true;
        } else {
            return level.getMaterial(x, y - 1, z).isSolid() && super.canPlaceAt(level, x, y, z);
        }
    }

    public Box getCollisionShape(Level level, int x, int y, int z) {
        return Box.method_94((double)x, (double)y, (double)z, (double)(x + 1), (double)((float)y + 1.5F), (double)(z + 1));
    }

    public int getTextureForSide(int side, int meta) {
        switch (meta)
        {
            case 0:
                return BlockBase.NETHERRACK.texture;
            case 1:
                return BlockBase.MOSSY_COBBLESTONE.texture;
            case 2:
                return BlockBase.BRICK.texture;
            case 3:
                return BlockBase.COBBLESTONE.texture;
            case 4:
                return ChickenMod.texBrickSoul_BLOCK;
            case 5:
                return ChickenMod.texBrickSoul_BLOCK1;
            case 6:
                return ChickenMod.texBrickNether;
            case 7:
                return ChickenMod.texBrickNormal0;
            case 8:
                return BlockBase.STONE.texture;
            case 9:
                return 176;
            case 10:
                return BlockBase.STONE_SLAB.getTextureForSide(0);
            default:
                return 1;
        }
    }


    public boolean isFullOpaque() {
        return false;
    }

    public boolean isFullCube() {
        return false;
    }

    @Environment(EnvType.CLIENT)
    public int method_1621() {
        return 11;
    }

    @Override
    public PlaceableTileEntity getBlockItem(int i) {
        return new TileItemExtended(i);
    }


    protected int droppedMeta(int i) {
        return i;
    }
}

