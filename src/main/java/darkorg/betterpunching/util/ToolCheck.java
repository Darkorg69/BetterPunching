package darkorg.betterpunching.util;

import net.minecraft.world.item.*;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("BooleanMethodIsAlwaysInverted")
public class ToolCheck {
    public static boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        return stack.getItem().isCorrectToolForDrops(stack, state);
    }
}

