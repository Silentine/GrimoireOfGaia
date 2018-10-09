package gaia.entity;

import java.util.List;

import gaia.GaiaConfig;
import gaia.init.GaiaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Apply all changes made here to EntityMobPassiveBase (except for AI).
 *
 * @see EntityMobPassiveBase
 */
@SuppressWarnings({ "squid:MaximumInheritanceDepth", "squid:S2160" })
public abstract class EntityMobHostileBase extends EntityMob {

	private static final DataParameter<Boolean> NEUTRAL = EntityDataManager.<Boolean>createKey(EntityMobHostileBase.class, DataSerializers.BOOLEAN);

	public EntityAINearestAttackableTarget<EntityPlayer> aiNearestAttackableTarget = new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, true);

	public EntityMobHostileBase(World worldIn) {
		super(worldIn);
		
		targetTasks.addTask(2, aiNearestAttackableTarget);
	}

	@Override
	protected boolean processInteract(EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);
		if (stack.getItem() == GaiaItems.FOOD_MONSTER_FEED_PREMIUM && !isNeutral()) {
			world.setEntityState(this, (byte) 8);

			if (!player.capabilities.isCreativeMode) {
				stack.shrink(1);
			}

			dataManager.set(NEUTRAL, Boolean.valueOf(true));
			targetTasks.removeTask(aiNearestAttackableTarget);

			return true;
		} else {
			return super.processInteract(player, hand);
		}
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		dataManager.register(NEUTRAL, Boolean.valueOf(false));
	}

	public boolean isNeutral() {
		return ((Boolean) this.dataManager.get(NEUTRAL)).booleanValue();
	}

	public void setNeutral() {
		targetTasks.removeTask(aiNearestAttackableTarget);
	}
	
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setBoolean("neutral", isNeutral());
	}

	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		dataManager.set(NEUTRAL, Boolean.valueOf(compound.getBoolean("neutral")));

		if (compound.getBoolean("neutral")) {
			this.setNeutral();
		}
	}

	/* SHARED CODE */
	@Override
	public boolean attackEntityAsMob(Entity entity) {
		if (super.attackEntityAsMob(entity)) {
			if (GaiaConfig.DAMAGE.baseDamage) {
				if (entity instanceof EntityPlayer && GaiaConfig.DAMAGE.shieldsBlockPiercing) {
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

	/**
	 * @param id    ParticleType.NAME
	 * @param id_08 ParticleType.HEART (For Healing)
	 * @param id_09 ParticleType.FLAME (For Spawning)
	 * @param id_10 ParticleType.SPELL_WITCH (For Spawning)
	 * @param id_11 ParticleType.SMOKE_NORMAL
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 7) {
			spawnParticles(EnumParticleTypes.VILLAGER_HAPPY);
		} else if (id == 8) {
			for (int i = 0; i < 8; ++i) {
				world.spawnParticle(EnumParticleTypes.HEART, posX + (double) (rand.nextFloat() * width * 2.0F) - (double) width, posY + 0.5D + (double) (rand.nextFloat() * height), posZ + (double) (rand.nextFloat() * width * 2.0F) - (double) width, 0.0D, 0.0D, 0.0D);
			}
		} else if (id == 9) {
			spawnParticles(EnumParticleTypes.FLAME);
		} else if (id == 10) {
			spawnParticles(EnumParticleTypes.SPELL_WITCH);
		} else if (id == 11) {
			spawnParticles(EnumParticleTypes.SMOKE_NORMAL);
		} else if (id == 12) {
			spawnParticles(EnumParticleTypes.EXPLOSION_NORMAL);
		} else {
			super.handleStatusUpdate(id);
		}
	}

	/**
	 * Adapted from @EntityVillager
	 */
	@SideOnly(Side.CLIENT)
	private void spawnParticles(EnumParticleTypes particleType) {
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
		if (rand.nextDouble() >= getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).getAttributeValue()) {
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
		int daysPassedClientInt = (int) (world.getWorldTime() / 24000);

		return GaiaConfig.SPAWN.spawnDaysSet <= daysPassedClientInt;
	}

	@Override
	public boolean getCanSpawnHere() {
		if (GaiaConfig.SPAWN.spawnDaysPassed) {
			return daysPassed() && super.getCanSpawnHere();
		} else {
			return super.getCanSpawnHere();
		}
	}
	/* SPAWN CONDITIONS */

	@Override
	protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier) {
	}

	@SuppressWarnings("unused")
	public void setSwingingArms(boolean swingingArms) {
	}
	/* SHARED CODE */
}
