package darkorg.betterpunching.utils;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class HarvestCheck {
    public static boolean canHarvest(BlockState state, PlayerEntity player, World world, BlockPos pos) {
        return ForgeHooks.canHarvestBlock(state, player, world, pos);
    }
}


