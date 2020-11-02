package kz.chesschicken.chickenextensions.api;

import net.minecraft.client.gui.screen.Connecting;
import net.minecraft.client.gui.screen.ScreenBase;
import net.minecraft.client.gui.screen.menu.MainMenu;
import net.minecraft.client.gui.screen.menu.Multiplayer;
import net.minecraft.client.gui.widgets.Button;
import net.minecraft.client.gui.widgets.Textbox;
import net.minecraft.client.resource.language.TranslationStorage;
import org.lwjgl.input.Keyboard;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class VersionGui extends ScreenBase {
    String s = "https://github.com/ChessChicken-KZ/ChickenExtensions/releases";


    public void init() {
        Keyboard.enableRepeatEvents(true);
        this.buttons.clear();
        this.buttons.add(new Button(0, this.width / 2 - 100, this.height / 4 + 96 + 12, 98, 20, "Open Release Page"));
        this.buttons.add(new Button(1, this.width / 2 - 100 + 100, this.height / 4 + 96 + 12, 98, 20,"Cancel"));
    }

    public void onClose() {
        Keyboard.enableRepeatEvents(false);
    }

    protected void buttonClicked(Button button) {
        if (button.active) {
            if (button.id == 1) {
                this.minecraft.openScreen(new MainMenu());
            } else if (button.id == 0) {
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    try {
                        Desktop.getDesktop().browse(new URI("https://github.com/ChessChicken-KZ/ChickenExtensions/releases"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }else
                {

                }
            }

        }
    }




    public void render(int mouseX, int mouseY, float delta) {
        TranslationStorage var4 = TranslationStorage.getInstance();
        this.renderBackground();
        this.drawTextWithShadowCentred(this.textManager, var4.translate("multiplayer.title"), this.width / 2, this.height / 4 - 60 + 20, 16777215);
        this.drawTextWithShadow(this.textManager, var4.translate("multiplayer.info1"), this.width / 2 - 140, this.height / 4 - 60 + 60 + 0, 10526880);
        this.drawTextWithShadow(this.textManager, var4.translate("multiplayer.info2"), this.width / 2 - 140, this.height / 4 - 60 + 60 + 9, 10526880);
        super.render(mouseX, mouseY, delta);
    }
}
