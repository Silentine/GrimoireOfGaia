package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobAssistDay;
import gaia.entity.GaiaLootTableList;
import gaia.entity.ai.EntityAIGaiaValidateTargetPlayer;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import gaia.items.ItemShard;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityGaiaYukiOnna extends EntityMobAssistDay {
	private static final String IS_CHILD_TAG = "IsBaby";

	private static final DataParameter<Boolean> IS_CHILD = EntityDataManager.<Boolean>createKey(EntityGaiaYukiOnna.class, DataSerializers.BOOLEAN);

	private EntityAIAttackMelee aiMeleeAttack = new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_2, true);
	private EntityAIAvoidEntity<EntityPlayer> aiAvoid = new EntityAIAvoidEntity<>(this, EntityPlayer.class, 20.0F, EntityAttributes.ATTACK_SPEED_2, EntityAttributes.ATTACK_SPEED_3);

	private int switchHealth;
	private boolean isChild;

	public EntityGaiaYukiOnna(World worldIn) {
		super(GaiaEntities.YUKI_ONNA, worldIn);

		experienceValue = EntityAttributes.EXPERIENCE_VALUE_2;
		stepHeight = 1.0F;

		switchHealth = 0;
		isChild = false;
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
		return super.attackEntityFrom(source, Math.min(damage, EntityAttributes.BASE_DEFENSE_2));
	}

	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
		super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_2);
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
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, byte0 * 20, 3));
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
		/* FLEE DATA */
		if ((getHealth() < EntityAttributes.MAX_HEALTH_2 * 0.25F) && (switchHealth == 0)) {
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

		if ((getHealth() > EntityAttributes.MAX_HEALTH_2 * 0.25F) && (switchHealth == 1)) {
			setAI((byte) 0);
			setEquipment((byte) 0);

			switchHealth = 0;
		}
		/* FLEE DATA */

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
			tasks.addTask(1, aiMeleeAttack);
			tasks.removeTask(aiAvoid);
		}

		if (id == 1) {
			tasks.removeTask(aiMeleeAttack);
			tasks.addTask(1, aiAvoid);
		}
	}

	private void setEquipment(byte id) {
		if (id == 0) {
			setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.EGG));
		}

		if (id == 1) {
			setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.FEATHER));
		}

		if (id == 2) {
			setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.EGG));
		}
	}

	private void setCombatTask() {
		tasks.removeTask(aiMeleeAttack);
		tasks.removeTask(aiAvoid);

		setAI((byte) 0);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaSounds.YUKIONNA_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaSounds.YUKIONNA_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.YUKIONNA_DEATH;
	}

	@Override
	protected void playStepSound(BlockPos pos, IBlockState blockIn) {
		playSound(GaiaSounds.NONE, 1.0F, 1.0F);
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return GaiaLootTableList.ENTITIES_GAIA_YUKI_ONNA;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			int drop = rand.nextInt(3 + lootingModifier);

			for (int i = 0; i < drop; ++i) {
				entityDropItem(GaiaItems.MISC_FUR, 1);
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
				ItemStack fanIce = new ItemStack(GaiaItems.WEAPON_FAN_ICE);
				fanIce.addEnchantment(Enchantments.KNOCKBACK, 4);
				entityDropItem(fanIce, 1);
			}
		}
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData entityLivingData, NBTTagCompound itemNbt) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, entityLivingData, itemNbt);

		if (!isChild) {
			setEquipmentEnchanted();
		}

		setCombatTask();

		return ret;
	}

	protected void setEquipmentEnchanted() {
		ItemStack weapon;

		if (rand.nextInt(4) == 0) {
			weapon = new ItemStack(GaiaItems.WEAPON_FAN, 1);
			weapon.addEnchantment(Enchantments.KNOCKBACK, 3);
		} else {
			weapon = new ItemStack(GaiaItems.WEAPON_PROP_ENCHANTED, 1);
			weapon.addEnchantment(Enchantments.KNOCKBACK, 2);
		}

		setItemStackToSlot(EntityEquipmentSlot.MAINHAND, weapon);
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
	protected void registerData() {
		super.registerData();
		this.getDataManager().register(IS_CHILD, false);
	}

	public boolean isChild() {
		return ((Boolean) getDataManager().get(IS_CHILD)).booleanValue();
	}

	public void setChild(boolean isChild) {
		getDataManager().set(IS_CHILD, Boolean.valueOf(isChild));
	}

	@Override
	public void writeAdditional(NBTTagCompound compound) {
		super.writeAdditional(compound);
		compound.setBoolean(IS_CHILD_TAG, isChild());
	}

	@Override
	public void readAdditional(NBTTagCompound compound) {
		super.readAdditional(compound);
		if (compound.hasKey(IS_CHILD_TAG)) {
			boolean b0 = compound.getBoolean(IS_CHILD_TAG);
			setChild(b0);
		}

		setCombatTask();
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

	@Override
	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.UNDEAD;
	}

	/* IMMUNITIES */
	@Override
	protected int getFireImmuneTicks() {
		return 20;
	}

	@Override
	public void fall(float distance, float damageMultiplier) {
	}

	@Override
	public void setInWeb() {
	}
	/* IMMUNITIES */

	/* SPAWN CONDITIONS */
	private boolean isSnowing() {
		return world.isRaining();
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return EntityAttributes.CHUNK_LIMIT_2;
	}

	@Override
	public boolean canSpawn(IWorld p_205020_1_, boolean p_205020_2_) {
		return posY > 60.0D && isSnowing() && super.canSpawn(world, p_205020_2_);
	}
	/* SPAWN CONDITIONS */
}
