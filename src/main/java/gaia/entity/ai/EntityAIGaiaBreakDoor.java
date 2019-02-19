package gaia.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIDoorInteract;
import net.minecraft.world.EnumDifficulty;

/**
 * @see EntityAIBreakDoor
 */
public class EntityAIGaiaBreakDoor extends EntityAIDoorInteract {

	private int breakingTime;
	private int previousBreakProgress = -1;

	public EntityAIGaiaBreakDoor(EntityLiving entityIn) {
		super(entityIn);
	}

	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	public boolean shouldExecute() {
        IBlockState iblockstate = this.entity.world.getBlockState(this.doorPosition);

		if (!super.shouldExecute()) {
			return false;
		} else if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.entity.world, this.entity) || !this.entity.world.getBlockState(this.doorPosition).getBlock().canEntityDestroy(this.entity.world.getBlockState(this.doorPosition), this.entity.world, this.doorPosition, this.entity) || !net.minecraftforge.event.ForgeEventFactory.onEntityDestroyBlock(this.entity, this.doorPosition, this.entity.world.getBlockState(this.doorPosition))) {
			return false;
		} else {
			return !iblockstate.get(BlockDoor.OPEN);
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
        IBlockState iblockstate = this.entity.world.getBlockState(this.doorPosition);

		double d0 = this.entity.getDistanceSq(this.doorPosition);
		boolean flag;

		if (this.breakingTime <= 240) {
			if (!iblockstate.get(BlockDoor.OPEN) && d0 < 4.0D) {
				flag = true;
				return flag;
			}
		}

		flag = false;
		return flag;
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

        IBlockState iblockstate = this.entity.world.getBlockState(this.doorPosition);
        
		if (this.entity.getRNG().nextInt(20) == 0) {
			this.entity.world.playEvent(1019, this.doorPosition, 0);
		}

		this.breakingTime += 3;
		int i = (int) ((float) this.breakingTime / 240.0F * 10.0F);

		if (i != this.previousBreakProgress) {
			this.entity.world.sendBlockBreakProgress(this.entity.getEntityId(), this.doorPosition, i);
			this.previousBreakProgress = i;
		}

		if (this.breakingTime == 240 && this.entity.world.getDifficulty() != EnumDifficulty.EASY) {
			this.entity.world.destroyBlock(this.doorPosition, false);
			this.entity.world.playEvent(1021, this.doorPosition, 0);
			this.entity.world.playEvent(2001, this.doorPosition, Block.getStateId(iblockstate));
		}
	}
}
