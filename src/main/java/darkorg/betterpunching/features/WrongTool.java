package darkorg.betterpunching.features;

import darkorg.betterpunching.setup.Config;
import darkorg.betterpunching.util.HarvestCheck;
import darkorg.betterpunching.util.ToolCheck;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@SuppressWarnings("unused")
public class WrongTool {
    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event) {
        BlockPos pos = event.getPos();
        BlockState state = event.getState();
        Block block = state.getBlock();
        Player player = event.getPlayer();
        Level level = player.getLevel();
        ItemStack stack = player.getMainHandItem();

        DamageSource invalidpunching = new DamageSource("invalidpunching");

        if(!Config.wrongToolEnabled.get()) {return;}
        if(block.getSpeedFactor() == 0.0F) {return;}

        if(!ToolCheck.isCorrectToolForDrops(stack, state) && !HarvestCheck.canHarvestBlock(state, player, level, pos)) {
            if (state.getMaterial() == Material.WEB || state.getMaterial() == Material.TOP_SNOW) {return;}
            if(stack.isEmpty()) {
                player.hurt(invalidpunching, Config.wrongToolDamage.get().floatValue());
                if(Config.weaknessDebuffEnabled.get()) {
                    player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 0));
                }
                if(Config.miningFatigueDebuffEnabled.get()) {
                    player.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200, 0));
                }
            }
            event.setNewSpeed(-1.0F);
        }
    }
}