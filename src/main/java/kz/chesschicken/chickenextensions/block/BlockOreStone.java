package kz.chesschicken.chickenextensions.block;

import kz.chesschicken.chickenextensions.api.RegisteringClass;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;

import java.util.Random;

public class BlockOreStone extends BlockBase {
    public BlockOreStone(int id) {
        super(id, Material.STONE);
        this.setHardness(3.0F);
        this.setBlastResistance(5.0F);
        this.sounds(PISTON_SOUNDS);
    }

    @Override
    public int getDropId(int meta, Random rand) {
        if(id == RegisteringClass.oreRuby.id)
            return RegisteringClass.itemRuby.id;
        else if(id == RegisteringClass.oreSaphire.id)
            return RegisteringClass.itemSaphire.id;
        else
            return 0;
    }
}
