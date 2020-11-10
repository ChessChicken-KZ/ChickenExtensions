package kz.chesschicken.chickenextensions.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.Session;
import net.minecraft.entity.player.AbstractClientPlayer;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractClientPlayer.class)
public class MixinPlayerSP extends PlayerBase {

    //Unnecessary code
    public MixinPlayerSP(Level arg) { super(arg); }
    @Override public void method_494() { }
    //

    @Inject(method = "<init>", at = @At("TAIL"))
    private void setSkin(Minecraft minecraft, Level level, Session session, int dimensionId, CallbackInfo ci)
    {
        if (session != null && session.username != null && session.username.length() > 0) {
            this.skinUrl = "http://http://assets.rubeta.net/skins/" + session.username + ".png";
        }
    }



}
