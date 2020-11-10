package kz.chesschicken.chickenextensions.mixin.client;


import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.AbstractClientPlayer;
import net.minecraft.entity.player.ClientPlayer;
import net.minecraft.entity.player.PlayerBase;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerBase.class)
public class MixinPlayerClient {
    private Minecraft mc = (Minecraft) FabricLoader.getInstance().getGameInstance();

    @Redirect(method = "initCloak()V", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/player/PlayerBase;playerCloakUrl:Ljava/lang/String;", opcode = Opcodes.PUTFIELD))
    private void getPlayerCloakUrl(PlayerBase playerBase, String value)
    {
        playerBase.playerCloakUrl = "http://assets.rubeta.net/cloaks/" + playerBase.name + ".png";
    }



}
