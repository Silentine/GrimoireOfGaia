package gaia.entity.monster;

import com.jcraft.jorbis.Block;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.entity.ai.Ranged;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaBaphomet extends EntityMobHostileBase implements IRangedAttackMob {

    private EntityAIAttackRanged aiArrowAttack = new EntityAIAttackRanged(this, EntityAttributes.attackSpeed2, 20, 60, 15.0F);
    private EntityAIAttackMelee aiAttackOnCollide = new EntityAIAttackMelee(this, EntityAttributes.attackSpeed2, true);

    private int switchHealth;

    public EntityGaiaBaphomet(World worldIn) {
        super(worldIn);

        this.experienceValue = EntityAttributes.experienceValue2;
        this.stepHeight = 1.0F;
        this.isImmuneToFire = true;

        this.switchHealth = 0;
    }

    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        // this.tasks.addTask(1, new RESERVED);
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

    public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
        Ranged.fireball(target, this, distanceFactor);
    }

    public boolean attackEntityAsMob(Entity entityIn) {
        if (super.attackEntityAsMob(entityIn)) {
            if (entityIn instanceof EntityLiving) {
                byte byte0 = 0;

                if (this.world.getDifficulty() == EnumDifficulty.NORMAL) {
                    byte0 = 10;
                } else if (this.world.getDifficulty() == EnumDifficulty.HARD) {
                    byte0 = 20;
                }

                if (byte0 > 0) {
                    ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, byte0 * 20, 0));
                    ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, byte0 * 20, 0));
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public boolean isAIDisabled() {
        return false;
    }

    public void onLivingUpdate() {
        if ((this.getHealth() < EntityAttributes.maxHealth2 * 0.75F) && (this.switchHealth == 0)) {
            this.tasks.removeTask(this.aiArrowAttack);
            this.tasks.addTask(1, this.aiAttackOnCollide);
            this.switchHealth = 1;
        }

        if ((this.getHealth() > EntityAttributes.maxHealth2 * 0.75F) && (this.switchHealth == 1)) {
            this.tasks.removeTask(this.aiAttackOnCollide);
            this.tasks.addTask(1, this.aiArrowAttack);
            this.switchHealth = 0;
        }

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

    protected void playStepSound(BlockPos pos, Block blockIn) {
        this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
    }

    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        if (wasRecentlyHit) {
            int var3 = this.rand.nextInt(3 + lootingModifier);

            if ((this.rand.nextInt(2) == 0 || this.rand.nextInt(1) > 0)) {
                for (int var4 = 0; var4 < var3; ++var4) {
                    this.dropItem(GaiaItems.MiscSoulFiery, 1);
                }
            } else {
                for (int var4 = 0; var4 < var3; ++var4) {
                    this.dropItem(Items.BLAZE_POWDER, 1);
                }
            }

            if ((this.rand.nextInt(4) == 0 || this.rand.nextInt(1 + lootingModifier) > 0)) {
                this.dropItem(GaiaItems.FoodNetherWart, 1);
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
                switch (this.rand.nextInt(2)) {
                    case 0:
                        this.entityDropItem(new ItemStack(GaiaItems.Box, 1, 1), 0.0F);
                        break;
                    case 1:
                        this.dropItem(GaiaItems.BagBook, 1);
                }
            }

            // Very Rare
            if ((this.rand.nextInt(EntityAttributes.rateraredrop) == 0 || this.rand.nextInt(1) > 0)) {
                this.dropItem(GaiaItems.AccessoryTrinketWither, 1);
            }
        }
    }

    @Override
    protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier) {
    }

    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
        livingdata = super.onInitialSpawn(difficulty, livingdata);

        this.tasks.removeTask(this.aiAttackOnCollide);
        this.tasks.addTask(1, this.aiArrowAttack);

        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.PropWeapon, 1, 1));

        return livingdata;
    }

    // ================= Immunities =================//
    public boolean isPotionApplicable(PotionEffect potioneffectIn) {
        return potioneffectIn.getPotion() == MobEffects.WITHER
                ? false
                : super.isPotionApplicable(potioneffectIn);
    }
    // =============================================//
}
