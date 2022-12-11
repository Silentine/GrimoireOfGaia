package gaia.entity.goal;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class StrafeGoal extends Goal {
	private final Mob mob;
	private final double speedModifier;
	private int attackIntervalMin;
	private final float attackRadiusSqr;
	private int attackTime = -1;
	private int seeTime;
	private boolean strafingClockwise;
	private boolean strafingBackwards;
	private int strafingTime = -1;

	public StrafeGoal(Mob mob, double speedModifier, int attackIntervalMin, float maxDistance) {
		this.mob = mob;
		this.speedModifier = speedModifier;
		this.attackIntervalMin = attackIntervalMin;
		this.attackRadiusSqr = maxDistance * maxDistance;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	}

	public void setMinAttackInterval(int interval) {
		this.attackIntervalMin = interval;
	}

	public boolean canUse() {
		return this.mob.getTarget() == null;
	}

	public boolean canContinueToUse() {
		return seeTime != -60 && (this.canUse() || !this.mob.getNavigation().isDone());
	}

	public void start() {
		super.start();
		this.mob.setAggressive(true);
	}

	public void stop() {
		super.stop();
		this.mob.setAggressive(false);
		this.seeTime = 0;
		this.attackTime = -1;
		this.mob.stopUsingItem();
	}

	public boolean requiresUpdateEveryTick() {
		return true;
	}

	public void tick() {
		LivingEntity livingentity = this.mob.getTarget();
		if (livingentity != null) {
			double distance = this.mob.distanceToSqr(livingentity.getX(), livingentity.getY(), livingentity.getZ());
			boolean hasLineOfSight = this.mob.getSensing().hasLineOfSight(livingentity);
			boolean flag1 = this.seeTime > 0;
			if (hasLineOfSight != flag1) {
				this.seeTime = 0;
			}

			if (hasLineOfSight) {
				++this.seeTime;
			} else {
				--this.seeTime;
			}

			if (!(distance > (double) this.attackRadiusSqr) && this.seeTime >= 20) {
				this.mob.getNavigation().stop();
				++this.strafingTime;
			} else {
				this.mob.getNavigation().moveTo(livingentity, this.speedModifier);
				this.strafingTime = -1;
			}

			if (this.strafingTime >= 20) {
				if ((double) this.mob.getRandom().nextFloat() < 0.3D) {
					this.strafingClockwise = !this.strafingClockwise;
				}

				if ((double) this.mob.getRandom().nextFloat() < 0.3D) {
					this.strafingBackwards = !this.strafingBackwards;
				}

				this.strafingTime = 0;
			}

			if (this.strafingTime > -1) {
				if (distance > (double) (this.attackRadiusSqr * 0.75F)) {
					this.strafingBackwards = false;
				} else if (distance < (double) (this.attackRadiusSqr * 0.25F)) {
					this.strafingBackwards = true;
				}

				this.mob.getMoveControl().strafe(this.strafingBackwards ? -1.0F : 1.0F, this.strafingClockwise ? 0.5F : -0.5F);
				this.mob.lookAt(livingentity, 30.0F, 30.0F);
			} else {
				this.mob.getLookControl().setLookAt(livingentity, 30.0F, 30.0F);
			}
		}
	}
}