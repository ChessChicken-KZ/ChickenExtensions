package kz.chesschicken.chickenextensions.block.furniture;

import kz.chesschicken.chickenextensions.api.common.RegisteringClass;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.inventory.InventoryBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.tileentity.TileEntityBase;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.io.CompoundTag;
import net.minecraft.util.io.ListTag;

public class TileEntityExtended extends TileEntityBase implements InventoryBase {
    private ItemInstance[] contents = new ItemInstance[36];

    private String getTileName()
    {
        if(this.level.getTileId(x,y,z) == RegisteringClass.furnitureCabinet.id)
            return "Cabinet";
        else if(this.level.getTileId(x,y,z) == RegisteringClass.furnitureNightstand.id)
            return "Nightstand";
        else if(this.level.getTileId(x,y,z) == RegisteringClass.furnitureBox.id)
            return "Box";
        else if(this.level.getTileId(x,y,z) == RegisteringClass.furnitureLocker.id)
            return "Locker";
        else if(this.level.getTileId(x,y,z) == RegisteringClass.furnitureCommode.id)
            return "Commode";
        else if(this.level.getTileId(x,y,z) == RegisteringClass.furnitureFridge.id)
            return "Fridge";
        return "";
    }


    public int getInventorySize() {
        return 27;
    }

    public ItemInstance getInventoryItem(int i) {
        return this.contents[i];
    }

    public ItemInstance takeInventoryItem(int index, int j) {
        if (this.contents[index] != null) {
            ItemInstance var3;
            if (this.contents[index].count <= j) {
                var3 = this.contents[index];
                this.contents[index] = null;
                this.markDirty();
                return var3;
            } else {
                var3 = this.contents[index].split(j);
                if (this.contents[index].count == 0) {
                    this.contents[index] = null;
                }

                this.markDirty();
                return var3;
            }
        } else {
            return null;
        }
    }

    public TileEntityExtended()
    {

    }

    public void setInventoryItem(int slot, ItemInstance arg) {
        this.contents[slot] = arg;
        if (arg != null && arg.count > this.getMaxItemCount()) {
            arg.count = this.getMaxItemCount();
        }

        this.markDirty();
    }

    public String getContainerName() {
        return getTileName();
    }

    public void readIdentifyingData(CompoundTag tag) {
        super.readIdentifyingData(tag);
        ListTag var2 = tag.getListTag("Items");
        this.contents = new ItemInstance[this.getInventorySize()];

        for(int var3 = 0; var3 < var2.size(); ++var3) {
            CompoundTag var4 = (CompoundTag)var2.get(var3);
            int var5 = var4.getByte("Slot") & 255;
            if (var5 >= 0 && var5 < this.contents.length) {
                this.contents[var5] = new ItemInstance(var4);
            }
        }

    }

    public void writeIdentifyingData(CompoundTag tag) {
        super.writeIdentifyingData(tag);
        ListTag var2 = new ListTag();

        for(int var3 = 0; var3 < this.contents.length; ++var3) {
            if (this.contents[var3] != null) {
                CompoundTag var4 = new CompoundTag();
                var4.put("Slot", (byte)var3);
                this.contents[var3].toTag(var4);
                var2.add(var4);
            }
        }

        tag.put("Items", var2);
    }

    public int getMaxItemCount() {
        return 64;
    }

    public boolean canPlayerUse(PlayerBase arg) {
        if (this.level.getTileEntity(this.x, this.y, this.z) != this) {
            return false;
        } else {
            return arg.squaredDistanceTo((double)this.x + 0.5D, (double)this.y + 0.5D, (double)this.z + 0.5D) <= 64.0D;
        }
    }
}
