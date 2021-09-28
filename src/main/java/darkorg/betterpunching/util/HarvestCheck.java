package darkorg.betterpunching.util;

import net.minecraft.block.AbstractGlassBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.PaneBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class HarvestCheck {
    public static boolean canHarvest(BlockState state, PlayerEntity player, World world, BlockPos pos) {
        if(
        (state.is(BlockTags.LOGS)) ||
        (state.is(BlockTags.PLANKS)) ||
        (state.is(BlockTags.WOODEN_SLABS)) ||
        (state.is(BlockTags.WOODEN_STAIRS)) ||
        //Tinker's construct glass bugfix.
        (state.getBlock() instanceof AbstractGlassBlock) || (state.getBlock() instanceof PaneBlock))
        {return false;}
        return ForgeHooks.canHarvestBlock(state, player, world, pos);
    }
}


