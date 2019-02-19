package gaia.entity.ai;

import gaia.entity.monster.EntityGaiaCreep;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAICreeperSwell;

/**
 * @see EntityAICreeperSwell
 */
public class EntityAIGaiaCreepSwell extends EntityAIBase {

	private EntityGaiaCreep swellingCreep;
	private EntityLivingBase creepAttackTarget;

	public EntityAIGaiaCreepSwell(EntityGaiaCreep swellingCreep) {
		this.swellingCreep = swellingCreep;
		this.setMutexBits(1);
	}

	@Override
	public boolean shouldExecute() {
		EntityLivingBase entitylivingbase = swellingCreep.getAttackTarget();
		return swellingCreep.getCreeperState() > 0 || entitylivingbase != null && swellingCreep.getDistanceSq(entitylivingbase) < 9.0D;
	}

	@Override
	public void startExecuting() {
		swellingCreep.getNavigator().clearPath();
		creepAttackTarget = swellingCreep.getAttackTarget();
	}

	@Override
	public void resetTask() {
		creepAttackTarget = null;
	}

	@Override
	public void tick() {
		if (creepAttackTarget == null) {
			swellingCreep.setCreeperState(-1);
		} else if (swellingCreep.getDistanceSq(creepAttackTarget) > 49.0D) {
			swellingCreep.setCreeperState(-1);
		} else if (!swellingCreep.getEntitySenses().canSee(creepAttackTarget)) {
			swellingCreep.setCreeperState(-1);
		} else {
			swellingCreep.setCreeperState(1);
		}
	}
}
