package gaia.entity.ai;

import gaia.ConfigGaia;
import gaia.entity.projectile.EntityGaiaProjectileSmallFireball;

import java.util.Random;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class Archers {
	
	/**Shortcut Method for Entities attacking with bows,
	 * Grafted from skeleton codebase
	 * Use this to replace entity [attackEntityWithRangedAttack]
	 * 
	 * @param target the entity to fire at
	 * @param host the entity that is shooting
	 * @param bonusdamage 
	 * 
	 * **/
	public static void RangedAttack(EntityLivingBase target, EntityLivingBase host, float bonusdamage)
    {
		Random rand = new Random();
        EntityTippedArrow entitytippedarrow = new EntityTippedArrow(host.worldObj, host);
        double d0 = target.posX - host.posX;
        double d1 = target.getEntityBoundingBox().minY + (double)(target.height / 3.0F) - entitytippedarrow.posY;
        double d2 = target.posZ - host.posZ;
        double d3 = (double)MathHelper.sqrt_double(d0 * d0 + d2 * d2);
        entitytippedarrow.setThrowableHeading(d0, d1 + d3 * 0.20000000298023224D, d2, 1.6F, (float)(14 - host.worldObj.getDifficulty().getDifficultyId() * 4));
        int i = EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.POWER, host);
        int j = EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.PUNCH, host);
        DifficultyInstance difficultyinstance = host.worldObj.getDifficultyForLocation(new BlockPos(host));
        entitytippedarrow.setDamage((double)(bonusdamage * 2.0F) + rand.nextGaussian() * 0.25D + (double)((float)host.worldObj.getDifficulty().getDifficultyId() * 0.11F));

        //TODO buffs to archers
        //Gaia archers have always been a tad weak, and with shields they're almost trivial foes
        //This will of course need delicate tweaking and balance
        if(host.worldObj.getDifficulty().getDifficultyId()==3 && ConfigGaia.HardmodeArchers){
        entitytippedarrow.addEffect(new PotionEffect(MobEffects.SLOWNESS, 20, 1));
        entitytippedarrow.addEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE, 1, 0));
        }
        if (i > 0)
        {
            entitytippedarrow.setDamage(entitytippedarrow.getDamage() + (double)i * 0.5D + 0.5D);
        }

        if (j > 0)
        {
            entitytippedarrow.setKnockbackStrength(j);
        }

        boolean flag = host.isBurning() && difficultyinstance.func_190083_c() && rand.nextBoolean();
        flag = flag || EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.FLAME, host) > 0;

        if (flag)
        {
            entitytippedarrow.setFire(100);
        }

        ItemStack itemstack = host.getHeldItem(EnumHand.OFF_HAND);

        if (itemstack != null && itemstack.getItem() == Items.TIPPED_ARROW)
        {
            entitytippedarrow.setPotionEffect(itemstack);
            
        }  
        
        host.playSound(SoundEvents.ENTITY_ARROW_SHOOT, 1.0F, 1.0F / (host.getRNG().nextFloat() * 0.4F + 0.8F));
        host.worldObj.spawnEntityInWorld(entitytippedarrow);
    }
	
	public static void fireball(EntityLivingBase target, EntityLivingBase host, float par2){
		Random rand = new Random();
		
		host.playSound(SoundEvents.ENTITY_BLAZE_SHOOT, 1.0F, 1.0F / (rand.nextFloat() * 0.4F + 0.8F));
		double d0 = target.posX - host.posX;
		double d1 = target.getEntityBoundingBox().minY + (double)(target.height / 2.0F) - (host.posY + (double)(host.height / 2.0F));
		double d2 = target.posZ - host.posZ;
		float f1 = MathHelper.sqrt_float(par2) * 0.5F;
		
		for (int var10 = 0; var10 < 1; ++var10) {
			EntityGaiaProjectileSmallFireball var11 = new EntityGaiaProjectileSmallFireball(host.worldObj, host, d0 + rand.nextGaussian() * (double)f1, d1, d2 + rand.nextGaussian() * (double)f1);
			var11.posY = host.posY + (double)(host.height / 2.0F) + 0.5D;
			host.worldObj.spawnEntityInWorld(var11);
		}
	}
	

	
	
}
