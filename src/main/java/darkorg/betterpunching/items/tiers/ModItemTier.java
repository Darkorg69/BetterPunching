package darkorg.betterpunching.items.tiers;

import darkorg.betterpunching.items.ModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import java.util.function.Supplier;

public enum ModItemTier implements IItemTier {

    SHARP_FLINT(0, 64, 3.0F, 1.0F, 10,
            () -> {return Ingredient.of(ModItems.SHARP_FLINT.get());});

    private final int setLevel;
    private final int setUses;
    private final float setSpeed;
    private final float setAttackDamageBonus;
    private final int setEnchantmentValue;
    private final Supplier<Ingredient> setRepairIngredient;

    ModItemTier(int setLevel, int setUses, float setSpeed, float setAttackDamageBonus, int setEnchantmentValue, Supplier<Ingredient> setRepairIngredient) {
        this.setLevel = setLevel;
        this.setUses = setUses;
        this.setSpeed = setSpeed;
        this.setAttackDamageBonus = setAttackDamageBonus;
        this.setEnchantmentValue = setEnchantmentValue;
        this.setRepairIngredient = setRepairIngredient;
    }

    @Override
    public int getUses() {
        return setUses;
    }
    @Override
    public float getSpeed() {
        return setSpeed;
    }
    @Override
    public float getAttackDamageBonus() {
        return setAttackDamageBonus;
    }
    @Override
    public int getLevel() {
        return setLevel;
    }
    @Override
    public int getEnchantmentValue() {
        return setEnchantmentValue;
    }
    @Override
    public Ingredient getRepairIngredient() {
        return setRepairIngredient.get();
    }
}
