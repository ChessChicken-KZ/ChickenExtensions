package kz.chesschicken.chickenextensions.content.overworld.structure

import kz.chesschicken.chickenextensions.content.overworld.OverworldListener
import net.minecraft.level.Level
import net.minecraft.level.structure.Structure
import net.minecraft.block.BlockBase
import net.minecraft.block.material.Material
import java.util.Random

class ColourTree extends Structure {
  var randomTreeBlock = 0
  private var selectedType = 0
  private var selectedMetadata = 0

  def this(metadata: Int)
  {
    this()
    selectedType = new Random().nextInt(2)
    selectedMetadata = metadata
    randomTreeBlock = new Random().nextInt(3)
  }

  override def generate(level: Level, rand: Random, x: Int, y: Int, z: Int): Boolean = {

    if ((level.isAir(x, y, z) || (level.getTileId(x, y, z) eq BlockBase.SNOW.id) || (level.getTileId(x, y, z) eq OverworldListener.colourSapling.id)) && (level.getMaterial(x, y - 1, z) eq Material.ORGANIC)) {
      if (selectedType eq 0)
        generateType1(level, rand, x, y, z)
      else
        generateType2(level, rand, x, y, z)

      true
    }else false
  }


  def generateType1(level: Level, rand: Random, x: Int, y: Int, z: Int): Unit = {
    var h1 = rand.nextInt(5)
    if (h1 < 3) h1 = 3
    for (i1 <- 0 until h1) {
      if (i1 == 0) for (i2 <- 0 until 3) {
        level.setTileWithMetadata(x, y + (i1 * 3) + i2, z, BlockBase.LOG.id, randomTreeBlock)
      }
      else {
        for (x1 <- 0 until 3) {
          for (z1 <- 0 until 3) {
            for (y1 <- 0 until 3) {
              level.setTileWithMetadata(x - 1 + x1, y + (i1 * 3) + y1, z - 1 + z1, OverworldListener.colourLeaves.id, selectedMetadata)
            }
          }
        }
        level.setTileWithMetadata(x - 2, y + (i1 * 3) + 1, z, OverworldListener.colourLeaves.id, selectedMetadata)
        level.setTileWithMetadata(x + 2, y + (i1 * 3) + 1, z, OverworldListener.colourLeaves.id, selectedMetadata)
        level.setTileWithMetadata(x, y + (i1 * 3) + 1, z - 2, OverworldListener.colourLeaves.id, selectedMetadata)
        level.setTileWithMetadata(x, y + (i1 * 3) + 1, z + 2, OverworldListener.colourLeaves.id, selectedMetadata)
        level.setTileWithMetadata(x, y + (i1 * 3) + 3, z, OverworldListener.colourLeaves.id, selectedMetadata)
        for (i2 <- 0 until 2) {
          level.setTile(x - 1, y + (i1 * 3) + (i2 * 2), z - 1, 0)
          level.setTile(x + 1, y + (i1 * 3) + (i2 * 2), z - 1, 0)
          level.setTile(x - 1, y + (i1 * 3) + (i2 * 2), z + 1, 0)
          level.setTile(x + 1, y + (i1 * 3) + (i2 * 2), z + 1, 0)
        }
        for (y1 <- 0 until 4) {
          level.setTileWithMetadata(x, y + (i1 * 3) - 1 + y1, z, BlockBase.LOG.id, randomTreeBlock)
        }
      }
    }
  }

  def generateType2(level: Level, rand: Random, x: Int, y: Int, z: Int): Unit = {
    val var6 = rand.nextInt(3) + 4
    var var7 = true
    if (y >= 1 && y + var6 + 1 <= 128) {
      var var8 = 0
      var var10 = 0
      var var11 = 0
      var var12 = 0
      var8 = y
      while ( {
        var8 <= y + 1 + var6
      }) {
        var var9 = 1
        if (var8 == y) var9 = 0
        if (var8 >= y + 1 + var6 - 2) var9 = 2
        var10 = x - var9
        while ( {
          var10 <= x + var9 && var7
        }) {
          var11 = z - var9
          while ( {
            var11 <= z + var9 && var7
          }) {
            if (var8 >= 0 && var8 < 128) {
              var12 = level.getTileId(var10, var8, var11)
              if (var12 != 0 && var12 != OverworldListener.colourLeaves.id) var7 = false
            }
            else var7 = false

            var11 += 1
          }

          var10 += 1
        }

        var8 += 1
      }
      var8 = level.getTileId(x, y - 1, z)
      if ((var8 == BlockBase.GRASS.id || var8 == BlockBase.DIRT.id) && y < 128 - var6 - 1) {
        level.setTileInChunk(x, y - 1, z, BlockBase.DIRT.id)
        var var16 = 0
        var16 = y - 3 + var6
        while ( {
          var16 <= y + var6
        }) {
          var10 = var16 - (y + var6)
          var11 = 1 - var10 / 2
          var12 = x - var11
          while ( {
            var12 <= x + var11
          }) {
            val var13 = var12 - x
            for (var14 <- z - var11 to z + var11) {
              val var15 = var14 - z
              if ((Math.abs(var13) != var11 || Math.abs(var15) != var11 || (rand.nextInt(2) ne 0) && var10 != 0) && !BlockBase.FULL_OPAQUE(level.getTileId(var12, var16, var14))) level.setTileWithMetadata(var12, var16, var14, OverworldListener.colourLeaves.id, selectedMetadata)
            }

            var12 += 1
          }

          var16 += 1
        }
        var16 = 0
        while ( {
          var16 < var6
        }) {
          var10 = level.getTileId(x, y + var16, z)
          if (var10 == 0 || var10 == OverworldListener.colourLeaves.id) level.setTileWithMetadata(x, y + var16, z, BlockBase.LOG.id, randomTreeBlock)

          var16 += 1
        }
      }
    }
    if (level.getTileId(x, y, z) ne BlockBase.LOG.id) level.setTileWithMetadata(x, y, z, BlockBase.LOG.id, randomTreeBlock)
  }
}
