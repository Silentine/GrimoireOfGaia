package gaia.entity;

import gaia.GaiaConfig;

public class EntityAttributes {
	
	public static double attackSpeed1 = 1.25D;
	public static double attackSpeed2 = 1.275D;
	public static double attackSpeed3 = 1.30D;
	public static int experienceValue1 = 10;
	public static int experienceValue2 = 20;
	public static int experienceValue3 = 40;
	public static float maxHealth1 = 40.0F * (float)GaiaConfig.Tier1maxHealth / 100.0F;
	public static float maxHealth2 = 80.0F * (float)GaiaConfig.Tier2maxHealth / 100.0F;
	public static float maxHealth3 = 160.0F * (float)GaiaConfig.Tier3maxHealth / 100.0F;
	public static double moveSpeed1 = 0.25D;
	public static double moveSpeed2 = 0.275D;
	public static double moveSpeed3 = 0.30D;
	public static float attackDamage1 = 4.0F * (float)GaiaConfig.Tier1attackDamage / 100.0F;
	public static float attackDamage2 = 8.0F * (float)GaiaConfig.Tier2attackDamage / 100.0F;
	public static float attackDamage3 = 12.0F * (float)GaiaConfig.Tier3attackDamage / 100.0F;
	public static double rateArmor1 = 4.0D;
	public static double rateArmor2 = 8.0D;
	public static double rateArmor3 = 12.0D;
	public static float baseDefense1 = ((float)GaiaConfig.BaseDefense / 100.0F) * (40.0F * (float)GaiaConfig.Tier1maxHealth / 100.0F);
	public static float baseDefense2 = ((float)GaiaConfig.BaseDefense / 100.0F) * (80.0F * (float)GaiaConfig.Tier2maxHealth / 100.0F);
	public static float baseDefense3 = ((float)GaiaConfig.BaseDefense / 100.0F) * (160.0F * (float)GaiaConfig.Tier3maxHealth / 100.0F);
	public static double knockback1 = 0.30D;
	public static double knockback2 = 0.25D;
	public static double knockback3 = 0.20D;
	
	public static int rateraredrop = 40;
	public static double followrange = 40.0D;
}
