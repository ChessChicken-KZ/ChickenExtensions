package kz.chesschicken.chickenextensions.api.common.bosses.cactusmaster;

import java.util.logging.Level;

public class ThreadBoss {
    private int[] xyz = new int[3];
    private Level levelMain;
    public ThreadBoss(Level level, int x, int y, int z)
    {
        xyz[0] = x;
        xyz[1] = y;
        xyz[2] = z;
        levelMain = level;
    }


}
