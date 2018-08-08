package gaia.entity.ai;

import gaia.GaiaConfig;
import gaia.entity.projectile.EntityGaiaProjectileMagic;
import gaia.entity.projectile.EntityGaiaProjectileSmallFireball;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

import static net.minecraft.world.EnumDifficulty.HARD;

public class Ranged {
	private Ranged() {}

	/**
	 * Shortcut Method for entities using ranged attacks.
	 * Use this to replace entity [attackEntityWithRangedAttack].
	 *
	 * @param target      the entity to fire at
	 * @param host        the entity that is shooting
	 * @param bonusdamage
	 * @see EntitySkeleton
	 */
	public static void rangedAttack(EntityLivingBase target, EntityLivingBase host, float bonusdamage) {
		Random rand = new Random();
		EntityTippedArrow entitytippedarrow = new EntityTippedArrow(host.world, host);
		double d0 = target.posX - host.posX;
		double d1 = target.getEntityBoundingBox().minY + target.height / 3.0D - entitytippedarrow.posY;
		double d2 = target.posZ - host.posZ;
		double d3 = MathHelper.sqrt(d0 * d0 + d2 * d2);
		entitytippedarrow.shoot(d0, d1 + d3 * 0.2D, d2, 1.6F, (float) (14 - host.world.getDifficulty().getDifficultyId() * 4));
		int i = EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.POWER, host);
		int j = EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.PUNCH, host);

		entitytippedarrow.setDamage(bonusdamage * 2.0D + rand.nextGaussian() * 0.25D + host.world.getDifficulty().getDifficultyId() * 0.11D);

		if (host.world.getDifficulty() == HARD && GaiaConfig.baseDamage.baseDamageArchers) {
			entitytippedarrow.addEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE, 1, 0));
		}

		if (i > 0) {
			entitytippedarrow.setDamage(entitytippedarrow.getDamage() + i * 0.5D + 0.5D);
		}

		if (j > 0) {
			entitytippedarrow.setKnockbackStrength(j);
		}

		boolean flag = host.isBurning() && host.getEntityWorld().getDifficulty() == HARD && rand.nextBoolean();
		flag = flag || EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.FLAME, host) > 0;

		if (flag) {
			entitytippedarrow.setFire(100);
		}

		ItemStack itemstack = host.getHeldItem(EnumHand.OFF_HAND);

		if (itemstack.getItem() == Items.TIPPED_ARROW) {
			entitytippedarrow.setPotionEffect(itemstack);
		}

		host.playSound(SoundEvents.ENTITY_ARROW_SHOOT, 1.0F, 1.0F / (host.getRNG().nextFloat() * 0.4F + 0.8F));
		host.world.spawnEntity(entitytippedarrow);
	}

	public static void fireball(EntityLivingBase target, EntityLivingBase host, float par2) {
		Random rand = new Random();

		host.playSound(SoundEvents.ENTITY_BLAZE_SHOOT, 1.0F, 1.0F / (rand.nextFloat() * 0.4F + 0.8F));
		double d0 = target.posX - host.posX;
		double d1 = target.getEntityBoundingBox().minY + target.height / 2.0D - (host.posY + host.height / 2.0D);
		double d2 = target.posZ - host.posZ;
		double f1 = MathHelper.sqrt(par2) * 0.5D;

		for (int var10 = 0; var10 < 1; ++var10) {
			EntityGaiaProjectileSmallFireball var11 = new EntityGaiaProjectileSmallFireball(host.world, host,
					d0 + rand.nextGaussian() * f1, d1, d2 + rand.nextGaussian() * f1);
			var11.posY = host.posY + host.height / 2.0D + 0.5D;
			host.world.spawnEntity(var11);
		}
	}

	public static void magic(EntityLivingBase target, EntityLivingBase host, float par2) {
		Random rand = new Random();

		host.playSound(SoundEvents.ENTITY_BLAZE_SHOOT, 1.0F, 1.0F / (rand.nextFloat() * 0.4F + 0.8F));

		double d0 = target.posX - host.posX;
		double d1 = target.getEntityBoundingBox().minY + target.height / 2.0D - (host.posY + host.height / 2.0D);
		double d2 = target.posZ - host.posZ;
		double f1 = MathHelper.sqrt(par2) * 0.5D;

		for (int var10 = 0; var10 < 1; ++var10) {
			EntityGaiaProjectileMagic var11 = new EntityGaiaProjectileMagic(host.world, host,
					d0 + rand.nextGaussian() * f1, d1, d2 + rand.nextGaussian() * f1);
			var11.posY = host.posY + host.height / 2.0D + 0.5D;
			host.world.spawnEntity(var11);
		}
	}
}
