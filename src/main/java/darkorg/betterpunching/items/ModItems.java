package darkorg.betterpunching.items;

import darkorg.betterpunching.BetterPunching;
import darkorg.betterpunching.items.bases.ItemBase;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BetterPunching.MODID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Items
    public static final RegistryObject<Item> ROPE = ITEMS.register("rope", ItemBase::new);
    public static final RegistryObject<Item> ROPE_BINDING = ITEMS.register("rope_binding", ItemBase::new);
    public static final RegistryObject<Item> SHARP_FLINT = ITEMS.register("sharp_flint", ItemBase::new);

    //Flint tool materials.
    public static final RegistryObject<Item> FLINT_SWORD_BLADE = ITEMS.register("flint_sword_blade", ItemBase::new);
    public static final RegistryObject<Item> FLINT_PICKAXE_HEAD = ITEMS.register("flint_pickaxe_head", ItemBase::new);
    public static final RegistryObject<Item> FLINT_SHOVEL_HEAD = ITEMS.register("flint_shovel_head", ItemBase::new);
    public static final RegistryObject<Item> FLINT_AXE_HEAD = ITEMS.register("flint_axe_head", ItemBase::new);
    public static final RegistryObject<Item> FLINT_HOE_HEAD = ITEMS.register("flint_hoe_head", ItemBase::new);
}
