package gaia.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.util.math.MathHelper;

/**
 * @see EntityAILeapAtTarget
 */
public class EntityAIGaiaLeapAtTarget extends EntityAIBase {

	private EntityLiving leaper;
	private EntityLivingBase leapTarget;
	private double leapMotionY;

	public EntityAIGaiaLeapAtTarget(EntityLiving leapingEntity, float leapMotionYIn) {
		this.leaper = leapingEntity;
		this.leapMotionY = leapMotionYIn;
		this.setMutexBits(5);
	}

	@Override
	public boolean shouldExecute() {
		leapTarget = leaper.getAttackTarget();

		if (this.leapTarget == null) {
			return false;
		} else {
			double d0 = this.leaper.getDistanceSq(this.leapTarget);

			if (d0 >= 4.0D && d0 <= 16.0D) {
				if (!this.leaper.onGround) {
					return false;
				} else {
					return this.leaper.getRNG().nextInt(5) == 0;
				}
			} else {
				return false;
			}
		}
	}

	private boolean leaperCanAttack(double distance) {
		return (distance >= 4.0D && distance <= 16.0D) && (leaper.onGround && leaper.getRNG().nextInt(5) == 0);
	}

	@Override
	public boolean shouldContinueExecuting() {
		return !leaper.onGround;
	}

	@Override
	public void startExecuting() {
		double d0 = leapTarget.posX - leaper.posX;
		double d1 = leapTarget.posZ - leaper.posZ;
		float f = MathHelper.sqrt(d0 * d0 + d1 * d1);

		if ((double) f >= 1.0E-4D) {
			leaper.motionX += d0 / (double) f * 0.5D * 0.8D + leaper.motionX * 0.8D;
			leaper.motionZ += d1 / (double) f * 0.5D * 0.8D + leaper.motionZ * 0.8D;
		}

		leaper.motionY = leapMotionY;
	}
}
