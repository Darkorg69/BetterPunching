package darkorg.betterpunching.features;

import darkorg.betterpunching.setup.Config;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@SuppressWarnings("unused")
public class DisableTools {
    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event) {
        PlayerEntity player = event.getPlayer();
        ItemStack stack = player.getHeldItemMainhand();
        Item item = stack.getItem();
        if (item instanceof TieredItem) {
            IItemTier tier = ((TieredItem) stack.getItem()).getTier();
            if (tier == ItemTier.WOOD) {
                if (Config.woodenToolsDisabled.get()) {
                    event.setNewSpeed(0.0F);
                }
            }
            if (tier == ItemTier.STONE) {
                if (Config.stoneToolsDisabled.get()) {
                    event.setNewSpeed(0.0F);
                }
            }
            if (tier == ItemTier.IRON) {
                if (Config.ironToolsDisabled.get()) {
                    event.setNewSpeed(0.0F);
                }
            }
            if (tier == ItemTier.GOLD) {
                if (Config.goldenToolsDisabled.get()) {
                    event.setNewSpeed(0.0F);
                }
            }
            if (tier == ItemTier.DIAMOND) {
                if (Config.diamondToolsDisabled.get()) {
                    event.setNewSpeed(0.0F);
                }
            }
            if (tier == ItemTier.NETHERITE) {
                if (Config.netheriteToolsDisabled.get()) {
                    event.setNewSpeed(0.0F);
                }
            }
        }
    }

    @SubscribeEvent
    public void rightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        ItemStack stack = event.getItemStack();
        Item item = stack.getItem();
        if (item instanceof TieredItem) {
            IItemTier tier = ((TieredItem) stack.getItem()).getTier();
            if (tier == ItemTier.WOOD) {
                if (Config.woodenToolsDisabled.get()) {
                    event.setCanceled(true);
                }
            }
            if (tier == ItemTier.STONE) {
                if (Config.stoneToolsDisabled.get()) {
                    event.setCanceled(true);
                }
            }
            if (tier == ItemTier.IRON) {
                if (Config.ironToolsDisabled.get()) {
                    event.setCanceled(true);
                }
            }
            if (tier == ItemTier.GOLD) {
                if (Config.goldenToolsDisabled.get()) {
                    event.setCanceled(true);
                }
            }
            if (tier == ItemTier.DIAMOND) {
                if (Config.diamondToolsDisabled.get()) {
                    event.setCanceled(true);
                }
            }
            if (tier == ItemTier.NETHERITE) {
                if (Config.netheriteToolsDisabled.get()) {
                    event.setCanceled(true);
                }
            }
        }
    }

    @SubscribeEvent
    public void attackEntityEvent(AttackEntityEvent event) {
        ItemStack stack = event.getEntityLiving().getHeldItemMainhand();
        Item item = stack.getItem();
        if (item instanceof TieredItem) {
            IItemTier tier = ((TieredItem) stack.getItem()).getTier();
            if (tier == ItemTier.WOOD) {
                if (Config.woodenToolsDisabled.get()) {
                    event.setCanceled(true);
                }
            }
            if (tier == ItemTier.STONE) {
                if (Config.stoneToolsDisabled.get()) {
                    event.setCanceled(true);
                }
            }
            if (tier == ItemTier.IRON) {
                if (Config.ironToolsDisabled.get()) {
                    event.setCanceled(true);
                }
            }
            if (tier == ItemTier.GOLD) {
                if (Config.goldenToolsDisabled.get()) {
                    event.setCanceled(true);
                }
            }
            if (tier == ItemTier.DIAMOND) {
                if (Config.diamondToolsDisabled.get()) {
                    event.setCanceled(true);
                }
            }
            if (tier == ItemTier.NETHERITE) {
                if (Config.netheriteToolsDisabled.get()) {
                    event.setCanceled(true);
                }
            }
        }
    }
}