package kz.chesschicken.chickenextensions.api.player;

import kz.chesschicken.chickenextensions.ChickenMod;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.monster.Zombie;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.tileentity.TileEntityChest;
import net.modificationstation.stationloader.api.common.entity.player.PlayerHandler;

public class CustomPlayerHandler implements PlayerHandler {

    private final PlayerBase player;

    public CustomPlayerHandler(PlayerBase playerBase) {
        this.player = playerBase;
    }

    @Override
    public boolean onDeath(EntityBase killer) {

        if (player.isInFluid(Material.WATER)) {
            Zombie toSpawn = new Zombie(player.level);
            toSpawn.setPosition(player.x, player.y, player.z);
            player.level.spawnEntity(toSpawn);
            return true;
        }
        return false;
    }


}
