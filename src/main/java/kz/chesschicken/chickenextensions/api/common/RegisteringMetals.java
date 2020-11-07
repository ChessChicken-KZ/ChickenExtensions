package kz.chesschicken.chickenextensions.api.common;

import kz.chesschicken.chickenextensions.ChickenMod;
import kz.chesschicken.chickenextensions.block.BlockMaterialExtended;
import kz.chesschicken.chickenextensions.block.BlockOreAq;
import kz.chesschicken.chickenextensions.block.BlockOreStone;
import kz.chesschicken.chickenextensions.item.ItemBasic;
import kz.chesschicken.chickenextensions.item.tool.ArmourExtended;
import kz.chesschicken.chickenextensions.item.tool.PickaxeBasic;
import net.minecraft.block.BlockBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.tool.Sword;
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
    public static int textureOreTin;
    public static int textureBlockTin;
    @Override
    public void registerTextures() {
        //ITEMS
        itemAquamarine.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/materials/aquamarine.png"));

        itemRuby.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/materials/ruby.png"));
        itemSaphire.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/materials/saphire.png"));
        nuggetRuby.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/nuggets/ruby.png"));
        nuggetSaphire.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/nuggets/saphire.png"));
        itemCopper.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/materials/copper.png"));
        nuggetCopper.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/nuggets/copper.png"));
        itemTin.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/materials/tin.png"));
        nuggetTin.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/nuggets/tin.png"));


        //BLOCKS
        oreAquamarine.texture = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/ore/aquamarine.png");

        textureOreRuby = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/ore/ruby.png");
        textureOreSaphire = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/ore/saphire.png");
        textureOreCopper = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/ore/copper.png");
        textureBlockTin = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/ore/tin.png");


        textureBlockRuby = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/oreblock/ruby.png");
        textureBlockSaphire = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/oreblock/saphire.png");
        textureBlockCopper = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/oreblock/copper.png");
        textureBlockTin = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/oreblock/tin.png");

        helmetCopper.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/tool/armor/copper_helmet.png"));
        chestplateCopper.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/tool/armor/copper_chestplate.png"));
        leggingsCopper.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/tool/armor/copper_leggings.png"));
        bootsCopper.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/tool/armor/copper_boots.png"));

        helmetRuby.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/tool/armor/ruby_helmet.png"));
        chestplateRuby.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/tool/armor/ruby_chestplate.png"));
        leggingsRuby.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/tool/armor/ruby_leggings.png"));
        bootsRuby.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/tool/armor/ruby_boots.png"));

        helmetSaphire.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/tool/armor/saphire_helmet.png"));
        chestplateSaphire.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/tool/armor/saphire_chestplate.png"));
        leggingsSaphire.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/tool/armor/saphire_leggings.png"));
        bootsSaphire.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/tool/armor/saphire_boots.png"));

        swordCopper.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/tool/sword/copper.png"));
        pickaxeCopper.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/tool/pickaxe/copper.png"));
        swordRuby.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/tool/sword/ruby.png"));
        pickaxeRuby.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/tool/pickaxe/ruby.png"));
        swordSaphire.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/tool/sword/saphire.png"));
        pickaxeSaphire.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/tool/pickaxe/saphire.png"));

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

    public static ItemBase helmetCopper;
    public static ItemBase chestplateCopper;
    public static ItemBase leggingsCopper;
    public static ItemBase bootsCopper;

    public static ItemBase helmetRuby;
    public static ItemBase chestplateRuby;
    public static ItemBase leggingsRuby;
    public static ItemBase bootsRuby;

    public static ItemBase helmetSaphire;
    public static ItemBase chestplateSaphire;
    public static ItemBase leggingsSaphire;
    public static ItemBase bootsSaphire;


    public static ItemBase swordCopper;
    public static ItemBase pickaxeCopper;

    public static ItemBase swordRuby;
    public static ItemBase pickaxeRuby;

    public static ItemBase swordSaphire;
    public static ItemBase pickaxeSaphire;

    public static ItemBase itemTin;
    public static ItemBase nuggetTin;


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
        Property nuggetSaphireID = itemIdsCategory.getProperty("nuggetSaphire", 154);
        Property itemCopperID = itemIdsCategory.getProperty("itemCopper", 155);
        Property nuggetCopperID = itemIdsCategory.getProperty("nuggetCopper", 156);

        itemAquamarine = new ItemBasic(itemAquamarineID.getIntValue()).setName("itemAquamarine");

        itemRuby = new ItemBasic(itemRubyID.getIntValue()).setName("itemRuby");
        itemSaphire = new ItemBasic(itemSaphireID.getIntValue()).setName("itemSaphire");
        nuggetRuby = new ItemBasic(nuggetRubyID.getIntValue()).setName("nuggetRuby");
        nuggetSaphire = new ItemBasic(nuggetSaphireID.getIntValue()).setName("nuggetSaphire");
        itemCopper = new ItemBasic(itemCopperID.getIntValue()).setName("itemCopper");
        nuggetCopper = new ItemBasic(nuggetCopperID.getIntValue()).setName("nuggetCopper");

        Property helmetCopperID = itemIdsCategory.getProperty("helmetCopper", 157);
        Property chestplateCopperID = itemIdsCategory.getProperty("chestplateCopper", 158);
        Property leggingsCopperID = itemIdsCategory.getProperty("leggingsCopper", 159);
        Property bootsCopperID = itemIdsCategory.getProperty("bootsCopper", 160);

        Property helmetRubyID = itemIdsCategory.getProperty("helmetRuby", 161);
        Property chestplateRubyID = itemIdsCategory.getProperty("chestplateRuby", 162);
        Property leggingsRubyID = itemIdsCategory.getProperty("leggingsRuby", 163);
        Property bootsRubyID = itemIdsCategory.getProperty("bootsRuby", 164);

        Property helmetSaphireID = itemIdsCategory.getProperty("helmetSaphire", 165);
        Property chestplateSaphireID = itemIdsCategory.getProperty("chestplateSaphire", 166);
        Property leggingsSaphireID = itemIdsCategory.getProperty("leggingsSaphire", 167);
        Property bootsSaphireID = itemIdsCategory.getProperty("bootsSaphire", 168);


        helmetCopper = new ArmourExtended(helmetCopperID.getIntValue(), 1, 1, 0, 0).setName("helmetCopper");
        chestplateCopper = new ArmourExtended(chestplateCopperID.getIntValue(), 1, 1, 1, 0).setName("chestplateCopper");
        leggingsCopper = new ArmourExtended(leggingsCopperID.getIntValue(), 1, 1, 2, 0).setName("leggingsCopper");
        bootsCopper = new ArmourExtended(bootsCopperID.getIntValue(), 1, 1, 3, 0).setName("bootsCopper");

        helmetRuby = new ArmourExtended(helmetRubyID.getIntValue(), 3, 3, 0, 1).setName("helmetRuby");
        chestplateRuby = new ArmourExtended(chestplateRubyID.getIntValue(), 3, 3, 1, 1).setName("chestplateRuby");
        leggingsRuby = new ArmourExtended(leggingsRubyID.getIntValue(), 3, 3, 2, 1).setName("leggingsRuby");
        bootsRuby = new ArmourExtended(bootsRubyID.getIntValue(), 3, 3, 3, 1).setName("bootsRuby");

        helmetSaphire = new ArmourExtended(helmetSaphireID.getIntValue(), 3, 3, 0, 2).setName("helmetSaphire");
        chestplateSaphire = new ArmourExtended(chestplateSaphireID.getIntValue(), 3, 3, 1, 2).setName("chestplateSaphire");
        leggingsSaphire = new ArmourExtended(leggingsSaphireID.getIntValue(), 3, 3, 2, 2).setName("leggingsSaphire");
        bootsSaphire = new ArmourExtended(bootsSaphireID.getIntValue(), 3, 3, 3, 2).setName("bootsSaphire");

        Property swordCopperID = itemIdsCategory.getProperty("swordCopper", 169);
        Property pickaxeCopperID = itemIdsCategory.getProperty("pickaxeCopper", 170);
        Property swordRubyID = itemIdsCategory.getProperty("swordRuby", 171);
        Property pickaxeRubyID = itemIdsCategory.getProperty("pickaxeRuby", 172);
        Property swordSaphireID = itemIdsCategory.getProperty("swordSaphire", 173);
        Property pickaxeSaphireID = itemIdsCategory.getProperty("pickaxeSaphire", 174);

        swordCopper = new Sword(swordCopperID.getIntValue(), ChickenMod.toolCopper).setName("swordCopper");
        pickaxeCopper = new PickaxeBasic(pickaxeCopperID.getIntValue(), ChickenMod.toolCopper).setName("pickaxeCopper");
        swordRuby = new Sword(swordRubyID.getIntValue(), ChickenMod.toolGems).setName("swordRuby");
        pickaxeRuby = new PickaxeBasic(pickaxeRubyID.getIntValue(), ChickenMod.toolGems).setName("pickaxeRuby");
        swordSaphire = new Sword(swordSaphireID.getIntValue(), ChickenMod.toolGems).setName("swordSaphire");
        pickaxeSaphire = new PickaxeBasic(pickaxeSaphireID.getIntValue(), ChickenMod.toolGems).setName("pickaxeSaphire");

        Property itemTinID = itemIdsCategory.getProperty("itemTin", 175);
        Property nuggetTinID = itemIdsCategory.getProperty("nuggetTin", 176);
        itemTin = new ItemBasic(itemTinID.getIntValue()).setName("itemTin");
        nuggetTin = new ItemBasic(nuggetTinID.getIntValue()).setName("nuggetTin");

        config.save();
    }
}
