package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.entity.projectile.EntityGaiaProjectileSmallFireball;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityGaiaNineTails extends EntityMobHostileBase implements IRangedAttackMob {

    public EntityGaiaNineTails(World worldIn) {
        super(worldIn);

        this.experienceValue = EntityAttributes.experienceValue2;
        this.stepHeight = 1.0F;
        this.isImmuneToFire = true;
    }

    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackRanged(this, EntityAttributes.attackSpeed2, 20, 60, 15.0F));
        this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(3, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH)
                .setBaseValue((double) EntityAttributes.maxHealth2);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE)
                .setBaseValue(EntityAttributes.followrange);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED)
                .setBaseValue(EntityAttributes.moveSpeed2);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE)
                .setBaseValue((double) EntityAttributes.attackDamage2);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR)
                .setBaseValue(EntityAttributes.rateArmor2);
    }

    public boolean attackEntityFrom(DamageSource source, float damage) {
        if (damage > EntityAttributes.baseDefense2) {
            damage = EntityAttributes.baseDefense2;
        }

        return super.attackEntityFrom(source, damage);
    }

    public void knockBack(Entity entityIn, float strenght, double xRatio, double zRatio) {
        super.knockBack(entityIn, strenght, xRatio, zRatio, EntityAttributes.knockback2);
    }

    public void attackEntityWithRangedAttack(EntityLivingBase living, float par2) {
        // this.world.playAuxSFXAtEntity((EntityPlayer)null, 1009,
        // this.getPosition(), 0);
        this.playSound(SoundEvents.ENTITY_BLAZE_SHOOT, 1.0F, 1.0F / (this.getRNG()
                .nextFloat() * 0.4F + 0.8F));
        double d0 = living.posX - this.posX;
        double d1 = living.getEntityBoundingBox().minY + (double) (living.height / 2.0F) - (this.posY + (double) (this.height / 2.0F));
        double d2 = living.posZ - this.posZ;
        float f1 = MathHelper.sqrt(par2) * 0.5F;

        for (int var10 = 0; var10 < 3; ++var10) {
            EntityGaiaProjectileSmallFireball var11 = new EntityGaiaProjectileSmallFireball(this.world, this,
                    d0 + this.rand.nextGaussian() * (double) f1, d1, d2 + this.rand.nextGaussian() * (double) f1);
            var11.posY = this.posY + (double) (this.height / 2.0F) + 0.5D;
            this.world.spawnEntity(var11);
        }
    }

    public boolean isAIDisabled() {
        return false;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    protected SoundEvent getAmbientSound() {
        return Sounds.aggressive_say;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return Sounds.aggressive_hurt;
    }

    protected SoundEvent getDeathSound() {
        return Sounds.aggressive_death;
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        if (wasRecentlyHit) {
            int var3 = this.rand.nextInt(3 + lootingModifier);

            for (int var4 = 0; var4 < var3; ++var4) {
                this.dropItem(GaiaItems.MiscSoulFire, 1);
            }

            // Nuggets/Fragments
            int var11 = this.rand.nextInt(3) + 1;

            for (int var12 = 0; var12 < var11; ++var12) {
                ItemShard.Drop_Nugget(this, 1);
            }

            if (GaiaConfig.AdditionalOre) {
                int var13 = this.rand.nextInt(3) + 1;

                for (int var14 = 0; var14 < var13; ++var14) {
                    ItemShard.Drop_Nugget(this, 5);
                }
            }

            // Rare
            if ((this.rand.nextInt(EntityAttributes.rateraredrop) == 0 || this.rand.nextInt(1 + lootingModifier) > 0)) {
                switch (this.rand.nextInt(3)) {
                    case 0:
                        this.dropItem(GaiaItems.BoxGold, 1);
                        break;
                    case 1:
                        this.dropItem(GaiaItems.BagBook, 1);
                        break;
                    case 2:
                        ItemStack FanFire = new ItemStack(GaiaItems.FanFire);
                        FanFire.addEnchantment(Enchantment.getEnchantmentByLocation("fire_aspect"), 2);
                        FanFire.addEnchantment(Enchantment.getEnchantmentByLocation("knockback"), 1);
                        this.entityDropItem(FanFire, 1);
                }
            }
        }
    }

    @Override
    protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier) {
    }

    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
        livingdata = super.onInitialSpawn(difficulty, livingdata);

        setLeftHanded(false);

        ItemStack weapon;

        if (rand.nextInt(4) == 0) {
            weapon = new ItemStack(GaiaItems.PropWeapon, 1, 4);
            weapon.addEnchantment(Enchantment.getEnchantmentByLocation("knockback"), 2);
        } else {
            weapon = new ItemStack(GaiaItems.PropWeaponEnchanted, 1);
            weapon.addEnchantment(Enchantment.getEnchantmentByLocation("knockback"), 1);
        }

        setItemStackToSlot(EntityEquipmentSlot.MAINHAND, weapon);

        return livingdata;
    }

    public boolean getCanSpawnHere() {
        return this.posY > 60.0D && super.getCanSpawnHere();
    }
}
