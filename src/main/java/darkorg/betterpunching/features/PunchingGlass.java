package darkorg.betterpunching.features;

import darkorg.betterpunching.setup.Config;
import darkorg.betterpunching.util.ToolCheck;
import net.minecraft.block.AbstractGlassBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public class PunchingGlass {

    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event) {

        PlayerEntity player = event.getPlayer();
        ItemStack stack = player.getMainHandItem();
        BlockState state = event.getState();
        Block block = state.getBlock();

        DamageSource cutbyglass = new DamageSource("cutbyglass");

        if(!Config.punchingGlassEnabled.get()) {return;}

        if ((block instanceof AbstractGlassBlock) || (block instanceof PaneBlock)) {

            if (ToolCheck.isInvalidTool(state, stack)) {
                if (stack.isEmpty()) {
                    player.hurt(cutbyglass, Config.punchingGlassDamage.get().floatValue());
                }
            }
            event.setNewSpeed(Float.MAX_VALUE);
        }
    }
}