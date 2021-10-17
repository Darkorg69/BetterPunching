package darkorg.betterpunching.setup;

import cpw.mods.modlauncher.LaunchPluginHandler;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class Config {

    public static ForgeConfigSpec CLIENT_CONFIG;
    public static ForgeConfigSpec SERVER_CONFIG;

    public static ForgeConfigSpec.BooleanValue disableStoneTools;
    public static ForgeConfigSpec.BooleanValue disableWoodTools;
    public static ForgeConfigSpec.BooleanValue easySticksEnabled;
    public static ForgeConfigSpec.DoubleValue easySticksChance;
    public static ForgeConfigSpec.IntValue easySticksDropCount;
    public static ForgeConfigSpec.BooleanValue punchingGlassEnabled;
    public static ForgeConfigSpec.DoubleValue punchingGlassDamage;
    public static ForgeConfigSpec.BooleanValue punchingWoodEnabled;
    public static ForgeConfigSpec.DoubleValue punchingWoodDamage;
    public static ForgeConfigSpec.BooleanValue sharpingFlintEnabled;
    public static ForgeConfigSpec.DoubleValue sharpingFlintChance;
    public static ForgeConfigSpec.BooleanValue wrongToolEnabled;
    public static ForgeConfigSpec.DoubleValue wrongToolDamage;


    public static void init() {
        initServer();
        initClient();

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT_CONFIG);
    }

    private static void initServer() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.push("BetterPunching configuration file");
        disableStoneTools = builder.comment("Set to false to disable vanilla stone tools.")
                .define("stoneTools_enabled", true);
        disableWoodTools = builder.comment("Set to false to disable vanilla wooden tools.")
                .define("woodTools_enabled", true);
        easySticksEnabled = builder.comment("Set to false to disable the EasySticks feature.")
                .define("easysticks_enabled", true);
        easySticksChance = builder.comment("Set what is the chance, sticks will drop from leaves.")
                .defineInRange("easysticks_chance", 0.25, 0.0, 1.0);
        easySticksDropCount = builder.comment("How much sticks will leaves drop.")
                .defineInRange("easysticks_drop_count", 1, 1, Integer.MAX_VALUE);
        punchingGlassEnabled = builder.comment("Set to false to disable the PunchingGlass feature.")
                .define("punchingglass_enabled", true);
        punchingGlassDamage = builder.comment("Set how much damage punching glass does to the player.")
                .defineInRange("punchingglass_damage", 10.0, 0.0, Float.MAX_VALUE);
        punchingWoodEnabled = builder.comment("Set to false to disable the PunchingWood feature.")
                .define("punchingwood_enabled", true);
        punchingWoodDamage = builder.comment("Set how much damage hand breaking wood does to the player.")
                .defineInRange("punchingwood_damage", 4.0, 0.0, Float.MAX_VALUE);
        sharpingFlintEnabled = builder.comment("Set to false to disable the SharpingFlint feature.")
                .define("sharpingflint_enabled", true);
        sharpingFlintChance = builder.comment("Set what is the chance for flint to get sharpened.")
                .defineInRange("sharpingflint_chance", 0.25, 0.0, 1.0);
        wrongToolEnabled = builder.comment("Set to false to disable the WrongTool feature.")
                .define("wrongtool_enabled", true);
        wrongToolDamage = builder.comment("Set how much damage punching the wrong block does to the player.")
                        .defineInRange("wrongtool_damage", 4.0, 0.0, Float.MAX_VALUE);
        builder.pop();
        SERVER_CONFIG = builder.build();
    }
    private static void initClient() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        //builder.pop();
        CLIENT_CONFIG = builder.build();
    }
}

