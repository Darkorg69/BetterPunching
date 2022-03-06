package darkorg.betterpunching.features;

import darkorg.betterpunching.setup.Config;
import darkorg.betterpunching.util.HarvestCheck;
import darkorg.betterpunching.util.LivingEntity;
import darkorg.betterpunching.util.ToolCheck;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class WrongTool {
    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event) {
        BlockPos pos = event.getPos();
        BlockState state = event.getState();
        Player player = event.getPlayer();

        if (Config.wrongToolEnabled.get()) {
            if (!player.isCreative()) {
                Block block = state.getBlock();
                if (block.getSpeedFactor() != 0.0F) {
                    ItemStack stack = player.getMainHandItem();
                    if (!ToolCheck.isCorrectToolForDrops(stack, state)) {
                        Level level = player.getLevel();
                        if (!HarvestCheck.canHarvestBlock(state, level, pos, player)) {
                            if (stack.isEmpty()) {
                                if (level.getDifficulty() != Difficulty.PEACEFUL) {
                                    if (Config.wrongToolDamageEnabled.get()) {
                                        LivingEntity.hurtFists(player);
                                    }
                                    if (Config.weaknessDebuffEnabled.get()) {
                                        LivingEntity.applyWeaknessEffect(player);
                                    }
                                    if (Config.miningFatigueDebuffEnabled.get()) {
                                        LivingEntity.applyMiningFatigueEffect(player);
                                    }
                                }
                            }
                            event.setNewSpeed(-1.0F);
                        }
                    }
                }
            }
        }
    }
}
