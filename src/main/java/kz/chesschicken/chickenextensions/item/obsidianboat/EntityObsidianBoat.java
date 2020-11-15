package kz.chesschicken.chickenextensions.item.obsidianboat;

import kz.chesschicken.chickenextensions.api.common.RegisteringClass;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Boat;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.level.Level;
import net.minecraft.util.io.CompoundTag;
import net.minecraft.util.maths.Box;
import net.minecraft.util.maths.MathHelper;

import java.util.List;

public class EntityObsidianBoat extends EntityBase {
    public int field_338;
    public int field_339;
    public int field_340;
    private int field_341;
    private double field_342;
    private double field_343;
    private double field_344;
    private double field_345;
    private double field_346;
    @Environment(EnvType.CLIENT)
    private double field_347;
    @Environment(EnvType.CLIENT)
    private double field_348;
    @Environment(EnvType.CLIENT)
    private double field_349;

    @Override
    protected void damageByFire(int amount) {
    }

    public EntityObsidianBoat(Level arg) {
        super(arg);
        this.field_338 = 0;
        this.field_339 = 0;
        this.field_340 = 1;
        this.field_1593 = true;
        this.setSize(1.5F, 0.6F);
        this.standingEyeHeight = this.height / 2.0F;
        this.immuneToFire = true;
    }

    protected boolean canClimb() {
        return false;
    }

    protected void initDataTracker() {
    }

    public Box method_1379(EntityBase arg) {
        return arg.boundingBox;
    }

    public Box method_1381() {
        return this.boundingBox;
    }

    public boolean method_1380() {
        return true;
    }

    public EntityObsidianBoat(Level arg, double d, double d1, double d2) {
        this(arg);
        this.setPosition(d, d1 + (double)this.standingEyeHeight, d2);
        this.velocityX = 0.0D;
        this.velocityY = 0.0D;
        this.velocityZ = 0.0D;
        this.prevX = d;
        this.prevY = d1;
        this.prevZ = d2;
        this.immuneToFire = true;
    }

    public double getMountedHeightOffset() {
        return (double)this.height * 0.0D - 0.30000001192092896D;
    }

    public boolean damage(EntityBase target, int amount) {
        if (!this.level.isClient && !this.removed) {
            this.field_340 = -this.field_340;
            this.field_339 = 10;
            this.field_338 += amount * 10;
            this.method_1336();
            if (this.field_338 > 40) {
                if (this.passenger != null) {
                    this.passenger.startRiding(this);
                }

                this.dropItem(RegisteringClass.boatObsidian.id, 1, 0.0F);

                this.remove();
            }

            return true;
        } else {
            return true;
        }
    }

    @Environment(EnvType.CLIENT)
    public void method_1312() {
        this.field_340 = -this.field_340;
        this.field_339 = 10;
        this.field_338 += this.field_338 * 10;
    }

    public boolean method_1356() {
        return !this.removed;
    }

    @Environment(EnvType.CLIENT)
    public void method_1311(double d, double d1, double d2, float f, float f1, int i) {
        this.field_342 = d;
        this.field_343 = d1;
        this.field_344 = d2;
        this.field_345 = (double)f;
        this.field_346 = (double)f1;
        this.field_341 = i + 4;
        this.velocityX = this.field_347;
        this.velocityY = this.field_348;
        this.velocityZ = this.field_349;
    }

    @Environment(EnvType.CLIENT)
    public void setVelocity(double d, double d1, double d2) {
        this.field_347 = this.velocityX = d;
        this.field_348 = this.velocityY = d1;
        this.field_349 = this.velocityZ = d2;
    }

    public void tick() {
        super.tick();
        if (this.field_339 > 0) {
            --this.field_339;
        }

        if (this.field_338 > 0) {
            --this.field_338;
        }

        this.prevX = this.x;
        this.prevY = this.y;
        this.prevZ = this.z;
        byte var1 = 5;
        double var2 = 0.0D;

        for(int var4 = 0; var4 < var1; ++var4) {
            double var5 = this.boundingBox.minY + (this.boundingBox.maxY - this.boundingBox.minY) * (double)(var4 + 0) / (double)var1 - 0.125D;
            double var7 = this.boundingBox.minY + (this.boundingBox.maxY - this.boundingBox.minY) * (double)(var4 + 1) / (double)var1 - 0.125D;
            Box var9 = Box.method_94(this.boundingBox.minX, var5, this.boundingBox.minZ, this.boundingBox.maxX, var7, this.boundingBox.maxZ);
            if (this.level.method_207(var9, Material.LAVA)) {
                var2 += 1.0D / (double)var1;
            }
        }

        double var6;
        double var8;
        double var10;
        double var21;
        if (this.level.isClient) {
            if (this.field_341 > 0) {
                var21 = this.x + (this.field_342 - this.x) / (double)this.field_341;
                var6 = this.y + (this.field_343 - this.y) / (double)this.field_341;
                var8 = this.z + (this.field_344 - this.z) / (double)this.field_341;

                for(var10 = this.field_345 - (double)this.yaw; var10 < -180.0D; var10 += 360.0D) {
                }

                while(var10 >= 180.0D) {
                    var10 -= 360.0D;
                }

                this.yaw = (float)((double)this.yaw + var10 / (double)this.field_341);
                this.pitch = (float)((double)this.pitch + (this.field_346 - (double)this.pitch) / (double)this.field_341);
                --this.field_341;
                this.setPosition(var21, var6, var8);
                this.setRotation(this.yaw, this.pitch);
            } else {
                var21 = this.x + this.velocityX;
                var6 = this.y + this.velocityY;
                var8 = this.z + this.velocityZ;
                this.setPosition(var21, var6, var8);
                if (this.onGround) {
                    this.velocityX *= 0.5D;
                    this.velocityY *= 0.5D;
                    this.velocityZ *= 0.5D;
                }

                this.velocityX *= 0.9900000095367432D;
                this.velocityY *= 0.949999988079071D;
                this.velocityZ *= 0.9900000095367432D;
            }

        } else {
            if (var2 < 1.0D) {
                var21 = var2 * 2.0D - 1.0D;
                this.velocityY += 0.03999999910593033D * var21;
            } else {
                if (this.velocityY < 0.0D) {
                    this.velocityY /= 2.0D;
                }

                this.velocityY += 0.007000000216066837D;
            }

            if (this.passenger != null) {
                this.velocityX += this.passenger.velocityX * 0.2D;
                this.velocityZ += this.passenger.velocityZ * 0.2D;
            }

            var21 = 0.4D;
            if (this.velocityX < -var21) {
                this.velocityX = -var21;
            }

            if (this.velocityX > var21) {
                this.velocityX = var21;
            }

            if (this.velocityZ < -var21) {
                this.velocityZ = -var21;
            }

            if (this.velocityZ > var21) {
                this.velocityZ = var21;
            }

            if (this.onGround) {
                this.velocityX *= 0.5D;
                this.velocityY *= 0.5D;
                this.velocityZ *= 0.5D;
            }

            this.move(this.velocityX, this.velocityY, this.velocityZ);
            var6 = Math.sqrt(this.velocityX * this.velocityX + this.velocityZ * this.velocityZ);
            if (var6 > 0.15D) {
                var8 = Math.cos((double)this.yaw * 3.141592653589793D / 180.0D);
                var10 = Math.sin((double)this.yaw * 3.141592653589793D / 180.0D);

                for(int var12 = 0; (double)var12 < 1.0D + var6 * 60.0D; ++var12) {
                    double var13 = (double)(this.rand.nextFloat() * 2.0F - 1.0F);
                    double var15 = (double)(this.rand.nextInt(2) * 2 - 1) * 0.7D;
                    double var17;
                    double var19;
                    if (this.rand.nextBoolean()) {
                        var17 = this.x - var8 * var13 * 0.8D + var10 * var15;
                        var19 = this.z - var10 * var13 * 0.8D - var8 * var15;
                    } else {
                        var17 = this.x + var8 + var10 * var13 * 0.7D;
                        var19 = this.z + var10 - var8 * var13 * 0.7D;
                    }
                    this.level.addParticle("smoke", var17, this.y - 0.125D, var19, this.velocityX, this.velocityY, this.velocityZ);
                }
            }

            if (this.field_1624 && var6 > 0.15D) {
                if (!this.level.isClient) {
                    this.remove();

                    this.dropItem(RegisteringClass.boatObsidian.id, 1, 0.0F);

                }
            } else {
                this.velocityX *= 0.9900000095367432D;
                this.velocityY *= 0.949999988079071D;
                this.velocityZ *= 0.9900000095367432D;
            }

            this.pitch = 0.0F;
            var8 = (double)this.yaw;
            var10 = this.prevX - this.x;
            double var23 = this.prevZ - this.z;
            if (var10 * var10 + var23 * var23 > 0.001D) {
                var8 = (double)((float)(Math.atan2(var23, var10) * 180.0D / 3.141592653589793D));
            }

            double var14;
            for(var14 = var8 - (double)this.yaw; var14 >= 180.0D; var14 -= 360.0D) {
            }

            while(var14 < -180.0D) {
                var14 += 360.0D;
            }

            if (var14 > 20.0D) {
                var14 = 20.0D;
            }

            if (var14 < -20.0D) {
                var14 = -20.0D;
            }

            this.yaw = (float)((double)this.yaw + var14);
            this.setRotation(this.yaw, this.pitch);
            List var16 = this.level.getEntities(this, this.boundingBox.expand(0.20000000298023224D, 0.0D, 0.20000000298023224D));
            int var24;
            if (var16 != null && var16.size() > 0) {
                for(var24 = 0; var24 < var16.size(); ++var24) {
                    EntityBase var18 = (EntityBase)var16.get(var24);
                    if (var18 != this.passenger && var18.method_1380() && var18 instanceof Boat) {
                        var18.method_1353(this);
                    }
                }
            }

            for(var24 = 0; var24 < 4; ++var24) {
                int var25 = MathHelper.floor(this.x + ((double)(var24 % 2) - 0.5D) * 0.8D);
                int var26 = MathHelper.floor(this.y);
                int var20 = MathHelper.floor(this.z + ((double)(var24 / 2) - 0.5D) * 0.8D);
                if (this.level.getTileId(var25, var26, var20) == BlockBase.SNOW.id) {
                    this.level.setTile(var25, var26, var20, 0);
                }
            }

            if(this.passenger != null) {
                passenger.fire = 0;
                passenger.setPosition(passenger.x, passenger.y + 0.2D, passenger.z);
            }
            if (this.passenger != null && this.passenger.removed) {
                this.passenger = null;
            }

        }
    }

    public void method_1382() {
        if (this.passenger != null) {
            double var1 = Math.cos((double)this.yaw * 3.141592653589793D / 180.0D) * 0.4D;
            double var3 = Math.sin((double)this.yaw * 3.141592653589793D / 180.0D) * 0.4D;
            this.passenger.setPosition(this.x + var1, this.y + this.getMountedHeightOffset() + this.passenger.getHeightOffset(), this.z + var3);
        }
    }

    protected void writeCustomDataToTag(CompoundTag tag) {
    }

    protected void readCustomDataFromTag(CompoundTag tag) {
    }

    @Environment(EnvType.CLIENT)
    public float getEyeHeight() {
        return 0.0F;
    }

    public boolean interact(PlayerBase arg) {
        if (this.passenger == null || !(this.passenger instanceof PlayerBase) || this.passenger == arg) {
            if (!this.level.isClient) {
                arg.startRiding(this);
            }

        }
        return true;
    }
}
