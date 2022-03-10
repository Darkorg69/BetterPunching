package darkorg.betterpunching;

import darkorg.betterpunching.setup.Config;
import darkorg.betterpunching.setup.Events;
import darkorg.betterpunching.setup.Registry;
import darkorg.betterpunching.tools.ModTools;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@SuppressWarnings({"NullableProblems", "unused"})
@Mod(BetterPunching.MOD_ID)
public class BetterPunching {
    public static final String MOD_ID = "betterpunching";
    IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

    public BetterPunching() {
        Config.init();
        Registry.init(bus);
        Events.init(bus);
        bus.addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }
    public static final ItemGroup TAB_BETTER_PUNCHING = new ItemGroup("better_punching") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModTools.FLINT_HATCHET.get());
        }
    };

    private void setup(final FMLCommonSetupEvent event) {
    }
}
