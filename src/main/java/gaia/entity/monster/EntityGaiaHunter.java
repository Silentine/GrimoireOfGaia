package gaia.entity.monster;

import java.util.List;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobAssistDay;
import gaia.entity.GaiaLootTableList;
import gaia.entity.ai.EntityAIGaiaAttackRangedBow;
import gaia.entity.ai.EntityAIGaiaValidateTargetPlayer;
import gaia.entity.ai.GaiaIRangedAttackMob;
import gaia.entity.ai.Ranged;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import gaia.items.ItemShard;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class EntityGaiaHunter extends EntityMobAssistDay implements GaiaIRangedAttackMob {

	private static final int DETECTION_RANGE = 3;

	private EntityAIGaiaAttackRangedBow aiArrowAttack = new EntityAIGaiaAttackRangedBow(this, EntityAttributes.ATTACK_SPEED_1, 20, 15.0F);
	private EntityAIAttackMelee aiAttackOnCollide = new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_1, true) {
		public void resetTask() {
			super.resetTask();
			EntityGaiaHunter.this.setSwingingArms(false);
		}

		public void startExecuting() {
			super.startExecuting();
			EntityGaiaHunter.this.setSwingingArms(true);
		}
	};

	private static final DataParameter<Boolean> SWINGING_ARMS = EntityDataManager.<Boolean>createKey(EntityGaiaHunter.class, DataSerializers.BOOLEAN);
	private static final ItemStack TIPPED_ARROW_CUSTOM = PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), PotionTypes.POISON);

	private int timer;
	private int switchDetect;
	private int switchEquip;

	private boolean isFriendly;

	public EntityGaiaHunter(World worldIn) {
		super(GaiaEntities.HUNTER, worldIn);

		experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
		stepHeight = 1.0F;

		timer = 0;
		switchDetect = 0;
		switchEquip = 0;
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAISwimming(this));

		tasks.addTask(2, new EntityAIWander(this, 1.0D));
		tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		tasks.addTask(3, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		targetTasks.addTask(2, new EntityAIGaiaValidateTargetPlayer(this));
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.MAX_HEALTH_1);
		getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.FOLLOW_RANGE);
		getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.MOVE_SPEED_1);
		getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityAttributes.ATTACK_DAMAGE_1);
		getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.RATE_ARMOR_1);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float damage) {
		return super.attackEntityFrom(source, Math.min(damage, EntityAttributes.BASE_DEFENSE_1));
	}

	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
		super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_1);
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
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.POISON, byte0 * 20, 0));
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isTameable() {
		return true;
	}

	@Override
	public boolean isAIDisabled() {
		return false;
	}

	@Override
	public void livingTick() {
		/* TODO Fix archers from attacking same spot despite target already being eliminated */
		if (isFriendly() && !isFriendly) {
			setAI((byte) 1);
			timer = 0;
			switchEquip = 1;
			setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_SWORD_WOOD));
			setItemStackToSlot(EntityEquipmentSlot.OFFHAND, ItemStack.EMPTY);
			isFriendly = true;
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

				if (!isFriendly()) {
					setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
					setAI((byte) 0);
				} else {
					setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_SWORD_WOOD));
					setAI((byte) 1);
				}

				timer = 0;
				switchEquip = 0;
			}
		}

		super.livingTick();
	}

	private void setAI(byte id) {
		if (id == 0) {
			if (!isFriendly()) {
				tasks.removeTask(aiAttackOnCollide);
				tasks.addTask(1, aiArrowAttack);
			}
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
		return super.canAttackClass(cls) && cls != EntityGaiaHunter.class;
	}

	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
		if (target.isAlive()) {
			Ranged.rangedAttack(target, this, distanceFactor);
		}
	}

	@Override
	protected void registerData() {
		super.registerData();
		this.getDataManager().register(SWINGING_ARMS, Boolean.valueOf(false));
	}

	@OnlyIn(Dist.CLIENT)
	public boolean isSwingingArms() {
		return ((Boolean) this.dataManager.get(SWINGING_ARMS)).booleanValue();
	}

	public void setSwingingArms(boolean swingingArms) {
		dataManager.set(SWINGING_ARMS, Boolean.valueOf(swingingArms));
	}
	/* ARCHER DATA */

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaSounds.HUNTER_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaSounds.HUNTER_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.HUNTER_DEATH;
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return GaiaLootTableList.ENTITIES_GAIA_HUNTER;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				entityDropItem(GaiaItems.FOOD_ROTTEN_HEART, 1);
			}

			// Nuggets/Fragments
			int dropNugget = rand.nextInt(3) + 1;

			for (int i = 0; i < dropNugget; ++i) {
				entityDropItem(Items.IRON_NUGGET, 1);
			}

			if (GaiaConfig.COMMON.additionalOre.get()) {
				int dropNuggetAlt = rand.nextInt(3) + 1;

				for (int i = 0; i < dropNuggetAlt; ++i) {
					ItemShard.dropNugget(this, 4);
				}
			}

			// Rare
			if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0)) {
				entityDropItem(GaiaItems.BOX_IRON, 1);
			}

			// Unique Rare
			if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
				entityDropItem(GaiaItems.BAG_ARROW, 1);
			}
		}
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData entityLivingData, NBTTagCompound itemNbt) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, entityLivingData, itemNbt);

		setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
		setEnchantmentBasedOnDifficulty(difficulty);

		if (world.rand.nextInt(2) == 0) {
			setItemStackToSlot(EntityEquipmentSlot.OFFHAND, TIPPED_ARROW_CUSTOM);
		}

		setCombatTask();

		return ret;
	}

	@Override
	public void readAdditional(NBTTagCompound compound) {
		super.readAdditional(compound);

		setCombatTask();
	}

	/* SPAWN CONDITIONS */
	@Override
	public int getMaxSpawnedInChunk() {
		return EntityAttributes.CHUNK_LIMIT_1;
	}

	@Override
	public boolean canSpawn(IWorld p_205020_1_, boolean p_205020_2_) {
		return posY > 60.0D && super.canSpawn(world, p_205020_2_);
	}
	/* SPAWN CONDITIONS */
}
