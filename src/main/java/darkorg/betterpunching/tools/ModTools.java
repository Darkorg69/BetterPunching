package darkorg.betterpunching.tools;

import darkorg.betterpunching.BetterPunching;
import darkorg.betterpunching.tiers.ModItemTier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.AxeItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unused")
public class ModTools {
    public static final DeferredRegister<Item> TOOLS = DeferredRegister.create(ForgeRegistries.ITEMS, BetterPunching.MOD_ID);

    public static final RegistryObject<Item> FLINT_DAGGER = TOOLS.register("flint_dagger", ()->
            new SwordItem(ModItemTier.FLINT, 1, -0.8F, (new Item.Properties()).tab(BetterPunching.TAB_BETTER_PUNCHING)));
    public static final RegistryObject<Item> FLINT_SPADE = TOOLS.register("flint_spade", ()->
            new ShovelItem(ModItemTier.FLINT, 1.5F, -3.0F, (new Item.Properties()).tab(BetterPunching.TAB_BETTER_PUNCHING)));
    public static final RegistryObject<Item> FLINT_PICK = TOOLS.register("flint_pick", ()->
            new PickaxeItem(ModItemTier.FLINT, 1, -2.8F, (new Item.Properties()).tab(BetterPunching.TAB_BETTER_PUNCHING)));
    public static final RegistryObject<Item> FLINT_HATCHET = TOOLS.register("flint_hatchet", ()->
            new AxeItem(ModItemTier.FLINT, 3.5F, -3.2F, (new Item.Properties()).tab(BetterPunching.TAB_BETTER_PUNCHING)));

    public static void init(IEventBus bus) {
        TOOLS.register(bus);
    }
}
