package gaia.entity.ai;

import net.minecraft.entity.IRangedAttackMob;

public interface GaiaIRangedAttackMob extends IRangedAttackMob {

	/**
	 * Better interface for bow animations
	 */
	void setHoldingBow(boolean holdingBow);
}
