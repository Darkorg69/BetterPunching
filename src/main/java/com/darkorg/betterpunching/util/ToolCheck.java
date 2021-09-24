package com.darkorg.betterpunching.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;

public class ToolCheck {
    public static boolean isInvalidTool(IBlockState state, ItemStack stack) {
        String blockHarvestTool = state.getBlock().getHarvestTool(state);
        if (blockHarvestTool != null) {
            for (String toolType : stack.getItem().getToolClasses(stack)) {
                if (blockHarvestTool.equals(toolType)) {
                    return false;
                }
            }
        }
        return true;
    }
}

