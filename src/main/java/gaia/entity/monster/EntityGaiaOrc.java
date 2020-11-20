package gaia.entity.monster;

import java.util.List;

import javax.annotation.Nullable;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.entity.ai.EntityAIGaiaBreakDoor;
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
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

public class EntityGaiaOrc extends EntityMobHostileBase implements IRangedAttackMob {
	private static final String MOB_TYPE_TAG = "MobType";

	private final EntityAIGaiaBreakDoor aiBreakDoor = new EntityAIGaiaBreakDoor(this);
	private EntityAIAttackRanged aiArrowAttack = new EntityAIAttackRanged(this, EntityAttributes.ATTACK_SPEED_1, 20, 60, 15.0F);
	private EntityAIAttackMelee aiAttackOnCollide = new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_1, true);

	private static final DataParameter<Integer> SKIN = EntityDataManager.createKey(EntityGaiaMinotaurus.class, DataSerializers.VARINT);

	// MobType_1
	private int switchHealth;
	// MobType_0
	private int buffEffect;
	private boolean animationPlay;
	private int animationTimer;

	public EntityGaiaOrc(World worldIn) {
		super(worldIn);

		setSize(0.8F, 2.2F);
		experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
		stepHeight = 1.0F;
		setCanPickUpLoot(true);
		// MobType_1
		switchHealth = 0;
		// MobType_0
		buffEffect = 0;
		animationPlay = false;
		animationTimer = 0;

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

		targetTasks.addTask(3, new EntityAINearestAttackableTarget<>(this, EntityGaiaDwarf.class, true));
	}

	/**
	 * sets or removes EntityAIBreakDoor task
	 */
	public void setBreakDoorsAItask(boolean enabled) {
		((PathNavigateGround) this.getNavigator()).setBreakDoors(enabled);

		if (enabled) {
			this.tasks.addTask(1, this.aiBreakDoor);
		} else {
			this.tasks.removeTask(this.aiBreakDoor);
		}
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.MAX_HEALTH_1);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.FOLLOW_RANGE);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.MOVE_SPEED_1);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityAttributes.ATTACK_DAMAGE_1);
		getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.RATE_ARMOR_1);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float damage) {
		if (hasShield()) {
			Entity entity = source.getImmediateSource();
			return !(entity instanceof EntityArrow) && super.attackEntityFrom(source, Math.min(damage, EntityAttributes.BASE_DEFENSE_1));
		} else {
			return super.attackEntityFrom(source, Math.min(damage, EntityAttributes.BASE_DEFENSE_1));
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
		super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_1);
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
		return super.canAttackClass(cls) && cls != EntityGaiaOrc.class;
	}
	/* RANGED DATA */

	@Override
	public boolean isAIDisabled() {
		return false;
	}

	@Override
	public void onLivingUpdate() {
		if (getMobType() == 0) {
			/* BUFF */
			if (getHealth() <= EntityAttributes.MAX_HEALTH_1 * 0.25F && getHealth() > 0.0F && buffEffect == 0) {
				setAI((byte) 2);
				setEquipment((byte) 2);
				buffEffect = 1;
				animationPlay = true;
			}

			if (getHealth() > EntityAttributes.MAX_HEALTH_1 * 0.25F && buffEffect == 1) {
				buffEffect = 0;
				animationPlay = false;
				animationTimer = 0;
			}

			if (animationPlay) {
				if (animationTimer != 15) {
					animationTimer += 1;
				} else {
					setBuff();
					setAI((byte) 1);
					setEquipment((byte) 0);
					animationPlay = false;
				}
			}
			/* BUFF */
		} else if (getMobType() == 1) {
			beaconMonster(6D);

			if ((getHealth() < EntityAttributes.MAX_HEALTH_1 * 0.5F) && (switchHealth == 0)) {
				setAI((byte) 1);
				switchHealth = 1;
			}

			if ((getHealth() > EntityAttributes.MAX_HEALTH_1 * 0.5F) && (switchHealth == 1)) {
				setAI((byte) 0);
				switchHealth = 0;
			}

			if (animationPlay) {
				if (animationTimer != 30) {
					animationTimer += 1;
				} else {
					setEquipment((byte) 0);
					animationPlay = false;
				}
			}
		}

		super.onLivingUpdate();
	}

	private void setAI(byte id) {
		if (id == 0) {
			tasks.removeTask(aiBreakDoor);
			tasks.removeTask(aiAttackOnCollide);
			tasks.addTask(2, aiArrowAttack);

			setEquipment((byte) 0);
			animationPlay = false;
			animationTimer = 0;
		}

		if (id == 1) {
			tasks.removeTask(aiArrowAttack);
			tasks.addTask(1, aiBreakDoor);
			tasks.addTask(2, aiAttackOnCollide);
		}

		if (id == 2) {
			tasks.removeTask(aiBreakDoor);
			tasks.removeTask(aiAttackOnCollide);
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

	private void setBuff() {
		world.setEntityState(this, (byte) 7);
		addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 20 * 60, 0));
	}

	private void beaconMonster(double range) {
		if (!world.isRemote) {
			AxisAlignedBB axisalignedbb = (new AxisAlignedBB(posX, posY, posZ, posX + 1, posY + 1, posZ + 1)).grow(range);

			List<EntityLivingBase> moblist = world.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);

			for (EntityLivingBase mob : moblist) {
				if (mob instanceof EntityGaiaOrc) {
					mob.addPotionEffect(new PotionEffect(MobEffects.HASTE, 300, 1, true, true));
				}
			}
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
		if (itemstack.getItem() == GaiaItems.WEAPON_PROP) {
			setAI((byte) 0);
		} else {
			setAI((byte) 1);
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

	@Override
	protected void entityInit() {
		super.entityInit();
		dataManager.register(SKIN, 0);
	}
	/* CLASS TYPE */

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaSounds.ORC_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaSounds.ORC_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.ORC_DEATH;
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		switch (getMobType()) {
		case 0:
			return GaiaLootTables.ENTITIES_GAIA_ORC_MELEE;
		case 1:
			return GaiaLootTables.ENTITIES_GAIA_ORC_RANGED;
		default:
			return LootTableList.EMPTY;
		}
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				dropItem(GaiaItems.FOOD_MEAT, 1);
			}

			// Nuggets/Fragments
			int dropNugget = rand.nextInt(GaiaConfig.DROPS.maxNuggetCount) + 1;

			for (int i = 0; i < dropNugget; ++i) {
				dropItem(Items.IRON_NUGGET, 1);
			}

			if (GaiaConfig.DROPS.additionalOre) {
				int dropNuggetAlt = rand.nextInt(GaiaConfig.DROPS.maxNuggetCount) + 1;

				for (int i = 0; i < dropNuggetAlt; ++i) {
					ItemShard.dropNugget(this, 4);
				}
			}

			// Rare
			if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0)) {
				dropItem(GaiaItems.BOX_IRON, 1);
			}

			// Unique Rare
			if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
				if (getMobType() == 1) {
					dropItem(GaiaItems.BAG_BOOK, 1);
				}
			}
		}
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, livingdata);

		if (world.rand.nextInt(4) == 0) {
			setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP, 1, 0));

			setTextureType(2);
		} else {
			switch (rand.nextInt(2)) {
			case 0:
				setTextureType(0);
				break;
			case 1:
				setTextureType(1);
				break;
			}

			switch (getTextureType()) {
			case 0:
				switch (rand.nextInt(2)) {
				case 0:
					setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.STONE_AXE));
					setEnchantmentBasedOnDifficulty(difficulty);
					break;
				case 1:
					setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.IRON_AXE));
					setEnchantmentBasedOnDifficulty(difficulty);
					break;
				}
				break;
			case 1:
				switch (rand.nextInt(2)) {
				case 0:
					setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_AXE));
					setEnchantmentBasedOnDifficulty(difficulty);
					break;
				case 1:
					setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.STONE_AXE));
					setEnchantmentBasedOnDifficulty(difficulty);
					break;
				}
				break;
			}

			ItemStack itemstack = getItemStackFromSlot(EntityEquipmentSlot.MAINHAND);

			ItemStack shield = ItemStack.EMPTY;
			ItemStack armor_leggings = ItemStack.EMPTY;
			ItemStack armor_chestplate = ItemStack.EMPTY;

			switch (getTextureType()) {
			case 0:
				if (itemstack.getItem() == Items.STONE_AXE) {
					armor_leggings = new ItemStack(Items.LEATHER_LEGGINGS);
				}

				if (itemstack.getItem() == Items.IRON_AXE) {
					armor_leggings = new ItemStack(Items.LEATHER_LEGGINGS);
					armor_chestplate = new ItemStack(Items.LEATHER_CHESTPLATE);
				}
				break;
			case 1:
				if (itemstack.getItem() == Items.WOODEN_AXE) {
					shield = new ItemStack(GaiaItems.SHIELD_PROP, 1, 0);
					armor_leggings = new ItemStack(Items.LEATHER_LEGGINGS);
					armor_chestplate = new ItemStack(Items.LEATHER_CHESTPLATE);
				}

				if (itemstack.getItem() == Items.STONE_AXE) {
					shield = new ItemStack(GaiaItems.SHIELD_PROP, 1, 1);
					armor_leggings = new ItemStack(Items.LEATHER_LEGGINGS);
					armor_chestplate = new ItemStack(Items.IRON_CHESTPLATE);
				}
				break;
			}

			setItemStackToSlot(EntityEquipmentSlot.OFFHAND, shield);
			setItemStackToSlot(EntityEquipmentSlot.LEGS, armor_leggings);
			setItemStackToSlot(EntityEquipmentSlot.CHEST, armor_chestplate);

			setBreakDoorsAItask(true);
		}

		setCombatTask();

		return ret;
	}

	/* SPAWN CONDITIONS */
	@Override
	public int getMaxSpawnedInChunk() {
		return EntityAttributes.CHUNK_LIMIT_1;
	}

	@Override
	public boolean getCanSpawnHere() {
		return posY > ((!GaiaConfig.SPAWN.disableYRestriction) ? 60D : 0D) && super.getCanSpawnHere();
	}
	/* SPAWN CONDITIONS */
}
