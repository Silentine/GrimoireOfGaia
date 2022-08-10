package gaia.entity;

import gaia.entity.goal.MobAttackGoal;
import gaia.registry.GaiaRegistry;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
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
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class CobblestoneGolem extends AbstractGaiaEntity {

	private int attackAnimationTick;

	public CobblestoneGolem(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);
		this.xpReward = SharedEntityData.EXPERIENCE_VALUE_2;

		this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new MobAttackGoal(this, SharedEntityData.ATTACK_SPEED_0, true));
		this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.5D));
		this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)));
		this.targetSelector.addGoal(2, this.targetPlayerGoal = new NearestAttackableTargetGoal<>(this, Player.class, true));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, SharedEntityData.getMaxHealth2())
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE)
				.add(Attributes.MOVEMENT_SPEED, SharedEntityData.MOVE_SPEED_0)
				.add(Attributes.ATTACK_DAMAGE, SharedEntityData.getAttackDamage2())
				.add(Attributes.ARMOR, SharedEntityData.RATE_ARMOR_2)
				.add(Attributes.ATTACK_KNOCKBACK, SharedEntityData.KNOCKBACK_2)

				.add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
				.add(ForgeMod.STEP_HEIGHT_ADDITION.get(), 1.0F);
	}

	@Override
	public int getGaiaLevel() {
		return 2;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
	}

	@Override
	public int maxVariants() {
		return 0;
	}

	@Override
	public float getBaseDefense() {
		return SharedEntityData.getBaseDefense2();
	}

	@Override
	public boolean hurt(DamageSource source, float damage) {
		float input = getBaseDamage(source, damage);
		if (source.getEntity() instanceof Player player) {
			ItemStack itemstack = player.getItemInHand(player.getUsedItemHand());

			if (itemstack.canPerformAction(ToolActions.PICKAXE_DIG)) {
				input += 5;
			}
		}

		return super.hurt(source, input);
	}

	@Override
	public boolean doHurtTarget(Entity entityIn) {
		this.attackAnimationTick = 10;
		this.level.broadcastEntityEvent(this, (byte) 4);
		boolean flag = entityIn.hurt(DamageSource.mobAttack(this), 7F + random.nextInt(15));
		if (flag) {
			entityIn.setDeltaMovement(entityIn.getDeltaMovement().add(0.0D, (double) 0.6F, 0.0D));
			this.doEnchantDamageEffects(this, entityIn);
		}

		this.playSound(GaiaRegistry.COBBLESTONE_GOLEM.getAttack(), 1.0F, 1.0F);
		return flag;
	}

	public void handleEntityEvent(byte id) {
		if (id == 4) {
			attackAnimationTick = 10;
			playSound(GaiaRegistry.COBBLESTONE_GOLEM.getAttack(), 1.0F, 1.0F);
		} else {
			super.handleEntityEvent(id);
		}
	}

	public int getAttackAnimationTick() {
		return this.attackAnimationTick;
	}

	@Override
	public void aiStep() {
		super.aiStep();

		if (!level.isClientSide && isPassenger()) {
			stopRiding();
		}

		if (this.attackAnimationTick > 0) {
			--this.attackAnimationTick;
		}

		if (this.getDeltaMovement().horizontalDistanceSqr() > (double) 2.5000003E-7F && this.random.nextInt(5) == 0) {
			int i = Mth.floor(this.getX());
			int j = Mth.floor(this.getY() - (double) 0.2F);
			int k = Mth.floor(this.getZ());
			BlockPos pos = new BlockPos(i, j, k);
			BlockState blockstate = this.level.getBlockState(pos);
			if (!blockstate.isAir()) {
				this.level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, blockstate).setPos(pos), this.getX() + ((double) this.random.nextFloat() - 0.5D) * (double) this.getBbWidth(), this.getY() + 0.1D, this.getZ() + ((double) this.random.nextFloat() - 0.5D) * (double) this.getBbWidth(), 4.0D * ((double) this.random.nextFloat() - 0.5D), 0.5D, ((double) this.random.nextFloat() - 0.5D) * 4.0D);
			}
		}
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return null;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.STONE_BREAK;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.COBBLESTONE_GOLEM.getDeath();
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState state) {
		playSound(GaiaRegistry.COBBLESTONE_GOLEM.getStep(), 1.0F, 1.0F);
	}

	@Override
	public boolean fireImmune() {
		return true;
	}

	@Override
	public boolean canBeAffected(MobEffectInstance effectInstance) {
		return effectInstance.getEffect() != MobEffects.POISON &&
				effectInstance.getEffect() != MobEffects.HARM && super.canBeAffected(effectInstance);
	}

	protected float getDamageAfterMagicAbsorb(DamageSource source, float damage) {
		damage = super.getDamageAfterMagicAbsorb(source, damage);
		if (source.getEntity() == this) {
			damage = 0.0F;
		}

		if (source.isMagic()) {
			damage *= 0.15F;
		}

		return damage;
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_2;
	}

	public static boolean checkCobblestoneGolemSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, Random random) {
		return checkDaysPassed(levelAccessor) && checkAboveSeaLevel(levelAccessor, pos) && checkMonsterSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}