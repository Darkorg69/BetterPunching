package darkorg.betterpunching.tab;

import darkorg.betterpunching.tools.ModTools;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModTab {
    public static final ItemGroup TAB = new ItemGroup("betterpunchingTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModTools.FLINT_AXE.get());
        }
    };
}
