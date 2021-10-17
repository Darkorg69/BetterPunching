package darkorg.betterpunching.items.base;

import darkorg.betterpunching.tab.ModTab;
import net.minecraft.item.Item;

public class ItemBase extends Item {
    public ItemBase() {
        super(new Item.Properties().tab(ModTab.TAB));
    }
}
