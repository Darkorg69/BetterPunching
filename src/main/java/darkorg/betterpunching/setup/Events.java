package darkorg.betterpunching.setup;

import darkorg.betterpunching.features.PunchingCactus;
import darkorg.betterpunching.features.PunchingGlass;
import darkorg.betterpunching.features.PunchingWood;
import darkorg.betterpunching.features.WrongTool;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;

@SuppressWarnings("unused")
public class Events {
    public static void init(IEventBus bus) {
        MinecraftForge.EVENT_BUS.register(new WrongTool());
        MinecraftForge.EVENT_BUS.register(new PunchingWood());
        MinecraftForge.EVENT_BUS.register(new PunchingGlass());
        MinecraftForge.EVENT_BUS.register(new PunchingCactus());
    }
}
