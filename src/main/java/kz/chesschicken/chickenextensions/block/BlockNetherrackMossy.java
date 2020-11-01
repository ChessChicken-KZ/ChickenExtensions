package kz.chesschicken.chickenextensions.block;

import kz.chesschicken.chickenextensions.ChickenMod;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;

public class BlockNetherrackMossy extends BlockBase {
    public BlockNetherrackMossy(int id) {
        super(id, ChickenMod.texNetherMossy, Material.STONE);
        this.setHardness(0.4F);
        this.sounds(PISTON_SOUNDS);
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        return ChickenMod.texNetherMossy;
    }

    @Override
    public int getTextureForSide(int side) {
        return ChickenMod.texNetherMossy;
    }
}
