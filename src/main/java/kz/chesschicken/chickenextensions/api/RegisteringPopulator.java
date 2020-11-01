package kz.chesschicken.chickenextensions.api;

import kz.chesschicken.chickenextensions.api.structure.AquamarineGenStructure;
import kz.chesschicken.chickenextensions.api.structure.ColourTreeStructure;
import kz.chesschicken.chickenextensions.api.structure.SoulBrickDungeon;
import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;
import net.minecraft.level.biome.Biome;
import net.minecraft.level.source.LevelSource;
import net.minecraft.level.source.NetherLevelSource;
import net.minecraft.level.source.OverworldLevelSource;
import net.minecraft.structure.Ore;
import net.modificationstation.stationloader.api.common.event.level.gen.ChunkPopulator;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RegisteringPopulator implements ChunkPopulator {
    @Override
    public void populate(Level level, LevelSource levelSource, Biome biome, int i, int j, Random random) {
        if(levelSource.getClass() == OverworldLevelSource.class)
        {
            //cool method stolen from modloader
            for(int iq = 0; iq < 8; iq++)
            {
                int chunkpX = i + random.nextInt(16);
                int chunkpZ = j + random.nextInt(16);
                int chunkpY = random.nextInt(128);
                ColourTreeStructure structure = new ColourTreeStructure(random.nextInt(17));
                if(structure.generate(level,random,chunkpX,chunkpY,chunkpZ))
                    structure.generate(level,random,chunkpX,chunkpY,chunkpZ);
            }

            for(int iq = 0; iq < 4; iq++)
            {
                int chunkpX = i + random.nextInt(16);
                int chunkpZ = j + random.nextInt(16);
                int chunkpY = ThreadLocalRandom.current().nextInt(51, 69 + 1);
                AquamarineGenStructure structure = new AquamarineGenStructure();
                if(structure.generate(level,random,chunkpX,chunkpY,chunkpZ))
                    structure.generate(level,random,chunkpX,chunkpY,chunkpZ);
            }

            for(int iq = 0; iq < 12; iq++)
            {
                int chunkpX = i + random.nextInt(16);
                int chunkpZ = j + random.nextInt(16);
                int chunkpY = random.nextInt(128);
                if(level.getTileId(chunkpX,chunkpY,chunkpZ) == BlockBase.GRASS.id && level.isAir(chunkpX,chunkpY+1,chunkpZ))
                    level.setTileWithMetadata(chunkpX,chunkpY+1,chunkpZ, RegisteringClass.blockFlowerC.id, random.nextInt(17));
                else if(level.getTileId(chunkpX,chunkpY - 1,chunkpZ) == BlockBase.GRASS.id && level.isAir(chunkpX,chunkpY,chunkpZ))
                    level.setTileWithMetadata(chunkpX,chunkpY,chunkpZ, RegisteringClass.blockFlowerC.id, random.nextInt(17));
            }

            for(int iq = 0; iq < 1; ++iq) {
                int chunkpX = i + random.nextInt(16);
                int chunkpZ = j + random.nextInt(16);
                int chunkpY = random.nextInt(16);
                (new Ore(RegisteringClass.oreRuby.id, 7)).generate(level, random, chunkpX, chunkpY, chunkpZ);
            }

            for(int iq = 0; iq < 1; ++iq) {
                int chunkpX = i + random.nextInt(16);
                int chunkpZ = j + random.nextInt(16);
                int chunkpY = random.nextInt(16);
                (new Ore(RegisteringClass.oreSaphire.id, 7)).generate(level, random, chunkpX, chunkpY, chunkpZ);
            }
        }
        if(levelSource.getClass() == NetherLevelSource.class)
        {
            for(int iq = 0; iq < 8; iq++)
            {
                int chunkpX = i + random.nextInt(16);
                int chunkpZ = j + random.nextInt(16);
                int chunkpY = random.nextInt(128);
                SoulBrickDungeon structure = new SoulBrickDungeon();
                if(structure.generate(level,random,chunkpX,chunkpY,chunkpZ))
                    structure.generate(level,random,chunkpX,chunkpY,chunkpZ);
            }
        }
    }
}