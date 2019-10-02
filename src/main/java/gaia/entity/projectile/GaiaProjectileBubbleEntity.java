package gaia.entity.projectile;

import gaia.entity.EntityAttributes;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.FMLPlayMessages;

public class GaiaProjectileBubbleEntity extends AbstractGaiaProjectileEntity {

    public GaiaProjectileBubbleEntity(EntityType<? extends AbstractGaiaProjectileEntity> entityType, World worldIn) {
        super(entityType, worldIn);
    }

    public GaiaProjectileBubbleEntity(World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(GaiaEntities.BUBBLE_PROJECTILE, worldIn, shooter, accelX, accelY, accelZ);
    }

    public GaiaProjectileBubbleEntity(FMLPlayMessages.SpawnEntity spawnEntity, World worldIn) {
        this(GaiaEntities.BUBBLE_PROJECTILE, worldIn);
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(GaiaItems.WEAPON_PROP_PROJECTILE_BUBBLE);
    }

    @Override
    protected IParticleData getParticle() {
        return ParticleTypes.BUBBLE;
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
                        ((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, i * 20, 1));
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
