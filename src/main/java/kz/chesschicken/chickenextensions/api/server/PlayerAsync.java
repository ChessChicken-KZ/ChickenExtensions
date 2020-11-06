package kz.chesschicken.chickenextensions.api.server;

import net.minecraft.entity.player.PlayerBase;

import java.util.Random;

public class PlayerAsync {
    private Thread newThread;

    public void runPlayerShakal(PlayerBase playerBase, int time)
    {
        int tickTime = time*20;
        newThread = new Thread(() -> {
            boolean isStopped = false;
            int i = 0;
            while(i < tickTime && !isStopped) {
                if(playerBase != null)
                    playerBase.setPosition(playerBase.x+randomizeWalk(),playerBase.y+randomizeWalk(),playerBase.z+randomizeWalk());
                else
                    isStopped = true;
                i++;
            }
        });
        newThread.start();
    }

    private double randomizeWalk()
    {
        return (new Random()).nextInt(11) * 0.1 * (new Random().nextBoolean() ? 1 : -1);
    }


}
