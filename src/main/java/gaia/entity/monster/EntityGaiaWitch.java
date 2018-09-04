package gaia.entity.monster;

import java.util.List;
import java.util.UUID;

import javax.annotation.Nullable;

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

/**
 * Copied code from EntityWitch.
 * isAIDisabled has been removed.
 * 
 * @see EntityWitch
 */
@SuppressWarnings({ "squid:MaximumInheritanceDepth", "squid:S2160" })
public class EntityGaiaWitch extends EntityMobHostileBase implements IRangedAttackMob {

	private int spawn;

	private static final UUID MODIFIER_UUID = UUID.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E");
	private static final AttributeModifier MODIFIER = (new AttributeModifier(MODIFIER_UUID, "Drinking speed penalty", -0.25D, 0)).setSaved(false);
	private static final DataParameter<Boolean> IS_DRINKING = EntityDataManager.createKey(EntityGaiaWitch.class, DataSerializers.BOOLEAN);

	private int potionUseTimer;

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
	
	/* WITCH CODE */
	@Override
	protected void entityInit() {
		super.entityInit();
		this.getDataManager().register(IS_DRINKING, Boolean.valueOf(false));
	}

	public void setDrinkingPotion(boolean drinkingPotion) {
		this.getDataManager().set(IS_DRINKING, Boolean.valueOf(drinkingPotion));
	}

	public boolean isDrinkingPotion() {
		return ((Boolean) this.getDataManager().get(IS_DRINKING)).booleanValue();
	}

	@Override
	public void onLivingUpdate() {
		beaconMonster();

		if (!onGround && motionY < 0.0D) {
			motionY *= 0.8D;
		}

		if (motionX > 0 || motionY > 0 || motionZ > 0) {
			for (int var5 = 0; var5 < 2; ++var5) {
				world.spawnParticle(EnumParticleTypes.SPELL_WITCH, posX + (rand.nextDouble() - 0.5D) * width, posY + rand.nextDouble() * height, posZ + (rand.nextDouble() - 0.5D) * width, 0.0D, 0.0D, 0.0D);
			}
		}

		if (getHealth() < EntityAttributes.MAX_HEALTH_2 * 0.75F && getHealth() > 0.0F && spawn == 0) {
			world.setEntityState(this, (byte) 9);

			if (!world.isRemote) {
				SetSpawn((byte) 0);
			}
			spawn = 1;
		}

		if (getHealth() < EntityAttributes.MAX_HEALTH_2 * 0.25F && getHealth() > 0.0F && spawn == 1) {
			world.setEntityState(this, (byte) 9);

			if (!world.isRemote) {
				SetSpawn((byte) 0);
			}
			spawn = 2;
		}

		/* WITCH CODE */
		if (!this.world.isRemote) {
			if (this.isDrinkingPotion()) {
				if (this.potionUseTimer-- <= 0) {
					this.setDrinkingPotion(false);
					ItemStack itemstack = this.getHeldItemMainhand();
					this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP, 1, 0));

					if (itemstack.getItem() == Items.POTIONITEM) {
						List<PotionEffect> list = PotionUtils.getEffectsFromStack(itemstack);

						if (list != null) {
							for (PotionEffect potioneffect : list) {
								this.addPotionEffect(new PotionEffect(potioneffect));
							}
						}
					}

					this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(MODIFIER);
				}
			} else {
				PotionType potiontype = null;

				if (this.rand.nextFloat() < 0.15F && this.isInsideOfMaterial(Material.WATER) && !this.isPotionActive(MobEffects.WATER_BREATHING)) {
					potiontype = PotionTypes.WATER_BREATHING;
				} else if (this.rand.nextFloat() < 0.15F && (this.isBurning() || this.getLastDamageSource() != null && this.getLastDamageSource().isFireDamage()) && !this.isPotionActive(MobEffects.FIRE_RESISTANCE)) {
					potiontype = PotionTypes.FIRE_RESISTANCE;
				} else if (this.rand.nextFloat() < 0.05F && this.getHealth() < this.getMaxHealth()) {
					potiontype = PotionTypes.HEALING;
				} else if (this.rand.nextFloat() < 0.5F && this.getAttackTarget() != null && !this.isPotionActive(MobEffects.SPEED) && this.getAttackTarget().getDistanceSq(this) > 121.0D) {
					potiontype = PotionTypes.SWIFTNESS;
				}

				if (potiontype != null) {
					this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), potiontype));
					this.potionUseTimer = this.getHeldItemMainhand().getMaxItemUseDuration();
					this.setDrinkingPotion(true);
					this.world.playSound((EntityPlayer) null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_WITCH_DRINK, this.getSoundCategory(), 1.0F, 0.8F + this.rand.nextFloat() * 0.4F);
					IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
					iattributeinstance.removeModifier(MODIFIER);
					iattributeinstance.applyModifier(MODIFIER);
				}
			}

			if (this.rand.nextFloat() < 7.5E-4F) {
				this.world.setEntityState(this, (byte) 15);
			}
		}
		/* WITCH CODE */

		super.onLivingUpdate();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void handleStatusUpdate(byte id) {
		if (id == 13) {
			for (int i = 0; i < rand.nextInt(35) + 10; ++i) {
				world.spawnParticle(EnumParticleTypes.SPELL_WITCH, posX + rand.nextGaussian() * 0.12999999523162842D, getEntityBoundingBox().maxY + 0.5D + rand.nextGaussian() * 0.12999999523162842D, posZ + rand.nextGaussian() * 0.13D, 0.0D, 0.0D, 0.0D);
			}
		} else {
			super.handleStatusUpdate(id);
		}
	}

	/**
	 * Reduces damage, depending on potions
	 */
	@Override
	protected float applyPotionDamageCalculations(DamageSource source, float damage) {
		damage = super.applyPotionDamageCalculations(source, damage);

		if (source.getTrueSource() == this) {
			damage = 0.0F;
		}

		if (source.isMagicDamage()) {
			damage = (float) ((double) damage * 0.15D);
		}

		return damage;
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
		if (!this.isDrinkingPotion()) {
			double d0 = target.posY + (double) target.getEyeHeight() - 1.100000023841858D;
			double d1 = target.posX + target.motionX - this.posX;
			double d2 = d0 - this.posY;
			double d3 = target.posZ + target.motionZ - this.posZ;
			float f = MathHelper.sqrt(d1 * d1 + d3 * d3);
			PotionType potiontype = PotionTypes.HARMING;

			if (f >= 8.0F && !target.isPotionActive(MobEffects.SLOWNESS)) {
				potiontype = PotionTypes.SLOWNESS;
			} else if (target.getHealth() >= 8.0F && !target.isPotionActive(MobEffects.POISON)) {
				potiontype = PotionTypes.POISON;
			} else if (f <= 3.0F && !target.isPotionActive(MobEffects.WEAKNESS) && this.rand.nextFloat() < 0.25F) {
				potiontype = PotionTypes.WEAKNESS;
			}

			EntityPotion entitypotion = new EntityPotion(this.world, this, PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), potiontype));
			entitypotion.rotationPitch -= -20.0F;
			entitypotion.shoot(d1, d2 + (double) (f * 0.2F), d3, 0.75F, 8.0F);
			this.world.playSound((EntityPlayer) null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_WITCH_THROW, this.getSoundCategory(), 1.0F, 0.8F + this.rand.nextFloat() * 0.4F);
			this.world.spawnEntity(entitypotion);
		}
	}
	/* WITCH CODE */

	private void SetSpawn(byte id) {
		EntityGaiaSummonWoodenGolem spider;

		if (id == 0) {
			spider = new EntityGaiaSummonWoodenGolem(world);
			spider.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
			spider.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(spider)), null);
			world.spawnEntity(spider);
		}
	}

	private void beaconMonster() {
		if (!world.isRemote) {
			AxisAlignedBB axisalignedbb = (new AxisAlignedBB(posX, posY, posZ, posX + 1, posY + 1, posZ + 1)).grow(6);
			List<EntityLivingBase> moblist = world.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);

			for (EntityLivingBase mob : moblist) {
				if (mob instanceof EntityGaiaSummonWoodenGolem) {
					mob.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 300, 1, true, true));
				}
			}
		}
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
	protected void playStepSound(BlockPos pos, Block blockIn) {
		playSound(Sounds.NONE, 1.0F, 1.0F);
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
				dropItem(GaiaItems.FOOD_NETHER_WART, 1);
			}

			// Nuggets/Fragments
			int var11 = rand.nextInt(3) + 1;

			for (int var12 = 0; var12 < var11; ++var12) {
				dropItem(Items.GOLD_NUGGET, 1);
			}

			if (GaiaConfig.OPTIONS.additionalOre) {
				int var13 = rand.nextInt(3) + 1;

				for (int var14 = 0; var14 < var13; ++var14) {
					ItemShard.dropNugget(this, 5);
				}
			}

			// Rare
			if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				int i = rand.nextInt(3);
				if (i == 0) {
					dropItem(GaiaItems.BOX_GOLD, 1);
				} else if (i == 1) {
					dropItem(GaiaItems.BAG_BOOK, 1);
				} else if (i == 2) {
					dropItem(GaiaItems.MISC_BOOK, 1);
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

		setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP, 1, 0));

		return ret;
	}

	/* IMMUNITIES */
	@Override
	public boolean isPotionApplicable(PotionEffect potioneffectIn) {
		return potioneffectIn.getPotion() != MobEffects.POISON && potioneffectIn.getPotion() != MobEffects.INSTANT_DAMAGE && super.isPotionApplicable(potioneffectIn);
	}

	@Override
	public void fall(float distance, float damageMultiplier) {
	}
	/* IMMUNITIES */

	@Override
	public boolean getCanSpawnHere() {
		return posY > 60.0D && super.getCanSpawnHere();
	}
}
