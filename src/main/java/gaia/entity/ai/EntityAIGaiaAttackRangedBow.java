package gaia.entity.ai;

import gaia.GaiaConfig;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackRangedBow;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBow;
import net.minecraft.util.EnumHand;

/**
 * @see EntityAIAttackRangedBow
 */
public class EntityAIGaiaAttackRangedBow extends EntityAIBase {

	private GaiaIRangedAttackMob archer;
	private EntityLiving entity;
	private final double moveSpeedAmp;
	private int attackCooldown;
	private final double maxAttackDistance;
	private int attackTime = -1;
	private int seeTime;
	private boolean strafingClockwise;
	private boolean strafingBackwards;
	private int strafingTime = -1;

	public EntityAIGaiaAttackRangedBow(GaiaIRangedAttackMob entity, double speedAmplifier, int delay, double maxDistance) {
		this.entity = (EntityLiving) entity;
		archer = entity;
		moveSpeedAmp = speedAmplifier;
		attackCooldown = delay;
		maxAttackDistance = maxDistance * maxDistance;
		setMutexBits(3);
	}

	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	@Override
	public boolean shouldExecute() {
		return entity.getAttackTarget() != null && entity.getHeldItemMainhand().getItem() == Items.BOW;
	}

	/**
	 * Returns whether an in-progress EntityAIBase should continue executing
	 */
	@Override
	public boolean shouldContinueExecuting() {
		return seeTime != -60 && (shouldExecute() || !entity.getNavigator().noPath()) && entity.getHeldItemMainhand().getItem() == Items.BOW;
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	@Override
	public void startExecuting() {
		super.startExecuting();
		archer.setHoldingBow(true);
	}

	/**
	 * Resets the task
	 */
	@Override
	public void resetTask() {
		super.resetTask();
		archer.setHoldingBow(false);
		seeTime = 0;
		attackTime = -1;
		entity.resetActiveHand();
	}

	/**
	 * Updates the task
	 */
	@Override
	public void updateTask() {
		EntityLivingBase entitylivingbase = entity.getAttackTarget();

		if (entitylivingbase != null) {
			double d0 = entity.getDistanceSq(entitylivingbase.posX, entitylivingbase.getEntityBoundingBox().minY, entitylivingbase.posZ);
			boolean flag = entity.getEntitySenses().canSee(entitylivingbase);
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
				entity.getNavigator().tryMoveToEntityLiving(entitylivingbase, moveSpeedAmp * 0.8);
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

				if (GaiaConfig.OPTIONS.strafingArchers) {
					entity.getMoveHelper()
							.strafe(strafingBackwards
									? -0.4F
									: 0.4F, strafingClockwise
									? 0.4F
									: -0.4F);
				} else {
					entity.getMoveHelper().strafe(0.01F, 0.01F);
				}
				entity.faceEntity(entitylivingbase, 10.0F, 10.0F);
			} else {
				entity.getLookHelper().setLookPositionWithEntity(entitylivingbase, 30.0F, 30.0F);
			}

			if (entity.isHandActive()) {
				if (!flag && seeTime < -60) {
					entity.resetActiveHand();
				} else if (flag) {
					int i = entity.getItemInUseMaxCount();

					if (i >= 20) {
						entity.resetActiveHand();
						archer.attackEntityWithRangedAttack(entitylivingbase, ItemBow.getArrowVelocity(i));
						attackTime = attackCooldown;
					}
				}
			} else if (--attackTime <= 0 && seeTime >= -60) {
				entity.setActiveHand(EnumHand.MAIN_HAND);
			}
		}
	}
}
