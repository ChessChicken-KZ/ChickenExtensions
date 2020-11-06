package kz.chesschicken.chickenextensions.api.common;

import kz.chesschicken.chickenextensions.ChickenMod;
import kz.chesschicken.chickenextensions.api.player.CustomPlayerHandler;
import kz.chesschicken.chickenextensions.block.*;
import kz.chesschicken.chickenextensions.block.colour.*;
import kz.chesschicken.chickenextensions.block.extensions.FenceExtended;
import kz.chesschicken.chickenextensions.block.extensions.SlabsExtended;
import kz.chesschicken.chickenextensions.block.extensions.StairsExtended;
import kz.chesschicken.chickenextensions.block.extensions.TileItemExtended;
import kz.chesschicken.chickenextensions.block.furniture.BlockContainerFurniture;
import kz.chesschicken.chickenextensions.entity.BloodyPigman;
import kz.chesschicken.chickenextensions.item.ItemBasic;
import kz.chesschicken.chickenextensions.item.ItemBiomeLocator;
import kz.chesschicken.chickenextensions.item.ItemLightBomb;
import kz.chesschicken.chickenextensions.item.mobcatcher.ItemMobCatcher;
import kz.chesschicken.chickenextensions.item.goldenegg.GoldenEgg;
import net.minecraft.block.BlockBase;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.food.FoodBase;
import net.modificationstation.stationloader.api.common.config.Category;
import net.modificationstation.stationloader.api.common.config.Configuration;
import net.modificationstation.stationloader.api.common.config.Property;
import net.modificationstation.stationloader.api.common.entity.player.PlayerHandler;
import net.modificationstation.stationloader.api.common.event.block.BlockRegister;
import net.modificationstation.stationloader.api.common.event.entity.EntityRegister;
import net.modificationstation.stationloader.api.common.event.entity.player.PlayerHandlerRegister;
import net.modificationstation.stationloader.api.common.event.item.ItemRegister;
import uk.co.benjiweber.expressions.functions.TriConsumer;

import java.util.List;

public class RegisteringClass implements ItemRegister, BlockRegister, EntityRegister, PlayerHandlerRegister {
    public static ItemBase itemLightShoker;
    public static ItemBase itemBrickSoul;
    public static ItemBase itemBrickNether;
    public static BlockBase blockCouple1;
    public static BlockBase blockSaplingC;
    public static BlockBase blockNetherrackMossy;
    public static BlockBase blockLeavesC;
    public static BlockBase blockFlowerC;
    public static ItemBase itemSteakRaw;
    public static ItemBase itemSteakCooked;
    public static ItemBase itemMuttonRaw;
    public static ItemBase itemMuttonCooked;
    public static ItemBase itemChickenRaw;
    public static ItemBase itemChickenCooked;
    public static BlockBase machineCartDiapenser;
    public static ItemBase itemChainmail;
    public static ItemBase itemIronNugget;
    public static ItemBase itemGoldNugget;
    public static ItemBase itemDiamondNugget;
    public static ItemBase itemMobCatcher;
    public static ItemBase itemEggGold;
    public static BlockBase netherStairs;
    public static BlockBase mossyCobblestoneStairs;
    public static BlockBase bricksStairs;
    public static BlockBase soulBrickStairs;
    public static BlockBase mossySoulBrickStairs;
    public static BlockBase netherBrickStairs;
    public static BlockBase normalBrickStairs;
    public static BlockBase stoneStairs;
    public static BlockBase fenceExtended;
    public static BlockBase stoneSmoothStairs;
    public static BlockBase sandStoneStairs;
    public static BlockBase extendedSlabs;
    public static BlockBase extendedDoubleSlabs;
    public static BlockBase lampCeiling;
    public static ItemBase itemBiomeLocator;
    public static BlockBase furnitureCabinet;
    public static BlockBase furnitureNightstand;
    public static BlockBase furnitureBox;
    public static BlockBase furnitureLocker;
    public static BlockBase furnitureCommode;
    public static BlockBase furnitureFridge;
    public static ItemBase itemLimestone;
    public static ItemBase itemTile;
    public static ItemBase itemSlakedLime;
    public static BlockBase blockChandelier;


    @Override
    public void registerItems()
    {
        Configuration config = ChickenMod.INSTANCE.getDefaultConfig();
        Category itemIdsCategory = config.getCategory("Item IDs");
        Property itemLightBombID = itemIdsCategory.getProperty("itemLightShoker", 130);
        Property itemBrickSoulID = itemIdsCategory.getProperty("itemBrickSoul", 131);
        Property itemBrickNetherID = itemIdsCategory.getProperty("itemBrickNether", 132);
        Property itemSteakRawID = itemIdsCategory.getProperty("itemSteakRaw", 134);
        Property itemSteakCookedID = itemIdsCategory.getProperty("itemSteakCooked", 135);
        Property itemMuttonRawID = itemIdsCategory.getProperty("itemMuttonRaw", 136);
        Property itemMuttonCookedID = itemIdsCategory.getProperty("itemMuttonCooked", 137);
        Property itemChickenRawID = itemIdsCategory.getProperty("itemChickenRaw", 138);
        Property itemChickenCookedID = itemIdsCategory.getProperty("itemChickenCooked", 139);
        Property itemChainmailID = itemIdsCategory.getProperty("itemChainmail", 140);
        Property itemIronNuggetID = itemIdsCategory.getProperty("itemIronNugget", 141);
        Property itemGoldNuggetID = itemIdsCategory.getProperty("itemGoldNugget", 142);
        Property itemDiamondNuggetID = itemIdsCategory.getProperty("itemDiamondNugget", 143);
        Property itemMobCatcherID = itemIdsCategory.getProperty("itemMobCatcher", 144);
        Property itemEggGoldID = itemIdsCategory.getProperty("itemEggGold", 145);
        Property itemBiomeLocatorID = itemIdsCategory.getProperty("itemBiomeFinder", 146);
        Property itemLimestoneID = itemIdsCategory.getProperty("itemLimestone", 149);
        Property itemTileID = itemIdsCategory.getProperty("itemTile", 150);
        Property itemSlakedLimeID = itemIdsCategory.getProperty("itemSlakedLime", 151);

        itemLightShoker = new ItemLightBomb(itemLightBombID.getIntValue()).setName("chickenextensions:itemLightShoker");
        itemBrickSoul = new ItemBasic(itemBrickSoulID.getIntValue()).setName("chickenextensions:itemBrickSoul");
        itemBrickNether = new ItemBasic(itemBrickNetherID.getIntValue()).setName("chickenextensions:itemBrickNether");
        itemSteakRaw = new FoodBase(itemSteakRawID.getIntValue(), 4, true).setName("chickenextensions:itemSteakRaw");
        itemSteakCooked = new FoodBase(itemSteakCookedID.getIntValue(), 8, true).setName("chickenextensions:itemSteakCooked");
        itemMuttonRaw = new FoodBase(itemMuttonRawID.getIntValue(), 4, true).setName("chickenextensions:itemMuttonRaw");
        itemMuttonCooked = new FoodBase(itemMuttonCookedID.getIntValue(), 7, true).setName("chickenextensions:itemMuttonCooked");
        itemChickenRaw = new FoodBase(itemChickenRawID.getIntValue(), 3, true).setName("chickenextensions:itemChickenRaw");
        itemChickenCooked = new FoodBase(itemChickenCookedID.getIntValue(), 6, true).setName("chickenextensions:itemChickenCooked");
        itemChainmail = new ItemBasic(itemChainmailID.getIntValue()).setName("chickenextensions:itemChainmail");
        itemIronNugget = new ItemBasic(itemIronNuggetID.getIntValue()).setName("chickenextensions:itemIronNugget");
        itemGoldNugget = new ItemBasic(itemGoldNuggetID.getIntValue()).setName("chickenextensions:itemGoldNugget");
        itemDiamondNugget = new ItemBasic(itemDiamondNuggetID.getIntValue()).setName("chickenextensions:itemDiamondNugget");
        itemMobCatcher = new ItemMobCatcher(itemMobCatcherID.getIntValue()).setName("chickenextensions:itemMobCatcher");
        itemEggGold = new GoldenEgg(itemEggGoldID.getIntValue()).setName("chickenextensions:itemEggGold");
        itemBiomeLocator = new ItemBiomeLocator(itemBiomeLocatorID.getIntValue()).setName("chickenextensions:itemBiomeLocator");
        itemLimestone = new ItemBasic(itemLimestoneID.getIntValue()).setName("chickenextensions:itemLimestone");
        itemTile = new ItemBasic(itemTileID.getIntValue()).setName("chickenextensions:itemTile");
        itemSlakedLime = new ItemBasic(itemSlakedLimeID.getIntValue()).setName("chickenextensions:itemSlakedLime");


    }


    @Override
    public void registerBlocks() {
        Configuration config = ChickenMod.INSTANCE.getDefaultConfig();
        Category blockIdsCategory = config.getCategory("Block IDs");
        Property blockCouple1ID = blockIdsCategory.getProperty("blockCouple1", 131);
        Property blockSaplingCID = blockIdsCategory.getProperty("blockSaplingC", 132);
        Property blockNetherrackMossyID = blockIdsCategory.getProperty("blockNetherrackMossy", 133);
        Property blockLeavesCID = blockIdsCategory.getProperty("blockLeavesC", 134);
        Property blockFlowerCID = blockIdsCategory.getProperty("blockFlowerC", 135);
        Property machineCartDiapenserID = blockIdsCategory.getProperty("machineCartDiapenser", 137);
        Property netherStairsID = blockIdsCategory.getProperty("netherStairs", 138);
        Property mossyCobblestoneStairsID = blockIdsCategory.getProperty("mossyCobblestone", 139);
        Property bricksStairsID = blockIdsCategory.getProperty("bricksStairs", 140);
        Property soulBrickStairsID = blockIdsCategory.getProperty("soulBrickStairs", 141);
        Property mossySoulBrickStairsID = blockIdsCategory.getProperty("mossySoulBrickStairs", 142);
        Property netherBrickStairsID = blockIdsCategory.getProperty("netherBrickStairs", 143);
        Property normalBrickStairsID = blockIdsCategory.getProperty("normalBrickStairs", 144);
        Property stoneStairsID = blockIdsCategory.getProperty("stoneStairs", 145);
        Property fenceExtendedID = blockIdsCategory.getProperty("fenceExtended", 146);
        Property stoneSmoothStairsID = blockIdsCategory.getProperty("stoneSmoothStairs", 147);
        Property sandStoneStairsID = blockIdsCategory.getProperty("sandStoneStairs", 148);
        Property extendedSlabsID = blockIdsCategory.getProperty("extendedSlabs", 149);
        Property extendedDoubleSlabsID = blockIdsCategory.getProperty("extendedDoubleSlabs", 150);
        Property lampCeilingID = blockIdsCategory.getProperty("lampCeiling",151);
        Property furnitureCabinetID = blockIdsCategory.getProperty("furnitureCabinet", 154);
        Property furnitureNightstandID = blockIdsCategory.getProperty("furnitureNightstand", 155);
        Property furnitureBoxID = blockIdsCategory.getProperty("furnitureBox", 156);
        Property furnitureLockerID = blockIdsCategory.getProperty("furnitureLocker", 157);
        Property furnitureCommodeID = blockIdsCategory.getProperty("furnitureCommode", 158);
        Property furnitureFridgeID = blockIdsCategory.getProperty("furnitureFridge", 159);
        Property blockChandelierID = blockIdsCategory.getProperty("blockChandelier", 160);

        blockCouple1 = new BlockStones(blockCouple1ID.getIntValue()).setName("chickenextensions:blockCouple1");
        blockSaplingC = new TileBlockColour_Sapling(blockSaplingCID.getIntValue()).setName("chickenextensions:blockSaplingC");
        blockNetherrackMossy = new BlockNetherrackMossy(blockNetherrackMossyID.getIntValue()).setName("chickenextensions:blockNetherrackMossy");
        blockLeavesC = new TileBlockColour_Leaves(blockLeavesCID.getIntValue()).setName("chickenextensions:blockLeavesC");
        blockFlowerC = new TileBlockColour_Flower(blockFlowerCID.getIntValue()).setName("chickenextensions:blockFlowerC");
        machineCartDiapenser = new BlockCartDispenser(machineCartDiapenserID.getIntValue()).setName("chickenextensions:machineCartDispenser");
        netherStairs = new StairsExtended(netherStairsID.getIntValue(), BlockBase.NETHERRACK.texture, BlockBase.NETHERRACK.id).setName("chickenextensions:netherStairs");
        mossyCobblestoneStairs = new StairsExtended(mossyCobblestoneStairsID.getIntValue(), BlockBase.MOSSY_COBBLESTONE.texture, BlockBase.MOSSY_COBBLESTONE.id).setName("chickenextensions:mossyCobblestoneStairs");
        bricksStairs =  new StairsExtended(bricksStairsID.getIntValue(), BlockBase.BRICK.texture, BlockBase.BRICK.id).setName("chickenextensions:bricksStairs");
        soulBrickStairs = new StairsExtended(soulBrickStairsID.getIntValue(), ChickenMod.texBrickSoul_BLOCK, RegisteringClass.blockCouple1.id).setName("chickenextensions:soulBrickStairs");
        mossySoulBrickStairs = new StairsExtended(mossySoulBrickStairsID.getIntValue(), ChickenMod.texBrickSoul_BLOCK1, RegisteringClass.blockCouple1.id).setName("chickenextensions:mossySoulBrickStairs");
        netherBrickStairs = new StairsExtended(netherBrickStairsID.getIntValue(), ChickenMod.texBrickNether, RegisteringClass.blockCouple1.id).setName("chickenextensions:netherBrickStairs");
        normalBrickStairs = new StairsExtended(normalBrickStairsID.getIntValue(), ChickenMod.texBrickNormal0, RegisteringClass.blockCouple1.id).setName("chickenextensions:normalBrickStairs");
        stoneStairs = new StairsExtended(stoneStairsID.getIntValue(), BlockBase.STONE.texture, BlockBase.STONE.id).setName("chickenextensions:stoneStairs");
        fenceExtended = new FenceExtended(fenceExtendedID.getIntValue()).setName("chickenextensions:fenceExtended");
        stoneSmoothStairs = new StairsExtended(stoneSmoothStairsID.getIntValue(), BlockBase.STONE_SLAB.getTextureForSide(0), BlockBase.STONE_SLAB.id).setName("chickenextensions:stoneSmoothStairs");
        sandStoneStairs = new StairsExtended(sandStoneStairsID.getIntValue(), BlockBase.SANDSTONE.getTextureForSide(1), BlockBase.SANDSTONE.id).setName("chickenextensions:sandStoneStairs");
        extendedSlabs = new SlabsExtended(extendedSlabsID.getIntValue(), false).setName("chickenextensions:extendedSlabs");
        extendedDoubleSlabs = new SlabsExtended(extendedDoubleSlabsID.getIntValue(), true).setName("chickenextensions:extendedSlabs");
        lampCeiling = new BlockCeilingLamp(lampCeilingID.getIntValue()).setName("chickenextensions:lampCeiling");
        furnitureCabinet = new BlockContainerFurniture(furnitureCabinetID.getIntValue()).setName("chickenextensions:furnitureCabinet");
        furnitureNightstand = new BlockContainerFurniture(furnitureNightstandID.getIntValue()).setName("chickenextensions:furnitureNightstand");
        furnitureBox = new BlockContainerFurniture(furnitureBoxID.getIntValue()).setName("chickenextensions:furnitureBox");
        furnitureLocker = new BlockContainerFurniture(furnitureLockerID.getIntValue()).setName("chickenextensions:furnitureLocker");
        furnitureCommode = new BlockContainerFurniture(furnitureCommodeID.getIntValue()).setName("chickenextensions:furnitureCommode");
        furnitureFridge = new BlockContainerFurniture(furnitureFridgeID.getIntValue()).setName("chickenextensions:furnitureFridge");
        blockChandelier = new BlockCeilingLamp(blockChandelierID.getIntValue()).setName("chickenextensions:blockChandelier");

        ItemBase.byId[blockCouple1.id] = (new TileBlockStones(blockCouple1.id - 256)).setName("chickenextensions:blockCouple1");
        ItemBase.byId[blockSaplingC.id] = (new TileItemColour_Sapling(blockSaplingC.id - 256)).setName("chickenextensions:blockSaplingC");
        ItemBase.byId[blockLeavesC.id] = (new TileItemColour_Leaves(blockLeavesC.id - 256)).setName("chickenextensions:blockLeavesC");
        ItemBase.byId[blockFlowerC.id] = (new TileItemColour_Flower(blockFlowerC.id - 256)).setName("chickenextensions:blockFlowerC");
        ItemBase.byId[fenceExtended.id] = (new TileItemExtended(fenceExtended.id - 256)).setName("chickenextensions:fenceExtended");
        ItemBase.byId[extendedSlabs.id] = (new TileItemExtended(extendedSlabs.id - 256)).setName("chickenextensions:extendedSlabs");
        ItemBase.byId[extendedDoubleSlabs.id] = (new TileItemExtended(extendedDoubleSlabs.id - 256)).setName("chickenextensions:extendedSlabs");

    }


    @Override
    public void registerEntities(TriConsumer<Class<? extends EntityBase>, String, Integer> triConsumer) {
        Configuration config = ChickenMod.INSTANCE.getDefaultConfig();
        Category mobIDsCategory = config.getCategory("Mob IDs");
        Property bloodPigmanID = mobIDsCategory.getProperty("bloodPigmanID", 20);


        triConsumer.accept(BloodyPigman.class, "BloodPigman", bloodPigmanID.getIntValue());
        config.save();
    }

    @Override
    public void registerPlayerHandlers(List<PlayerHandler> list, PlayerBase playerBase) {
        list.add(new CustomPlayerHandler(playerBase));
    }
}
