package gaia.entity.projectile;

import gaia.registry.GaiaRegistry;
import gaia.util.SharedEntityData;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.hurtingprojectile.SmallFireball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.fluids.FluidType;
import org.jspecify.annotations.Nullable;

public class BubbleProjectile extends SmallFireball {
	public BubbleProjectile(EntityType<? extends SmallFireball> entityType, Level pLevel) {
		super(entityType, pLevel);
	}

	public BubbleProjectile(Level level, LivingEntity livingEntity, Vec3 p_347501_) {
		super(level, livingEntity, p_347501_);
	}

	public BubbleProjectile(Level level, double p_37368_, double p_37369_, double p_37370_, Vec3 p_347543_) {
		super(level, p_37368_, p_37369_, p_37370_, p_347543_);
	}

	@Override
	public ItemStack getItem() {
		ItemStack itemstack = super.getItem();
		return itemstack.isEmpty() ? new ItemStack(GaiaRegistry.PROJECTILE_BUBBLE.get()) : itemstack;
	}

	@Override
	public EntityType<?> getType() {
		return GaiaRegistry.BUBBLE.get();
	}

	@Override
	protected ParticleOptions getTrailParticle() {
		return ParticleTypes.BUBBLE;
	}

	@Override
	public void tick() {
		super.tick();
		if (this.tickCount > 60)
			discard();
	}

	@Override
	protected float getInertia() {
		return isInvulnerable() ? 0.73F : super.getInertia();
	}

	@Override
	public boolean isOnFire() {
		return false;
	}

	@Override
	protected void onHit(HitResult result) {
		super.onHit(result);
	}

	@Override
	protected void onHitBlock(BlockHitResult hitResult) {
		//No fire
	}

	@Override
	protected void onHitEntity(EntityHitResult entityResult) {
		if (!this.level().isClientSide()) {
			Entity owner = this.getOwner();
			if (owner instanceof LivingEntity ownerEntity) {
				Entity entity = entityResult.getEntity();
				entity.hurt(damageSources().indirectMagic(this, ownerEntity), SharedEntityData.getAttackDamage2() / 2.0F);

				if (entity instanceof LivingEntity livingEntity) {
					int effectTime = 0;

					if (this.level().getDifficulty() == Difficulty.NORMAL) {
						effectTime = 10;
					} else if (this.level().getDifficulty() == Difficulty.HARD) {
						effectTime = 20;
					}

					if (effectTime > 0) {
						livingEntity.addEffect(new MobEffectInstance(MobEffects.MINING_FATIGUE, effectTime * 20, 1));
					}
				}
			}
			this.level().explode(this, this.getX(), this.getY(), this.getZ(), 1.0F, false, Level.ExplosionInteraction.NONE);
		}
	}

	@Override
	public boolean canBeCollidedWith(@Nullable Entity other) {
		return false;
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource source, float damage) {
		return false;
	}

	@Override
	public boolean isPushedByFluid(FluidType type) {
		return false;
	}
}
