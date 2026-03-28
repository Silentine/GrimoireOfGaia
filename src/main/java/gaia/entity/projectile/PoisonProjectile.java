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
import org.jspecify.annotations.Nullable;

public class PoisonProjectile extends SmallFireball {


	public PoisonProjectile(EntityType<? extends SmallFireball> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	public PoisonProjectile(Level p_37375_, LivingEntity p_37376_, Vec3 p_347501_) {
		super(p_37375_, p_37376_, p_347501_);
	}

	public PoisonProjectile(Level p_37367_, double p_37368_, double p_37369_, double p_37370_, Vec3 p_347543_) {
		super(p_37367_, p_37368_, p_37369_, p_37370_, p_347543_);
	}

	@Override
	public ItemStack getItem() {
		ItemStack itemstack = super.getItem();
		return itemstack.isEmpty() ? new ItemStack(GaiaRegistry.PROJECTILE_POISON.get()) : itemstack;
	}

	@Override
	public EntityType<?> getType() {
		return GaiaRegistry.POISON.get();
	}

	@Override
	protected ParticleOptions getTrailParticle() {
		return ParticleTypes.END_ROD;
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
						livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, effectTime * 20, 1));
					}
				}
			}
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
}
