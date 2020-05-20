package gaia.util;

import gaia.config.GaiaConfig;
import gaia.entity.projectile.GaiaProjectileBombEntity;
import gaia.entity.projectile.GaiaProjectileBubbleEntity;
import gaia.entity.projectile.GaiaProjectileMagicEntity;
import gaia.entity.projectile.GaiaProjectilePoisonEntity;
import gaia.entity.projectile.GaiaProjectileSmallFireballEntity;
import gaia.entity.projectile.GaiaProjectileWebEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;

import java.util.Random;

public class RangedHelper {
    private RangedHelper() {
    }

    /**
     * Shortcut Method for entities using ranged attacks. Use this to replace entity [attackEntityWithRangedAttack].
     *
     * @param target      the entity to fire at
     * @param host        the entity that is shooting
     * @param bonusdamage bonus damage
     *
     * @see               net.minecraft.entity.monster.AbstractSkeletonEntity
     */
    public static void rangedAttack(LivingEntity target, LivingEntity host, float bonusdamage) {
        Random rand = new Random();
        ArrowEntity arrowEntity = new ArrowEntity(host.world, host);
        double d0 = target.getPosX() - host.getPosX();
        double d1 = target.getBoundingBox().minY + target.getHeight() / 3.0D - arrowEntity.getPosY();
        double d2 = target.getPosZ() - host.getPosZ();
        double d3 = MathHelper.sqrt(d0 * d0 + d2 * d2);
        arrowEntity.shoot(d0, d1 + d3 * 0.2D, d2, 1.6F, (float) (14 - host.world.getDifficulty().getId() * 4));
        int i = EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.POWER, host);
        int j = EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.PUNCH, host);

        arrowEntity.setDamage(bonusdamage * 2.0D + rand.nextGaussian() * 0.25D + host.world.getDifficulty().getId() * 0.11D);

        if (host.world.getDifficulty() == Difficulty.HARD && GaiaConfig.COMMON.baseDamageArchers.get()) {
            arrowEntity.addEffect(new EffectInstance(Effects.INSTANT_DAMAGE, 1, 0));
        }

        if (i > 0) {
            arrowEntity.setDamage(arrowEntity.getDamage() + i * 0.5D + 0.5D);
        }

        if (j > 0) {
            arrowEntity.setKnockbackStrength(j);
        }

        boolean flag = host.isBurning() && host.getEntityWorld().getDifficulty() == Difficulty.HARD && rand.nextBoolean();
        flag = flag || EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.FLAME, host) > 0;

        if (flag) {
            arrowEntity.setFire(100);
        }

        ItemStack itemstack = host.getHeldItem(Hand.OFF_HAND);

        if (itemstack.getItem() == Items.TIPPED_ARROW) {
            arrowEntity.setPotionEffect(itemstack);
        }

        host.playSound(SoundEvents.ENTITY_ARROW_SHOOT, 1.0F, 1.0F / (host.getRNG().nextFloat() * 0.4F + 0.8F));
        host.world.addEntity(arrowEntity);
    }

    /**
     * Shortcut Method for entities using blaze attacks. Use this to replace entity [attackEntityWithRangedAttack].
     *
     * @param target         the entity to fire at
     * @param host           the entity that is shooting
     * @param distanceFactor distance
     *
     * @see                  net.minecraft.entity.monster.BlazeEntity
     */
    public static void fireball(LivingEntity target, LivingEntity host, float distanceFactor) {
        Random rand = new Random();

        host.playSound(SoundEvents.ENTITY_BLAZE_SHOOT, 1.0F, 1.0F / (rand.nextFloat() * 0.4F + 0.8F));

        double d0 = target.getPosX() - host.getPosX();
        double d1 = target.getBoundingBox().minY + target.getHeight() / 2.0D - (host.getPosY() + host.getHeight() / 2.0D);
        double d2 = target.getPosZ() - host.getPosZ();
        double f1 = MathHelper.sqrt(distanceFactor) * 0.5D;

        for (int i = 0; i < 1; ++i) {
            GaiaProjectileSmallFireballEntity smallFireball = new GaiaProjectileSmallFireballEntity(host.world, host, d0 + rand.nextGaussian() * f1, d1, d2 + rand.nextGaussian() * f1);
            smallFireball.setPosition(smallFireball.getPosX(), host.getPosY() + host.getHeight() / 2.0D, smallFireball.getPosZ());

            host.world.addEntity(smallFireball);
        }
    }

    /**
     * Shortcut Method for entities using blaze attacks. Use this to replace entity [attackEntityWithRangedAttack].
     *
     * @param target         the entity to fire at
     * @param host           the entity that is shooting
     * @param distanceFactor distance
     *
     * @see                  net.minecraft.entity.monster.BlazeEntity
     */
    public static void magic(LivingEntity target, LivingEntity host, float distanceFactor) {
        Random rand = new Random();

        host.playSound(SoundEvents.ENTITY_BLAZE_SHOOT, 1.0F, 1.0F / (rand.nextFloat() * 0.4F + 0.8F));

        double d0 = target.getPosX() - host.getPosX();
        double d1 = target.getBoundingBox().minY + target.getHeight() / 2.0D - (host.getPosY() + host.getHeight() / 2.0D);
        double d2 = target.getPosZ() - host.getPosZ();
        double f1 = MathHelper.sqrt(distanceFactor) * 0.5D;

        for (int i = 0; i < 1; ++i) {
            GaiaProjectileMagicEntity projectileMagic = new GaiaProjectileMagicEntity(host.world, host, d0 + rand.nextGaussian() * f1, d1, d2 + rand.nextGaussian() * f1);
            projectileMagic.setPosition(projectileMagic.getPosX(), host.getPosY() + host.getHeight() / 2.0D, projectileMagic.getPosZ());
            host.world.addEntity(projectileMagic);
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
     * @see                  net.minecraft.entity.monster.BlazeEntity
     */
    public static void web(LivingEntity target, LivingEntity host, float distanceFactor, double height) {
        Random rand = new Random();

        host.playSound(SoundEvents.ENTITY_BLAZE_SHOOT, 1.0F, 1.0F / (rand.nextFloat() * 0.4F + 0.8F));

        double d0 = target.getPosX() - host.getPosX();
        double d1 = target.getBoundingBox().minY + target.getHeight() / 2.0D - (host.getPosY() + host.getHeight() / 2.0D);
        double d2 = target.getPosZ() - host.getPosZ();
        double f1 = MathHelper.sqrt(distanceFactor) * 0.5D;

        for (int i = 0; i < 1; ++i) {
            GaiaProjectileWebEntity projectileWeb = new GaiaProjectileWebEntity(host.world, host, d0 + rand.nextGaussian() * f1, d1, d2 + rand.nextGaussian() * f1);
            projectileWeb.setPosition(projectileWeb.getPosX(), host.getPosY() + host.getHeight() / 2.0D + height, projectileWeb.getPosZ());
            host.world.addEntity(projectileWeb);
        }
    }

    /**
     * Shortcut Method for entities using bubble attacks. Use this to replace entity [attackEntityWithRangedAttack].
     *
     * @param target         the entity to fire at
     * @param host           the entity that is shooting
     * @param distanceFactor distance
     *
     * @see                  net.minecraft.entity.monster.BlazeEntity
     */
    public static void bubble(LivingEntity target, LivingEntity host, float distanceFactor) {
        Random rand = new Random();

        double d0 = target.getPosX() - host.getPosX();
        double d1 = target.getBoundingBox().minY + target.getHeight() / 2.0D - (host.getPosY() + host.getHeight() / 2.0D);
        double d2 = target.getPosZ() - host.getPosZ();
        double f1 = MathHelper.sqrt(distanceFactor) * 0.5D;

        for (int i = 0; i < 1; ++i) {
            GaiaProjectileBubbleEntity projectileBubble = new GaiaProjectileBubbleEntity(host.world, host, d0 + rand.nextGaussian() * f1, d1, d2 + rand.nextGaussian() * f1);
            projectileBubble.setPosition(projectileBubble.getPosX(), host.getPosY() + host.getHeight() / 2.0D + host.getHeight(), projectileBubble.getPosZ());
            host.world.addEntity(projectileBubble);
        }
    }

    /**
     * Shortcut Method for entities using bubble attacks. Use this to replace entity [attackEntityWithRangedAttack].
     *
     * @param target         the entity to fire at
     * @param host           the entity that is shooting
     * @param distanceFactor distance
     *
     * @see                  net.minecraft.entity.monster.BlazeEntity
     */
    public static void poison(LivingEntity target, LivingEntity host, float distanceFactor) {
        Random rand = new Random();

        double d0 = target.getPosX() - host.getPosX();
        double d1 = target.getBoundingBox().minY + target.getHeight() / 2.0D - (host.getPosY() + host.getHeight() / 2.0D);
        double d2 = target.getPosZ() - host.getPosZ();
        double f1 = MathHelper.sqrt(distanceFactor) * 0.5D;

        for (int i = 0; i < 1; ++i) {
            GaiaProjectilePoisonEntity projectilePoison = new GaiaProjectilePoisonEntity(host.world, host, d0 + rand.nextGaussian() * f1, d1, d2 + rand.nextGaussian() * f1);
            projectilePoison.setPosition(projectilePoison.getPosX(), host.getPosY() + host.getHeight() / 2.0D + host.getHeight(), projectilePoison.getPosZ());
            host.world.addEntity(projectilePoison);
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
     * @see                  net.minecraft.entity.monster.WitchEntity
     */
    public static void potion(LivingEntity target, LivingEntity host, float distanceFactor, Potion potiontype) {
        Random rand = new Random();

        Vec3d motion = target.getMotion();
        double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.100000023841858D;
        double d1 = target.getPosX() + motion.getX() - host.getPosX();
        double d2 = d0 - host.getPosY();
        double d3 = target.getPosZ() + motion.getZ() - host.getPosZ();
        float f = MathHelper.sqrt(d1 * d1 + d3 * d3);

        for (int i = 0; i < 1; ++i) {
            PotionEntity potionEntity = new PotionEntity(host.world, host);
            potionEntity.setItem(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), potiontype));
            potionEntity.rotationPitch -= -20.0F;
            potionEntity.shoot(d1, d2 + (double) (f * 0.2F), d3, 0.75F, 8.0F);

            host.world.playSound((PlayerEntity) null, host.getPosX(), host.getPosY(), host.getPosZ(), SoundEvents.ENTITY_WITCH_THROW, host.getSoundCategory(), 1.0F, 0.8F + rand.nextFloat() * 0.4F);
            host.world.addEntity(potionEntity);
        }
    }

    /**
     * Shortcut Method for entities using bomb attacks. Use this to replace entity [attackEntityWithRangedAttack].
     *
     * @param target         the entity to fire at
     * @param distanceFactor distance
     * @param distanceFactor distance
     *
     * @see                  net.minecraft.entity.monster.WitchEntity
     */
    public static void bomb(LivingEntity target, LivingEntity host, float distanceFactor) {
        Random rand = new Random();

        Vec3d motion = target.getMotion();
        double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.100000023841858D;
        double d1 = target.getPosX() + motion.getX() - host.getPosX();
        double d2 = d0 - host.getPosY();
        double d3 = target.getPosZ() + motion.getZ() - host.getPosZ();
        float f = MathHelper.sqrt(d1 * d1 + d3 * d3);

        for (int i = 0; i < 1; ++i) {
            GaiaProjectileBombEntity projectileBomb = new GaiaProjectileBombEntity(host.world, host);
            projectileBomb.rotationPitch -= -20.0F;
            projectileBomb.shoot(d1, d2 + (double) (f * 0.2F), d3, 0.75F, 8.0F);

            host.world.playSound((PlayerEntity) null, host.getPosX(), host.getPosY(), host.getPosZ(), SoundEvents.ENTITY_WITCH_THROW, host.getSoundCategory(), 1.0F, 0.8F + rand.nextFloat() * 0.4F);
            host.world.addEntity(projectileBomb);
        }
    }
}
