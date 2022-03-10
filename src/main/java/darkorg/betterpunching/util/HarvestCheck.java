package darkorg.betterpunching.util;

import darkorg.betterpunching.setup.Config;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HarvestCheck {
    public static boolean canHarvestBlock(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        boolean canHarvestBlock = state.canHarvestBlock(world,pos,player);
        if (Config.debugEnabled.get()) {
            System.out.println("canHarvestBlock = " + canHarvestBlock);
        }
        return canHarvestBlock;
    }
}



