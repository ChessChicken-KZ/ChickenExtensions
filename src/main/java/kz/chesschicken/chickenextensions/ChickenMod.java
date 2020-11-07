package kz.chesschicken.chickenextensions;


import kz.chesschicken.chickenextensions.api.common.*;
import net.fabricmc.loader.discovery.DirectoryModCandidateFinder;
import net.minecraft.block.BlockBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.item.tool.ToolMaterial;
import net.modificationstation.stationloader.api.client.event.render.entity.EntityRendererRegister;
import net.modificationstation.stationloader.api.client.event.texture.TextureRegister;
import net.modificationstation.stationloader.api.client.texture.TextureRegistry;
import net.modificationstation.stationloader.api.common.config.Category;
import net.modificationstation.stationloader.api.common.config.Configuration;
import net.modificationstation.stationloader.api.common.config.Property;
import net.modificationstation.stationloader.api.common.entity.player.PlayerHandler;
import net.modificationstation.stationloader.api.common.event.block.BlockRegister;
import net.modificationstation.stationloader.api.common.event.entity.EntityRegister;
import net.modificationstation.stationloader.api.common.event.entity.player.PlayerHandlerRegister;
import net.modificationstation.stationloader.api.common.event.item.ItemRegister;
import net.modificationstation.stationloader.api.common.event.level.biome.BiomeByClimateProvider;
import net.modificationstation.stationloader.api.common.event.level.biome.BiomeRegister;
import net.modificationstation.stationloader.api.common.event.level.gen.ChunkPopulator;
import net.modificationstation.stationloader.api.common.event.recipe.RecipeRegister;
import net.modificationstation.stationloader.api.common.factory.GeneralFactory;
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

    public static String VERSION = "0.0.3era-alpha";

    public static ToolMaterial toolGems;
    public static ToolMaterial toolCopper;
    public static boolean isCheckVersion;
    public static boolean isDeathChest;

    @Override
    public void preInit()
    {
        RegisteringClass registeringClass = new RegisteringClass();
        RegisteringMetals registeringMetals = new RegisteringMetals();
        RegisteringBiome registeringBiome = new RegisteringBiome();
        RegisteringEntity registeringEntity = new RegisteringEntity();

        toolGems = GeneralFactory.INSTANCE.newInst(ToolMaterial.class, "chickenextensions:GEMS",3, 1561, 8.0F, 3);
        toolCopper = GeneralFactory.INSTANCE.newInst(ToolMaterial.class, "chickenextensions:COPPER", 1, 220, 5.0F, 2);



        ItemRegister.EVENT.register(registeringClass);
        ItemRegister.EVENT.register(registeringMetals);
        BlockRegister.EVENT.register(registeringClass);
        BlockRegister.EVENT.register(registeringMetals);

        TextureRegister.EVENT.register(this);
        TextureRegister.EVENT.register(registeringMetals);
        EntityRendererRegister.EVENT.register(registeringEntity);

        EntityRegister.EVENT.register(registeringEntity);
        RecipeRegister.EVENT.register(this);
        BiomeRegister.EVENT.register(registeringBiome);
        BiomeByClimateProvider.EVENT.register(registeringBiome);
        ChunkPopulator.EVENT.register(new RegisteringPopulator());
        PlayerHandlerRegister.EVENT.register(registeringEntity);
        loadCustomConfigPart();

        getDefaultConfig().load();
    }

    private void loadCustomConfigPart()
    {
        Category miscCategory = getDefaultConfig().getCategory("Misc");
        Property checkVersion = miscCategory.getProperty("checkVersion", true);
        Property deathChest = miscCategory.getProperty("deathChest", true);
        isCheckVersion = checkVersion.getBooleanValue();
        isDeathChest = deathChest.getBooleanValue();
        getDefaultConfig().save();
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

    public static int texCeilingLamp;


    @Override
    public void registerTextures() {
        texBrickSoul_BLOCK = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/build/blockBrickSoul.png");
        texBrickSoul_BLOCK1 = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/build/blockBrickSoul1.png");
        texNetherMossy = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/build/blockNetherrack0.png");
        textColourSapling = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/colour/tileSapling.png");
        textColourLeaves = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/colour/tileLeaves.png");
        textColourLeaves_Fast = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/colour/tileLeavesOpaque.png");
        textColourFlower = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/colour/tileFlower.png");


        texBrickNether = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/build/blockBrickNether0.png");

        texBrickNormal0 = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/build/blockBrickNormal0.png");
        texBrickNormal1 = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/build/blockBrickNormal1.png");
        texBrickNormal2 = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/build/blockBrickNormal2.png");
        texBrickNormal3 = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/build/blockBrickNormal3.png");

        texMachineCartDispenser = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/machineCartDispenser.png");
        texCeilingLamp = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furniture/blockCeilingLamp.png");

        RegisteringClass.itemBrickSoul.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/materials/brickSoul.png"));
        RegisteringClass.itemLightShoker.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/tool/itemLightShoker.png"));
        RegisteringClass.itemBrickNether.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/materials/brickNether.png"));

        RegisteringClass.itemSteakRaw.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/food/SteakRaw.png"));
        RegisteringClass.itemSteakCooked.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/food/SteakCook.png"));
        RegisteringClass.itemMuttonRaw.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/food/MuttonRaw.png"));
        RegisteringClass.itemMuttonCooked.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/food/MuttonCook.png"));
        RegisteringClass.itemChickenRaw.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/food/ChickenRaw.png"));
        RegisteringClass.itemChickenCooked.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/food/ChickenCook.png"));
        RegisteringClass.itemChainmail.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/materials/chainmail.png"));

        RegisteringClass.itemIronNugget.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/nuggets/iron.png"));
        RegisteringClass.itemGoldNugget.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/nuggets/gold.png"));
        RegisteringClass.itemDiamondNugget.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/nuggets/diamond.png"));
        RegisteringClass.itemMobCatcher.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/itemMobCatcher.png"));

        RegisteringClass.itemEggGold.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/itemEggGold.png"));
        RegisteringClass.itemBiomeLocator.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/itemBiomeLocator.png"));

        texCabinetTop = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furniture/furnitureCabinetTop.png");
        texCabinetSide = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furniture/furnitureCabinetSide.png");
        texCabinetFront = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furniture/furnitureCabinetFront.png");

        texNightstandTop = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furniture/furnitureNightstandTop.png");
        texNightstandSide = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furniture/furnitureNightstandSide.png");
        texNightstandFront = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furniture/furnitureNightstandFront.png");

        texBoxTop = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furniture/furnitureBoxTop.png");
        texBoxSide = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furniture/furnitureBoxSide.png");
        texBoxFront = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furniture/furnitureBoxFront.png");

        texBrickLimestone = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/build/blockBrickLimestone.png");
        texBrickSnow = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/build/blockBrickSnow.png");
        texBrickSlakedLime = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/build/blockBrickSlakedLime.png");

        texLocker = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furniture/furnitureLocker.png");

        texCommodeTop = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furniture/furnitureCommodeTop.png");
        texCommodeSide = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furniture/furnitureCommodeSide.png");
        texCommodeFront = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furniture/furnitureCommodeFront.png");

        texFridgeSide = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furniture/furnitureFridgeSide.png");
        texFridgeBack = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furniture/furnitureFridgeBack.png");
        texFridgeFront = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furniture/furnitureFridgeFront.png");

        RegisteringClass.itemLimestone.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/materials/limestone.png"));
        RegisteringClass.itemTile.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/itemTile.png"));
        RegisteringClass.itemSlakedLime.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/materials/slakedLime.png"));

        RegisteringClass.blockChandelier.texture = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/chickenextensions/textures/block/furniture/blockChandelier.png");
        RegisteringClass.boatObsidian.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/chickenextensions/textures/item/tool/boatObsidian.png"));

    }



        @Override
    public void registerRecipes(String string) {
        Vanilla type = Vanilla.fromType(string);
        switch (type) {
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
