package darkorg.betterpunching.effects.custom;

import darkorg.betterpunching.effects.ModEffects;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.LivingEntity;

@SuppressWarnings("all")
public class ModEffect extends Effect {

    public ModEffect(EffectType typeIn, int liquidColorIn) {super(typeIn, liquidColorIn);}

    @Override
    public boolean isReady(int duration, int amplifier) {return duration > 0;}

    @Override
    public void performEffect(LivingEntity entity, int amplifier) {
        if (this == ModEffects.BLEEDING.get()) {
            entity.attackEntityFrom(new DamageSource ("bleeding"), 0.25F*(amplifier+1));
        }
        if (this == ModEffects.SPLINTER.get()) {
            entity.attackEntityFrom(new DamageSource ("splinter"), 0.05F*(amplifier+1));
        }
    }
}
