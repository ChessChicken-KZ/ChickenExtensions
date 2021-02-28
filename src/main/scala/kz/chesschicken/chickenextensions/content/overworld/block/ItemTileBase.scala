package kz.chesschicken.chickenextensions.content.overworld.block

import net.minecraft.item.{Block, ItemInstance}


class ItemTileBase(i: Integer) extends Block(i) {
  def this (i: Integer) {
    this(i)
    this.setDurability(0)
    this.setHasSubItems(true)
  }

  override def getMetaData(i: Int): Int = i

  override def getTranslationKey(item: ItemInstance): String = getTranslationKey + item.getDamage


}
