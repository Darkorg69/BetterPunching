package darkorg.betterpunching.setup;

import darkorg.betterpunching.features.*;
import net.minecraftforge.common.MinecraftForge;

public class Events {
    public static void init() {
        MinecraftForge.EVENT_BUS.register(new DisableStoneTools());
        MinecraftForge.EVENT_BUS.register(new DisableWoodTools());
        MinecraftForge.EVENT_BUS.register(new EasySticks());
        MinecraftForge.EVENT_BUS.register(new PunchingGlass());
        MinecraftForge.EVENT_BUS.register(new PunchingWood());
        MinecraftForge.EVENT_BUS.register(new SharpingFlint());
        MinecraftForge.EVENT_BUS.register(new WrongTool());
    }
}
