package darkorg.betterpunching.tiers;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public enum ModItemTier implements IItemTier {

    BONE(0, 59, 2.0F, 0.0F, 15, () -> {return Ingredient.fromItems(Items.BONE);}),
    FLINT(1, 131, 4.0F, 1.0F, 5, () -> {return Ingredient.fromItems(Items.FLINT);});

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;

    ModItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = new LazyValue<>(repairMaterialIn);
    }

    @Override
    public int getMaxUses() {return this.maxUses;}
    @Override
    public float getEfficiency() {return this.efficiency;}
    @Override
    public float getAttackDamage() {return this.attackDamage;}
    @Override
    public int getHarvestLevel() {return this.harvestLevel;}
    @Override
    public int getEnchantability() {return this.enchantability;}
    @Override
    public Ingredient getRepairMaterial() {return this.repairMaterial.getValue();}
}
