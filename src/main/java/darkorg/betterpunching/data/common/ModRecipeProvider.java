package darkorg.betterpunching.data.common;

import darkorg.betterpunching.tools.ModTools;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder.shapedRecipe(ModTools.FLINT_DAGGER.get()).key('#', Items.FLINT).key('/', Items.STICK)
                .patternLine("# ")
                .patternLine(" /")
                .addCriterion("has_item", hasItem(Items.FLINT))
                .build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ModTools.FLINT_PICK.get()).key('#', Items.FLINT).key('/', Items.STICK)
                .patternLine("##")
                .patternLine(" /")
                .addCriterion("has_item", hasItem(Items.FLINT))
                .build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ModTools.FLINT_SPADE.get()).key('#', Items.FLINT).key('/', Items.STICK)
                .patternLine("#")
                .patternLine("/")
                .addCriterion("has_item", hasItem(Items.FLINT))
                .build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ModTools.FLINT_HATCHET.get()).key('#', Items.FLINT).key('/', Items.STICK)
                .patternLine("##")
                .patternLine("#/")
                .addCriterion("has_item", hasItem(Items.FLINT))
                .build(consumer);
    }
}
