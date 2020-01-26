package gaia.entity.prop.spawner;

import javax.annotation.Nullable;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobProp;
import gaia.entity.monster.EntityGaiaGorgon;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaSpawnerGorgon extends EntityMobProp {

	private boolean spawned;

	public EntityGaiaSpawnerGorgon(World worldIn) {
		super(worldIn);
		/**
		 * Copy size of original mob
		 * 
		 * @see EntityGaiaVampire
		 */
		setSize(1.0F, 2.2F);
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
		EntityGaiaGorgon entity;

		entity = new EntityGaiaGorgon(world);
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
			return posY > ((!GaiaConfig.SPAWN.disableYRestriction) ? 60D : 0D) && world.isRaining() && world.getDifficulty() != EnumDifficulty.PEACEFUL && super.getCanSpawnHere();
		} else {
			return posY > ((!GaiaConfig.SPAWN.disableYRestriction) ? 60D : 0D) && world.getDifficulty() != EnumDifficulty.PEACEFUL && super.getCanSpawnHere();
		}
	}
	/* SPAWN CONDITIONS */
}
