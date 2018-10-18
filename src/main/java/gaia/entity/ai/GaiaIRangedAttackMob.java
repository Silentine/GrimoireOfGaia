package gaia.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;

/**
 * @see IRangedAttackMob
 */
public interface GaiaIRangedAttackMob extends IRangedAttackMob {

	/**
	 * Attack the specified entity using a ranged attack.
	 */
	void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor);

	/**
	 * Better interface for bow animations
	 */
	void setSwingingArms(boolean swingingArms);
	
//	boolean isTarget();
}
