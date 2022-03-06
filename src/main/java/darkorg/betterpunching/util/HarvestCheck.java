package darkorg.betterpunching.util;

import darkorg.betterpunching.setup.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class HarvestCheck {
    public static boolean canHarvestBlock(BlockState state, Level level,BlockPos pos, Player player) {
        boolean canHarvestBlock = state.canHarvestBlock(level,pos,player);
        if (Config.debugEnabled.get()) {
            System.out.println("canHarvestBlock = " + canHarvestBlock);
        }
        return canHarvestBlock;
    }
}



