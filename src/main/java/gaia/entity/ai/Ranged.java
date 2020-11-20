package gaia.entity.ai;

import static net.minecraft.world.EnumDifficulty.HARD;

import java.util.Random;

import gaia.GaiaConfig;
import gaia.entity.projectile.EntityGaiaProjectileBomb;
import gaia.entity.projectile.EntityGaiaProjectileBubble;
import gaia.entity.projectile.EntityGaiaProjectileMagic;
import gaia.entity.projectile.EntityGaiaProjectilePoison;
import gaia.entity.projectile.EntityGaiaProjectileMagicRandom;
import gaia.entity.projectile.EntityGaiaProjectileSmallFireball;
import gaia.entity.projectile.EntityGaiaProjectileWeb;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;

public class Ranged {
	private Ranged() {
	}

	/**
	 * Shortcut Method for entities using ranged attacks. Use this to replace entity [attackEntityWithRangedAttack].
	 *
	 * @param target      the entity to fire at
	 * @param host        the entity that is shooting
	 * @param bonusdamage bonus damage
	 * 
	 * @see               EntitySkeleton
	 */
	public static void rangedAttack(EntityLivingBase target, EntityLivingBase host, float bonusdamage) {
		Random rand = new Random();
		EntityTippedArrow entitytippedarrow = new EntityTippedArrow(host.world, host);
		double d0 = target.posX - host.posX;
		double d1 = target.getEntityBoundingBox().minY + target.height / 3.0D - entitytippedarrow.posY;
		double d2 = target.posZ - host.posZ;
		double d3 = MathHelper.sqrt(d0 * d0 + d2 * d2);
		entitytippedarrow.shoot(d0, d1 + d3 * 0.2D, d2, 1.6F, (float) (14 - host.world.getDifficulty().getId() * 4));
		int i = EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.POWER, host);
		int j = EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.PUNCH, host);

		entitytippedarrow.setDamage(bonusdamage * 2.0D + rand.nextGaussian() * 0.25D + host.world.getDifficulty().getId() * 0.11D);

		if (host.world.getDifficulty() == HARD && GaiaConfig.DAMAGE.baseDamageArchers) {
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

	/**
	 * Shortcut Method for entities using blaze attacks. Use this to replace entity [attackEntityWithRangedAttack].
	 *
	 * @param target         the entity to fire at
	 * @param host           the entity that is shooting
	 * @param distanceFactor distance
	 * 
	 * @see                  EntityBlaze
	 */
	public static void fireball(EntityLivingBase target, EntityLivingBase host, float distanceFactor) {
		Random rand = new Random();

		host.playSound(SoundEvents.ENTITY_BLAZE_SHOOT, 1.0F, 1.0F / (rand.nextFloat() * 0.4F + 0.8F));

		double d0 = target.posX - host.posX;
		double d1 = target.getEntityBoundingBox().minY + target.height / 2.0D - (host.posY + host.height / 2.0D);
		double d2 = target.posZ - host.posZ;
		double f1 = MathHelper.sqrt(distanceFactor) * 0.5D;

		for (int i = 0; i < 1; ++i) {
			EntityGaiaProjectileSmallFireball entitygaiaprojectilesmallfireball = new EntityGaiaProjectileSmallFireball(host.world, host, d0 + rand.nextGaussian() * f1, d1, d2 + rand.nextGaussian() * f1);
			entitygaiaprojectilesmallfireball.posY = host.posY + host.height / 2.0D;
			host.world.spawnEntity(entitygaiaprojectilesmallfireball);
		}
	}

	/**
	 * Shortcut Method for entities using magic attacks. Use this to replace entity [attackEntityWithRangedAttack].
	 *
	 * @param target         the entity to fire at
	 * @param host           the entity that is shooting
	 * @param distanceFactor distance
	 * 
	 * @see                  EntityBlaze
	 */
	public static void magic(EntityLivingBase target, EntityLivingBase host, float distanceFactor) {
		Random rand = new Random();

		host.playSound(SoundEvents.ENTITY_BLAZE_SHOOT, 1.0F, 1.0F / (rand.nextFloat() * 0.4F + 0.8F));

		double d0 = target.posX - host.posX;
		double d1 = target.getEntityBoundingBox().minY + target.height / 2.0D - (host.posY + host.height / 2.0D);
		double d2 = target.posZ - host.posZ;
		double f1 = MathHelper.sqrt(distanceFactor) * 0.5D;

		for (int i = 0; i < 1; ++i) {
			EntityGaiaProjectileMagic entitygaiaprojectilemagic = new EntityGaiaProjectileMagic(host.world, host, d0 + rand.nextGaussian() * f1, d1, d2 + rand.nextGaussian() * f1);
			entitygaiaprojectilemagic.posY = host.posY + host.height / 2.0D;
			host.world.spawnEntity(entitygaiaprojectilemagic);
		}
	}
	
	/**
	 * Shortcut Method for entities using random magic attacks. Use this to replace entity [attackEntityWithRangedAttack].
	 *
	 * @param target         the entity to fire at
	 * @param host           the entity that is shooting
	 * @param distanceFactor distance
	 * 
	 * @see                  EntityBlaze
	 */
	public static void magicRandom(EntityLivingBase target, EntityLivingBase host, float distanceFactor, double height, int potionEffect) {
		Random rand = new Random();

		host.playSound(SoundEvents.ENTITY_BLAZE_SHOOT, 1.0F, 1.0F / (rand.nextFloat() * 0.4F + 0.8F));

		double d0 = target.posX - host.posX;
		double d1 = target.getEntityBoundingBox().minY + target.height / 2.0D - (host.posY + host.height / 2.0D);
		double d2 = target.posZ - host.posZ;
		double f1 = MathHelper.sqrt(distanceFactor) * 0.5D;

		for (int i = 0; i < 1; ++i) {
			EntityGaiaProjectileMagicRandom entitygaiaprojectilemagicrandom = new EntityGaiaProjectileMagicRandom(host.world, host, d0 + rand.nextGaussian() * f1, d1, d2 + rand.nextGaussian() * f1);
			entitygaiaprojectilemagicrandom.potionEffect(potionEffect);
			entitygaiaprojectilemagicrandom.posY = host.posY + host.height / 2.0D + height;
			host.world.spawnEntity(entitygaiaprojectilemagicrandom);
		}
	}

	/**
	 * Shortcut Method for entities using web attacks. Use this to replace entity [attackEntityWithRangedAttack].
	 *
	 * @param target         the entity to fire at
	 * @param host           the entity that is shooting
	 * @param distanceFactor distance
	 * @param height         height from which the projectile spawns from
	 * 
	 * @see                  EntityBlaze
	 */
	public static void web(EntityLivingBase target, EntityLivingBase host, float distanceFactor, double height) {
		Random rand = new Random();

		host.playSound(SoundEvents.ENTITY_BLAZE_SHOOT, 1.0F, 1.0F / (rand.nextFloat() * 0.4F + 0.8F));

		double d0 = target.posX - host.posX;
		double d1 = target.getEntityBoundingBox().minY + target.height / 2.0D - (host.posY + host.height / 2.0D);
		double d2 = target.posZ - host.posZ;
		double f1 = MathHelper.sqrt(distanceFactor) * 0.5D;

		for (int i = 0; i < 1; ++i) {
			EntityGaiaProjectileWeb entitygaiaprojectileweb = new EntityGaiaProjectileWeb(host.world, host, d0 + rand.nextGaussian() * f1, d1, d2 + rand.nextGaussian() * f1);
			entitygaiaprojectileweb.posY = host.posY + host.height / 2.0D + height;
			host.world.spawnEntity(entitygaiaprojectileweb);
		}
	}

	/**
	 * Shortcut Method for entities using bubble attacks. Use this to replace entity [attackEntityWithRangedAttack].
	 *
	 * @param target         the entity to fire at
	 * @param host           the entity that is shooting
	 * @param distanceFactor distance
	 * 
	 * @see                  EntityBlaze
	 */
	public static void bubble(EntityLivingBase target, EntityLivingBase host, float distanceFactor) {
		Random rand = new Random();

		double d0 = target.posX - host.posX;
		double d1 = target.getEntityBoundingBox().minY + target.height / 2.0D - (host.posY + host.height / 2.0D);
		double d2 = target.posZ - host.posZ;
		double f1 = MathHelper.sqrt(distanceFactor) * 0.5D;

		for (int i = 0; i < 1; ++i) {
			EntityGaiaProjectileBubble entitygaiaprojectilebubble = new EntityGaiaProjectileBubble(host.world, host, d0 + rand.nextGaussian() * f1, d1, d2 + rand.nextGaussian() * f1);
			entitygaiaprojectilebubble.posY = host.posY + host.height / 2.0D;
			host.world.spawnEntity(entitygaiaprojectilebubble);
		}
	}

	/**
	 * Shortcut Method for entities using poison attacks. Use this to replace entity [attackEntityWithRangedAttack].
	 *
	 * @param target         the entity to fire at
	 * @param host           the entity that is shooting
	 * @param distanceFactor distance
	 * 
	 * @see                  EntityBlaze
	 */
	public static void poison(EntityLivingBase target, EntityLivingBase host, float distanceFactor) {
		Random rand = new Random();

		double d0 = target.posX - host.posX;
		double d1 = target.getEntityBoundingBox().minY + target.height / 2.0D - (host.posY + host.height / 2.0D);
		double d2 = target.posZ - host.posZ;
		double f1 = MathHelper.sqrt(distanceFactor) * 0.5D;

		for (int i = 0; i < 1; ++i) {
			EntityGaiaProjectilePoison entitygaiaprojectile = new EntityGaiaProjectilePoison(host.world, host, d0 + rand.nextGaussian() * f1, d1, d2 + rand.nextGaussian() * f1);
			entitygaiaprojectile.posY = host.posY + host.height / 2.0D;
			host.world.spawnEntity(entitygaiaprojectile);
		}
	}

	/**
	 * Shortcut Method for entities using potion attacks. Use this to replace entity [attackEntityWithRangedAttack].
	 *
	 * @param target         the entity to fire at
	 * @param host           the entity that is shooting
	 * @param distanceFactor distance
	 * @param potiontype     PotionType
	 * 
	 * @see                  EntityWitch
	 */
	public static void potion(EntityLivingBase target, EntityLivingBase host, float distanceFactor, PotionType potiontype) {
		Random rand = new Random();

		double d0 = target.posY + (double) target.getEyeHeight() - 1.100000023841858D;
		double d1 = target.posX + target.motionX - host.posX;
		double d2 = d0 - host.posY;
		double d3 = target.posZ + target.motionZ - host.posZ;
		float f = MathHelper.sqrt(d1 * d1 + d3 * d3);

		EntityPotion entitypotion = new EntityPotion(host.world, host, PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), potiontype));
		entitypotion.rotationPitch -= -20.0F;
		entitypotion.shoot(d1, d2 + (double) (f * 0.2F), d3, 0.75F, 8.0F);

		host.world.playSound((EntityPlayer) null, host.posX, host.posY, host.posZ, SoundEvents.ENTITY_WITCH_THROW, host.getSoundCategory(), 1.0F, 0.8F + rand.nextFloat() * 0.4F);
		host.world.spawnEntity(entitypotion);
	}

	/**
	 * Shortcut Method for entities using bomb attacks. Use this to replace entity [attackEntityWithRangedAttack].
	 *
	 * @param target         the entity to fire at
	 * @param distanceFactor distance
	 * @param distanceFactor distance
	 * 
	 * @see                  EntityWitch
	 */
	public static void bomb(EntityLivingBase target, EntityLivingBase host, float distanceFactor) {
		Random rand = new Random();

		double d0 = target.posY + (double) target.getEyeHeight() - 1.100000023841858D;
		double d1 = target.posX + target.motionX - host.posX;
		double d2 = d0 - host.posY;
		double d3 = target.posZ + target.motionZ - host.posZ;
		float f = MathHelper.sqrt(d1 * d1 + d3 * d3);

		EntityGaiaProjectileBomb entitygaiaprojectilebomb = new EntityGaiaProjectileBomb(host.world, host);
		entitygaiaprojectilebomb.rotationPitch -= -20.0F;
		entitygaiaprojectilebomb.shoot(d1, d2 + (double) (f * 0.2F), d3, 0.75F, 8.0F);

		host.world.playSound((EntityPlayer) null, host.posX, host.posY, host.posZ, SoundEvents.ENTITY_WITCH_THROW, host.getSoundCategory(), 1.0F, 0.8F + rand.nextFloat() * 0.4F);
		host.world.spawnEntity(entitygaiaprojectilebomb);
	}
}
