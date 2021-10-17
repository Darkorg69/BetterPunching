package darkorg.betterpunching.features;

import darkorg.betterpunching.setup.Config;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Random;

public class EasySticks {

    private static final Random RANDOM = new Random();

    @SubscribeEvent
    public void breakEvent(BlockEvent.BreakEvent event) {

        BlockState state = event.getState();
        BlockPos pos = event.getPos();
        World world = event.getPlayer().getCommandSenderWorld();
        PlayerEntity player = event.getPlayer();

        if(!Config.easySticksEnabled.get()) {return;}

        if(player.isCreative()) {return;}

        if (state.is(BlockTags.LEAVES)) {
            if (RANDOM.nextFloat() <= Config.easySticksChance.get()) {
                InventoryHelper.dropItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.STICK, Config.easySticksDropCount.get()));
            }
        }
    }
}
