package kz.chesschicken.chickenextensions.block;

import kz.chesschicken.chickenextensions.ChickenMod;
import kz.chesschicken.chickenextensions.api.RegisteringClass;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockBase;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Item;
import net.minecraft.entity.Living;
import net.minecraft.entity.Minecart;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.minecraft.level.TileView;
import net.minecraft.tileentity.TileEntityBase;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.maths.MathHelper;

import java.util.Random;

public class BlockCartDispenser extends BlockWithEntity {
    private final Random rand = new Random();

    public BlockCartDispenser(int id) {
        super(id, Material.STONE);
        this.texture = ChickenMod.texMachineCartDispenser;
        this.setHardness(3.5F);
        this.sounds(PISTON_SOUNDS);
        this.disableNotifyOnMetaDataChange();
    }

    public int getTickrate() {
        return 4;
    }

    public int getDropId(int meta, Random rand) {
        return RegisteringClass.machineCartDiapenser.id;
    }

    public void onBlockPlaced(Level level, int x, int y, int z) {
        super.onBlockPlaced(level, x, y, z);
        this.method_1775(level, x, y, z);
    }

    private void method_1775(Level arg, int i, int j, int k) {
        if (!arg.isClient) {
            int var5 = arg.getTileId(i, j, k - 1);
            int var6 = arg.getTileId(i, j, k + 1);
            int var7 = arg.getTileId(i - 1, j, k);
            int var8 = arg.getTileId(i + 1, j, k);
            byte var9 = 3;
            if (BlockBase.FULL_OPAQUE[var5] && !BlockBase.FULL_OPAQUE[var6]) {
                var9 = 3;
            }

            if (BlockBase.FULL_OPAQUE[var6] && !BlockBase.FULL_OPAQUE[var5]) {
                var9 = 2;
            }

            if (BlockBase.FULL_OPAQUE[var7] && !BlockBase.FULL_OPAQUE[var8]) {
                var9 = 5;
            }

            if (BlockBase.FULL_OPAQUE[var8] && !BlockBase.FULL_OPAQUE[var7]) {
                var9 = 4;
            }

            arg.setTileMeta(i, j, k, var9);
        }
    }

    @Environment(EnvType.CLIENT)
    public int method_1626(TileView arg, int i, int j, int k, int i1) {
        if (i1 == 1) {
            return  62;
        } else if (i1 == 0) {
            return 62;
        } else {
            int var6 = arg.getTileMeta(i, j, k);
            return i1 != var6 ? 45 : ChickenMod.texMachineCartDispenser;
        }
    }

    public int getTextureForSide(int side) {
        if (side == 1) {
            return 62;
        } else if (side == 0) {
            return 62;
        } else {
            return side == 3 ? ChickenMod.texMachineCartDispenser : 45;
        }
    }

    public boolean canUse(Level level, int x, int y, int z, PlayerBase player) {
        if (!level.isClient) {
            TileEntityDispenser var6 = (TileEntityDispenser) level.getTileEntity(x, y, z);
            player.openDispenserScreen(var6);
        }
        return true;
    }

    private void method_1774(Level arg, int i, int j, int k) {
        int var6 = arg.getTileMeta(i, j, k);
        byte var9 = 0;
        byte var10 = 0;
        if (var6 == 3) {
            var10 = 1;
        } else if (var6 == 2) {
            var10 = -1;
        } else if (var6 == 5) {
            var9 = 1;
        } else {
            var9 = -1;
        }

        TileEntityDispenser var11 = (TileEntityDispenser)arg.getTileEntity(i, j, k);
        ItemInstance var12 = var11.getItemToDispense();
        double var13 = (double)i + (double)var9 * 0.6D + 0.5D;
        double var15 = (double)j + 0.5D;
        double var17 = (double)k + (double)var10 * 0.6D + 0.5D;
        if (var12 == null) {
            arg.playLevelEvent(1001, i, j, k, 0);
        } else {
            if (var12.itemId == ItemBase.minecart.id) {
                Minecart var19 = new Minecart(arg);
                var19.setPosition(var13, var15, var17);
                arg.spawnEntity(var19);
                arg.playLevelEvent(1002, i, j, k, 0);
            }else if (var12.itemId == ItemBase.minecartFurnace.id) {
                Minecart var19 = new Minecart(arg, var13, var15, var17, 2);
                arg.spawnEntity(var19);
                arg.playLevelEvent(1002, i, j, k, 0);
            }else if (var12.itemId == ItemBase.minecartChest.id) {
                Minecart var19 = new Minecart(arg, var13, var15, var17, 1);
                arg.spawnEntity(var19);
                arg.playLevelEvent(1002, i, j, k, 0);
            }else
            {
                Item var19 = new Item(arg, var13, var15, var17, var12);
                arg.spawnEntity(var19);
                arg.playLevelEvent(1002, i, j, k, 0);
            }

            arg.playLevelEvent(2000, i, j, k, var9 + 1 + (var10 + 1) * 3);
        }

    }

    public void onAdjacentBlockUpdate(Level level, int x, int y, int z, int id) {
        if (id > 0 && BlockBase.BY_ID[id].emitsRedstonePower()) {
            boolean var6 = level.hasRedstonePower(x, y, z) || level.hasRedstonePower(x, y + 1, z);
            if (var6) {
                level.method_216(x, y, z, this.id, this.getTickrate());
            }
        }

    }

    public void onScheduledTick(Level level, int x, int y, int z, Random rand) {
        if (level.hasRedstonePower(x, y, z) || level.hasRedstonePower(x, y + 1, z)) {
            this.method_1774(level, x, y, z);
        }

    }

    protected TileEntityBase createTileEntity() {
        return new TileEntityDispenser();
    }

    public void afterPlaced(Level arg, int i, int j, int k, Living arg1) {
        int var6 = MathHelper.floor((double)(arg1.yaw * 4.0F / 360.0F) + 0.5D) & 3;
        if (var6 == 0) {
            arg.setTileMeta(i, j, k, 2);
        }

        if (var6 == 1) {
            arg.setTileMeta(i, j, k, 5);
        }

        if (var6 == 2) {
            arg.setTileMeta(i, j, k, 3);
        }

        if (var6 == 3) {
            arg.setTileMeta(i, j, k, 4);
        }

    }

    public void onBlockRemoved(Level level, int x, int y, int z) {
        TileEntityDispenser var5 = (TileEntityDispenser)level.getTileEntity(x, y, z);

        for(int var6 = 0; var6 < var5.getInventorySize(); ++var6) {
            ItemInstance var7 = var5.getInventoryItem(var6);
            if (var7 != null) {
                float var8 = this.rand.nextFloat() * 0.8F + 0.1F;
                float var9 = this.rand.nextFloat() * 0.8F + 0.1F;
                float var10 = this.rand.nextFloat() * 0.8F + 0.1F;

                while(var7.count > 0) {
                    int var11 = this.rand.nextInt(21) + 10;
                    if (var11 > var7.count) {
                        var11 = var7.count;
                    }

                    var7.count -= var11;
                    Item var12 = new Item(level, (double)((float)x + var8), (double)((float)y + var9), (double)((float)z + var10), new ItemInstance(var7.itemId, var11, var7.getDamage()));
                    float var13 = 0.05F;
                    var12.velocityX = (double)((float)this.rand.nextGaussian() * var13);
                    var12.velocityY = (double)((float)this.rand.nextGaussian() * var13 + 0.2F);
                    var12.velocityZ = (double)((float)this.rand.nextGaussian() * var13);
                    level.spawnEntity(var12);
                }
            }
        }

        super.onBlockRemoved(level, x, y, z);
    }
}

