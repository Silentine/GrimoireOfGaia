package gaia.entity.monster;

import javax.annotation.Nullable;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.entity.projectile.EntityGaiaProjectileSmallFireball;
import gaia.init.GaiaBlocks;
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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityGaiaNineTails extends EntityMobHostileBase implements IRangedAttackMob {

	private static final DataParameter<Integer> WEAPON_TYPE = EntityDataManager.createKey(EntityGaiaNineTails.class, DataSerializers.VARINT);

	private EntityAIAttackRanged aiArrowAttack = new EntityAIAttackRanged(this, EntityAttributes.ATTACK_SPEED_2, 20, 60, 15.0F);
	private EntityAIAttackMelee aiAttackOnCollide = new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_2, true);

	private int switchHealth;

	private boolean animationPlay;
	private int animationTimer;

	public EntityGaiaNineTails(World worldIn) {
		super(worldIn);

		experienceValue = EntityAttributes.EXPERIENCE_VALUE_2;
		stepHeight = 1.0F;
		switchHealth = 0;
		isImmuneToFire = true;

		animationPlay = false;
		animationTimer = 0;
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

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase living, float par2) {
		playSound(SoundEvents.ENTITY_BLAZE_SHOOT, 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
		double d0 = living.posX - posX;
		double d1 = living.getEntityBoundingBox().minY + living.height / 2.0D - (posY + height / 2.0D);
		double d2 = living.posZ - posZ;
		double f1 = MathHelper.sqrt(par2) * 0.5D;

		for (int var10 = 0; var10 < 3; ++var10) {
			EntityGaiaProjectileSmallFireball var11 = new EntityGaiaProjectileSmallFireball(world, this, d0 + rand.nextGaussian() * f1, d1, d2 + rand.nextGaussian() * f1);
			var11.posY = posY + height / 2.0D + 0.5D;
			world.spawnEntity(var11);
		}

		setEquipment((byte) 1);
		animationPlay = true;
		animationTimer = 0;
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		if (super.attackEntityAsMob(entityIn)) {
			entityIn.setFire(6);
		}
		return true;
	}

	@Override
	public boolean isAIDisabled() {
		return false;
	}

	public void onLivingUpdate() {
		if ((getHealth() < EntityAttributes.MAX_HEALTH_2 * 0.75F) && (switchHealth == 0)) {
			if (getWeaponType() == 0) {
				if (rand.nextInt(4) == 0) {
					setWeaponType(2);
				} else {
					setWeaponType(1);
				}
			}

			setEquipmentEnchanted(getWeaponType());

			setAI((byte) 1);
			switchHealth = 1;
		}

		if ((getHealth() > EntityAttributes.MAX_HEALTH_2 * 0.75F) && (switchHealth == 1)) {
			setItemStackToSlot(EntityEquipmentSlot.MAINHAND, ItemStack.EMPTY);
			setAI((byte) 0);
			switchHealth = 0;
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
			tasks.addTask(1, aiArrowAttack);

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
	}

	private void setCombatTask() {
		ItemStack itemstack = getHeldItemMainhand();
		if (itemstack.isEmpty()) {
			setAI((byte) 0);
		} else {
			setAI((byte) 1);
		}
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaSounds.NINETAILS_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaSounds.NINETAILS_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.NINETAILS_DEATH;
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return GaiaLootTables.ENTITIES_GAIA_NINETAILS;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			int drop = rand.nextInt(3 + lootingModifier);

			for (int i = 0; i < drop; ++i) {
				dropItem(GaiaItems.MISC_SOUL_FIRE, 1);
			}

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
				ItemStack fanFire = new ItemStack(GaiaItems.WEAPON_FAN_FIRE);
				fanFire.addEnchantment(Enchantments.FIRE_ASPECT, 2);
				fanFire.addEnchantment(Enchantments.KNOCKBACK, 1);
				entityDropItem(fanFire, 1);
			}
			
			// Unique Rare
			if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
				dropItem(Item.getItemFromBlock(GaiaBlocks.DOLL_NINE_TAILS), 1);
			}
		}
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, livingdata);

		setCombatTask();

		return ret;
	}

	private void setEquipmentEnchanted(int id) {
		ItemStack weapon;

		switch (id) {
		case 1:
			weapon = new ItemStack(GaiaItems.WEAPON_PROP_ENCHANTED, 1);
			weapon.addEnchantment(Enchantments.KNOCKBACK, 1);
			setItemStackToSlot(EntityEquipmentSlot.MAINHAND, weapon);
			break;
		case 2:
			weapon = new ItemStack(GaiaItems.WEAPON_FAN, 1);
			weapon.addEnchantment(Enchantments.KNOCKBACK, 2);
			setItemStackToSlot(EntityEquipmentSlot.MAINHAND, weapon);
			break;
		}
	}

	/* ALTERNATE SKIN */
	@Override
	protected void entityInit() {
		super.entityInit();
		dataManager.register(WEAPON_TYPE, 0);
	}

	public int getWeaponType() {
		return dataManager.get(WEAPON_TYPE);
	}

	private void setWeaponType(int par1) {
		dataManager.set(WEAPON_TYPE, par1);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setInteger("WeaponType", getWeaponType());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		setWeaponType(compound.getInteger("WeaponType"));

		setCombatTask();
	}

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
