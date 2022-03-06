package darkorg.betterpunching.util;

import darkorg.betterpunching.effects.ModEffects;
import darkorg.betterpunching.effects.custom.ModEffectInstance;
import darkorg.betterpunching.setup.Config;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;

public class LivingEntity {
    public static void applySplinterEffect(Player player) {
        player.addEffect(new ModEffectInstance(ModEffects.SPLINTER.get(), (Config.splinterDuration.get() * 20), (Config.splinterAmplifier.get()-1)));
    }

    public static void applyBleedingEffect(Player player) {
        player.addEffect(new ModEffectInstance(ModEffects.BLEEDING.get(), Config.bleedingDuration.get() * 20, Config.bleedingAmplifier.get()-1));
    }

    public static void applyWeaknessEffect(Player player) {
        player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, Config.weaknessDuration.get() * 20, Config.weaknessAmplifier.get()-1));
    }

    public static void applyMiningFatigueEffect(Player player) {
        player.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, Config.miningFatigueDuration.get() * 20, Config.miningFatigueAmplifier.get()-1));
    }

    public static void hurtFists(Player player) {
        DamageSource invalidpunching = new DamageSource("invalidpunching");
        player.hurt(invalidpunching.bypassArmor(), Config.wrongToolDamage.get().floatValue());
    }
}
