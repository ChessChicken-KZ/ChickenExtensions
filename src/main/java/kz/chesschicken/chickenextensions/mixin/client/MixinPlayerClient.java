package kz.chesschicken.chickenextensions.mixin.client;


import net.minecraft.container.ContainerBase;
import net.minecraft.entity.player.PlayerBase;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerBase.class)
public class MixinPlayerClient {
    @Shadow public String playerCloakUrl;

    //@Redirect(method = "initCloak()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerBase;playerCloakUrl()Ljava/lang/String", opcode = Opcodes.PUTFIELD))
    //private void getPlayerCloakUrl(PlayerBase playerBase)
    //{
    //    playerBase.playerCloakUrl = "";
//
    //}



}
