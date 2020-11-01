package kz.chesschicken.chickenextensions.item;

import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;

public class ItemBiomeLocator extends ItemBase {
    public ItemBiomeLocator(int id) {
        super(id);
    }

    @Override
    public ItemInstance use(ItemInstance item, Level level, PlayerBase player) {
        player.sendMessage("Biome: "+level.getBiomeSource().getBiome((int) player.x, (int) player.z).biomeName);
        return item;
    }
}
