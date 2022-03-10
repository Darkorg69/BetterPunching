package darkorg.betterpunching.util;

import darkorg.betterpunching.effects.ModEffects;
import darkorg.betterpunching.effects.custom.ModEffectInstance;
import darkorg.betterpunching.setup.Config;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;

public class PlayerUtil {
    public static void applySplinterEffect(PlayerEntity player) {
        player.addPotionEffect(new ModEffectInstance(ModEffects.SPLINTER.get(), (Config.splinterDuration.get() * 20), (Config.splinterAmplifier.get()-1)));
    }

    public static void applyBleedingEffect(PlayerEntity player) {
        player.addPotionEffect(new ModEffectInstance(ModEffects.BLEEDING.get(), Config.bleedingDuration.get() * 20, Config.bleedingAmplifier.get()-1));
    }

    public static void applyWeaknessEffect(PlayerEntity player) {
        player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, Config.weaknessDuration.get() * 20, Config.weaknessAmplifier.get()-1));
    }

    public static void applyMiningFatigueEffect(PlayerEntity player) {
        player.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, Config.miningFatigueDuration.get() * 20, Config.miningFatigueAmplifier.get()-1));
    }

    public static void hurtFists(PlayerEntity player) {
        DamageSource invalidpunching = new DamageSource("invalidpunching");
        player.attackEntityFrom(invalidpunching.setDamageBypassesArmor(), Config.wrongToolDamage.get().floatValue());
    }
}
