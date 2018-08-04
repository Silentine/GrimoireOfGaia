package gaia.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.util.math.MathHelper;

public class EntityAIGaiaLeapAtTarget extends EntityAIBase {

    EntityLiving leaper;
    EntityLivingBase leapTarget;
    float leapMotionY;

    /**
     * @param leapingEntity
     * @param leapMotionYIn
     * @see EntityAILeapAtTarget
     */
    public EntityAIGaiaLeapAtTarget(EntityLiving leapingEntity, float leapMotionYIn) {
        this.leaper = leapingEntity;
        this.leapMotionY = leapMotionYIn;
        this.setMutexBits(5);
    }

    public boolean shouldExecute() {
        this.leapTarget = this.leaper.getAttackTarget();
        if (this.leapTarget == null) {
            return false;
        } else {
            double d0 = this.leaper.getDistanceSq(this.leapTarget);
            return d0 >= 4.0D && d0 <= 16.0D
                    ? (!this.leaper.onGround
                            ? false
                            : this.leaper.getRNG()
                                    .nextInt(5) == 0)
                    : false;
        }
    }

    public boolean shouldContinueExecuting() {
        return !this.leaper.onGround;
    }

    public void startExecuting() {
        double d0 = this.leapTarget.posX - this.leaper.posX;
        double d1 = this.leapTarget.posZ - this.leaper.posZ;
        float f = MathHelper.sqrt(d0 * d0 + d1 * d1);
        this.leaper.motionX += d0 / (double) f * 0.5D * 0.800000011920929D + this.leaper.motionX * 0.80000000298023225D;
        this.leaper.motionZ += d1 / (double) f * 0.5D * 0.800000011920929D + this.leaper.motionZ * 0.80000000298023225D;
        this.leaper.motionY = (double) this.leapMotionY;
    }
}
