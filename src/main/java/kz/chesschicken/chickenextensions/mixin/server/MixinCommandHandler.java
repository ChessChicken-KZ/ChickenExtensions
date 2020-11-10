package kz.chesschicken.chickenextensions.mixin.server;

import kz.chesschicken.chickenextensions.api.server.PlayerAsync;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ServerPlayerConnectionManager;
import net.minecraft.server.command.Command;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.CommandSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CommandManager.class)
public class MixinCommandHandler {
    @Shadow private MinecraftServer server;
    @Shadow private void sendFeedbackAndLog(String commandSourceName, String message) {}

    @Inject(method = "processCommand", at = @At("HEAD"))
    private void injectCommands(Command arg, CallbackInfo ci)
    {

        String var2 = arg.commandString;
        CommandSource var3 = arg.source;
        String var4 = var3.getName();
        ServerPlayerConnectionManager var5 = this.server.serverPlayerConnectionManager;

        if (!var2.toLowerCase().startsWith("help") && !var2.toLowerCase().startsWith("?")) {
            if (var2.toLowerCase().startsWith("kill")) {
                String var13 = var2.substring(var2.indexOf(" ")).trim();
                PlayerBase playerBase = var5.getServerPlayer(var13);
                if(playerBase != null) {

                    this.sendFeedbackAndLog(var4, "Killed player " + var13);
                }else
                    this.sendFeedbackAndLog(var4, "Can't find player " + var13);
            }
            if (var2.toLowerCase().startsWith("shakal")) {
                String[] var13 = var2.split(var2);
                if(var13.length == 3)
                {
                    PlayerBase playerBase = var5.getServerPlayer(var13[1]);
                    if(playerBase != null) {
                        this.sendFeedbackAndLog(var4, "Shakaling " + var13[1] + " time:" + var13[2]);
                        (new PlayerAsync()).runPlayerShakal(playerBase, Integer.parseInt(var13[2]));
                    }
                    else
                        this.sendFeedbackAndLog(var4, "Can't find player " + var13[1]);
                }else
                    this.sendFeedbackAndLog(var4, "Not enough arguments" + var2);
            }
        }

    }

}
