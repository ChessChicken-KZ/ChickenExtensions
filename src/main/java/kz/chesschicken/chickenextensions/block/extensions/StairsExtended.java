package kz.chesschicken.chickenextensions.block.extensions;

import kz.chesschicken.chickenextensions.ChickenMod;
import kz.chesschicken.chickenextensions.api.common.RegisteringClass;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Living;
import net.minecraft.level.Level;
import net.minecraft.level.TileView;
import net.minecraft.util.maths.Box;
import net.minecraft.util.maths.MathHelper;

import java.util.ArrayList;
import java.util.Random;

public class StairsExtended extends BlockBase {
    private int newDID;

    public StairsExtended(int i, int q, int getNewDid) {
        super(i, q, Material.STONE);
        this.newDID = getNewDid;
        this.setHardness(2.0F);
        this.setBlastResistance(10.0F);
        this.sounds(PISTON_SOUNDS);
        this.setLightOpacity(255);
    }

    public void method_1616(TileView arg, int i, int j, int k) {
        this.setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public Box getCollisionShape(Level level, int x, int y, int z) {
        return super.getCollisionShape(level, x, y, z);
    }

    public boolean isFullOpaque() {
        return false;
    }

    public boolean isFullCube() {
        return false;
    }

    @Environment(EnvType.CLIENT)
    public int method_1621() {
        return 10;
    }

    @Environment(EnvType.CLIENT)
    public boolean method_1618(TileView arg, int i, int j, int k, int i1) {
        return super.method_1618(arg, i, j, k, i1);
    }

    public void method_1562(Level arg, int i, int j, int k, Box arg1, ArrayList arrayList) {
        int var7 = arg.getTileMeta(i, j, k);
        if (var7 == 0) {
            this.setBoundingBox(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 1.0F);
            super.method_1562(arg, i, j, k, arg1, arrayList);
            this.setBoundingBox(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.method_1562(arg, i, j, k, arg1, arrayList);
        } else if (var7 == 1) {
            this.setBoundingBox(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
            super.method_1562(arg, i, j, k, arg1, arrayList);
            this.setBoundingBox(0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            super.method_1562(arg, i, j, k, arg1, arrayList);
        } else if (var7 == 2) {
            this.setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 0.5F);
            super.method_1562(arg, i, j, k, arg1, arrayList);
            this.setBoundingBox(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
            super.method_1562(arg, i, j, k, arg1, arrayList);
        } else if (var7 == 3) {
            this.setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
            super.method_1562(arg, i, j, k, arg1, arrayList);
            this.setBoundingBox(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
            super.method_1562(arg, i, j, k, arg1, arrayList);
        }

        this.setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }




    public int getDropId(int meta, Random rand) {
        return this.newDID;
    }


    public int getTextureForSide(int side, int meta) {
        return getTextureNew();
    }

    public int getTextureForSide(int side) {
        return getTextureNew();
    }

    private int getTextureNew()
    {
        if(id == RegisteringClass.soulBrickStairs.id)
            return ChickenMod.texBrickSoul_BLOCK;
        else if(id == RegisteringClass.mossySoulBrickStairs.id)
            return ChickenMod.texBrickSoul_BLOCK1;
        else if(id == RegisteringClass.netherBrickStairs.id)
            return ChickenMod.texBrickNether;
        else if(id == RegisteringClass.normalBrickStairs.id)
            return ChickenMod.texBrickNormal0;
        else
            return texture;
    }


    @Override
    protected int droppedMeta(int i) {
        if(this.id == RegisteringClass.mossySoulBrickStairs.id)
            return 1;
        else if(this.id == RegisteringClass.netherBrickStairs.id)
            return 2;
        else if(this.id == RegisteringClass.normalBrickStairs.id)
            return 3;
        else return 0;
    }

    public void onBlockPlaced(Level level, int x, int y, int z) {
        this.onAdjacentBlockUpdate(level, x, y, z, 0);
    }


    public void afterPlaced(Level arg, int i, int j, int k, Living arg1) {
        int var6 = MathHelper.floor((double)(arg1.yaw * 4.0F / 360.0F) + 0.5D) & 3;
        if (var6 == 0) {
            arg.setTileMeta(i, j, k, 2);
        }

        if (var6 == 1) {
            arg.setTileMeta(i, j, k, 1);
        }

        if (var6 == 2) {
            arg.setTileMeta(i, j, k, 3);
        }

        if (var6 == 3) {
            arg.setTileMeta(i, j, k, 0);
        }

    }
}
