package kz.chesschicken.chickenextensions.mixin.common;

import kz.chesschicken.chickenextensions.ChickenMod;
import kz.chesschicken.chickenextensions.api.common.RegisteringClass;
import kz.chesschicken.chickenextensions.block.furniture.TileCorpseBox;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.entity.player.PlayerInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerInventory.class)
public class MixinPlayerInventoryAdditional {
    @Shadow public PlayerBase player;
    private final Minecraft mc = (Minecraft) FabricLoader.getInstance().getGameInstance();

    @Inject(method = "dropInventory", at = @At("HEAD"), cancellable = true)
    private void cancelDrop(CallbackInfo ci)
    {
        if(ChickenMod.isDeathChest) {
            int ix = (int)player.x;
            int iy = (int)player.y - 1;
            int iz = (int)player.z;

            mc.level.setTile(ix,iy,iz, RegisteringClass.corpseBox.id);
            TileCorpseBox chest1 = (TileCorpseBox) mc.level.getTileEntity(ix,iy,iz);
            for(int i = 0; i < player.inventory.main.length; i++)
            {
                if(player.inventory.main[i] != null)
                {
                    chest1.setInventoryItem(i, player.inventory.main[i]);
                }
            }
            for(int i = 0; i < player.inventory.armour.length; i++)
            {
                if(player.inventory.armour[i] != null)
                {
                    chest1.setInventoryItem(i+36, player.inventory.armour[i]);
               }
            }

            ci.cancel();
        }
    }
}
