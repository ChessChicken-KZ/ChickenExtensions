package kz.chesschicken.chickenextensions.content.overworld.block

import kz.chesschicken.chickenextensions.ChickenMod
import kz.chesschicken.chickenextensions.content.overworld.OverworldBase
import net.minecraft.block.{BlockBase, LeavesBase}
import net.minecraft.block.material.Material
import net.minecraft.entity.player.PlayerBase
import net.minecraft.item.{Block, ItemBase, ItemInstance}
import net.modificationstation.stationapi.api.common.block.{BlockItemProvider, BlockRegistry}
import net.modificationstation.stationapi.api.common.registry.Identifier
import net.minecraft.level.Level
import net.minecraft.stat.Stats

import java.util.Random


class TileLeaves() extends LeavesBase(BlockRegistry.INSTANCE.getNextSerializedID, OverworldBase.textureColourLeaves, Material.LEAVES, false) with BlockItemProvider{
  var field_1171: Array[Int] = _

  def this (id: Identifier)
  {
    this()
    BlockRegistry.INSTANCE.registerValue(id, this)
    this.setTicksRandomly(true)
    this.setHardness(0.2F)
    this.setLightOpacity(1)
    this.sounds(BlockBase.GRASS_SOUNDS)
    this.disableStat
    this.disableNotifyOnMetaDataChange
    this.setTicksRandomly(true)
  }

  override def getBlockItem(i: Int): Block = new ItemTileBase(i)

  import net.fabricmc.api.EnvType
  import net.fabricmc.api.Environment

  @Environment(EnvType.CLIENT) def method_1589(i: Int): Int = ChickenMod.get16ColorCode(i)

  import net.fabricmc.api.EnvType
  import net.fabricmc.api.Environment
  import net.minecraft.level.TileView

  @Environment(EnvType.CLIENT) def getColor(arg: TileView, x: Int, y: Int, z: Int): Int = ChickenMod.get16ColorCode(arg.getTileMeta(x, y, z))

  import kz.chesschicken.chickenextensions.content.overworld.OverworldBase

  override def onBlockRemoved(level: Level, x: Int, y: Int, z: Int): Unit = {
    val var5 = 1
    val var6 = var5 + 1
    if (level.method_155(x - var6, y - var6, z - var6, x + var6, y + var6, z + var6)) for (var7 <- -var5 to var5) {
      for (var8 <- -var5 to var5) {
        for (var9 <- -var5 to var5) {
          val var10 = level.getTileId(x + var7, y + var8, z + var9)
          if (var10 == OverworldBase.colourLeaves.id) {
            val var11 = level.getTileMeta(x + var7, y + var8, z + var9)
            level.method_223(x + var7, y + var8, z + var9, var11)
          }
        }
      }
    }
  }

  override def onScheduledTick(level: Level, x: Int, y: Int, z: Int, rand: Random): Unit = {
    if (!level.isClient) {
      val var6 = level.getTileMeta(x, y, z)
      if ((var6 & 8) != 0) {
        val var7 = 4
        val var8 = var7 + 1
        val var9 = 32
        val var10 = var9 * var9
        val var11 = var9 / 2
        if (field_1171 == null) field_1171 = new Array[Int](var9 * var9 * var9)
        var var12 = 0
        if (level.method_155(x - var8, y - var8, z - var8, x + var8, y + var8, z + var8)) {
          var12 = -var7

          while ( {
            true
          }) {
            var var13 = 0
            var var14 = 0
            var var15 = 0
            if (var12 > var7) {
              var12 = 1
              while ( {
                true
              }) {
                if (var12 > 4)
                  var13 = -var7
                while ( {
                  var13 <= var7
                }) {
                  var14 = -var7
                  while ( {
                    var14 <= var7
                  }) {
                    var15 = -var7
                    while ( {
                      var15 <= var7
                    }) {
                      if (field_1171((var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11) eq var12 - 1) {
                        if (field_1171((var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var15 + var11) eq -2) field_1171((var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var15 + var11) = var12
                        if (field_1171((var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var15 + var11) eq -2) field_1171((var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var15 + var11) = var12
                        if (field_1171((var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var15 + var11) eq -2) field_1171((var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var15 + var11) = var12
                        if (field_1171((var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var15 + var11) eq -2) field_1171((var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var15 + var11) = var12
                        if (field_1171((var13 + var11) * var10 + (var14 + var11) * var9 + (var15 + var11 - 1)) eq -2) field_1171((var13 + var11) * var10 + (var14 + var11) * var9 + (var15 + var11 - 1)) = var12
                        if (field_1171((var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11 + 1) eq -2) field_1171((var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11 + 1) = var12
                      }

                      var15 += 1
                    }

                    var14 += 1
                  }

                  var13 += 1
                }
                var12 += 1
              }
            }
            var13 = -var7
            while ( {
              var13 <= var7
            }) {
              var14 = -var7
              while ( {
                var14 <= var7
              }) {
                var15 = level.getTileId(x + var12, y + var13, z + var14)
                if (var15 == BlockBase.LOG.id) field_1171((var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11) = 0
                else if (var15 == OverworldBase.colourLeaves.id) field_1171((var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11) = -2
                else field_1171((var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11) = -1

                var14 += 1
              }

              var13 += 1
            }
            var12 += 1
          }
        }
        var12 = field_1171(var11 * var10 + var11 * var9 + var11)
        if (var12 >= 0) level.method_223(x, y, z, var6)
        else dropAndRemove(level, x, y, z)
      }
    }
  }

  private def dropAndRemove(arg: Level, i: Int, j: Int, k: Int): Unit = {
    this.drop(arg, i, j, k, arg.getTileMeta(i, j, k))
    arg.setTile(i, j, k, 0)
  }

  override def getDropCount(rand: Random): Int = if (rand.nextInt(20) eq 0) 1 else 0

  override def getDropId(meta: Int, rand: Random): Int = OverworldBase.colourSapling.id


  override def afterBreak(arg: Level, arg1: PlayerBase, x: Int, y: Int, z: Int, i1: Int): Unit = {
    if (!arg.isClient && arg1.getHeldItem != null && arg1.getHeldItem.itemId == ItemBase.shears.id) {
      arg1.increaseStat(Stats.STAT_MINE_BLOCK(this.id), 1)
      this.drop(arg, x, y, z, new ItemInstance(OverworldBase.colourLeaves.id, 1, i1))
    }
    else super.afterBreak(arg, arg1, x, y, z, i1)
  }

  override protected def droppedMeta(i: Int): Int = i

  override def isFullOpaque: Boolean = !isTransparent

  override def getTextureForSide(side: Int, meta: Int): Int = OverworldBase.textureColourLeaves
}
