package gaia.init;

import gaia.Gaia;
import gaia.GaiaReference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Source <li>http://www.minecraftforge.net/forum/index.php/topic,38076.0.html
 */
public class Sounds {

    static String MODID = GaiaReference.MOD_ID;

    public static SoundEvent passive_say;
    public static SoundEvent passive_hurt;
    public static SoundEvent passive_death;

    public static SoundEvent assist_say;
    public static SoundEvent assist_hurt;
    public static SoundEvent assist_death;

    public static SoundEvent aggressive_say;
    public static SoundEvent aggressive_hurt;
    public static SoundEvent aggressive_death;

    public static SoundEvent minotaur_say;
    public static SoundEvent minotaur_hurt;

    public static SoundEvent box_open1;
    public static SoundEvent box_open2;
    public static SoundEvent bag_open;
    public static SoundEvent book_hit;

    public static SoundEvent none;

    public static void Sounds_Init() {
        Gaia.LOGGER.info("Registering Sounds");
        SoundsRegister();
        Gaia.LOGGER.info("Sounds Finished");
    }

    public static void SoundsRegister() {
        passive_say = createSoundEvent("passive_say");
        passive_hurt = createSoundEvent("passive_hurt");
        passive_death = createSoundEvent("passive_death");

        assist_say = createSoundEvent("assist_say");
        assist_hurt = createSoundEvent("assist_hurt");
        assist_death = createSoundEvent("assist_death");

        aggressive_say = createSoundEvent("aggressive_say");
        aggressive_hurt = createSoundEvent("aggressive_hurt");
        aggressive_death = createSoundEvent("aggressive_death");

        minotaur_say = createSoundEvent("minotaur_say");
        minotaur_hurt = createSoundEvent("minotaur_hurt");

        box_open1 = createSoundEvent("box_open1");
        box_open2 = createSoundEvent("box_open2");
        bag_open = createSoundEvent("bag_open");
        book_hit = createSoundEvent("book_hit");

        none = createSoundEvent("none");
    }

    /**
     * Create a {@link SoundEvent}.
     *
     * @param soundName The SoundEvent's name without the testmod3 prefix
     * @return The SoundEvent
     */
    private static SoundEvent createSoundEvent(final String soundName) {
        final ResourceLocation soundID = new ResourceLocation(GaiaReference.MOD_ID, soundName);
        return new SoundEvent(soundID).setRegistryName(soundID);
    }

    @Mod.EventBusSubscriber(modid = GaiaReference.MOD_ID)
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void registerSoundEvents(final RegistryEvent.Register<SoundEvent> event) {
            Sounds_Init();
            event.getRegistry().registerAll(
                    passive_say,
                    passive_hurt,
                    passive_death,

                    assist_say,
                    assist_hurt,
                    assist_death,

                    aggressive_say,
                    aggressive_hurt,
                    aggressive_death,

                    minotaur_say,
                    minotaur_hurt,

                    box_open1,
                    box_open2,
                    bag_open,
                    book_hit);
        }
    }
}
