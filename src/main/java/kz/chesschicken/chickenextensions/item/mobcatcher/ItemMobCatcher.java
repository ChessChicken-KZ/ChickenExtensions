package kz.chesschicken.chickenextensions.item.mobcatcher;

import kz.chesschicken.chickenextensions.ChickenMod;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.Living;
import net.minecraft.entity.animal.Chicken;
import net.minecraft.entity.animal.Cow;
import net.minecraft.entity.animal.Pig;
import net.minecraft.entity.animal.Sheep;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.entity.swimming.Squid;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.minecraft.util.io.CompoundTag;
import net.modificationstation.stationloader.api.common.item.HasItemEntity;
import net.modificationstation.stationloader.api.common.item.ItemEntity;
import net.modificationstation.stationloader.api.common.item.ItemWithEntity;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;

import javax.swing.text.html.parser.Entity;
import java.util.function.Function;
import java.util.function.Supplier;

public class ItemMobCatcher extends ItemBase implements ItemWithEntity {
    public ItemMobCatcher(int id) {
        super(id);
        this.setDurability(0);
        this.setMaxStackSize(1);
    }

    @Override
    public void interactWithEntity(ItemInstance arg, Living arg1) {
        if(arg.getDamage() < 1)
        {
            CompoundTag tag = new CompoundTag();
            tag.put("chickenextensions:mobc_mob", getD(arg1));
            System.out.println("MOB NEW IS "+tag.getString("chickenextensions:mobc_mob"));
            HasItemEntity.cast(arg).getItemEntity().writeToNBT(tag);


            arg1.remove();
        }
    }




    @Override
    public ItemInstance use(ItemInstance item, Level level, PlayerBase player) {
        if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) && HasItemEntity.cast(item).getItemEntity() != null)
        {

            String tag1 = ((NBTMobCatcher) HasItemEntity.cast(item).getItemEntity()).getDisplayNumber();
            System.out.println("Tag result is "+tag1);
            if(tag1 == null || tag1.equalsIgnoreCase(""))
                return item;
            EntityBase tospawn = (EntityBase) getAnimal(tag1, level);
            tospawn.setPosition(player.x,player.y,player.z);
            level.spawnEntity(tospawn);
        }
        return item;
    }

    private Object getAnimal(String mob, Level level)
    {
        if(mob.equalsIgnoreCase("Pig"))
            return new Pig(level);
        else if(mob.equalsIgnoreCase("Cow"))
            return new Cow(level);
        else if(mob.equalsIgnoreCase("Chicken"))
            return new Chicken(level);
        else if(mob.equalsIgnoreCase("Sheep"))
            return new Sheep(level);
        else if(mob.equalsIgnoreCase("Squid"))
            return new Squid(level);
        else
            return null;
    }

    private String getD(Object object)
    {
        if(object.getClass() == Pig.class)
            return "Pig";
        else if(object.getClass() == Cow.class)
            return "Cow";
        else if(object.getClass() == Chicken.class)
            return "Chicken";
        else if(object.getClass() == Sheep.class)
            return "Sheep";
        else if(object.getClass() == Squid.class)
            return "Squid";
        else
            return "";
    }

    @Override
    public Supplier<ItemEntity> getItemEntityFactory() {
        return NBTMobCatcher::new;
    }

    @Override
    public Function<CompoundTag, ItemEntity> getItemEntityNBTFactory() {
        return NBTMobCatcher::new;
    }
}
