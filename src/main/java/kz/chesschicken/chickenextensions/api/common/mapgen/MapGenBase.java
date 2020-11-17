package kz.chesschicken.chickenextensions.api.common.mapgen;

import net.minecraft.level.Level;

import java.util.Random;

public class MapGenBase {
    protected int range = 8;
    protected Random rand = new Random();
    protected Level level;

    public void generate(Level level, int par3, int par4, byte[] par5ArrayOfByte)
    {
        int var6 = this.range;
        this.level = level;
        this.rand.setSeed(level.getSeed());
        long var7 = this.rand.nextLong();
        long var9 = this.rand.nextLong();

        for (int var11 = par3 - var6; var11 <= par3 + var6; ++var11)
        {
            for (int var12 = par4 - var6; var12 <= par4 + var6; ++var12)
            {
                long var13 = (long)var11 * var7;
                long var15 = (long)var12 * var9;
                this.rand.setSeed(var13 ^ var15 ^ level.getSeed());
                this.recursiveGenerate(var11, var12, par3, par4, par5ArrayOfByte);
            }
        }
    }

    protected void recursiveGenerate(int x1, int x2, int x3, int x4, byte[] x5) {}
}
