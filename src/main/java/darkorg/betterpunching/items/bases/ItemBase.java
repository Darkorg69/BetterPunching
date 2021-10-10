package darkorg.betterpunching.items.bases;

import darkorg.betterpunching.client.tabs.ModTab;
import net.minecraft.item.Item;

public class ItemBase extends Item {
    public ItemBase() {
        super(new Item.Properties().tab(ModTab.TAB));
    }
}
