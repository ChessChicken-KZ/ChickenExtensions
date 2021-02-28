package kz.chesschicken.chickenextensions.content.overworld

import kz.chesschicken.chickenextensions.content.overworld.OverworldListener._
import kz.chesschicken.chickenextensions.content.overworld.block.{TileFlower, TileLeaves, TileSapling}
import net.minecraft.block.BlockBase
import net.minecraft.item.ItemBase
import net.modificationstation.stationapi.api.client.texture.{TextureFactory, TextureRegistry}
import net.modificationstation.stationapi.api.common.event.EventListener
import net.modificationstation.stationapi.api.common.event.registry.RegistryEvent
import net.modificationstation.stationapi.api.common.registry.{Identifier, ModID}
import net.modificationstation.stationapi.api.common.mod.entrypoint.Entrypoint
import net.modificationstation.stationapi.api.common.util.Null
import net.modificationstation.stationapi.template.common.block.{TemplateRedstoneTorch, TemplateTorch}

object OverworldListener
{
  @Entrypoint.ModID val MOD_ID: ModID = Null.get

  var boneTorch : net.minecraft.block.BlockBase = _
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

class OverworldListener {


  @EventListener
  def registerBlocks(event: RegistryEvent.Blocks): Unit =
  {
    boneTorch = new TemplateTorch(Identifier.of(MOD_ID, "bonetorch"), 0).setTranslationKey(MOD_ID, "bonetorch")
    colourSapling = new TileSapling(Identifier.of(MOD_ID, "coloursapling")).setTranslationKey(MOD_ID, "coloursapling")
    colourLeaves = new TileLeaves(Identifier.of(MOD_ID, "colourleaves")).setTranslationKey(MOD_ID,"colourleaves")
    colourFlower = new TileFlower(Identifier.of(MOD_ID, "colourflower")).setTranslationKey(MOD_ID, "colourflower")
  }

  @EventListener
  def registerTextures(): Unit = {
    itemSteakRaw.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/goldenfeaturessap/textures/content/overworld/item/steakRaw.png"))
    itemSteakCooked.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/goldenfeaturessap/textures/content/overworld/item/steakCooked.png"))
    itemMuttonRaw.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/goldenfeaturessap/textures/content/overworld/item/muttonRaw.png"))
    itemMuttonCooked.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/goldenfeaturessap/textures/content/overworld/item/muttonCooked.png"))
    itemChickenRaw.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/goldenfeaturessap/textures/content/overworld/item/chickenRaw.png"))
    itemChickenCooked.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/goldenfeaturessap/textures/content/overworld/item/chickenCooked.png"))
    itemRottenFlesh.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/goldenfeaturessap/textures/content/overworld/item/fleshRotten.png"))
  }


}
