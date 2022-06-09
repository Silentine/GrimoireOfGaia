package gaia.util;

import gaia.config.GaiaConfig;

public class SharedEntityData {
	public static final double ATTACK_SPEED_0 = 1.15D;
	public static final double ATTACK_SPEED_1 = 1.25D;
	public static final double ATTACK_SPEED_2 = 1.275D;
	public static final double ATTACK_SPEED_3 = 1.30D;

	public static final double ATTACK_SPEED_BOOST = 0.15D;

	public static final int EXPERIENCE_VALUE_1 = 10;
	public static final int EXPERIENCE_VALUE_2 = 20;
	public static final int EXPERIENCE_VALUE_3 = 40;

	public static int getMaxHealth1() {
		return GaiaConfig.COMMON.tier1maxHealth.get();
	}

	public static int getMaxHealth2() {
		return GaiaConfig.COMMON.tier2maxHealth.get();
	}

	public static int getMaxHealth3() {
		return GaiaConfig.COMMON.tier3maxHealth.get();
	}

	public static final double MOVE_SPEED_0 = 0.20D;
	public static final double MOVE_SPEED_1 = 0.25D;
	public static final double MOVE_SPEED_2 = 0.275D;
	public static final double MOVE_SPEED_3 = 0.30D;

	public static int getAttackDamage1() {
		return GaiaConfig.COMMON.tier1attackDamage.get();
	}

	public static int getAttackDamage2() {
		return GaiaConfig.COMMON.tier2attackDamage.get();
	}

	public static int getAttackDamage3() {
		return GaiaConfig.COMMON.tier3attackDamage.get();
	}

	public static final double RATE_ARMOR_1 = 4.0D;
	public static final double RATE_ARMOR_2 = 8.0D;
	public static final double RATE_ARMOR_3 = 12.0D;


	public static float getBaseDefense1() {
		return ((100.0F / GaiaConfig.COMMON.tier1baseDefense.get()) * 0.01F) * getMaxHealth1();
	}

	public static float getBaseDefense2() {
		return ((100.0F / GaiaConfig.COMMON.tier2baseDefense.get()) * 0.01F) * getMaxHealth2();
	}

	public static float getBaseDefense3() {
		return ((100.0F / GaiaConfig.COMMON.tier3baseDefense.get()) * 0.01F) * getMaxHealth3();
	}

	public static final double KNOCKBACK_1 = 0.30D;
	public static final double KNOCKBACK_2 = 0.25D;
	public static final double KNOCKBACK_3 = 0.20D;

	public static final int CHUNK_LIMIT_1 = 2;
	public static final int CHUNK_LIMIT_2 = 1;
	public static final int CHUNK_LIMIT_3 = 1;
	public static final int CHUNK_LIMIT_UNDERGROUND = 2;

	public static final int RATE_SEMI_RARE_DROP = 10;
	public static final int RATE_RARE_DROP = 40;
	public static final int RATE_UNIQUE_RARE_DROP = 100;
	public static final double FOLLOW_RANGE = 40.0D;
	public static final double FOLLOW_RANGE_NETHER = 30.0D;
}
