package gaia.registry.helper;

import gaia.GrimoireOfGaia;
import gaia.Reference;
import gaia.item.MerchantSpawnItem;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaSounds;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.Nullable;

import java.util.function.Supplier;

/**
 * Helper class for registering mob's with spawn eggs.
 * with options for registering sound events.
 */
public class MobReg<T extends Mob> {
	protected final String name;
	protected final Supplier<EntityType<? extends T>> entityType;
	protected final GaiaMobType gaiaMobType;
	protected DeferredItem<Item> spawnEgg;

	protected DeferredHolder<SoundEvent, SoundEvent> SAY;
	protected DeferredHolder<SoundEvent, SoundEvent> HURT;
	protected DeferredHolder<SoundEvent, SoundEvent> DEATH;
	protected DeferredHolder<SoundEvent, SoundEvent> STEP;
	protected DeferredHolder<SoundEvent, SoundEvent> ATTACK;
	protected DeferredHolder<SoundEvent, SoundEvent> SAY_MALE;
	protected DeferredHolder<SoundEvent, SoundEvent> HURT_MALE;
	protected DeferredHolder<SoundEvent, SoundEvent> DEATH_MALE;
	protected DeferredHolder<SoundEvent, SoundEvent> STEP_MALE;
	protected DeferredHolder<SoundEvent, SoundEvent> ATTACK_MALE;
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
	public DeferredItem<Item> getSpawnEgg() {
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

	public MobReg(String name, EntityType.Builder<T> builder, GaiaMobType mobType, boolean say, boolean hurt, boolean death, boolean step, boolean attack, boolean hasGenders, boolean noSpawnEgg, boolean traderEgg) {
		this.name = name;
		this.entityType = GaiaRegistry.ENTITIES.register(name, () -> builder.build(ResourceKey.create(Registries.ENTITY_TYPE, Reference.modLoc(name))));
		this.gaiaMobType = mobType;
		if (!noSpawnEgg) {
			if (traderEgg) {
				this.spawnEgg = GaiaRegistry.ITEMS.registerItem("spawn_" + name, (properties) -> new MerchantSpawnItem(this.entityType, properties));
			} else {
				this.spawnEgg = GaiaRegistry.ITEMS.registerItem(name + "_spawn_egg", (properties) -> new SpawnEggItem(properties.spawnEgg(this.entityType.get())));
			}
		}

		this.SAY = say ? GaiaSounds.SOUND_EVENTS.register(name + "_say", () -> SoundEvent.createVariableRangeEvent(GrimoireOfGaia.modLoc(name + "_say"))) : null;
		this.HURT = hurt ? GaiaSounds.SOUND_EVENTS.register(name + "_hurt", () -> SoundEvent.createVariableRangeEvent(GrimoireOfGaia.modLoc(name + "_hurt"))) : null;
		this.DEATH = death ? GaiaSounds.SOUND_EVENTS.register(name + "_death", () -> SoundEvent.createVariableRangeEvent(GrimoireOfGaia.modLoc(name + "_death"))) : null;
		this.STEP = step ? GaiaSounds.SOUND_EVENTS.register(name + "_step", () -> SoundEvent.createVariableRangeEvent(GrimoireOfGaia.modLoc(name + "_step"))) : null;
		this.ATTACK = attack ? GaiaSounds.SOUND_EVENTS.register(name + "_attack", () -> SoundEvent.createVariableRangeEvent(GrimoireOfGaia.modLoc(name + "_attack"))) : null;

		if (hasGenders) {
			this.SAY_MALE = say ? GaiaSounds.SOUND_EVENTS.register(name + "_male_say", () -> SoundEvent.createVariableRangeEvent(GrimoireOfGaia.modLoc(name + "_male_say"))) : null;
			this.HURT_MALE = hurt ? GaiaSounds.SOUND_EVENTS.register(name + "_male_hurt", () -> SoundEvent.createVariableRangeEvent(GrimoireOfGaia.modLoc(name + "_male_hurt"))) : null;
			this.DEATH_MALE = death ? GaiaSounds.SOUND_EVENTS.register(name + "_male_death", () -> SoundEvent.createVariableRangeEvent(GrimoireOfGaia.modLoc(name + "_male_death"))) : null;
			this.STEP_MALE = step ? GaiaSounds.SOUND_EVENTS.register(name + "_male_step", () -> SoundEvent.createVariableRangeEvent(GrimoireOfGaia.modLoc(name + "_male_step"))) : null;
			this.ATTACK_MALE = attack ? GaiaSounds.SOUND_EVENTS.register(name + "_male_attack", () -> SoundEvent.createVariableRangeEvent(GrimoireOfGaia.modLoc(name + "_male_attack"))) : null;
		}
		this.hasGenders = hasGenders;
	}

	public static class Builder<T extends Mob> {
		private final String name;
		private final EntityType.Builder<T> builder;
		private final GaiaMobType gaiaMobType;
		private boolean say, hurt, death, step, attack, hasGenders, noSpawnEgg, traderEgg;

		public Builder(String name, EntityType.Builder<T> builder) {
			this.name = name;
			this.builder = builder;
			this.gaiaMobType = GaiaMobType.AGGRESSIVE;
		}

		public Builder(String name, GaiaMobType mobType, EntityType.Builder<T> builder) {
			this.name = name;
			this.builder = builder;
			this.gaiaMobType = mobType;
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
			return new MobReg<>(name, builder, gaiaMobType, say, hurt, death, step, attack, hasGenders, noSpawnEgg, traderEgg);
		}
	}
}
