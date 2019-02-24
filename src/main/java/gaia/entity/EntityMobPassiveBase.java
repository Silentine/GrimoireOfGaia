package gaia.entity;

import gaia.GaiaConfig;
import gaia.init.GaiaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.Particles;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;
import java.util.function.Predicate;

/**
 * This is a direct copy of EntityMobHostileBase.
 *
 * @see EntityMobPassive
 */
public abstract class EntityMobPassiveBase extends EntityMobPassive implements IRangedAttackMob {

	private static final DataParameter<Boolean> FRIENDLY = EntityDataManager.<Boolean>createKey(EntityMobPassiveBase.class, DataSerializers.BOOLEAN);

	private EntityAINearestAttackableTarget<EntityPlayer> aiNearestAttackableTarget = new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, true);
	
//	private EntityAINearestAttackableTarget aiNearestAttackableHostileTarget = new EntityAINearestAttackableTarget(this, EntityLiving.class, 10, false, true, new Predicate<EntityLiving>() {
//		public boolean apply(@Nullable EntityLiving p_apply_1_) {
//			return p_apply_1_ != null && IMob.VISIBLE_MOB_SELECTOR.apply(p_apply_1_) && !(p_apply_1_ instanceof EntityCreeper);
//		}
//	});

	public EntityMobPassiveBase(EntityType<?> type, World worldIn) {
		super(type, worldIn);

		if (GaiaConfig.COMMON.passiveHostileAllMobs.get()) {
			targetTasks.addTask(2, aiNearestAttackableTarget);
		}
	}

	/**
	 * Used to set if the mob can be tamed or not
	 */
	public boolean isTameable() {
		return false;
	}

	@Override
	public EnumActionResult applyPlayerInteraction(EntityPlayer player, Vec3d vec, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);
		if (stack.getItem() == GaiaItems.FOOD_MONSTER_FEED && !isFriendly() && isTameable()) {

			getEntityWorld().setEntityState(this, (byte) 8);

			if (!player.abilities.isCreativeMode) {
				stack.shrink(1);
			}

			dataManager.set(FRIENDLY, Boolean.valueOf(true));
			targetTasks.addTask(3, new AINearestAttackableHostileTarget(this));

			return EnumActionResult.SUCCESS;
		} else {
			return super.applyPlayerInteraction(player, vec, hand);
		}
	}

	@Override
	public boolean canAttackClass(Class<? extends EntityLivingBase> cls) {
		if (EntityMobPassiveBase.class.isAssignableFrom(cls)) {
			return false;
		} else {
			return cls == EntityCreeper.class ? false : super.canAttackClass(cls);
		}
	}

	@Override
	protected void registerData() {
		super.registerData();
		this.getDataManager().register(FRIENDLY, Boolean.valueOf(false));
	}

	public boolean isFriendly() {
		return ((Boolean) this.dataManager.get(FRIENDLY)).booleanValue();
	}

	public void setFriendly() {
		targetTasks.addTask(3, new AINearestAttackableHostileTarget(this));
	}

	public void writeAdditional(NBTTagCompound compound) {
		super.writeAdditional(compound);
		compound.setBoolean("friendly", isFriendly());
	}

	public void readAdditional(NBTTagCompound compound) {
		super.readAdditional(compound);
		dataManager.set(FRIENDLY, Boolean.valueOf(compound.getBoolean("friendly")));

		if (compound.getBoolean("friendly")) {
			this.setFriendly();
		}
	}

	/* SHARED CODE */
	@Override
	public boolean attackEntityAsMob(Entity entity) {
		if (super.attackEntityAsMob(entity)) {
			if (GaiaConfig.COMMON.baseDamage.get()) {
				if (entity instanceof EntityPlayer && GaiaConfig.COMMON.shieldsBlockPiercing.get()) {
					EntityPlayer player = (EntityPlayer) entity;
					ItemStack itemstack = player.isHandActive() ? player.getActiveItemStack() : ItemStack.EMPTY;
					if (itemstack.getItem() == Items.SHIELD) {
						return true;
					}
				}

				if (!isFriendly()) {
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE, 2, 0));
				}
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 7) {
			spawnParticles(Particles.HAPPY_VILLAGER);
		} else if (id == 8) {
			for (int i = 0; i < 8; ++i) {
				world.spawnParticle(Particles.HEART, posX + (double) (rand.nextFloat() * width * 2.0F) - (double) width, posY + 0.5D + (double) (rand.nextFloat() * height), posZ + (double) (rand.nextFloat() * width * 2.0F) - (double) width, 0.0D, 0.0D, 0.0D);
			}
		} else if (id == 9) {
			spawnParticles(Particles.FLAME);
		} else if (id == 10) {
			spawnParticles(Particles.WITCH);
		} else if (id == 11) {
			spawnParticles(Particles.SMOKE);
		} else if (id == 12) {
			spawnParticles(Particles.EXPLOSION);
		} else {
			super.handleStatusUpdate(id);
		}
	}

	/**
	 * Adapted from @EntityVillager
	 */
	@OnlyIn(Dist.CLIENT)
	private void spawnParticles(IParticleData particleType) {
		for (int i = 0; i < 5; ++i) {
			double d0 = rand.nextGaussian() * 0.02D;
			double d1 = rand.nextGaussian() * 0.02D;
			double d2 = rand.nextGaussian() * 0.02D;
			world.spawnParticle(particleType, posX + rand.nextDouble() * width * 2.0D - width, posY + 1.0D + rand.nextDouble() * height, posZ + rand.nextDouble() * width * 2.0D - width, d0, d1, d2);
		}
	}

	/**
	 * Adapted from @TileEntityBeacon
	 *
	 * @param effect   Potion Effect to Implement
	 * @param duration Duration of potion effect in ticks (20 ticks = 1 second)
	 * @see TileEntityBeacon
	 */
	protected void beaconDebuff(double range, Potion effect, int duration, int amplifier) {
		if (!world.isRemote) {
			AxisAlignedBB axisalignedbb = (new AxisAlignedBB(posX, posY, posZ, posX + 1, posY + 1, posZ + 1)).grow(range);
			List<EntityLivingBase> moblist = world.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);

			for (EntityLivingBase mob : moblist) {
				if (!(mob instanceof EntityMob) && (mob instanceof IMob || mob instanceof EntityPlayer)) {
					mob.addPotionEffect(new PotionEffect(effect, duration, amplifier, true, true));
				}
			}
		}
	}

	/**
	 * Adapted from @EntityCreeper
	 *
	 * @param sourceMob   Entity creating the cloud
	 * @param potionIn    Potion effect
	 * @param durationIn  Potion duration
	 * @param amplifierIn Potion level
	 * @see EntityAreaEffectCloud
	 */
	protected void spawnLingeringCloud(EntityLivingBase sourceMob, Potion potionIn, int durationIn, int amplifierIn) {

		EntityAreaEffectCloud entityareaeffectcloud = new EntityAreaEffectCloud(sourceMob.world, posX, posY, posZ);
		entityareaeffectcloud.setOwner(sourceMob);

		entityareaeffectcloud.setRadius(2.5F);
		entityareaeffectcloud.setRadiusOnUse(-0.5F);
		entityareaeffectcloud.setWaitTime(10);
		entityareaeffectcloud.setDuration(entityareaeffectcloud.getDuration() / 2);
		entityareaeffectcloud.setRadiusPerTick(-entityareaeffectcloud.getRadius() / (float) entityareaeffectcloud.getDuration());

		entityareaeffectcloud.addEffect(new PotionEffect(potionIn, durationIn, amplifierIn));

		world.spawnEntity(entityareaeffectcloud);
	}

	/**
	 * Used to adjust the motionY when a mob is hit.
	 * 
	 * @see EntityLivingBase
	 */
	public void knockBack(double xRatio, double zRatio, double power) {
		if (rand.nextDouble() >= getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).getValue()) {
			isAirBorne = true;
			float f1 = MathHelper.sqrt(xRatio * xRatio + zRatio * zRatio);
			float f2 = 0.4F;
			motionX /= 2.0D;
			motionY /= 2.0D;
			motionZ /= 2.0D;
			motionX -= xRatio / (double) f1 * (double) f2;
			motionY += (double) f2;
			motionZ -= zRatio / (double) f1 * (double) f2;

			if (motionY > power) {
				motionY = power;
			}
		}
	}

	/* SPAWN CONDITIONS */
	public boolean daysPassed() {
		int daysPassedClientInt = (int) (world.getGameTime() / 24000);

		return checkDimension() && GaiaConfig.COMMON.spawnDaysSet.get() <= daysPassedClientInt;
	}

	@Override
	public boolean canSpawn(IWorld p_205020_1_, boolean p_205020_2_) {
		if (GaiaConfig.COMMON.spawnDaysPassed.get()) {
			return daysPassed() && super.canSpawn(world, p_205020_2_);
		} else {
			return super.canSpawn(world, p_205020_2_);
		}
	}

	public boolean checkDimension() {
		if(!GaiaConfig.COMMON.dimensionBlacklist.get().isEmpty()) {
			if(GaiaConfig.COMMON.dimensionBlacklist.get().contains(String.valueOf(this.world.getDimension().getType().getId()))) {
				return true;
			} else {
				return false;
			}
		}

		return true;
	}
	/* SPAWN CONDITIONS */

	@Override
	protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier) {
	}

	@OnlyIn(Dist.CLIENT)
	public boolean isSwingingArms() {
		return false;
	}

	@SuppressWarnings("unused")
	public void setSwingingArms(boolean swingingArms) {
	}

	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
	}
	/* SHARED CODE */
	
	private static final Predicate<Entity> PASSIVE_SELECTOR = (p_210136_0_) -> {
		return p_210136_0_ != null && IMob.VISIBLE_MOB_SELECTOR.test(p_210136_0_) && !(p_210136_0_ instanceof EntityCreeper);
	};
	
	static class AINearestAttackableHostileTarget extends EntityAINearestAttackableTarget<EntityLiving> {
		public AINearestAttackableHostileTarget(EntityMobPassiveBase passive) {
			super(passive, EntityLiving.class, 10, false, true, EntityMobPassiveBase.PASSIVE_SELECTOR);
		}
	}
}
