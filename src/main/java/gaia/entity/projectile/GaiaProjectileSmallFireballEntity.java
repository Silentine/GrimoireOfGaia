package gaia.entity.projectile;

import gaia.init.GaiaEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

public class GaiaProjectileSmallFireballEntity extends SmallFireballEntity {

    public GaiaProjectileSmallFireballEntity(EntityType<? extends SmallFireballEntity> entityType, World worldIn) {
        super(entityType, worldIn);
    }

    public GaiaProjectileSmallFireballEntity(World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(worldIn, shooter, accelX, accelY, accelZ);
    }

    @Override
    public EntityType<?> getType() {
        return GaiaEntities.FIREBALL_PROJECTILE;
    }

    public GaiaProjectileSmallFireballEntity(World worldIn, LivingEntity shooter) {
        this(GaiaEntities.FIREBALL_PROJECTILE, worldIn);
        this.shootingEntity = shooter;
    }

    public GaiaProjectileSmallFireballEntity(FMLPlayMessages.SpawnEntity spawnEntity, World worldIn) {
        this(GaiaEntities.FIREBALL_PROJECTILE, worldIn);
    }

    @Override
    protected IParticleData getParticle() {
        return ParticleTypes.END_ROD;
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.getType() == RayTraceResult.Type.ENTITY) {
            Entity entity = ((EntityRayTraceResult)result).getEntity();
            if (entity != null && !entity.isImmuneToFire() && entity.attackEntityFrom(DamageSource.causeFireballDamage(this, shootingEntity), 5.0F)) {
                entity.setFire(4);
            }
        }

        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte)3);
            this.remove();
        }
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
        return false;
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
