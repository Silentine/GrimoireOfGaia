package gaia.entity.projectile;

import gaia.entity.EntityAttributes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.MobEffects;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaProjectileMagicRandom extends EntityFireball {

	private int potionEffect;

	@SuppressWarnings("unused") // used in reflection
	public EntityGaiaProjectileMagicRandom(World worldIn) {
		super(worldIn);
		setSize(0.3125F, 0.3125F);
	}

	public EntityGaiaProjectileMagicRandom(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ) {
		super(worldIn, shooter, accelX, accelY, accelZ);
		setSize(0.3125F, 0.3125F);
	}

	@Override
	protected EnumParticleTypes getParticleType() {
		return EnumParticleTypes.END_ROD;
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
	protected void onImpact(RayTraceResult movingObject) {
		if (!world.isRemote) {
			if (movingObject.entityHit != null) {
				movingObject.entityHit.attackEntityFrom(DamageSource.MAGIC, (EntityAttributes.ATTACK_DAMAGE_2 / 2));

				if (movingObject.entityHit instanceof EntityLivingBase) {
					int i = 0;

					if (world.getDifficulty() == EnumDifficulty.NORMAL) {
						i = 10;
					} else if (world.getDifficulty() == EnumDifficulty.HARD) {
						i = 20;
					}

					if (i > 0) {
						switch (potionEffect) {
						case 0:
							((EntityLivingBase) movingObject.entityHit).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, i * 20, 1));
							break;
						case 1:
							((EntityLivingBase) movingObject.entityHit).addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, i * 20, 1));
							break;
						case 2:
							((EntityLivingBase) movingObject.entityHit).addPotionEffect(new PotionEffect(MobEffects.NAUSEA, i * 20, 1));
							break;
						case 3:
							((EntityLivingBase) movingObject.entityHit).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, i * 20, 1));
							break;
						case 4:
							((EntityLivingBase) movingObject.entityHit).addPotionEffect(new PotionEffect(MobEffects.HUNGER, i * 20, 1));
							break;
						case 5:
							((EntityLivingBase) movingObject.entityHit).addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, i * 20, 1));
							break;
						case 6:
							((EntityLivingBase) movingObject.entityHit).addPotionEffect(new PotionEffect(MobEffects.POISON, i * 10, 1));
							break;
						case 7:
							((EntityLivingBase) movingObject.entityHit).addPotionEffect(new PotionEffect(MobEffects.WITHER, i * 10, 1));
							break;
						case 8:
							((EntityLivingBase) movingObject.entityHit).addPotionEffect(new PotionEffect(MobEffects.LEVITATION, i * 10, 1));
							break;
						default:
							((EntityLivingBase) movingObject.entityHit).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, i * 20, 1));
						}
					}
				}
			}

			setDead();
		}
	}

	public int potionEffect(int value) {
		return potionEffect = value;
	}

	@Override
	public boolean canBeCollidedWith() {
		return false;
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		return false;
	}

	private static final DataParameter<Integer> Vuln = EntityDataManager.createKey(EntityGaiaProjectileMagicRandom.class, DataSerializers.VARINT);

	@Override
	protected void entityInit() {
		super.entityInit();
		dataManager.register(Vuln, 0);
	}

	private boolean isInvulnerable() {
		return dataManager.get(Vuln) == 1;
	}
}
