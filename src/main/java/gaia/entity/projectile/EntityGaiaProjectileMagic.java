package gaia.entity.projectile;

import gaia.entity.EntityAttributes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaProjectileMagic extends EntityFireball {

	public EntityGaiaProjectileMagic(World par1World) {
		super(par1World);
        this.setSize(0.3125F, 0.3125F);
	}
	
    public EntityGaiaProjectileMagic(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ) {
        super(worldIn, shooter, accelX, accelY, accelZ);
        this.setSize(0.3125F, 0.3125F);
    }

    protected float getMotionFactor() {
        return this.isInvulnerable() ? 0.73F : super.getMotionFactor();
    }

    public boolean isBurning() {
        return false;
    }
    
    /** EntityWitherSkull **/
    protected void onImpact(MovingObjectPosition movingObject) {
        if (!this.worldObj.isRemote) {
            if (movingObject.entityHit != null) {
            	movingObject.entityHit.attackEntityFrom(DamageSource.magic, (EntityAttributes.attackDamage2/2));

            	if (movingObject.entityHit instanceof EntityLivingBase) {
            		int i = 0;

                    if (this.worldObj.getDifficulty() == EnumDifficulty.NORMAL) {
                        i = 10;
                    }
                    else if (this.worldObj.getDifficulty() == EnumDifficulty.HARD) {
                        i = 40;
                    }

                    if (i > 0) {
                        ((EntityLivingBase)movingObject.entityHit).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 30 * i, 0));
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

    protected void entityInit() {
        this.dataWatcher.addObject(10, Byte.valueOf((byte)0));
    }

    public boolean isInvulnerable() {
        return this.dataWatcher.getWatchableObjectByte(10) == 1;
    }

    public void setInvulnerable(boolean par1) {
        this.dataWatcher.updateObject(10, Byte.valueOf((byte)(par1 ? 1 : 0)));
    }
}
