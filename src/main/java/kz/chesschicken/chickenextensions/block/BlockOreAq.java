package kz.chesschicken.chickenextensions.block;

import kz.chesschicken.chickenextensions.ChickenMod;
import kz.chesschicken.chickenextensions.api.RegisteringClass;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBase;

import java.util.Random;

public class BlockOreAq extends BlockBase {
    public BlockOreAq(int id) {
        super(id, Material.SAND);
        this.setHardness(0.5F);
        this.sounds(SAND_SOUNDS);
    }

    @Override
    public int getDropId(int meta, Random rand) { return RegisteringClass.itemAquamarine.id; }
    public int getDropCount(Random rand) {
        return 4 + rand.nextInt(5);
    }
}
