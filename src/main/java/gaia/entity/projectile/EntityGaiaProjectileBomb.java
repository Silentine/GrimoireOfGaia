package gaia.entity.projectile;

import gaia.entity.EntityAttributes;
import gaia.init.GaiaEntities;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Particles;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityGaiaProjectileBomb extends EntityThrowable {

	public EntityGaiaProjectileBomb(World worldIn) {
		super(GaiaEntities.BOMB_PROJECTILE, worldIn);
		setSize(0.3125F, 0.3125F);
	}

	public EntityGaiaProjectileBomb(World worldIn, EntityLivingBase throwerIn) {
		super(GaiaEntities.BOMB_PROJECTILE, worldIn);
		this.thrower = throwerIn;
	}

	@Override
	public void handleStatusUpdate(byte id) {
		if (id == 3) {
			for (int i = 0; i < 8; ++i) {
				this.world.spawnParticle(Particles.LARGE_SMOKE, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
			}
		}
	}

	/**
	 * @see EntityFireball
	 */
	@Override
	protected void onImpact(RayTraceResult result) {
		if (!this.world.isRemote) {
			if (result.entity != null) {
				result.entity.attackEntityFrom(DamageSource.MAGIC, (EntityAttributes.ATTACK_DAMAGE_2 / 2));
				result.entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)2);
			}

			this.world.newExplosion(this, this.posX, this.posY, this.posZ, 2.0F, false, false);
			this.remove();
		}
	}
}
