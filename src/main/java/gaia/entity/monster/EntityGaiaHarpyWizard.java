package gaia.entity.monster;

import javax.annotation.Nullable;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobAssistBase;
import gaia.entity.ai.EntityAIGaiaValidateTargetPlayer;
import gaia.entity.ai.Ranged;
import gaia.init.GaiaItems;
import gaia.init.GaiaLootTables;
import gaia.init.GaiaSounds;
import gaia.items.ItemShard;
import gaia.items.ItemWeaponBook;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityGaiaHarpyWizard extends EntityMobAssistBase implements IRangedAttackMob {

	private EntityAIAttackRanged aiArrowAttack = new EntityAIAttackRanged(this, EntityAttributes.ATTACK_SPEED_2, 20, 60, 15.0F);
	private EntityAIAvoidEntity<EntityPlayer> aiAvoid = new EntityAIAvoidEntity<>(this, EntityPlayer.class, 20.0F, EntityAttributes.ATTACK_SPEED_1, EntityAttributes.ATTACK_SPEED_3);

	private boolean animationPlay;
	private int animationTimer;

	private int switchHealth;

	public EntityGaiaHarpyWizard(World worldIn) {
		super(worldIn);

		experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
		stepHeight = 1.0F;
		isImmuneToFire = true;

		animationPlay = false;
		animationTimer = 0;

		switchHealth = 0;
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

	public float getEyeHeight() {
		return this.height * 0.5F;
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
		return super.attackEntityFrom(source, Math.min(damage, EntityAttributes.BASE_DEFENSE_1));
	}

	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
		super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_1);
	}

	/* RANGED DATA */
	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
		ItemStack itemstack = this.getItemStackFromSlot(EntityEquipmentSlot.OFFHAND);

		if (itemstack.getItem() == GaiaItems.WEAPON_BOOK_FREEZING)
			Ranged.magicRandom(target, this, distanceFactor, 0, 0);

		if (itemstack.getItem() == GaiaItems.WEAPON_BOOK_NIGHTMARE)
			Ranged.magicRandom(target, this, distanceFactor, 0, 1);
		
		if (itemstack.getItem() == GaiaItems.WEAPON_BOOK_METAL)
			Ranged.magicRandom(target, this, distanceFactor, 0, 2);
		
		if (itemstack.getItem() == GaiaItems.WEAPON_BOOK_ENDER)
			Ranged.magicRandom(target, this, distanceFactor, 0, 3);
		
		if (itemstack.getItem() == GaiaItems.WEAPON_BOOK_HUNGER)
			Ranged.magicRandom(target, this, distanceFactor, 0, 4);

		if (itemstack.getItem() == GaiaItems.WEAPON_BOOK_BATTLE)
			Ranged.magicRandom(target, this, distanceFactor, 0, 5);
		
		if (itemstack.getItem() == GaiaItems.WEAPON_BOOK_NATURE)
			Ranged.magicRandom(target, this, distanceFactor, 0, 6);
		
		if (itemstack.getItem() == GaiaItems.WEAPON_BOOK_WITHER)
			Ranged.magicRandom(target, this, distanceFactor, 0, 7);

		if (itemstack.getItem() == GaiaItems.WEAPON_BOOK)
			Ranged.magic(target, this, distanceFactor);

		setEquipment((byte) 1);
		animationPlay = true;
		animationTimer = 0;
	}

	@Override
	public boolean canAttackClass(Class<? extends EntityLivingBase> cls) {
		return super.canAttackClass(cls) && cls != EntityGaiaHarpyWizard.class;
	}
	/* RANGED DATA */

	@Override
	public boolean isAIDisabled() {
		return false;
	}

	@Override
	public void onLivingUpdate() {
		if (!onGround && motionY < 0.0D) {
			motionY *= 0.8D;
		}

		/* FLEE DATA */
		if ((getHealth() < EntityAttributes.MAX_HEALTH_1 * 0.25F) && (switchHealth == 0)) {
			switch (rand.nextInt(2)) {
			case 0:
				setAI((byte) 1);
				setItemStackToSlot(EntityEquipmentSlot.OFFHAND, ItemStack.EMPTY);
				setEquipment((byte) 2);
				switchHealth = 1;
				break;
			case 1:
				switchHealth = 2;
				break;
			}
		}

		if ((getHealth() > EntityAttributes.MAX_HEALTH_1 * 0.25F) && (switchHealth == 1)) {
			ItemStack itemstack = this.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
					
			setAI((byte) 0);
			setItemStackToSlot(EntityEquipmentSlot.OFFHAND, itemstack);
			setEquipment((byte) 0);

			switchHealth = 0;
		}
		/* FLEE DATA */

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
			tasks.removeTask(aiAvoid);
			tasks.addTask(2, aiArrowAttack);

			setEquipment((byte) 0);
			animationPlay = false;
			animationTimer = 0;
		}

		if (id == 1) {
			tasks.removeTask(aiArrowAttack);
			tasks.addTask(2, aiAvoid);
		}
	}

	private void setEquipment(byte id) {
		if (id == 0) {
			setItemStackToSlot(EntityEquipmentSlot.HEAD, ItemStack.EMPTY);
		}

		if (id == 1) {
			setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.STICK));
		}

		if (id == 2) {
			setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.FEATHER));
		}
	}

	private void setCombatTask() {
		tasks.removeTask(aiArrowAttack);
		tasks.removeTask(aiAvoid);

		ItemStack itemstack = getHeldItemOffhand();
		if (itemstack.getItem() instanceof ItemWeaponBook) {
			setAI((byte) 0);
		} else {
			setAI((byte) 1);
		}
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaSounds.HARPY_WIZARD_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaSounds.HARPY_WIZARD_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.HARPY_WIZARD_DEATH;
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return GaiaLootTables.ENTITIES_GAIA_HARPY_WIZARD;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			int drop = rand.nextInt(3 + lootingModifier);

			for (int i = 0; i < drop; ++i) {
				dropItem(GaiaItems.MISC_SOUL_FIRE, 1);
			}

			// Nuggets/Fragments
			int dropNugget = rand.nextInt(3) + 1;

			for (int i = 0; i < dropNugget; ++i) {
				dropItem(Items.IRON_NUGGET, 1);
			}

			if (GaiaConfig.OPTIONS.additionalOre) {
				int dropNuggetAlt = rand.nextInt(3) + 1;

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
				dropItem(GaiaItems.MISC_BOOK, 1);
			}
		}
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, livingdata);

		switch (world.rand.nextInt(3)) {
		case 0:
			setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(GaiaItems.WEAPON_BOOK_FREEZING));
			setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(GaiaItems.WEAPON_BOOK_FREEZING));
			break;
		case 1:
			setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(GaiaItems.WEAPON_BOOK_NIGHTMARE));
			setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(GaiaItems.WEAPON_BOOK_NIGHTMARE));
			break;
		case 2:
			setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(GaiaItems.WEAPON_BOOK_METAL));
			setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(GaiaItems.WEAPON_BOOK_METAL));
			break;
		case 3:
			setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(GaiaItems.WEAPON_BOOK_ENDER));
			setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(GaiaItems.WEAPON_BOOK_ENDER));
			break;
		case 4:
			setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(GaiaItems.WEAPON_BOOK_HUNGER));
			setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(GaiaItems.WEAPON_BOOK_HUNGER));
			break;
		case 5:
			setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(GaiaItems.WEAPON_BOOK_BATTLE));
			setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(GaiaItems.WEAPON_BOOK_BATTLE));
			break;
		case 6:
			setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(GaiaItems.WEAPON_BOOK_NATURE));
			setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(GaiaItems.WEAPON_BOOK_NATURE));
			break;
		case 7:
			setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(GaiaItems.WEAPON_BOOK_WITHER));
			setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(GaiaItems.WEAPON_BOOK_WITHER));
			break;
		default:
			setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(GaiaItems.WEAPON_BOOK));
		}
		
		setEnchantmentBasedOnDifficulty(difficulty);

		setCombatTask();

		return ret;
	}

	/* IMMUNITIES */
	@Override
	public void fall(float distance, float damageMultiplier) {
	}
	/* IMMUNITIES */

	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);

		setCombatTask();
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
