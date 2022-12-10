package gaia.entity.prop;

import gaia.config.GaiaConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public abstract class AbstractPropEntity extends AgeableMob {

	protected AbstractPropEntity(EntityType<? extends AgeableMob> type, Level level) {
		super(type, level);
	}

	@Override
	public void tick() {
		super.tick();

		if (!level.isClientSide && isPassenger()) {
			stopRiding();
		}
	}

	protected static boolean checkDaysPassed(ServerLevelAccessor levelAccessor) {
		if (GaiaConfig.COMMON.spawnDaysPassed.get()) {
			return GaiaConfig.COMMON.spawnDaysSet.get() <= levelAccessor.dayTime() % 24000;
		} else {
			return true;
		}
	}

	/**
	 * Checks if the position is above sea level so the entity can spawn
	 */
	protected static boolean checkAboveSeaLevel(ServerLevelAccessor levelAccessor, BlockPos pos) {
		return GaiaConfig.COMMON.disableYRestriction.get() || pos.getY() > levelAccessor.getSeaLevel() - 16;
	}

	/**
	 * Checks if the position is below sea level so the entity can spawn
	 */
	protected static boolean checkBelowSeaLevel(ServerLevelAccessor levelAccessor, BlockPos pos) {
		return GaiaConfig.COMMON.disableYRestriction.get() || pos.getY() < levelAccessor.getSeaLevel() - 16;
	}

	public static boolean checkGaiaSpawnRules(EntityType<? extends AgeableMob> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, Random random) {
		return checkDarkEnough(levelAccessor, pos, random) && checkAnyLightMonsterSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}

	public static boolean checkAnyLightMonsterSpawnRules(EntityType<? extends AgeableMob> entityType, LevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, Random random) {
		return levelAccessor.getDifficulty() != Difficulty.PEACEFUL && checkMobSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}

	protected static boolean checkDarkEnough(ServerLevelAccessor levelAccessor, BlockPos pos, Random random) {
		if (levelAccessor.getBrightness(LightLayer.SKY, pos) > random.nextInt(32)) {
			return false;
		} else if (levelAccessor.getBrightness(LightLayer.BLOCK, pos) > 0) {
			return false;
		} else {
			int i = levelAccessor.getLevel().isThundering() ? levelAccessor.getMaxLocalRawBrightness(pos, 10) : levelAccessor.getMaxLocalRawBrightness(pos);
			return i <= random.nextInt(8);
		}
	}

	protected static boolean checkTagBlocks(ServerLevelAccessor levelAccessor, BlockPos pos, TagKey<Block> blockTag) {
		return levelAccessor.getBlockState(pos.below()).is(blockTag);
	}

	@Nullable
	@Override
	public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
		return null;
	}
}
