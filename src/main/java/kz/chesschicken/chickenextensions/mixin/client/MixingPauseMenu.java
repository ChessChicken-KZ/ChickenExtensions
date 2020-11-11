package kz.chesschicken.chickenextensions.mixin.client;

import kz.chesschicken.chickenextensions.api.client.GuiPlayerList;
import net.minecraft.client.gui.screen.ScreenBase;
import net.minecraft.client.gui.screen.ingame.Pause;
import net.minecraft.client.gui.widgets.Button;
import net.minecraft.client.resource.language.I18n;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Pause.class)
public class MixingPauseMenu extends ScreenBase {
    @Inject(method = "buttonClicked", at = @At("TAIL"))
    private void r111(Button button, CallbackInfo ci)
    {
        if (button.id == 8) {
            minecraft.openScreen(new GuiPlayerList());
        }
    }

    @Inject(method = "init", at = @At("TAIL"))
    private void r112(CallbackInfo ci)
    {
        this.buttons.add(new Button(8, 5, 5, 20, 20, "LOL"));
    }
}
