package gaia.entity.monster;

import java.util.List;

import javax.annotation.Nullable;

import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobPassiveDay;
import gaia.entity.ai.EntityAIGaiaValidateTargetPlayer;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SuppressWarnings({ "squid:MaximumInheritanceDepth", "squid:S2160" })
public class EntityGaiaValkyrie extends EntityMobPassiveDay {

	private static final double DETECTION_RANGE = 6D;
	private EntityAINearestAttackableTarget<EntityPlayer> aiNearestAttackableTarget = new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, true);

	private int equipItems;
	private int aggression;
	private int aggressive;

	private int buffEffect;
	private boolean animationPlay;
	private int animationTimer;

	@SuppressWarnings("WeakerAccess") // used in reflection
	public EntityGaiaValkyrie(World worldIn) {
		super(worldIn);

		setSize(1.0F, 2.0F);
		experienceValue = EntityAttributes.EXPERIENCE_VALUE_3;
		stepHeight = 1.0F;
		isImmuneToFire = true;

		equipItems = 0;
		aggression = 0;
		aggressive = 0;

		buffEffect = 0;
		animationPlay = false;
		animationTimer = 0;
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_3, true));
		tasks.addTask(2, new EntityAIWander(this, 0.8D));
		tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		tasks.addTask(3, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		targetTasks.addTask(2, new EntityAIGaiaValidateTargetPlayer(this));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.MAX_HEALTH_3);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.FOLLOW_RANGE);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.MOVE_SPEED_3);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityAttributes.ATTACK_DAMAGE_3);
		getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.RATE_ARMOR_3);
		getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.25D);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float damage) {
		return !(source instanceof EntityDamageSourceIndirect) && super.attackEntityFrom(source, Math.min(damage, EntityAttributes.BASE_DEFENSE_3));
	}

	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
		super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_3);
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		if (super.attackEntityAsMob(entityIn)) {
			if (entityIn instanceof EntityLivingBase) {
				byte byte0 = 0;
				byte byte1 = 0;

				if (world.getDifficulty() == EnumDifficulty.NORMAL) {
					byte0 = 20;
					byte1 = 10;
				} else if (world.getDifficulty() == EnumDifficulty.HARD) {
					byte0 = 30;
					byte1 = 20;
				}

				if (byte0 > 0) {
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, byte0 * 20, 0));
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, byte1 * 20, 0));
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

		/* AGGRESSION */
//		ItemStack itemstack = getItemStackFromSlot(EntityEquipmentSlot.MAINHAND);
//		if (equipItems == 0 && itemstack.isEmpty()) {	
		if (equipItems == 0) {
			if (aggressive <= 4) {
				if (playerDetection(DETECTION_RANGE)) {
					if (aggression <= 60) {
						aggression += 1;
					} else {
						aggression = 0;
						aggressive += 1;
					}

					if (aggression >= 50) {
						world.setEntityState(this, (byte) 13);
					}
				}
			} else {
				SetAI((byte) 0);
				SetEquipment((byte) 2);

				equipItems = 1;
			}
		}

		if (getHealth() < EntityAttributes.MAX_HEALTH_3 * 1.00F && equipItems == 0) {
			SetAI((byte) 0);
			SetEquipment((byte) 2);

			equipItems = 1;
		}
		/* AGGRESSION */

		/* BUFF */
		if (getHealth() <= EntityAttributes.MAX_HEALTH_3 * 0.25F && getHealth() > 0.0F && buffEffect == 0) {
			SetEquipment((byte) 1);
			animationPlay = true;

			addPotionEffect(new PotionEffect(MobEffects.SPEED, 20 * 60, 0));
			addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 20 * 60, 0));

			buffEffect = 1;
		}

		if (getHealth() > EntityAttributes.MAX_HEALTH_3 * 0.25F && buffEffect == 1) {
			buffEffect = 0;
			animationPlay = false;
			animationTimer = 0;
		}

		if (animationPlay) {
			if (animationTimer != 30) {
				animationTimer += 1;
			} else {
				SetEquipment((byte) 0);
				animationPlay = false;
			}
		}
		/* BUFF */

		if (getHealth() <= 0.0F) {
			world.setEntityState(this, (byte) 14);
		} else {
			super.onLivingUpdate();
		}
	}

	private void SetAI(byte id) {
		if (id == 0) {
			targetTasks.addTask(2, aiNearestAttackableTarget);
		}
	}

	private void SetEquipment(byte id) {
		if (id == 0) {
			setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.EGG));
		}

		if (id == 1) {
			setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.STICK));
		}

		if (id == 2) {
			ItemStack shield = new ItemStack(GaiaItems.SHIELD_PROP, 1, 0);
			setItemStackToSlot(EntityEquipmentSlot.OFFHAND, shield);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 13) {
			this.spawnParticles(EnumParticleTypes.VILLAGER_ANGRY);
		} else if (id == 14) {
			this.spawnParticles(EnumParticleTypes.EXPLOSION_LARGE);
		} else {
			super.handleStatusUpdate(id);
		}
	}

	@SideOnly(Side.CLIENT)
	private void spawnParticles(EnumParticleTypes particleType) {
		for (int i = 0; i < 5; ++i) {
			double d0 = this.rand.nextGaussian() * 0.02D;
			double d1 = this.rand.nextGaussian() * 0.02D;
			double d2 = this.rand.nextGaussian() * 0.02D;
			this.world.spawnParticle(particleType, this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, this.posY + 1.0D + (double) (this.rand.nextFloat() * this.height), this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, d0, d1, d2);
		}
	}

	/**
	 * Detects if there are any EntityPlayer nearby
	 */
	private boolean playerDetection(double range) {
		AxisAlignedBB axisalignedbb = (new AxisAlignedBB(posX, posY, posZ, posX + 1, posY + 1, posZ + 1)).grow(range);
		List<EntityPlayer> list = world.getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);

		return !list.isEmpty();

	}

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
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if ((rand.nextInt(4) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				dropItem(GaiaItems.FOOD_SMALL_APPLE_GOLD, 1);
			}

			// Nuggets/Fragments
			int var11 = rand.nextInt(3) + 1;

			for (int var12 = 0; var12 < var11; ++var12) {
				ItemShard.dropNugget(this, 2);
			}

			int var13 = rand.nextInt(3) + 1;

			for (int var14 = 0; var14 < var13; ++var14) {
				ItemShard.dropNugget(this, 3);
			}

			// Rare
			if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				int i = rand.nextInt(3);
				if (i == 0) {
					dropItem(GaiaItems.BOX_DIAMOND, 1);
				} else if (i == 1) {
					dropItem(Item.getItemFromBlock(GaiaBlocks.BUST_VALKYRIE), 1);
				} else if (i == 2) {
					entityDropItem(new ItemStack(GaiaItems.MISC_RING, 1, 0), 0.0F);
				}
			}
		}
	}

	@Override
	protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier) {
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, livingdata);
		
		setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_SWORD_IRON));
		setEnchantmentBasedOnDifficulty(difficulty);

		ItemStack bootsSwimming = new ItemStack(Items.LEATHER_BOOTS);
		setItemStackToSlot(EntityEquipmentSlot.FEET, bootsSwimming);
		bootsSwimming.addEnchantment(Enchantments.DEPTH_STRIDER, 2);
		
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
	public int getMaxSpawnedInChunk() {
		return 1;
	}

	@Override
	public boolean getCanSpawnHere() {
		return posY > 80.0D && super.getCanSpawnHere();
	}
}
