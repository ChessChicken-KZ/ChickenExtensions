package kz.chesschicken.chickenextensions.content.overworld.block

import net.modificationstation.stationapi.api.common.preset.item.PlaceableTileEntity

class ItemTileBase(i: Integer) extends PlaceableTileEntity(i) {
  def this (i: Integer)
  {
    this(i)
    this.setDurability(0)
    this.setHasSubItems(true)
  }


}
