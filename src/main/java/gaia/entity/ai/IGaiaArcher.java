package gaia.entity.ai;

import net.minecraft.entity.IRangedAttackMob;

public interface IGaiaArcher extends IRangedAttackMob{

	/** 
	 * Better interface for bow animations 
	 */
	public void setHoldingBow(boolean holdingBow);
}
