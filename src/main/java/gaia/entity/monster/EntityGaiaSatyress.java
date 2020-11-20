package gaia.entity.monster;

import javax.annotation.Nullable;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobAssistDay;
import gaia.entity.ai.EntityAIGaiaValidateTargetPlayer;
import gaia.init.GaiaItems;
import gaia.init.GaiaLootTables;
import gaia.init.GaiaSounds;
import gaia.items.ItemShard;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
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
import net.minecraft.world.World;

public class EntityGaiaSatyress extends EntityMobAssistDay {
	private static final String MOB_TYPE_TAG = "MobType";
	private static final DataParameter<Integer> SKIN = EntityDataManager.createKey(EntityGaiaSatyress.class, DataSerializers.VARINT);

	private EntityAIAttackMelee aiMeleeAttack = new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_1, true);
	private EntityAIAvoidEntity<EntityPlayer> aiAvoid = new EntityAIAvoidEntity<>(this, EntityPlayer.class, 4.0F, EntityAttributes.ATTACK_SPEED_1, EntityAttributes.ATTACK_SPEED_3);
	private EntityAIAvoidEntity<EntityCreature> aiAvoidCreature = new EntityAIAvoidEntity<>(this, EntityCreature.class, 4.0F, EntityAttributes.ATTACK_SPEED_1, EntityAttributes.ATTACK_SPEED_3);
	private EntityAIAvoidEntity<EntityMob> aiAvoidMob = new EntityAIAvoidEntity<>(this, EntityMob.class, 4.0F, EntityAttributes.ATTACK_SPEED_1, EntityAttributes.ATTACK_SPEED_3);

	private int fullHealth;
	private int regenerateHealth;

	public EntityGaiaSatyress(World worldIn) {
		super(worldIn);

		experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
		stepHeight = 1.0F;

		fullHealth = 0;
		regenerateHealth = 0;
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
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, byte0 * 20, 0));
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
	public void onLivingUpdate() {
		/* REGENERATE DATA */
		if ((getHealth() < EntityAttributes.MAX_HEALTH_1 * 0.25F) && (fullHealth == 0)) {
			ItemStack stacky = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM, 1, 0), PotionTypes.REGENERATION);
			setItemStackToSlot(EntityEquipmentSlot.MAINHAND, stacky);
			setAI((byte) 1);
			setEquipment((byte) 1);

			fullHealth = 1;
		}

		if ((getHealth() < EntityAttributes.MAX_HEALTH_1) && (fullHealth == 1)) {
			if (regenerateHealth <= 100) {
				++regenerateHealth;
			} else {
				playSound(SoundEvents.ENTITY_GENERIC_DRINK, 0.15F, 1.0F);
				addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 360, 3));
				regenerateHealth = 0;
			}
		} else if ((getHealth() >= EntityAttributes.MAX_HEALTH_1) && (fullHealth == 1)) {
			setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_SWORD_WOOD));
			removePotionEffect(MobEffects.REGENERATION);
			setAI((byte) 0);
			setEquipment((byte) 0);

			fullHealth = 0;
			regenerateHealth = 0;
		}
		/* REGENERATE DATA */

		super.onLivingUpdate();
	}

	private void setAI(byte id) {
		if (id == 0) {
			tasks.removeTask(aiAvoid);
			tasks.removeTask(aiAvoidCreature);
			tasks.removeTask(aiAvoidMob);
			tasks.addTask(1, aiMeleeAttack);
		}

		if (id == 1) {
			tasks.removeTask(aiMeleeAttack);
			tasks.addTask(1, aiAvoid);
			tasks.addTask(1, aiAvoidCreature);
			tasks.addTask(1, aiAvoidMob);
		}
	}

	private void setEquipment(byte id) {
		if (id == 0) {
			setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.EGG));
		}

		if (id == 1) {
			setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.FEATHER));
		}
	}

	private void setCombatTask() {
		tasks.removeTask(aiMeleeAttack);
		tasks.removeTask(aiAvoid);

		setAI((byte) 0);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaSounds.SATYRESS_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaSounds.SATYRESS_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.SATYRESS_DEATH;
	}

	@Override
	protected void playStepSound(BlockPos pos, Block blockIn) {
		playSound(SoundEvents.ENTITY_PIG_STEP, 0.15F, 1.0F);
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return GaiaLootTables.ENTITIES_GAIA_SATYRESS;
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
		}
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, livingdata);

		if (!this.world.isRemote) {
			int i = MathHelper.floor(this.posX);
			int j = MathHelper.floor(this.posY);
			int k = MathHelper.floor(this.posZ);

			if (this.world.getBiome(new BlockPos(i, 0, k)).getTemperature(new BlockPos(i, j, k)) > 1.0F) {
				setTextureType(1);
			}
		}

		setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_SWORD_WOOD));
		setEnchantmentBasedOnDifficulty(difficulty);

		setCombatTask();

		return ret;
	}

	/* ALTERNATE SKIN */
	@Override
	protected void entityInit() {
		super.entityInit();
		dataManager.register(SKIN, 0);
	}

	public int getTextureType() {
		return dataManager.get(SKIN);
	}

	private void setTextureType(int par1) {
		dataManager.set(SKIN, par1);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setByte(MOB_TYPE_TAG, (byte) getTextureType());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		if (compound.hasKey(MOB_TYPE_TAG)) {
			byte b0 = compound.getByte(MOB_TYPE_TAG);
			setTextureType(b0);
		}

		setCombatTask();
	}
	/* ALTERNATE SKIN */

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
