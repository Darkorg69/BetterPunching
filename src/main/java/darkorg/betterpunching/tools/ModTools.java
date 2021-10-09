package darkorg.betterpunching.tools;

import darkorg.betterpunching.BetterPunching;
import darkorg.betterpunching.items.tiers.ModItemTier;
import darkorg.betterpunching.client.tabs.ModTab;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTools {
        public static final DeferredRegister<Item> TOOLS = DeferredRegister.create(ForgeRegistries.ITEMS, BetterPunching.MODID);

        public static void init() {
            TOOLS.register(FMLJavaModLoadingContext.get().getModEventBus());
        }

        //Tools
        public static final RegistryObject<AxeItem> SHARP_FLINT_AXE = TOOLS.register("flint_axe", () ->
                new AxeItem(ModItemTier.SHARP_FLINT, 6, -3.2F, new Item.Properties().tab(ModTab.TAB)));
        public static final RegistryObject<PickaxeItem> SHARP_FLINT_PICKAXE = TOOLS.register("flint_pickaxe", () ->
                new PickaxeItem(ModItemTier.SHARP_FLINT, 1, -2.8F, new Item.Properties().tab(ModTab.TAB)));
}
