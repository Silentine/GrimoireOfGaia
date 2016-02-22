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
	
	public EntityGaiaProjectileMagic(World par1World, EntityLivingBase living, double par3, double par5, double par7) {
		super(par1World, living, par3, par5, par7);
        this.setSize(0.3125F, 0.3125F);
        
	}
	
    protected float getMotionFactor() {
        return this.isInvulnerable() ? 0.73F : super.getMotionFactor();
    }

	/*@SideOnly(Side.CLIENT)
	public EntityGaiaProjectileMagic(World par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
		super(par1World, par2, par4, par6, par8, par10, par12);
        this.setSize(0.3125F, 0.3125F);
	} */
	
    @Override
    public boolean isBurning() {
        return false;
    }
    
    protected void onImpact(MovingObjectPosition mop)
    {
    	if (!this.worldObj.isRemote)
    	{
    		if (mop.entityHit != null)
    		{
    			mop.entityHit.attackEntityFrom(DamageSource.magic, (EntityAttributes.attackDamage2/2));

    			if (mop.entityHit instanceof EntityLivingBase)
    			{
    				byte byte0 = 0;

    				if (this.worldObj.getDifficulty() == EnumDifficulty.NORMAL)
    				{
    					byte0 = 7;
    				}
    				else if (this.worldObj.getDifficulty() == EnumDifficulty.HARD)
    				{
    					byte0 = 15;
    				}

    				if (byte0 > 0)
    				{
    					((EntityLivingBase)mop.entityHit).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, byte0 * 30, 1));
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
