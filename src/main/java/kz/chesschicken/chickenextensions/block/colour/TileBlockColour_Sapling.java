package kz.chesschicken.chickenextensions.block.colour;

import kz.chesschicken.chickenextensions.ChickenMod;
import kz.chesschicken.chickenextensions.api.common.structure.ColourTreeStructure;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Plant;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.PlaceableTileEntity;
import net.minecraft.level.Level;
import net.minecraft.level.TileView;
import net.minecraft.level.structure.*;
import net.modificationstation.stationloader.api.common.block.BlockItemProvider;

import java.util.Random;

public class TileBlockColour_Sapling extends Plant implements BlockItemProvider {
    public TileBlockColour_Sapling(int id) {
        super(id, ChickenMod.textColourSapling);
        this.setTicksRandomly(true);
        this.disableNotifyOnMetaDataChange();
        float var3 = 0.4F;
        this.setBoundingBox(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 2.0F, 0.5F + var3);
    }

    @Environment(EnvType.CLIENT)
    public int getColor(TileView arg, int x, int y, int z) {
        return ChickenMod.INSTANCE.get16ColorCode(arg.getTileMeta(x, y, z));
    }


    @Override
    public int getTextureForSide(int side) {
        return ChickenMod.textColourSapling;
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        return ChickenMod.textColourSapling;
    }

    public PlaceableTileEntity getBlockItem(int i) {
        return new TileItemColour_Sapling(i);
    }





    @Override
    public void onScheduledTick(Level level, int x, int y, int z, Random rand) {
        if (!level.isClient) {
            super.onScheduledTick(level, x, y, z, rand);
            if (level.getLightLevel(x, y + 1, z) >= 9 && rand.nextInt(90) == 0) {
                    this.growTree(level, x, y, z, rand, level.getTileMeta(x, y, z));
            }
        }
    }

    @Override
    public boolean canUse(Level level, int x, int y, int z, PlayerBase player) {
        if(player.getHeldItem() != null)
            if(player.getHeldItem().itemId == ItemBase.dyePowder.id)
                if(player.getHeldItem().getDamage() == 15)
                {
                    int var8 = level.getTileId(x, y, z);
                    (new ColourTreeStructure(var8)).generate(level, level.rand, x, y, z);
                    --player.getHeldItem().count;
                    return true;
                }
        return false;
    }

    public void growTree(Level arg, int i, int j, int k, Random random, int metadata) {
        //UPDATE THIS
        int var6 = arg.getTileMeta(i, j, k);
        arg.setTileInChunk(i, j, k, 0);
        Object var7 = null;
        var7 = new ColourTreeStructure(metadata);

        if (!((Structure)var7).generate(arg, random, i, j, k))
            arg.setTileWithMetadata(i, j, k, this.id, var6);
        else
            ((Structure)var7).generate(arg, random, i, j, k);
    }

    protected int droppedMeta(int i) {
        return i;
    }

}
