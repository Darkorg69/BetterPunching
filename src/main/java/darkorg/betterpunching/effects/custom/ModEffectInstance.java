package darkorg.betterpunching.effects.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class ModEffectInstance extends MobEffectInstance {

    private final MobEffect effect;
    private int duration;
    private final int amplifier;

    public ModEffectInstance(MobEffect effectIn, int durationIn, int amplifierIn) {
        super(effectIn, durationIn, amplifierIn);
        this.effect = effectIn;
        this.duration = durationIn;
        this.amplifier = amplifierIn;
    }

    @Override
    public boolean tick(@NotNull LivingEntity livingEntity, @NotNull Runnable runnable) {
        if (this.duration > 0) {
            this.applyEffect(livingEntity);
        }
        this.tickDownDuration();
        return this.duration > 0;
    }

    @Override
    public void applyEffect(@NotNull LivingEntity livingEntity) {
        this.effect.applyEffectTick(livingEntity, this.amplifier);
    }

    private void tickDownDuration() {
        --this.duration;
    }
}