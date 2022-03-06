package darkorg.betterpunching.data;

import darkorg.betterpunching.tools.ModTools;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        ShapedRecipeBuilder.shaped(ModTools.FLINT_DAGGER.get()).define('#', Items.FLINT).define('/', Items.STICK).pattern(" #").pattern("/ ").unlockedBy("has_material", has(Items.FLINT)).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModTools.FLINT_PICK.get()).define('#', Items.FLINT).define('/', Items.STICK).pattern("##").pattern("/ ").unlockedBy("has_material", has(Items.FLINT)).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModTools.FLINT_SPADE.get()).define('#', Items.FLINT).define('/', Items.STICK).pattern("#").pattern("/").unlockedBy("has_material", has(Items.FLINT)).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModTools.FLINT_HATCHET.get()).define('#', Items.FLINT).define('/', Items.STICK).pattern("##").pattern("/#").unlockedBy("has_material", has(Items.FLINT)).save(pFinishedRecipeConsumer);
    }
}

