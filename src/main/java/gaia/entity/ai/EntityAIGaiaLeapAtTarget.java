package gaia.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.math.MathHelper;

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
		return leapTarget != null && leaperCanAttack(leaper.getDistanceSq(leapTarget));
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
		leaper.motionX += d0 / f * 0.5D * 0.8D + leaper.motionX * 0.8D;
		leaper.motionZ += d1 / f * 0.5D * 0.8D + leaper.motionZ * 0.8D;
		leaper.motionY = leapMotionY;
	}
}
