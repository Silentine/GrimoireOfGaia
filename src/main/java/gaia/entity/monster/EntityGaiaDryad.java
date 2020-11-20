package gaia.entity.monster;

import javax.annotation.Nullable;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobAssistDay;
import gaia.entity.ai.EntityAIGaiaValidateTargetPlayer;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaItems;
import gaia.init.GaiaLootTables;
import gaia.init.GaiaSounds;
import gaia.items.ItemShard;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityGaiaDryad extends EntityMobAssistDay {
	private static final String MOB_TYPE_TAG = "MobType";
	private static final String IS_CHILD_TAG = "IsBaby";

	private static final DataParameter<Integer> SKIN = EntityDataManager.createKey(EntityGaiaDryad.class, DataSerializers.VARINT);
	private static final DataParameter<Boolean> IS_CHILD = EntityDataManager.<Boolean>createKey(EntityGaiaDryad.class, DataSerializers.BOOLEAN);

	private EntityAIAttackMelee aiMeleeAttack = new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_1, true);
	private EntityAIAvoidEntity<EntityPlayer> aiAvoid = new EntityAIAvoidEntity<>(this, EntityPlayer.class, 4.0F, EntityAttributes.ATTACK_SPEED_1, EntityAttributes.ATTACK_SPEED_3);
	private EntityAIAvoidEntity<EntityCreature> aiAvoidCreature = new EntityAIAvoidEntity<>(this, EntityCreature.class, 4.0F, EntityAttributes.ATTACK_SPEED_1, EntityAttributes.ATTACK_SPEED_3);
	private EntityAIAvoidEntity<EntityMob> aiAvoidMob = new EntityAIAvoidEntity<>(this, EntityMob.class, 4.0F, EntityAttributes.ATTACK_SPEED_1, EntityAttributes.ATTACK_SPEED_3);

	private int switchHealth;
	private int axeAttack;

	private byte inWaterTimer;

	public EntityGaiaDryad(World worldIn) {
		super(worldIn);

		if (isChild()) {
			setSize(1.0F, 0.5F);
		}

		experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
		stepHeight = 1.0F;

		switchHealth = 0;
		axeAttack = 0;

		inWaterTimer = 0;
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_1, true));
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
		float input = Math.min(damage, EntityAttributes.BASE_DEFENSE_1);
		Entity entity = source.getTrueSource();

		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			ItemStack itemstack = player.getHeldItem(getActiveHand());

			if (itemstack.getItem() instanceof ItemAxe) {
				input = input * 1.5F;
				axeAttack += 1;
			}
		}

		return super.attackEntityFrom(source, input);
	}

	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
		super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_1);
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
		if (!world.isRemote) {
			if (isWet()) {
				if (inWaterTimer <= 100) {
					++inWaterTimer;
				} else {
					world.setEntityState(this, (byte) 8);
					heal(EntityAttributes.MAX_HEALTH_1 * 0.10F);
					addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 5 * 20, 0));
					inWaterTimer = 0;
				}
			}
		}

		if (isBurning()) {
			addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 0));
			addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 100, 0));
		}

		/* FLEE DATA */
		if ((getHealth() < EntityAttributes.MAX_HEALTH_1 * 0.25F) && (switchHealth == 0)) {
			switch (rand.nextInt(2)) {
			case 0:
				setAI((byte) 1);
				setEquipment((byte) 1);
				switchHealth = 1;
				break;
			case 1:
				switchHealth = 2;
				break;
			}
		}

		if ((getHealth() > EntityAttributes.MAX_HEALTH_1 * 0.25F) && (switchHealth == 1)) {
			setAI((byte) 0);
			setEquipment((byte) 0);

			switchHealth = 0;
		}
		/* FLEE DATA */

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
			setItemStackToSlot(EntityEquipmentSlot.HEAD, ItemStack.EMPTY);
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
		return GaiaSounds.DRYAD_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaSounds.DRYAD_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.DRYAD_DEATH;
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return GaiaLootTables.ENTITIES_GAIA_DRYAD;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				dropItem(GaiaItems.FOOD_ROOT, 1);
			}

			if (axeAttack >= 4 && (rand.nextInt(2) == 0)) {
				dropItem(Item.getItemFromBlock(Blocks.LOG), rand.nextInt(2) + 1);
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
				dropItem(Item.getItemFromBlock(GaiaBlocks.DOLL_DRYAD), 1);
			}
		}
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, livingdata);

		if (world.rand.nextInt(4) == 0) {
			setTextureType(1);
		}

		setChild(true, 10);

		setCombatTask();

		return ret;
	}

	/* CHILD CODE */
	private void setChild(boolean isRandom, int chance) {
		if (isRandom) {
			if (world.rand.nextInt(chance) == 0) {
				setChild(true);
			}
		} else {
			setChild(true);
		}
	}

	@Override
	public float getEyeHeight() {
		float f;

		ItemStack itemstack = getItemStackFromSlot(EntityEquipmentSlot.CHEST);

		if (itemstack.isEmpty() || itemstack.getItem() != Items.EGG) {
			f = 1.74F;
		} else {
			f = 1.74F - 0.81F;
		}

		return f;
	}
	/* CHILD CODE */

	/* ALTERNATE SKIN */
	@Override
	protected void entityInit() {
		super.entityInit();
		dataManager.register(SKIN, 0);
		dataManager.register(IS_CHILD, false);
	}

	public int getTextureType() {
		return dataManager.get(SKIN);
	}

	private void setTextureType(int par1) {
		dataManager.set(SKIN, par1);
	}

	public boolean isChild() {
		return ((Boolean) getDataManager().get(IS_CHILD)).booleanValue();
	}

	public void setChild(boolean isChild) {
		getDataManager().set(IS_CHILD, Boolean.valueOf(isChild));
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setByte(MOB_TYPE_TAG, (byte) getTextureType());
		compound.setBoolean(IS_CHILD_TAG, isChild());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		if (compound.hasKey(MOB_TYPE_TAG)) {
			byte b0 = compound.getByte(MOB_TYPE_TAG);
			setTextureType(b0);
		}

		if (compound.hasKey(IS_CHILD_TAG)) {
			boolean b0 = compound.getBoolean(IS_CHILD_TAG);
			setChild(b0);
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
