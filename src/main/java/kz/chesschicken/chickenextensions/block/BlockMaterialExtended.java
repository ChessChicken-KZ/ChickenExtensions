package kz.chesschicken.chickenextensions.block;

import kz.chesschicken.chickenextensions.api.RegisteringMetals;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.item.PlaceableTileEntity;
import net.modificationstation.stationloader.api.common.block.BlockItemProvider;

public class BlockMaterialExtended extends BlockBase implements BlockItemProvider {
    public BlockMaterialExtended(int id) {
        super(id, Material.METAL);
        this.setHardness(5.0F);
        this.setBlastResistance(10.0F);
        this.sounds(METAL_SOUNDS);
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        switch (meta)
        {
            case 0:
                return RegisteringMetals.textureBlockRuby;
            case 1:
                return RegisteringMetals.textureBlockSaphire;
            case 2:
                return RegisteringMetals.textureBlockCopper;

            default:
                return 0;
        }
    }

    @Override
    public PlaceableTileEntity getBlockItem(int i) {
        return new TileMaterialExtended(i);
    }
}
