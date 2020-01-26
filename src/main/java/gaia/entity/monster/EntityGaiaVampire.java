package gaia.entity.monster;

import javax.annotation.Nullable;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaItems;
import gaia.init.GaiaLootTables;
import gaia.init.GaiaSounds;
import gaia.items.ItemShard;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaVampire extends EntityMobHostileBase {

	private static final String CAN_SPAWN_TAG = "CanSpawn";

	private static final DataParameter<Boolean> CAN_SPAWN = EntityDataManager.<Boolean>createKey(EntityGaiaVampire.class, DataSerializers.BOOLEAN);

	private int spawnLimit;
	private int spawnTime;
	private boolean canSpawn;
	private boolean spawnOnDeath;

	public EntityGaiaVampire(World worldIn) {
		super(worldIn);

		setSize(1.0F, 2.2F);
		experienceValue = EntityAttributes.EXPERIENCE_VALUE_3;
		stepHeight = 6.0F;
		isImmuneToFire = true;

		spawnLimit = 0;
		spawnTime = 0;
		canSpawn = true;
		spawnOnDeath = false;
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAIRestrictSun(this));
		tasks.addTask(2, new EntityAIFleeSun(this, EntityAttributes.ATTACK_SPEED_3));
		tasks.addTask(3, new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_3, true));
		tasks.addTask(4, new EntityAIWander(this, 1.0D));
		tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F, 1.0F));
		tasks.addTask(5, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.MAX_HEALTH_3);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.FOLLOW_RANGE);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.MOVE_SPEED_3);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityAttributes.ATTACK_DAMAGE_3);
		getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.RATE_ARMOR_3);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float damage) {
		if (isArmored()) {
			return !(source instanceof EntityDamageSourceIndirect) && super.attackEntityFrom(source, Math.min(damage, EntityAttributes.BASE_DEFENSE_3));
		} else {
			return super.attackEntityFrom(source, Math.min(damage, EntityAttributes.BASE_DEFENSE_3));
		}
	}
	
	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
		super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_3);
	}
	
	public boolean isArmored() {
		return getHealth() <= this.getMaxHealth() / 2.0F;
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		if (super.attackEntityAsMob(entityIn)) {
			if (entityIn instanceof EntityLivingBase) {
				byte byte0 = 0;

				if (world.getDifficulty() == EnumDifficulty.NORMAL) {
					byte0 = 10;
				} else if (world.getDifficulty() == EnumDifficulty.HARD) {
					byte0 = 20;
				}

				if (byte0 > 0 && getHealth() < EntityAttributes.MAX_HEALTH_3 * 0.75F) {
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, byte0 * 20, 0));

					world.setEntityState(this, (byte) 8);
					heal(EntityAttributes.MAX_HEALTH_3 * 0.10F);
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isAIDisabled() {
		return false;
	}

	@Override
	public void onLivingUpdate() {
		if (!onGround && motionY < 0.0D) {
			motionY *= 0.8D;
		}
		
		if (!world.isRemote && isRiding()) {
			dismountRidingEntity();
		}

		if (!world.isRemote && world.isDaytime()) {
			float f = getBrightness();

			if (f > 0.5F && rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && world.canSeeSky(getPosition())) {
				world.setEntityState(this, (byte) 11);
				attackEntityFrom(DamageSource.GENERIC, EntityAttributes.MAX_HEALTH_3 * 0.25F);
			}
		}

		if (getHealth() < EntityAttributes.MAX_HEALTH_3 * 0.75F && getHealth() > EntityAttributes.MAX_HEALTH_3 * 0.25F) {
			if (canSpawn) {
				if (spawnLimit < 5) {
					if ((spawnTime >= 0) && (spawnTime <= 200)) {
						++spawnTime;
					} else {
						if (canSpawn()) {
							world.setEntityState(this, (byte) 9);

							if (!world.isRemote) {
								setSpawn((byte) 0);
							}
						}

						spawnLimit += 1;
						spawnTime = 0;
					}
				} else {
					canSpawn = false;
				}
			}
		}

		if (getHealth() <= 0.0F) {
			for (int i = 0; i < 2; ++i) {
				world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, posX + (rand.nextDouble() - 0.5D) * width, posY + rand.nextDouble() * height, posZ + (rand.nextDouble() - 0.5D) * width, 0.0D, 0.0D, 0.0D);
			}

			if (!spawnOnDeath) {
				if (!world.isRemote) {
					setSpawn((byte) 1);
				}

				spawnOnDeath = true;
			}
		} else {
			super.onLivingUpdate();
		}
	}

	private void setSpawn(byte id) {
		if (id == 0) {
			BlockPos blockpos = (new BlockPos(EntityGaiaVampire.this)).add(-1 + EntityGaiaVampire.this.rand.nextInt(3), 1, -1 + EntityGaiaVampire.this.rand.nextInt(3));
			EntityGaiaIllagerButler entitySpawn = new EntityGaiaIllagerButler(EntityGaiaVampire.this.world);
			entitySpawn.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
			entitySpawn.onInitialSpawn(EntityGaiaVampire.this.world.getDifficultyForLocation(blockpos), (IEntityLivingData) null);
			EntityGaiaVampire.this.world.spawnEntity(entitySpawn);
		}

		if (id == 1) {
			BlockPos blockpos = (new BlockPos(EntityGaiaVampire.this)).add(1, 2, 1);
			EntityBat entitySpawn = new EntityBat(EntityGaiaVampire.this.world);
			entitySpawn.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
			entitySpawn.onInitialSpawn(EntityGaiaVampire.this.world.getDifficultyForLocation(blockpos), (IEntityLivingData) null);
			EntityGaiaVampire.this.world.spawnEntity(entitySpawn);
		}
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		dataManager.register(CAN_SPAWN, true);
	}

	public boolean canSpawn() {
		return ((Boolean) getDataManager().get(CAN_SPAWN)).booleanValue();
	}

	public void setSpawn(boolean canSpawn) {
		getDataManager().set(CAN_SPAWN, Boolean.valueOf(canSpawn));
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setBoolean(CAN_SPAWN_TAG, canSpawn());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		if (compound.hasKey(CAN_SPAWN_TAG)) {
			boolean b0 = compound.getBoolean(CAN_SPAWN_TAG);
			setSpawn(b0);
		}
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaSounds.VAMPIRE_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaSounds.VAMPIRE_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.VAMPIRE_DEATH;
	}

	@Override
	protected void playStepSound(BlockPos pos, Block blockIn) {
		playSound(GaiaSounds.NONE, 1.0F, 1.0F);
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return GaiaLootTables.ENTITIES_GAIA_VAMPIRE;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if ((rand.nextInt(4) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				dropItem(GaiaItems.FOOD_SMALL_APPLE_GOLD, 1);
			}

			// Nuggets/Shards
			int dropNugget = rand.nextInt(3) + 1;

			for (int i = 0; i < dropNugget; ++i) {
				ItemShard.dropNugget(this, 2);
			}

			int dropNuggetAlt = rand.nextInt(3) + 1;

			for (int i = 0; i < dropNuggetAlt; ++i) {
				ItemShard.dropNugget(this, 3);
			}

			// Rare
			if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0)) {
				dropItem(GaiaItems.BOX_DIAMOND, 1);
			}

			// Unique Rare
			if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
				dropItem(Item.getItemFromBlock(GaiaBlocks.BUST_VAMPIRE), 1);
			}

			if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
				entityDropItem(new ItemStack(GaiaItems.MISC_RING, 1, 3), 0.0F);
			}
		}
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, livingdata);

		ItemStack bootsSwimming = new ItemStack(Items.LEATHER_BOOTS);
		setItemStackToSlot(EntityEquipmentSlot.FEET, bootsSwimming);
		bootsSwimming.addEnchantment(Enchantments.DEPTH_STRIDER, 2);

		return ret;
	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}

	/* IMMUNITIES */
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public boolean isPushedByWater() {
		return false;
	}

	@Override
	public void fall(float distance, float damageMultiplier) {
	}

	@Override
	public void setInWeb() {
	}
	/* IMMUNITIES */

	/* SPAWN CONDITIONS */
	@Override
	public int getMaxSpawnedInChunk() {
		return EntityAttributes.CHUNK_LIMIT_3;
	}

	@Override
	public boolean getCanSpawnHere() {
		if (GaiaConfig.SPAWN.spawnLevel3Rain) {
			return posY > ((!GaiaConfig.SPAWN.disableYRestriction) ? 60D : 0D) && world.isRaining() && super.getCanSpawnHere();
		} else {
			return posY > ((!GaiaConfig.SPAWN.disableYRestriction) ? 60D : 0D) && super.getCanSpawnHere();
		}
	}
	/* SPAWN CONDITIONS */
}
