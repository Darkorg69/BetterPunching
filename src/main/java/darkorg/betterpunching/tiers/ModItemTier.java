package darkorg.betterpunching.tiers;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModItemTier {
    public static final ForgeTier FLINT = new ForgeTier(1, 65, 4.0F, 1.0F, 5, BlockTags.NEEDS_STONE_TOOL, ()-> Ingredient.of(Items.FLINT));
}
