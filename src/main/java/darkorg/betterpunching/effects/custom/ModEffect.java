package darkorg.betterpunching.effects.custom;

import darkorg.betterpunching.effects.ModEffects;
import darkorg.betterpunching.setup.Config;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;

public class ModEffect extends Effect {
    public ModEffect(EffectType typeIn, int liquidColorIn) {
        super(typeIn, liquidColorIn);
    }

    @Override
    public void performEffect(LivingEntity entity, int amplifier) {
        if (this == ModEffects.SPLINTER.get()) {
            DamageSource splinter = new DamageSource("splinter");
            if (Config.splinterEffectBypassArmor.get()) {
                entity.attackEntityFrom(splinter.setDamageBypassesArmor(), (Config.splinterDamagePerSecond.get().floatValue() / 2) * (amplifier + 1));
            } else {
                entity.attackEntityFrom(splinter, (Config.splinterDamagePerSecond.get().floatValue() / 2) * (amplifier + 1));
            }
        }
        if (this == ModEffects.BLEEDING.get()) {
            DamageSource bleeding = new DamageSource("bleeding");
            if (Config.splinterEffectBypassArmor.get()) {
                entity.attackEntityFrom(bleeding.setDamageBypassesArmor(), (Config.bleedingDamagePerSecond.get().floatValue() / 2) * (amplifier + 1));
            } else {
                entity.attackEntityFrom(bleeding, (Config.bleedingDamagePerSecond.get().floatValue() / 2) * (amplifier + 1));
            }
        }
    }
}
