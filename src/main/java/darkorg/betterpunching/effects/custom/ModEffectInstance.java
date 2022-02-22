package darkorg.betterpunching.effects.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("UnusedReturnValue")
public class ModEffectInstance extends MobEffectInstance {

    private final MobEffect potion;
    private int duration;
    private int amplifier;

    public ModEffectInstance(MobEffect potionIn, int durationIn, int amplifierIn) {
        super(potionIn, durationIn, amplifierIn);
        this.potion = potionIn;
        this.duration = durationIn;
        this.amplifier = amplifierIn;
    }

    @Override
    public boolean tick(@NotNull LivingEntity entityIn, @NotNull Runnable runnable) {
        if (this.duration > 0) {
            if (this.potion.isDurationEffectTick(duration, amplifier)) {
            this.applyEffect(entityIn);
            }
        }
        this.deincrementDuration();
        return this.duration > 0;
    }
    @Override
    public void applyEffect(@NotNull LivingEntity entityIn) {
        if (this.duration > 0) {this.potion.applyEffectTick(entityIn, amplifier);}
    }

    private int deincrementDuration() {return --this.duration;}
}


