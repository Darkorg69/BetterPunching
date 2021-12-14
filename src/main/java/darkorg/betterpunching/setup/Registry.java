package darkorg.betterpunching.setup;

import darkorg.betterpunching.effects.ModEffects;
import darkorg.betterpunching.tools.ModTools;
import net.minecraftforge.eventbus.api.IEventBus;

public class Registry {
    public static void init(IEventBus bus) {
        ModTools.init(bus);
        ModEffects.init(bus);
    }
}
