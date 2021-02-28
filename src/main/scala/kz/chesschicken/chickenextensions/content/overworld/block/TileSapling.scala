package kz.chesschicken.chickenextensions.content.overworld.block

import kz.chesschicken.chickenextensions.ChickenMod
import kz.chesschicken.chickenextensions.content.overworld.OverworldListener
import kz.chesschicken.chickenextensions.content.overworld.structure.ColourTree
import net.minecraft.entity.player.PlayerBase
import net.minecraft.level.{Level, TileView}
import net.modificationstation.stationapi.api.common.registry.Identifier
import net.modificationstation.stationapi.template.common.block.TemplateSapling
import net.minecraft.item.ItemBase

import java.util.Random
import net.minecraft.level.structure.Structure
import net.modificationstation.stationapi.api.common.block.HasCustomBlockItemFactory

@HasCustomBlockItemFactory(classOf[ItemTileBase])
class TileSapling(ident: Identifier) extends TemplateSapling(ident, OverworldListener.textureColourSapling) {
  def this (ident: Identifier, t: Int) {
    this(ident, t)
    setTicksRandomly(true)
    disableNotifyOnMetaDataChange()
    val var3 = 0.4F;
    setBoundingBox(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 2.0F, 0.5F + var3)
  }

  override def getColourMultiplier(tileView: TileView, x: Int, y: Int, z: Int): Int = ChickenMod.get16ColorCode(tileView.getTileMeta(x,y,z))

  override def getTextureForSide(side: Int): Int = OverworldListener.textureColourSapling

  override def onScheduledTick(level: Level, x: Int, y: Int, z: Int, rand: Random): Unit = {
    if (!level.isClient) {
      super.onScheduledTick(level, x, y, z, rand)
      if (level.getLightLevel(x, y + 1, z) >= 9 && (rand.nextInt(90) eq 0)) this.growTree(level, x, y, z, rand, level.getTileMeta(x, y, z))
    }

  }

  override def canUse(level: Level, x: Int, y: Int, z: Int, player: PlayerBase): Boolean = {

    if (player.getHeldItem != null) {
      if (player.getHeldItem.itemId eq ItemBase.dyePowder.id) if (player.getHeldItem.getDamage eq 15) {
        val var8 = level.getTileMeta(x, y, z)
        new ColourTree(var8).generate(level, level.rand, x, y, z)
        player.getHeldItem.count -= 1
        return true

      }
    }
    return false
  }


  def growTree(arg: Level, x: Int, y: Int, z: Int, random: Random, metadata: Int): Unit = {

    val var6 = arg.getTileMeta(x, y, z)
    arg.setTileInChunk(x, y, z, 0)
    val var7 = new ColourTree(metadata)

    if (!var7.asInstanceOf[Structure].generate(arg, random, x, y, z))
      arg.setTileWithMetadata(x, y, z, this.id, var6)
    else
      var7.asInstanceOf[Structure].generate(arg, random, x, y, z)
  }

  override def droppedMeta(meta: Int): Int = meta




}
