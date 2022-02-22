package darkorg.betterpunching.setup;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class Config {
    public static ForgeConfigSpec SERVER_CONFIG;
    public static ForgeConfigSpec.BooleanValue punchingCactusEnabled;
    public static ForgeConfigSpec.BooleanValue punchingGlassEnabled;
    public static ForgeConfigSpec.BooleanValue punchingWoodEnabled;
    public static ForgeConfigSpec.BooleanValue wrongToolEnabled;
    public static ForgeConfigSpec.DoubleValue wrongToolDamage;
    public static ForgeConfigSpec.BooleanValue miningFatigueDebuffEnabled;
    public static ForgeConfigSpec.BooleanValue weaknessDebuffEnabled;

    public static void init() {
        initServer();
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG);
    }

    private static void initServer() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.push("BetterPunching configuration file");

        punchingCactusEnabled = builder.comment("Set to false to disable the PunchingCactus feature.").define("punchingcactus_enabled", true);
        punchingGlassEnabled = builder.comment("Set to false to disable the PunchingGlass feature.").define("punchingglass_enabled", true);
        punchingWoodEnabled = builder.comment("Set to false to disable the PunchingWood feature.").define("punchingwood_enabled", true);
        wrongToolEnabled = builder.comment("Set to false to disable the WrongTool feature.").define("wrongtool_enabled", true);
        wrongToolDamage = builder.comment("Set how much damage punching the wrong block does to the player.").defineInRange("wrongtool_damage", 2.0, 0.0, Float.MAX_VALUE);
        miningFatigueDebuffEnabled = builder.comment("Set to false to disable the mining fatigue debuff given to the player when punching a wrong block or gaining a splinter/bleeding effect.").define("miningfatigue_debuff_enabled", true);
        weaknessDebuffEnabled = builder.comment("Set to false to disable the weakness debuff given to the player when punching a wrong block or gaining a splinter/bleeding effect.").define("weakness_debuff_enabled", true);

        builder.pop();
        SERVER_CONFIG = builder.build();
    }
}

