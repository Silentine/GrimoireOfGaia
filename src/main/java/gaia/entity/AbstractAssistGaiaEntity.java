package gaia.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityReference;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jspecify.annotations.Nullable;

public abstract class AbstractAssistGaiaEntity extends AbstractGaiaEntity implements NeutralMob {
	private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
	private long remainingTime;
	private @Nullable EntityReference<LivingEntity> persistentAngerTarget;

	public AbstractAssistGaiaEntity(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);
	}

	@Override
	public boolean canBeLeashed() {
		return !isAngry();
	}

	@Override
	public boolean isPreventingPlayerRest(ServerLevel level, Player player) {
		return this.isAngryAt(player, level);
	}

	@Override
	protected void customServerAiStep(ServerLevel level) {
		this.updatePersistentAnger(level, true);
	}

	@Override
	public void startPersistentAngerTimer() {
		this.setTimeToRemainAngry(PERSISTENT_ANGER_TIME.sample(this.random));
	}

	@Override
	public void setPersistentAngerEndTime(long endTime) {
		this.remainingTime = endTime;
	}

	@Override
	public long getPersistentAngerEndTime() {
		return this.remainingTime;
	}

	@Override
	public void setPersistentAngerTarget(@Nullable EntityReference<LivingEntity> persistentAngerTarget) {
		this.persistentAngerTarget = persistentAngerTarget;
	}

	@Override
	public @Nullable EntityReference<LivingEntity> getPersistentAngerTarget() {
		return persistentAngerTarget;
	}

	@Override
	protected void addAdditionalSaveData(ValueOutput output) {
		super.addAdditionalSaveData(output);
		this.addPersistentAngerSaveData(output);
	}

	@Override
	protected void readAdditionalSaveData(ValueInput input) {
		super.readAdditionalSaveData(input);
		this.readPersistentAngerSaveData(this.level(), input);
	}
}
