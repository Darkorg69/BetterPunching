package darkorg.betterpunching.effects.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;

public class ModEffectInstance extends EffectInstance {

    private final Effect effect;
    private int duration;
    private final int amplifier;

    public ModEffectInstance(Effect effectIn, int durationIn, int amplifierIn) {
        super(effectIn, durationIn, amplifierIn);
        this.effect = effectIn;
        this.duration = durationIn;
        this.amplifier = amplifierIn;
    }

    @Override
    public boolean tick(LivingEntity entity, Runnable runnable) {
        if (this.duration > 0) {
            this.performEffect(entity);
        }
        this.tickDownDuration();
        return this.duration > 0;
    }

    @Override
    public void performEffect(LivingEntity entity) {
        this.effect.performEffect(entity, this.amplifier);
    }

    private void tickDownDuration() {
        --this.duration;
    }
}