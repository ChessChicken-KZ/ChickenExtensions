package kz.chesschicken.chickenextensions.block;

import kz.chesschicken.chickenextensions.ChickenMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.level.Level;
import net.minecraft.util.maths.Box;

import java.util.Random;

public class BlockCeilingLamp extends BlockBase {
    public BlockCeilingLamp(int id) {
        super(id, Material.PLANT);
        this.setHardness(0.0F);
        this.setLightEmittance(0.9375F);
        this.sounds(WOOD_SOUNDS);
        this.disableNotifyOnMetaDataChange();
    }

    public boolean canPlaceAt(Level level, int x, int y, int z) {
        return super.canPlaceAt(level, x, y, z) && !level.isAir(x,y+1,z);
    }
    public void onScheduledTick(Level level, int x, int y, int z, Random rand) {
        this.method_1684(level, x, y, z);
    }

    protected final void method_1684(Level arg, int i, int j, int k) {
        if (!canPlaceAt(arg, i, j, k)) {
            this.drop(arg, i, j, k, arg.getTileMeta(i, j, k));
            arg.setTile(i, j, k, 0);
        }
    }


    public Box getCollisionShape(Level level, int x, int y, int z) {
        return null;
    }

    public boolean isFullOpaque() {
        return false;
    }

    public boolean isFullCube() {
        return false;
    }

    @Environment(EnvType.CLIENT)
    public int method_1621() {
        return 1;
    }
}