package darkorg.betterpunching.features;

import darkorg.betterpunching.setup.Config;
import darkorg.betterpunching.items.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Random;

public class SharpingFlint {

    private static final Random RANDOM = new Random();

    @SubscribeEvent
    public void rightClickBlock(PlayerInteractEvent.RightClickBlock event) {

        ItemStack stack = event.getItemStack();
        World world = event.getWorld();
        PlayerEntity player = event.getPlayer();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);

        if(!Config.sharpingFlintEnabled.get()) {return;}

        if (stack.getItem() == Items.FLINT && state.getMaterial() == Material.STONE) {
            if (RANDOM.nextFloat() <= Config.sharpingFlintChance.get().floatValue()) {
                player.inventory.add(new ItemStack(ModItems.SHARP_FLINT.get()));
            }
            stack.shrink(1);
            event.setCancellationResult(ActionResultType.SUCCESS);
            event.setCanceled(true);
        }
    }
}
