package gaia.entity.projectile;

import gaia.registry.GaiaRegistry;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.projectile.hurtingprojectile.SmallFireball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import org.jspecify.annotations.Nullable;

public class WebProjectile extends SmallFireball {

	public WebProjectile(EntityType<? extends SmallFireball> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	public WebProjectile(Level p_37375_, LivingEntity p_37376_, Vec3 p_347501_) {
		super(p_37375_, p_37376_, p_347501_);
	}

	public WebProjectile(Level p_37367_, double p_37368_, double p_37369_, double p_37370_, Vec3 p_347543_) {
		super(p_37367_, p_37368_, p_37369_, p_37370_, p_347543_);
	}

	@Override
	public ItemStack getItem() {
		ItemStack itemstack = super.getItem();
		return itemstack.isEmpty() ? new ItemStack(GaiaRegistry.PROJECTILE_WEB.get()) : itemstack;
	}

	@Override
	public EntityType<?> getType() {
		return GaiaRegistry.WEB.get();
	}

	@Override
	protected ParticleOptions getTrailParticle() {
		return ParticleTypes.SPIT;
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
	protected void onHitEntity(EntityHitResult entityResult) {
		if (!this.level().isClientSide()) {
			Entity owner = this.getOwner();
			if (owner instanceof LivingEntity ownerEntity) {
				entityResult.getEntity().hurt(damageSources().indirectMagic(this, ownerEntity), SharedEntityData.getAttackDamage2() / 2.0F);
			}
		}
	}

	@Override
	protected void onHitBlock(BlockHitResult result) {
		BlockState blockstate = this.level().getBlockState(result.getBlockPos());
		blockstate.onProjectileHit(this.level(), blockstate, result, this);
		if (!this.level().isClientSide()) {
			Entity entity = this.getOwner();
			if (!(entity instanceof Mob) || EventHooks.canEntityGrief((ServerLevel) this.level(), this)) {
				BlockPos blockpos = result.getBlockPos().relative(result.getDirection());
				if (this.level().isEmptyBlock(blockpos)) {
					this.level().setBlockAndUpdate(blockpos, Blocks.COBWEB.defaultBlockState()); //TODO: WEB BLOCK
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
