package kz.chesschicken.chickenextensions.api;

import kz.chesschicken.chickenextensions.ChickenMod;
import kz.chesschicken.chickenextensions.block.BlockMaterialExtended;
import kz.chesschicken.chickenextensions.block.BlockOreAq;
import kz.chesschicken.chickenextensions.block.BlockOreStone;
import kz.chesschicken.chickenextensions.item.ItemBasic;
import net.minecraft.block.BlockBase;
import net.minecraft.item.ItemBase;
import net.modificationstation.stationloader.api.client.event.texture.TextureRegister;
import net.modificationstation.stationloader.api.client.texture.TextureRegistry;
import net.modificationstation.stationloader.api.common.config.Category;
import net.modificationstation.stationloader.api.common.config.Configuration;
import net.modificationstation.stationloader.api.common.config.Property;
import net.modificationstation.stationloader.api.common.event.block.BlockRegister;
import net.modificationstation.stationloader.api.common.event.item.ItemRegister;
import net.modificationstation.stationloader.impl.client.texture.TextureFactory;

/**
 * Because of 0.0.3, I'll start inserting material textures here
 *
 * @author ChessChicken-KZ
 */
public class RegisteringMetals implements TextureRegister, ItemRegister, BlockRegister {
    public static int textureOreRuby;
    public static int textureOreSaphire;
    public static int textureOreCopper;
    public static int textureBlockRuby;
    public static int textureBlockSaphire;
    public static int textureBlockCopper;
    @Override
    public void registerTextures() {
        //ITEMS
        itemAquamarine.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/materials/aquamarine.png"));
        itemRuby.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/materials/ruby.png"));
        itemSaphire.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/materials/saphire.png"));
        nuggetRuby.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/nuggets/ruby.png"));
        nuggetSaphire.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/nuggets/saphire.png"));



        //BLOCKS
        oreAquamarine.texture = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/ore/aquamarine.png");
        textureOreRuby = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/ore/ruby.png");
        textureOreSaphire = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/ore/saphire.png");
        textureOreCopper = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/ore/copper.png");

    }

    /*
     * Map list:
     * Ruby
     * Saphire
     * Copper
     * Tin
     */

    public static BlockBase allMetalsOre;
    public static BlockBase allMetalsBlock;

    public static BlockBase oreAquamarine;
    public static ItemBase itemAquamarine;

    //0.0.3
    public static ItemBase itemRuby;
    public static ItemBase nuggetRuby;

    public static ItemBase itemSaphire;
    public static ItemBase nuggetSaphire;

    public static ItemBase itemCopper;
    public static ItemBase nuggetCopper;

    @Override
    public void registerBlocks() {
        Configuration config = ChickenMod.INSTANCE.getDefaultConfig();
        Category blockIdsCategory = config.getCategory("Block IDs");
        Property oreAquamarineID = blockIdsCategory.getProperty("oreAquamarine", 136);
        Property allMetalsOreID = blockIdsCategory.getProperty("allMetalsOre", 152);
        Property allMetalsBlockID = blockIdsCategory.getProperty("allMetalsBlock", 153);

        oreAquamarine = new BlockOreAq(oreAquamarineID.getIntValue()).setName("oreAquamarine");
        allMetalsOre = new BlockOreStone(allMetalsOreID.getIntValue()).setName("allMetalsOre");
        allMetalsBlock = new BlockMaterialExtended(allMetalsBlockID.getIntValue()).setName("allMetalsBlock");
        config.save();
    }

    @Override
    public void registerItems() {
        Configuration config = ChickenMod.INSTANCE.getDefaultConfig();
        Category itemIdsCategory = config.getCategory("Item IDs");
        Property itemAquamarineID = itemIdsCategory.getProperty("itemAquamarine", 133);
        Property itemRubyID = itemIdsCategory.getProperty("itemRuby", 147);
        Property itemSaphireID = itemIdsCategory.getProperty("itemSaphire", 148);
        Property nuggetRubyID = itemIdsCategory.getProperty("nuggetRuby", 152);
        Property nuggetSaphireID = itemIdsCategory.getProperty("nuggetSaphire", 153);


        itemAquamarine = new ItemBasic(itemAquamarineID.getIntValue()).setName("chickenextensions:itemAquamarine");
        itemRuby = new ItemBasic(itemRubyID.getIntValue()).setName("itemRuby");
        itemSaphire = new ItemBasic(itemSaphireID.getIntValue()).setName("itemSaphire");
        nuggetRuby = new ItemBasic(nuggetRubyID.getIntValue()).setName("nuggetRuby");
        nuggetSaphire = new ItemBasic(nuggetSaphireID.getIntValue()).setName("nuggetSaphire");
        config.save();
    }
}
