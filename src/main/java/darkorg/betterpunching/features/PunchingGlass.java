package darkorg.betterpunching.features;

import darkorg.betterpunching.setup.Config;
import darkorg.betterpunching.util.BlockUtil;
import darkorg.betterpunching.util.LivingEntity;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PunchingGlass {
    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event) {
        Player player = event.getPlayer();
        BlockState state = event.getState();

        if (Config.punchingGlassEnabled.get()) {
            if (BlockUtil.isGlass(state)) {
                ItemStack stack = player.getMainHandItem();
                if (stack.isEmpty()) {
                    Level level = player.getLevel();
                    if (level.getDifficulty() != Difficulty.PEACEFUL) {
                        if (Config.wrongToolDamageEnabled.get()) {
                            LivingEntity.hurtFists(player);
                        }
                        if (Config.bleedingEffectEnabled.get()) {
                            LivingEntity.applyBleedingEffect(player);
                        }
                        if (Config.weaknessDebuffEnabled.get()) {
                            LivingEntity.applyWeaknessEffect(player);
                        }
                        if (Config.miningFatigueDebuffEnabled.get()) {
                            LivingEntity.applyMiningFatigueEffect(player);
                        }
                    }
                }
                event.setNewSpeed(Float.MAX_VALUE);
            }
        }
    }
}