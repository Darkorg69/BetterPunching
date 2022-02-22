package darkorg.betterpunching.setup;

import darkorg.betterpunching.tools.ModTools;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ModTab extends CreativeModeTab {

    public static final CreativeModeTab BETTER_PUNCHING = new ModTab("better_punching") ;

    public ModTab(String label) {
        super(label);
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(ModTools.FLINT_HATCHET.get());
    }
}
