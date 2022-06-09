package gaia.registry;

import gaia.GrimoireOfGaia;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GaiaSounds {
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, GrimoireOfGaia.MOD_ID);

	public static final RegistryObject<SoundEvent> BAG_OPEN = SOUND_EVENTS.register("bag_open", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "bag_open")));
	public static final RegistryObject<SoundEvent> BOOK_HIT = SOUND_EVENTS.register("book_hit", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "book_hit")));
	public static final RegistryObject<SoundEvent> METAL_BOOK_HIT = SOUND_EVENTS.register("metal_book_hit", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "metal_book_hit")));
	public static final RegistryObject<SoundEvent> BOX_OPEN = SOUND_EVENTS.register("box_open", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "box_open")));
	public static final RegistryObject<SoundEvent> CREEP_PRIMED = SOUND_EVENTS.register("creep_primed", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "creep_primed")));
	public static final RegistryObject<SoundEvent> GAIA_SHOOT = SOUND_EVENTS.register("gaia_shoot", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "gaia_shoot")));
}
