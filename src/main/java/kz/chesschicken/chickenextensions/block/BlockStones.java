package kz.chesschicken.chickenextensions.block;

import kz.chesschicken.chickenextensions.ChickenMod;
import kz.chesschicken.chickenextensions.api.RegisteringClass;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Item;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.item.PlaceableTileEntity;
import net.minecraft.level.Level;
import net.modificationstation.stationloader.api.common.block.BlockItemProvider;

import java.util.Random;

public class BlockStones extends BlockBase implements BlockItemProvider {

    public BlockStones(int id) {
        super(id, Material.STONE);
        this.setHardness(2.0F);
        this.setBlastResistance(10.0F);
        this.sounds(BlockBase.PISTON_SOUNDS);

    }



    public PlaceableTileEntity getBlockItem(int i) {
        return new TileBlockStones(i);
    }

    protected int droppedMeta(int i) {
        return i;
    }

    public int getTextureForSide(int side, int meta) {
        switch (meta) {
            case 0:
                return ChickenMod.texBrickSoul_BLOCK;
            case 1:
                return ChickenMod.texBrickSoul_BLOCK1;
            case 2:
                return ChickenMod.texBrickNether;
            case 3:
                return ChickenMod.texBrickNormal0;
            case 4:
                return ChickenMod.texBrickNormal1;
            case 5:
                return ChickenMod.texBrickNormal2;
            case 6:
                return ChickenMod.texBrickNormal3;
            case 7:
                return ChickenMod.texBrickLimestone;
            case 8:
                return ChickenMod.texBrickSnow;
            case 9:
                return ChickenMod.texBrickSlakedLime;
        }
        return super.getTextureForSide(side, meta);
    }

    @Override
    public int getDropId(int meta, Random rand) {
        if(meta == 7)
            return RegisteringClass.itemLimestone.id;
        return id;
    }

    @Override
    public void afterBreak(Level arg, PlayerBase arg1, int x, int y, int z, int i1) {
        if(i1 == 7)
        {
            for(int q1 = 0; q1 < 3; q1++)
            {
                Item itemgold = new Item(arg, x,y,z, new ItemInstance(RegisteringClass.itemLimestone));
                arg.spawnEntity(itemgold);
            }
        }
    }
}
