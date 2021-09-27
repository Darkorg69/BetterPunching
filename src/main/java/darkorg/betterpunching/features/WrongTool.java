package darkorg.betterpunching.features;

import darkorg.betterpunching.util.HarvestCheck;
import darkorg.betterpunching.util.ToolCheck;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

//Known bugs: Punching blocks with -1 hardness (Bedrock for example) won't cause you any damage.

public class WrongTool {
    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event) {

        PlayerEntity player = event.getPlayer();
        ItemStack stack = player.getMainHandItem();
        BlockState state = event.getState();
        Block block = state.getBlock();
        BlockPos pos = event.getPos();
        World world = event.getPlayer().getCommandSenderWorld();

        DamageSource splinter = new DamageSource("splinter");
        DamageSource cutbyglass = new DamageSource("cutbyglass");
        DamageSource invalidpunching = new DamageSource("invalidpunching");

        //If the block is INSTANT_BREAK, then just do nothing.
        if(block.getSpeedFactor() == 0.0F) {return;}

        //Glass now breaks instantaneous with any item, open hand hurts like hell.
        if ((block instanceof AbstractGlassBlock) || (block instanceof PaneBlock)) {
            if(stack.isEmpty()) {
                player.hurt(cutbyglass, 5.0F);
            }
            event.setNewSpeed(Float.MAX_VALUE);
        }

        if(ToolCheck.isInvalidTool(state,stack) && !HarvestCheck.canHarvest(state,player,world,pos)) {

            //Exceptions
            if(block instanceof SnowBlock || block instanceof WebBlock) {return;}

            if(stack.isEmpty()) {
                if(
                  (state.is(BlockTags.LOGS)) ||
                  (state.is(BlockTags.PLANKS)) ||
                  (state.is(BlockTags.WOODEN_SLABS)) ||
                  (state.is(BlockTags.WOODEN_STAIRS)))
                {player.hurt(splinter, 3.0F);}

                player.hurt(invalidpunching, 2.0F);
            }
            event.setNewSpeed(-1.0F);
        }
    }
}