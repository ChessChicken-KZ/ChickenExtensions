package kz.chesschicken.chickenextensions.mixin.nether;


import net.minecraft.block.BlockBase;
import net.minecraft.block.Sand;
import net.minecraft.level.Level;
import net.minecraft.level.biome.Biome;
import net.minecraft.level.chunk.Chunk;
import net.minecraft.level.source.LevelSource;
import net.minecraft.level.source.NetherLevelSource;
import net.minecraft.level.structure.Cactus;
import net.minecraft.util.noise.PerlinOctaveNoise;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

/**
 * Adds multiple biomes support - generator;
 */
@Mixin(NetherLevelSource.class)
public abstract class NetherGenerator implements LevelSource {

    @Shadow private double[] field_1352;

    @Shadow private double[] field_1353;

    @Shadow private double[] field_1354;

    @Shadow private PerlinOctaveNoise field_1348;

    @Shadow private PerlinOctaveNoise field_1349;

    @Shadow private Random rand;

    @Shadow private Level level;

    private Biome[] arrayBiome_CUSTOM;

    @Inject(method = "generate", at = @At("HEAD"), cancellable = true)
    private void biomeInject(int par1, int par2, byte[] par3ArrayOfByte, CallbackInfo ci)
    {

        byte b0 = 32;
        double d0 = 0.03125D;
        field_1352 = field_1348.sample(field_1352, par1 * 16, par2 * 16, 0, 16, 16, 1, d0, d0, 1.0D);
        field_1353 = field_1348.sample(field_1353, par1 * 16, 109, par2 * 16, 16, 1, 16, d0, 1.0D, d0);
        field_1354 = field_1349.sample(field_1354, par1 * 16, par2 * 16, 0, 16, 16, 1, d0 * 2.0D, d0 * 2.0D, d0 * 2.0D);

        for (int k = 0; k < 16; ++k)
        {
            for (int l = 0; l < 16; ++l)
            {
                Biome biomeCurrent = arrayBiome_CUSTOM[l + k * 16];

                boolean flag = field_1352[k + l * 16] + rand.nextDouble() * 0.2D > 0.0D;
                boolean flag1 = field_1353[k + l * 16] + rand.nextDouble() * 0.2D > 0.0D;
                int i1 = (int)(field_1354[k + l * 16] / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
                int j1 = -1;
                byte b1 = biomeCurrent.topTileId;
                byte b2 = biomeCurrent.underTileId;

                for (int k1 = 127; k1 >= 0; --k1)
                {
                    int l1 = (l * 16 + k) * 128 + k1;

                    if (k1 < 127 - rand.nextInt(5) && k1 > 0 + rand.nextInt(5))
                    {
                        byte b3 = par3ArrayOfByte[l1];

                        if (b3 == 0)
                        {
                            j1 = -1;
                        }
                        else if (b3 == BlockBase.NETHERRACK.id)
                        {
                            if (j1 == -1)
                            {
                                if (i1 <= 0)
                                {
                                    b1 = 0;
                                    b2 = (byte)BlockBase.NETHERRACK.id;
                                }
                                else if (k1 >= b0 - 4 && k1 <= b0 + 1)
                                {
                                    b1 = (byte)BlockBase.NETHERRACK.id;
                                    b2 = (byte)BlockBase.NETHERRACK.id;

                                    if (flag1)
                                    {
                                        b1 = (byte)BlockBase.SAND.id;
                                    }

                                    if (flag1)
                                    {
                                        b2 = (byte)BlockBase.NETHERRACK.id;
                                    }

                                    if (flag)
                                    {
                                        b1 = (byte) BlockBase.SOUL_SAND.id;
                                    }

                                    if (flag)
                                    {
                                        b2 = (byte) BlockBase.SOUL_SAND.id;
                                    }
                                }

                                if (k1 < b0 && b1 == 0)
                                {
                                    b1 = (byte)BlockBase.STILL_LAVA.id;
                                }

                                j1 = i1;

                                if (k1 >= b0 - 1)
                                {
                                    par3ArrayOfByte[l1] = b1;
                                }
                                else
                                {
                                    par3ArrayOfByte[l1] = b2;
                                }
                            }
                            else if (j1 > 0)
                            {
                                --j1;
                                par3ArrayOfByte[l1] = b2;
                            }
                        }
                    }
                    else
                    {
                        par3ArrayOfByte[l1] = (byte)BlockBase.BEDROCK.id;
                    }
                }
            }
        }
        ci.cancel();
    }

    @Inject(method = "getChunk", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/level/source/NetherLevelSource;method_1180(II[B)V",
            shift = At.Shift.BEFORE
    ))
    private void lmao(int chunkX, int chunkZ, CallbackInfoReturnable<Chunk> cir)
    {
        this.arrayBiome_CUSTOM = this.level.getBiomeSource().getBiomes(this.arrayBiome_CUSTOM, chunkX * 16, chunkZ * 16, 16, 16);
    }

    @Inject(method = "decorate", at = @At("TAIL"), cancellable = true)
    private void decor(LevelSource levelSource, int chunkX, int chunkZ, CallbackInfo ci)
    {
        Sand.fallInstantly = true;
        int var4 = chunkX * 16;
        int var5 = chunkZ * 16;
        Biome var6 = this.level.getBiomeSource().getBiome(var4 + 16, var5 + 16);
        int desertCHANCE = 0;
        if (var6 == NetherBase.SOUL_DESERT)
            desertCHANCE += 10;

        for(int var25 = 0; var25 < desertCHANCE; ++var25) {
            int x = var4 + this.rand.nextInt(16) + 8;
            int y = this.rand.nextInt(128);
            int z = var5 + this.rand.nextInt(16) + 8;
            (new Cactus()).generate(this.level, this.rand, x, y, z);
        }

        Sand.fallInstantly = false;
    }

}
