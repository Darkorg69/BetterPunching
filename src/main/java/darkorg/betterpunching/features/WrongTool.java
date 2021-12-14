package darkorg.betterpunching.features;

import darkorg.betterpunching.setup.Config;
import darkorg.betterpunching.util.HarvestCheck;
import darkorg.betterpunching.util.ToolCheck;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@SuppressWarnings("unused")
public class WrongTool {

    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event) {
        BlockPos pos = event.getPos();
        BlockState state = event.getState();
        Block block = state.getBlock();
        PlayerEntity player = event.getPlayer();
        World world = player.getEntityWorld();
        ItemStack stack = player.getHeldItemMainhand();

        DamageSource invalidpunching = new DamageSource("invalidpunching");

        if(!Config.wrongToolEnabled.get()) {return;}
        if(block.getSpeedFactor() == 0.0F) {return;}

        if(ToolCheck.isInvalidTool(state,stack) && !HarvestCheck.canHarvest(state,player,world,pos)) {

            //Exceptions
            if((block instanceof SnowBlock) ||
               (block instanceof WebBlock) ||
               (block instanceof AbstractGlassBlock) ||
               (block instanceof PaneBlock) ||
               (state.isIn(BlockTags.LOGS)) ||
               (state.isIn(BlockTags.PLANKS)) ||
               (state.isIn(BlockTags.WOODEN_SLABS)) ||
               (state.isIn(BlockTags.WOODEN_STAIRS))) {return;}

            if(stack.isEmpty()) {
                player.attackEntityFrom(invalidpunching, Config.wrongToolDamage.get().floatValue());
                if(Config.weaknessDebuffEnabled.get()) {
                    player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 400, 0));
                }
                if(Config.miningFatigueDebuffEnabled.get()) {
                    player.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 400, 0));
                }
            }
            event.setNewSpeed(-1.0F);
        }
    }
}