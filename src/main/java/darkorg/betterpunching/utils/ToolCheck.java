package darkorg.betterpunching.utils;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ToolType;

public class ToolCheck {
    public static boolean isInvalidTool(BlockState state, ItemStack stack) {
        ToolType blockHarvestTool = state.getBlock().getHarvestTool(state);
        if (blockHarvestTool != null) {
            for (ToolType toolType : stack.getItem().getToolTypes(stack)) {
                if (blockHarvestTool.equals(toolType)) {
                    return false;
                }
            }
        }
        return true;
    }
}

