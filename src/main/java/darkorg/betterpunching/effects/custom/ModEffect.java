package darkorg.betterpunching.effects.custom;

import darkorg.betterpunching.effects.ModEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class ModEffect extends MobEffect {

    public ModEffect(MobEffectCategory typeIn, int liquidColorIn) {super(typeIn, liquidColorIn);}

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {return duration > 0;}

    @Override
    public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
        if (this == ModEffects.BLEEDING.get()) {
            entity.hurt(new DamageSource("bleeding"), 0.25F*(amplifier+1));
        }
        if (this == ModEffects.SPLINTER.get()) {
            entity.hurt(new DamageSource ("splinter"), 0.05F*(amplifier+1));
        }
    }
}
