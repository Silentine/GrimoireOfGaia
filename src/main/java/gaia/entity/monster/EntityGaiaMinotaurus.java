package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.entity.GaiaLootTableList;
import gaia.entity.ai.EntityAIGaiaAttackRangedBow;
import gaia.entity.ai.GaiaIRangedAttackMob;
import gaia.entity.ai.Ranged;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import gaia.items.ItemShard;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
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
import net.minecraft.init.SoundEvents;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class EntityGaiaMinotaurus extends EntityMobHostileBase implements GaiaIRangedAttackMob {

	private static final String MOB_TYPE_TAG = "MobType";
	private EntityAIGaiaAttackRangedBow aiArrowAttack = new EntityAIGaiaAttackRangedBow(this, EntityAttributes.ATTACK_SPEED_2, 20, 15.0F);
	private EntityAIAttackMelee aiAttackOnCollide = new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_2, true) {
		public void resetTask() {
			super.resetTask();
			EntityGaiaMinotaurus.this.setSwingingArms(false);
		}

		public void startExecuting() {
			super.startExecuting();
			EntityGaiaMinotaurus.this.setSwingingArms(true);
		}
	};

	private static final DataParameter<Integer> SKIN = EntityDataManager.createKey(EntityGaiaMinotaurus.class, DataSerializers.VARINT);
	private static final DataParameter<Boolean> SWINGING_ARMS = EntityDataManager.createKey(EntityGaiaMinotaurus.class, DataSerializers.BOOLEAN);
	private static final ItemStack TIPPED_ARROW_CUSTOM = PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), PotionTypes.SLOWNESS);
	private static final ItemStack TIPPED_ARROW_CUSTOM_2 = PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), PotionTypes.WEAKNESS);

	private boolean canSpawnLevel3;
	private boolean spawned;
	private int spawnLevel3;
	private int spawnLevel3Chance;

	private boolean blockIsAir[] = new boolean[] {};

	public EntityGaiaMinotaurus(World worldIn) {
		super(GaiaEntities.MINOTAURUS, worldIn);

		experienceValue = EntityAttributes.EXPERIENCE_VALUE_2;
		stepHeight = 1.0F;

		spawnLevel3 = 0;
		spawnLevel3Chance = 0;

		if (!worldIn.isRemote) {
			setCombatTask();
		}
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAISwimming(this));

		tasks.addTask(2, new EntityAIWander(this, 1.0D));
		tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		tasks.addTask(3, new EntityAILookIdle(this));
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

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		if (super.attackEntityAsMob(entity)) {
			if (getMobType() == 1 && entity instanceof EntityLivingBase) {
				byte byte0 = 0;

				if (world.getDifficulty() == EnumDifficulty.NORMAL) {
					byte0 = 10;
				} else if (world.getDifficulty() == EnumDifficulty.HARD) {
					byte0 = 20;
				}

				if (byte0 > 0) {
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, byte0 * 20, 0));
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, byte0 * 20, 0));
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
		/* LEVEL 3 SPAWN DATA */
		if ((GaiaConfig.COMMON.spawnLevel3.get() && (GaiaConfig.COMMON.spawnLevel3Chance.get() != 0)) && !canSpawnLevel3) {
			canSpawnLevel3 = true;
		}

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

		if (spawnLevel3 == 1) {
			world.setEntityState(this, (byte) 10);

			attackEntityFrom(DamageSource.GENERIC, EntityAttributes.MAX_HEALTH_2 * 0.01F);
		}
		/* LEVEL 3 SPAWN DATA */

		super.livingTick();
	}

	private void setSpawn(byte id) {
		EntityGaiaMinotaur minotaur;

		if (id == 1) {
			explode();

			minotaur = new EntityGaiaMinotaur(world);
			minotaur.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
			minotaur.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(minotaur)), null, null);
			world.spawnEntity(minotaur);
		}
	}

	/* CLASS TYPE */
	@Override
	public void setItemStackToSlot(EntityEquipmentSlot slotIn, ItemStack stack) {
		super.setItemStackToSlot(slotIn, stack);
		if (!world.isRemote && slotIn.getIndex() == 0) {
			setCombatTask();
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
			tasks.addTask(1, aiArrowAttack);
		} else {
			tasks.addTask(1, aiAttackOnCollide);
		}
	}

	public int getTextureType() {
		return dataManager.get(SKIN);
	}

	private void setTextureType(int par1) {
		dataManager.set(SKIN, par1);
	}

	private int getMobType() {
		return dataManager.get(SKIN);
	}

	private void setMobType(int par1) {
		dataManager.set(SKIN, par1);
	}

	@Override
	public void writeAdditional(NBTTagCompound compound) {
		super.writeAdditional(compound);
		compound.setByte(MOB_TYPE_TAG, (byte) getMobType());
	}

	@Override
	public void readAdditional(NBTTagCompound compound) {
		super.readAdditional(compound);
		if (compound.hasKey(MOB_TYPE_TAG)) {
			byte b0 = compound.getByte(MOB_TYPE_TAG);
			setMobType(b0);
		}

		setCombatTask();
	}
	/* CLASS TYPE */

	/* ARCHER DATA */
	@Override
	public boolean canAttackClass(Class<? extends EntityLivingBase> cls) {
		return super.canAttackClass(cls) && cls != EntityGaiaMinotaurus.class;
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
		this.getDataManager().register(SKIN, 0);
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
		return GaiaSounds.MINOTAURUS_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaSounds.MINOTAURUS_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.MINOTAURUS_DEATH;
	}

	@Override
	protected void playStepSound(BlockPos pos, IBlockState blockIn) {
		playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return GaiaLootTableList.ENTITIES_GAIA_MINOTAURUS;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			int drop = rand.nextInt(3 + lootingModifier);

			if (getMobType() == 1) {
				for (int i = 0; i < drop; ++i) {
					entityDropItem(Items.ARROW, 1);
				}
			} else {
				for (int i = 0; i < drop; ++i) {
					entityDropItem(Items.LEATHER, 1);
				}
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
				entityDropItem(GaiaItems.SPAWN_HOLSTAURUS, 1);
			}

			if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
				entityDropItem(getMobType() == 1 ? GaiaItems.BAG_ARROW : GaiaItems.WEAPON_BOOK_BATTLE, 1);
			}
		}

		// Boss
		if (spawnLevel3 == 1) {
			setSpawn((byte) 1);
		}
	}

	public boolean canSpawn() {
		int i = MathHelper.floor(posX);
		int j = MathHelper.floor(posY + 2.0D);
		int k = MathHelper.floor(posZ);
		IBlockState iblockstate = world.getBlockState(new BlockPos(i, j, k));

		int i1 = MathHelper.floor(posX);
		int j1 = MathHelper.floor(posY + 3.0D);
		int k1 = MathHelper.floor(posZ);
		IBlockState iblockstate_j = world.getBlockState(new BlockPos(i1, j1, k1));

		if (iblockstate.getMaterial() == Material.AIR && iblockstate_j.getMaterial() == Material.AIR) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData entityLivingData, NBTTagCompound itemNbt) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, entityLivingData, itemNbt);

		if (world.rand.nextInt(4) == 0) {
			mobClass(difficulty, 1);
		} else {
			mobClass(difficulty, 0);
		}

		setCombatTask();

		if (GaiaConfig.COMMON.spawnLevel3.get() && (GaiaConfig.COMMON.spawnLevel3Chance.get() != 0)) {
			canSpawnLevel3 = true;
		}

		return ret;
	}

	public void mobClass(DifficultyInstance difficulty, int id) {
		switch (id) {
			case 0:
				setEquipmentBasedOnDifficulty(difficulty);
				setEnchantmentBasedOnDifficulty(difficulty);
				setMobType(1);
				getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityAttributes.ATTACK_DAMAGE_2);
				break;
			case 1:
				setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
				setEnchantmentBasedOnDifficulty(difficulty);

				if (world.rand.nextInt(2) == 0) {
					if (world.rand.nextInt(2) == 0) {
						setItemStackToSlot(EntityEquipmentSlot.OFFHAND, TIPPED_ARROW_CUSTOM);
					} else {
						setItemStackToSlot(EntityEquipmentSlot.OFFHAND, TIPPED_ARROW_CUSTOM_2);
					}
				}
				break;
		}

		setMobType(id);
		setTextureType(id);
	}

	@Override
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		if (rand.nextInt(4) == 0) {
			setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_SWORD_STONE));
			setEnchantmentBasedOnDifficulty(difficulty);
		} else {
			setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_AXE_STONE));
			setEnchantmentBasedOnDifficulty(difficulty);
		}
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
