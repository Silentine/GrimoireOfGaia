package gaia.entity.projectile;

import gaia.entity.EntityAttributes;
import gaia.entity.monster.EntityGaiaWerecat;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaEntities;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.Particles;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityGaiaProjectileWeb extends EntityFireball {

	public EntityGaiaProjectileWeb(World worldIn) {
		super(GaiaEntities.WEB_PROJECTILE, worldIn, 0.3125F, 0.3125F);
		setSize(0.3125F, 0.3125F);
	}

	public EntityGaiaProjectileWeb(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ) {
	    this(worldIn);
	}

	@Override
	protected IParticleData func_195057_f() {
	    return Particles.SMOKE;
	}

	@Override
	protected float getMotionFactor() {
		return isInvulnerable() ? 0.73F : super.getMotionFactor();
	}

	@Override
	public boolean isBurning() {
		return false;
	}

	/**
	 * @see EntitySmallFireball
	 */
	@Override
	protected void onImpact(RayTraceResult result) {
		if (!this.world.isRemote) {
			if (result.entity != null) {
				result.entity.attackEntityFrom(DamageSource.MAGIC, (EntityAttributes.ATTACK_DAMAGE_2 / 2));
				
				double x = result.entity.posX;
				double y = result.entity.posY;
				double z = result.entity.posZ;

				if (this.world.isAirBlock(new BlockPos(x, y, z))) {
					this.world.setBlockState(new BlockPos(x, y, z), GaiaBlocks.WEB_TEMP.getDefaultState());
				}
			} else {
				BlockPos blockpos = result.getBlockPos().offset(result.sideHit);

				if (this.world.isAirBlock(blockpos)) {
					this.world.setBlockState(blockpos, GaiaBlocks.WEB_TEMP.getDefaultState());
				}
			}

			this.remove();
		}
	}

	@Override
	public boolean canBeCollidedWith() {
		return false;
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		return false;
	}

	private static final DataParameter<Integer> Vuln = EntityDataManager.createKey(EntityGaiaWerecat.class, DataSerializers.VARINT);

	@Override
	protected void registerData() {
		super.registerData();
		this.getDataManager().register(Vuln, 0);
	}
	
	@Override
	public boolean isInvulnerable() {
		return this.getDataManager().get(Vuln) == 1;
	}
}
