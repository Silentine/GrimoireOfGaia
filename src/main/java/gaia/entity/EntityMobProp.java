package gaia.entity;

import gaia.GaiaConfig;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityMobProp extends EntityAgeable {

	public EntityMobProp(World worldIn) {
		super(worldIn);
	}

	/* SPAWN CONDITIONS */
	public boolean daysPassed() {
		int daysPassedClientInt = (int) (world.getWorldTime() / 24000);

		return GaiaConfig.SPAWN.spawnDaysSet <= daysPassedClientInt;
	}

	@Override
	public boolean getCanSpawnHere() {
		if (GaiaConfig.SPAWN.spawnDaysPassed) {
			return daysPassed() && super.getCanSpawnHere();
		} else {
			return super.getCanSpawnHere();
		}
	}
	/* SPAWN CONDITIONS */

	/**
	 * Used to access dropFewItems despite having a LootTable
	 */
	@Override
	protected void dropLoot(boolean wasRecentlyHit, int lootingModifier, DamageSource source) {
		super.dropLoot(wasRecentlyHit, lootingModifier, source);
		dropFewItems(wasRecentlyHit, lootingModifier);
	}

	public EntityAgeable createChild(EntityAgeable entityageable) {
		return null;
	}
}
