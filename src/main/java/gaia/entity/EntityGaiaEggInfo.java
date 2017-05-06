package gaia.entity;

public class EntityGaiaEggInfo {
	/** 
	 * The entityID of the spawned mob 
	 */
	public final int spawnedID;
	/** 
	 * Base color of the egg 
	 */
	public final int primaryColor;
	/** 
	 * Color of the egg spots 
	 */
	public final int secondaryColor;
	private static final String __OBFID = "CL_00001539";

	public EntityGaiaEggInfo(int p_i1583_1_, int p_i1583_2_, int p_i1583_3_) {
		this.spawnedID = p_i1583_1_;
		this.primaryColor = p_i1583_2_;
		this.secondaryColor = p_i1583_3_;
	}
}