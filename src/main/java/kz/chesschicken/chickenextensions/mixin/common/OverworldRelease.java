package kz.chesschicken.chickenextensions.mixin.common;

import kz.chesschicken.chickenextensions.ChickenMod;
import kz.chesschicken.chickenextensions.api.common.BiomeClass;
import kz.chesschicken.chickenextensions.api.common.mapgen.MapGenBase;
import kz.chesschicken.chickenextensions.api.common.mapgen.MapGenCaves;
import kz.chesschicken.chickenextensions.api.common.mapgen.MapGenRavine;
import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;
import net.minecraft.level.biome.Biome;
import net.minecraft.level.chunk.Chunk;
import net.minecraft.level.source.OverworldLevelSource;
import net.minecraft.util.maths.MathHelper;
import net.minecraft.util.noise.PerlinOctaveNoise;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(OverworldLevelSource.class)
public abstract class OverworldRelease {
    private final MapGenBase caveGenerator = new MapGenCaves();
    private final MapGenBase ravineGenerator = new MapGenRavine();
    float[] heightDoubleNOISE;

    @Shadow private Biome[] biomes;

    @Shadow private Level level;

    @Shadow private double[] noises;

    @Shadow protected abstract double[] calculateNoise(double[] noises, int chunkX, int chunkY, int chunkZ, int noiseResolutionX, int noiseResolutionY, int noiseResolutionZ);

    @Shadow private Random rand;

    @Shadow private PerlinOctaveNoise beachNoise;

    @Shadow private PerlinOctaveNoise surfaceDepthNoise;

    @Shadow private double[] surfaceDepthNoises;

    @Shadow public abstract void shapeChunk(int chunkX, int chunkZ, byte[] tiles, Biome[] biomes, double[] temperatures);

    @Shadow public abstract void buildSurface(int chunkX, int chunkZ, byte[] tiles, Biome[] biomes);

    @Shadow private PerlinOctaveNoise upperInterpolationNoise;

    @Shadow double[] upperInterpolationNoises;

    @Shadow double[] lowerInterpolationNoises;

    @Shadow private PerlinOctaveNoise lowerInterpolationNoise;

    @Shadow double[] interpolationNoises;

    @Shadow private PerlinOctaveNoise interpolationNoise;

    @Shadow private double[] sandNoises;

    @Shadow public PerlinOctaveNoise depthNoise;

    @Shadow double[] depthNoises;

    @Inject(method = "shapeChunk", at = @At("HEAD"), cancellable = true)
    private void shapeChunkSt(int par1, int par2, byte[] par3ArrayOfByte, Biome[] biomes, double[] temperatures, CallbackInfo ci)
    {
        if(ChickenMod.isCustomWorldGen) {
            byte var4 = 4;
            byte var5 = 16;
            byte var6 = 63;
            int var7 = var4 + 1;
            byte var8 = 17;
            int var9 = var4 + 1;
            this.biomes = this.level.getBiomeSource().getBiomes(this.biomes, par1 * 4 - 2, par2 * 4 - 2, var7 + 5, var9 + 5);
            this.noises = this.calculateNoise(this.noises, par1 * var4, 0, par2 * var4, var7, var8, var9);

            for (int var10 = 0; var10 < var4; ++var10) {
                for (int var11 = 0; var11 < var4; ++var11) {
                    for (int var12 = 0; var12 < var5; ++var12) {
                        double var13 = 0.125D;
                        double var15 = this.noises[((var10) * var9 + var11) * var8 + var12];
                        double var17 = this.noises[((var10) * var9 + var11 + 1) * var8 + var12];
                        double var19 = this.noises[((var10 + 1) * var9 + var11) * var8 + var12];
                        double var21 = this.noises[((var10 + 1) * var9 + var11 + 1) * var8 + var12];
                        double var23 = (this.noises[((var10) * var9 + var11) * var8 + var12 + 1] - var15) * var13;
                        double var25 = (this.noises[((var10) * var9 + var11 + 1) * var8 + var12 + 1] - var17) * var13;
                        double var27 = (this.noises[((var10 + 1) * var9 + var11) * var8 + var12 + 1] - var19) * var13;
                        double var29 = (this.noises[((var10 + 1) * var9 + var11 + 1) * var8 + var12 + 1] - var21) * var13;

                        for (int var31 = 0; var31 < 8; ++var31) {
                            double var32 = 0.25D;
                            double var34 = var15;
                            double var36 = var17;
                            double var38 = (var19 - var15) * var32;
                            double var40 = (var21 - var17) * var32;

                            for (int var42 = 0; var42 < 4; ++var42) {
                                int var43 = var42 + var10 * 4 << 11 | var11 * 4 << 7 | var12 * 8 + var31;
                                short var44 = 128;
                                var43 -= var44;
                                double var45 = 0.25D;
                                double var49 = (var36 - var34) * var45;
                                double var47 = var34 - var49;

                                for (int var51 = 0; var51 < 4; ++var51) {
                                    if ((var47 += var49) > 0.0D) {
                                        par3ArrayOfByte[var43 += var44] = (byte) BlockBase.STONE.id;
                                    } else if (var12 * 8 + var31 < var6) {
                                        par3ArrayOfByte[var43 += var44] = (byte) BlockBase.STILL_WATER.id;
                                    } else {
                                        par3ArrayOfByte[var43 += var44] = 0;
                                    }
                                }

                                var34 += var38;
                                var36 += var40;
                            }

                            var15 += var23;
                            var17 += var25;
                            var19 += var27;
                            var21 += var29;
                        }
                    }
                }
            }
            ci.cancel();
        }
    }

    @Inject(method = "buildSurface", at = @At("HEAD"), cancellable = true)
    private void buildSurfaceSt(int par1, int par2, byte[] par3ArrayOfByte, Biome[] par4ArrayOfBiomeGenBase, CallbackInfo ci)
    {
        if(ChickenMod.isCustomWorldGen) {

            byte var5 = 63;
            double var6 = 0.03125D;
            this.sandNoises = this.beachNoise.sample(this.sandNoises, par1 * 16, par2 * 16, 0, 16, 16, 1, var6 * 2.0D, var6 * 2.0D, var6 * 2.0D);

            for (int var8 = 0; var8 < 16; ++var8) {
                for (int var9 = 0; var9 < 16; ++var9) {
                    Biome var10 = par4ArrayOfBiomeGenBase[var9 + var8 * 16];
                    int var12 = (int) (this.sandNoises[var8 + var9 * 16] / 3.0D + 3.0D + this.rand.nextDouble() * 0.25D);
                    int var13 = -1;
                    byte var14 = var10.topTileId;
                    byte var15 = var10.underTileId;

                    for (int var16 = 127; var16 >= 0; --var16) {
                        int var17 = (var9 * 16 + var8) * 128 + var16;

                        if (var16 <= this.rand.nextInt(5)) {
                            par3ArrayOfByte[var17] = (byte) BlockBase.BEDROCK.id;
                        } else {
                            byte var18 = par3ArrayOfByte[var17];

                            if (var18 == 0) {
                                var13 = -1;
                            } else if (var18 == BlockBase.STONE.id) {
                                if (var13 == -1) {
                                    if (var12 <= 0) {
                                        var14 = 0;
                                        var15 = (byte) BlockBase.STONE.id;
                                    } else if (var16 >= var5 - 4 && var16 <= var5 + 1) {
                                        var14 = var10.topTileId;
                                        var15 = var10.underTileId;
                                    }

                                    if (var16 < var5 && var14 == 0) {
                                        var14 = (byte) BlockBase.STILL_WATER.id;
                                    }

                                    var13 = var12;

                                    if (var16 >= var5 - 1) {
                                        par3ArrayOfByte[var17] = var14;
                                    } else {
                                        par3ArrayOfByte[var17] = var15;
                                    }
                                } else if (var13 > 0) {
                                    --var13;
                                    par3ArrayOfByte[var17] = var15;

                                    if (var13 == 0 && var15 == BlockBase.SAND.id) {
                                        var13 = this.rand.nextInt(4);
                                        var15 = (byte) BlockBase.SANDSTONE.id;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ci.cancel();
        }
    }

    @Inject(method = "getChunk", at = @At("HEAD"), cancellable = true)
    private void getChunkSt(int par1, int par2, CallbackInfoReturnable<Chunk> cir)
    {
        if(ChickenMod.isCustomWorldGen) {
            this.rand.setSeed((long) par1 * 341873128712L + (long) par2 * 132897987541L);
            byte[] bytes = new byte[32768];
            this.shapeChunk(par1, par2, bytes, null, null);
            this.biomes = this.level.getBiomeSource().getBiomes(this.biomes, par1 * 16, par2 * 16, 16, 16);
            this.buildSurface(par1, par2, bytes, this.biomes);
            this.caveGenerator.generate(this.level, par1, par2, bytes);
            this.ravineGenerator.generate(this.level, par1, par2, bytes);

            Chunk chunk = new Chunk(this.level, bytes, par1, par2);
            chunk.generateHeightmap();
            cir.setReturnValue(chunk);
        }
    }

    @Inject(method = "calculateNoise", at = @At("HEAD"), cancellable = true)
    private void calculateNoiseST(double[] par1ArrayOfDouble, int x1, int x2, int x3, int x4, int x5, int x6, CallbackInfoReturnable<double[]> cir)
    {
        if(ChickenMod.isCustomWorldGen) {
            if (par1ArrayOfDouble == null) {
                par1ArrayOfDouble = new double[x4 * x5 * x6];
            }

            if (this.heightDoubleNOISE == null) {
                this.heightDoubleNOISE = new float[25];
                for (int q = -2; q <= 2; ++q) {
                    for (int var9 = -2; var9 <= 2; ++var9) {
                        float var10 = 10.0F / MathHelper.sqrt((float) (q * q + var9 * var9) + 0.2F);
                        this.heightDoubleNOISE[q + 2 + (var9 + 2) * 5] = var10;
                    }
                }
            }

            this.surfaceDepthNoises = this.surfaceDepthNoise.sample(this.surfaceDepthNoises, x1, x3, x4, x6, 1.121D, 1.121D, 0.5D);
            this.depthNoises = this.depthNoise.sample(this.depthNoises, x1, x3, x4, x6, 200.0D, 200.0D, 0.5D);
            this.interpolationNoises = this.interpolationNoise.sample(this.interpolationNoises, x1, x2, x3, x4, x5, x6, 684.412D / 80.0D, 684.412D / 160.0D, 684.412D / 80.0D);
            this.upperInterpolationNoises = this.upperInterpolationNoise.sample(this.upperInterpolationNoises, x1, x2, x3, x4, x5, x6, 684.412D, 684.412D, 684.412D);
            this.lowerInterpolationNoises = this.lowerInterpolationNoise.sample(this.lowerInterpolationNoises, x1, x2, x3, x4, x5, x6, 684.412D, 684.412D, 684.412D);
            int var12 = 0;
            int var13 = 0;

            for (int q1 = 0; q1 < x4; ++q1) {
                for (int q2 = 0; q2 < x6; ++q2) {
                    float var16 = 0.0F;
                    float var17 = 0.0F;
                    float var18 = 0.0F;
                    byte var19 = 2;
                    Biome var20 = this.biomes[q1 + 2 + (q2 + 2) * (x4 + 5)];

                    for (int q3 = -var19; q3 <= var19; ++q3) {
                        for (int q4 = -var19; q4 <= var19; ++q4) {
                            Biome var23 = this.biomes[q1 + q3 + 2 + (q2 + q4 + 2) * (x4 + 5)];
                            float var24 = this.heightDoubleNOISE[q3 + 2 + (q4 + 2) * 5] / (BiomeClass.minHeight.get(var23) + 2.0F);
                            if (BiomeClass.minHeight.get(var23) > BiomeClass.minHeight.get(var20)) {
                                var24 /= 2.0F;
                            }
                            var16 += BiomeClass.maxHeight.get(var23) * var24;
                            var17 += BiomeClass.minHeight.get(var23) * var24;
                            var18 += var24;
                        }
                    }
                    var16 /= var18;
                    var17 /= var18;
                    var16 = var16 * 0.9F + 0.1F;
                    var17 = (var17 * 4.0F - 1.0F) / 8.0F;
                    double var46 = this.depthNoises[var13] / 8000.0D;
                    if (var46 < 0.0D) {
                        var46 = -var46 * 0.3D;
                    }
                    var46 = var46 * 3.0D - 2.0D;
                    if (var46 < 0.0D) {
                        var46 /= 2.0D;

                        if (var46 < -1.0D) {
                            var46 = -1.0D;
                        }

                        var46 /= 1.4D;
                        var46 /= 2.0D;
                    } else {
                        if (var46 > 1.0D) {
                            var46 = 1.0D;
                        }

                        var46 /= 8.0D;
                    }
                    ++var13;

                    for (int var47 = 0; var47 < x5; ++var47) {
                        double var48 = var17;
                        var48 += var46 * 0.2D;
                        var48 = var48 * (double) x5 / 16.0D;
                        double var28 = (double) x5 / 2.0D + var48 * 4.0D;
                        double var30;
                        double var32 = ((double) var47 - var28) * 12.0D * 128.0D / 128.0D / (double) var16;
                        if (var32 < 0.0D) {
                            var32 *= 4.0D;
                        }
                        double var34 = this.upperInterpolationNoises[var12] / 512.0D;
                        double var36 = this.lowerInterpolationNoises[var12] / 512.0D;
                        double var38 = (this.interpolationNoises[var12] / 10.0D + 1.0D) / 2.0D;
                        if (var38 < 0.0D) {
                            var30 = var34;
                        } else if (var38 > 1.0D) {
                            var30 = var36;
                        } else {
                            var30 = var34 + (var36 - var34) * var38;
                        }
                        var30 -= var32;
                        if (var47 > x5 - 4) {
                            double var40 = (float) (var47 - (x5 - 4)) / 3.0F;
                            var30 = var30 * (1.0D - var40) + -10.0D * var40;
                        }
                        par1ArrayOfDouble[var12] = var30;
                        ++var12;
                    }
                }
            }

            cir.setReturnValue(par1ArrayOfDouble);
        }
    }


}
