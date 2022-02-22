package darkorg.betterpunching.setup;

import darkorg.betterpunching.features.*;
import net.minecraftforge.common.MinecraftForge;

public class Events {
    public static void init() {
        MinecraftForge.EVENT_BUS.register(new PunchingCactus());
        MinecraftForge.EVENT_BUS.register(new PunchingGlass());
        MinecraftForge.EVENT_BUS.register(new PunchingWood());
        MinecraftForge.EVENT_BUS.register(new WrongTool());
    }
}
