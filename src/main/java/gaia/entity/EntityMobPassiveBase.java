package gaia.entity;

import gaia.GaiaConfig;
import gaia.renderer.particle.ParticleBuff;
import gaia.renderer.particle.ParticleDrop;
import gaia.renderer.particle.ParticleHeal;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SuppressWarnings("squid:MaximumInheritanceDepth")
public abstract class EntityMobPassiveBase extends EntityMobPassive {

	public EntityMobPassiveBase(World worldIn) {
		super(worldIn);
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		if (super.attackEntityAsMob(entity)) {
			if (GaiaConfig.BaseDamage) {
				if (entity instanceof EntityPlayer && GaiaConfig.ShieldsBlockPiercing) {
					EntityPlayer player = (EntityPlayer) entity;
					ItemStack itemstack = player.isHandActive() ? player.getActiveItemStack() : ItemStack.EMPTY;
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
	@SideOnly(Side.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 8) {
			for (int i = 0; i < 8; ++i) {
				ParticleDrop particleCustom = new ParticleDrop(world,
						posX + (double) (rand.nextFloat() * width * 2.0F) - (double) width,
						posY + 0.5D + (double) (rand.nextFloat() * height),
						posZ + (double) (rand.nextFloat() * width * 2.0F) - (double) width, 0.0D, 0.0D, 0.0D);
				Minecraft.getMinecraft().effectRenderer.addEffect(particleCustom);
			}
		} else if (id == 9) {
			for (int i = 0; i < 8; ++i) {
				ParticleHeal particleCustom = new ParticleHeal(world,
						posX + (double) (rand.nextFloat() * width * 2.0F) - (double) width,
						posY + 0.5D + (double) (rand.nextFloat() * height),
						posZ + (double) (rand.nextFloat() * width * 2.0F) - (double) width, 0.0D, 0.0D, 0.0D);
				Minecraft.getMinecraft().effectRenderer.addEffect(particleCustom);
			}
		} else if (id == 10) {
			for (int i = 0; i < 8; ++i) {
				ParticleBuff particleCustom = new ParticleBuff(world,
						posX + (double) (rand.nextFloat() * width * 2.0F) - (double) width,
						posY + 0.5D + (double) (rand.nextFloat() * height),
						posZ + (double) (rand.nextFloat() * width * 2.0F) - (double) width, 0.0D, 0.0D, 0.0D);
				Minecraft.getMinecraft().effectRenderer.addEffect(particleCustom);
			}
		} else if (id == 11) {
			for (int i = 0; i < 8; ++i) {
				world.spawnParticle(EnumParticleTypes.HEART,
						posX + (double) (rand.nextFloat() * width * 2.0F) - (double) width,
						posY + 0.5D + (double) (rand.nextFloat() * height),
						posZ + (double) (rand.nextFloat() * width * 2.0F) - (double) width, 0.0D, 0.0D, 0.0D);
			}
		} else {
			super.handleStatusUpdate(id);
		}
	}

	/**
	 * Used to adjust the motionY when a mob is hit.
	 */
	public void knockBack(double xRatio, double zRatio, double yRatio) {
		if (rand.nextDouble() >= getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE)
				.getAttributeValue()) {
			isAirBorne = true;
			float f1 = MathHelper.sqrt(xRatio * xRatio + zRatio * zRatio);
			float f2 = 0.4F;
			motionX /= 2.0D;
			motionY /= 2.0D;
			motionZ /= 2.0D;
			motionX -= xRatio / (double) f1 * (double) f2;
			motionY += (double) f2;
			motionZ -= zRatio / (double) f1 * (double) f2;
			if (motionY > yRatio) {
				motionY = yRatio;
			}
		}
	}
}
