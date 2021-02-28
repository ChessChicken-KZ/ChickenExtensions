package kz.chesschicken.chickenextensions.content.overworld.block

import kz.chesschicken.chickenextensions.ChickenMod
import kz.chesschicken.chickenextensions.content.overworld.OverworldListener
import net.modificationstation.stationapi.api.common.registry.Identifier
import net.minecraft.level.TileView
import net.modificationstation.stationapi.api.common.block.HasCustomBlockItemFactory
import net.modificationstation.stationapi.template.common.block.TemplatePlant

import java.util.Random

@HasCustomBlockItemFactory(classOf[ItemTileBase])
class TileFlower(id: Identifier) extends TemplatePlant(id, 0)
{
  override def getTextureForSide(side: Int, meta: Int): Int = OverworldListener.textureColourFlower

  override def getColourMultiplier(arg: TileView, x: Int, y: Int, z: Int): Int = ChickenMod.get16ColorCode(arg.getTileMeta(x, y, z))

  override def getDropId(meta: Int, rand: Random): Int = OverworldListener.colourSapling.id

  override def droppedMeta(i: Int): Int = i



}
