package gaia.entity.projectile;

import gaia.registry.GaiaRegistry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.hurtingprojectile.SmallFireball;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

public class GaiaSmallFireball extends SmallFireball {


	public GaiaSmallFireball(EntityType<? extends SmallFireball> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	public GaiaSmallFireball(Level p_37375_, LivingEntity p_37376_, Vec3 p_347501_) {
		super(p_37375_, p_37376_, p_347501_);
	}

	public GaiaSmallFireball(Level p_37367_, double p_37368_, double p_37369_, double p_37370_, Vec3 p_347543_) {
		super(p_37367_, p_37368_, p_37369_, p_37370_, p_347543_);
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
		if (!this.level().isClientSide()) {
			Entity entity = entityResult.getEntity();
			if (!entity.fireImmune()) {
				Entity entity1 = this.getOwner();
				int i = entity.getRemainingFireTicks();
				entity.setRemainingFireTicks(20 * 4);
				DamageSource damagesource = damageSources().fireball(this, entity1);
				boolean flag = entity.hurtServer((ServerLevel) this.level(), damagesource, 4.0F);
				if (!flag) {
					entity.setRemainingFireTicks(i);
				} else if (entity1 instanceof LivingEntity) {
					if (this.level() instanceof ServerLevel serverlevel) {
						EnchantmentHelper.doPostAttackEffects(serverlevel, entity1, damagesource);
					}
				}
			}
		}
	}

	@Override
	protected void onHitBlock(BlockHitResult result) {
		//No fire
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
