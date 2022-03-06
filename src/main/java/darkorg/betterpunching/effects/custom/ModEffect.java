package darkorg.betterpunching.effects.custom;

import darkorg.betterpunching.effects.ModEffects;
import darkorg.betterpunching.setup.Config;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class ModEffect extends MobEffect {
    public ModEffect(MobEffectCategory typeIn, int liquidColorIn) {
        super(typeIn, liquidColorIn);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity livingEntity, int amplifier) {
        if (this == ModEffects.SPLINTER.get()) {
            DamageSource splinter = new DamageSource("splinter");
            if (Config.splinterEffectBypassArmor.get()) {
                livingEntity.hurt(splinter.bypassArmor(), (Config.splinterDamagePerSecond.get().floatValue() / 2) * (amplifier + 1));
            } else {
                livingEntity.hurt(splinter, (Config.splinterDamagePerSecond.get().floatValue() / 2) * (amplifier + 1));
            }
        }
        if (this == ModEffects.BLEEDING.get()) {
            DamageSource bleeding = new DamageSource("bleeding");
            if (Config.bleedingEffectBypassArmor.get()) {
                livingEntity.hurt(bleeding.bypassArmor(), (Config.bleedingDamagePerSecond.get().floatValue() / 2) * (amplifier + 1));
            } else {
                livingEntity.hurt(bleeding, (Config.bleedingDamagePerSecond.get().floatValue() / 2) * (amplifier + 1));
            }
        }
    }
}
