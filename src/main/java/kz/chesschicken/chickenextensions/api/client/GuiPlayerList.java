package kz.chesschicken.chickenextensions.api.client;

import net.minecraft.client.gui.screen.ScreenBase;
import net.minecraft.client.gui.widgets.Button;
import net.minecraft.client.resource.language.TranslationStorage;
import org.lwjgl.input.Keyboard;

public class GuiPlayerList extends ScreenBase {

    private int tickGui = 40;
    private boolean canRender = false;

    @Override
    public void tick() {
        if(tickGui == 40)
        {
            CustomPackerSender.queue_PacketGetList(minecraft.session.username);
            tickGui = 0;
        }else
            tickGui++;

        if(CustomPackerSender.staticPlayerList != null)
            canRender = true;
    }

    public void init() {
        TranslationStorage var1 = TranslationStorage.getInstance();
        Keyboard.enableRepeatEvents(true);
        this.buttons.clear();
        this.buttons.add(new Button(0, this.width / 2 - 100, this.height / 4 + 96 + 12, var1.translate("multiplayer.connect")));
        this.buttons.add(new Button(1, this.width / 2 - 100, this.height / 4 + 120 + 12, var1.translate("gui.cancel")));

    }

    public void onClose() {
        Keyboard.enableRepeatEvents(false);
    }

    protected void buttonClicked(Button button) {
        if (button.active) {
            if (button.id == 1) {
                this.minecraft.openScreen(null);
            } else if (button.id == 0) {

            }

        }
    }


    protected void keyPressed(char character, int key) {
        if (character == '\r') {
            this.buttonClicked((Button)this.buttons.get(0));
        }
    }

    protected void mouseClicked(int mouseX, int mouseY, int button) {
        super.mouseClicked(mouseX, mouseY, button);
    }

    public void render(int mouseX, int mouseY, float delta) {
        TranslationStorage var4 = TranslationStorage.getInstance();
        this.renderBackground();
        this.drawTextWithShadowCentred(this.textManager, var4.translate("multiplayer.title"), this.width / 2, this.height / 4 - 60 + 20, 16777215);

        if(canRender)
        for(int i = 0; i < CustomPackerSender.staticPlayerList.length; i++)
        {
            this.drawTextWithShadow(textManager, CustomPackerSender.staticPlayerList[i], 10, 10 + (i * 10), 16777215);
        }
        super.render(mouseX, mouseY, delta);
    }
}
