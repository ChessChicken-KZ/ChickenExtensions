package kz.chesschicken.chickenextensions.api.structure;

import kz.chesschicken.chickenextensions.api.RegisteringClass;
import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class SoulBrickDungeon extends Structure {
    @Override
    public boolean generate(Level level, Random rand, int x, int y, int z) {
        if(level.getTileId(x, y, z) == BlockBase.NETHERRACK.id)
        {
            for(int x1=0;x1<5;x1++)
            {
                for(int z1=0;z1<5;z1++)
                {
                    int lol = rand.nextInt(5);
                    for(int i2 = 0; i2<lol;i2++)
                        level.setTileWithMetadata(x+plusminusget(x1), y+i2, z+plusminusget(z1), RegisteringClass.blockCouple1.id, rand.nextBoolean() ? 0 : 1);
                }
            }
            return true;
        }
        return false;
    }

    private Integer plusminusget(int i)
    {
        if((new Random()).nextBoolean())
            return i;
        else
            return -1*i;
    }
}
