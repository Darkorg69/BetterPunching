package darkorg.betterpunching.features;

import darkorg.betterpunching.effects.custom.ModEffectInstance;
import darkorg.betterpunching.effects.ModEffects;
import darkorg.betterpunching.setup.Config;
import darkorg.betterpunching.util.ToolCheck;
import net.minecraft.block.AbstractGlassBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@SuppressWarnings("unused")
public class PunchingGlass {

    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event) {

        PlayerEntity player = event.getPlayer();
        ItemStack stack = player.getHeldItemMainhand();
        BlockState state = event.getState();
        Block block = state.getBlock();

        DamageSource invalidpunching = new DamageSource("invalidpunching");

        if(!Config.punchingGlassEnabled.get()) {return;}

        if ((block instanceof AbstractGlassBlock) || (block instanceof PaneBlock)) {
            if (ToolCheck.isInvalidTool(state, stack)) {
                if (stack.isEmpty()) {
                    player.attackEntityFrom(invalidpunching, Config.wrongToolDamage.get().floatValue());
                    player.addPotionEffect(new ModEffectInstance(ModEffects.BLEEDING.get(), 200, 0));
                    if(Config.miningFatigueDebuffEnabled.get()) {
                        player.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 200, 1));
                    }
                    if(Config.weaknessDebuffEnabled.get()) {
                        player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 200, 1));
                    }
                }
            }
            event.setNewSpeed(Float.MAX_VALUE);
        }
    }
}