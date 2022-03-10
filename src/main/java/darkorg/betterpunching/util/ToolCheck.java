package darkorg.betterpunching.util;

import darkorg.betterpunching.setup.Config;
import net.minecraft.block.BlockState;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;

@SuppressWarnings("BooleanMethodIsAlwaysInverted")
public class ToolCheck {
    public static boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        boolean isWood = BlockUtil.isWood(state);
        boolean requiresCorrectToolForDrops = state.getRequiresTool();
        boolean isCorrectToolForDrops = stack.getToolTypes().contains(state.getHarvestTool());

        if (Config.debugEnabled.get()) {
            System.out.println("isWood = " + isWood);
            System.out.println("isCorrectToolForDrops = " + isCorrectToolForDrops);
            System.out.println("requiresCorrectToolForDrops = " + requiresCorrectToolForDrops);
        }
        if (!isWood) {
            if (requiresCorrectToolForDrops) {
                return isCorrectToolForDrops;
            }
            return true;
        }
        if (stack.getItem() instanceof AxeItem) {
            return true;
        }
        return isCorrectToolForDrops;
    }
}

