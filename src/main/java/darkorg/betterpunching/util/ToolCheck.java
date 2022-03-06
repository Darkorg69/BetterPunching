package darkorg.betterpunching.util;

import darkorg.betterpunching.setup.Config;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.state.BlockState;

public class ToolCheck {
    public static boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        boolean isWood = BlockUtil.isWood(state);
        boolean isCorrectToolForDrops = stack.isCorrectToolForDrops(state);
        boolean requiresCorrectToolForDrops = state.requiresCorrectToolForDrops();

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

