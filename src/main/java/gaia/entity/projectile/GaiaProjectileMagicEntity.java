package gaia.entity.projectile;

import gaia.entity.EntityAttributes;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.FMLPlayMessages;

public class GaiaProjectileMagicEntity extends AbstractGaiaProjectileEntity {

    public GaiaProjectileMagicEntity(EntityType<? extends AbstractGaiaProjectileEntity> entityType, World worldIn) {
        super(entityType, worldIn);
    }

    public GaiaProjectileMagicEntity(World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(GaiaEntities.MAGIC_PROJECTILE, worldIn, shooter, accelX, accelY, accelZ);
    }

    public GaiaProjectileMagicEntity(FMLPlayMessages.SpawnEntity spawnEntity, World worldIn) {
        this(GaiaEntities.MAGIC_PROJECTILE, worldIn);
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(GaiaItems.WEAPON_PROP_PROJECTILE_MAGIC);
    }

    @Override
    protected IParticleData getParticle() {
        return ParticleTypes.END_ROD;
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.getType() == RayTraceResult.Type.ENTITY) {
            Entity entity = ((EntityRayTraceResult)result).getEntity();
            if (entity != null) {
                entity.attackEntityFrom(DamageSource.MAGIC, (EntityAttributes.ATTACK_DAMAGE_2 / 2));

                if (entity instanceof LivingEntity) {
                    int i = 0;

                    if (world.getDifficulty() == Difficulty.NORMAL) {
                        i = 10;
                    } else if (world.getDifficulty() == Difficulty.HARD) {
                        i = 20;
                    }

                    if (i > 0) {
                        ((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, i * 20, 1));
                    }
                }
            }
        }

        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte)3);
            this.remove();
        }
    }
}
