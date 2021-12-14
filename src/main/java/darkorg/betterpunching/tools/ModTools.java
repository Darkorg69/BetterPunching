package darkorg.betterpunching.tools;

import darkorg.betterpunching.BetterPunching;
import darkorg.betterpunching.setup.ModTab;
import darkorg.betterpunching.tiers.ModItemTier;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTools {
    public static final DeferredRegister<Item> TOOLS = DeferredRegister.create(ForgeRegistries.ITEMS, BetterPunching.MODID);

    public static final RegistryObject<Item> BONE_HATCHET =
            TOOLS.register("bone_hatchet", ()-> new AxeItem(ModItemTier.BONE, 3.5F, -3.2F, (new Item.Properties()).group(ModTab.BETTER_PUNCHING)));
    public static final RegistryObject<Item> FLINT_HATCHET =
            TOOLS.register("flint_hatchet", ()-> new AxeItem(ModItemTier.FLINT, 3.5F, -3.2F, (new Item.Properties()).group(ModTab.BETTER_PUNCHING)));

    public static void init(IEventBus bus) {TOOLS.register(bus);}
}
