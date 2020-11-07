package kz.chesschicken.chickenextensions.item.obsidianboat;

import net.minecraft.block.BlockBase;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.Boat;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.hit.HitType;
import net.minecraft.util.maths.MathHelper;
import net.minecraft.util.maths.Vec3f;

public class ItemObsidianBoat extends ItemBase {
    public ItemObsidianBoat(int i) {
        super(i);
    }

    public ItemInstance use(ItemInstance item, Level level, PlayerBase player) {
        float var4 = 1.0F;
        float var5 = player.prevPitch + (player.pitch - player.prevPitch) * var4;
        float var6 = player.prevYaw + (player.yaw - player.prevYaw) * var4;
        double var7 = player.prevX + (player.x - player.prevX) * (double)var4;
        double var9 = player.prevY + (player.y - player.prevY) * (double)var4 + 1.62D - (double)player.standingEyeHeight;
        double var11 = player.prevZ + (player.z - player.prevZ) * (double)var4;
        Vec3f var13 = Vec3f.from(var7, var9, var11);
        float var14 = MathHelper.cos(-var6 * 0.017453292F - 3.1415927F);
        float var15 = MathHelper.sin(-var6 * 0.017453292F - 3.1415927F);
        float var16 = -MathHelper.cos(-var5 * 0.017453292F);
        float var17 = MathHelper.sin(-var5 * 0.017453292F);
        float var18 = var15 * var16;
        float var20 = var14 * var16;
        double var21 = 5.0D;
        Vec3f var23 = var13.method_1301((double)var18 * var21, (double)var17 * var21, (double)var20 * var21);
        HitResult var24 = level.method_161(var13, var23, true);
        if (var24 == null) {
            return item;
        } else {
            if (var24.type == HitType.TILE) {
                int var25 = var24.x;
                int var26 = var24.y;
                int var27 = var24.z;
                if (!level.isClient) {
                    if (level.getTileId(var25, var26, var27) == BlockBase.SNOW.id) {
                        --var26;
                    }

                    level.spawnEntity(new EntityObsidianBoat(level, (double)((float)var25 + 0.5F), (double)((float)var26 + 1.0F), (double)((float)var27 + 0.5F)));
                }

                --item.count;
            }

            return item;
        }
    }
}
