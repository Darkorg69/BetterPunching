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

public class PunchingGlass {
    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event) {
        BlockState state = event.getState();
        PlayerEntity player = event.getPlayer();

        if (Config.punchingGlassEnabled.get()) {
            if (BlockUtil.isGlass(state)) {
                ItemStack stack = player.getHeldItemMainhand();
                if (stack.isEmpty()) {
                    World world = player.getEntityWorld();
                    if (world.getDifficulty() != Difficulty.PEACEFUL) {
                        if (Config.wrongToolDamageEnabled.get()) {
                            PlayerUtil.hurtFists(player);
                        }
                        if (Config.bleedingEffectEnabled.get()) {
                            PlayerUtil.applyBleedingEffect(player);
                        }
                        if (Config.weaknessDebuffEnabled.get()) {
                            PlayerUtil.applyWeaknessEffect(player);
                        }
                        if (Config.miningFatigueDebuffEnabled.get()) {
                            PlayerUtil.applyMiningFatigueEffect(player);
                        }
                    }
                }
                event.setNewSpeed(Float.MAX_VALUE);
            }
        }
    }
}