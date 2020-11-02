package kz.chesschicken.chickenextensions.block.furniture;

import kz.chesschicken.chickenextensions.ChickenMod;
import kz.chesschicken.chickenextensions.api.RegisteringClass;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Item;
import net.minecraft.entity.Living;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.minecraft.level.TileView;
import net.minecraft.tileentity.TileEntityBase;
import net.minecraft.util.maths.MathHelper;

import java.util.Random;

public class BlockContainerFurniture extends BlockWithEntity {
    private Random rand = new Random();

    public BlockContainerFurniture(int id) {
        super(id, Material.WOOD);
        this.texture = 26;
        this.setHardness(2.5F);
        this.sounds(WOOD_SOUNDS);
        this.disableNotifyOnMetaDataChange();
    }

    @Environment(EnvType.CLIENT)
    public int method_1626(TileView arg, int i, int j, int k, int i1) {
        if(this.id == RegisteringClass.furnitureCabinet.id) {
            if (i1 == 1) {
                return ChickenMod.texCabinetTop;
            } else if (i1 == 0) {
                return ChickenMod.texCabinetTop;
            } else {
                int var6 = arg.getTileMeta(i, j, k);
                return i1 != var6 ? ChickenMod.texCabinetSide : ChickenMod.texCabinetFront;
            }
        }else if(this.id == RegisteringClass.furnitureNightstand.id) {
            if (i1 == 1) {
                return ChickenMod.texNightstandTop;
            } else if (i1 == 0) {
                return ChickenMod.texCabinetTop;
            } else {
                int var6 = arg.getTileMeta(i, j, k);
                return i1 != var6 ? ChickenMod.texNightstandSide : ChickenMod.texNightstandFront;
            }
        }else if(this.id == RegisteringClass.furnitureBox.id) {
            if (i1 == 1) {
                return ChickenMod.texBoxTop;
            } else if (i1 == 0) {
                return ChickenMod.texBoxSide;
            } else {
                int var6 = arg.getTileMeta(i, j, k);
                return i1 != var6 ? ChickenMod.texBoxSide : ChickenMod.texBoxFront;
            }
        }else if(this.id == RegisteringClass.furnitureLocker.id) {
           return ChickenMod.texLocker;
        }else if(this.id == RegisteringClass.furnitureCommode.id) {
            if (i1 == 1) {
                return ChickenMod.texCommodeTop;
            } else if (i1 == 0) {
                return ChickenMod.texCommodeTop;
            } else {
                int var6 = arg.getTileMeta(i, j, k);
                return i1 != var6 ? ChickenMod.texCommodeSide : ChickenMod.texCommodeFront;
            }
        }else if(this.id == RegisteringClass.furnitureFridge.id) {
            if (i1 == 1) {
                return ChickenMod.texFridgeSide;
            } else if (i1 == 0) {
                return ChickenMod.texFridgeSide;
            } else {
                int var6 = arg.getTileMeta(i, j, k);
                return i1 != var6 ? ChickenMod.texFridgeSide : ChickenMod.texFridgeFront;
            }
        }
        return 0;
    }

    public int getTextureForSide(int side) {
        if(this.id == RegisteringClass.furnitureCabinet.id)
        {
            if (side == 1) {
                return ChickenMod.texCabinetTop;
            } else if (side == 0) {
                return ChickenMod.texCabinetTop;
            } else {
                return side == 3 ? ChickenMod.texCabinetFront: ChickenMod.texCabinetSide;
            }
        }else if(this.id == RegisteringClass.furnitureNightstand.id)
        {
            if (side == 1) {
                return ChickenMod.texNightstandTop;
            } else if (side == 0) {
                return ChickenMod.texCabinetTop;
            } else {
                return side == 3 ? ChickenMod.texNightstandFront : ChickenMod.texNightstandSide;
            }
        }else if(this.id == RegisteringClass.furnitureBox.id)
        {
            if (side == 1) {
                return ChickenMod.texBoxTop;
            } else if (side == 0) {
                return ChickenMod.texBoxSide;
            } else {
                return side == 3 ? ChickenMod.texBoxFront : ChickenMod.texBoxSide;
            }
        }else if(this.id == RegisteringClass.furnitureLocker.id) {
            return ChickenMod.texLocker;
        }else if(this.id == RegisteringClass.furnitureCommode.id)
        {
            if (side == 1) {
                return ChickenMod.texCommodeTop;
            } else if (side == 0) {
                return ChickenMod.texCommodeTop;
            } else {
                return side == 3 ? ChickenMod.texCommodeFront : ChickenMod.texCommodeSide;
            }
        }else if(this.id == RegisteringClass.furnitureFridge.id)
        {
            if (side == 1) {
                return ChickenMod.texFridgeSide;
            } else if (side == 0) {
                return ChickenMod.texFridgeSide;
            } else {
                return side == 3 ? ChickenMod.texFridgeFront : ChickenMod.texFridgeSide;
            }
        }
        return 0;
    }


    public void onBlockRemoved(Level level, int x, int y, int z) {
        TileEntityExtended var5 = (TileEntityExtended) level.getTileEntity(x, y, z);

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

    public boolean canUse(Level level, int x, int y, int z, PlayerBase player) {
        if (!level.isClient) {
            TileEntityExtended var6 = (TileEntityExtended) level.getTileEntity(x, y, z);
            player.openChestScreen(var6);
        }
        return true;
    }

    protected TileEntityBase createTileEntity() {
        return new TileEntityExtended(getTileName());
    }

    private String getTileName()
    {
        if(id == RegisteringClass.furnitureCabinet.id)
            return "Cabinet";
        else if(id == RegisteringClass.furnitureNightstand.id)
            return "Nightstand";
        else if(id == RegisteringClass.furnitureBox.id)
            return "Box";
        else if(id == RegisteringClass.furnitureLocker.id)
            return "Locker";
        else if(id == RegisteringClass.furnitureCommode.id)
            return "Commode";
        else if(id == RegisteringClass.furnitureFridge.id)
            return "Fridge";
        return "";
    }

    public void afterPlaced(Level arg, int i, int j, int k, Living arg1) {
        int var6 = MathHelper.floor((double)(arg1.yaw * 4.0F / 360.0F) + 0.5D);
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

}
