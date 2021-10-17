package darkorg.betterpunching.features;

import darkorg.betterpunching.setup.Config;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.TieredItem;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DisableStoneTools {
    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event) {

        PlayerEntity player = event.getPlayer();
        ItemStack stack = player.getMainHandItem();

        if (!Config.disableStoneTools.get()) {return;}

        if (stack.getItem() instanceof TieredItem) {
            if (((TieredItem) stack.getItem()).getTier() == ItemTier.STONE) {
                event.setNewSpeed(0.0F);
            }
        }
    }
}
