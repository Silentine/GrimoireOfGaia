package gaia.entity.projectile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractFireballEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class AbstractGaiaProjectileEntity extends AbstractFireballEntity implements IRendersAsItem {
    public AbstractGaiaProjectileEntity(EntityType<? extends AbstractGaiaProjectileEntity> entityType, World worldIn) {
        super(entityType, worldIn);
    }

    public AbstractGaiaProjectileEntity(EntityType<? extends AbstractGaiaProjectileEntity> entityType, World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(entityType, shooter, accelX, accelY, accelZ, worldIn);
    }

    public AbstractGaiaProjectileEntity(EntityType<? extends AbstractGaiaProjectileEntity> entityType, World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
        super(entityType, x, y, z, accelX, accelY, accelZ, worldIn);
    }

    @Override
    protected float getMotionFactor() {
        return isInvulnerable() ? 0.73F : super.getMotionFactor();
    }

    @Override
    protected void onImpact(RayTraceResult result) {

    }

    @Override
    public boolean isBurning() {
        return false;
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        return false;
    }

    private static final DataParameter<Integer> Vuln = EntityDataManager.createKey(AbstractGaiaProjectileEntity.class, DataSerializers.VARINT);

    @Override
    protected void registerData() {
        super.registerData();
        this.getDataManager().register(Vuln, 0);
    }

    @Override
    public boolean isInvulnerable() {
        return this.getDataManager().get(Vuln) == 1;
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
