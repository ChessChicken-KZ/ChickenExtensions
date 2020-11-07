package kz.chesschicken.chickenextensions.api.common;

import kz.chesschicken.chickenextensions.ChickenMod;
import kz.chesschicken.chickenextensions.api.player.CustomPlayerHandler;
import kz.chesschicken.chickenextensions.entity.BloodyPigman;
import kz.chesschicken.chickenextensions.item.obsidianboat.EntityObsidianBoat;
import kz.chesschicken.chickenextensions.item.obsidianboat.RenderObisidianBoat;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.player.PlayerBase;
import net.modificationstation.stationloader.api.client.event.render.entity.EntityRendererRegister;
import net.modificationstation.stationloader.api.common.config.Category;
import net.modificationstation.stationloader.api.common.config.Configuration;
import net.modificationstation.stationloader.api.common.config.Property;
import net.modificationstation.stationloader.api.common.entity.player.PlayerHandler;
import net.modificationstation.stationloader.api.common.event.entity.EntityRegister;
import net.modificationstation.stationloader.api.common.event.entity.player.PlayerHandlerRegister;
import uk.co.benjiweber.expressions.functions.TriConsumer;

import java.util.List;
import java.util.Map;

public class RegisteringEntity implements EntityRegister, PlayerHandlerRegister, EntityRendererRegister {


    @Override
    public void registerEntities(TriConsumer<Class<? extends EntityBase>, String, Integer> triConsumer) {
        Configuration config = ChickenMod.INSTANCE.getDefaultConfig();
        Category mobIDsCategory = config.getCategory("Mob IDs");
        Property bloodPigmanID = mobIDsCategory.getProperty("bloodPigmanID", 20);


        triConsumer.accept(BloodyPigman.class, "BloodPigman", bloodPigmanID.getIntValue());
        config.save();
    }

    @Override
    public void registerPlayerHandlers(List<PlayerHandler> list, PlayerBase playerBase) {
        list.add(new CustomPlayerHandler(playerBase));
    }

    @Override
    public void registerEntityRenderers(Map<Class<? extends EntityBase>, EntityRenderer> map) {
        map.put(EntityObsidianBoat.class, new RenderObisidianBoat());
    }
}
