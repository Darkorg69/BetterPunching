package darkorg.betterpunching.features;

import darkorg.betterpunching.effects.ModEffects;
import darkorg.betterpunching.effects.custom.ModEffectInstance;
import darkorg.betterpunching.setup.Config;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@SuppressWarnings("unused")
public class PunchingCactus {
    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event) {
        Player player = event.getPlayer();
        ItemStack stack = player.getMainHandItem();
        BlockState state = event.getState();
        Block block = state.getBlock();

        DamageSource invalidpunching = new DamageSource("invalidpunching");

        if(!Config.punchingCactusEnabled.get()) {return;}

        if (block instanceof CactusBlock) {
            if (stack.isEmpty()) {
                if(!player.isCrouching()) {
                player.hurt(invalidpunching, Config.wrongToolDamage.get().floatValue());
                player.addEffect(new ModEffectInstance(ModEffects.SPLINTER.get(), 200, 0));
                event.setNewSpeed(0.0F);
                    if(Config.miningFatigueDebuffEnabled.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200, 0));
                    }
                    if(Config.weaknessDebuffEnabled.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 0));
                    }
                }
            }
        }
    }
}
