package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

@SuppressWarnings({"squid:MaximumInheritanceDepth", "squid:S2160"})
public class EntityGaiaWitch extends EntityMobHostileBase implements IRangedAttackMob {

	private int spawn;

	private static final UUID MODIFIER_UUID = UUID.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E");
	private static final AttributeModifier MODIFIER = (new AttributeModifier(MODIFIER_UUID, "Drinking speed penalty", -0.25D, 0)).setSaved(false);
	private static final DataParameter<Boolean> IS_AGGRESSIVE = EntityDataManager.createKey(EntityWitch.class, DataSerializers.BOOLEAN);

	private int witchAttackTimer;

	public EntityGaiaWitch(World par1World) {
		super(par1World);

		experienceValue = EntityAttributes.EXPERIENCE_VALUE_2;
		stepHeight = 1.0F;

		spawn = 0;
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAIAttackRanged(this, EntityAttributes.ATTACK_SPEED_2, 60, 10.0F));
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

	private void setAggressive(boolean aggressive) {
		getDataManager().set(IS_AGGRESSIVE, aggressive);
	}

	private boolean isDrinkingPotion() {
		return getDataManager().get(IS_AGGRESSIVE);
	}

	@Override
	public boolean isAIDisabled() {
		return false;
	}

	@Override
	public void onLivingUpdate() {
		beaconMonster();

		if (!onGround && motionY < 0.0D) {
			motionY *= 0.8D;
		}

		if (motionX > 0 || motionY > 0 || motionZ > 0) {
			for (int var5 = 0; var5 < 2; ++var5) {
				world.spawnParticle(EnumParticleTypes.SPELL_WITCH,
						posX + (rand.nextDouble() - 0.5D) * width,
						posY + rand.nextDouble() * height,
						posZ + (rand.nextDouble() - 0.5D) * width, 0.0D, 0.0D, 0.0D);
			}
		}

		EntitySpider spawnMob;
		if (getHealth() < EntityAttributes.MAX_HEALTH_2 * 0.75F && getHealth() > 0.0F && spawn == 0) {
			world.setEntityState(this, (byte) 12);

			if (!world.isRemote) {
				spawnMob = new EntitySpider(world);
				spawnMob.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
				spawnMob.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(spawnMob)), null);
				world.spawnEntity(spawnMob);
			}
			spawn = 1;
		}

		if (getHealth() < EntityAttributes.MAX_HEALTH_2 * 0.25F && getHealth() > 0.0F && spawn == 1) {
			world.setEntityState(this, (byte) 12);

			if (!world.isRemote) {
				spawnMob = new EntitySpider(world);
				spawnMob.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
				spawnMob.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(spawnMob)), null);
				world.spawnEntity(spawnMob);
			}
			spawn = 2;
		}

		if (!world.isRemote) {
			if (isDrinkingPotion()) {
				if (witchAttackTimer-- <= 0) {
					setAggressive(false);
					ItemStack itemstack = getHeldItemMainhand();
					setItemStackToSlot(EntityEquipmentSlot.MAINHAND, ItemStack.EMPTY);

					if (itemstack.getItem() == Items.POTIONITEM) {
						List<PotionEffect> list = PotionUtils.getEffectsFromStack(itemstack);

						for (PotionEffect potioneffect : list) {
							addPotionEffect(new PotionEffect(potioneffect));
						}
					}

					getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED)
							.removeModifier(MODIFIER);
				}
			} else {
				setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.PropWeapon, 1, 0));
				PotionType potiontype = null;

				if (rand.nextFloat() < 0.15F && isInsideOfMaterial(Material.WATER) && !isPotionActive(MobEffects.WATER_BREATHING)) {
					potiontype = PotionTypes.WATER_BREATHING;
				} else if (rand.nextFloat() < 0.15F && (isBurning() || getLastDamageSource() != null && getLastDamageSource()
						.isFireDamage()) &&
						!isPotionActive(MobEffects.FIRE_RESISTANCE)) {
					potiontype = PotionTypes.FIRE_RESISTANCE;
				} else if (rand.nextFloat() < 0.05F && getHealth() < getMaxHealth()) {
					potiontype = PotionTypes.HEALING;
				} else if (rand.nextFloat() < 0.5F && getAttackTarget() != null && !isPotionActive(MobEffects.SPEED) &&
						getAttackTarget().getDistanceSq(this) > 121.0D) {
					potiontype = PotionTypes.SWIFTNESS;
				}

				if (potiontype != null) {
					setItemStackToSlot(EntityEquipmentSlot.MAINHAND,
							PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), potiontype));
					witchAttackTimer = getHeldItemMainhand()
							.getMaxItemUseDuration();
					setAggressive(true);
					world.playSound(null, posX, posY, posZ, SoundEvents.ENTITY_WITCH_DRINK,
							getSoundCategory(), 1.0F,
							0.8F + rand.nextFloat() * 0.4F);
					IAttributeInstance iattributeinstance = getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
					iattributeinstance.removeModifier(MODIFIER);
					iattributeinstance.applyModifier(MODIFIER);
				}
			}

			if (rand.nextFloat() < 7.5E-4F) {
				world.setEntityState(this, (byte) 15);
			}
		}

		super.onLivingUpdate();
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		getDataManager().register(IS_AGGRESSIVE, false);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void handleStatusUpdate(byte id) {
		if (id == 12) {
			spawnParticles(EnumParticleTypes.EXPLOSION_NORMAL);
		} else if (id == 15) {
			for (int i = 0; i < rand.nextInt(35) + 10; ++i) {
				world.spawnParticle(EnumParticleTypes.SPELL_WITCH,
						posX + rand.nextGaussian() * 0.12999999523162842D,
						getEntityBoundingBox().maxY + 0.5D + rand.nextGaussian() * 0.12999999523162842D,
						posZ + rand.nextGaussian() * 0.13D, 0.0D, 0.0D, 0.0D);
			}
		} else {
			super.handleStatusUpdate(id);
		}
	}

	@SideOnly(Side.CLIENT)
	private void spawnParticles(EnumParticleTypes particleType) {
		for (int i = 0; i < 5; ++i) {
			double d0 = rand.nextGaussian() * 0.02D;
			double d1 = rand.nextGaussian() * 0.02D;
			double d2 = rand.nextGaussian() * 0.02D;
			world.spawnParticle(particleType,
					posX + rand.nextDouble() * width * 2.0F - width,
					posY + 1.0D + rand.nextDouble() * height,
					posZ + rand.nextDouble() * width * 2.0F - width, d0, d1, d2);
		}
	}

	/**
	 * Reduces damage, depending on potions
	 */
	@Override
	protected float applyPotionDamageCalculations(DamageSource source, float damage) {
		float modifiedDamage = super.applyPotionDamageCalculations(source, damage);

		if (source.getTrueSource() == this) {
			modifiedDamage = 0.0F;
		}

		if (source.isMagicDamage()) {
			modifiedDamage = modifiedDamage * 0.15F;
		}

		return modifiedDamage;
	}

	@Override
	public float getAIMoveSpeed() {
		float speed = super.getAIMoveSpeed();
		if (isDrinkingPotion()) {
			speed *= 0.75F;
		}

		return speed;
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
		if (!isDrinkingPotion()) {
			double d0 = target.posY + target.getEyeHeight() - 1.1D;
			double d1 = target.posX + target.motionX - posX;
			double d2 = d0 - posY;
			double d3 = target.posZ + target.motionZ - posZ;
			float f = MathHelper.sqrt(d1 * d1 + d3 * d3);
			PotionType potiontype = PotionTypes.HARMING;

			if (f >= 8.0F && !target.isPotionActive(MobEffects.SLOWNESS)) {
				potiontype = PotionTypes.SLOWNESS;
			} else if (target.getHealth() >= 8.0F && !target.isPotionActive(MobEffects.POISON)) {
				potiontype = PotionTypes.POISON;
			} else if (f <= 3.0F && !target.isPotionActive(MobEffects.WEAKNESS) && rand.nextFloat() < 0.25F) {
				potiontype = PotionTypes.WEAKNESS;
			}

			EntityPotion entitypotion =
					new EntityPotion(world, this, PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), potiontype));
			entitypotion.rotationPitch -= -20.0F;
			entitypotion.shoot(d1, d2 + f * 0.2D, d3, 0.75F, 8.0F);
			world.playSound(null, posX, posY, posZ, SoundEvents.ENTITY_WITCH_THROW, getSoundCategory(), 1.0F,
					0.8F + rand.nextFloat() * 0.4F);
			world.spawnEntity(entitypotion);
		}
	}

	private void beaconMonster() {
		if (!world.isRemote) {
			AxisAlignedBB axisalignedbb = (new AxisAlignedBB(posX, posY, posZ, posX + 1, posY + 1, posZ + 1)).grow(6);
			List<EntityLivingBase> moblist = world.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);

			for (EntityLivingBase mob : moblist) {
				if (mob instanceof EntitySpider) {
					mob.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 300, 1, true, true));
				}
			}
		}
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return Sounds.aggressive_say;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return Sounds.aggressive_hurt;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return Sounds.aggressive_death;
	}

	@Override
	protected void playStepSound(BlockPos pos, Block blockIn) {
		playSound(Sounds.none, 1.0F, 1.0F);
	}

	@Override
	protected void dropLoot(boolean wasRecentlyHit, int lootingModifier, DamageSource source) {
		super.dropLoot(wasRecentlyHit, lootingModifier, source);
		dropFewItems(wasRecentlyHit, lootingModifier);
	}

	@Nullable
	@Override
	protected ResourceLocation getLootTable() {
		return LootTableList.ENTITIES_WITCH;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			int var3 = rand.nextInt(3 + lootingModifier);

			for (int var4 = 0; var4 < var3; ++var4) {
				dropItem(GaiaItems.FoodNetherWart, 1);
			}

			// Nuggets/Fragments
			int var11 = rand.nextInt(3) + 1;

			for (int var12 = 0; var12 < var11; ++var12) {
				ItemShard.Drop_Nugget(this, 1);
			}

			if (GaiaConfig.options.additionalOre) {
				int var13 = rand.nextInt(3) + 1;

				for (int var14 = 0; var14 < var13; ++var14) {
					ItemShard.Drop_Nugget(this, 5);
				}
			}

			// Rare
			if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				int i = rand.nextInt(3);
				if (i == 0) {
					dropItem(GaiaItems.BoxGold, 1);
				} else if (i == 1) {
					dropItem(GaiaItems.BagBook, 1);
				} else if (i == 2) {
					dropItem(GaiaItems.MiscBook, 1);
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

		setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.PropWeapon, 1, 0));

		return ret;
	}

	// ================= Immunities =================//
	@Override
	public boolean isPotionApplicable(PotionEffect potioneffectIn) {
		return potioneffectIn.getPotion() != MobEffects.POISON && super.isPotionApplicable(potioneffectIn);
	}

	@Override
	public void fall(float distance, float damageMultiplier) {
		//noop
	}
	// ==============================================//

	@Override
	public boolean getCanSpawnHere() {
		return posY > 60.0D && super.getCanSpawnHere();
	}
}
