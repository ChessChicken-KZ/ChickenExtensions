package kz.chesschicken.chickenextensions.content.overworld

import kz.chesschicken.chickenextensions.content.overworld.OverworldBase._
import kz.chesschicken.chickenextensions.content.overworld.block.{TileFlower, TileLeaves}
import net.minecraft.block.BlockBase
import net.minecraft.client.render.entity.EntityRenderer
import net.minecraft.entity.EntityBase
import net.minecraft.item.ItemBase
import net.modificationstation.stationapi.api.client.event.render.entity.EntityRendererRegister
import net.modificationstation.stationapi.api.client.event.texture.TextureRegister
import net.modificationstation.stationapi.api.client.texture.{TextureFactory, TextureRegistry}
import net.modificationstation.stationapi.api.common.block.BlockRegistry
import net.modificationstation.stationapi.api.common.entity.EntityHandlerRegistry
import net.modificationstation.stationapi.api.common.event.block.BlockRegister
import net.modificationstation.stationapi.api.common.event.entity.EntityRegister
import net.modificationstation.stationapi.api.common.event.item.ItemRegister
import net.modificationstation.stationapi.api.common.item.ItemRegistry
import net.modificationstation.stationapi.api.common.registry.{Identifier, ModID}
import uk.co.benjiweber.expressions.functions.TriConsumer

import java.util

object OverworldBase
{
  var itemSteakRaw: ItemBase = _
  var itemSteakCooked: ItemBase = _
  var itemMuttonRaw: ItemBase = _
  var itemMuttonCooked: ItemBase = _
  var itemChickenRaw: ItemBase = _
  var itemChickenCooked: ItemBase = _
  var itemRottenFlesh: ItemBase = _

  var colourWood: BlockBase = _
  var colourSapling: BlockBase = _
  var colourLeaves: BlockBase = _
  var colourFlower: BlockBase = _

  var textureColourWood = 0
  var textureColourSapling = 0
  var textureColourLeaves = 0
  var textureColourFlower = 0
}


class OverworldBase extends java.lang.Object with ItemRegister with BlockRegister with EntityRegister with EntityRendererRegister with TextureRegister {
  override def registerItems(itemRegistry: ItemRegistry, modID: ModID): Unit = ???

  override def registerBlocks(blockRegistry: BlockRegistry, modID: ModID): Unit = {
    colourSapling = new Nothing(Identifier.of(modID, "coloursapling")).setName("coloursapling")
    colourLeaves = new TileLeaves(Identifier.of(modID, "colourleaves")).setName("colourleaves")
    colourFlower = new TileFlower(Identifier.of(modID, "colourflower")).setName("colourflower")
  }

  override def registerEntities(triConsumer: TriConsumer[Class[_ <: EntityBase], String, Integer], entityHandlerRegistry: EntityHandlerRegistry, modID: ModID): Unit = ???

  override def registerEntityRenderers(map: util.Map[Class[_ <: EntityBase], EntityRenderer]): Unit = ???

  override def registerTextures(): Unit = {
    itemSteakRaw.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/goldenfeaturessap/textures/content/overworld/item/steakRaw.png"))
    itemSteakCooked.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/goldenfeaturessap/textures/content/overworld/item/steakCooked.png"))
    itemMuttonRaw.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/goldenfeaturessap/textures/content/overworld/item/muttonRaw.png"))
    itemMuttonCooked.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/goldenfeaturessap/textures/content/overworld/item/muttonCooked.png"))
    itemChickenRaw.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/goldenfeaturessap/textures/content/overworld/item/chickenRaw.png"))
    itemChickenCooked.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/goldenfeaturessap/textures/content/overworld/item/chickenCooked.png"))
    itemRottenFlesh.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/goldenfeaturessap/textures/content/overworld/item/fleshRotten.png"))
  }
}
