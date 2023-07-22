package gaia.entity;

import gaia.registry.GaiaRegistry;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.Nullable;

public class Mummy extends AbstractGaiaEntity {

	public Mummy(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, SharedEntityData.ATTACK_SPEED_1, true));
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)));
		this.targetSelector.addGoal(2, this.targetPlayerGoal = new NearestAttackableTargetGoal<>(this, Player.class, true));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 40.0D)
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE_RANGED)
				.add(Attributes.MOVEMENT_SPEED, SharedEntityData.MOVE_SPEED_1)
				.add(Attributes.ATTACK_DAMAGE, 4.0D)
				.add(Attributes.ARMOR, SharedEntityData.RATE_ARMOR_1)

				.add(Attributes.KNOCKBACK_RESISTANCE, 0.5D)
				.add(ForgeMod.STEP_HEIGHT_ADDITION.get(), 1.0F);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
	}

	@Override
	public float getBaseDefense() {
		return SharedEntityData.getBaseDefense1();
	}

	@Override
	public boolean hurt(DamageSource source, float damage) {
		float input = getBaseDamage(source, damage);
		Entity entity = source.getDirectEntity();

		if (entity instanceof Player && random.nextBoolean() && !this.level.isClientSide) {
			level.broadcastEntityEvent(this, (byte) 12);
			setSpawn(0);
		}

		return super.hurt(source, input);
	}

	@Override
	public boolean doHurtTarget(Entity entityIn) {
		if (super.doHurtTarget(entityIn)) {
			if (entityIn instanceof LivingEntity livingEntity) {
				int effectTime = 0;

				if (this.level.getDifficulty() == Difficulty.NORMAL) {
					effectTime = 5;
				} else if (this.level.getDifficulty() == Difficulty.HARD) {
					effectTime = 10;
				}

				if (effectTime > 0) {
					livingEntity.addEffect(new MobEffectInstance(MobEffects.HUNGER, effectTime * 20, 0));
				}
			}

			float effectiveDifficulty = this.level.getCurrentDifficultyAt(blockPosition()).getEffectiveDifficulty();

			if (this.getMainHandItem().isEmpty() && this.isOnFire() && this.random.nextFloat() < effectiveDifficulty * 0.3F) {
				entityIn.setSecondsOnFire(2 * (int) effectiveDifficulty);
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	public void aiStep() {
		if (this.isAlive()) {
			boolean flag = this.isSunBurnTick();
			if (flag) {
				ItemStack itemstack = this.getItemBySlot(EquipmentSlot.HEAD);
				if (!itemstack.isEmpty()) {
					if (itemstack.isDamageableItem()) {
						itemstack.setDamageValue(itemstack.getDamageValue() + this.random.nextInt(2));
						if (itemstack.getDamageValue() >= itemstack.getMaxDamage()) {
							this.broadcastBreakEvent(EquipmentSlot.HEAD);
							this.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
						}
					}

					flag = false;
				}

				if (flag) {
					this.setSecondsOnFire(8);
					this.hurt(DamageSource.OUT_OF_WORLD, getMaxHealth() * 0.10F);
				}
			}
		}

		super.aiStep();
	}

	private void setSpawn(int id) {
		if (this.level.getDifficulty() != Difficulty.PEACEFUL) {
			BlockPos blockpos = blockPosition().offset(-1 + random.nextInt(3), 1, -1 + random.nextInt(3));
			if (id == 0) {
				GraveMite mite = GaiaRegistry.GRAVEMITE.getEntityType().create(this.level);
				if (mite != null) {
					mite.moveTo(blockpos, 0.0F, 0.0F);
					mite.finalizeSpawn((ServerLevel) this.level, this.level.getCurrentDifficultyAt(blockPosition()), null, (SpawnGroupData) null, (CompoundTag) null);
					level.addFreshEntity(mite);
				}
			}
		}
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
										MobSpawnType spawnType, @Nullable SpawnGroupData groupData, @Nullable CompoundTag tag) {
		SpawnGroupData data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, groupData, tag);

		return data;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaRegistry.MUMMY.getSay();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaRegistry.MUMMY.getHurt();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.MUMMY.getDeath();
	}

	public MobType getMobType() {
		return MobType.ARTHROPOD;
	}

	protected void playStepSound(BlockPos pos, BlockState state) {
		this.playSound(SoundEvents.ZOMBIE_STEP, 0.15F, 1.0F);
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_1;
	}

	public static boolean checkMummySpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
		return checkDaysPassed(levelAccessor) && checkAboveSeaLevel(levelAccessor, pos) && checkMonsterSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}