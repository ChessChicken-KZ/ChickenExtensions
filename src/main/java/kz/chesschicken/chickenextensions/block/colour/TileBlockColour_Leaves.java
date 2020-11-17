package kz.chesschicken.chickenextensions.block.colour;

import kz.chesschicken.chickenextensions.ChickenMod;
import kz.chesschicken.chickenextensions.api.common.BiomeClass;
import kz.chesschicken.chickenextensions.api.common.RegisteringClass;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.item.PlaceableTileEntity;
import net.minecraft.level.Level;
import net.minecraft.level.TileView;
import net.minecraft.stat.Stats;
import net.modificationstation.stationloader.api.common.block.BlockItemProvider;

import java.util.Random;

public class TileBlockColour_Leaves extends net.minecraft.class_307 implements BlockItemProvider {

    int[] field_1171;

    public TileBlockColour_Leaves(int i) {
        super(i, ChickenMod.textColourLeaves_Fast, Material.LEAVES, false);
        this.setTicksRandomly(true);
        this.setHardness(0.2F);
        this.setLightOpacity(1);
        this.sounds(GRASS_SOUNDS);
        this.disableStat();
        this.disableNotifyOnMetaDataChange();
        this.setTicksRandomly(true);
    }


    public PlaceableTileEntity getBlockItem(int i) {
        return new TileItemColour_Leaves(i);
    }

    @Environment(EnvType.CLIENT)
    public int method_1589(int i) {
        return BiomeClass.get16ColorCode(i);
    }

    @Environment(EnvType.CLIENT)
    public int getColor(TileView arg, int x, int y, int z) {
        return BiomeClass.get16ColorCode(arg.getTileMeta(x,y,z));
    }

    public void onBlockRemoved(Level level, int x, int y, int z) {
        byte var5 = 1;
        int var6 = var5 + 1;
        if (level.method_155(x - var6, y - var6, z - var6, x + var6, y + var6, z + var6)) {
            for(int var7 = -var5; var7 <= var5; ++var7) {
                for(int var8 = -var5; var8 <= var5; ++var8) {
                    for(int var9 = -var5; var9 <= var5; ++var9) {
                        int var10 = level.getTileId(x + var7, y + var8, z + var9);
                        if (var10 == RegisteringClass.blockLeavesC.id) {
                            int var11 = level.getTileMeta(x + var7, y + var8, z + var9);
                            level.method_223(x + var7, y + var8, z + var9, var11);
                        }
                    }
                }
            }
        }

    }

    public void onScheduledTick(Level level, int x, int y, int z, Random rand) {
        if (!level.isClient) {
            int var6 = level.getTileMeta(x, y, z);
            if ((var6 & 8) != 0) {
                byte var7 = 4;
                int var8 = var7 + 1;
                byte var9 = 32;
                int var10 = var9 * var9;
                int var11 = var9 / 2;
                if (this.field_1171 == null) {
                    this.field_1171 = new int[var9 * var9 * var9];
                }

                int var12;
                if (level.method_155(x - var8, y - var8, z - var8, x + var8, y + var8, z + var8)) {
                    var12 = -var7;

                    label111:
                    while(true) {
                        int var13;
                        int var14;
                        int var15;
                        if (var12 > var7) {
                            var12 = 1;

                            while(true) {
                                if (var12 > 4) {
                                    break label111;
                                }

                                for(var13 = -var7; var13 <= var7; ++var13) {
                                    for(var14 = -var7; var14 <= var7; ++var14) {
                                        for(var15 = -var7; var15 <= var7; ++var15) {
                                            if (this.field_1171[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11] == var12 - 1) {
                                                if (this.field_1171[(var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var15 + var11] == -2) {
                                                    this.field_1171[(var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var15 + var11] = var12;
                                                }

                                                if (this.field_1171[(var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var15 + var11] == -2) {
                                                    this.field_1171[(var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var15 + var11] = var12;
                                                }

                                                if (this.field_1171[(var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var15 + var11] == -2) {
                                                    this.field_1171[(var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var15 + var11] = var12;
                                                }

                                                if (this.field_1171[(var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var15 + var11] == -2) {
                                                    this.field_1171[(var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var15 + var11] = var12;
                                                }

                                                if (this.field_1171[(var13 + var11) * var10 + (var14 + var11) * var9 + (var15 + var11 - 1)] == -2) {
                                                    this.field_1171[(var13 + var11) * var10 + (var14 + var11) * var9 + (var15 + var11 - 1)] = var12;
                                                }

                                                if (this.field_1171[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11 + 1] == -2) {
                                                    this.field_1171[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11 + 1] = var12;
                                                }
                                            }
                                        }
                                    }
                                }

                                ++var12;
                            }
                        }

                        for(var13 = -var7; var13 <= var7; ++var13) {
                            for(var14 = -var7; var14 <= var7; ++var14) {
                                var15 = level.getTileId(x + var12, y + var13, z + var14);
                                if (var15 == BlockBase.LOG.id) {
                                    this.field_1171[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = 0;
                                } else if (var15 == RegisteringClass.blockLeavesC.id) {
                                    this.field_1171[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -2;
                                } else {
                                    this.field_1171[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -1;
                                }
                            }
                        }

                        ++var12;
                    }
                }

                var12 = this.field_1171[var11 * var10 + var11 * var9 + var11];
                if (var12 >= 0) {
                    level.method_223(x, y, z, var6);
                } else {
                    this.method_990(level, x, y, z);
                }
            }

        }
    }

    private void method_990(Level arg, int i, int j, int k) {
        this.drop(arg, i, j, k, arg.getTileMeta(i, j, k));
        arg.setTile(i, j, k, 0);
    }

    public int getDropCount(Random rand) {
        return rand.nextInt(20) == 0 ? 1 : 0;
    }

    public int getDropId(int meta, Random rand) {
        return RegisteringClass.blockSaplingC.id;
    }

    public void afterBreak(Level arg, PlayerBase arg1, int x, int y, int z, int i1) {
        if (!arg.isClient && arg1.getHeldItem() != null && arg1.getHeldItem().itemId == ItemBase.shears.id) {
            arg1.increaseStat(Stats.STAT_MINE_BLOCK[this.id], 1);
            this.drop(arg, x, y, z, new ItemInstance(RegisteringClass.blockLeavesC.id, 1, i1));
        } else {
            super.afterBreak(arg, arg1, x, y, z, i1);
        }

    }

    protected int droppedMeta(int i) {
        return i;
    }

    public boolean isFullOpaque() {
        return !this.field_1192;
    }

    public int getTextureForSide(int side, int meta) {
        return ChickenMod.textColourLeaves_Fast;
    }

    @Environment(EnvType.CLIENT)
    public void method_991(boolean flag) {
        this.field_1192 = flag;
        this.texture = flag ? ChickenMod.textColourLeaves : ChickenMod.textColourLeaves_Fast;
    }

    public void method_1560(Level arg, int i, int j, int k, EntityBase arg1) {
        super.method_1560(arg, i, j, k, arg1);
    }

}
