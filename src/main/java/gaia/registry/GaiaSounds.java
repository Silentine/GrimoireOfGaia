package gaia.registry;

import gaia.GrimoireOfGaia;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GaiaSounds {
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, GrimoireOfGaia.MOD_ID);

	public static final RegistryObject<SoundEvent> BAG_OPEN = SOUND_EVENTS.register("bag_open", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "bag_open")));
	public static final RegistryObject<SoundEvent> BOOK_HIT = SOUND_EVENTS.register("book_hit", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "book_hit")));
	public static final RegistryObject<SoundEvent> METAL_BOOK_HIT = SOUND_EVENTS.register("metal_book_hit", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "metal_book_hit")));
	public static final RegistryObject<SoundEvent> BOX_OPEN = SOUND_EVENTS.register("box_open", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "box_open")));
	public static final RegistryObject<SoundEvent> CREEP_PRIMED = SOUND_EVENTS.register("creep_primed", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "creep_primed")));
	public static final RegistryObject<SoundEvent> GOBLIN_FERAL_PRIMED = SOUND_EVENTS.register("goblin_feral_primed", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "goblin_feral_primed")));
	public static final RegistryObject<SoundEvent> GAIA_SHOOT = SOUND_EVENTS.register("gaia_shoot", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "gaia_shoot")));
	public static final RegistryObject<SoundEvent> ANT_HILL_DEATH = SOUND_EVENTS.register("ant_hill_death", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "ant_hill_death")));
	public static final RegistryObject<SoundEvent> ENDER_EYE_TELEPORT = SOUND_EVENTS.register("ender_eye_teleport", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "ender_eye_teleport")));
	public static final RegistryObject<SoundEvent> ENDER_EYE_SCREAM = SOUND_EVENTS.register("ender_eye_scream", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "ender_eye_scream")));
	public static final RegistryObject<SoundEvent> ENDER_DRAGON_GIRL_TELEPORT = SOUND_EVENTS.register("ender_dragon_girl_teleport", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "ender_dragon_girl_teleport")));
	public static final RegistryObject<SoundEvent> ENDER_DRAGON_GIRL_SCREAM = SOUND_EVENTS.register("ender_dragon_girl_scream", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "ender_dragon_girl_scream")));
	public static final RegistryObject<SoundEvent> BEHENDER_TELEPORT = SOUND_EVENTS.register("behender_teleport", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "behender_teleport")));
	public static final RegistryObject<SoundEvent> BEHENDER_SCREAM = SOUND_EVENTS.register("behender_scream", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "behender_scream")));
	public static final RegistryObject<SoundEvent> BOMB_THROW = SOUND_EVENTS.register("bomb_throw", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "bomb_throw")));
	public static final RegistryObject<SoundEvent> MANDRAGORA_SCREAM = SOUND_EVENTS.register("mandragora_scream", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, "mandragora_scream")));

}
