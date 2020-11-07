package kz.chesschicken.chickenextensions.item.striker;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.Lightning;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.minecraft.util.hit.HitType;

public class ItemLightBomb extends ItemBase
{
    private Minecraft mc = (Minecraft) FabricLoader.getInstance().getGameInstance();

    public ItemLightBomb(int id) {
        super(id);
        this.setDurability(3);
    }

    @Override
    public ItemInstance use(ItemInstance item, Level level, PlayerBase player) {
        if(mc.hitResult != null)
        {
            if(mc.hitResult.type == HitType.TILE)
            {
                EntityBase baselight = new Lightning(level, mc.hitResult.x, mc.hitResult.y, mc.hitResult.z);
                level.spawnEntity(baselight);
                item.setDamage(item.getDamage() + 1);
            }
        }
        return item;
    }

    @Override public int getMaxStackSize() { return 1; }
}
