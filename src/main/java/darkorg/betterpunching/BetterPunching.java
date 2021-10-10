package darkorg.betterpunching;

import darkorg.betterpunching.features.*;
import darkorg.betterpunching.items.ModItems;
import darkorg.betterpunching.tools.ModTools;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("betterpunching")
public class BetterPunching {

    public static final String MODID = "betterpunching";

    private static final Logger LOGGER = LogManager.getLogger();

    public BetterPunching() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(this);

        //Registry Handler
        ModItems.init();
        ModTools.init();

        //Event handler
        MinecraftForge.EVENT_BUS.register(new PunchingGlass());
        MinecraftForge.EVENT_BUS.register(new PunchingWood());
        MinecraftForge.EVENT_BUS.register(new SharpFlint());
        MinecraftForge.EVENT_BUS.register(new StickFromLeaves());
        MinecraftForge.EVENT_BUS.register(new WrongTool());
    }
    private void setup(final FMLCommonSetupEvent event) {}

    private void doClientStuff(final FMLClientSetupEvent event) {}
}
