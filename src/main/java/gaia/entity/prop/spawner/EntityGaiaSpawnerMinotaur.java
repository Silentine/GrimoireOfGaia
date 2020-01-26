package gaia.entity.prop.spawner;

import javax.annotation.Nullable;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobProp;
import gaia.entity.monster.EntityGaiaMinotaur;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class EntityGaiaSpawnerMinotaur extends EntityMobProp {

	private boolean spawned;
	
	public EntityGaiaSpawnerMinotaur(World worldIn) {
		super(worldIn);
		/**
		 * Copy size of original mob
		 * 
		 * @see EntityGaiaMinotaur
		 */
		setSize(1.4F, 3.0F);
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
		EntityGaiaMinotaur entity;
		
		entity = new EntityGaiaMinotaur(world);
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
	private boolean isValidLightLevel() {
		BlockPos blockpos = new BlockPos(posX, getEntityBoundingBox().minY, posZ);

		if (world.getLightFor(EnumSkyBlock.SKY, blockpos) > rand.nextInt(32)) {
			return false;
		} else {
			int i = world.getLightFromNeighbors(blockpos);

			if (world.isThundering()) {
				int j = world.getSkylightSubtracted();
				world.setSkylightSubtracted(10);
				i = world.getLightFromNeighbors(blockpos);
				world.setSkylightSubtracted(j);
			}

			return i <= rand.nextInt(8);
		}
	}
	
	@Override
	public int getMaxSpawnedInChunk() {
		return EntityAttributes.CHUNK_LIMIT_3;
	}
	
	@Override
	public boolean getCanSpawnHere() {
		if (world.getDifficulty() == EnumDifficulty.PEACEFUL && GaiaConfig.SPAWN.spawnLevel3Rain) {
			return posY > ((!GaiaConfig.SPAWN.disableYRestriction) ? 32D : 0D) && world.isRaining() && world.getDifficulty() != EnumDifficulty.PEACEFUL && isValidLightLevel() && super.getCanSpawnHere();
		} else {
			return posY > ((!GaiaConfig.SPAWN.disableYRestriction) ? 32D : 0D) && world.getDifficulty() != EnumDifficulty.PEACEFUL && isValidLightLevel() && super.getCanSpawnHere();
		}
	}
	/* SPAWN CONDITIONS */
}
