package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.entity.GaiaLootTableList;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import gaia.items.ItemShard;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
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
import net.minecraft.init.Particles;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityGaiaVampire extends EntityMobHostileBase {

	private static final String CAN_SPAWN_TAG = "CanSpawn";

	private static final DataParameter<Boolean> CAN_SPAWN = EntityDataManager.<Boolean>createKey(EntityGaiaVampire.class, DataSerializers.BOOLEAN);

	private int spawnLimit;
	private int spawnTime;
	private boolean canSpawn;
	private boolean spawnOnDeath;

	public EntityGaiaVampire(World worldIn) {
		super(GaiaEntities.VAMPIRE, worldIn);

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
	protected void registerAttributes() {
		super.registerAttributes();
		getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.MAX_HEALTH_3);
		getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.FOLLOW_RANGE);
		getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.MOVE_SPEED_3);
		getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityAttributes.ATTACK_DAMAGE_3);
		getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.RATE_ARMOR_3);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float damage) {
		return !(source instanceof EntityDamageSourceIndirect) && super.attackEntityFrom(source, Math.min(damage, EntityAttributes.BASE_DEFENSE_3));
	}

	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
		super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_3);
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
	public void livingTick() {
		if (!onGround && motionY < 0.0D) {
			motionY *= 0.8D;
		}

		if (world.isDaytime() && !world.isRemote) {
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
				world.spawnParticle(Particles.EXPLOSION, posX + (rand.nextDouble() - 0.5D) * width, posY + rand.nextDouble() * height, posZ + (rand.nextDouble() - 0.5D) * width, 0.0D, 0.0D, 0.0D);
			}

			if (!spawnOnDeath) {
				if (!world.isRemote) {
					setSpawn((byte) 1);
				}

				spawnOnDeath = true;
			}
		} else {
			super.livingTick();
		}
	}

	@Override
	protected void registerData() {
		super.registerData();
		this.getDataManager().register(CAN_SPAWN, true);
	}

	public boolean canSpawn() {
		return ((Boolean) getDataManager().get(CAN_SPAWN)).booleanValue();
	}

	public void setSpawn(boolean canSpawn) {
		getDataManager().set(CAN_SPAWN, Boolean.valueOf(canSpawn));
	}

	@Override
	public void writeAdditional(NBTTagCompound compound) {
		super.writeAdditional(compound);
		compound.setBoolean(CAN_SPAWN_TAG, canSpawn());
	}

	@Override
	public void readAdditional(NBTTagCompound compound) {
		super.readAdditional(compound);
		if (compound.hasKey(CAN_SPAWN_TAG)) {
			boolean b0 = compound.getBoolean(CAN_SPAWN_TAG);
			setSpawn(b0);
		}
	}

	private void setSpawn(byte id) {
		EntityGaiaSummonButler butler;
		EntityBat bat;

		if (id == 0) {
			butler = new EntityGaiaSummonButler(world);
			butler.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
			butler.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(butler)), null, null);
			world.spawnEntity(butler);
		}

		if (id == 1) {
			bat = new EntityBat(world);
			bat.setLocationAndAngles(posX, posY + 1.0D, posZ, rotationYaw, 0.0F);
			bat.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(bat)), null, null);
			world.spawnEntity(bat);
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
	protected void playStepSound(BlockPos pos, IBlockState blockIn) {
		playSound(GaiaSounds.NONE, 1.0F, 1.0F);
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return GaiaLootTableList.ENTITIES_GAIA_VAMPIRE;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if ((rand.nextInt(4) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				entityDropItem(GaiaItems.FOOD_SMALL_APPLE_GOLD, 1);
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
				entityDropItem(GaiaItems.BOX_DIAMOND, 1);
			}

			// Unique Rare
			if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
				entityDropItem(GaiaBlocks.BUST_VAMPIRE, 1);
			}

			if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
				entityDropItem(new ItemStack(GaiaItems.MISC_RING_NIGHT, 1), 0.0F);
			}
		}
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData entityLivingData, NBTTagCompound itemNbt) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, entityLivingData, itemNbt);

		ItemStack bootsSwimming = new ItemStack(Items.LEATHER_BOOTS);
		setItemStackToSlot(EntityEquipmentSlot.FEET, bootsSwimming);
		bootsSwimming.addEnchantment(Enchantments.DEPTH_STRIDER, 2);

		return ret;
	}

	@Override
	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.UNDEAD;
	}

	/* IMMUNITIES */
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
	public boolean canSpawn(IWorld p_205020_1_, boolean p_205020_2_) {
		if (GaiaConfig.COMMON.spawnLevel3Rain.get()) {
			return posY > 60.0D && world.getWorld().isRaining() && super.canSpawn(world, p_205020_2_);
		} else {
			return posY > 60.0D && super.canSpawn(world, p_205020_2_);
		}
	}
	/* SPAWN CONDITIONS */
}
