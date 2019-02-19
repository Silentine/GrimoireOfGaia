package gaia.entity;

import gaia.GaiaConfig;

public class EntityAttributes {

	private EntityAttributes() {
	}

	public static final double ATTACK_SPEED_0 = 1.15D;
	public static final double ATTACK_SPEED_1 = 1.25D;
	public static final double ATTACK_SPEED_2 = 1.275D;
	public static final double ATTACK_SPEED_3 = 1.30D;

	public static final double ATTACK_SPEED_BOOST = 0.15D;

	public static final int EXPERIENCE_VALUE_1 = 10;
	public static final int EXPERIENCE_VALUE_2 = 20;
	public static final int EXPERIENCE_VALUE_3 = 40;

	public static final float MAX_HEALTH_1 = 40.0F * (float) GaiaConfig.COMMON.tier1maxHealth.get() / 100.0F;
	public static final float MAX_HEALTH_2 = 80.0F * (float) GaiaConfig.COMMON.tier2maxHealth.get() / 100.0F;
	public static final float MAX_HEALTH_3 = 160.0F * (float) GaiaConfig.COMMON.tier3maxHealth.get() / 100.0F;

	public static final double MOVE_SPEED_0 = 0.20D;
	public static final double MOVE_SPEED_1 = 0.25D;
	public static final double MOVE_SPEED_2 = 0.275D;
	public static final double MOVE_SPEED_3 = 0.30D;

	public static final float ATTACK_DAMAGE_1 = 4.0F * (float) GaiaConfig.COMMON.tier1attackDamage.get() / 100.0F;
	public static final float ATTACK_DAMAGE_2 = 8.0F * (float) GaiaConfig.COMMON.tier2attackDamage.get() / 100.0F;
	public static final float ATTACK_DAMAGE_3 = 12.0F * (float) GaiaConfig.COMMON.tier3attackDamage.get() / 100.0F;

	public static final double RATE_ARMOR_1 = 4.0D;
	public static final double RATE_ARMOR_2 = 8.0D;
	public static final double RATE_ARMOR_3 = 12.0D;

	public static final float BASE_DEFENSE_1 = ((100.0F / GaiaConfig.COMMON.tier1baseDefense.get()) * 0.01F) * (40.0F * (float) GaiaConfig.COMMON.tier1maxHealth.get() / 100.0F);
	public static final float BASE_DEFENSE_2 = ((100.0F / GaiaConfig.COMMON.tier2baseDefense.get()) * 0.01F) * (80.0F * (float) GaiaConfig.COMMON.tier2maxHealth.get() / 100.0F);
	public static final float BASE_DEFENSE_3 = ((100.0F / GaiaConfig.COMMON.tier3baseDefense.get()) * 0.01F) * (160.0F * (float) GaiaConfig.COMMON.tier3maxHealth.get() / 100.0F);

	public static final double KNOCKBACK_1 = 0.30D;
	public static final double KNOCKBACK_2 = 0.25D;
	public static final double KNOCKBACK_3 = 0.20D;

	public static final int CHUNK_LIMIT_1 = 4;
	public static final int CHUNK_LIMIT_2 = 2;
	public static final int CHUNK_LIMIT_3 = 1;
	public static final int CHUNK_LIMIT_UNDERGROUND = 2;

	public static final int RATE_RARE_DROP = 40;
	public static final int RATE_UNIQUE_RARE_DROP = 100;
	public static final double FOLLOW_RANGE = 40.0D;
}
