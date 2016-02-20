package gaia.entity;

import gaia.ConfigGaia;

public class EntityAttributes {
	public static int experienceValue1 = 10;
	public static int experienceValue2 = 25;
	public static int experienceValue3 = 50;
	public static float maxHealth1 = 40.0F * (float)ConfigGaia.Tier1maxHealth / 100.0F;
	public static float maxHealth2 = 80.0F * (float)ConfigGaia.Tier2maxHealth / 100.0F;
	public static float maxHealth3 = 160.0F * (float)ConfigGaia.Tier3maxHealth / 100.0F;
	public static float moveSpeed1 = 0.3F;
	public static float moveSpeed2 = 0.35F;
	public static float moveSpeed3 = 0.375F;
	public static float attackDamage1 = 4.0F * (float)ConfigGaia.Tier1attackDamage / 100.0F;
	public static float attackDamage2 = 8.0F * (float)ConfigGaia.Tier2attackDamage / 100.0F;
	public static float attackDamage3 = 12.0F * (float)ConfigGaia.Tier3attackDamage / 100.0F;
	public static int rateArmor1 = 4;
	public static int rateArmor2 = 8;
	public static int rateArmor3 = 16;
	public static double knockback1 = 0.30D;
	public static double knockback2 = 0.25D;
	public static double knockback3 = 0.20D;
}
