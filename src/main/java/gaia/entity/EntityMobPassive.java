package gaia.entity;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.IAnimal;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumLightType;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

/**
 * This is a direct copy of EntityMob used by assist mobs to not trigger the warning message when using a bed. No additional changes have been made aside from the class name.
 *
 * @see EntityMob
 */
public abstract class EntityMobPassive extends EntityCreature implements IAnimal {

	EntityMobPassive(EntityType<?> type, World worldIn) {
		super(type, worldIn);
		this.experienceValue = 5;
	}

	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons use this to react to sunlight and start to burn.
	 */
	@Override
	public void livingTick() {
		this.updateArmSwingProgress();
		float f = this.getBrightness();

		if (f > 0.5F) {
			this.idleTime += 2;
		}

		super.livingTick();
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	public void tick() {
		super.tick();

		if (!this.world.isRemote && this.world.getDifficulty() == EnumDifficulty.PEACEFUL) {
			this.remove();
		}
	}

	@Override
	protected SoundEvent getSwimSound() {
		return SoundEvents.ENTITY_HOSTILE_SWIM;
	}

	@Override
	protected SoundEvent getSplashSound() {
		return SoundEvents.ENTITY_HOSTILE_SPLASH;
	}

	/**
	 * Called when the entity is attacked.
	 */

	// TODO updated attack line

//	public boolean attackEntityFrom(DamageSource source, float amount) {
//		if (this.isInvulnerableTo(source)) {
//			return false;
//		} else if (super.attackEntityFrom(source, amount)) {
//			Entity entity = source.getTrueSource();
//			return this.riddenByEntity != entity && this.ridingEntity != entity ? true : true;
//		} else {
//			return false;
//		}
//	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	public boolean attackEntityFrom(DamageSource source, float inputDamage) {
		return !this.isInvulnerableTo(source) && super.attackEntityFrom(source, inputDamage);
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_HOSTILE_HURT;
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_HOSTILE_DEATH;
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		float f = (float) this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue();
		int i = 0;

		if (entityIn instanceof EntityLivingBase) {
			f += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), ((EntityLivingBase) entityIn).getCreatureAttribute());
			i += EnchantmentHelper.getKnockbackModifier(this);
		}

		boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);

		if (flag) {
			if (i > 0) {
				entityIn.addVelocity((double) (-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F) * (float) i * 0.5F), 0.1D, (double) (MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F) * (float) i * 0.5F));
				this.motionX *= 0.6D;
				this.motionZ *= 0.6D;
			}

			int j = EnchantmentHelper.getFireAspectModifier(this);

			if (j > 0) {
				entityIn.setFire(j * 4);
			}

			this.applyEnchantments(this, entityIn);
		}

		return flag;
	}

	@Override
	public float getBlockPathWeight(BlockPos pos) {
		return 0.5F - this.world.getLight(pos);
	}

	/**
	 * Checks to make sure the light is not too bright where the mob is spawning
	 */
	private boolean isValidLightLevel() {
		BlockPos blockpos = new BlockPos(this.posX, this.getBoundingBox().minY, this.posZ);

		if (this.world.getLightFor(EnumLightType.SKY, blockpos) > this.rand.nextInt(32)) {
			return false;
		} else {
	         int i = this.world.isThundering() ? this.world.getNeighborAwareLightSubtracted(blockpos, 10) : this.world.getLight(blockpos);
	         return i <= this.rand.nextInt(8);
	    }
	}

	/**
	 * Checks if the entity's current position is a valid location to spawn this entity.
	 */
	@Override
	public boolean canSpawn(IWorld worldIn, boolean value) {
		return this.world.getDifficulty() != EnumDifficulty.PEACEFUL && this.isValidLightLevel() && super.canSpawn(worldIn, value);
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
	}

	/**
	 * Entity won't drop items or experience points if this returns false
	 */
	@Override
	protected boolean canDropLoot() {
		return true;
	}
}
