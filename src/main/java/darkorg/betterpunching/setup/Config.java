package darkorg.betterpunching.setup;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class Config {
    public static ForgeConfigSpec SERVER_CONFIG;
    public static ForgeConfigSpec.BooleanValue wrongToolEnabled;
    public static ForgeConfigSpec.BooleanValue punchingWoodEnabled;
    public static ForgeConfigSpec.BooleanValue punchingGlassEnabled;
    public static ForgeConfigSpec.BooleanValue punchingCactusEnabled;
    public static ForgeConfigSpec.BooleanValue wrongToolDamageEnabled;
    public static ForgeConfigSpec.DoubleValue wrongToolDamage;
    public static ForgeConfigSpec.BooleanValue splinterDebuffEnabled;
    public static ForgeConfigSpec.BooleanValue splinterEffectBypassArmor;
    public static ForgeConfigSpec.DoubleValue splinterDamagePerSecond;
    public static ForgeConfigSpec.IntValue splinterDuration;
    public static ForgeConfigSpec.IntValue splinterAmplifier;
    public static ForgeConfigSpec.BooleanValue bleedingEffectEnabled;
    public static ForgeConfigSpec.BooleanValue bleedingEffectBypassArmor;
    public static ForgeConfigSpec.DoubleValue bleedingDamagePerSecond;
    public static ForgeConfigSpec.IntValue bleedingDuration;
    public static ForgeConfigSpec.IntValue bleedingAmplifier;
    public static ForgeConfigSpec.IntValue weaknessDuration;
    public static ForgeConfigSpec.IntValue weaknessAmplifier;
    public static ForgeConfigSpec.BooleanValue weaknessDebuffEnabled;
    public static ForgeConfigSpec.BooleanValue miningFatigueDebuffEnabled;
    public static ForgeConfigSpec.IntValue miningFatigueDuration;
    public static ForgeConfigSpec.IntValue miningFatigueAmplifier;
    public static ForgeConfigSpec.BooleanValue debugEnabled;


    private static void initServerConfig() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.push("Welcome to the Better Punching mod server configuration file");
        wrongToolEnabled = builder.comment("Set to false to completely disable the WrongTool feature.").define("wrongtool_enabled", true);
        punchingWoodEnabled = builder.comment("Set to false to completely disable the PunchingWood feature.").define("punchingwood_enabled", true);
        punchingGlassEnabled = builder.comment("Set to false to completely disable the PunchingGlass feature.").define("punchingglass_enabled", true);
        punchingCactusEnabled = builder.comment("Set to false to completely disable the PunchingCactus feature.").define("punchingcactus_enabled", true);
        wrongToolDamageEnabled = builder.comment("If set to false, you won't get hurt when punching the wrong block.").define("wrongtool_damage_enabled", true);
        wrongToolDamage = builder.comment("Set the damage dealt to the player when punching the wrong block.").defineInRange("wrongtool_damage", 4.0, 0.0, Float.MAX_VALUE);
        splinterDebuffEnabled = builder.comment("If set to false, player won't receive a Splinter effect when punching wood or cactus without sneaking.").define("splinter_debuff_enabled", true);
        splinterEffectBypassArmor = builder.comment("If set to true, the damage from the Splinter effect will ignore your armor protection and deal the same damage, no matter if you have good armor or not.").define("splinter_effect_bypass_armor", true);
        splinterDamagePerSecond = builder.comment("Define how much damage should the player take from the Splinter effect for 1 second").defineInRange("splinter_damage_per_second", 0.6, 0.0, Float.MAX_VALUE);
        splinterDuration = builder.comment("Define long should the splinter effect last in seconds.").defineInRange("splinter_duration", 10, 0, 1000000);
        splinterAmplifier = builder.comment("Define the amplifier for the splinter effect.").defineInRange("splinter_amplifier", 1, 1, 255);
        bleedingEffectEnabled = builder.comment("If set to false, player won't receive a Bleeding effect when punching glass").define("bleeding_effect_enabled", true);
        bleedingEffectBypassArmor = builder.comment("If set to true, the damage from the Bleeding effect will ignore your armor protection and deal the same damage, no matter if you have good armor or not.").define("bleeding_effect_bypass_armor", true);
        bleedingDamagePerSecond = builder.comment("Define how much damage should the player take from the Bleeding effect for 1 second").defineInRange("bleeding_damage_per_second", 1.0, 0.0, Float.MAX_VALUE);
        bleedingDuration = builder.comment("Define long should the splinter effect last in seconds.").defineInRange("bleeding_duration", 10, 0, 1000000);
        bleedingAmplifier = builder.comment("Define the amplifier for the splinter effect.").defineInRange("bleeding_amplifier", 1, 1, 255);
        weaknessDebuffEnabled = builder.comment("If set to false, you won't receive a Weakness effect when punching the wrong block.").define("weakness_debuff_enabled", true);
        weaknessDuration = builder.comment("Define long should the splinter effect last in seconds.").defineInRange("weakness_duration", 10, 0, 1000000);
        weaknessAmplifier = builder.comment("Define the amplifier for the splinter effect.").defineInRange("weakness_amplifier", 1, 1, 255);
        miningFatigueDebuffEnabled = builder.comment("If set to false, you won't receive a Mining Fatigue effect when punching the wrong block.").define("mining_fatigue_debuff_enabled", true);
        miningFatigueDuration = builder.comment("Define long should the splinter effect last in seconds.").defineInRange("mining_fatigue_duration", 10, 0, 1000000);
        miningFatigueAmplifier = builder.comment("Define the amplifier for the splinter effect.").defineInRange("mining_fatigue_amplifier", 1, 1, 255);
        debugEnabled = builder.comment("When enabled throws debug info to the console, useful for debugging purposes, it should be disabled if not used, it spams the console hard!").define("debug_enabled", false);
        builder.pop();
        SERVER_CONFIG = builder.build();
    }

    public static void init() {
        initServerConfig();
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG);
    }
}

