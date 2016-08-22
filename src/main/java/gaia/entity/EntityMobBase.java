package gaia.entity;

import gaia.ConfigGaia;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public abstract class EntityMobBase extends EntityMob {

	public EntityMobBase(World par1World) {
		super(par1World);
	}

	public boolean attackEntityAsMob(Entity par1Entity) {
		if (super.attackEntityAsMob(par1Entity)) {
			if (ConfigGaia.BaseDamage) {
				((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.harm.id, 2, 0));
			}
			return true;
		} else {
			return false;
		}
	}

	public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1iEntityLivingData) {
		return null;
	}

	/**
	 * Used to adjust the motionY when a mob is hit.
	 */
	public void knockBack(Entity par1Entity, float par2, double par3, double par5, double par6) {
		if (this.rand.nextDouble() >= this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).getAttributeValue()) {
			this.isAirBorne = true;
			float f1 = MathHelper.sqrt_double(par3 * par3 + par5 * par5);
			float f2 = 0.4F;
			this.motionX /= 2.0D;
			this.motionY /= 2.0D;
			this.motionZ /= 2.0D;
			this.motionX -= par3 / (double)f1 * (double)f2;
			this.motionY += (double)f2;
			this.motionZ -= par5 / (double)f1 * (double)f2;
			if (this.motionY > par6) {
				this.motionY = par6;
			}
		}
	}

	//TODO Custom Damage Source which includes the name of the monster
	/*
	public boolean attackEntityAsMob(Entity par1Entity) {
		if (super.attackEntityAsMob(par1Entity)) {
			if (ConfigGaia.BaseDamage) {
	            ((EntityLivingBase)par1Entity).attackEntityFrom(CustomDamageSource.pierce, 2.0F);
			}
			return true;
		} else {
			return false;
		}
	}
	*/
}
