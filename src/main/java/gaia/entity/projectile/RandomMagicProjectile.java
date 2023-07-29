package gaia.entity.projectile;

import gaia.registry.GaiaDataSerializers;
import gaia.registry.GaiaRegistry;
import gaia.util.SharedEntityData;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages.SpawnEntity;
import net.minecraftforge.registries.ForgeRegistries;

public class RandomMagicProjectile extends SmallFireball {
	private static final EntityDataAccessor<ResourceLocation> EFFECT_LOCATION = SynchedEntityData.defineId(RandomMagicProjectile.class,
			GaiaDataSerializers.RESOURCE_LOCATION.get());

	public RandomMagicProjectile(EntityType<? extends SmallFireball> entityType, Level level) {
		super(entityType, level);
	}

	public RandomMagicProjectile(Level level) {
		this(GaiaRegistry.RANDOM_MAGIC.get(), level);
	}

	public RandomMagicProjectile(Level level, LivingEntity livingEntity, double accelX, double accelY, double accelZ) {
		super(level, livingEntity, accelX, accelY, accelZ);
	}

	@Override
	public ItemStack getItem() {
		ItemStack itemstack = this.getItemRaw();
		return itemstack.isEmpty() ? new ItemStack(GaiaRegistry.PROJECTILE_RANDOM_MAGIC.get()) : itemstack;
	}

	public RandomMagicProjectile(SpawnEntity spawnEntity, Level level) {
		this(GaiaRegistry.RANDOM_MAGIC.get(), level);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public EntityType<?> getType() {
		return GaiaRegistry.RANDOM_MAGIC.get();
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(EFFECT_LOCATION, ForgeRegistries.MOB_EFFECTS.getKey(MobEffects.MOVEMENT_SLOWDOWN));
	}

	public ResourceLocation getEffectLocation() {
		return this.entityData.get(EFFECT_LOCATION);
	}

	public MobEffect getEffect() {
		return getEffectLocation() == null ? null : ForgeRegistries.MOB_EFFECTS.getValue(getEffectLocation());
	}

	public void setEffectLocation(ResourceLocation effectLocation) {
		this.entityData.set(EFFECT_LOCATION, effectLocation);
	}

	public void setEffect(MobEffect effect) {
		setEffectLocation(ForgeRegistries.MOB_EFFECTS.getKey(effect));
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
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putString("EffectLocation", getEffectLocation() == null ? "" : getEffectLocation().toString());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		if (tag.contains("EffectLocation")) {
			String effect = tag.getString("EffectLocation");
			setEffectLocation(effect.isEmpty() ? null : ResourceLocation.tryParse(effect));
		}
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
		if (!this.level.isClientSide) {
			Entity owner = this.getOwner();
			if (owner instanceof LivingEntity ownerEntity) {
				Entity entity = entityResult.getEntity();
				entity.hurt(DamageSource.indirectMagic(this, ownerEntity), SharedEntityData.getAttackDamage2() / 2.0F);

				if (entity instanceof LivingEntity livingEntity) {
					int effectTime = 0;

					if (this.level.getDifficulty() == Difficulty.NORMAL) {
						effectTime = 10;
					} else if (this.level.getDifficulty() == Difficulty.HARD) {
						effectTime = 20;
					}

					if (effectTime > 0) {
						livingEntity.addEffect(new MobEffectInstance(getEffect(), effectTime * 20, 1));
					}
				}
			}
		}
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
