package darkorg.betterpunching;

import darkorg.betterpunching.setup.Config;
import darkorg.betterpunching.setup.Events;
import darkorg.betterpunching.setup.Registry;
import darkorg.betterpunching.tools.ModTools;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;

@Mod("betterpunching")
public class BetterPunching {
    public static final String MOD_ID = "betterpunching";

    public BetterPunching() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        Config.init();
        Registry.init(bus);
        Events.init();
        bus.addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static final CreativeModeTab TAB_BETTER_PUNCHING = new CreativeModeTab("better_punching") {
        @Override
        public @NotNull ItemStack makeIcon() {return new ItemStack(ModTools.FLINT_HATCHET.get());}
    };

    private void setup(final FMLCommonSetupEvent event) {}
}
