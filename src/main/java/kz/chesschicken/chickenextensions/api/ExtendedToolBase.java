package kz.chesschicken.chickenextensions.api;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockBase;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.Living;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.item.tool.ToolMaterial;

public class ExtendedToolBase extends ItemBase {
    private BlockBase[] effectiveBlocksBase;
    private float field_2713 = 4.0F;
    private int field_2714;
    protected ExtendedMaterialEnum toolMaterial;

    public ExtendedToolBase(int id, int j, ExtendedMaterialEnum arg, BlockBase[] effectiveBlocks) {
        super(id);
        this.toolMaterial = arg;
        this.effectiveBlocksBase = effectiveBlocks;
        this.maxStackSize = 1;
        this.setDurability(arg.getDurability());
        this.field_2713 = arg.getMiningSpeed();
        this.field_2714 = j + arg.getAttackDamage();
    }

    public float getStrengthOnBlock(ItemInstance item, BlockBase tile) {
        for(int var3 = 0; var3 < this.effectiveBlocksBase.length; ++var3) {
            if (this.effectiveBlocksBase[var3] == tile) {
                return this.field_2713;
            }
        }

        return 1.0F;
    }

    public boolean postHit(ItemInstance arg, Living damageSource, Living damageTarget) {
        arg.applyDamage(2, damageTarget);
        return true;
    }

    public boolean postMine(ItemInstance arg, int i, int j, int k, int i1, Living damageTarget) {
        arg.applyDamage(1, damageTarget);
        return true;
    }

    public int method_447(EntityBase arg) {
        return this.field_2714;
    }

    @Environment(EnvType.CLIENT)
    public boolean isRendered3d() {
        return true;
    }
}
