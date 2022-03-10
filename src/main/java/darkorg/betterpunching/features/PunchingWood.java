package darkorg.betterpunching.features;

import darkorg.betterpunching.setup.Config;
import darkorg.betterpunching.util.BlockUtil;
import darkorg.betterpunching.util.PlayerUtil;
import darkorg.betterpunching.util.ToolCheck;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PunchingWood {
    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event) {
        BlockState state = event.getState();
        PlayerEntity player = event.getPlayer();

        if (Config.punchingWoodEnabled.get()) {
            if (!player.isCreative()) {
                if (BlockUtil.isWood(state)) {
                    ItemStack stack = player.getHeldItemMainhand();
                    if (!ToolCheck.isCorrectToolForDrops(stack, state)) {
                        if (stack.isEmpty()) {
                            World level = player.getEntityWorld();
                            if (level.getDifficulty() != Difficulty.PEACEFUL) {
                                if (Config.wrongToolDamageEnabled.get()) {
                                    PlayerUtil.hurtFists(player);
                                }
                                if (Config.splinterDebuffEnabled.get()) {
                                    PlayerUtil.applySplinterEffect(player);
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