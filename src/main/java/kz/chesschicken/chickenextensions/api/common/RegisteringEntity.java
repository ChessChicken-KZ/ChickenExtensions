package kz.chesschicken.chickenextensions.api.common;

import kz.chesschicken.chickenextensions.ChickenMod;
import kz.chesschicken.chickenextensions.block.furniture.TileCorpseBox;
import kz.chesschicken.chickenextensions.block.furniture.TileEntityExtended;
import kz.chesschicken.chickenextensions.entity.BloodyPigman;
import kz.chesschicken.chickenextensions.item.obsidianboat.EntityObsidianBoat;
import kz.chesschicken.chickenextensions.item.obsidianboat.RenderObisidianBoat;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.EntityBase;
import net.modificationstation.stationloader.api.client.event.render.entity.EntityRendererRegister;
import net.modificationstation.stationloader.api.common.config.Category;
import net.modificationstation.stationloader.api.common.config.Configuration;
import net.modificationstation.stationloader.api.common.config.Property;
import net.modificationstation.stationloader.api.common.event.block.TileEntityRegister;
import net.modificationstation.stationloader.api.common.event.entity.EntityRegister;
import uk.co.benjiweber.expressions.functions.TriConsumer;

import java.util.Map;

public class RegisteringEntity implements EntityRegister, EntityRendererRegister, TileEntityRegister {


    @Override
    public void registerEntities(TriConsumer<Class<? extends EntityBase>, String, Integer> triConsumer) {
        Configuration config = ChickenMod.INSTANCE.getDefaultConfig();
        Category mobIDsCategory = config.getCategory("Mob IDs");
        Property bloodPigmanID = mobIDsCategory.getProperty("bloodPigmanID", 20);
        Property boatObsidianID = mobIDsCategory.getProperty("boatObsidianID", 21);


        triConsumer.accept(BloodyPigman.class, "BloodPigman", bloodPigmanID.getIntValue());
        triConsumer.accept(EntityObsidianBoat.class, "Obsidian Boat", boatObsidianID.getIntValue());
        config.save();
    }


    @Override
    public void registerEntityRenderers(Map<Class<? extends EntityBase>, EntityRenderer> map) {
        map.put(EntityObsidianBoat.class, new RenderObisidianBoat());
    }

    @Override
    public void registerTileEntities(Map<Class<?>, String> map) {
        map.put(TileEntityExtended.class, "TileEntityExtended");
        map.put(TileCorpseBox.class, "TileCorpseBox");
    }
}
