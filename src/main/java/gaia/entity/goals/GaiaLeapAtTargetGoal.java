package gaia.entity.goals;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

import java.util.EnumSet;

public class GaiaLeapAtTargetGoal extends Goal {

    private CreatureEntity leaper;
    private LivingEntity leapTarget;
    private double leapMotionY;

    public GaiaLeapAtTargetGoal(CreatureEntity leapingEntity, float leapMotionYIn) {
        this.leaper = leapingEntity;
        this.leapMotionY = leapMotionYIn;
        this.setMutexFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
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

    @Override
    public boolean shouldContinueExecuting() {
        return !leaper.onGround;
    }

    @Override
    public void startExecuting() {
        double d0 = leapTarget.getPosX() - leaper.getPosX();
        double d1 = leapTarget.getPosZ() - leaper.getPosZ();
        float f = MathHelper.sqrt(d0 * d0 + d1 * d1);
        Vec3d motion = leaper.getMotion();
        double motionX = motion.getX();
        double motionZ = motion.getZ();

        if ((double) f >= 1.0E-4D) {
            motionX += d0 / (double) f * 0.5D * 0.8D + motionX * 0.8D;
            motionZ += d1 / (double) f * 0.5D * 0.8D + motionZ * 0.8D;
        }

        double motionY = leapMotionY;

        leaper.setMotion(motionX, motionY, motionZ);
    }
}
