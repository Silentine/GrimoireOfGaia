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

	public EntityGaiaProjectileSmallFireball(World par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
		super(par1World, par2, par4, par6, par8, par10, par12);
        this.setSize(0.3125F, 0.3125F);
	}

	public EntityGaiaProjectileSmallFireball(World par1World, EntityLivingBase par2EntityLivingBase, double par3, double par5, double par7) {
		super(par1World, par2EntityLivingBase, par3, par5, par7);
        this.setSize(0.3125F, 0.3125F);
	}

	protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
		if(!this.worldObj.isRemote) {
			if(par1MovingObjectPosition.entityHit != null) {
				if(!par1MovingObjectPosition.entityHit.isImmuneToFire() && par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 5.0F)) {
					par1MovingObjectPosition.entityHit.setFire(4);
				}
			} else {
				int var2 = par1MovingObjectPosition.blockX;
				int var3 = par1MovingObjectPosition.blockY;
				int var4 = par1MovingObjectPosition.blockZ;
				
				switch(par1MovingObjectPosition.sideHit) {
				case 0:
					--var3;
					break;
				case 1:
					++var3;
					break;
				case 2:
					--var4;
					break;
				case 3:
					++var4;
					break;
				case 4:
					--var2;
					break;
				case 5:
					++var2;
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
