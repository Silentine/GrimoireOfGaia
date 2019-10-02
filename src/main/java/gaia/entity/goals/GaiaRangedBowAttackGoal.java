package gaia.entity.goals;

import gaia.config.GaiaConfig;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.item.BowItem;
import net.minecraft.util.Hand;

import java.util.EnumSet;

public class GaiaRangedBowAttackGoal extends Goal {
    private final IRangedAttackMob archer;
    private MobEntity entity;
    private final double moveSpeedAmp;
    private int attackCooldown;
    private final double maxAttackDistance;
    private int attackTime = -1;
    private int seeTime;
    private boolean strafingClockwise;
    private boolean strafingBackwards;
    private int strafingTime = -1;

    public GaiaRangedBowAttackGoal(IRangedAttackMob entity, double speedAmplifier, int delay, double maxDistance) {
        this.entity = (MobEntity) entity;
        this.archer = entity;
        this.moveSpeedAmp = speedAmplifier;
        this.attackCooldown = delay;
        this.maxAttackDistance = maxDistance * maxDistance;
        this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    public void setAttackCooldown(int cooldown) {
        this.attackCooldown = cooldown;
    }

    protected boolean isBowInMainhand() {
        return !this.entity.getHeldItemMainhand().isEmpty() && this.entity.getHeldItemMainhand().getItem() instanceof BowItem;
    }

    @Override
    public boolean shouldExecute() {
        return this.entity.getAttackTarget() == null ? false : this.isBowInMainhand();
    }

    @Override
    public boolean shouldContinueExecuting() {
        return (this.shouldExecute() || !this.entity.getNavigator().noPath()) && this.isBowInMainhand();
    }

    @Override
    public void resetTask() {
        super.resetTask();
        this.entity.setAttackTarget(null);
        this.attackTime = -1;
        this.entity.resetActiveHand();
    }

    @Override
    public void tick() {
        LivingEntity target = entity.getAttackTarget();

        if (target != null) {
            double d0 = entity.getDistanceSq(target.posX, target.getBoundingBox().minY, target.posZ);
            boolean flag = entity.getEntitySenses().canSee(target);
            boolean flag1 = seeTime > 0;

            if (flag != flag1) {
                seeTime = 0;
            }

            if (flag) {
                ++seeTime;
            } else {
                --seeTime;
            }

            if (d0 <= maxAttackDistance && seeTime >= 20) {
                entity.getNavigator().clearPath();
                ++strafingTime;
            } else {
                entity.getNavigator().tryMoveToEntityLiving(target, moveSpeedAmp * 0.8);
                strafingTime = -1;
            }

            if (strafingTime >= 20) {
                if (entity.getRNG().nextDouble() < 0.3D) {
                    strafingClockwise = !strafingClockwise;
                }

                if (entity.getRNG().nextDouble() < 0.3D) {
                    strafingBackwards = !strafingBackwards;
                }

                strafingTime = 0;
            }

            if (strafingTime > -1) {
                if (d0 > maxAttackDistance * 0.75D) {
                    strafingBackwards = false;
                } else if (d0 < maxAttackDistance * 0.25D) {
                    strafingBackwards = true;
                }

                if (GaiaConfig.COMMON.strafingArchers.get()) {
                    entity.getMoveHelper().strafe(strafingBackwards ? -0.4F : 0.4F, strafingClockwise ? 0.4F : -0.4F);
                } else {
                    entity.getMoveHelper().strafe(0.01F, 0.01F);
                }
                entity.faceEntity(target, 10.0F, 10.0F);
            } else {
                entity.getLookController().setLookPositionWithEntity(target, 30.0F, 30.0F);
            }

            if (entity.isHandActive()) {
                if (!flag && seeTime < -60) {
                    entity.resetActiveHand();
                } else if (flag) {
                    int i = entity.getItemInUseMaxCount();

                    if (i >= 20) {
                        entity.resetActiveHand();
                        archer.attackEntityWithRangedAttack(target, BowItem.getArrowVelocity(i));
                        attackTime = attackCooldown;
                    }
                }
            } else if (--attackTime <= 0 && seeTime >= -60) {
                entity.setActiveHand(Hand.MAIN_HAND);
            }
        }
    }
}
