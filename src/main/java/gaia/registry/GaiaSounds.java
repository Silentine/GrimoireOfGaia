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
	public static final RegistryObject<SoundEvent> GOBLIN_FERAL_PRIMED = SOUND_EVENTS.register("goblin_feral_primed", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "goblin_feral_primed")));
	public static final RegistryObject<SoundEvent> GAIA_SHOOT = SOUND_EVENTS.register("gaia_shoot", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "gaia_shoot")));
	public static final RegistryObject<SoundEvent> ANT_HILL_DEATH = SOUND_EVENTS.register("ant_hill_death", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "ant_hill_death")));
	public static final RegistryObject<SoundEvent> BOMB_THROW = SOUND_EVENTS.register("bomb_throw", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "bomb_throw")));

	public static final RegistryObject<SoundEvent> BONE_KNIGHT_STEP = SOUND_EVENTS.register("bone_knight_step", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "bone_knight_step")));
	public static final RegistryObject<SoundEvent> FLESH_LICH_STEP = SOUND_EVENTS.register("flesh_lich_step", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "flesh_lich_step")));
}
