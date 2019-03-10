package gaia.entity.monster;

import javax.annotation.Nullable;

import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.entity.GaiaLootTableList;
import gaia.entity.ai.EntityAIGaiaAttackRangedBow;
import gaia.entity.ai.GaiaIRangedAttackMob;
import gaia.entity.ai.Ranged;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
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
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SuppressWarnings({ "squid:MaximumInheritanceDepth", "squid:S2160" })
public class EntityGaiaGoblinFeral extends EntityMobHostileBase implements GaiaIRangedAttackMob {

	private int lastActiveTime;
	private int timeSinceIgnited;
	private int fuseTime = 30;
	private int explosionRadius = 3;
	private float explosionPower = 1.0F;
	private static final String MOB_TYPE_TAG = "MobType";

	private EntityAIGaiaAttackRangedBow aiArrowAttack = new EntityAIGaiaAttackRangedBow(this, EntityAttributes.ATTACK_SPEED_1, 20, 15.0F);
	private EntityAIAttackMelee aiAttackOnCollide = new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_1, true) {
		public void resetTask() {
			super.resetTask();
			EntityGaiaGoblinFeral.this.setSwingingArms(false);
		}

		public void startExecuting() {
			super.startExecuting();
			EntityGaiaGoblinFeral.this.setSwingingArms(true);
		}
	};

	private static final DataParameter<Integer> SKIN = EntityDataManager.createKey(EntityGaiaGoblinFeral.class, DataSerializers.VARINT);
	private static final DataParameter<Boolean> SWINGING_ARMS = EntityDataManager.createKey(EntityGaiaGoblinFeral.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IGNITED = EntityDataManager.createKey(EntityGaiaGoblinFeral.class, DataSerializers.BOOLEAN);

	private static final ItemStack TIPPED_ARROW_CUSTOM = PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), PotionTypes.SLOWNESS);

	public EntityGaiaGoblinFeral(World worldIn) {
		super(worldIn);

		stepHeight = 1.0F;
		setCanPickUpLoot(true);

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
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.MAX_HEALTH_1 * 0.5);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.FOLLOW_RANGE);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.MOVE_SPEED_1);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityAttributes.ATTACK_DAMAGE_1 * 0.5);
		getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.RATE_ARMOR_1);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (hasShield()) {
			Entity entity = source.getImmediateSource();
			return !(entity instanceof EntityArrow) && super.attackEntityFrom(source, Math.min(amount, EntityAttributes.BASE_DEFENSE_1));
		} else {
			return super.attackEntityFrom(source, amount);
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
	public boolean attackEntityAsMob(Entity entityIn) {
		if (super.attackEntityAsMob(entityIn)) {
			if (getMobType() == 2 && entityIn instanceof EntityLivingBase) {
				tasks.removeTask(aiAttackOnCollide);
				ignite();
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
		super.onLivingUpdate();
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

	@Override
	protected void entityInit() {
		super.entityInit();
		dataManager.register(SKIN, 0);
		dataManager.register(SWINGING_ARMS, Boolean.valueOf(false));
		dataManager.register(IGNITED, Boolean.FALSE);
	}

	/* ARCHER DATA */
	@Override
	public boolean canAttackClass(Class<? extends EntityLivingBase> cls) {
		return super.canAttackClass(cls) && cls != EntityGaiaGoblinFeral.class;
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
		if (!target.isDead) {
			Ranged.rangedAttack(target, this, distanceFactor);
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean isSwingingArms() {
		return ((Boolean) this.dataManager.get(SWINGING_ARMS)).booleanValue();
	}

	public void setSwingingArms(boolean swingingArms) {
		dataManager.set(SWINGING_ARMS, Boolean.valueOf(swingingArms));
	}
	/* ARCHER DATA */

	/* BOMBER DATA */
	@Override
	public void onUpdate() {
		if (hasIgnited()) {
			if (isEntityAlive()) {
				lastActiveTime = timeSinceIgnited;

				int i = 1;

				if (i > 0 && timeSinceIgnited == 0) {
					playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0F, 0.5F);
				}

				timeSinceIgnited += i;

				if (timeSinceIgnited < 0) {
					timeSinceIgnited = 0;
				}

				if (timeSinceIgnited >= fuseTime) {
					timeSinceIgnited = fuseTime;
					explode();
				}
			}
		}

		super.onUpdate();
	}

	private boolean hasIgnited() {
		return dataManager.get(IGNITED);
	}

	private void ignite() {
		dataManager.set(IGNITED, true);
	}

	private void explode() {
		if (!world.isRemote) {
			dead = true;
			world.createExplosion(this, this.posX, this.posY, this.posZ, (float) explosionRadius * explosionPower, false);
			setDead();
		}
	}

	@SideOnly(Side.CLIENT)
	public float getCreeperFlashIntensity(float partialTickTime) {
		return (lastActiveTime + (timeSinceIgnited - lastActiveTime) * partialTickTime) / (fuseTime - 2);
	}
	/* BOMBER DATA */

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaSounds.GOBLIN_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaSounds.GOBLIN_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.GOBLIN_DEATH;
	}

	public void onDeath(DamageSource cause) {
		super.onDeath(cause);

		if (getMobType() == 2) {
			explode();
		}
	}
	
	@Nullable
	protected ResourceLocation getLootTable() {
		switch (getMobType()) {
		case 0:
			return GaiaLootTableList.ENTITIES_GAIA_GOBLIN_FERAL_MELEE;
		case 1:
			return GaiaLootTableList.ENTITIES_GAIA_GOBLIN_FERAL_RANGED;
		case 2:
			return GaiaLootTableList.ENTITIES_GAIA_GOBLIN_FERAL_BOMBER;
		default:
			return LootTableList.EMPTY;
		}
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			// Rare
			if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0)) {
				dropItem(Items.IRON_NUGGET, 1);
			}
		}
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, livingdata);

		if (world.rand.nextInt(4) == 0) {
			setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
			setEnchantmentBasedOnDifficulty(difficulty);

			setTextureType(1);
		} else {
			if (world.rand.nextInt(4) == 0) {
				setMobType(2);
				setTextureType(2);
			} else {
				setEquipmentBasedOnDifficulty(difficulty);

				setMobType(0);
				setTextureType(0);
			}
		}

		setCombatTask();

		return ret;
	}

	@Override
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		if (rand.nextInt(4) == 0) {
			setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_SWORD_WOOD));
			setEnchantmentBasedOnDifficulty(difficulty);
		} else {
			setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_AXE_WOOD));
			setEnchantmentBasedOnDifficulty(difficulty);
		}
	}

	/* SPAWN CONDITIONS */
	@Override
	public int getMaxSpawnedInChunk() {
		return EntityAttributes.CHUNK_LIMIT_1;
	}

	@Override
	public boolean getCanSpawnHere() {
		return posY > 60.0D && super.getCanSpawnHere();
	}
	/* SPAWN CONDITIONS */
}
