package kz.chesschicken.chickenextensions.api.structure;

import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;
import net.minecraft.level.structure.Structure;
import net.minecraft.util.maths.MathHelper;

import java.util.Random;

public class OreMeta extends Structure {
    private int field_283;
    private int field_284;
    private int curMeta;

    public OreMeta(int i, int meta, int j) {
        this.field_283 = i;
        this.field_284 = j;
        this.curMeta = meta;
    }

    public boolean generate(Level level, Random rand, int x, int y, int z) {
        float var6 = rand.nextFloat() * 3.1415927F;
        double var7 = (double)((float)(x + 8) + MathHelper.sin(var6) * (float)this.field_284 / 8.0F);
        double var9 = (double)((float)(x + 8) - MathHelper.sin(var6) * (float)this.field_284 / 8.0F);
        double var11 = (double)((float)(z + 8) + MathHelper.cos(var6) * (float)this.field_284 / 8.0F);
        double var13 = (double)((float)(z + 8) - MathHelper.cos(var6) * (float)this.field_284 / 8.0F);
        double var15 = (double)(y + rand.nextInt(3) + 2);
        double var17 = (double)(y + rand.nextInt(3) + 2);

        for(int var19 = 0; var19 <= this.field_284; ++var19) {
            double var20 = var7 + (var9 - var7) * (double)var19 / (double)this.field_284;
            double var22 = var15 + (var17 - var15) * (double)var19 / (double)this.field_284;
            double var24 = var11 + (var13 - var11) * (double)var19 / (double)this.field_284;
            double var26 = rand.nextDouble() * (double)this.field_284 / 16.0D;
            double var28 = (double)(MathHelper.sin((float)var19 * 3.1415927F / (float)this.field_284) + 1.0F) * var26 + 1.0D;
            double var30 = (double)(MathHelper.sin((float)var19 * 3.1415927F / (float)this.field_284) + 1.0F) * var26 + 1.0D;
            int var32 = MathHelper.floor(var20 - var28 / 2.0D);
            int var33 = MathHelper.floor(var22 - var30 / 2.0D);
            int var34 = MathHelper.floor(var24 - var28 / 2.0D);
            int var35 = MathHelper.floor(var20 + var28 / 2.0D);
            int var36 = MathHelper.floor(var22 + var30 / 2.0D);
            int var37 = MathHelper.floor(var24 + var28 / 2.0D);

            for(int var38 = var32; var38 <= var35; ++var38) {
                double var39 = ((double)var38 + 0.5D - var20) / (var28 / 2.0D);
                if (var39 * var39 < 1.0D) {
                    for(int var41 = var33; var41 <= var36; ++var41) {
                        double var42 = ((double)var41 + 0.5D - var22) / (var30 / 2.0D);
                        if (var39 * var39 + var42 * var42 < 1.0D) {
                            for(int var44 = var34; var44 <= var37; ++var44) {
                                double var45 = ((double)var44 + 0.5D - var24) / (var28 / 2.0D);
                                if (var39 * var39 + var42 * var42 + var45 * var45 < 1.0D && level.getTileId(var38, var41, var44) == BlockBase.STONE.id) {
                                    level.setTileWithMetadata(var38, var41, var44, this.field_283, curMeta);
                                }
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
