package kz.chesschicken.chickenextensions.api.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.packet.AbstractPacket;
import net.minecraft.server.MinecraftServer;
import net.modificationstation.stationloader.api.common.event.packet.PacketRegister;
import net.modificationstation.stationloader.api.common.factory.GeneralFactory;
import net.modificationstation.stationloader.api.common.packet.CustomData;
import net.modificationstation.stationloader.api.common.packet.PacketHelper;
import uk.co.benjiweber.expressions.functions.QuadConsumer;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class CustomPackerSender implements PacketRegister {
    public static String[] staticPlayerList;
    private final MinecraftServer minecraftServer = (MinecraftServer) FabricLoader.getInstance().getGameInstance();




    @Environment(EnvType.CLIENT)
    public static void queue_PacketGetList(String s)
    {
        CustomData packet = GeneralFactory.INSTANCE.newInst(CustomData.class, "chickenextensions:playerlist");
        packet.set(new String[] {s});
        PacketHelper.INSTANCE.send((AbstractPacket) packet);
    }



    @Override
    public void registerPackets(QuadConsumer<Integer, Boolean, Boolean, Class<? extends AbstractPacket>> quadConsumer, Map<String, BiConsumer<PlayerBase, CustomData>> map) {
        map.put("playerlist", this::handleSendPlayers);
        map.put("playerlistResult", this::handleSendRes);
        System.out.println("R u good boy?");
    }

    public void handleSendPlayers(PlayerBase playerBase, CustomData customData)
    {
        if(FabricLoader.getInstance().getEnvironmentType() == EnvType.SERVER)
        {
            CustomData packet = GeneralFactory.INSTANCE.newInst(CustomData.class, "chickenextensions:playerlistResult");
            packet.set(getPlayerNickList(minecraftServer.serverPlayerConnectionManager.players));
            PacketHelper.INSTANCE.sendTo(getPlayerBase(customData), (AbstractPacket) packet);
        }
    }

    @Environment(EnvType.SERVER)
    public PlayerBase getPlayerBase(CustomData customData)
    {
       return minecraftServer.serverPlayerConnectionManager.getServerPlayer(((String) customData.objects()[0]));
    }

    public void handleSendRes(PlayerBase playerBase, CustomData customData)
    {
        staticPlayerList = (String[]) customData.objects();
    }


    public String[] getPlayerNickList(List players)
    {
        String[] lol = new String[players.size()];
        for(int i = 0; i < lol.length; i++)
        {
            lol[i] = ((PlayerBase)players.get(i)).name;
        }
        return lol;
    }
}
