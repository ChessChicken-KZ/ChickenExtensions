package kz.chesschicken.chickenextensions.mixin;

import kz.chesschicken.chickenextensions.ChickenMod;
import kz.chesschicken.chickenextensions.api.VersionGui;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.ScreenBase;
import net.modificationstation.stationloader.api.common.StationLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

@Mixin(Minecraft.class)
public abstract class VersionCheckMixin {
    @Shadow public abstract void openScreen(ScreenBase screen);

    @Inject(method = "init", at = @At("TAIL"))
    private void rungui(CallbackInfo ci)
    {
        if(!isNewVersion())
            this.openScreen(new VersionGui());
    }

    private boolean isNewVersion()
    {
        String i = "";
        try
        {
            URL url = new URL("http://domain.com/file.txt");
            BufferedReader read = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            i = read.readLine();
            read.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return i.equals(ChickenMod.VERSION);
    }

}