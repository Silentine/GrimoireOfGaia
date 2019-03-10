package gaia.entity.monster;

import java.util.List;

import javax.annotation.Nullable;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.entity.GaiaLootTableList;
import gaia.entity.ai.Ranged;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import gaia.items.ItemShard;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

public class EntityGaiaAnubis extends EntityMobHostileBase implements IRangedAttackMob {
	private static final DataParameter<Boolean> MALE = EntityDataManager.<Boolean>createKey(EntityGaiaAnubis.class, DataSerializers.BOOLEAN);

	private EntityAIAttackRanged aiArrowAttack = new EntityAIAttackRanged(this, EntityAttributes.ATTACK_SPEED_2, 20, 60, 15.0F);
	private EntityAIAttackMelee aiAttackOnCollide = new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_2, true);

	private int switchHealth;
	private int spawn;
	private int spawnTimer;

	private boolean animationPlay;
	private int animationTimer;

	private boolean canSpawnLevel3;
	private boolean spawned;
	private int spawnLevel3;
	private int spawnLevel3Chance;

	public EntityGaiaAnubis(World worldIn) {
		super(GaiaEntities.ANUBIS, worldIn);

		experienceValue = EntityAttributes.EXPERIENCE_VALUE_2;
		stepHeight = 1.0F;

		switchHealth = 0;
		spawn = 0;
		spawnTimer = 0;

		animationPlay = false;
		animationTimer = 0;

		canSpawnLevel3 = false;
		spawned = false;
		spawnLevel3 = 0;
		spawnLevel3Chance = 0;
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAISwimming(this));

		tasks.addTask(2, new EntityAIWander(this, 1.0D));
		tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		tasks.addTask(4, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
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
		if (damage > EntityAttributes.BASE_DEFENSE_2) {
			if (canSpawnLevel3) {
				spawnLevel3Chance += (int) (GaiaConfig.COMMON.spawnLevel3Chance.get() * 0.05);
			}
		}

		return super.attackEntityFrom(source, Math.min(damage, EntityAttributes.BASE_DEFENSE_2));
	}

	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
		super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_2);
	}

	/* RANGED DATA */
	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
		Ranged.magic(target, this, distanceFactor);

		setEquipment((byte) 1);
		animationPlay = true;
		animationTimer = 0;
	}

	@Override
	public boolean canAttackClass(Class<? extends EntityLivingBase> cls) {
		return super.canAttackClass(cls) && cls != EntityGaiaAnubis.class;
	}
	/* RANGED DATA */

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		if (super.attackEntityAsMob(entityIn)) {
			if (entityIn instanceof EntityLivingBase) {
				byte byte0 = 0;
				byte byte1 = 0;

				if (world.getDifficulty() == EnumDifficulty.NORMAL) {
					byte0 = 5;
					byte1 = 5;
				} else if (world.getDifficulty() == EnumDifficulty.HARD) {
					byte0 = 10;
					byte1 = 10;
				}

				if (byte0 > 0) {
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, byte0 * 20, 0));
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, byte1 * 20, 0));
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
		beaconMonster();

		if ((getHealth() < EntityAttributes.MAX_HEALTH_2 * 0.75F) && (switchHealth == 0)) {
			setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_DAGGER_METAL));
			setAI((byte) 1);
			switchHealth = 1;
		}

		if ((getHealth() > EntityAttributes.MAX_HEALTH_2 * 0.75F) && (switchHealth == 1)) {
			setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_BLAZE, 1));
			setAI((byte) 0);
			switchHealth = 0;
		}

		if (getHealth() < EntityAttributes.MAX_HEALTH_2 * 0.75F && getHealth() > 0.0F && spawn == 0) {
			setEquipment((byte) 2);

			if (spawnTimer != 30) {
				spawnTimer += 1;
			}

			if (spawnTimer == 30) {
				world.setEntityState(this, (byte) 9);
				setEquipment((byte) 0);

				if (!world.isRemote) {
					setSpawn((byte) 0);
				}

				spawnTimer = 0;
				spawn = 1;
			}
		}

		if (getHealth() < EntityAttributes.MAX_HEALTH_2 * 0.25F && getHealth() > 0.0F && spawn == 1) {
			setEquipment((byte) 2);

			if (spawnTimer != 30) {
				spawnTimer += 1;
			}

			if (spawnTimer == 30) {
				world.setEntityState(this, (byte) 9);
				setEquipment((byte) 0);

				if (!world.isRemote) {
					setSpawn((byte) 0);
				}

				/* LEVEL 3 SPAWN DATA */
				if (canSpawnLevel3) {
					if (getHealth() < EntityAttributes.MAX_HEALTH_2 * 0.25F && getHealth() > 0.0F && !spawned) {

						if (spawnLevel3Chance > (int) (GaiaConfig.COMMON.spawnLevel3Chance.get() * 0.5)) {
							spawnLevel3Chance = (int) (GaiaConfig.COMMON.spawnLevel3Chance.get() * 0.5);
						}

						if ((rand.nextInt(GaiaConfig.COMMON.spawnLevel3Chance.get() - spawnLevel3Chance) == 0 || rand.nextInt(1) > 0)) {
							spawnLevel3 = 1;
						}

						spawned = true;
					}
				}
				/* LEVEL 3 SPAWN DATA */

				spawnTimer = 0;
				spawn = 2;
			}
		}

		if (animationPlay) {
			if (animationTimer != 20) {
				animationTimer += 1;
			} else {
				setEquipment((byte) 0);
				animationPlay = false;
			}
		}

		/* LEVEL 3 SPAWN DATA */
		if ((GaiaConfig.COMMON.spawnLevel3.get() && (GaiaConfig.COMMON.spawnLevel3Chance.get() != 0)) && !canSpawnLevel3) {
			canSpawnLevel3 = true;
		}

		if (spawnLevel3 == 1) {
			world.setEntityState(this, (byte) 10);

			attackEntityFrom(DamageSource.GENERIC, EntityAttributes.MAX_HEALTH_2 * 0.01F);
		}
		/* LEVEL 3 SPAWN DATA */

		super.livingTick();
	}

	private void setAI(byte id) {
		if (id == 0) {
			tasks.removeTask(aiAttackOnCollide);
			tasks.addTask(2, aiArrowAttack);
			
			setEquipment((byte) 0);
			animationPlay = false;
			animationTimer = 0;
		}

		if (id == 1) {
			tasks.removeTask(aiArrowAttack);
			tasks.addTask(1, aiAttackOnCollide);
		}
	}

	private void setEquipment(byte id) {
		if (id == 0) {
			setItemStackToSlot(EntityEquipmentSlot.HEAD, ItemStack.EMPTY);
		}

		if (id == 1) {
			setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.ARROW));
		}

		if (id == 2) {
			setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.STICK));
		}
	}
	
	private void setBodyType(String id) {
		if (id == "none") {
			setItemStackToSlot(EntityEquipmentSlot.CHEST, ItemStack.EMPTY);
		}

		if (id == "male") {
			setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.STICK));
		}
	}

	private void setSpawn(byte id) {
		EntitySkeleton skeleton;
		EntityGaiaSphinx sphinx;

		if (id == 0) {
			skeleton = new EntitySkeleton(world);
			skeleton.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
			skeleton.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(skeleton)), null, null);
			skeleton.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(GaiaItems.ACCESSORY_HEADGEAR_MOB, 1));
			skeleton.setDropChance(EntityEquipmentSlot.MAINHAND, 0);
			skeleton.setDropChance(EntityEquipmentSlot.OFFHAND, 0);
			skeleton.setDropChance(EntityEquipmentSlot.FEET, 0);
			skeleton.setDropChance(EntityEquipmentSlot.LEGS, 0);
			skeleton.setDropChance(EntityEquipmentSlot.CHEST, 0);
			skeleton.setDropChance(EntityEquipmentSlot.HEAD, 0);
			world.spawnEntity(skeleton);
		}

		if (id == 1) {
			explode();

			sphinx = new EntityGaiaSphinx(world);
			sphinx.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
			sphinx.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(sphinx)), null, null);
			world.spawnEntity(sphinx);
		}
	}
	
	private void setCombatTask() {
		tasks.removeTask(aiAttackOnCollide);
		tasks.removeTask(aiArrowAttack);
		
		ItemStack itemstack = getHeldItemMainhand();
		if (itemstack.getItem() == GaiaItems.WEAPON_PROP_BLAZE) {
			setAI((byte) 0);
		} else {
			setAI((byte) 1);
		}
	}

	private void beaconMonster() {
		if (!world.isRemote) {
			AxisAlignedBB axisalignedbb = (new AxisAlignedBB(posX, posY, posZ, posX + 1, posY + 1, posZ + 1)).grow(6D);

			List<EntityLivingBase> moblist = world.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);

			for (EntityLivingBase mob : moblist) {
				if (mob instanceof EntityZombie || mob instanceof EntitySkeleton) {
					mob.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 300, 1, true, true));
				}
			}
		}
	}

	private void explode() {
		if (!this.world.isRemote) {
			boolean flag = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this);
			int explosionRadius = 2;

			this.dead = true;
			this.world.createExplosion(this, this.posX, this.posY, this.posZ, (float) explosionRadius, flag);
			this.remove();
		}
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaSounds.ANUBIS_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaSounds.ANUBIS_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.ANUBIS_DEATH;
	}

	@Override
	protected void dropLoot(boolean wasRecentlyHit, int lootingModifier, DamageSource source) {
		super.dropLoot(wasRecentlyHit, lootingModifier, source);

		dropFewItems(wasRecentlyHit, lootingModifier);
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		switch (rand.nextInt(2)) {
			case 0:
				return GaiaLootTableList.ENTITIES_GAIA_ANUBIS;
			case 1:
				return LootTableList.ENTITIES_WITCH;
			default:
				return GaiaLootTableList.ENTITIES_GAIA_ANUBIS;
		}
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
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
				entityDropItem(GaiaItems.MISC_BOOK, 1);
			}
			
			// Unique Rare
			if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
				entityDropItem(GaiaItems.SPAWN_WERESHEEP, 1);
			}
		}

		// Boss
		if (spawnLevel3 == 1) {
			setSpawn((byte) 1);
		}
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData entityLivingData, NBTTagCompound itemNbt) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, entityLivingData, itemNbt);

		if (world.rand.nextInt(4) == 0) {
			dataManager.set(MALE, Boolean.valueOf(true));
			setBodyType("male");
		}

		setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_BLAZE, 1));

		if (GaiaConfig.COMMON.spawnLevel3.get() && (GaiaConfig.COMMON.spawnLevel3Chance.get() != 0)) {
			canSpawnLevel3 = true;
		}
		
		setCombatTask();

		return ret;
	}

	/* IMMUNITIES */
	@Override
	protected int getFireImmuneTicks() {
		return 10;
	}
	/* IMMUNITIES */
	
	/* ALTERNATE SKIN */
	@Override
	protected void registerData() {
		super.registerData();
		this.getDataManager().register(MALE, Boolean.valueOf(false));
	}
	
	public boolean isMale() {
		return ((Boolean) this.dataManager.get(MALE)).booleanValue();
	}

	public void writeAdditional(NBTTagCompound compound) {
		super.writeAdditional(compound);
		compound.setBoolean("male", isMale());
	}

	public void readAdditional(NBTTagCompound compound) {
		super.readAdditional(compound);
		dataManager.set(MALE, Boolean.valueOf(compound.getBoolean("male")));
		
		setCombatTask();
	}

	/* ALTERNATE SKIN */

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
