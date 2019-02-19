package gaia.entity.monster;

import java.util.List;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileDay;
import gaia.entity.ai.Ranged;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import gaia.items.ItemShard;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityGaiaAntRanger extends EntityMobHostileDay implements IRangedAttackMob {

	private static final DataParameter<Boolean> HIDDING = EntityDataManager.<Boolean>createKey(EntityGaiaAntRanger.class, DataSerializers.BOOLEAN);

	private static final int DETECTION_RANGE = 4;

	private EntityAIAttackRanged aiArrowAttack = new EntityAIAttackRanged(this, EntityAttributes.ATTACK_SPEED_1, 20, 60, 15.0F);

	private boolean canHide;

	public EntityGaiaAntRanger(World worldIn) {
		super(GaiaEntities.ANT_RANGER, worldIn);

		setSize(0.50F, 0.5F);
		experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
		stepHeight = 1.0F;

		canHide = false;
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		tasks.addTask(3, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.MAX_HEALTH_1);
		getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.FOLLOW_RANGE * 0.5);
		getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(-0.25F);
		getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityAttributes.ATTACK_DAMAGE_1);
		getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.RATE_ARMOR_1);

		getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.00D);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float damage) {
		if (getHidding()) {
			return false;
		} else {
			return super.attackEntityFrom(source, Math.min(damage, EntityAttributes.BASE_DEFENSE_1));
		}
	}

	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
		super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_1);
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
		Ranged.poison(target, this, distanceFactor);
	}

	@Override
	public boolean isAIDisabled() {
		return false;
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
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, byte0 * 20));
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, byte0 * 20));
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	public void livingTick() {
		if (ticksExisted % 60 == 0 && !canHide) {
			canHide = true;
		}

		if (playerDetection(DETECTION_RANGE)) {
//			if (!getHidding()) {
//				world.setEntityState(this, (byte) 12);
//				setAI((byte) 1);
//				setHidding(true);
//			}

			if (canHide) {
				if (!isPotionActive(MobEffects.INVISIBILITY)) {
					world.setEntityState(this, (byte) 12);
					setAI((byte) 1);
					addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 480 * 20, 0));
					setHidding(true);
				}

				if (!(this.onGround)) {
					world.setEntityState(this, (byte) 11);
					remove();
				}
			}
		} else {
//			if (getHidding()) {
//				world.setEntityState(this, (byte) 12);
//				setAI((byte) 0);
//				setHidding(false);
//			}

			if (isPotionActive(MobEffects.INVISIBILITY)) {
				world.setEntityState(this, (byte) 12);
				setAI((byte) 0);
				removePotionEffect(MobEffects.INVISIBILITY);
				setHidding(false);
			}
		}

		super.livingTick();
	}

	private void setAI(byte id) {
		if (id == 0) {
			tasks.addTask(1, aiArrowAttack);
		}

		if (id == 1) {
			tasks.removeTask(aiArrowAttack);
		}
	}

	private void setCombatTask() {
		if (!getHidding()) {
			setAI((byte) 0);
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

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaSounds.ANTRANGER_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaSounds.ANTRANGER_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.ANTRANGER_DEATH;
	}

	@Override
	protected void playStepSound(BlockPos pos, IBlockState blockIn) {
		playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.15F, 1.0F);
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {

			if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				entityDropItem(GaiaItems.FOOD_MEAT, 1);
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
				ItemStack enchantmentBook = new ItemStack(Items.ENCHANTED_BOOK);
				ItemEnchantedBook.addEnchantment(enchantmentBook, new EnchantmentData(Enchantments.LOOTING, 1));
				this.entityDropItem(enchantmentBook, 1);
			}
		}
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData entityLivingData, NBTTagCompound itemNbt) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, entityLivingData, itemNbt);

		setCombatTask();

		return ret;
	}

	boolean hidding;

	public void readAdditional(NBTTagCompound tag) {
		super.readAdditional(tag);
		if (tag.hasKey("Hidding")) {
			hidding = tag.getBoolean("Hidding");
		}

		setCombatTask();
	}

	public void writeAdditional(NBTTagCompound tag) {
		super.writeAdditional(tag);
		tag.setBoolean("Hidding", hidding);
	}

	protected void registerData() {
		super.registerData();
		this.getDataManager().register(HIDDING, Boolean.valueOf(false));
	}

	public boolean getHidding() {
		return ((Boolean) dataManager.get(HIDDING)).booleanValue();
	}

	public void setHidding(boolean flag) {
		dataManager.set(HIDDING, flag);
	}

	@Override
	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.ARTHROPOD;
	}

	/* STATIC */
	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	protected void collideWithEntity(Entity entityIn) {
	}

	@Override
	public boolean canBeCollidedWith() {
		return true;
	}

	@Override
	public boolean canBePushed() {
		return true;
	}

	@Override
	public void applyEntityCollision(Entity entityIn) {
	}
	/* STATIC */

	/* IMMUNITIES */
	@Override
	protected int getFireImmuneTicks() {
		return 10;
	}

	@Override
	public boolean isPotionApplicable(PotionEffect potioneffectIn) {
		return potioneffectIn.getPotion() == MobEffects.POISON ? false : super.isPotionApplicable(potioneffectIn);
	}
	/* IMMUNITIES */

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
