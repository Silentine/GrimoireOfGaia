package gaia.entity.projectile;

import gaia.registry.GaiaRegistry;
import gaia.util.SharedEntityData;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
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
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

public class MagicProjectile extends SmallFireball {
	private static final EntityDataAccessor<Float> PROJECTILE_DAMAGE = SynchedEntityData.defineId(MagicProjectile.class, EntityDataSerializers.FLOAT);

	public MagicProjectile(EntityType<? extends SmallFireball> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	public MagicProjectile(Level level, LivingEntity livingEntity, Vec3 vec3) {
		super(level, livingEntity, vec3);
	}

	public MagicProjectile(Level p_37367_, double p_37368_, double p_37369_, double p_37370_, Vec3 p_347543_) {
		super(p_37367_, p_37368_, p_37369_, p_37370_, p_347543_);
	}


	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(PROJECTILE_DAMAGE, SharedEntityData.getAttackDamage2() / 2.0F);
	}

	@Override
	public ItemStack getItem() {
		ItemStack itemstack = super.getItem();
		return itemstack.isEmpty() ? new ItemStack(GaiaRegistry.PROJECTILE_MAGIC.get()) : itemstack;
	}

	@Override
	public EntityType<?> getType() {
		return GaiaRegistry.MAGIC.get();
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

	protected float getProjectileDamage() {
		return this.getEntityData().get(PROJECTILE_DAMAGE);
	}

	public void setDamage(float damage) {
		this.getEntityData().set(PROJECTILE_DAMAGE, damage);
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
				entity.hurt(damageSources().indirectMagic(this, ownerEntity), getProjectileDamage());

				if (entity instanceof LivingEntity livingEntity) {
					int effectTime = 0;

					if (this.level().getDifficulty() == Difficulty.NORMAL) {
						effectTime = 10;
					} else if (this.level().getDifficulty() == Difficulty.HARD) {
						effectTime = 20;
					}

					if (effectTime > 0) {
						livingEntity.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, effectTime * 20, 1));
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

	@Override
	protected void addAdditionalSaveData(ValueOutput output) {
		super.addAdditionalSaveData(output);
		output.putFloat("ProjectileDamage", this.getProjectileDamage());
	}

	@Override
	protected void readAdditionalSaveData(ValueInput input) {
		super.readAdditionalSaveData(input);
		setDamage(input.getFloatOr("ProjectileDamage", 0));
	}
}
