package gaia.entity.monster;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntitySkeletonHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

/**
 * @see EntitySkeletonHorse
 */
public class EntityGaiaHorse extends AbstractHorse {

	private int lifetime;

	public EntityGaiaHorse(World worldIn) {
		super(worldIn);
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D);
		this.getEntityAttribute(JUMP_STRENGTH).setBaseValue(this.getModifiedJumpStrength());
	}

	@Override
	protected boolean canDespawn() {
		return true;
	}

	@Override
	public boolean canBeLeashedTo(EntityPlayer player) {
		return false;
	}
	
	@Override
	public boolean canBeSaddled() {
		return false;
	}
	
//	@Override
//	public boolean isHorseSaddled() {
//		return true;
//	}

	public void onLivingUpdate() {
		if (!isBeingRidden()) {
			if (!world.isRemote) {
				if (!isNoDespawnRequired()) {
					++lifetime;
				}

				if (this.lifetime >= 1200) {
					setDead();
				}
			}
		}

		super.onLivingUpdate();
	}

	protected SoundEvent getAmbientSound() {
		super.getAmbientSound();
		return SoundEvents.ENTITY_ZOMBIE_HORSE_AMBIENT;
	}

	protected SoundEvent getDeathSound() {
		super.getDeathSound();
		return SoundEvents.ENTITY_ZOMBIE_HORSE_DEATH;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		super.getHurtSound(damageSourceIn);
		return SoundEvents.ENTITY_ZOMBIE_HORSE_HURT;
	}
}