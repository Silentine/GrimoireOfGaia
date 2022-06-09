package gaia.registry.helper;

import gaia.GrimoireOfGaia;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaSounds;
import gaia.registry.GaiaTabs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Helper class for registering mob's with spawn eggs.
 */
public class MobReg<T extends Mob> {
	protected final String name;
	protected final RegistryObject<EntityType<? extends T>> entityType;
	protected final RegistryObject<Item> spawnEgg;

	protected final RegistryObject<SoundEvent> SAY;
	protected final RegistryObject<SoundEvent> HURT;
	protected final RegistryObject<SoundEvent> DEATH;
	protected final RegistryObject<SoundEvent> SAY_MALE;
	protected final RegistryObject<SoundEvent> HURT_MALE;
	protected final RegistryObject<SoundEvent> DEATH_MALE;
	protected final boolean hasGenders;

	/**
	 * @return The registry name of the mob
	 */
	@Nonnull
	public String getName() {
		return name;
	}

	/**
	 * @return The entity type registry object of the mob.
	 */
	public EntityType<? extends T> getEntityType() {
		return entityType.get();
	}

	/**
	 * @return The spawn egg item registry object of the mob.
	 */
	public RegistryObject<Item> getSpawnEgg() {
		return spawnEgg;
	}

	/**
	 * @return The Say SoundEvent of the mob.
	 */
	public SoundEvent getSay() {
		return SAY == null ? null : SAY.get();
	}

	/**
	 * @return The Hurt SoundEvent of the mob.
	 */
	public SoundEvent getHurt() {
		return HURT == null ? null : HURT.get();
	}

	/**
	 * @return The Death SoundEvent of the mob.
	 */
	public SoundEvent getDeath() {
		return DEATH == null ? null : DEATH.get();
	}

	public boolean hasGender() {
		return hasGenders;
	}

	/**
	 * @return The Male Say SoundEvent of the mob.
	 */
	@Nullable
	public SoundEvent getMaleSay() {
		return SAY_MALE == null ? null : SAY_MALE.get();
	}

	/**
	 * @return The Male Hurt SoundEvent of the mob.
	 */
	@Nullable
	public SoundEvent getMaleHurt() {
		return HURT_MALE == null ? null : HURT_MALE.get();
	}

	/**
	 * @return The Male Death SoundEvent of the mob.
	 */
	@Nullable
	public SoundEvent getMaleDeath() {
		return DEATH_MALE == null ? null : DEATH_MALE.get();
	}

	public MobReg(String name, EntityType.Builder<T> builder, int backgroundColor, int highlightColor, boolean hasGenders) {
		this.name = name;
		this.entityType = GaiaRegistry.ENTITIES.register(name, () -> builder.build(name));
		this.spawnEgg = GaiaRegistry.ITEMS.register(name + "_spawn_egg", () -> new ForgeSpawnEggItem(this.entityType, backgroundColor, highlightColor,
				new Item.Properties().tab(GaiaTabs.GAIA_TAB)));

		this.SAY = GaiaSounds.SOUND_EVENTS.register(name + "_say", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, name + "_say")));
		this.HURT = GaiaSounds.SOUND_EVENTS.register(name + "_hurt", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, name + "_hurt")));
		this.DEATH = GaiaSounds.SOUND_EVENTS.register(name + "_death", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, name + "_death")));
		if (hasGenders) {
			this.SAY_MALE = GaiaSounds.SOUND_EVENTS.register(name + "_male_say", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, name + "_male_say")));
			this.HURT_MALE = GaiaSounds.SOUND_EVENTS.register(name + "_male_hurt", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, name + "_male_hurt")));
			this.DEATH_MALE = GaiaSounds.SOUND_EVENTS.register(name + "_male_death", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, name + "_male_death")));
		} else {
			this.SAY_MALE = null;
			this.HURT_MALE = null;
			this.DEATH_MALE = null;
		}
		this.hasGenders = hasGenders;
	}

	public MobReg(String name, EntityType.Builder<T> builder, int backgroundColor, int highlightColor) {
		this(name, builder, backgroundColor, highlightColor, false);
	}
}
