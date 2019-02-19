package gaia.entity.monster;

import javax.annotation.Nullable;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import gaia.items.ItemShard;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySpectralArrow;
import net.minecraft.init.Items;
import net.minecraft.init.Particles;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

/**
 * Copied code from EntityVex with the main difference that code related to 'owner' and 'limitedLifespan' have been removed. isAIDisabled has also been removed.
 * 
 * @see EntityVex
 */
public class EntityGaiaBanshee extends EntityMobHostileBase {

//	private static final int DETECTION_RANGE = 8;

	protected static final DataParameter<Byte> VEX_FLAGS = EntityDataManager.<Byte>createKey(EntityGaiaBanshee.class, DataSerializers.BYTE);
	@Nullable
	private BlockPos boundOrigin;

	public EntityGaiaBanshee(World worldIn) {
		super(GaiaEntities.BANSHEE, worldIn);

		experienceValue = EntityAttributes.EXPERIENCE_VALUE_2;
		isImmuneToFire = true;

		this.moveHelper = new EntityGaiaBanshee.AIMoveControl(this);
	}

	@Override
	protected void initEntityAI() {
		super.initEntityAI();
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(4, new EntityGaiaBanshee.AIChargeAttack());
		this.tasks.addTask(8, new EntityGaiaBanshee.AIMoveRandom());
		this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F, 1.0F));
		this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[] { EntityGaiaBanshee.class }));
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();

		getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.MAX_HEALTH_2);
		getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.FOLLOW_RANGE);
		getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.MOVE_SPEED_2);
		getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityAttributes.ATTACK_DAMAGE_2);
		getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.RATE_ARMOR_2);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float damage) {
		Entity entity = source.getImmediateSource();

		if (entity instanceof EntityArrow) {
			damage += 2;
		} 
		
		if (entity instanceof EntitySpectralArrow) {
			damage += 4;
		}
		
		return super.attackEntityFrom(source, Math.min(damage, EntityAttributes.BASE_DEFENSE_2));
	}

	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
		super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_2);
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		if (super.attackEntityAsMob(entityIn)) {
			entityIn.setFire(6);
		}
		return true;
	}

	@Override
	public void livingTick() {
		if (world.isDaytime() && !world.isRemote) {
			float f = getBrightness();

			if (f > 0.5F && rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && world.canSeeSky(getPosition())) {
				world.setEntityState(this, (byte) 11);

				attackEntityFrom(DamageSource.OUT_OF_WORLD, EntityAttributes.MAX_HEALTH_2 * 0.25F);
			}
		}

		for (int var2 = 0; var2 < 2; ++var2) {
			world.spawnParticle(Particles.PORTAL, posX + (rand.nextDouble() - 0.5D) * width, posY + rand.nextDouble() * height, posZ + (rand.nextDouble() - 0.5D) * width, 0.0D, 0.0D, 0.0D);
		}

		super.livingTick();
	}

	/* VEX CODE */
	/**
	 * Tries to move the entity towards the specified location.
	 */
	public void move(MoverType type, double x, double y, double z) {
		super.move(type, x, y, z);
		this.doBlockCollisions();
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void tick() {
		this.noClip = true;
		super.tick();
		this.noClip = false;
		this.setNoGravity(true);
	}

	protected void registerData() {
		super.registerData();
		this.getDataManager().register(VEX_FLAGS, Byte.valueOf((byte) 0));
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readAdditional(NBTTagCompound compound) {
		super.readAdditional(compound);

		if (compound.hasKey("BoundX")) {
			this.boundOrigin = new BlockPos(compound.getInt("BoundX"), compound.getInt("BoundY"), compound.getInt("BoundZ"));
		}
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeAdditional(NBTTagCompound compound) {
		super.writeAdditional(compound);

		if (this.boundOrigin != null) {
			compound.setInt("BoundX", this.boundOrigin.getX());
			compound.setInt("BoundY", this.boundOrigin.getY());
			compound.setInt("BoundZ", this.boundOrigin.getZ());
		}
	}

	@Nullable
	public BlockPos getBoundOrigin() {
		return this.boundOrigin;
	}

	public void setBoundOrigin(@Nullable BlockPos boundOriginIn) {
		this.boundOrigin = boundOriginIn;
	}

	private boolean getVexFlag(int mask) {
		int i = ((Byte) this.dataManager.get(VEX_FLAGS)).byteValue();
		return (i & mask) != 0;
	}

	private void setVexFlag(int mask, boolean value) {
		int i = ((Byte) this.dataManager.get(VEX_FLAGS)).byteValue();

		if (value) {
			i = i | mask;
		} else {
			i = i & ~mask;
		}

		this.dataManager.set(VEX_FLAGS, Byte.valueOf((byte) (i & 255)));
	}

	public boolean isCharging() {
		return this.getVexFlag(1);
	}

	public void setCharging(boolean charging) {
		this.setVexFlag(1, charging);
	}

	class AIChargeAttack extends EntityAIBase {
		public AIChargeAttack() {
			this.setMutexBits(1);
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute() {
			if (EntityGaiaBanshee.this.getAttackTarget() != null && !EntityGaiaBanshee.this.getMoveHelper().isUpdating() && EntityGaiaBanshee.this.rand.nextInt(7) == 0) {
				return EntityGaiaBanshee.this.getDistanceSq(EntityGaiaBanshee.this.getAttackTarget()) > 4.0D;
			} else {
				return false;
			}
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean shouldContinueExecuting() {
			return EntityGaiaBanshee.this.getMoveHelper().isUpdating() && EntityGaiaBanshee.this.isCharging() && EntityGaiaBanshee.this.getAttackTarget() != null && EntityGaiaBanshee.this.getAttackTarget().isAlive();
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			EntityLivingBase entitylivingbase = EntityGaiaBanshee.this.getAttackTarget();
			Vec3d vec3d = entitylivingbase.getEyePosition(1.0F);
			EntityGaiaBanshee.this.moveHelper.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 1.0D);
			EntityGaiaBanshee.this.setCharging(true);
			EntityGaiaBanshee.this.playSound(SoundEvents.ENTITY_VEX_CHARGE, 1.0F, 1.0F);
		}

		/**
		 * Reset the task's internal state. Called when this task is interrupted by another one
		 */
		public void resetTask() {
			EntityGaiaBanshee.this.setCharging(false);
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			EntityLivingBase entitylivingbase = EntityGaiaBanshee.this.getAttackTarget();

			if (EntityGaiaBanshee.this.getBoundingBox().intersects(entitylivingbase.getBoundingBox())) {
				EntityGaiaBanshee.this.attackEntityAsMob(entitylivingbase);
				EntityGaiaBanshee.this.setCharging(false);
			} else {
				double d0 = EntityGaiaBanshee.this.getDistanceSq(entitylivingbase);

				if (d0 < 9.0D) {
					Vec3d vec3d = entitylivingbase.getEyePosition(1.0F);
					EntityGaiaBanshee.this.moveHelper.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 1.0D);
				}
			}
		}
	}

	class AIMoveControl extends EntityMoveHelper {
		public AIMoveControl(EntityGaiaBanshee vex) {
			super(vex);
		}

		public void tickMoveHelper() {
			if (this.action == EntityMoveHelper.Action.MOVE_TO) {
				double d0 = this.posX - EntityGaiaBanshee.this.posX;
				double d1 = this.posY - EntityGaiaBanshee.this.posY;
				double d2 = this.posZ - EntityGaiaBanshee.this.posZ;
				double d3 = d0 * d0 + d1 * d1 + d2 * d2;
				d3 = (double) MathHelper.sqrt(d3);

				if (d3 < EntityGaiaBanshee.this.getBoundingBox().getAverageEdgeLength()) {
					this.action = EntityMoveHelper.Action.WAIT;
					EntityGaiaBanshee.this.motionX *= 0.5D;
					EntityGaiaBanshee.this.motionY *= 0.5D;
					EntityGaiaBanshee.this.motionZ *= 0.5D;
				} else {
					EntityGaiaBanshee.this.motionX += d0 / d3 * 0.05D * this.speed;
					EntityGaiaBanshee.this.motionY += d1 / d3 * 0.05D * this.speed;
					EntityGaiaBanshee.this.motionZ += d2 / d3 * 0.05D * this.speed;

					if (EntityGaiaBanshee.this.getAttackTarget() == null) {
						EntityGaiaBanshee.this.rotationYaw = -((float) MathHelper.atan2(EntityGaiaBanshee.this.motionX, EntityGaiaBanshee.this.motionZ)) * (180F / (float) Math.PI);
						EntityGaiaBanshee.this.renderYawOffset = EntityGaiaBanshee.this.rotationYaw;
					} else {
						double d4 = EntityGaiaBanshee.this.getAttackTarget().posX - EntityGaiaBanshee.this.posX;
						double d5 = EntityGaiaBanshee.this.getAttackTarget().posZ - EntityGaiaBanshee.this.posZ;
						EntityGaiaBanshee.this.rotationYaw = -((float) MathHelper.atan2(d4, d5)) * (180F / (float) Math.PI);
						EntityGaiaBanshee.this.renderYawOffset = EntityGaiaBanshee.this.rotationYaw;
					}
				}
			}
		}
	}

	class AIMoveRandom extends EntityAIBase {
		public AIMoveRandom() {
			this.setMutexBits(1);
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute() {
			return !EntityGaiaBanshee.this.getMoveHelper().isUpdating() && EntityGaiaBanshee.this.rand.nextInt(7) == 0;
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean shouldContinueExecuting() {
			return false;
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			BlockPos blockpos = EntityGaiaBanshee.this.getBoundOrigin();

			if (blockpos == null) {
				blockpos = new BlockPos(EntityGaiaBanshee.this);
			}

			for (int i = 0; i < 3; ++i) {
				BlockPos blockpos1 = blockpos.add(EntityGaiaBanshee.this.rand.nextInt(15) - 7, EntityGaiaBanshee.this.rand.nextInt(11) - 5, EntityGaiaBanshee.this.rand.nextInt(15) - 7);

				if (EntityGaiaBanshee.this.world.isAirBlock(blockpos1)) {
					EntityGaiaBanshee.this.moveHelper.setMoveTo((double) blockpos1.getX() + 0.5D, (double) blockpos1.getY() + 0.5D, (double) blockpos1.getZ() + 0.5D, 0.25D);

					if (EntityGaiaBanshee.this.getAttackTarget() == null) {
						EntityGaiaBanshee.this.getLookHelper().setLookPosition((double) blockpos1.getX() + 0.5D, (double) blockpos1.getY() + 0.5D, (double) blockpos1.getZ() + 0.5D, 180.0F, 20.0F);
					}

					break;
				}
			}
		}
	}
	/* VEX CODE */

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaSounds.BANSHEE_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaSounds.BANSHEE_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.BANSHEE_DEATH;
	}

	@Override
	protected void playStepSound(BlockPos pos, IBlockState blockIn) {
		playSound(GaiaSounds.NONE, 1.0F, 1.0F);
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			int drop = rand.nextInt(3 + lootingModifier);

			for (int i = 0; i < drop; ++i) {
				entityDropItem(GaiaItems.MISC_SOUL_FIRE, 1);
			}

			// Nuggets/Fragments
			int dropNugget = rand.nextInt(3) + 1;

			for (int i = 0; i < dropNugget; ++i) {
				entityDropItem(Items.GOLD_NUGGET, 1);
			}

			if (GaiaConfig.COMMON.additionalOre.get()) {
				int dropNuggetAlt = rand.nextInt(3) + 1;

				for (int i = 0; i < dropNuggetAlt; ++i) {
					ItemShard.dropNugget(this, 5);
				}
			}

			// Rare
			if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0)) {
				switch (rand.nextInt(2)) {
				case 0:
					entityDropItem(GaiaItems.BOX_GOLD, 1);
				case 1:
					entityDropItem(GaiaItems.BAG_BOOK, 1);
				}
			}
			
			// Unique Rare
			if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
				entityDropItem(GaiaItems.WEAPON_BOOK_NIGHTMARE, 1);
			}
		}
	}

	@Override
	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.UNDEAD;
	}

	/* SPAWN CONDITIONS */
	@Override
	public int getMaxSpawnedInChunk() {
		return EntityAttributes.CHUNK_LIMIT_2;
	}

	@Override
	public boolean canSpawn(IWorld p_205020_1_, boolean p_205020_2_) {
		return posY > 60.0D && super.canSpawn(world, p_205020_2_);
	}
	/* SPAWN CONDITIONS */
}
