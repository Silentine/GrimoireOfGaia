package gaia.entity.projectile;

import gaia.registry.GaiaRegistry;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages.SpawnEntity;

public class GaiaSmallFireball extends SmallFireball {
	public GaiaSmallFireball(EntityType<? extends SmallFireball> entityType, Level level) {
		super(entityType, level);
	}

	public GaiaSmallFireball(Level level, LivingEntity livingEntity, double accelX, double accelY, double accelZ) {
		super(level, livingEntity, accelX, accelY, accelZ);
	}

	public GaiaSmallFireball(SpawnEntity spawnEntity, Level level) {
		this(GaiaRegistry.SMALL_FIREBALL.get(), level);
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
	protected void onHit(HitResult result) {
		super.onHit(result);
	}

	@Override
	protected void onHitEntity(EntityHitResult entityResult) {
		if (!this.level.isClientSide) {
			Entity entity = entityResult.getEntity();
			if (!entity.fireImmune()) {
				Entity entity1 = this.getOwner();
				int i = entity.getRemainingFireTicks();
				entity.setSecondsOnFire(4);
				boolean flag = entity.hurt(DamageSource.fireball(this, entity1), 4.0F);
				if (!flag) {
					entity.setRemainingFireTicks(i);
				} else if (entity1 instanceof LivingEntity) {
					this.doEnchantDamageEffects((LivingEntity) entity1, entity);
				}
			}
		}
	}

	@Override
	protected void onHitBlock(BlockHitResult result) {
		//No fire
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
