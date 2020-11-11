package kz.chesschicken.chickenextensions.api.client;

import net.minecraft.client.gui.screen.ScreenBase;
import net.minecraft.client.gui.widgets.Button;
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
        Keyboard.enableRepeatEvents(true);
        this.buttons.clear();

    }

    public void onClose() {
        Keyboard.enableRepeatEvents(false);
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
        this.renderBackground();
        this.drawTextWithShadowCentred(this.textManager, "Server list", this.width / 2, this.height / 4 - 60 + 20, 16777215);

        if(canRender)
        for(int i = 0; i < CustomPackerSender.staticPlayerList.length; i++)
        {
            this.drawTextWithShadow(textManager, CustomPackerSender.staticPlayerList[i], this.width / 2, this.height / 4 - 60 + 20 + (i * 10), 16777215);
        }
        super.render(mouseX, mouseY, delta);
    }
}
