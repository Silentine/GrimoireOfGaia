package gaia.entity.monster;

import javax.annotation.Nullable;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.entity.projectile.EntityGaiaProjectileSmallFireball;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

@SuppressWarnings("squid:MaximumInheritanceDepth")
public class EntityGaiaNineTails extends EntityMobHostileBase implements IRangedAttackMob {

	private EntityAIAttackRanged aiArrowAttack = new EntityAIAttackRanged(this, EntityAttributes.ATTACK_SPEED_2, 20, 60, 15.0F);
	private EntityAIAttackMelee aiAttackOnCollide = new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_2, true);

	private int switchHealth;

	public EntityGaiaNineTails(World worldIn) {
		super(worldIn);

		experienceValue = EntityAttributes.EXPERIENCE_VALUE_2;
		stepHeight = 1.0F;
		switchHealth = 0;
		isImmuneToFire = true;
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

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase living, float par2) {
		playSound(SoundEvents.ENTITY_BLAZE_SHOOT, 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
		double d0 = living.posX - posX;
		double d1 = living.getEntityBoundingBox().minY + living.height / 2.0D - (posY + height / 2.0D);
		double d2 = living.posZ - posZ;
		double f1 = MathHelper.sqrt(par2) * 0.5D;

		for (int var10 = 0; var10 < 3; ++var10) {
			EntityGaiaProjectileSmallFireball var11 = new EntityGaiaProjectileSmallFireball(world, this, d0 + rand.nextGaussian() * f1, d1, d2 + rand.nextGaussian() * f1);
			var11.posY = posY + height / 2.0D + 0.5D;
			world.spawnEntity(var11);
		}
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		if (super.attackEntityAsMob(entityIn)) {
			entityIn.setFire(6);
		}
		return true;
	}

	@Override
	public boolean isAIDisabled() {
		return false;
	}

	public void onLivingUpdate() {
		if ((getHealth() < EntityAttributes.MAX_HEALTH_2 * 0.75F) && (switchHealth == 0)) {
			SetAI((byte) 1);
			switchHealth = 1;
		}

		if ((getHealth() > EntityAttributes.MAX_HEALTH_2 * 0.75F) && (switchHealth == 1)) {
			SetAI((byte) 0);
			switchHealth = 0;
		}

		super.onLivingUpdate();
	}
	
	private void SetAI(byte id) {
		if (id == 0) {
			tasks.removeTask(aiAttackOnCollide);
			tasks.addTask(1, aiArrowAttack);
		}

		if (id == 1) {
			tasks.removeTask(aiArrowAttack);
			tasks.addTask(1, aiAttackOnCollide);
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
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			int var3 = rand.nextInt(3 + lootingModifier);

			for (int var4 = 0; var4 < var3; ++var4) {
				dropItem(GaiaItems.MISC_SOUL_FIRE, 1);
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
					ItemStack fanFire = new ItemStack(GaiaItems.WEAPON_FAN_FIRE);
					fanFire.addEnchantment(Enchantments.FIRE_ASPECT, 2);
					fanFire.addEnchantment(Enchantments.KNOCKBACK, 1);
					entityDropItem(fanFire, 1);
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
		SetAI((byte) 0);

		setLeftHanded(false);
		ItemStack weapon;

		if (rand.nextInt(4) == 0) {
			weapon = new ItemStack(GaiaItems.WEAPON_PROP, 1, 4);
			weapon.addEnchantment(Enchantments.KNOCKBACK, 2);
		} else {
			weapon = new ItemStack(GaiaItems.WEAPON_PROP_ENCHANTED, 1);
			weapon.addEnchantment(Enchantments.KNOCKBACK, 1);
		}

		setItemStackToSlot(EntityEquipmentSlot.MAINHAND, weapon);

		return ret;
	}

	@Override
	public boolean getCanSpawnHere() {
		return posY > 60.0D && super.getCanSpawnHere();
	}
}
