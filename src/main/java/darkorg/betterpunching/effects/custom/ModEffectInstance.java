package darkorg.betterpunching.effects.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;

@SuppressWarnings("all")
public class ModEffectInstance extends EffectInstance {

    private final Effect potion;
    private int duration;
    private int amplifier;

    public ModEffectInstance(Effect potionIn, int durationIn, int amplifierIn) {
        super(potionIn, durationIn, amplifierIn);
        this.potion = potionIn;
        this.duration = durationIn;
        this.amplifier = amplifierIn;
    }

    @Override
    public boolean tick(LivingEntity entityIn, Runnable runnable) {
        if (this.duration > 0) {
            if (this.potion.isReady(duration, amplifier)) {
                this.performEffect(entityIn);
            }
        }
        this.deincrementDuration();
        return this.duration > 0;
    }

    @Override
    public void performEffect(LivingEntity entityIn) {
        if (this.duration > 0) {
            this.potion.performEffect(entityIn, amplifier);
        }
    }

    private int deincrementDuration() {
        return --this.duration;
    }
}


