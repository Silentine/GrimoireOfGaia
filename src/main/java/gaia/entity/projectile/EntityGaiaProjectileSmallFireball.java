package gaia.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

/**
 * Same as EntitySmallFireball, except it does not spawn a fire block on impact
 * 
 * @see EntitySmallFireball
 *
 */
public class EntityGaiaProjectileSmallFireball extends EntitySmallFireball {

	@SuppressWarnings("unused") // used in reflection
	public EntityGaiaProjectileSmallFireball(World worldIn) {
		super(worldIn);
		setSize(0.3125F, 0.3125F);
	}

	public EntityGaiaProjectileSmallFireball(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ) {
		super(worldIn, shooter, accelX, accelY, accelZ);
		setSize(0.3125F, 0.3125F);
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		if (!world.isRemote) {
			if (result.entityHit != null && !result.entityHit.isImmuneToFire() && result.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, shootingEntity), 5.0F)) {
				result.entityHit.setFire(4);
			}
			setDead();
		}
	}

	@Override
	public boolean canBeCollidedWith() {
		return false;
	}

	@Override
	public boolean attackEntityFrom(DamageSource damageSource, float amount) {
		return false;
	}
}
