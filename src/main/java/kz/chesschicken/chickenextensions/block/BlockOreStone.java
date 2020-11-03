package kz.chesschicken.chickenextensions.block;

import kz.chesschicken.chickenextensions.api.RegisteringMetals;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.item.PlaceableTileEntity;
import net.modificationstation.stationloader.api.common.block.BlockItemProvider;

import java.util.Random;

public class BlockOreStone extends BlockBase implements BlockItemProvider {
    public BlockOreStone(int id) {
        super(id, Material.STONE);
        this.setHardness(3.0F);
        this.setBlastResistance(5.0F);
        this.sounds(PISTON_SOUNDS);
    }

    @Override
    public int getDropId(int meta, Random rand) {
        if(meta == 0)
            return RegisteringMetals.itemRuby.id;
        else if(meta == 1)
            return RegisteringMetals.itemSaphire.id;
        else
            return id;
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        switch (meta)
        {
            case 0:
                return RegisteringMetals.textureOreRuby;
            case 1:
                return RegisteringMetals.textureOreSaphire;
            case 2:
                return RegisteringMetals.textureOreCopper;

            default:
                return 0;
        }
    }

    @Override
    public PlaceableTileEntity getBlockItem(int i) {
        return new TileMaterialExtended(i);
    }
}
