package gaia.entity.prop;

import gaia.config.GaiaConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractPropEntity extends AgeableMob {

	protected AbstractPropEntity(EntityType<? extends AgeableMob> type, Level level) {
		super(type, level);
	}

	@Override
	public void tick() {
		super.tick();

		if (!this.level().isClientSide && isPassenger()) {
			stopRiding();
		}
	}

	public void finalizeAttributes() {

	}

	/**
	 * A copy of Monster#checkAnyLightMonsterSpawnRules adjusted to take in an EntityType of AgeableMob
	 */
	public static boolean checkAnyLightMonsterSpawnRules(EntityType<? extends AgeableMob> entityType, LevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
		return levelAccessor.getDifficulty() != Difficulty.PEACEFUL && checkMobSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}

	/**
	 * An adjusted version of Monster#checkMonsterSpawnRules adjusted for Prop mobs
	 */
	public static boolean checkPropSpawnRules(EntityType<? extends AgeableMob> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
		return isDarkEnoughToSpawn(levelAccessor, pos, random) && checkAnyLightMonsterSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}

	/**
	 * A copy of Monster#isDarkEnoughToSpawn
	 */
	public static boolean isDarkEnoughToSpawn(ServerLevelAccessor levelAccessor, BlockPos pos, RandomSource random) {
		if (levelAccessor.getBrightness(LightLayer.SKY, pos) > random.nextInt(32)) {
			return false;
		} else if (levelAccessor.getBrightness(LightLayer.BLOCK, pos) > 0) {
			return false;
		} else {
			int i = levelAccessor.getLevel().isThundering() ? levelAccessor.getMaxLocalRawBrightness(pos, 10) : levelAccessor.getMaxLocalRawBrightness(pos);
			return i <= random.nextInt(8);
		}
	}

	/**
	 * An adjusted version of Monster#checkMonsterSpawnRules adjusted for day time Prop mobs
	 */
	public static boolean checkDayPropSpawnRules(EntityType<? extends AgeableMob> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
		return checkDaylight(levelAccessor, pos) && checkAnyLightMonsterSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}

	/**
	 * Check if the lighting is good for spawning
	 */
	protected static boolean checkDaylight(ServerLevelAccessor levelAccessor, BlockPos pos) {
		return levelAccessor.canSeeSky(pos) && levelAccessor.getBrightness(LightLayer.BLOCK, pos) == 0;
	}

	/**
	 * Checks if the position is above sea level so the entity can spawn
	 */
	protected static boolean checkAboveSeaLevel(ServerLevelAccessor levelAccessor, BlockPos pos) {
		return checkAboveY(pos, levelAccessor.getSeaLevel());
	}

	/**
	 * Checks if the position is above a given Y level so the entity can spawn
	 */
	protected static boolean checkAboveY(BlockPos pos, int yLevel) {
		return GaiaConfig.COMMON.disableYRestriction.get() || pos.getY() > yLevel;
	}

	/**
	 * Checks if the position is below sea level so the entity can spawn
	 */
	protected static boolean checkBelowSeaLevel(ServerLevelAccessor levelAccessor, BlockPos pos) {
		return checkBelowY(pos, levelAccessor.getSeaLevel());
	}

	/**
	 * Checks if the position is above a given Y level so the entity can spawn
	 */
	protected static boolean checkBelowY(BlockPos pos, int yLevel) {
		return GaiaConfig.COMMON.disableYRestriction.get() || pos.getY() < yLevel;
	}

	/**
	 * Checks if the block under the spawn location is in the given tag so the entity can spawn
	 */
	protected static boolean checkTagBlocks(ServerLevelAccessor levelAccessor, BlockPos pos, TagKey<Block> blockTag) {
		return levelAccessor.getBlockState(pos.below()).is(blockTag);
	}

	/**
	 * Checks if the configured amount of days has passed so the entity can spawn
	 */
	protected static boolean checkDaysPassed(ServerLevelAccessor levelAccessor) {
		if (GaiaConfig.COMMON.spawnDaysPassed.get()) {
			return (int) (levelAccessor.dayTime() / 24000L) >= GaiaConfig.COMMON.spawnDaysSet.get();
		} else {
			return true;
		}
	}

	@Nullable
	@Override
	public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
		return null;
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
										MobSpawnType spawnType, @Nullable SpawnGroupData groupData, @Nullable CompoundTag tag) {
		this.finalizeAttributes();
		return super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, groupData, tag);
	}
}
