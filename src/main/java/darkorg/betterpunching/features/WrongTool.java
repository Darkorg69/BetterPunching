package darkorg.betterpunching.features;

import darkorg.betterpunching.setup.Config;
import darkorg.betterpunching.util.HarvestCheck;
import darkorg.betterpunching.util.PlayerUtil;
import darkorg.betterpunching.util.ToolCheck;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class WrongTool {
    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event) {
        BlockPos pos = event.getPos();
        BlockState state = event.getState();
        PlayerEntity player = event.getPlayer();

        if (Config.wrongToolEnabled.get()) {
            if (!player.isCreative()) {
                Block block = state.getBlock();
                if (block.getSpeedFactor() != 0.0F) {
                    ItemStack stack = player.getHeldItemMainhand();
                    if (!ToolCheck.isCorrectToolForDrops(stack, state)) {
                        World world = player.getEntityWorld();
                        if (!HarvestCheck.canHarvestBlock(state, world, pos, player)) {
                            if (stack.isEmpty()) {
                                if (world.getDifficulty() != Difficulty.PEACEFUL) {
                                    if (Config.wrongToolDamageEnabled.get()) {
                                        PlayerUtil.hurtFists(player);
                                    }
                                    if (Config.weaknessDebuffEnabled.get()) {
                                        PlayerUtil.applyWeaknessEffect(player);
                                    }
                                    if (Config.miningFatigueDebuffEnabled.get()) {
                                        PlayerUtil.applyMiningFatigueEffect(player);
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
