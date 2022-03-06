package darkorg.betterpunching.features;

import darkorg.betterpunching.setup.Config;
import darkorg.betterpunching.util.BlockUtil;
import darkorg.betterpunching.util.LivingEntity;
import darkorg.betterpunching.util.ToolCheck;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PunchingWood {
    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event) {
        BlockState state = event.getState();
        Player player = event.getPlayer();

        if (Config.punchingWoodEnabled.get()) {
            if (!player.isCreative()) {
                if (BlockUtil.isWood(state)) {
                    ItemStack stack = player.getMainHandItem();
                    if (!ToolCheck.isCorrectToolForDrops(stack, state)) {
                        if (stack.isEmpty()) {
                            Level level = player.getLevel();
                            if (level.getDifficulty() != Difficulty.PEACEFUL) {
                                if (Config.wrongToolDamageEnabled.get()) {
                                    LivingEntity.hurtFists(player);
                                }
                                if (Config.splinterDebuffEnabled.get()) {
                                    LivingEntity.applySplinterEffect(player);
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