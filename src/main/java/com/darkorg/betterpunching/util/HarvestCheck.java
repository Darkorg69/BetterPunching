package com.darkorg.betterpunching.util;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class HarvestCheck {
    public static boolean canHarvest(Block block, EntityPlayer player, World world, BlockPos pos) {
        if (block.isWood(world, pos)) {return false;}
        return ForgeHooks.canHarvestBlock(block, player, world, pos);
    }
}


