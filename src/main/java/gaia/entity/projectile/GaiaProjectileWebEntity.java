package gaia.entity.projectile;

import gaia.entity.EntityAttributes;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.FMLPlayMessages;

public class GaiaProjectileWebEntity extends AbstractGaiaProjectileEntity {

    public GaiaProjectileWebEntity(EntityType<? extends AbstractGaiaProjectileEntity> entityType, World worldIn) {
        super(entityType, worldIn);
    }

    public GaiaProjectileWebEntity(World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(GaiaEntities.WEB_PROJECTILE.get(), worldIn, shooter, accelX, accelY, accelZ);
    }

    public GaiaProjectileWebEntity(FMLPlayMessages.SpawnEntity spawnEntity, World worldIn) {
        this(GaiaEntities.WEB_PROJECTILE.get(), worldIn);
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(GaiaItems.WEAPON_PROP_PROJECTILE_WEB.get());
    }

    @Override
    protected IParticleData getParticle() {
        return ParticleTypes.SMOKE;
    }

    @Override
    public boolean isBurning() {
        return false;
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.getType() == RayTraceResult.Type.ENTITY) {
            Entity entity = ((EntityRayTraceResult)result).getEntity();
            if (entity != null) {
                entity.attackEntityFrom(DamageSource.MAGIC, (EntityAttributes.ATTACK_DAMAGE_2 / 2));

                double x = entity.posX;
                double y = entity.posY;
                double z = entity.posZ;

                if (this.world.isAirBlock(new BlockPos(x, y, z))) {
                    this.world.setBlockState(new BlockPos(x, y, z), GaiaBlocks.WEB_TEMP.get().getDefaultState());
                }
            }
        } else if (result.getType() == RayTraceResult.Type.BLOCK) {
            BlockRayTraceResult blockTraceResult = (BlockRayTraceResult)result;
            BlockPos blockpos = blockTraceResult.getPos().offset(blockTraceResult.getFace());
            if (this.world.isAirBlock(blockpos)) {
                this.world.setBlockState(blockpos, GaiaBlocks.WEB_TEMP.get().getDefaultState());
            }
        }

        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte)3);
            this.remove();
        }
    }
}
