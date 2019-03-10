package gaia.entity.monster;

import javax.annotation.Nullable;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobAssistDay;
import gaia.entity.GaiaLootTableList;
import gaia.entity.ai.EntityAIGaiaAttackRangedBow;
import gaia.entity.ai.EntityAIGaiaBreakDoor;
import gaia.entity.ai.EntityAIGaiaValidateTargetPlayer;
import gaia.entity.ai.GaiaIRangedAttackMob;
import gaia.entity.ai.Ranged;
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
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGaiaDwarf extends EntityMobAssistDay implements GaiaIRangedAttackMob {

	private static final String MOB_TYPE_TAG = "MobType";
	private EntityAIGaiaAttackRangedBow aiArrowAttack = new EntityAIGaiaAttackRangedBow(this, EntityAttributes.ATTACK_SPEED_2, 20, 15.0F);
	private EntityAIAttackMelee aiAttackOnCollide = new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_2, true) {
		public void resetTask() {
			super.resetTask();
			EntityGaiaDwarf.this.setSwingingArms(false);
		}

		public void startExecuting() {
			super.startExecuting();
			EntityGaiaDwarf.this.setSwingingArms(true);
		}
	};
	private final EntityAIGaiaBreakDoor breakDoor = new EntityAIGaiaBreakDoor(this);

	private static final DataParameter<Integer> SKIN = EntityDataManager.createKey(EntityGaiaDwarf.class, DataSerializers.VARINT);
	private static final DataParameter<Boolean> SWINGING_ARMS = EntityDataManager.createKey(EntityGaiaDwarf.class, DataSerializers.BOOLEAN);
	private static final ItemStack TIPPED_ARROW_CUSTOM = PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), PotionTypes.SLOWNESS);
	private static final ItemStack TIPPED_ARROW_CUSTOM_2 = PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), PotionTypes.WEAKNESS);

	public int classID;
	public boolean randomClass;

	private boolean canSpawnLevel3;
	private boolean spawned;
	private int spawnLevel3;
	private int spawnLevel3Chance;

	public EntityGaiaDwarf(World worldIn) {
		super(worldIn);

		setSize(0.5F, 1.5F);
		experienceValue = EntityAttributes.EXPERIENCE_VALUE_2;
		stepHeight = 1.0F;

		classID = 0;
		randomClass = true;
		spawnLevel3 = 0;
		spawnLevel3Chance = 0;

		if (!worldIn.isRemote) {
			setCombatTask();
		}
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(3, new EntityAIWander(this, 1.0D));
		tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		tasks.addTask(4, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		targetTasks.addTask(2, new EntityAIGaiaValidateTargetPlayer(this));
		targetTasks.addTask(3, new EntityAINearestAttackableTarget<>(this, EntityGaiaOrc.class, true));
	}

	/**
	 * sets or removes EntityAIBreakDoor task
	 */
	public void setBreakDoorsAItask(boolean enabled) {
		((PathNavigateGround) this.getNavigator()).setBreakDoors(enabled);

		if (enabled) {
			this.tasks.addTask(1, this.breakDoor);
		} else {
			this.tasks.removeTask(this.breakDoor);
		}
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
		if (damage > EntityAttributes.BASE_DEFENSE_2) {
			if (canSpawnLevel3) {
				spawnLevel3Chance += (int) (GaiaConfig.SPAWN.spawnLevel3Chance * 0.05);
			}
		}

		if (hasShield()) {
			Entity entity = source.getImmediateSource();
			return !(entity instanceof EntityArrow) && super.attackEntityFrom(source, Math.min(damage, EntityAttributes.BASE_DEFENSE_1));
		} else {
			return super.attackEntityFrom(source, Math.min(damage, EntityAttributes.BASE_DEFENSE_2));
		}
	}

	private boolean hasShield() {
		ItemStack itemstack = this.getItemStackFromSlot(EntityEquipmentSlot.OFFHAND);

		if (itemstack.getItem() == Items.SHIELD || itemstack.getItem() == GaiaItems.SHIELD_PROP) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
		super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_2);
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		if (super.attackEntityAsMob(entityIn)) {
			if (getMobType() == 1 && entityIn instanceof EntityLivingBase) {
				byte byte0 = 0;

				if (world.getDifficulty() == EnumDifficulty.NORMAL) {
					byte0 = 10;
				} else if (world.getDifficulty() == EnumDifficulty.HARD) {
					byte0 = 20;
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
	public boolean isAIDisabled() {
		return false;
	}

	@Override
	public void onLivingUpdate() {
		/* LEVEL 3 SPAWN DATA */
		if ((GaiaConfig.SPAWN.spawnLevel3 && (GaiaConfig.SPAWN.spawnLevel3Chance != 0)) && !canSpawnLevel3) {
			canSpawnLevel3 = true;
		}

		if (canSpawnLevel3) {
			if (getHealth() < EntityAttributes.MAX_HEALTH_2 * 0.25F && getHealth() > 0.0F && !spawned) {

				if (spawnLevel3Chance > (int) (GaiaConfig.SPAWN.spawnLevel3Chance * 0.5)) {
					spawnLevel3Chance = (int) (GaiaConfig.SPAWN.spawnLevel3Chance * 0.5);
				}

				if ((rand.nextInt(GaiaConfig.SPAWN.spawnLevel3Chance - spawnLevel3Chance) == 0 || rand.nextInt(1) > 0)) {
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

		super.onLivingUpdate();
	}

	private void setSpawn(byte id) {
		EntityGaiaValkyrie valyrie;

		if (id == 1) {
			explode();

			valyrie = new EntityGaiaValkyrie(world);
			valyrie.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
			valyrie.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(valyrie)), null);
			world.spawnEntity(valyrie);
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
			tasks.addTask(2, aiArrowAttack);
		} else {
			tasks.addTask(2, aiAttackOnCollide);
		}
	}

	public int getTextureType() {
		return dataManager.get(SKIN);
	}

	private void setTextureType(int par1) {
		dataManager.set(SKIN, par1);
	}

	public int getMobType() {
		return dataManager.get(SKIN);
	}

	private void setMobType(int par1) {
		dataManager.set(SKIN, par1);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setByte(MOB_TYPE_TAG, (byte) getMobType());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
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
		return super.canAttackClass(cls) && cls != EntityGaiaDwarf.class;
	}

	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
		if (!target.isDead) {
			Ranged.rangedAttack(target, this, distanceFactor);
		}
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		dataManager.register(SKIN, 0);
		dataManager.register(SWINGING_ARMS, Boolean.valueOf(false));
	}

	@SideOnly(Side.CLIENT)
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
			this.setDead();
		}
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaSounds.DWARF_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaSounds.DWARF_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.DWARF_DEATH;
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		switch (getMobType()) {
		case 0:
			return GaiaLootTableList.ENTITIES_GAIA_DWARF_MELEE;
		case 1:
			return GaiaLootTableList.ENTITIES_GAIA_DWARF_RANGED;
		case 2:
			return GaiaLootTableList.ENTITIES_GAIA_DWARF_MINER;
		default:
			return LootTableList.EMPTY;
		}
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			int drop = rand.nextInt(3 + lootingModifier);

			switch (getMobType()) {
			case 0:
				for (int i = 0; i < drop; ++i) {
					dropItem(GaiaItems.FOOD_MEAT, 1);
				}
				break;
			case 1:
				for (int i = 0; i < drop; ++i) {
					dropItem(Items.ARROW, 1);
				}
				break;
			case 2:
				for (int i = 0; i < drop; ++i) {
					dropItem(Items.IRON_NUGGET, 1);
				}
			}

			// Nuggets/Fragments
			int dropNugget = rand.nextInt(3) + 1;

			for (int i = 0; i < dropNugget; ++i) {
				dropItem(Items.GOLD_NUGGET, 1);
			}

			if (GaiaConfig.OPTIONS.additionalOre) {
				int dropNuggetAlt = rand.nextInt(3) + 1;

				for (int i = 0; i < dropNuggetAlt; ++i) {
					ItemShard.dropNugget(this, 5);
				}
			}

			// Semi-Rare
			if ((rand.nextInt(EntityAttributes.RATE_SEMI_RARE_DROP) == 0) && (getMobType() == 2)) {
				entityDropItem(new ItemStack(GaiaItems.BOX, 1, 0), 0.0F);
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
			if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0) && (getMobType() == 1)) {
				dropItem(GaiaItems.BAG_ARROW, 1);
			}
		}

		// Boss
		if (spawnLevel3 == 1) {
			setSpawn((byte) 1);
		}
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, livingdata);

		if (randomClass) {
			if (world.rand.nextInt(4) == 0) {
				mobClass(difficulty, 1);
			} else {
				if (world.rand.nextInt(4) == 0) {
					mobClass(difficulty, 2);
				} else {
					mobClass(difficulty, 0);
				}
			}
		} else {
			mobClass(difficulty, classID);
		}

		setCombatTask();
		setBreakDoorsAItask(true);

		if (GaiaConfig.SPAWN.spawnLevel3 && (GaiaConfig.SPAWN.spawnLevel3Chance != 0)) {
			canSpawnLevel3 = true;
		}

		return ret;
	}

	public void mobClass(DifficultyInstance difficulty, int id) {
		switch (id) {
		case 0:
			setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_AXE_STONE));
			setEnchantmentBasedOnDifficulty(difficulty);

			if (world.rand.nextInt(2) == 0) {
				ItemStack shield = new ItemStack(GaiaItems.SHIELD_PROP, 1, 1);
				setItemStackToSlot(EntityEquipmentSlot.OFFHAND, shield);
				getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.25D);
			}
			break;
		case 1:
			ItemStack bowCustom = new ItemStack(Items.BOW);
			setItemStackToSlot(EntityEquipmentSlot.MAINHAND, bowCustom);
			bowCustom.addEnchantment(Enchantments.PUNCH, 1);

			if (world.rand.nextInt(2) == 0) {
				if (world.rand.nextInt(2) == 0) {
					setItemStackToSlot(EntityEquipmentSlot.OFFHAND, TIPPED_ARROW_CUSTOM);
				} else {
					setItemStackToSlot(EntityEquipmentSlot.OFFHAND, TIPPED_ARROW_CUSTOM_2);
				}
			}
			break;
		case 2:
			setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(Items.STONE_PICKAXE));
			setEnchantmentBasedOnDifficulty(difficulty);
			break;
		}

		setMobType(id);
		setTextureType(id);
	}

	/* SPAWN CONDITIONS */
	@Override
	public int getMaxSpawnedInChunk() {
		return EntityAttributes.CHUNK_LIMIT_2;
	}

	@Override
	public boolean getCanSpawnHere() {
		return posY > 60.0D && super.getCanSpawnHere();
	}
	/* SPAWN CONDITIONS */
}
