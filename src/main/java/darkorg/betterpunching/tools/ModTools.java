package darkorg.betterpunching.tools;

import darkorg.betterpunching.BetterPunching;
import darkorg.betterpunching.items.tier.ModItemTier;
import darkorg.betterpunching.tab.ModTab;
import net.minecraft.item.*;
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
        public static final RegistryObject<SwordItem> FLINT_SWORD = TOOLS.register("flint_sword", () ->
                new SwordItem(ModItemTier.SHARP_FLINT, 4, -2.4F, new Item.Properties().tab(ModTab.TAB)));
        public static final RegistryObject<PickaxeItem> FLINT_PICKAXE = TOOLS.register("flint_pickaxe", () ->
                new PickaxeItem(ModItemTier.SHARP_FLINT, 2, -2.8F, new Item.Properties().tab(ModTab.TAB)));
        public static final RegistryObject<ShovelItem> FLINT_SHOVEL = TOOLS.register("flint_shovel", () ->
                new ShovelItem(ModItemTier.SHARP_FLINT, 2, -3.0F, new Item.Properties().tab(ModTab.TAB)));
        public static final RegistryObject<AxeItem> FLINT_AXE = TOOLS.register("flint_axe", () ->
                new AxeItem(ModItemTier.SHARP_FLINT, 7, -3.2F, new Item.Properties().tab(ModTab.TAB)));
        public static final RegistryObject<HoeItem> FLINT_HOE = TOOLS.register("flint_hoe", () ->
                new HoeItem(ModItemTier.SHARP_FLINT, 0, -2.5F, new Item.Properties().tab(ModTab.TAB)));
}
