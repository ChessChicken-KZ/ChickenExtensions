package kz.chesschicken.chickenextensions.mixin.client;

import kz.chesschicken.chickenextensions.ChickenMod;
import kz.chesschicken.chickenextensions.api.common.VersionGui;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.ScreenBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Environment(EnvType.CLIENT)
@Mixin(Minecraft.class)
public abstract class MixinVersionCheck {
    @Shadow public abstract void openScreen(ScreenBase screen);

    @Inject(method = "init", at = @At("TAIL"))
    private void rungui(CallbackInfo ci)
    {
        if(ChickenMod.isCheckVersion)
            if(!isNewVersion())
                this.openScreen(new VersionGui());
    }

    private boolean isNewVersion()
    {
        String i = "";
        try
        {
            URL url = new URL("https://raw.githubusercontent.com/ChessChicken-KZ/ChickenExtensions/main/LATEST_VERSION");
            BufferedReader read = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            i = read.readLine();
            read.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return i.equals(ChickenMod.INSTANCE.VERSION);
    }

}
