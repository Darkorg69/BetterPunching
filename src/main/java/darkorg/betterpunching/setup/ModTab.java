package darkorg.betterpunching.setup;

import darkorg.betterpunching.tools.ModTools;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModTab extends ItemGroup {

    public static final ItemGroup BETTER_PUNCHING = new ModTab("better_punching") ;

    public ModTab(String label) {
        super(label);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModTools.FLINT_HATCHET.get());
    }
}
