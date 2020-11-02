package kz.chesschicken.chickenextensions.item.goldenegg;

import kz.chesschicken.chickenextensions.api.RegisteringClass;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.Item;
import net.minecraft.entity.Living;
import net.minecraft.entity.projectile.Egg;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.maths.Box;
import net.minecraft.util.maths.MathHelper;
import net.minecraft.util.maths.Vec3f;

import java.util.List;
import java.util.Random;

public class GoldenEggEntity extends Egg {
    private int xTile = -1;
    private int yTile = -1;
    private int zTile = -1;
    private int inTile = 0;
    private boolean inGround = false;
    public int shake = 0;
    private Living field_2044;
    private int field_2045;
    private int field_2046 = 0;

    public GoldenEggEntity(Level arg, Living arg1) {
        super(arg, arg1);
    }

    @Override
    public void tick() {
        this.prevRenderX = this.x;
        this.prevRenderY = this.y;
        this.prevRenderZ = this.z;
        super.tick();
        if (this.shake > 0) {
            --this.shake;
        }

        if (this.onGround) {
            int var1 = this.level.getTileId(this.xTile, this.yTile, this.zTile);
            if (var1 == this.inTile) {
                ++this.field_2045;
                if (this.field_2045 == 1200) {
                    this.remove();
                }

                return;
            }

            this.inGround = false;
            this.velocityX *= (double)(this.rand.nextFloat() * 0.2F);
            this.velocityY *= (double)(this.rand.nextFloat() * 0.2F);
            this.velocityZ *= (double)(this.rand.nextFloat() * 0.2F);
            this.field_2045 = 0;
            this.field_2046 = 0;
        } else {
            ++this.field_2046;
        }

        Vec3f var15 = Vec3f.from(this.x, this.y, this.z);
        Vec3f var2 = Vec3f.from(this.x + this.velocityX, this.y + this.velocityY, this.z + this.velocityZ);
        HitResult var3 = this.level.method_160(var15, var2);
        var15 = Vec3f.from(this.x, this.y, this.z);
        var2 = Vec3f.from(this.x + this.velocityX, this.y + this.velocityY, this.z + this.velocityZ);
        if (var3 != null) {
            var2 = Vec3f.from(var3.field_1988.x, var3.field_1988.y, var3.field_1988.z);
        }

        if (!this.level.isClient) {
            EntityBase var4 = null;
            List var5 = this.level.getEntities(this, this.boundingBox.method_86(this.velocityX, this.velocityY, this.velocityZ).expand(1.0D, 1.0D, 1.0D));
            double var6 = 0.0D;

            for (Object o : var5) {
                EntityBase var9 = (EntityBase) o;
                if (var9.method_1356() && (var9 != this.field_2044 || this.field_2046 >= 5)) {
                    float var10 = 0.3F;
                    Box var11 = var9.boundingBox.expand(var10, var10, var10);
                    HitResult var12 = var11.method_89(var15, var2);
                    if (var12 != null) {
                        double var13 = var15.method_1294(var12.field_1988);
                        if (var13 < var6 || var6 == 0.0D) {
                            var4 = var9;
                            var6 = var13;
                        }
                    }
                }
            }

            if (var4 != null) {
                var3 = new HitResult(var4);
            }
        }

        if (var3 != null) {
            if (var3.field_1989 != null) {
                var3.field_1989.damage(this.field_2044, 4);
            }

            for(int q1 = 0; q1 < 16; q1++)
            {
                double[] randomPlade = getRandom(x,y,z);
                Item itemgold = new Item(level, randomPlade[0], randomPlade[1], randomPlade[2], new ItemInstance(RegisteringClass.itemGoldNugget));
                level.spawnEntity(itemgold);
            }
            int rare = rand.nextInt(64);
            if(rare == 0) {
                GoldenChicken goldenChicken = new GoldenChicken(level);
                goldenChicken.setPosition(x,y,z);
                level.spawnEntity(goldenChicken);
            }

            for(int var18 = 0; var18 < 8; ++var18) {
                this.level.addParticle("snowballpoof", this.x, this.y, this.z, 0.0D, 0.0D, 0.0D);
            }

            this.remove();
        }

        this.x += this.velocityX;
        this.y += this.velocityY;
        this.z += this.velocityZ;
        MathHelper.sqrt(this.velocityX * this.velocityX + this.velocityZ * this.velocityZ);
        this.yaw = (float)(Math.atan2(this.velocityX, this.velocityZ) * 180.0D / 3.1415927410125732D);


        while(this.pitch - this.prevPitch >= 180.0F) {
            this.prevPitch += 360.0F;
        }

        while(this.yaw - this.prevYaw < -180.0F) {
            this.prevYaw -= 360.0F;
        }

        while(this.yaw - this.prevYaw >= 180.0F) {
            this.prevYaw += 360.0F;
        }

        this.pitch = this.prevPitch + (this.pitch - this.prevPitch) * 0.2F;
        this.yaw = this.prevYaw + (this.yaw - this.prevYaw) * 0.2F;
        float var19 = 0.99F;
        float var22 = 0.03F;
        if (this.method_1334()) {
            for(int var7 = 0; var7 < 4; ++var7) {
                float var23 = 0.25F;
                this.level.addParticle("bubble", this.x - this.velocityX * (double)var23, this.y - this.velocityY * (double)var23, this.z - this.velocityZ * (double)var23, this.velocityX, this.velocityY, this.velocityZ);
            }

            var19 = 0.8F;
        }

        this.velocityX *= (double)var19;
        this.velocityY *= (double)var19;
        this.velocityZ *= (double)var19;
        this.velocityY -= (double)var22;
        this.setPosition(this.x, this.y, this.z);
    }

    public double[] getRandom(double x1, double y1, double z1)
    {
        for(int i1 = 0; i1 < 3; i1++)
        {
            double gteqd = (new Random()).nextInt(10)*0.05 * (((new Random()).nextBoolean()) ? 1 : -1);
            if(i1 == 0)
                x1 = x1 + gteqd;
            else if(i1 == 1)
                y1 = y1 + gteqd;
            else
                z1 = z1 + gteqd;
        }
        return new double[] {x1,y1,z1};
    }
}
