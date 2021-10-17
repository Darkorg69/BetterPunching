package darkorg.betterpunching.features;

import darkorg.betterpunching.setup.Config;
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

public class WrongTool {

    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event) {

        PlayerEntity player = event.getPlayer();
        ItemStack stack = player.getMainHandItem();
        BlockState state = event.getState();
        Block block = state.getBlock();
        BlockPos pos = event.getPos();
        World world = event.getPlayer().getCommandSenderWorld();

        DamageSource invalidpunching = new DamageSource("invalidpunching");

        if(!Config.wrongToolEnabled.get()) {return;}

        if(block.getSpeedFactor() == 0.0F) {return;}


        if(ToolCheck.isInvalidTool(state,stack) && !HarvestCheck.canHarvest(state,player,world,pos)) {

            //Exceptions
            if((block instanceof SnowBlock) ||
               (block instanceof WebBlock) ||
               (block instanceof AbstractGlassBlock) ||
               (block instanceof PaneBlock) ||
               (state.is(BlockTags.LOGS)) ||
               (state.is(BlockTags.PLANKS)) ||
               (state.is(BlockTags.WOODEN_SLABS)) ||
               (state.is(BlockTags.WOODEN_STAIRS)))
            {return;}

            if(stack.isEmpty()) {
                player.hurt(invalidpunching, Config.wrongToolDamage.get().floatValue());
            }
            event.setNewSpeed(-1.0F);
        }
    }
}