package darkorg.betterpunching;

import darkorg.betterpunching.setup.Config;
import darkorg.betterpunching.setup.Events;
import darkorg.betterpunching.setup.Registry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("betterpunching")
public class BetterPunching {

    public static final String MODID = "betterpunching";
    IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

    public BetterPunching() {
        Registry.init(bus);
        Config.init();
        Events.init();
        bus.addListener(this::setup);
        bus.addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void setup(final FMLCommonSetupEvent event) {}
    private void doClientStuff(final FMLClientSetupEvent event) {}
}
