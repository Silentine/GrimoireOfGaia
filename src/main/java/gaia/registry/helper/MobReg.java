package gaia.registry.helper;

import gaia.GrimoireOfGaia;
import gaia.item.MerchantSpawnItem;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Helper class for registering mob's with spawn eggs.
 * with options for registering sound events.
 */
public class MobReg<T extends Mob> {
	protected final String name;
	protected final RegistryObject<EntityType<? extends T>> entityType;
	protected final GaiaMobType gaiaMobType;
	protected RegistryObject<Item> spawnEgg;

	protected RegistryObject<SoundEvent> SAY;
	protected RegistryObject<SoundEvent> HURT;
	protected RegistryObject<SoundEvent> DEATH;
	protected RegistryObject<SoundEvent> STEP;
	protected RegistryObject<SoundEvent> ATTACK;
	protected RegistryObject<SoundEvent> SAY_MALE;
	protected RegistryObject<SoundEvent> HURT_MALE;
	protected RegistryObject<SoundEvent> DEATH_MALE;
	protected RegistryObject<SoundEvent> STEP_MALE;
	protected RegistryObject<SoundEvent> ATTACK_MALE;
	protected boolean hasGenders;

	/**
	 * @return The registry name of the mob
	 */
	@NotNull
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
	 * @return The gaia sound type of the mob used for the sound pack generation.
	 */
	public GaiaMobType getGaiaSoundType() {
		return gaiaMobType;
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

	/**
	 * @return The Step SoundEvent of the mob.
	 */
	public SoundEvent getStep() {
		return STEP == null ? null : STEP.get();
	}

	/**
	 * @return The Attack SoundEvent of the mob.
	 */
	public SoundEvent getAttack() {
		return ATTACK == null ? null : ATTACK.get();
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

	/**
	 * @return The Step SoundEvent of the mob.
	 */
	@Nullable
	public SoundEvent getMaleStep() {
		return STEP_MALE == null ? null : STEP_MALE.get();
	}

	/**
	 * @return The Attack SoundEvent of the mob.
	 */
	@Nullable
	public SoundEvent getMaleAttack() {
		return ATTACK_MALE == null ? null : ATTACK_MALE.get();
	}

	public MobReg(String name, EntityType.Builder<T> builder, GaiaMobType mobType, int backgroundColor, int highlightColor, boolean say, boolean hurt, boolean death, boolean step, boolean attack, boolean hasGenders, boolean noSpawnEgg, boolean traderEgg) {
		this.name = name;
		this.entityType = GaiaRegistry.ENTITIES.register(name, () -> builder.build(name));
		this.gaiaMobType = mobType;
		if (!noSpawnEgg) {
			if (traderEgg) {
				this.spawnEgg = GaiaRegistry.ITEMS.register("spawn_" + name, () -> new MerchantSpawnItem(this.entityType, new Item.Properties().tab(GaiaTabs.GAIA_TAB)));
			} else {
				this.spawnEgg = GaiaRegistry.ITEMS.register(name + "_spawn_egg", () -> new ForgeSpawnEggItem(this.entityType, backgroundColor, highlightColor,
						new Item.Properties().tab(GaiaTabs.GAIA_TAB)));
			}
		}

		this.SAY = say ? GaiaSounds.SOUND_EVENTS.register(name + "_say", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, name + "_say"))) : null;
		this.HURT = hurt ? GaiaSounds.SOUND_EVENTS.register(name + "_hurt", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, name + "_hurt"))) : null;
		this.DEATH = death ? GaiaSounds.SOUND_EVENTS.register(name + "_death", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, name + "_death"))) : null;
		this.STEP = step ? GaiaSounds.SOUND_EVENTS.register(name + "_step", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, name + "_step"))) : null;
		this.ATTACK = attack ? GaiaSounds.SOUND_EVENTS.register(name + "_attack", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, name + "_attack"))) : null;

		if (hasGenders) {
			this.SAY_MALE = say ? GaiaSounds.SOUND_EVENTS.register(name + "_male_say", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, name + "_male_say"))) : null;
			this.HURT_MALE = hurt ? GaiaSounds.SOUND_EVENTS.register(name + "_male_hurt", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, name + "_male_hurt"))) : null;
			this.DEATH_MALE = death ? GaiaSounds.SOUND_EVENTS.register(name + "_male_death", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, name + "_male_death"))) : null;
			this.STEP_MALE = step ? GaiaSounds.SOUND_EVENTS.register(name + "_male_step", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, name + "_male_step"))) : null;
			this.ATTACK_MALE = attack ? GaiaSounds.SOUND_EVENTS.register(name + "_male_attack", () -> new SoundEvent(new ResourceLocation(GrimoireOfGaia.MOD_ID, name + "_male_attack"))) : null;
		}
		this.hasGenders = hasGenders;
	}

	public static class Builder<T extends Mob> {
		private final String name;
		private final EntityType.Builder<T> builder;
		private final GaiaMobType gaiaMobType;
		private final int backgroundColor, highlightColor;
		private boolean say, hurt, death, step, attack, hasGenders, noSpawnEgg, traderEgg;

		public Builder(String name, EntityType.Builder<T> builder, int backgroundColor, int highlightColor) {
			this.name = name;
			this.builder = builder;
			this.gaiaMobType = GaiaMobType.AGGRESSIVE;
			this.backgroundColor = backgroundColor;
			this.highlightColor = highlightColor;
		}

		public Builder(String name, EntityType.Builder<T> builder) {
			this.name = name;
			this.builder = builder;
			this.gaiaMobType = GaiaMobType.AGGRESSIVE;
			this.backgroundColor = 0;
			this.highlightColor = 0;
		}

		public Builder(String name, GaiaMobType mobType, EntityType.Builder<T> builder, int backgroundColor, int highlightColor) {
			this.name = name;
			this.builder = builder;
			this.gaiaMobType = mobType;
			this.backgroundColor = backgroundColor;
			this.highlightColor = highlightColor;
		}

		public Builder(String name, GaiaMobType mobType, EntityType.Builder<T> builder) {
			this.name = name;
			this.builder = builder;
			this.gaiaMobType = mobType;
			this.backgroundColor = 0;
			this.highlightColor = 0;
		}

		public Builder<T> withDefaultSounds() {
			this.say = true;
			this.hurt = true;
			this.death = true;
			return this;
		}

		public Builder<T> noSpawnEgg() {
			this.noSpawnEgg = true;
			return this;
		}

		public Builder<T> traderEgg() {
			this.traderEgg = true;
			return this;
		}

		public Builder<T> withSay() {
			this.say = true;
			return this;
		}

		public Builder<T> withHurt() {
			this.hurt = true;
			return this;
		}

		public Builder<T> withDeath() {
			this.death = true;
			return this;
		}

		public Builder<T> withGender() {
			this.hasGenders = true;
			return this;
		}

		public Builder<T> withStep() {
			this.step = true;
			return this;
		}

		public Builder<T> withAttack() {
			this.attack = true;
			return this;
		}

		public MobReg<T> build() {
			return new MobReg<>(name, builder, gaiaMobType, backgroundColor, highlightColor, say, hurt, death, step, attack, hasGenders, noSpawnEgg, traderEgg);
		}
	}
}
