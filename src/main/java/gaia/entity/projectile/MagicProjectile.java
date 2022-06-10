package gaia.entity.projectile;

import gaia.registry.GaiaRegistry;
import gaia.util.SharedEntityData;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages.SpawnEntity;

public class MagicProjectile extends SmallFireball {
	public MagicProjectile(EntityType<? extends SmallFireball> entityType, Level level) {
		super(entityType, level);
	}

	public MagicProjectile(Level level, LivingEntity livingEntity, double accelX, double accelY, double accelZ) {
		super(level, livingEntity, accelX, accelY, accelZ);
	}

	@Override
	public ItemStack getItem() {
		ItemStack itemstack = this.getItemRaw();
		return itemstack.isEmpty() ? new ItemStack(GaiaRegistry.PROJECTILE_MAGIC.get()) : itemstack;
	}

	public MagicProjectile(SpawnEntity spawnEntity, Level level) {
		this(GaiaRegistry.MAGIC.get(), level);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public EntityType<?> getType() {
		return GaiaRegistry.SMALL_FIREBALL.get();
	}

	@Override
	protected ParticleOptions getTrailParticle() {
		return ParticleTypes.END_ROD;
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
		if (!this.level.isClientSide && result instanceof EntityHitResult entityResult) {
			Entity entity = entityResult.getEntity();
			entity.hurt(DamageSource.indirectMagic(this, entity), SharedEntityData.getAttackDamage2() / 2.0F);

			if (entity instanceof LivingEntity livingEntity) {
				int effectTime = 0;

				if (level.getDifficulty() == Difficulty.NORMAL) {
					effectTime = 10;
				} else if (level.getDifficulty() == Difficulty.HARD) {
					effectTime = 20;
				}

				if (effectTime > 0) {
					livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, effectTime * 20, 1));
				}
			}
		}
		discard();
	}

	@Override
	public boolean canBeCollidedWith() {
		return false;
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		return false;
	}
}