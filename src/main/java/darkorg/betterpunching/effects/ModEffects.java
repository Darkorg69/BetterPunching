package darkorg.betterpunching.effects;

import darkorg.betterpunching.BetterPunching;
import darkorg.betterpunching.effects.custom.ModEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {

    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, BetterPunching.MODID);

    //Effects
    public static final RegistryObject<MobEffect> BLEEDING = EFFECTS.register("bleeding", ()-> new ModEffect(MobEffectCategory.HARMFUL, 0x8A0303));
    public static final RegistryObject<MobEffect> SPLINTER = EFFECTS.register("splinter", ()-> new ModEffect(MobEffectCategory.HARMFUL, 0xA3713F));

    public static void init(IEventBus bus) {EFFECTS.register(bus);}
}
