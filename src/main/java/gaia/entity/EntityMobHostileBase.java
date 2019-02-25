package gaia.entity;

import gaia.GaiaConfig;
import gaia.init.GaiaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
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
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

/**
 * Apply all changes made here to EntityMobPassiveBase (except for AI).
 *
 * @see EntityMobPassiveBase
 */
public abstract class EntityMobHostileBase extends EntityMob implements IRangedAttackMob {

	private static final DataParameter<Boolean> NEUTRAL = EntityDataManager.<Boolean>createKey(EntityMobHostileBase.class, DataSerializers.BOOLEAN);

	public EntityAINearestAttackableTarget<EntityPlayer> aiNearestAttackableTarget = new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, true);

	public EntityMobHostileBase(EntityType<?> type, World worldIn) {
		super(type, worldIn);

		targetTasks.addTask(2, aiNearestAttackableTarget);
	}

	@Override
	protected boolean processInteract(EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);
		if (stack.getItem() == GaiaItems.FOOD_MONSTER_FEED_PREMIUM && !isNeutral()) {
			world.setEntityState(this, (byte) 8);

			if (!player.abilities.isCreativeMode) {
				stack.shrink(1);
			}

			this.getDataManager().set(NEUTRAL, Boolean.valueOf(true));
			targetTasks.removeTask(aiNearestAttackableTarget);

			return true;
		} else {
			return super.processInteract(player, hand);
		}
	}

	@Override
	protected void registerData() {
		super.registerData();
		this.getDataManager().register(NEUTRAL, Boolean.valueOf(false));
	}

	public boolean isNeutral() {
		return ((Boolean) this.getDataManager().get(NEUTRAL)).booleanValue();
	}

	public void setNeutral() {
		targetTasks.removeTask(aiNearestAttackableTarget);
	}

	public void writeAdditional(NBTTagCompound compound) {
		super.writeAdditional(compound);
		compound.setBoolean("neutral", isNeutral());
	}

	public void readAdditional(NBTTagCompound compound) {
		super.readAdditional(compound);
		dataManager.set(NEUTRAL, Boolean.valueOf(compound.getBoolean("neutral")));

		if (compound.getBoolean("neutral")) {
			this.setNeutral();
		}
	}

	/* SHARED CODE */
	@Override
	public boolean attackEntityAsMob(Entity entity) {
		if (super.attackEntityAsMob(entity)) {
			if (GaiaConfig.COMMON.baseDamage.get()) {
				if (entity instanceof EntityPlayer && GaiaConfig.COMMON.shieldsBlockPiercing.get()) {
					EntityPlayer player = (EntityPlayer) entity;
					ItemStack itemstack = player.getActiveItemStack();

					if (itemstack.getItem() == Items.SHIELD) {
						return true;
					}
				}

				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE, 2, 0));
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

		return GaiaConfig.COMMON.spawnDaysSet.get() <= daysPassedClientInt;
	}
	
	@Override
	public boolean canSpawn(IWorld worldIn, boolean value) {
		if (GaiaConfig.COMMON.spawnDaysPassed.get()) {
			return !isDimensionBlacklisted() && daysPassed() && super.canSpawn(world, value);
		} else {
			return !isDimensionBlacklisted() && super.canSpawn(worldIn, value);
		}
	}

	public boolean isDimensionBlacklisted() {
		if(!GaiaConfig.COMMON.dimensionBlacklist.get().isEmpty()) {
			if(GaiaConfig.COMMON.dimensionBlacklist.get().contains(String.valueOf(this.world.getDimension().getType().getId()))) {
				return true;
			} else {
				return false;
			}
		}

		return false;
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
}
