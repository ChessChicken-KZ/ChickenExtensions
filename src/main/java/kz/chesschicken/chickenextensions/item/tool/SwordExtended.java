package kz.chesschicken.chickenextensions.item.tool;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockBase;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.Living;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.item.tool.ToolMaterial;

public class SwordExtended extends ItemBase {
    private int field_1314;

    public SwordExtended(int i, int durability, int attackDamage) {
        super(i);
        this.maxStackSize = 1;
        this.setDurability(durability);
        this.field_1314 = attackDamage;
    }

    public SwordExtended(int i, ToolMaterial material, int attackDamage) {
        super(i);
        this.maxStackSize = 1;
        this.setDurability(material.getDurability());
        this.field_1314 = attackDamage;
    }

    public float getStrengthOnBlock(ItemInstance item, BlockBase tile) {
        return tile.id == BlockBase.COBWEB.id ? 15.0F : 1.5F;
    }

    public boolean postHit(ItemInstance arg, Living damageSource, Living damageTarget) {
        arg.applyDamage(1, damageTarget);
        return true;
    }

    public boolean postMine(ItemInstance arg, int i, int j, int k, int i1, Living damageTarget) {
        arg.applyDamage(2, damageTarget);
        return true;
    }

    public int method_447(EntityBase arg) {
        return this.field_1314;
    }

    @Environment(EnvType.CLIENT)
    public boolean isRendered3d() {
        return true;
    }

    public boolean isEffectiveOn(BlockBase tile) {
        return tile.id == BlockBase.COBWEB.id;
    }

}
