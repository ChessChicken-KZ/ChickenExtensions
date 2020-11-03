package kz.chesschicken.chickenextensions.item.tool;

import kz.chesschicken.chickenextensions.api.ExtendedMaterialEnum;
import kz.chesschicken.chickenextensions.api.ExtendedToolBase;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;

public class PickaxeExtended extends ExtendedToolBase {
    private static BlockBase[] effectiveBlocks;

    protected PickaxeExtended(int id, ExtendedMaterialEnum material) {
        super(id, 2, material, effectiveBlocks);
    }

    public boolean isEffectiveOn(BlockBase tile) {
        if (tile == BlockBase.OBSIDIAN) {
            return this.toolMaterial.getMiningLevel() == 3;
        } else if (tile != BlockBase.DIAMOND_BLOCK && tile != BlockBase.DIAMOND_ORE) {
            if (tile != BlockBase.GOLD_BLOCK && tile != BlockBase.GOLD_ORE) {
                if (tile != BlockBase.IRON_BLOCK && tile != BlockBase.IRON_ORE) {
                    if (tile != BlockBase.LAPIS_LAZULI_BLOCK && tile != BlockBase.LAPIS_LAZULI_ORE) {
                        if (tile != BlockBase.REDSTONE_ORE && tile != BlockBase.REDSTONE_ORE_LIT) {
                            if (tile.material == Material.STONE) {
                                return true;
                            } else {
                                return tile.material == Material.METAL;
                            }
                        } else {
                            return this.toolMaterial.getMiningLevel() >= 2;
                        }
                    } else {
                        return this.toolMaterial.getMiningLevel() >= 1;
                    }
                } else {
                    return this.toolMaterial.getMiningLevel() >= 1;
                }
            } else {
                return this.toolMaterial.getMiningLevel() >= 2;
            }
        } else {
            return this.toolMaterial.getMiningLevel() >= 2;
        }
    }

    static {
        effectiveBlocks = new BlockBase[]{BlockBase.COBBLESTONE, BlockBase.DOUBLE_STONE_SLAB, BlockBase.STONE_SLAB, BlockBase.STONE, BlockBase.SANDSTONE, BlockBase.MOSSY_COBBLESTONE, BlockBase.IRON_ORE, BlockBase.IRON_BLOCK, BlockBase.COAL_ORE, BlockBase.GOLD_BLOCK, BlockBase.GOLD_ORE, BlockBase.DIAMOND_ORE, BlockBase.DIAMOND_BLOCK, BlockBase.ICE, BlockBase.NETHERRACK, BlockBase.LAPIS_LAZULI_ORE, BlockBase.LAPIS_LAZULI_BLOCK};
    }
}
