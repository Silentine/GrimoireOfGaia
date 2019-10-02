package gaia.entity.goals;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.Goal;

import java.util.EnumSet;

public class GaiaStrafeGoal extends Goal {

    private MobEntity entity;
    private final double moveSpeedAmp;
    @SuppressWarnings("unused")
    private int attackCooldown;
    private final double maxAttackDistance;
    @SuppressWarnings("unused")
    private int attackTime = -1;
    private int seeTime;
    private boolean strafingClockwise;
    private boolean strafingBackwards;
    private int strafingTime = -1;

    public GaiaStrafeGoal(MobEntity entity, double speedAmplifier, int delay, double maxDistance) {
        this.entity = (MobEntity) entity;
        moveSpeedAmp = speedAmplifier;
        attackCooldown = delay;
        maxAttackDistance = maxDistance * maxDistance;
        this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    @Override
    public boolean shouldExecute() {
        return entity.getAttackTarget() != null;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    @Override
    public boolean shouldContinueExecuting() {
        return seeTime != -60 && (shouldExecute() || !entity.getNavigator().noPath());
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    @Override
    public void startExecuting() {
        super.startExecuting();
    }

    /**
     * Resets the task
     */
    @Override
    public void resetTask() {
        super.resetTask();
        seeTime = 0;
        attackTime = -1;
        entity.resetActiveHand();
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void tick()
    {
        LivingEntity target = this.entity.getAttackTarget();

        if (target != null)
        {
            double d0 = this.entity.getDistanceSq(target.posX, target.getBoundingBox().minY, target.posZ);
            boolean flag = this.entity.getEntitySenses().canSee(target);
            boolean flag1 = this.seeTime > 0;

            if (flag != flag1)
            {
                this.seeTime = 0;
            }

            if (flag)
            {
                ++this.seeTime;
            }
            else
            {
                --this.seeTime;
            }

            if (d0 <= (double)this.maxAttackDistance && this.seeTime >= 20)
            {
                this.entity.getNavigator().clearPath();
                ++this.strafingTime;
            }
            else
            {
                this.entity.getNavigator().tryMoveToEntityLiving(target, this.moveSpeedAmp);
                this.strafingTime = -1;
            }

            if (this.strafingTime >= 20)
            {
                if ((double)this.entity.getRNG().nextFloat() < 0.3D)
                {
                    this.strafingClockwise = !this.strafingClockwise;
                }

                if ((double)this.entity.getRNG().nextFloat() < 0.3D)
                {
                    this.strafingBackwards = !this.strafingBackwards;
                }

                this.strafingTime = 0;
            }

            if (this.strafingTime > -1)
            {
                if (d0 > (double)(this.maxAttackDistance * 0.75F))
                {
                    this.strafingBackwards = false;
                }
                else if (d0 < (double)(this.maxAttackDistance * 0.25F))
                {
                    this.strafingBackwards = true;
                }

                this.entity.getMoveHelper().strafe(this.strafingBackwards ? -1.0F : 1.0F, this.strafingClockwise ? 0.5F : -0.5F);
                this.entity.faceEntity(target, 30.0F, 30.0F);
            }
            else
            {
                this.entity.getLookController().setLookPositionWithEntity(target, 30.0F, 30.0F);
            }
        }
    }
}
