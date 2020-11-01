package kz.chesschicken.chickenextensions.block.extensions;

import kz.chesschicken.chickenextensions.ChickenMod;
import kz.chesschicken.chickenextensions.api.RegisteringClass;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.item.PlaceableTileEntity;
import net.minecraft.level.Level;
import net.minecraft.level.TileView;
import net.modificationstation.stationloader.api.common.block.BlockItemProvider;

import java.util.Random;

public class SlabsExtended extends BlockBase implements BlockItemProvider {
    private boolean field_2324;

    public SlabsExtended(int i, boolean flag) {
        super(i, 6, Material.STONE);
        this.field_2324 = flag;
        if (!flag) {
            this.setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        }
        this.setHardness(2.0F);
        this.setBlastResistance(10.0F);
        this.sounds(PISTON_SOUNDS);
        this.setLightOpacity(255);
    }

    public int getTextureForSide(int side, int meta) {
        switch (meta) {
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

    public int getTextureForSide(int side) {
        return this.getTextureForSide(side, 0);
    }

    public boolean isFullOpaque() {
        return this.field_2324;
    }

    public void onBlockPlaced(Level level, int x, int y, int z) {
        if (this != RegisteringClass.extendedSlabs) {
            super.onBlockPlaced(level, x, y, z);
        }

        int var5 = level.getTileId(x, y - 1, z);
        int var6 = level.getTileMeta(x, y, z);
        int var7 = level.getTileMeta(x, y - 1, z);
        if (var6 == var7) {
            if (var5 == RegisteringClass.extendedSlabs.id) {
                level.setTile(x, y, z, 0);
                level.placeBlockWithMetaData(x, y - 1, z, RegisteringClass.extendedDoubleSlabs.id, var6);
            }

        }
    }

    public int getDropId(int meta, Random rand) {
        return RegisteringClass.extendedSlabs.id;
    }

    public int getDropCount(Random rand) {
        return this.field_2324 ? 2 : 1;
    }

    protected int droppedMeta(int i) {
        return i;
    }

    public boolean isFullCube() {
        return this.field_2324;
    }

    @Environment(EnvType.CLIENT)
    public boolean method_1618(TileView arg, int i, int j, int k, int i1) {
        if (this != RegisteringClass.extendedSlabs) {
            super.method_1618(arg, i, j, k, i1);
        }

        if (i1 == 1) {
            return true;
        } else if (!super.method_1618(arg, i, j, k, i1)) {
            return false;
        } else if (i1 == 0) {
            return true;
        } else {
            return arg.getTileId(i, j, k) != this.id;
        }
    }

    @Override
    public PlaceableTileEntity getBlockItem(int i) {
        return new TileItemExtended(i);
    }
}