package gaia.entity.monster;

import javax.annotation.Nullable;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaItems;
import gaia.init.GaiaLootTables;
import gaia.init.GaiaSounds;
import gaia.items.ItemShard;
import net.minecraft.block.Block;
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
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaMinotaur extends EntityMobHostileBase {

	private EntityAIAttackMelee aiAttackOnCollide = new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_3, true);

	private ItemStack mainWeapon;

	private int buffEffect;
	private boolean animationPlay;
	private int animationTimer;

	public EntityGaiaMinotaur(World worldIn) {
		super(worldIn);

		setSize(1.4F, 3.0F);
		experienceValue = EntityAttributes.EXPERIENCE_VALUE_3;
		stepHeight = 6.0F;
		isImmuneToFire = true;

		buffEffect = 0;
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
					byte0 = 20;
				} else if (world.getDifficulty() == EnumDifficulty.HARD) {
					byte0 = 30;
				}

				if (byte0 > 0) {
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, byte0 * 20, 0));
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, byte0 * 20, 0));
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

		if (motionX * motionX + motionZ * motionZ > 2.500000277905201E-7D && rand.nextInt(5) == 0) {
			int i = MathHelper.floor(posX);
			int j = MathHelper.floor(posY - 0.20000000298023224D);
			int k = MathHelper.floor(posZ);
			IBlockState iblockstate = world.getBlockState(new BlockPos(i, j, k));

			if (iblockstate.getMaterial() != Material.AIR) {
				world.spawnParticle(EnumParticleTypes.BLOCK_CRACK, posX + (rand.nextDouble() - 0.5D) * width, getEntityBoundingBox().minY + 0.1D, posZ + (rand.nextDouble() - 0.5D) * width, 4.0D * (rand.nextDouble() - 0.5D), 0.5D, (rand.nextDouble() - 0.5D) * 4.0D, Block.getStateId(iblockstate));
			}
		}

		/* BUFF */
		if (getHealth() <= EntityAttributes.MAX_HEALTH_3 * 0.25F && getHealth() > 0.0F && buffEffect == 0) {
			setAI((byte) 1);
			setEquipment((byte) 1);
			buffEffect = 1;
			animationPlay = true;
		}

		if (getHealth() > EntityAttributes.MAX_HEALTH_3 * 0.25F && buffEffect == 1) {
			buffEffect = 0;
			animationPlay = false;
			animationTimer = 0;
		}

		if (animationPlay) {
			if (animationTimer != 15) {
				animationTimer += 1;
			} else {
				setBuff();
				setAI((byte) 0);
				setEquipment((byte) 0);
				animationPlay = false;
			}
		}
		/* BUFF */

		if (getHealth() <= 0.0F) {
			for (int i = 0; i < 2; ++i) {
				world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, posX + (rand.nextDouble() - 0.5D) * width, posY + rand.nextDouble() * height, posZ + (rand.nextDouble() - 0.5D) * width, 0.0D, 0.0D, 0.0D);
			}
		} else {
			super.onLivingUpdate();
		}
	}

	private void setAI(byte id) {
		if (id == 0) {
			tasks.addTask(1, aiAttackOnCollide);
		}

		if (id == 1) {
			tasks.removeTask(aiAttackOnCollide);
		}
	}

	private void setEquipment(byte id) {
		if (id == 0) {
			setItemStackToSlot(EntityEquipmentSlot.HEAD, ItemStack.EMPTY);
			setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_HAMMER_MINOTAUR));
		}

		if (id == 1) {
			setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.STICK));
			setItemStackToSlot(EntityEquipmentSlot.MAINHAND, ItemStack.EMPTY);
		}
	}

	private void setBuff() {
		world.setEntityState(this, (byte) 7);
		addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 20 * 60, 0));
		addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 20 * 60, 0));
	}

	private void setCombatTask() {
		tasks.removeTask(aiAttackOnCollide);

		setAI((byte) 0);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaSounds.MINOTAUR_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaSounds.MINOTAUR_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.MINOTAUR_DEATH;
	}

	@Override
	protected void playStepSound(BlockPos pos, Block blockIn) {
		playSound(SoundEvents.ENTITY_IRONGOLEM_STEP, 1.0F, 1.0F);
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return GaiaLootTables.ENTITIES_GAIA_MINOTAUR;
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
				dropItem(GaiaItems.ACCESSORY_CURSED, 1);
			}

			if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
				dropItem(Item.getItemFromBlock(GaiaBlocks.DECO_BUST_MINOTAUR), 1);
			}

			if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
				entityDropItem(new ItemStack(GaiaItems.MISC_RING, 1, 1), 0.0F);
			}
		}
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, livingdata);

		setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_HAMMER_MINOTAUR));
		setEnchantmentBasedOnDifficulty(difficulty);

		ItemStack bootsSwimming = new ItemStack(Items.LEATHER_BOOTS);
		setItemStackToSlot(EntityEquipmentSlot.FEET, bootsSwimming);
		bootsSwimming.addEnchantment(Enchantments.DEPTH_STRIDER, 2);

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
	/* IMMUNITIES */

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);

		setCombatTask();
	}

	/* SPAWN CONDITIONS */
	@Override
	public int getMaxSpawnedInChunk() {
		return EntityAttributes.CHUNK_LIMIT_3;
	}
	
	@Override
	public boolean getCanSpawnHere() {
		if (GaiaConfig.SPAWN.spawnLevel3Rain) {
			return posY > ((!GaiaConfig.SPAWN.disableYRestriction) ? 32D : 0D) && world.isRaining() && super.getCanSpawnHere();
		} else {
			return posY > ((!GaiaConfig.SPAWN.disableYRestriction) ? 32D : 0D) && super.getCanSpawnHere();
		}
	}
	/* SPAWN CONDITIONS */
}
