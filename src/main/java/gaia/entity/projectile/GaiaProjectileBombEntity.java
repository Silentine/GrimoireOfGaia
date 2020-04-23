package gaia.entity.projectile;

import gaia.entity.EntityAttributes;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

public class GaiaProjectileBombEntity extends ProjectileItemEntity {

    public GaiaProjectileBombEntity(EntityType<? extends ProjectileItemEntity> entityType, World worldIn) {
        super(entityType, worldIn);
    }

    public GaiaProjectileBombEntity(World worldIn, LivingEntity shooter) {
        super(GaiaEntities.BOMB_PROJECTILE.get(), shooter, worldIn);
    }

    public GaiaProjectileBombEntity(FMLPlayMessages.SpawnEntity spawnEntity, World worldIn) {
        this(GaiaEntities.BOMB_PROJECTILE.get(), worldIn);
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(GaiaItems.WEAPON_PROJECTILE_BOMB.get());
    }

    @Override
    protected Item getDefaultItem() {
        return GaiaItems.WEAPON_PROJECTILE_BOMB.get();
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 3) {
            for(int i = 0; i < 8; ++i) {
                this.world.addParticle(ParticleTypes.LARGE_SMOKE, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.getType() == RayTraceResult.Type.ENTITY) {
            Entity entity = ((EntityRayTraceResult)result).getEntity();
            if (entity != null) {
                entity.attackEntityFrom(DamageSource.MAGIC, (EntityAttributes.ATTACK_DAMAGE_2 / 2));
                entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)2);
            }
        }

        if (!this.world.isRemote) {
            this.world.createExplosion(this, this.posX, this.posY, this.posZ, 1.5F, false, Explosion.Mode.NONE);
            this.world.setEntityState(this, (byte)3);
            this.remove();
        }
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
