package kz.chesschicken.chickenextensions.api.structure;

import kz.chesschicken.chickenextensions.api.RegisteringClass;
import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class AquamarineGenStructure extends Structure {

    @Override
    public boolean generate(Level level, Random rand, int x, int y, int z) {
        if(level.getTileId(x, y, z) == BlockBase.SAND.id && level.getTileId(x, y+1, z) == BlockBase.STILL_WATER.id)
        {
            level.setTile(x,y,z, RegisteringClass.oreAquamarine.id);
            if(level.getTileId(x+1, y, z) == BlockBase.SAND.id)
                level.setTile(x+1,y,z, RegisteringClass.oreAquamarine.id);
            if(level.getTileId(x-1, y, z) == BlockBase.SAND.id)
                level.setTile(x-1,y,z, RegisteringClass.oreAquamarine.id);
            if(level.getTileId(x, y, z+1) == BlockBase.SAND.id)
                level.setTile(x,y,z+1, RegisteringClass.oreAquamarine.id);
            if(level.getTileId(x, y, z-1) == BlockBase.SAND.id)
                level.setTile(x,y,z-1, RegisteringClass.oreAquamarine.id);
            if(level.getTileId(x, y-1, z) == BlockBase.SAND.id)
                level.setTile(x,y-1,z, RegisteringClass.oreAquamarine.id);
            return true;
        }
        return false;
    }
}
