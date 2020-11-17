package kz.chesschicken.chickenextensions.api.common;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.monster.Zombie;
import net.minecraft.entity.player.PlayerBase;
import net.modificationstation.stationloader.api.common.entity.player.PlayerHandler;
import org.lwjgl.input.Keyboard;

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

    @Override
    @Environment(EnvType.CLIENT)
    public boolean sendChatMessage(String s) {
        if(this.player.level.isClient)
            return true;
        return false;
    }



    public static void processInfinityFly(PlayerBase oEntityPlayerSP) {
        Minecraft m_oMinecraft = (Minecraft) FabricLoader.getInstance().getGameInstance();
        oEntityPlayerSP.onGround = false;
        oEntityPlayerSP.velocityX = 0.0D;
        oEntityPlayerSP.velocityY = 0.0D;
        oEntityPlayerSP.velocityZ = 0.0D;
        double d2 = (double)(oEntityPlayerSP.yaw + 90.0F);
        boolean flag = Keyboard.isKeyDown(17) && m_oMinecraft.hasFocus;
        boolean flag1 = Keyboard.isKeyDown(31) && m_oMinecraft.hasFocus;
        boolean flag2 = Keyboard.isKeyDown(30) && m_oMinecraft.hasFocus;
        boolean flag3 = Keyboard.isKeyDown(32) && m_oMinecraft.hasFocus;
        if (flag) {
            if (flag2) {
                d2 -= 45.0D;
            } else if (flag3) {
                d2 += 45.0D;
            }
        } else if (flag1) {
            d2 += 180.0D;
            if (flag2) {
                d2 += 45.0D;
            } else if (flag3) {
                d2 -= 45.0D;
            }
        } else if (flag2) {
            d2 -= 90.0D;
        } else if (flag3) {
            d2 += 90.0D;
        }

        if (flag || flag2 || flag1 || flag3) {
            oEntityPlayerSP.velocityX = Math.cos(Math.toRadians(d2));
            oEntityPlayerSP.velocityZ = Math.sin(Math.toRadians(d2));
        }

        if (Keyboard.isKeyDown(57) && m_oMinecraft.hasFocus) {
            oEntityPlayerSP.velocityY += 3.0D;
        } else if (Keyboard.isKeyDown(42) && m_oMinecraft.hasFocus) {
            oEntityPlayerSP.velocityY -= 3.0D;
        } else if (Keyboard.isKeyDown(82) && m_oMinecraft.hasFocus) {
            oEntityPlayerSP.velocityY -= 4.0D;
        } else if (Keyboard.isKeyDown(77) && m_oMinecraft.hasFocus) {
            oEntityPlayerSP.velocityY += 4.0D;
        }

        //FIX FLY PSEE
        oEntityPlayerSP.velocityX *= 1.0D;
        oEntityPlayerSP.velocityY *= 1.0D;
        oEntityPlayerSP.velocityZ *= 1.0D;
    }
}
