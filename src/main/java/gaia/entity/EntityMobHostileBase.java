package gaia.entity;

import gaia.GaiaConfig;
import gaia.init.GaiaItems;
import gaia.renderer.particle.ParticleBuff;
import gaia.renderer.particle.ParticleDrop;
import gaia.renderer.particle.ParticleHeal;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

@SuppressWarnings({"squid:MaximumInheritanceDepth", "squid:S2160"})
public abstract class EntityMobHostileBase extends EntityMob {

	private EntityAINearestAttackableTarget<EntityPlayer> aiNearestAttackableTarget = new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, true);

	public EntityMobHostileBase(World worldIn) {
		super(worldIn);

		this.targetTasks.addTask(2, this.aiNearestAttackableTarget);
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		if (super.attackEntityAsMob(entity)) {
			// TODO Rebalance tweaking for shields
			// Shields aren't so fun when they can't block most of the damage
			if (GaiaConfig.BaseDamage) {
				if (entity instanceof EntityPlayer && GaiaConfig.ShieldsBlockPiercing) {
					EntityPlayer player = (EntityPlayer) entity;
					ItemStack itemstack = player.isHandActive()
							? player.getActiveItemStack()
							: null;

					if (itemstack != null && itemstack.getItem() == Items.SHIELD) {
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
	@SideOnly(Side.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 8) {
			for (int i = 0; i < 8; ++i) {
				ParticleDrop particleCustom = new ParticleDrop(this.world,
						this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width,
						this.posY + 0.5D + (double) (this.rand.nextFloat() * this.height),
						this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, 0.0D, 0.0D, 0.0D);
				Minecraft.getMinecraft().effectRenderer.addEffect(particleCustom);
			}
		} else if (id == 9) {
			for (int i = 0; i < 8; ++i) {
				ParticleHeal particleCustom = new ParticleHeal(this.world,
						this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width,
						this.posY + 0.5D + (double) (this.rand.nextFloat() * this.height),
						this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, 0.0D, 0.0D, 0.0D);
				Minecraft.getMinecraft().effectRenderer.addEffect(particleCustom);
			}
		} else if (id == 10) {
			for (int i = 0; i < 8; ++i) {
				ParticleBuff particleCustom = new ParticleBuff(this.world,
						this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width,
						this.posY + 0.5D + (double) (this.rand.nextFloat() * this.height),
						this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, 0.0D, 0.0D, 0.0D);
				Minecraft.getMinecraft().effectRenderer.addEffect(particleCustom);
			}
		} else if (id == 11) {
			for (int i = 0; i < 8; ++i) {
				this.world.spawnParticle(EnumParticleTypes.HEART,
						this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width,
						this.posY + 0.5D + (double) (this.rand.nextFloat() * this.height),
						this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, 0.0D, 0.0D, 0.0D);
			}
		} else {
			super.handleStatusUpdate(id);
		}
	}

	/**
	 * Adapted from @TileEntityBeacon
	 *
	 * @param effect   Potion Effect to Implement
	 * @param duration Duration of potion effect in ticks (20 ticks = 1 second)
	 * @see TileEntityBeacon
	 */
	protected void beaconDebuff(Potion effect, int duration) {
		if (!this.world.isRemote) {
			AxisAlignedBB axisalignedbb = (new AxisAlignedBB(posX, posY, posZ, posX + 1, posY + 1, posZ + 1)).grow(2);
			List<EntityLivingBase> moblist = this.world.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);

			for (EntityLivingBase mob : moblist) {
				if (!(mob instanceof EntityMob) && (mob instanceof IMob || mob instanceof EntityPlayer)) {
					mob.addPotionEffect(new PotionEffect(effect, duration, 0, true, true));
				}
			}
		}
	}

	/**
	 * Adapted from @EntityPotion
	 *
	 * @param sourceMob The mob creating the cloud
	 * @param effect    Potion Effect to Implement (@MobEffects.class)
	 * @param type      Type of potion (I think for rendering) (@PotionTypes.class)
	 * @param pos       Position to spawn effect
	 * @see EntityPotion
	 */
	protected void lingeringEffect(EntityLivingBase sourceMob, Potion effect, PotionType type, BlockPos pos) {
		EntityAreaEffectCloud entityareaeffectcloud = new EntityAreaEffectCloud(sourceMob.world, pos.getX(), pos.getY(), pos.getZ());
		entityareaeffectcloud.setOwner(sourceMob);
		entityareaeffectcloud.setRadius(3.0F);
		entityareaeffectcloud.setRadiusOnUse(-0.5F);
		entityareaeffectcloud.setWaitTime(10);
		entityareaeffectcloud.setRadiusPerTick(-entityareaeffectcloud.getRadius() / (float) entityareaeffectcloud.getDuration());
		entityareaeffectcloud.setPotion(type);

		entityareaeffectcloud.addEffect(new PotionEffect(effect, 200, 0));

		world.spawnEntity(entityareaeffectcloud);
	}

	/**
	 * Used to adjust the motionY when a mob is hit.
	 */
	public void knockBack(double xRatio, double zratio, double power) {
		if (this.rand.nextDouble() >= this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).getAttributeValue()) {
			this.isAirBorne = true;
			float f1 = MathHelper.sqrt(xRatio * xRatio + zratio * zratio);
			float f2 = 0.4F;
			this.motionX /= 2.0D;
			this.motionY /= 2.0D;
			this.motionZ /= 2.0D;
			this.motionX -= xRatio / (double) f1 * (double) f2;
			this.motionY += (double) f2;
			this.motionZ -= zratio / (double) f1 * (double) f2;
			if (this.motionY > power) {
				this.motionY = power;
			}
		}
	}

	@Override
	protected boolean processInteract(EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);
		if (stack.getItem() == GaiaItems.SpawnTame) {
			this.world.setEntityState(this, (byte) 11);

			if (!player.capabilities.isCreativeMode) {
				stack.shrink(1);
			}

			this.targetTasks.removeTask(this.aiNearestAttackableTarget);

			return true;
		} else {
			return super.processInteract(player, hand);
		}
	}

	@SuppressWarnings("unused")
	public void setSwingingArms(boolean swingingArms) {
	}
}
