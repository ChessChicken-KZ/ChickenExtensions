package kz.chesschicken.chickenextensions.mixin.client;

import kz.chesschicken.chickenextensions.api.common.CustomPackerSender;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.InGame;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.TextRenderer;
import net.minecraft.client.util.ScreenScaler;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;

@Mixin(InGame.class)
public class MixinGameList {
    @Shadow private Minecraft minecraft;
    private int tickGui = 40;
    @Inject(method = "renderHud", at = @At("TAIL"))
    private void renderList(float f, boolean flag, int i, int j, CallbackInfo ci)
    {
        if(minecraft.level.isClient) {
            if (tickGui == 40) {
                CustomPackerSender.queue_PacketGetList(minecraft.session.username);
                tickGui = 0;
            } else
                tickGui++;

            if (Keyboard.isKeyDown(Keyboard.KEY_TAB)) {
                ScreenScaler screenScaler = new ScreenScaler(this.minecraft.options, this.minecraft.actualWidth, this.minecraft.actualHeight);
                TextRenderer textRenderer = this.minecraft.textRenderer;
                drawCenteredString(textRenderer, "Player List", screenScaler.getScaledWidth() / 2, screenScaler.getScaledHeight() / 4 - 60, 16777215);

                for (int isa = 0; isa < CustomPackerSender.staticPlayerList.length; isa++)
                    drawCenteredString(textRenderer, CustomPackerSender.staticPlayerList[isa], screenScaler.getScaledWidth() / 2, screenScaler.getScaledHeight() / 4 - 50 + (isa * 10), 16777215);

                gradientRender(textRenderer.getTextWidth("Player List"), 8 * (1 + CustomPackerSender.staticPlayerList.length), (screenScaler.getScaledWidth() / 2) - textRenderer.getTextWidth("Player List"), screenScaler.getScaledHeight() / 4 - 60, new Color(27,27,27).getRGB(),new Color(27,27,27).getRGB());
            }
        }
    }

    private void drawCenteredString(TextRenderer textRenderer, String s, int width, int height, int color)
    {
        textRenderer.drawTextWithShadow(s, width - (textRenderer.getTextWidth(s) / 2), height, color);
    }

    private void gradientRender(int x1, int y1, int x2, int y2, int startColour, int endColour) {
        float var7 = (float)(startColour >> 24 & 255) / 255.0F;
        float var8 = (float)(startColour >> 16 & 255) / 255.0F;
        float var9 = (float)(startColour >> 8 & 255) / 255.0F;
        float var10 = (float)(startColour & 255) / 255.0F;
        float var11 = (float)(endColour >> 24 & 255) / 255.0F;
        float var12 = (float)(endColour >> 16 & 255) / 255.0F;
        float var13 = (float)(endColour >> 8 & 255) / 255.0F;
        float var14 = (float)(endColour & 255) / 255.0F;
        GL11.glDisable(3553);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 771);
        GL11.glShadeModel(7425);
        Tessellator var15 = Tessellator.INSTANCE;
        var15.start();
        var15.colour(var8, var9, var10, var7);
        var15.pos(x2, y1, 0.0D);
        var15.pos(x1, y1, 0.0D);
        var15.colour(var12, var13, var14, var11);
        var15.pos(x1, y2, 0.0D);
        var15.pos(x2, y2, 0.0D);
        var15.draw();
        GL11.glShadeModel(7424);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glEnable(3553);
    }




}
