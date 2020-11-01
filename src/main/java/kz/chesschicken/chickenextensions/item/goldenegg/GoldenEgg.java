package kz.chesschicken.chickenextensions.item.goldenegg;

import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;

public class GoldenEgg extends ItemBase {
    public GoldenEgg(int i) {
        super(i);
        this.maxStackSize = 16;
    }

    public ItemInstance use(ItemInstance item, Level level, PlayerBase player) {
        --item.count;
        level.playSound(player, "random.bow", 0.5F, 0.4F / (rand.nextFloat() * 0.4F + 0.8F));
        if (!level.isClient) {
            level.spawnEntity(new GoldenEggEntity(level, player));
        }

        return item;
    }
}
