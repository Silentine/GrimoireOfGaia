package gaia.entity.monster;

import java.util.List;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileDay;
import gaia.entity.GaiaLootTableList;
import gaia.entity.ai.EntityAIGaiaAttackRangedBow;
import gaia.entity.ai.GaiaIRangedAttackMob;
import gaia.entity.ai.Ranged;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import gaia.items.ItemShard;
import net.minecraft.enchantment.EnchantmentData;
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
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemEnchantedBook;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class EntityGaiaSelkie extends EntityMobHostileDay implements GaiaIRangedAttackMob {

	private static final int DETECTION_RANGE = 3;

	private EntityAIGaiaAttackRangedBow aiArrowAttack = new EntityAIGaiaAttackRangedBow(this, EntityAttributes.ATTACK_SPEED_1, 20, 15.0F);
	private EntityAIAttackMelee aiAttackOnCollide = new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_1, true) {
		public void resetTask() {
			super.resetTask();
			EntityGaiaSelkie.this.setSwingingArms(false);
		}

		public void startExecuting() {
			super.startExecuting();
			EntityGaiaSelkie.this.setSwingingArms(true);
		}
	};

	private static final DataParameter<Boolean> SWINGING_ARMS = EntityDataManager.createKey(EntityGaiaSelkie.class, DataSerializers.BOOLEAN);
	private static final ItemStack TIPPED_ARROW_CUSTOM = PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), PotionTypes.SLOWNESS);
	private static final ItemStack TIPPED_ARROW_CUSTOM_2 = PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), PotionTypes.WEAKNESS);

	private int timer;
	private int switchDetect;
	private int switchEquip;

	public EntityGaiaSelkie(World worldIn) {
		super(GaiaEntities.SELKIE, worldIn);

		experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
		stepHeight = 1.0F;

		timer = 0;
		switchDetect = 0;
		switchEquip = 0;
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
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, byte0 * 30, 1));
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
				setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
				setAI((byte) 0);
				timer = 0;
				switchEquip = 0;
			}
		}

		if (!this.world.isRemote) {
			int i = MathHelper.floor(this.posX);
			int j = MathHelper.floor(this.posY);
			int k = MathHelper.floor(this.posZ);

			if (this.world.getBiome(new BlockPos(i, 0, k)).getTemperature(new BlockPos(i, j, k)) > 1.0F) {
				addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 0));
				addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 100, 0));
			}
		}

		super.livingTick();
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
		return super.canAttackClass(cls) && cls != EntityGaiaSelkie.class;
	}

	@Override
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
		return GaiaSounds.SELKIE_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaSounds.SELKIE_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.SELKIE_DEATH;
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return GaiaLootTableList.ENTITIES_GAIA_SELKIE;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				entityDropItem(GaiaItems.MISC_FUR, 1);
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

			if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
				ItemStack enchantmentBook = new ItemStack(Items.ENCHANTED_BOOK);
				ItemEnchantedBook.addEnchantment(enchantmentBook, new EnchantmentData(Enchantments.LURE, 1));
				entityDropItem(enchantmentBook, 1);
			}
		}
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData entityLivingData, NBTTagCompound itemNbt) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, entityLivingData, itemNbt);

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

	/* ARCHER DATA */
	@Override
	public boolean isPushedByWater() {
		return false;
	}
	/* ARCHER DATA */

	@Override
	public void readAdditional(NBTTagCompound compound) {
		super.readAdditional(compound);

		setCombatTask();
	}

	/* SPAWN CONDITIONS */
	@Override
	public int getMaxSpawnedInChunk() {
		return 4;
	}

	@Override
	public boolean canSpawn(IWorld p_205020_1_, boolean p_205020_2_) {
		return posY > 60.0D && super.canSpawn(world, p_205020_2_);
	}
	/* SPAWN CONDITIONS */
}
