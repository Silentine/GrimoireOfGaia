package gaia.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import org.apache.commons.lang3.tuple.Pair;

public class GaiaConfig {
	public static class Client {
		public final BooleanValue genderNeutral;

		Client(ForgeConfigSpec.Builder builder) {
			builder.comment("Client settings")
					.push("client");

			genderNeutral = builder
					.comment("When enabled makes the mobs look more gender neutral (default: false)")
					.define("genderNeutral", false);

			builder.pop();
		}
	}

	public static class Common {
		public final BooleanValue disableInvisibility;
		public final BooleanValue allPassiveMobsHostile;

		public final BooleanValue friendlyPersistence;

		public final IntValue tier1maxHealth;
		public final IntValue tier1attackDamage;
		public final IntValue tier1baseDefense;

		public final IntValue tier2maxHealth;
		public final IntValue tier2attackDamage;
		public final IntValue tier2baseDefense;

		public final IntValue tier3maxHealth;
		public final IntValue tier3attackDamage;
		public final IntValue tier3baseDefense;

		public final BooleanValue baseDamage;
		public final BooleanValue shieldsBlockPiercing;
		public final BooleanValue baseDamageArchers;

		public final BooleanValue spawnDaysPassed;
		public final IntValue spawnDaysSet;
		public final BooleanValue spawnLevel3Rain;
		public final BooleanValue disableYRestriction;
		public final BooleanValue spawnWeather;

		Common(ForgeConfigSpec.Builder builder) {
			builder.comment("General Settings")
					.push("General");

			disableInvisibility = builder
					.comment("Disable mobs that use the Invisibility status effect when far from a player [Default: false]")
					.define("disableInvisibility", false);

			allPassiveMobsHostile = builder
					.comment("All mobs are now hostile [Default: false]")
					.define("allPassiveMobsHostile", false);

			friendlyPersistence = builder
					.comment("Stop befriended mobs from despawning [Default: false]")
					.define("friendlyPersistence", false);

			builder.pop();
			builder.comment("Attribute settings")
					.push("Attributes");

			builder.comment("Tier 1")
					.push("Tier1");
			tier1maxHealth = builder
					.comment("Defines the health of Tier 1 Gaia mobs (50 = half, 200 = double) [40 = 20 Hearts]")
					.defineInRange("tier1maxHealth", 40, 1, Integer.MAX_VALUE);
			tier1attackDamage = builder
					.comment("Defines the attack damage of Tier 1 Gaia mobs (50 = half, 200 = double) [4 = 2 Hearts]")
					.defineInRange("tier1attackDamage", 4, 1, Integer.MAX_VALUE);
			tier1baseDefense = builder
					.comment("Defines the maximum amount of hits required to defeat Tier 1 Gaia mobs (0 = disable)")
					.defineInRange("tier1baseDefense", 2, 1, Integer.MAX_VALUE);
			builder.pop();

			builder.comment("Tier 2")
					.push("Tier2");
			tier2maxHealth = builder
					.comment("Defines the health of Tier 2 Gaia mobs (50 = half, 200 = double) [80 = 40 Hearts]")
					.defineInRange("tier2maxHealth", 80, 1, Integer.MAX_VALUE);
			tier2attackDamage = builder
					.comment("Defines the attack damage of Tier 2 Gaia mobs (50 = half, 200 = double) [8 = 4 Hearts]")
					.defineInRange("tier2attackDamage", 8, 1, Integer.MAX_VALUE);
			tier2baseDefense = builder
					.comment("Defines the maximum amount of hits required to defeat Tier 2 Gaia mobs (0 = disable)")
					.defineInRange("tier2baseDefense", 4, 1, Integer.MAX_VALUE);
			builder.pop();

			builder.comment("Tier 3")
					.push("Tier3");
			tier3maxHealth = builder
					.comment("Defines the health of Tier 3 Gaia mobs (50 = half, 200 = double) [160 = 80 Hearts]")
					.defineInRange("tier3maxHealth", 160, 1, Integer.MAX_VALUE);
			tier3attackDamage = builder
					.comment("Defines the attack damage of Tier 3 Gaia mobs (50 = half, 200 = double) [12 = 6 Hearts]")
					.defineInRange("tier3attackDamage", 12, 1, Integer.MAX_VALUE);
			tier3baseDefense = builder
					.comment("Defines the maximum amount of hits required to defeat Tier 3 Gaia mobs (0 = disable)")
					.defineInRange("tier3baseDefense", 8, 1, Integer.MAX_VALUE);
			builder.pop();

			builder.pop();
			builder.comment("Damage settings")
					.push("Damage");

			baseDamage = builder
					.comment("Melee attacks deal an additional 2.0 (1 heart) of damage [Default: true]")
					.define("baseDamage", true);
			shieldsBlockPiercing = builder
					.comment("Archers arrows deal an additional 1 (0.5 heart) of damage. [Default: true]")
					.define("baseDamage", true);
			baseDamageArchers = builder
					.comment("Base Damage (melee) won't penetrate Shields. [Default: true]")
					.define("shieldsBlockPiercing", true);

			builder.pop();
			builder.comment("Spawn settings")
					.push("Spawn");

			spawnDaysPassed = builder
					.comment("Mobs only spawn after a certain amount of days have passed [Default: false]")
					.define("spawnDaysPassed", false);

			spawnDaysSet = builder
					.comment("Amount of days required to have passed before they can start spawning [Default: 3]")
					.defineInRange("spawnDaysSet", 3, 1, Integer.MAX_VALUE);

			spawnLevel3Rain = builder
					.comment("Level 3 mobs only spawn when it is raining/snowing [Default: false]")
					.define("spawnLevel3Rain", false);

			disableYRestriction = builder
					.comment("Remove spawn conditions related to height (Y-axis) [Default: false]")
					.define("disableYRestriction", false);

			spawnWeather = builder
					.comment("Remove spawn conditions related to weather [Default: false]")
					.define("spawnWeather", false);

			builder.pop();
		}
	}

	public static final ForgeConfigSpec clientSpec;
	public static final Client CLIENT;

	static {
		final Pair<Client, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Client::new);
		clientSpec = specPair.getRight();
		CLIENT = specPair.getLeft();
	}

	public static final ForgeConfigSpec commonSpec;
	public static final Common COMMON;

	static {
		final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
		commonSpec = specPair.getRight();
		COMMON = specPair.getLeft();
	}
}
