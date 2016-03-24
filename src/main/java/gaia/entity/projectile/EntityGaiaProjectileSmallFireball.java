package gaia.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGaiaProjectileSmallFireball extends EntitySmallFireball {

	public EntityGaiaProjectileSmallFireball(World par1World) {
		super(par1World);
		this.setSize(0.3125F, 0.3125F);
	}

    public EntityGaiaProjectileSmallFireball(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ) {
        super(worldIn, shooter, accelX, accelY, accelZ);
        this.setSize(0.3125F, 0.3125F);
    }

    public EntityGaiaProjectileSmallFireball(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
        super(worldIn, x, y, z, accelX, accelY, accelZ);
        this.setSize(0.3125F, 0.3125F);
    }

	protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
		if (!this.worldObj.isRemote) {
			if (par1MovingObjectPosition.entityHit != null) {
				if (!par1MovingObjectPosition.entityHit.isImmuneToFire() && par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 5.0F)) {
					par1MovingObjectPosition.entityHit.setFire(4);
				}
			}

			this.setDead();
		}
	}

	public boolean canBeCollidedWith() {
		return false;
	}

	public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
		return false;
	}
}
