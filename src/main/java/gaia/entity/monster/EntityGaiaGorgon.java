package gaia.entity.monster;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Nullable;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileDay;
import gaia.entity.ai.EntityAIGaiaAttackRangedBow;
import gaia.entity.ai.GaiaIRangedAttackMob;
import gaia.entity.ai.Ranged;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaItems;
import gaia.init.GaiaLootTables;
import gaia.init.GaiaSounds;
import gaia.items.ItemShard;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGaiaGorgon extends EntityMobHostileDay implements GaiaIRangedAttackMob {

	private static final int DETECTION_RANGE = 3;
	private static final int DETECTION_RANGE_STARE = 8;
	private static boolean isStaringRange;
	
	private boolean debugMode;

	private EntityAIGaiaAttackRangedBow aiArrowAttack = new EntityAIGaiaAttackRangedBow(this, EntityAttributes.ATTACK_SPEED_3, 20, 15.0F);
	private EntityAIAttackMelee aiAttackOnCollide = new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_3, true) {
		public void resetTask() {
			super.resetTask();
			EntityGaiaGorgon.this.setSwingingArms(false);
			isStaringRange = false;
		}

		public void startExecuting() {
			super.startExecuting();
			EntityGaiaGorgon.this.setSwingingArms(true);
		}
	};

	private static final DataParameter<Boolean> SWINGING_ARMS = EntityDataManager.<Boolean>createKey(EntityGaiaGorgon.class, DataSerializers.BOOLEAN);
	private static final ItemStack TIPPED_ARROW_CUSTOM = PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), PotionTypes.SLOWNESS);
	private static final ItemStack TIPPED_ARROW_CUSTOM_2 = PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), PotionTypes.WEAKNESS);

	private int timer;
	private int switchDetect;
	private int switchEquip;

	private byte inWaterTimer;

	public EntityGaiaGorgon(World worldIn) {
		super(worldIn);

		experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
		stepHeight = 6.0F;
		isImmuneToFire = true;

		setPathPriority(PathNodeType.WATER, 8.0F);

		timer = 0;
		switchDetect = 0;
		switchEquip = 0;

		inWaterTimer = 0;
		
		debugMode = false;
	}

	@Override
	protected int getFireImmuneTicks() {
		return 10;
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAISwimming(this));

		tasks.addTask(2, new EntityAIWander(this, 1.0D));
		tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		tasks.addTask(3, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		targetTasks.addTask(3, new EntityGaiaGorgon.AIFindPlayer(this));
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
					byte0 = 5;
				} else if (world.getDifficulty() == EnumDifficulty.HARD) {
					byte0 = 10;
				}

				if (byte0 > 0) {
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, byte0 * 20, 1));
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

		if (!world.isRemote) {
			if (isWet()) {
				if (inWaterTimer <= 100) {
					++inWaterTimer;
				} else {
					world.setEntityState(this, (byte) 8);
					heal(EntityAttributes.MAX_HEALTH_3 * 0.10F);
					addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 5 * 20, 0));
					inWaterTimer = 0;
				}
			}
		}

		if (playerDetection(DETECTION_RANGE)) {
			if (switchDetect == 0) {
				switchDetect = 1;
			}
		} else {
			if (switchDetect == 1) {
				switchDetect = 0;
			}
		}

		if (playerDetection(DETECTION_RANGE_STARE)) {
			if (!isStaringRange) {
				isStaringRange = true;
//				System.out.println("Stare");
			}
		} else {
			if (isStaringRange) {
				isStaringRange = false;
//				System.out.println("Shy?");
			}
		}

		if (switchDetect == 1 && switchEquip == 0) {
			if (timer <= 20) {
				++timer;
			} else {
				if (!isPotionActive(MobEffects.SPEED)) {
					addPotionEffect(new PotionEffect(MobEffects.SPEED, 10 * 20, 0));
				}
				setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_DAGGER_METAL));
				setAI((byte) 1);
				timer = 0;
				switchEquip = 1;
			}
		}

		if (switchDetect == 0 && switchEquip == 1) {
			if (timer <= 20) {
				++timer;
			} else {
				if (isPotionActive(MobEffects.SPEED)) {
					removePotionEffect(MobEffects.SPEED);
				}
				setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
				setAI((byte) 0);
				timer = 0;
				switchEquip = 0;
			}
		}

		super.onLivingUpdate();
	}

	private boolean shouldAttackPlayer(EntityPlayer player) {
		Vec3d vec3d = player.getLook(1.0F).normalize();
		Vec3d vec3d1 = new Vec3d(this.posX - player.posX, this.getEntityBoundingBox().minY + (double) this.getEyeHeight() - (player.posY + (double) player.getEyeHeight()), this.posZ - player.posZ);
		double d0 = vec3d1.length();
		vec3d1 = vec3d1.normalize();
		double d1 = vec3d.dotProduct(vec3d1);
		return d1 > 1.0D - 0.025D / d0 ? player.canEntityBeSeen(this) : false;

	}

	static class AIFindPlayer extends EntityAINearestAttackableTarget<EntityPlayer> {
		private final EntityGaiaGorgon targetLooked;
		/** The player */
		private EntityPlayer player;
		private int stareTime;

		public AIFindPlayer(EntityGaiaGorgon p_i45842_1_) {
			super(p_i45842_1_, EntityPlayer.class, false);
			this.targetLooked = p_i45842_1_;
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute() {
			double d0 = this.getTargetDistance();
			this.player = this.targetLooked.world.getNearestAttackablePlayer(this.targetLooked.posX, this.targetLooked.posY, this.targetLooked.posZ, d0, d0, (Function) null, new Predicate<EntityPlayer>() {
				public boolean apply(@Nullable EntityPlayer p_apply_1_) {
					return p_apply_1_ != null && AIFindPlayer.this.targetLooked.shouldAttackPlayer(p_apply_1_);
				}
			});
			return this.player != null;
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			if (isStaringRange) {
				++stareTime;
//				System.out.println(stareTime);
				
				if (stareTime >= 20) {
					player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 200, 5));
					stareTime = 0;
				}
			}
		}

		/**
		 * Reset the task's internal state. Called when this task is interrupted by another one
		 */
		public void resetTask() {
			this.player = null;
			super.resetTask();
		}
	}

	private void setAI(byte id) {
		if (id == 0) {
			tasks.removeTask(aiAttackOnCollide);
			tasks.addTask(1, aiArrowAttack);
		}

		if (id == 1) {
			tasks.removeTask(aiArrowAttack);
			tasks.addTask(1, aiAttackOnCollide);
		}
	}

	private void setCombatTask() {
		tasks.removeTask(aiAttackOnCollide);
		tasks.removeTask(aiArrowAttack);
		ItemStack itemstack = getHeldItemMainhand();

		if (itemstack.getItem() == Items.BOW) {
			int i = 20;

			if (this.world.getDifficulty() != EnumDifficulty.HARD) {
				i = 40;
			}

			aiArrowAttack.setAttackCooldown(i);
			setAI((byte) 0);
		} else {
			setAI((byte) 1);
		}
	}

	/**
	 * Detects if there are any EntityPlayer nearby
	 */
	private boolean playerDetection(int range) {
		AxisAlignedBB axisalignedbb = (new AxisAlignedBB(posX, posY, posZ, posX + 1, posY + 1, posZ + 1)).grow(range);
		List<EntityPlayer> list = world.getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);

		return !list.isEmpty();
	}

	/* ARCHER DATA */
	@Override
	public boolean canAttackClass(Class<? extends EntityLivingBase> cls) {
		return super.canAttackClass(cls) && cls != EntityGaiaGorgon.class;
	}

	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
		if (!target.isDead) {
			Ranged.rangedAttack(target, this, distanceFactor);
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean isSwingingArms() {
		return ((Boolean) this.dataManager.get(SWINGING_ARMS)).booleanValue();
	}

	public void setSwingingArms(boolean swingingArms) {
		dataManager.set(SWINGING_ARMS, Boolean.valueOf(swingingArms));
	}
	/* ARCHER DATA */

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaSounds.GORGON_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaSounds.GORGON_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.GORGON_DEATH;
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return GaiaLootTables.ENTITIES_GAIA_GORGON;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if ((rand.nextInt(4) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				dropItem(GaiaItems.FOOD_SMALL_APPLE_GOLD, 1);
			}

			// Nuggets/Shards
			int dropNugget = rand.nextInt(GaiaConfig.DROPS.maxNuggetCount) + 1;

			for (int i = 0; i < dropNugget; ++i) {
				ItemShard.dropNugget(this, 2);
			}

			int dropNuggetAlt = rand.nextInt(GaiaConfig.DROPS.maxNuggetCount) + 1;

			for (int i = 0; i < dropNuggetAlt; ++i) {
				ItemShard.dropNugget(this, 3);
			}

			// Rare
			if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0)) {
				dropItem(GaiaItems.BOX_DIAMOND, 1);
			}

			// Unique Rare
			if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
				dropItem(GaiaItems.BAG_ARROW, 1);
			}

			if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
				dropItem(Item.getItemFromBlock(GaiaBlocks.BUST_GORGON), 1);
			}
		}
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, livingdata);
		
		setCustomNameTag("WIP");
		
		if (!debugMode) {
			System.out.println("Disabled.");
			setDead();
		}

		setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
		setEnchantmentBasedOnDifficulty(difficulty);

		ItemStack bootsSwimming = new ItemStack(Items.LEATHER_BOOTS);
		setItemStackToSlot(EntityEquipmentSlot.FEET, bootsSwimming);
		bootsSwimming.addEnchantment(Enchantments.DEPTH_STRIDER, 2);

		if (world.rand.nextInt(2) == 0) {
			if (world.rand.nextInt(2) == 0) {
				setItemStackToSlot(EntityEquipmentSlot.OFFHAND, TIPPED_ARROW_CUSTOM);
			} else {
				setItemStackToSlot(EntityEquipmentSlot.OFFHAND, TIPPED_ARROW_CUSTOM_2);
			}
		}

		setCombatTask();

		return ret;
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

	@Override
	public boolean isPotionApplicable(PotionEffect potioneffectIn) {
		return potioneffectIn.getPotion() == MobEffects.POISON ? false : super.isPotionApplicable(potioneffectIn);
	}
	/* IMMUNITIES */

	/* ALTERNATE SKIN */
	@Override
	protected void entityInit() {
		super.entityInit();
		dataManager.register(SWINGING_ARMS, Boolean.valueOf(false));
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);

		setCombatTask();
	}
	/* ALTERNATE SKIN */

	/* SPAWN CONDITIONS */
	@Override
	public int getMaxSpawnedInChunk() {
		return EntityAttributes.CHUNK_LIMIT_3;
	}

	@Override
	public boolean getCanSpawnHere() {
		return posY > ((!GaiaConfig.SPAWN.disableYRestriction) ? 60D : 0D) && super.getCanSpawnHere();
	}
	/* SPAWN CONDITIONS */
}
