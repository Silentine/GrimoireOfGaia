package gaia.entity.goals;

import net.minecraft.block.Block;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.InteractDoorGoal;
import net.minecraft.world.Difficulty;

public class GaiaBreakDoorGoal extends InteractDoorGoal {
    private int breakingTime;
    private int previousBreakProgress = -1;

    public GaiaBreakDoorGoal(MobEntity entityIn) {
        super(entityIn);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute() {
        if (!super.shouldExecute()) {
            return false;
        } else if (!net.minecraftforge.common.ForgeHooks.canEntityDestroy(this.entity.world, this.doorPosition, this.entity)) {
            return false;
        } else {
            return !this.canDestroy();
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting() {
        super.startExecuting();
        this.breakingTime = 0;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean shouldContinueExecuting() {
        return this.breakingTime <= 240 && !this.canDestroy() && this.doorPosition.withinDistance(this.entity.getPositionVec(), 2.0D);
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void resetTask() {
        super.resetTask();
        this.entity.world.sendBlockBreakProgress(this.entity.getEntityId(), this.doorPosition, -1);
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void tick() {
        super.tick();

        if (this.entity.getRNG().nextInt(20) == 0) {
            this.entity.world.playEvent(1019, this.doorPosition, 0);
            if (!this.entity.isSwingInProgress) {
                this.entity.swingArm(this.entity.getActiveHand());
            }
        }

        this.breakingTime += 3;
        int i = (int) ((float) this.breakingTime / 240.0F * 10.0F);

        if (i != this.previousBreakProgress) {
            this.entity.world.sendBlockBreakProgress(this.entity.getEntityId(), this.doorPosition, i);
            this.previousBreakProgress = i;
        }

        if (this.breakingTime == 240 && this.entity.world.getDifficulty() != Difficulty.EASY) {
            this.entity.world.destroyBlock(this.doorPosition, false);
            this.entity.world.playEvent(1021, this.doorPosition, 0);
            this.entity.world.playEvent(2001, this.doorPosition, Block.getStateId(this.entity.world.getBlockState(this.doorPosition)));
        }
    }
}
