package kz.chesschicken.chickenextensions.item.mobcatcher;

import net.minecraft.util.io.CompoundTag;
import net.modificationstation.stationloader.api.common.item.ItemEntity;

public class NBTMobCatcher implements ItemEntity {

	public NBTMobCatcher(CompoundTag tag) {
		this(tag.getString("chickenextensions:mobc_mob"));
	}

	public NBTMobCatcher(String mobString) {
		this.mob = mobString;
	}

    public NBTMobCatcher() {
	        this.mob = "";
    }

    @Override
	public ItemEntity copy() {
		return new NBTMobCatcher(mob);
	}

	@Override
	public void writeToNBT(CompoundTag compoundTag) {
		compoundTag.put("chickenextensions:mobc_mob", getDisplayNumber());
	}

	public String getDisplayNumber() {
		return mob;
	}

	private final String mob;
}
