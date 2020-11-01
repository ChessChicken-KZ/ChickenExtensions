package kz.chesschicken.chickenextensions;


import kz.chesschicken.chickenextensions.api.RegisteringBiome;
import kz.chesschicken.chickenextensions.api.RegisteringPopulator;
import kz.chesschicken.chickenextensions.api.RegisteringClass;
import net.minecraft.block.BlockBase;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Item;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.modificationstation.stationloader.api.client.event.texture.TextureRegister;
import net.modificationstation.stationloader.api.client.texture.TextureRegistry;
import net.modificationstation.stationloader.api.common.StationLoader;
import net.modificationstation.stationloader.api.common.event.block.BlockRegister;
import net.modificationstation.stationloader.api.common.event.entity.EntityRegister;
import net.modificationstation.stationloader.api.common.event.item.ItemRegister;
import net.modificationstation.stationloader.api.common.event.level.biome.BiomeRegister;
import net.modificationstation.stationloader.api.common.event.level.gen.ChunkPopulator;
import net.modificationstation.stationloader.api.common.event.recipe.RecipeRegister;
import net.modificationstation.stationloader.api.common.mod.StationMod;
import net.modificationstation.stationloader.api.common.recipe.CraftingRegistry;
import net.modificationstation.stationloader.api.common.recipe.SmeltingRegistry;
import net.modificationstation.stationloader.impl.client.texture.TextureFactory;

import java.awt.*;

public class ChickenMod implements StationMod, TextureRegister, RecipeRegister
{
    public static ChickenMod INSTANCE;
    public ChickenMod()
    {
        INSTANCE = this;
    }


    @Override
    public void preInit()
    {

        TextureRegister.EVENT.register(this);

        ItemRegister.EVENT.register(new RegisteringClass());
        BlockRegister.EVENT.register(new RegisteringClass());
        EntityRegister.EVENT.register(new RegisteringClass());
        RecipeRegister.EVENT.register(this);
        BiomeRegister.EVENT.register(new RegisteringBiome());
        ChunkPopulator.EVENT.register(new RegisteringPopulator());



        getDefaultConfig().load();
    }





    public int get16ColorCode(int colortype)
    {
        switch (colortype)
        {
            case 0:
                return new Color(221,221,221).getRGB();
            case 1:
                return new Color(219,125,62).getRGB();
            case 2:
                return new Color(179,80,188).getRGB();
            case 3:
                return new Color(107,138,201).getRGB();
            case 4:
                return new Color(177,166,39).getRGB();
            case 5:
                return new Color(65,164,56).getRGB();
            case 6:
                return new Color(208,132,153).getRGB();
            case 7:
                return new Color(64,64,64).getRGB();
            case 8:
                return new Color(154,161,161).getRGB();
            case 9:
                return new Color(46,110,137).getRGB();
            case 10:
                return new Color(126,61,181).getRGB();
            case 11:
                return new Color(46,56,141).getRGB();
            case 12:
                return new Color(79,50,31).getRGB();
            case 13:
                return new Color(53,70,27).getRGB();
            case 14:
                return new Color(150,52,48).getRGB();
            case 15:
                return new Color(25,22,22).getRGB();
        }
        return 0;
    }

    public static int texBrickSoul_BLOCK;
    public static int texBrickSoul_BLOCK1;
    public static int texNetherMossy;
    public static int textColourSapling;
    public static int textColourLeaves;
    public static int textColourLeaves_Fast;
    public static int textColourFlower;

    public static int texBrickNether;
    public static int texBrickNormal0;
    public static int texBrickNormal1;
    public static int texBrickNormal2;
    public static int texBrickNormal3;

    public static int texBrickLimestone;
    public static int texBrickSnow;
    public static int texBrickSlakedLime;

    public static int texMachineCartDispenser;

    public static int texCabinetTop;
    public static int texCabinetSide;
    public static int texCabinetFront;
    public static int texNightstandTop;
    public static int texNightstandSide;
    public static int texNightstandFront;
    public static int texBoxTop;
    public static int texBoxSide;
    public static int texBoxFront;
    public static int texLocker;
    public static int texCommodeTop;
    public static int texCommodeSide;
    public static int texCommodeFront;
    public static int texFridgeSide;
    public static int texFridgeFront;
    public static int texFridgeBack;


    @Override
    public void registerTextures() {
        texBrickSoul_BLOCK = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/blockBrickSoul.png");
        texBrickSoul_BLOCK1 = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/blockBrickSoul1.png");
        texNetherMossy = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/blockNetherrack0.png");
        textColourSapling = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/tileSapling_COLOUR.png");
        textColourLeaves = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/tileLeaves_COLOUR.png");
        textColourLeaves_Fast = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/tileLeavesOpaque_COLOUR.png");
        textColourFlower = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/tileFlower_COLOUR.png");


        texBrickNether = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/blockBrickNether0.png");

        texBrickNormal0 = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/blockBrickNormal0.png");
        texBrickNormal1 = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/blockBrickNormal1.png");
        texBrickNormal2 = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/blockBrickNormal2.png");
        texBrickNormal3 = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/blockBrickNormal3.png");

        texMachineCartDispenser = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/machineCartDispenser.png");

        RegisteringClass.lampCeiling.texture = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/blockCeilingLamp.png");


        RegisteringClass.itemBrickSoul.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/itemBrickSoul.png"));
        RegisteringClass.itemLightShoker.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/itemLightShoker.png"));
        RegisteringClass.itemBrickNether.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/itemBrickNether.png"));
        RegisteringClass.itemAquamarine.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/itemAquamarine.png"));

        RegisteringClass.itemSteakRaw.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/itemSteak_raw.png"));
        RegisteringClass.itemSteakCooked.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/itemSteak_cooked.png"));
        RegisteringClass.itemMuttonRaw.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/itemMutton_raw.png"));
        RegisteringClass.itemMuttonCooked.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/itemMutton_cooked.png"));
        RegisteringClass.itemChickenRaw.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/itemChicken_raw.png"));
        RegisteringClass.itemChickenCooked.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/itemChicken_cooked.png"));
        RegisteringClass.itemChainmail.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/itemChainmail.png"));

        RegisteringClass.itemIronNugget.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/itemNugget_iron.png"));
        RegisteringClass.itemGoldNugget.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/itemNugget_gold.png"));
        RegisteringClass.itemDiamondNugget.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/itemNugget_diamond.png"));
        RegisteringClass.itemMobCatcher.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/itemMobCatcher.png"));

        RegisteringClass.itemEggGold.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/itemEggGold.png"));
        RegisteringClass.itemBiomeLocator.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/itemBiomeLocator.png"));
        RegisteringClass.itemRuby.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/itemRuby.png"));
        RegisteringClass.itemSaphire.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/itemSaphire.png"));

        RegisteringClass.oreAquamarine.texture = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/oreAquamarine.png");
        RegisteringClass.oreRuby.texture = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/oreRuby.png");
        RegisteringClass.oreSaphire.texture = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/oreSaphire.png");

        texCabinetTop = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furnitureCabinetTop.png");
        texCabinetSide = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furnitureCabinetSide.png");
        texCabinetFront = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furnitureCabinetFront.png");

        texNightstandTop = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furnitureNightstandTop.png");
        texNightstandSide = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furnitureNightstandSide.png");
        texNightstandFront = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furnitureNightstandFront.png");

        texBoxTop = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furnitureBoxTop.png");
        texBoxSide = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furnitureBoxSide.png");
        texBoxFront = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furnitureBoxFront.png");

        texBrickLimestone = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/blockBrickLimestone.png");
        texBrickSnow = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/blockBrickSnow.png");
        texBrickSlakedLime = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/blockBrickSlakedLime.png");

        texLocker = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furnitureLocker.png");

        texCommodeTop = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furnitureCommodeTop.png");
        texCommodeSide = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furnitureCommodeSide.png");
        texCommodeFront = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furnitureCommodeFront.png");

        texFridgeSide = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furnitureFridgeSide.png");
        texFridgeBack = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furnitureFridgeBack.png");
        texFridgeFront = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furnitureFridgeFront.png");

        RegisteringClass.itemLimestone.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/itemLimestone.png"));
        RegisteringClass.itemTile.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/itemTile.png"));
        RegisteringClass.itemSlakedLime.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/itemSlakedLime.png"));

        RegisteringClass.blockChandelier.texture = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/blockChandelier.png");

    }



        @Override
    public void registerRecipes(String string) {
        Vanilla type = Vanilla.fromType(string);
        switch (type) {
            case CRAFTING_SHAPED: {
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.blockCouple1, 1, 0), "XX", "XX", Character.valueOf('X'), RegisteringClass.itemBrickSoul);

                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.blockCouple1, 4, 3), "XX", "XX", Character.valueOf('X'), BlockBase.STONE);
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.blockCouple1, 1, 2), "XX", "XX", Character.valueOf('X'), RegisteringClass.itemBrickNether);

                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.blockCouple1, 4, 3), "XX", "XX", Character.valueOf('X'), new ItemInstance(RegisteringClass.blockCouple1, 1, 6));
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.blockCouple1, 4, 6), "XX", "XX", Character.valueOf('X'), new ItemInstance(RegisteringClass.blockCouple1, 1, 3));

                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.machineCartDiapenser), "XXX", "XHX", "XWX", Character.valueOf('X'), BlockBase.COBBLESTONE, Character.valueOf('H'), BlockBase.DETECTOR_RAIL, Character.valueOf('W'), ItemBase.redstoneDust);
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.itemChainmail), " X ", "XHX", " X ", Character.valueOf('X'), RegisteringClass.itemIronNugget, Character.valueOf('H'), ItemBase.ironIngot);

                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(ItemBase.ironIngot), "XXX", "XXX", "XXX", Character.valueOf('X'), RegisteringClass.itemIronNugget);
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(ItemBase.goldIngot), "XXX", "XXX", "XXX", Character.valueOf('X'), RegisteringClass.itemGoldNugget);
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(ItemBase.diamond), "XXX", "XXX", "XXX", Character.valueOf('X'), RegisteringClass.itemDiamondNugget);

                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(ItemBase.chainHelmet), "XXX", "X X", Character.valueOf('X'), RegisteringClass.itemChainmail);
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(ItemBase.chainChestplate), "X X", "XXX", "XXX", Character.valueOf('X'), RegisteringClass.itemChainmail);
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(ItemBase.chainLeggings), "XXX", "X X", "X X", Character.valueOf('X'), RegisteringClass.itemChainmail);
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(ItemBase.chainBoots), "X X", "X X", Character.valueOf('X'), RegisteringClass.itemChainmail);

                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.netherStairs, 4), "  X", " XX", "XXX", Character.valueOf('X'), BlockBase.NETHERRACK);
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.mossyCobblestoneStairs, 4), "  X", " XX", "XXX", Character.valueOf('X'), BlockBase.MOSSY_COBBLESTONE);
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.bricksStairs, 4), "  X", " XX", "XXX", Character.valueOf('X'), BlockBase.BRICK);
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.soulBrickStairs, 4), "  X", " XX", "XXX", Character.valueOf('X'), new ItemInstance(RegisteringClass.blockCouple1, 1, 0));
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.mossySoulBrickStairs, 4), "  X", " XX", "XXX", Character.valueOf('X'), new ItemInstance(RegisteringClass.blockCouple1, 1, 1));
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.netherBrickStairs, 4), "  X", " XX", "XXX", Character.valueOf('X'), new ItemInstance(RegisteringClass.blockCouple1, 1, 2));
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.normalBrickStairs, 4), "  X", " XX", "XXX", Character.valueOf('X'), new ItemInstance(RegisteringClass.blockCouple1, 1, 3));
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.stoneStairs, 4), "  X", " XX", "XXX", Character.valueOf('X'), BlockBase.STONE);

                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.fenceExtended, 2, 0), "XXX", "XXX",  Character.valueOf('X'), BlockBase.NETHERRACK);
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.fenceExtended, 2, 1), "XXX", "XXX",  Character.valueOf('X'), BlockBase.MOSSY_COBBLESTONE);
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.fenceExtended, 2, 2), "XXX", "XXX",  Character.valueOf('X'), BlockBase.BRICK);
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.fenceExtended, 2, 3), "XXX", "XXX",  Character.valueOf('X'), BlockBase.COBBLESTONE);
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.fenceExtended, 2, 4), "XXX", "XXX",  Character.valueOf('X'), new ItemInstance(RegisteringClass.blockCouple1, 1, 0));
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.fenceExtended, 2, 5), "XXX", "XXX",  Character.valueOf('X'), new ItemInstance(RegisteringClass.blockCouple1, 1, 1));
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.fenceExtended, 2, 6), "XXX", "XXX",  Character.valueOf('X'), new ItemInstance(RegisteringClass.blockCouple1, 1, 2));
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.fenceExtended, 2, 7), "XXX", "XXX",  Character.valueOf('X'), new ItemInstance(RegisteringClass.blockCouple1, 1, 3));
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.fenceExtended, 2, 8), "XXX", "XXX", Character.valueOf('X'), BlockBase.STONE);
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.fenceExtended, 2, 9), "XXX", "XXX", Character.valueOf('X'), BlockBase.SANDSTONE);
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.fenceExtended, 2, 10), "XXX", "XXX", Character.valueOf('X'), BlockBase.STONE_SLAB);

                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.lampCeiling), "WWW", "XXX", " X ",  Character.valueOf('X'), BlockBase.TORCH, Character.valueOf('W'), new ItemInstance(BlockBase.STONE_SLAB, 1 ,2));
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.sandStoneStairs), "  X", " XX", "XXX", Character.valueOf('X'), BlockBase.SANDSTONE);
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.stoneSmoothStairs), "  X", " XX", "XXX",  Character.valueOf('X'), BlockBase.STONE_SLAB);

                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.extendedSlabs, 3, 0), "XXX", Character.valueOf('X'), BlockBase.NETHERRACK);
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.extendedSlabs, 3, 1), "XXX",  Character.valueOf('X'), BlockBase.MOSSY_COBBLESTONE);
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.extendedSlabs, 3, 2), "XXX",  Character.valueOf('X'), BlockBase.BRICK);
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.extendedSlabs, 3, 3), "XXX",  Character.valueOf('X'), BlockBase.COBBLESTONE);
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.extendedSlabs, 3, 4), "XXX",  Character.valueOf('X'), new ItemInstance(RegisteringClass.blockCouple1, 1, 0));
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.extendedSlabs, 3, 5), "XXX",  Character.valueOf('X'), new ItemInstance(RegisteringClass.blockCouple1, 1, 1));
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.extendedSlabs, 3, 6), "XXX",  Character.valueOf('X'), new ItemInstance(RegisteringClass.blockCouple1, 1, 2));
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.extendedSlabs, 3, 7), "XXX",  Character.valueOf('X'), new ItemInstance(RegisteringClass.blockCouple1, 1, 3));
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.extendedSlabs, 3, 8), "XXX", Character.valueOf('X'), BlockBase.STONE);
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.itemBiomeLocator), "XWX", "WAW", "XWX", Character.valueOf('X'), BlockBase.SAPLING, Character.valueOf('W'), ItemBase.goldIngot, Character.valueOf('A'), BlockBase.CACTUS);

                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.blockCouple1, 4, 8), "XX", "XX", Character.valueOf('X'), BlockBase.SNOW);
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.itemTile), "X", "X", Character.valueOf('X'), RegisteringClass.itemSlakedLime);

                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.blockCouple1, 4, 7), "XX", "XX", Character.valueOf('X'), RegisteringClass.itemLimestone);
                CraftingRegistry.INSTANCE.addShapedRecipe(new ItemInstance(RegisteringClass.blockCouple1, 4, 9), "XX", "XX", Character.valueOf('X'), RegisteringClass.itemSlakedLime);

                break;
            }
            case CRAFTING_SHAPELESS: {
                CraftingRegistry.INSTANCE.addShapelessRecipe(new ItemInstance(RegisteringClass.itemIronNugget, 9), ItemBase.ironIngot);
                CraftingRegistry.INSTANCE.addShapelessRecipe(new ItemInstance(RegisteringClass.itemGoldNugget, 9), ItemBase.goldIngot);
                CraftingRegistry.INSTANCE.addShapelessRecipe(new ItemInstance(RegisteringClass.itemDiamondNugget, 9), ItemBase.diamond);

                //DEBUG
                CraftingRegistry.INSTANCE.addShapelessRecipe(new ItemInstance(RegisteringClass.itemMobCatcher), BlockBase.DIRT);
                CraftingRegistry.INSTANCE.addShapelessRecipe(new ItemInstance(RegisteringClass.furnitureNightstand), ItemBase.stick);
                CraftingRegistry.INSTANCE.addShapelessRecipe(new ItemInstance(RegisteringClass.furnitureBox), BlockBase.WOOD);
                //DEBUG
                break;
            }
            case SMELTING: {
                SmeltingRegistry.INSTANCE.addSmeltingRecipe(BlockBase.SOUL_SAND.id, new ItemInstance(RegisteringClass.itemBrickSoul));
                SmeltingRegistry.INSTANCE.addSmeltingRecipe(BlockBase.NETHERRACK.id, new ItemInstance(RegisteringClass.itemBrickNether));
                SmeltingRegistry.INSTANCE.addSmeltingRecipe(RegisteringClass.itemSteakRaw.id, new ItemInstance(RegisteringClass.itemSteakCooked));
                SmeltingRegistry.INSTANCE.addSmeltingRecipe(RegisteringClass.itemMuttonRaw.id, new ItemInstance(RegisteringClass.itemMuttonCooked));
                SmeltingRegistry.INSTANCE.addSmeltingRecipe(RegisteringClass.itemChickenRaw.id, new ItemInstance(RegisteringClass.itemChickenCooked));
                SmeltingRegistry.INSTANCE.addSmeltingRecipe(new ItemInstance(RegisteringClass.blockCouple1, 1,9), new ItemInstance(RegisteringClass.blockCouple1, 1, 7));
                SmeltingRegistry.INSTANCE.addSmeltingRecipe(RegisteringClass.itemLimestone.id, new ItemInstance(RegisteringClass.itemSlakedLime));

                break;
            }
        }
    }

}
