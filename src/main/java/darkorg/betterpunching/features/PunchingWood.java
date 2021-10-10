package darkorg.betterpunching.features;

import darkorg.betterpunching.utils.ToolCheck;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PunchingWood {

    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event) {

        PlayerEntity player = event.getPlayer();
        ItemStack stack = player.getMainHandItem();
        BlockState state = event.getState();

        DamageSource punchingwood = new DamageSource("punchingwood");

        if ((state.is(BlockTags.LOGS)) ||
            (state.is(BlockTags.PLANKS)) ||
            (state.is(BlockTags.WOODEN_SLABS)) ||
            (state.is(BlockTags.WOODEN_STAIRS))) {
            if (ToolCheck.isInvalidTool(state, stack)) {
                if (stack.isEmpty()) {
                    player.hurt(punchingwood, 2.0F);
                }
                event.setNewSpeed(0.0F);
            }
        }
    }
}
