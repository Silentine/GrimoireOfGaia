package gaia.entity.projectile;

import gaia.entity.EntityAttributes;
import gaia.entity.monster.EntityGaiaWerecat;
import gaia.init.GaiaEntities;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.MobEffects;
import net.minecraft.init.Particles;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaProjectileBubble extends EntityFireball {

	public EntityGaiaProjectileBubble(World worldIn) {
		super(GaiaEntities.BUBBLE_PROJECTILE, worldIn, 0.3125F, 0.3125F);
		setSize(0.3125F, 0.3125F);
	}

	public EntityGaiaProjectileBubble(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ) {
	    this(worldIn);
	}

	@Override
	protected IParticleData func_195057_f() {
		return Particles.BUBBLE;
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
	 * @see EntityFireball
	 */
	@Override
	protected void onImpact(RayTraceResult result) {
		if (!world.isRemote) {
			if (result.entity != null) {
				result.entity.attackEntityFrom(DamageSource.MAGIC, (EntityAttributes.ATTACK_DAMAGE_2 / 2));

				if (result.entity instanceof EntityLivingBase) {
					int i = 0;

					if (world.getDifficulty() == EnumDifficulty.NORMAL) {
						i = 10;
					} else if (world.getDifficulty() == EnumDifficulty.HARD) {
						i = 20;
					}

					if (i > 0) {
						((EntityLivingBase) result.entity).addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, i * 20, 1));
					}
				}
			}

			this.world.newExplosion(this, this.posX, this.posY, this.posZ, 1.0F, false, false);
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

	private static final DataParameter<Integer> Vuln = EntityDataManager.createKey(EntityGaiaProjectileBubble.class, DataSerializers.VARINT);

	@Override
	protected void registerData() {
		super.registerData();
		this.getDataManager().register(Vuln, 0);
	}

	public boolean isInvulnerable() {
		return dataManager.get(Vuln) == 1;
	}
}
