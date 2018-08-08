package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobPassiveDay;
import gaia.entity.ai.EntityAIGaiaValidateTargetPlayer;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
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
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
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
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.UUID;

@SuppressWarnings({"squid:MaximumInheritanceDepth", "squid:S2160"})
public class EntityGaiaDryad extends EntityMobPassiveDay {

	private static final UUID MODIFIER_UUID = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
	private static final AttributeModifier MODIFIER = (new AttributeModifier(MODIFIER_UUID, "Attacking speed penalty", -0.05D, 0)).setSaved(false);
	private static final String MOB_TYPE_TAG = "MobType";

	private EntityAIAttackMelee aiMeleeAttack = new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_2, true);
	private EntityAIAvoidEntity<EntityPlayer> aiAvoid = new EntityAIAvoidEntity<>(this, EntityPlayer.class, 20.0F, EntityAttributes.ATTACK_SPEED_2, EntityAttributes.ATTACK_SPEED_3);

	private int switchHealth;
	private int axeAttack;

	private byte stamina;
	private byte staminaTimer;

	public EntityGaiaDryad(World worldIn) {
		super(worldIn);

		experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
		stepHeight = 1.0F;

		switchHealth = 0;
		axeAttack = 0;

		stamina = (30 * 4);
		staminaTimer = 0;
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
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.POISON, byte0 * 20, 0));
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
		if (isInWater()) {
			addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 10 * 20, 0));
		}

		if (isWet()) {
			addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 10 * 20, 0));
		}

		if (isBurning()) {
			addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 0));
			addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 100, 0));
		}

		if ((getHealth() < EntityAttributes.MAX_HEALTH_1 * 0.25F) && (switchHealth == 0)) {
			if (rand.nextInt(4) == 0) {
				tasks.removeTask(aiMeleeAttack);
				tasks.addTask(1, aiAvoid);
				switchHealth = 1;
			} else {
				switchHealth = 1;
			}
		}

		if (switchHealth == 1 && ticksExisted % 10 == 0) {
			world.setEntityState(this, (byte) 8);
		}

		if ((getHealth() > EntityAttributes.MAX_HEALTH_1 * 0.25F) && (switchHealth == 1)) {
			tasks.addTask(1, aiMeleeAttack);
			tasks.removeTask(aiAvoid);
			switchHealth = 0;
		}

		//Rough stamina system
		IAttributeInstance iattributeinstance = getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
		if (motionX * motionX + motionZ * motionZ > 2.500000277905201E-7D && rand.nextInt(5) == 0) {
			if (staminaTimer > 0) {
				staminaTimer = 0;
			}

			if (stamina > 0) {
				stamina -= 1;
			}

			if ((stamina <= 0) && (!iattributeinstance.hasModifier(MODIFIER))) {
				iattributeinstance.applyModifier(MODIFIER);
			}
		} else if (stamina < (30 * 4)) {
			if (staminaTimer < (10 * 4)) {
				staminaTimer += 1;
			} else {
				stamina = (30 * 4);

				if (iattributeinstance.hasModifier(MODIFIER)) {
					iattributeinstance.removeModifier(MODIFIER);
				}
			}
		}

		super.onLivingUpdate();
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return Sounds.ASSIST_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return Sounds.ASSIST_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return Sounds.ASSIST_DEATH;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				dropItem(GaiaItems.FoodRoot, 1);
			}

			if (axeAttack >= 4 && (rand.nextInt(2) == 0)) {
				dropItem(Item.getItemFromBlock(Blocks.LOG), rand.nextInt(2) + 1);
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
			if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0 || rand.nextInt(1 + lootingModifier) > 0) && rand.nextInt(1) == 0) {
				dropItem(GaiaItems.BoxIron, 1);
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
		tasks.addTask(1, aiMeleeAttack);

		if (world.rand.nextInt(4) == 0) {
			setTextureType(1);
		}

		// TEMP Method used instead of isChild
		if (world.rand.nextInt(10) == 0) {
			setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.EGG));
		}

		return ret;
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

	private static final DataParameter<Integer> SKIN = EntityDataManager.createKey(EntityGaiaDryad.class, DataSerializers.VARINT);

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
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		if (par1NBTTagCompound.hasKey(MOB_TYPE_TAG)) {
			byte b0 = par1NBTTagCompound.getByte(MOB_TYPE_TAG);
			setTextureType(b0);
		}
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setByte(MOB_TYPE_TAG, (byte) getTextureType());
	}

	@Override
	public boolean getCanSpawnHere() {
		return posY > 60.0D && super.getCanSpawnHere();
	}
}
