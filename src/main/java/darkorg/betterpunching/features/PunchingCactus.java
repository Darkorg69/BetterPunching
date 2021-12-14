package darkorg.betterpunching.features;

import darkorg.betterpunching.effects.ModEffects;
import darkorg.betterpunching.effects.custom.ModEffectInstance;
import darkorg.betterpunching.setup.Config;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CactusBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@SuppressWarnings("unused")
public class PunchingCactus {
    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event) {
        PlayerEntity player = event.getPlayer();
        ItemStack stack = player.getHeldItemMainhand();
        BlockState state = event.getState();
        Block block = state.getBlock();

        DamageSource invalidpunching = new DamageSource("invalidpunching");

        if(!Config.punchingCactusEnabled.get()) {return;}

        if (block instanceof CactusBlock) {
            if (stack.isEmpty()) {
                if(!player.isCrouching()) {
                player.attackEntityFrom(invalidpunching, Config.wrongToolDamage.get().floatValue());
                player.addPotionEffect(new ModEffectInstance(ModEffects.SPLINTER.get(), 200, 0));
                event.setNewSpeed(0.0F);
                    if(Config.miningFatigueDebuffEnabled.get()) {
                        player.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 200, 0));
                    }
                    if(Config.weaknessDebuffEnabled.get()) {
                        player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 200, 0));
                    }
                }
            }
        }
    }
}
