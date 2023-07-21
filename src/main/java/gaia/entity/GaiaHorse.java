package gaia.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class GaiaHorse extends AbstractHorse {
	private int lifetime;

	public GaiaHorse(EntityType<? extends AbstractHorse> entityType, Level level) {
		super(entityType, level);
	}

	protected void randomizeAttributes() {
		this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(15.0D);
		this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.30D);
		this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(this.generateRandomJumpStrength());
	}

	@Override
	public boolean removeWhenFarAway(double distance) {
		return true;
	}

	@Override
	public boolean isSaddleable() {
		return false;
	}

	@Override
	public boolean canBeLeashed(Player player) {
		return false;
	}

	@Override
	public boolean isPersistenceRequired() {
		return super.isPersistenceRequired();
	}

	@Override
	public void aiStep() {
		if (!isVehicle()) {
			if (!this.level.isClientSide) {
				if (!isPersistenceRequired()) {
					++lifetime;
				}

				if (this.lifetime >= 1200) {
					discard();
				}
			}
		}

		super.aiStep();
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		super.getAmbientSound();
		return SoundEvents.ZOMBIE_HORSE_AMBIENT;
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		super.getDeathSound();
		return SoundEvents.ZOMBIE_HORSE_DEATH;
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		super.getHurtSound(source);
		return SoundEvents.ZOMBIE_HORSE_HURT;
	}
}
