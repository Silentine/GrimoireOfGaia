package gaia.entity.prop.spawner;

import javax.annotation.Nullable;

import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobProp;
import gaia.entity.monster.EntityGaiaEnderDragonGirl;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaSpawnerEnderDragonGirl extends EntityMobProp {

	private boolean spawned;

	public EntityGaiaSpawnerEnderDragonGirl(World worldIn) {
		super(worldIn);
		/**
		 * Copy size of original mob
		 * 
		 * @see EntityGaiaEnderDragonGirl
		 */
		setSize(0.6F, 2.2F);
		spawned = false;
	}

	@Override
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		int spawnChance = 25;

		if (world.rand.nextInt(100 / spawnChance) == 0 && !spawned) {
			setSpawn();
		} else {
			spawned = true;
		}

		return super.onInitialSpawn(difficulty, livingdata);
	}

	private void setSpawn() {
		EntityGaiaEnderDragonGirl entity;

		entity = new EntityGaiaEnderDragonGirl(world);
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
		return EntityAttributes.CHUNK_LIMIT_2;
	}

	public boolean getCanSpawnHere() {
		if (world.getDifficulty() == EnumDifficulty.PEACEFUL) {
			return false;
		} else {
			return super.getCanSpawnHere();
		}
	}
	/* SPAWN CONDITIONS */
}
