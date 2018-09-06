package gaia.entity.projectile;

import gaia.entity.EntityAttributes;
import gaia.entity.monster.EntityGaiaWerecat;
import gaia.init.GaiaBlocks;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityGaiaProjectileWeb extends EntityFireball {

	@SuppressWarnings("unused") // used in reflection
	public EntityGaiaProjectileWeb(World worldIn) {
		super(worldIn);
		setSize(0.3125F, 0.3125F);
	}

	public EntityGaiaProjectileWeb(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ) {
		super(worldIn, shooter, accelX, accelY, accelZ);
		setSize(0.3125F, 0.3125F);
	}

	@Override
	protected EnumParticleTypes getParticleType() {
		return EnumParticleTypes.EXPLOSION_NORMAL;
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
			if (result.entityHit != null) {
				result.entityHit.attackEntityFrom(DamageSource.MAGIC, (EntityAttributes.ATTACK_DAMAGE_1 / 2));
				
				double x = result.entityHit.posX;
				double y = result.entityHit.posY;
				double z = result.entityHit.posZ;

				if (this.world.isAirBlock(new BlockPos(x, y, z))) {
					this.world.setBlockState(new BlockPos(x, y, z), GaiaBlocks.WEB_TEMP.getDefaultState());
				}
			} else {
				BlockPos blockpos = result.getBlockPos().offset(result.sideHit);

				if (this.world.isAirBlock(blockpos)) {
					this.world.setBlockState(blockpos, GaiaBlocks.WEB_TEMP.getDefaultState());
				}
			}

			this.setDead();
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
	protected void entityInit() {
		super.entityInit();
		dataManager.register(Vuln, 0);
	}

	private boolean isInvulnerable() {
		return dataManager.get(Vuln) == 1;
	}
}
