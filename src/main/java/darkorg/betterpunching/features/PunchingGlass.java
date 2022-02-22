package darkorg.betterpunching.features;

import darkorg.betterpunching.effects.custom.ModEffectInstance;
import darkorg.betterpunching.effects.ModEffects;
import darkorg.betterpunching.setup.Config;
import darkorg.betterpunching.util.ToolCheck;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@SuppressWarnings("unused")
public class PunchingGlass {

    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event) {
        Player player = event.getPlayer();
        ItemStack stack = player.getMainHandItem();
        BlockState state = event.getState();
        Block block = state.getBlock();

        DamageSource invalidpunching = new DamageSource("invalidpunching");

        if(!Config.punchingGlassEnabled.get()) {return;}

        if ((state.getMaterial() == Material.GLASS)) {
            if (!ToolCheck.isCorrectToolForDrops(stack, state)) {
                if (stack.isEmpty()) {
                    player.hurt(invalidpunching, Config.wrongToolDamage.get().floatValue());
                    player.addEffect(new ModEffectInstance(ModEffects.BLEEDING.get(), 200, 0));
                    if(Config.miningFatigueDebuffEnabled.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200, 1));
                    }
                    if(Config.weaknessDebuffEnabled.get()) {
                        player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 1));
                    }
                }
            }
            event.setNewSpeed(Float.MAX_VALUE);
        }
    }
}