package darkorg.betterpunching.data.client;

import darkorg.betterpunching.BetterPunching;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

@SuppressWarnings("UnusedReturnValue")
public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, BetterPunching.MOD_ID, existingFileHelper);
    }

    ModelFile itemHandheld = getExistingFile(mcLoc("item/handheld"));

    @Override
    protected void registerModels() {
        modelBuilder("flint_dagger", itemHandheld);
        modelBuilder("flint_pick", itemHandheld);
        modelBuilder("flint_spade", itemHandheld);
        modelBuilder("flint_hatchet", itemHandheld);
    }

    private ItemModelBuilder modelBuilder(String itemName, ModelFile modelFile) {
        return getBuilder(itemName).parent(modelFile).texture("layer0", "item/" + itemName);
    }
}
