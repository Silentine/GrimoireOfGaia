package gaia.entity.projectile;

import gaia.init.GaiaEntities;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityType;
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

	public EntityGaiaProjectileSmallFireball(World worldIn) {
		super(worldIn);
		setSize(0.3125F, 0.3125F);
	}

	public EntityGaiaProjectileSmallFireball(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ) {
	    this(worldIn);
	}
	
	@Override
		public EntityType<?> getType() {
			return GaiaEntities.FIREBALL_PROJECTILE;
		}

	@Override
	protected void onImpact(RayTraceResult result) {
		if (!world.isRemote) {
			if (result.entity != null && !result.entity.isImmuneToFire() && result.entity.attackEntityFrom(DamageSource.causeFireballDamage(this, shootingEntity), 5.0F)) {
				result.entity.setFire(4);
			}
			remove();
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
