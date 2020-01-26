package gaia.entity.prop.spawner;

import javax.annotation.Nullable;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobProp;
import gaia.entity.monster.EntityGaiaValkyrie;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaSpawnerValkyrie extends EntityMobProp {

	private boolean spawned;

	public EntityGaiaSpawnerValkyrie(World worldIn) {
		super(worldIn);
		/**
		 * Copy size of original mob
		 * 
		 * @see EntityGaiaValkyrie
		 */
		setSize(1.0F, 2.0F);
		spawned = false;
	}

	@Override
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		int spawnChance = 10;

		if (world.rand.nextInt(100 / spawnChance) == 0 && !spawned) {
			setSpawn();
		} else {
			spawned = true;
		}

		return super.onInitialSpawn(difficulty, livingdata);
	}

	private void setSpawn() {
		EntityGaiaValkyrie entity;

		entity = new EntityGaiaValkyrie(world);
		entity.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
		entity.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(entity)), null);
		world.spawnEntity(entity);

		spawned = true;
	}

	public void onUpdate() {
		if (spawned)
			setDead();

		super.onUpdate();
	}

	/* SPAWN CONDITIONS */
	@Override
	public int getMaxSpawnedInChunk() {
		return EntityAttributes.CHUNK_LIMIT_3;
	}

	@Override
	public boolean getCanSpawnHere() {
		if (world.getDifficulty() == EnumDifficulty.PEACEFUL && GaiaConfig.SPAWN.spawnLevel3Rain) {
			return posY > ((!GaiaConfig.SPAWN.disableYRestriction) ? 80D : 0D) && world.isRaining() && world.getDifficulty() != EnumDifficulty.PEACEFUL && super.getCanSpawnHere();
		} else {
			return posY > ((!GaiaConfig.SPAWN.disableYRestriction) ? 80D : 0D) && world.getDifficulty() != EnumDifficulty.PEACEFUL && super.getCanSpawnHere();
		}
	}
	/* SPAWN CONDITIONS */
}
