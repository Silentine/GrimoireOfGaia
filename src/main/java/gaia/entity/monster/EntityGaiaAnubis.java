package gaia.entity.monster;

import java.util.List;

import javax.annotation.Nullable;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.entity.ai.Ranged;
import gaia.init.GaiaItems;
import gaia.init.GaiaLootTables;
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

	public EntityGaiaAnubis(World worldIn) {
		super(worldIn);

		experienceValue = EntityAttributes.EXPERIENCE_VALUE_2;
		stepHeight = 1.0F;

		switchHealth = 0;
		spawn = 0;
		spawnTimer = 0;

		animationPlay = false;
		animationTimer = 0;
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
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.MAX_HEALTH_2);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.FOLLOW_RANGE);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.MOVE_SPEED_2);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityAttributes.ATTACK_DAMAGE_2);
		getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.RATE_ARMOR_2);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float damage) {
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
	public void onLivingUpdate() {
		beaconMonster();

		if ((getHealth() < EntityAttributes.MAX_HEALTH_2 * 0.75F) && (switchHealth == 0)) {
			setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_DAGGER_METAL));
			setAI((byte) 1);
			switchHealth = 1;
		}

		if ((getHealth() > EntityAttributes.MAX_HEALTH_2 * 0.75F) && (switchHealth == 1)) {
			setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP, 1, 0));
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

		super.onLivingUpdate();
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
		BlockPos blockpos = (new BlockPos(EntityGaiaAnubis.this)).add(-1 + EntityGaiaAnubis.this.rand.nextInt(3), 1, -1 + EntityGaiaAnubis.this.rand.nextInt(3));

		if (id == 0) {
			EntitySkeleton entitySpawn = new EntitySkeleton(EntityGaiaAnubis.this.world);
			entitySpawn.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
			entitySpawn.onInitialSpawn(EntityGaiaAnubis.this.world.getDifficultyForLocation(blockpos), (IEntityLivingData) null);
			entitySpawn.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(GaiaItems.ACCESSORY_HEADGEAR_MOB));
			entitySpawn.setDropChance(EntityEquipmentSlot.MAINHAND, 0);
			entitySpawn.setDropChance(EntityEquipmentSlot.OFFHAND, 0);
			entitySpawn.setDropChance(EntityEquipmentSlot.FEET, 0);
			entitySpawn.setDropChance(EntityEquipmentSlot.LEGS, 0);
			entitySpawn.setDropChance(EntityEquipmentSlot.CHEST, 0);
			entitySpawn.setDropChance(EntityEquipmentSlot.HEAD, 0);
			EntityGaiaAnubis.this.world.spawnEntity(entitySpawn);
		}
	}

	private void setCombatTask() {
		tasks.removeTask(aiAttackOnCollide);
		tasks.removeTask(aiArrowAttack);

		ItemStack itemstack = getHeldItemMainhand();
		if (itemstack.getItem() == GaiaItems.WEAPON_PROP) {
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
			this.setDead();
		}
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return !isMale() ? GaiaSounds.ANUBIS_SAY : GaiaSounds.ANUBIS_MALE_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return !isMale() ? GaiaSounds.ANUBIS_HURT : GaiaSounds.ANUBIS_MALE_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return !isMale() ? GaiaSounds.ANUBIS_DEATH : GaiaSounds.ANUBIS_MALE_DEATH;
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		switch (rand.nextInt(2)) {
		case 0:
			return GaiaLootTables.ENTITIES_GAIA_ANUBIS;
		case 1:
			return LootTableList.ENTITIES_WITCH;
		default:
			return GaiaLootTables.ENTITIES_GAIA_ANUBIS;
		}
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			// Nuggets/Fragments
			int dropNugget = rand.nextInt(GaiaConfig.DROPS.maxNuggetCount) + 1;

			for (int i = 0; i < dropNugget; ++i) {
				dropItem(Items.GOLD_NUGGET, 1);
			}

			if (GaiaConfig.DROPS.additionalOre) {
				int dropNuggetAlt = rand.nextInt(GaiaConfig.DROPS.maxNuggetCount) + 1;

				for (int i = 0; i < dropNuggetAlt; ++i) {
					ItemShard.dropNugget(this, 5);
				}
			}

			// Rare
			if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0)) {
				switch (rand.nextInt(2)) {
				case 0:
					dropItem(GaiaItems.BOX_GOLD, 1);
				case 1:
					dropItem(GaiaItems.BAG_BOOK, 1);
				}
			}

			// Unique Rare
			if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
				dropItem(GaiaItems.MISC_BOOK, 1);
			}

			// Unique Rare
			if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
				dropItem(GaiaItems.SPAWN_WERESHEEP, 1);
			}
		}
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, livingdata);

		if (world.rand.nextInt(4) == 0) {
			dataManager.set(MALE, Boolean.valueOf(true));
			setBodyType("male");
		}

		setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP, 1, 0));

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
	protected void entityInit() {
		super.entityInit();
		dataManager.register(MALE, Boolean.valueOf(false));
	}

	public boolean isMale() {
		return ((Boolean) this.dataManager.get(MALE)).booleanValue();
	}

	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setBoolean("male", isMale());
	}

	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
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
	public boolean getCanSpawnHere() {
		return posY > ((!GaiaConfig.SPAWN.disableYRestriction) ? 60D : 0D) && super.getCanSpawnHere();
	}
	/* SPAWN CONDITIONS */
}
