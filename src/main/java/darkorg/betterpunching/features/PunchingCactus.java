package darkorg.betterpunching.features;

import darkorg.betterpunching.setup.Config;
import darkorg.betterpunching.util.BlockUtil;
import darkorg.betterpunching.util.PlayerUtil;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PunchingCactus {
    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event) {
        PlayerEntity player = event.getPlayer();
        BlockState state = event.getState();

        if (!Config.punchingCactusEnabled.get()) {
            if (BlockUtil.isCactus(state)) {
                ItemStack stack = player.getHeldItemMainhand();
                if (stack.isEmpty()) {
                    if (!player.isCrouching()) {
                        World world = player.getEntityWorld();
                        if (world.getDifficulty() != Difficulty.PEACEFUL) {
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
                        event.setNewSpeed(-1.0F);
                    }
                }
            }
        }
    }
}
