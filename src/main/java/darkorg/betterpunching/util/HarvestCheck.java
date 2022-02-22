package darkorg.betterpunching.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class HarvestCheck {
    public static boolean canHarvestBlock(BlockState state, Player player, Level world, BlockPos pos) {
        return state.canHarvestBlock(world, pos, player);
    }
}


