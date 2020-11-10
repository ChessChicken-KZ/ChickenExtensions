package kz.chesschicken.chickenextensions.mixin.client;

import kz.chesschicken.chickenextensions.ChickenMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.ScreenBase;
import net.minecraft.client.gui.screen.menu.MainMenu;
import net.minecraft.client.render.Tessellator;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.image.BufferedImage;

@Environment(EnvType.CLIENT)
@Mixin(MainMenu.class)
public class MixinMainMenu extends ScreenBase
{
    private int viewportTexture;
    private Minecraft mc = (Minecraft) FabricLoader.getInstance().getGameInstance();

    //@Inject(method = "render(IIF)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/menu/MainMenu;renderBackground()V", shift = At.Shift.AFTER))
    @Redirect(method = "render(IIF)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/menu/MainMenu;renderBackground()V"))
    private void injected(MainMenu mainMenu, int mouseX, int mouseY, float delta) {
        renderSkybox(mouseX,mouseY,delta);
    }

    @Inject(method = "init", at = @At("HEAD"))
    private void declareNew(CallbackInfo ci)
    {
        this.viewportTexture = this.mc.textureManager.method_1088(new BufferedImage(ChickenMod.massiveMainMenuSize[0], ChickenMod.massiveMainMenuSize[1], 2));
    }

    public void renderBackground()
    {
    }






    /**
     * Draws the main menu panorama
     */
    private void drawPanorama(int par1, int par2, float par3)
    {
        Tessellator var4 = Tessellator.INSTANCE;
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GLU.gluPerspective(120.0F, 1.0F, 0.05F, 10.0F);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        GL11.glDisable(GL11.GL_CULL_FACE);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        byte var5 = 8;

        for (int var6 = 0; var6 < var5 * var5; ++var6)
        {
            GL11.glPushMatrix();
            float var7 = ((float)(var6 % var5) / (float)var5 - 0.5F) / 64.0F;
            float var8 = ((float)(var6 / var5) / (float)var5 - 0.5F) / 64.0F;
            float var9 = 0.0F;
            GL11.glTranslatef(var7, var8, var9);


            for (int var10 = 0; var10 < 6; ++var10)
            {
                GL11.glPushMatrix();

                if (var10 == 1)
                {
                    GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
                }

                if (var10 == 2)
                {
                    GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
                }

                if (var10 == 3)
                {
                    GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
                }

                if (var10 == 4)
                {
                    GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
                }

                if (var10 == 5)
                {
                    GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
                }

                GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.mc.textureManager.getTextureId("/assets/chickenextensions/textures/gui/panorama/panorama" + var10 + ".png"));
                var4.start();
                var4.colour(16777215, 255 / (var6 + 1));
                float var11 = 0.0F;
                var4.vertex(-1.0D, -1.0D, 1.0D, (double)(0.0F + var11), (double)(0.0F + var11));
                var4.vertex(1.0D, -1.0D, 1.0D, (double)(1.0F - var11), (double)(0.0F + var11));
                var4.vertex(1.0D, 1.0D, 1.0D, (double)(1.0F - var11), (double)(1.0F - var11));
                var4.vertex(-1.0D, 1.0D, 1.0D, (double)(0.0F + var11), (double)(1.0F - var11));
                var4.draw();
                GL11.glPopMatrix();
            }

            GL11.glPopMatrix();
            GL11.glColorMask(true, true, true, false);
        }

        var4.method_1696(0.0D, 0.0D, 0.0D);
        GL11.glColorMask(true, true, true, true);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glPopMatrix();
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glPopMatrix();
        GL11.glDepthMask(true);
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
    }

    /**
     * Rotate and blurs the skybox view in the main menu
     */
    private void rotateAndBlurSkybox(float par1)
    {
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.viewportTexture);
        GL11.glCopyTexSubImage2D(GL11.GL_TEXTURE_2D, 0, 0, 0, 0, 0, 256, 256);
        if(ChickenMod.isMainMenuBlured)
        {
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        }
        GL11.glColorMask(true, true, true, false);
        Tessellator var2 = Tessellator.INSTANCE;
        var2.start();
        byte var3;

        if(ChickenMod.isMainMenuBlured)
            var3 = 3;
        else
            var3 = 1;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            var2.colour(1.0F, 1.0F, 1.0F, 1.0F / (float)(var4 + 1));
            int var5 = this.width;
            int var6 = this.height;
            float var7 = (float)(var4 - var3 / 2) / 256.0F;
            var2.vertex((double)var5, (double)var6, (double)this.zOffset, (double)(0.0F + var7), 0.0D);
            var2.vertex((double)var5, 0.0D, (double)this.zOffset, (double)(1.0F + var7), 0.0D);
            var2.vertex(0.0D, 0.0D, (double)this.zOffset, (double)(1.0F + var7), 1.0D);
            var2.vertex(0.0D, (double)var6, (double)this.zOffset, (double)(0.0F + var7), 1.0D);
        }

        var2.draw();
        GL11.glColorMask(true, true, true, true);
    }

    /**
     * Renders the skybox in the main menu
     */
    private void renderSkybox(int par1, int par2, float par3)
    {
        GL11.glViewport(0, 0, 256, 256);
        this.drawPanorama(par1, par2, par3);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        this.rotateAndBlurSkybox(par3);
        this.rotateAndBlurSkybox(par3);
        this.rotateAndBlurSkybox(par3);
        this.rotateAndBlurSkybox(par3);
        this.rotateAndBlurSkybox(par3);
        this.rotateAndBlurSkybox(par3);
        this.rotateAndBlurSkybox(par3);
        this.rotateAndBlurSkybox(par3);
        GL11.glViewport(0, 0, this.mc.actualWidth, this.mc.actualHeight);
        Tessellator var4 = Tessellator.INSTANCE;
        var4.start();
        float var5 = this.width > this.height ? 120.0F / (float)this.width : 120.0F / (float)this.height;
        float var6 = (float)this.height * var5 / 256.0F;
        float var7 = (float)this.width * var5 / 256.0F;
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
        var4.colour(1.0F, 1.0F, 1.0F, 1.0F);
        int var8 = this.width;
        int var9 = this.height;
        var4.vertex(0.0D, (double)var9, (double)this.zOffset, (double)(0.5F - var6), (double)(0.5F + var7));
        var4.vertex((double)var8, (double)var9, (double)this.zOffset, (double)(0.5F - var6), (double)(0.5F - var7));
        var4.vertex((double)var8, 0.0D, (double)this.zOffset, (double)(0.5F + var6), (double)(0.5F - var7));
        var4.vertex(0.0D, 0.0D, (double)this.zOffset, (double)(0.5F + var6), (double)(0.5F + var7));
        var4.draw();
    }

}
