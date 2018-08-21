package gaia.entity.projectile;

import javax.annotation.Nonnull;

import gaia.entity.EntityAttributes;
import gaia.entity.monster.EntityGaiaWerecat;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.MobEffects;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaProjectileMagic extends EntityFireball {

    public EntityGaiaProjectileMagic(World worldIn) {
        super(worldIn);
        this.setSize(0.3125F, 0.3125F);
    }

    public EntityGaiaProjectileMagic(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ) {
        super(worldIn, shooter, accelX, accelY, accelZ);
        this.setSize(0.3125F, 0.3125F);
    }

    @Override
    protected EnumParticleTypes getParticleType() {
        return EnumParticleTypes.END_ROD;
    }

    protected float getMotionFactor() {
        return this.isInvulnerable()
                ? 0.73F
                : super.getMotionFactor();
    }

    public boolean isBurning() {
        return false;
    }

    /**
     * @see EntityFireball
     */
    @Override
    protected void onImpact(@Nonnull RayTraceResult movingObject) {
        if (!this.world.isRemote) {
            if (movingObject.entityHit != null) {
                movingObject.entityHit.attackEntityFrom(DamageSource.MAGIC, (EntityAttributes.attackDamage2 / 2));

                if (movingObject.entityHit instanceof EntityLivingBase) {
                    int i = 0;

                    if (this.world.getDifficulty() == EnumDifficulty.NORMAL) {
                        i = 10;
                    } else if (this.world.getDifficulty() == EnumDifficulty.HARD) {
                        i = 40;
                    }

                    if (i > 0) {
                        ((EntityLivingBase) movingObject.entityHit).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 30 * i, 0));
                    }
                }
            }

            this.setDead();
        }
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        return false;
    }

    /*
    protected void entityInit() {
        this.dataWatcher.addObject(10, Byte.valueOf((byte)0));
    }
     */

    private static final DataParameter<Integer> Vuln = EntityDataManager.<Integer>createKey(EntityGaiaWerecat.class, DataSerializers.VARINT);

    protected void entityInit() {
        super.entityInit();
        // this.dataWatcher.addObject(13, new Byte((byte)0));
        this.dataManager.register(Vuln, Integer.valueOf(0));
    }

    public boolean isInvulnerable() {
        // return this.dataWatcher.getWatchableObjectByte(10) == 1;
        return ((Integer) this.dataManager.get(Vuln)).intValue() == 1;
    }

    public void setInvulnerable(boolean par1) {
        // this.dataWatcher.updateObject(10, Byte.valueOf((byte)(par1 ? 1 :
        // 0)));
        this.dataManager.set(Vuln, (par1
                ? 1
                : 0));
    }
}
