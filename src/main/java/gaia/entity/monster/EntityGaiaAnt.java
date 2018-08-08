package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileDay;
import gaia.entity.ai.EntityAIGaiaAttackRangedBow;
import gaia.entity.ai.GaiaIRangedAttackMob;
import gaia.entity.ai.Ranged;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
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
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@SuppressWarnings({"squid:MaximumInheritanceDepth", "squid:S2160"})
public class EntityGaiaAnt extends EntityMobHostileDay implements GaiaIRangedAttackMob {
	private static final String MOB_TYPE_TAG = "MobType";
	private EntityAIGaiaAttackRangedBow aiArrowAttack = new EntityAIGaiaAttackRangedBow(this, EntityAttributes.ATTACK_SPEED_1, 20, 15.0F);
	private EntityAIAttackMelee aiAttackOnCollide = new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_1, true);

	private static final DataParameter<Integer> SKIN = EntityDataManager.createKey(EntityGaiaAnt.class, DataSerializers.VARINT);
	private static final DataParameter<Boolean> HOLDING_BOW = EntityDataManager.createKey(EntityGaiaAnt.class, DataSerializers.BOOLEAN);
	private static final ItemStack TIPPED_ARROW_CUSTOM = PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), PotionTypes.SLOWNESS);
	private static final ItemStack TIPPED_ARROW_CUSTOM_2 = PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), PotionTypes.WEAKNESS);

	private int mobClass;

	public EntityGaiaAnt(World world) {
		super(world);

		experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
		stepHeight = 1.0F;

		setPathPriority(PathNodeType.DANGER_FIRE, 0.0F);

		mobClass = 0;

		if (!world.isRemote) {
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
	public boolean isAIDisabled() {
		return false;
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		if (super.attackEntityAsMob(entityIn)) {
			if (getMobType() == 1 && entityIn instanceof EntityLivingBase) {
				byte byte0 = 0;

				if (world.getDifficulty() == EnumDifficulty.NORMAL) {
					byte0 = 5;
				} else if (world.getDifficulty() == EnumDifficulty.HARD) {
					byte0 = 10;
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
	public void setItemStackToSlot(EntityEquipmentSlot par1, ItemStack par2ItemStack) {
		super.setItemStackToSlot(par1, par2ItemStack);
		if (!world.isRemote && par1.getIndex() == 0) {
			setCombatTask();
		}
	}

	private void setCombatTask() {
		tasks.removeTask(aiAttackOnCollide);
		tasks.removeTask(aiArrowAttack);

		ItemStack itemstack = getHeldItemMainhand();

		if (itemstack.getItem() == Items.BOW) {
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
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		if (par1NBTTagCompound.hasKey(MOB_TYPE_TAG)) {
			byte b0 = par1NBTTagCompound.getByte(MOB_TYPE_TAG);
			setMobType(b0);
		}

		setCombatTask();
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setByte(MOB_TYPE_TAG, (byte) getMobType());
	}

	// ================= Archer data =================//
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
		Ranged.rangedAttack(target, this, distanceFactor);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		dataManager.register(SKIN, 0);
		dataManager.register(HOLDING_BOW, false);
	}

	@Override
	public boolean canAttackClass(Class<? extends EntityLivingBase> cls) {
		return super.canAttackClass(cls) && cls != EntityGaiaAnt.class;
	}

	@SideOnly(Side.CLIENT)
	public boolean isHoldingBow() {
		return dataManager.get(HOLDING_BOW);
	}

	public void setHoldingBow(boolean swingingArms) {
		dataManager.set(HOLDING_BOW, swingingArms);
	}
	// ===============================================//

	@Override
	protected SoundEvent getAmbientSound() {
		return Sounds.AGGRESSIVE_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return Sounds.AGGRESSIVE_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return Sounds.AGGRESSIVE_DEATH;
	}

	@Override
	protected void playStepSound(BlockPos pos, Block blockIn) {
		playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.15F, 1.0F);
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if (mobClass == 1) {
				if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
					dropItem(Items.ARROW, 1);
				}
			} else {
				if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
					dropItem(GaiaItems.FoodMeat, 1);
				}
			}

			// Nuggets/Fragments
			int var11 = rand.nextInt(3) + 1;

			for (int var12 = 0; var12 < var11; ++var12) {
				ItemShard.Drop_Nugget(this, 0);
			}

			if (GaiaConfig.OPTIONS.additionalOre) {
				int var13 = rand.nextInt(3) + 1;

				for (int var14 = 0; var14 < var13; ++var14) {
					ItemShard.Drop_Nugget(this, 4);
				}
			}

			// Rare
			if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				if (mobClass == 1) {
					int i = rand.nextInt(2);
					if (i == 0) {
						dropItem(GaiaItems.BoxIron, 1);

					} else if (i == 1) {
						dropItem(GaiaItems.BagArrow, 1);
					}
				} else {
					if (rand.nextInt(1) == 0) {
						dropItem(GaiaItems.BoxIron, 1);

					}
				}
			}
		}
	}

	@Override
	protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier) {
		//noop
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, livingdata);

		if (world.rand.nextInt(2) == 0) {
			tasks.addTask(1, aiArrowAttack);
			setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
			setEnchantmentBasedOnDifficulty(difficulty);

			if (world.rand.nextInt(2) == 0) {
				if (world.rand.nextInt(2) == 0) {
					setItemStackToSlot(EntityEquipmentSlot.OFFHAND, TIPPED_ARROW_CUSTOM);
				} else {
					setItemStackToSlot(EntityEquipmentSlot.OFFHAND, TIPPED_ARROW_CUSTOM_2);
				}
			}

			setTextureType(1);
			mobClass = 1;
		} else {
			tasks.addTask(1, aiAttackOnCollide);
			setEquipmentBasedOnDifficulty(difficulty);
			setEnchantmentBasedOnDifficulty(difficulty);
			setMobType(1);
			getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityAttributes.ATTACK_DAMAGE_1);
			setTextureType(0);
			mobClass = 0;
		}

		return ret;
	}

	@Override
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		int i = rand.nextInt(3);

		if (i == 0) {
			setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_AXE));
		} else {
			setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_SWORD));
		}
	}

	@Override
	public @Nonnull
	EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.ARTHROPOD;
	}

	// ================= Immunities =================//
	@Override
	public boolean isPotionApplicable(@Nonnull PotionEffect potioneffectIn) {
		return potioneffectIn.getPotion() != MobEffects.POISON && super.isPotionApplicable(potioneffectIn);
	}
	// ==============================================//

	@Override
	public boolean getCanSpawnHere() {
		return posY > 60.0D && super.getCanSpawnHere();
	}

}
