package kz.chesschicken.chickenextensions.content.overworld.block

import kz.chesschicken.chickenextensions.ChickenMod
import net.modificationstation.stationapi.api.common.block.BlockItemProvider
import net.modificationstation.stationapi.api.common.preset.block.Plant
import net.modificationstation.stationapi.api.common.registry.Identifier
import net.minecraft.item.PlaceableTileEntity
import net.minecraft.level.TileView
import kz.chesschicken.chickenextensions.content.overworld.OverworldBase

import java.util.Random


class TileFlower(id: Identifier) extends Plant(id, 0) with BlockItemProvider {
  override def getTextureForSide(side: Int, meta: Int): Int = OverworldBase.textureColourFlower

  override def getColor(arg: TileView, x: Int, y: Int, z: Int): Int = ChickenMod.get16ColorCode(arg.getTileMeta(x, y, z))

  override def getDropId(meta: Int, rand: Random): Int = OverworldBase.colourSapling.id

  override def getBlockItem(i: Int): Int = OverworldBase.colourSapling.id

  override def droppedMeta(i: Int): Int = i
}
