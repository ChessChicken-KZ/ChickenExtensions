package kz.chesschicken.chickenextensions.item.obsidianboat;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.model.Boat;
import net.minecraft.client.render.entity.model.EntityModelBase;
import net.minecraft.entity.EntityBase;
import net.minecraft.util.maths.MathHelper;
import org.lwjgl.opengl.GL11;

@Environment(EnvType.CLIENT)
public class RenderObisidianBoat extends EntityRenderer {
    protected EntityModelBase field_596;

    public RenderObisidianBoat() {
        this.field_2678 = 0.5F;
        this.field_596 = new Boat();
    }

    @Override
    public void render(EntityBase entity, double x, double y, double z, float f, float f1) {
        EntityObsidianBoat boat = (EntityObsidianBoat) entity;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x, (float)y, (float)z);
        GL11.glRotatef(180.0F - f, 0.0F, 1.0F, 0.0F);
        float var10 = (float)boat.field_339 - f1;
        float var11 = (float)boat.field_338 - f1;
        if (var11 < 0.0F) {
            var11 = 0.0F;
        }

        if (var10 > 0.0F) {
            GL11.glRotatef(MathHelper.sin(var10) * var10 * var11 / 10.0F * (float)boat.field_340, 1.0F, 0.0F, 0.0F);
        }

        this.bindTexture("/terrain.png");
        float var12 = 0.75F;
        GL11.glScalef(var12, var12, var12);
        GL11.glScalef(1.0F / var12, 1.0F / var12, 1.0F / var12);
        this.bindTexture("/assets/chickenextensions/textures/entity/things/boatObsidian.png");
        GL11.glScalef(-1.0F, -1.0F, 1.0F);
        this.field_596.render(0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }


}

